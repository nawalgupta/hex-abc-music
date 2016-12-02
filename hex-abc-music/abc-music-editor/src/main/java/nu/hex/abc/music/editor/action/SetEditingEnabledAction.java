package nu.hex.abc.music.editor.action;

import java.awt.event.ActionEvent;
import nu.hex.abc.music.editor.AbcMusicEditor;

/**
 * Created 2016-dec-02
 *
 * @author hl
 */
public class SetEditingEnabledAction extends AmeAction<Void> {

    private final boolean enabled;

    public SetEditingEnabledAction(AbcMusicEditor parent, boolean enabled) {
        super(parent);
        this.enabled = enabled;
    }

    @Override
    protected void performAction(ActionEvent event) {
        parent.getTuneEditor().setEditingEnabled(enabled);
    }

}
