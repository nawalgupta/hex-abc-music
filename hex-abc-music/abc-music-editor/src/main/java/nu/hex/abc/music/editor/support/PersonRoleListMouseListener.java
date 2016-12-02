package nu.hex.abc.music.editor.support;

import abc.music.core.domain.Person;
import abc.music.core.domain.PersonRole;
import abc.music.core.domain.Tune;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import nu.hex.abc.music.editor.AbcMusicEditor;
import nu.hex.abc.music.editor.action.AddPersonRoleAction;
import nu.hex.abc.music.editor.action.RemovePersonRoleAction;
import nu.hex.abc.music.editor.components.TuneHeadersPanel;

/**
 * Created 2016-dec-01
 *
 * @author hl
 */
public class PersonRoleListMouseListener implements MouseListener {

    private final TuneHeadersPanel parent;
    private final JList list;
    private final JPopupMenu menu;
    private final Person.Role role;
    private int selectedIndex;

    public PersonRoleListMouseListener(TuneHeadersPanel parent, JList list, Person.Role role, Tune tune) {
        this.parent = parent;
        this.list = list;
        this.role = role;
        this.menu = new JPopupMenu();

        JMenuItem add = new JMenuItem("Select Person and Role(s) to add");
        add.addActionListener((ActionEvent e) -> {
            AddPersonRoleAction action = new AddPersonRoleAction(parent.getApplication(), role);
                    action.actionPerformed(e);
                    action.get().forEach((pr) -> {
                        tune.addCreator(pr);
                    });
                    parent.updateLists();
        });

        JMenuItem remove = new JMenuItem("Remove " + role.toString());
        remove.addActionListener((ActionEvent e) -> {
            new RemovePersonRoleAction(parent.getApplication(), (PersonRole) list.getModel().getElementAt(selectedIndex)).actionPerformed(e);
            list.requestFocus();
        });
        menu.add(add);
        menu.add(remove);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        list.setSelectedIndex(list.locationToIndex(e.getPoint()));
        selectedIndex = list.locationToIndex(e.getPoint());
        menu.show(e.getComponent(), e.getX(), e.getY());
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
