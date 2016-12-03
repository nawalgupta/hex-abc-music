package abc.music.editor.settings;

import abc.music.core.domain.Person;
import abc.music.core.domain.Project;
import abc.music.editor.AbcMusicEditor;
import abc.music.editor.components.AmeDialog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import nu.hex.abc.music.service.properties.AbcMusicProperties;

/**
 *
 * @author hl
 */
public class SettingsDialog extends AmeDialog<Void> {

    private final Map<String, JTextField> fieldMap = new HashMap<>();
    private final AbcMusicProperties properties = AbcMusicProperties.getInstance();
    private final Project project;

    public SettingsDialog(Project project, AbcMusicEditor application) {
        super(application, "Settings for HexRpgManger");
        this.project = project;
        fieldMap.put(AbcMusicProperties.PROJECT_FOLDER, projectFolderTextField);
        fieldMap.put(AbcMusicProperties.BACKUP_FOLDER, backupDirectoryTextField);
        fieldMap.put(AbcMusicProperties.ABC_FOLDER, abcDirectoryTextField);
        setProperties();
        if (project != null) {
            settingsTabbedPane.add("Project Settings", projectPanel);
        }
    }

    @Override
    protected void init() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        projectPanel = new javax.swing.JPanel();
        projectInformationPanel = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        projectNameTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        abcVersionTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        summaryTextField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        projectOwnerPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        firstNameTextField = new javax.swing.JTextField();
        lastNameTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        creatorButton = new javax.swing.JButton();
        emailTextField = new javax.swing.JTextField();
        creatorsPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        creatorsTable = new javax.swing.JTable();
        settingsTabbedPane = new javax.swing.JTabbedPane();
        generalOptionsPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        backupDirectoryTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        abcDirectoryTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        projectFolderTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        autoOpenLatesProjectCheckBox = new javax.swing.JCheckBox();
        keepHistoryCheckBox = new javax.swing.JCheckBox();
        buttonPanel = new javax.swing.JPanel();
        saveAndCloseButton = new javax.swing.JButton();

        projectPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        projectInformationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Project Information"));

        jLabel7.setText("Project Name:");

        jLabel8.setText("ABC-Version:");

        jLabel9.setText("Summary:");

        jLabel10.setFont(new java.awt.Font("Ubuntu", 2, 12)); // NOI18N
        jLabel10.setText("Latest stable: 2.1 Draft: 2.2");

        javax.swing.GroupLayout projectInformationPanelLayout = new javax.swing.GroupLayout(projectInformationPanel);
        projectInformationPanel.setLayout(projectInformationPanelLayout);
        projectInformationPanelLayout.setHorizontalGroup(
            projectInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(projectInformationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(projectInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(projectInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(projectNameTextField)
                    .addComponent(summaryTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addGroup(projectInformationPanelLayout.createSequentialGroup()
                        .addComponent(abcVersionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)))
                .addContainerGap())
        );
        projectInformationPanelLayout.setVerticalGroup(
            projectInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(projectInformationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(projectInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(projectNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(projectInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(abcVersionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(projectInformationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(summaryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        projectOwnerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Project owner Information"));

        jLabel6.setText("Name:");

        jLabel5.setText("Email Address:");

        creatorButton.setText("Creator");
        creatorButton.setToolTipText("Click this if you want to add the user as a creator");
        creatorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creatorButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout projectOwnerPanelLayout = new javax.swing.GroupLayout(projectOwnerPanel);
        projectOwnerPanel.setLayout(projectOwnerPanelLayout);
        projectOwnerPanelLayout.setHorizontalGroup(
            projectOwnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(projectOwnerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(projectOwnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(projectOwnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, projectOwnerPanelLayout.createSequentialGroup()
                        .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(creatorButton))
                    .addGroup(projectOwnerPanelLayout.createSequentialGroup()
                        .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        projectOwnerPanelLayout.setVerticalGroup(
            projectOwnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(projectOwnerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(projectOwnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(projectOwnerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(creatorButton)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        creatorsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Composers, Authors et al"));
        creatorsPanel.setToolTipText("You can add creators here as well as through the menu");

        creatorsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "First Name", "Last Name", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(creatorsTable);

        javax.swing.GroupLayout creatorsPanelLayout = new javax.swing.GroupLayout(creatorsPanel);
        creatorsPanel.setLayout(creatorsPanelLayout);
        creatorsPanelLayout.setHorizontalGroup(
            creatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(creatorsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        creatorsPanelLayout.setVerticalGroup(
            creatorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(creatorsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout projectPanelLayout = new javax.swing.GroupLayout(projectPanel);
        projectPanel.setLayout(projectPanelLayout);
        projectPanelLayout.setHorizontalGroup(
            projectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(projectPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(projectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(creatorsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(projectInformationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(projectOwnerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(156, Short.MAX_VALUE))
        );
        projectPanelLayout.setVerticalGroup(
            projectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(projectPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(projectInformationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(projectOwnerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(creatorsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        generalOptionsPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Files Settings"));

        jLabel1.setText("Backup Directory");

        backupDirectoryTextField.setToolTipText("The directory where backup copies are stored.");

        jLabel2.setText("Abc Directory");

        abcDirectoryTextField.setToolTipText("<html>This is the directory where abc files are to be searched for.<br/>\nSet this to a directory where you have easy access to them.\n");

        jLabel3.setText("Root Directory");

        projectFolderTextField.setToolTipText("<html>Where the source files will be stored. <br/>\nThis should preferably stay unchanged.");

        jLabel4.setText("Set/select the different directories that will be used in the manager.");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(backupDirectoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(projectFolderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(abcDirectoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel4))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(projectFolderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(backupDirectoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(abcDirectoryTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Open Project Settings"));

        autoOpenLatesProjectCheckBox.setText("Automatically open latest project");

        keepHistoryCheckBox.setText("Keep Recently Opened Items for projects");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(autoOpenLatesProjectCheckBox)
                    .addComponent(keepHistoryCheckBox))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(autoOpenLatesProjectCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(keepHistoryCheckBox)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout generalOptionsPanelLayout = new javax.swing.GroupLayout(generalOptionsPanel);
        generalOptionsPanel.setLayout(generalOptionsPanelLayout);
        generalOptionsPanelLayout.setHorizontalGroup(
            generalOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalOptionsPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(generalOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        generalOptionsPanelLayout.setVerticalGroup(
            generalOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalOptionsPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(173, Short.MAX_VALUE))
        );

        settingsTabbedPane.addTab("General", generalOptionsPanel);

        getContentPane().add(settingsTabbedPane, java.awt.BorderLayout.CENTER);

        saveAndCloseButton.setText("Save and Close");
        saveAndCloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAndCloseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonPanelLayout.createSequentialGroup()
                .addContainerGap(533, Short.MAX_VALUE)
                .addComponent(saveAndCloseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, buttonPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saveAndCloseButton)
                .addContainerGap())
        );

        getContentPane().add(buttonPanel, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveAndCloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAndCloseButtonActionPerformed
        ok();
    }//GEN-LAST:event_saveAndCloseButtonActionPerformed

    private void creatorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creatorButtonActionPerformed
        addUserToCreator();
    }//GEN-LAST:event_creatorButtonActionPerformed

    @Override
    protected void accept() {
        updateProperties();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField abcDirectoryTextField;
    private javax.swing.JTextField abcVersionTextField;
    private javax.swing.JCheckBox autoOpenLatesProjectCheckBox;
    private javax.swing.JTextField backupDirectoryTextField;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton creatorButton;
    private javax.swing.JPanel creatorsPanel;
    private javax.swing.JTable creatorsTable;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JPanel generalOptionsPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox keepHistoryCheckBox;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JTextField projectFolderTextField;
    private javax.swing.JPanel projectInformationPanel;
    private javax.swing.JTextField projectNameTextField;
    private javax.swing.JPanel projectOwnerPanel;
    private javax.swing.JPanel projectPanel;
    private javax.swing.JButton saveAndCloseButton;
    private javax.swing.JTabbedPane settingsTabbedPane;
    private javax.swing.JTextField summaryTextField;
    // End of variables declaration//GEN-END:variables

    private void setProperties() {
        properties.getProperties().keySet().stream().filter((key) -> (fieldMap.containsKey(key))).forEach((key) -> {
            fieldMap.get(key).setText(properties.getProperties().get(key));
        });
        autoOpenLatesProjectCheckBox.setSelected(Boolean.valueOf(properties.getProperty("auto-open-project")));
        keepHistoryCheckBox.setSelected(Boolean.valueOf(properties.getProperty("preserve-project-history")));
        if (project != null) {
            if (project.getOwner() != null) {
                firstNameTextField.setText(project.getOwner().getFirstName());
                lastNameTextField.setText(project.getOwner().getLastName());
                emailTextField.setText(project.getOwner().getEmail());
            }
            projectNameTextField.setText(project.getName());
            abcVersionTextField.setText(project.getAbcVersion());
            summaryTextField.setText(project.getSummary());
            refreshCreatorTable();
        }
    }

    private void refreshCreatorTable() {
        creatorsTable.setModel(new CreatorTableModel(project.getPersons()));
    }

    private void updateProperties() {
        properties.getProperties().keySet().stream().filter((key) -> (fieldMap.containsKey(key))).forEach((key) -> {
            properties.setProperty(key, fieldMap.get(key).getText());
        });
        properties.setProperty("auto-open-project", String.valueOf(autoOpenLatesProjectCheckBox.isSelected()));
        properties.setProperty("preserve-project-history", String.valueOf(keepHistoryCheckBox.isSelected()));
        if (project != null) {
            if (project.getOwner() == null) {
                project.setOwner(new Project.Owner());
            }
            project.getOwner().setFirstName(firstNameTextField.getText());
            project.getOwner().setLastName(lastNameTextField.getText());
            project.getOwner().setEmail(emailTextField.getText());
            project.setName(projectNameTextField.getText());
            project.setAbcVersion(abcVersionTextField.getText());
            project.setSummary(summaryTextField.getText());
        }
    }

    private void addUserToCreator() {
        if (project != null) {
            Person person = new Person(project);
            person.setFirstName(firstNameTextField.getText());
            person.setLastName(lastNameTextField.getText());
            person.setEmail(emailTextField.getText());
            project.addPerson(person);
            refreshCreatorTable();
        }
    }

    class CreatorTableModel extends AbstractTableModel {

        private final String[] columnNames = {"First Name", "Last Name", "Email"};
        private final List<Person> person;
        private Object[][] data;

        public CreatorTableModel(List<Person> person) {
            this.person = person;
            setValues();
        }

        private void setValues() {
            data = new Object[person.size() + 1][];
            int i = 0;
            for (Person p : person) {
                data[i++] = new Object[]{p.getFirstName(), p.getLastName(), p.getEmail()};
            }
            data[i] = new Object[]{"", "", ""};
        }

        @Override
        public int getRowCount() {
            return data.length;
        }

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        @Override
        public boolean isCellEditable(int row, int col) {
            return true;
        }

        @Override
        public void setValueAt(Object value, int row, int col) {
            data[row][col] = value;
            fireTableCellUpdated(row, col);
        }
    }
}