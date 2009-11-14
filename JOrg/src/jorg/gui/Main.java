package jorg.gui;

import javax.swing.JCheckBox;
import jorg.gui.config.Configurator;
import jorg.gui.container.NewContainer;
import jorg.gui.container.SearchContainer;
import jorg.gui.file.FileIndexing;
import jorg.gui.unit.NewUnit;
import jorg.gui.unit.SearchUnit;

public class Main extends javax.swing.JFrame {

    public Main() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLblLeftPic = new javax.swing.JLabel();
        jLblTitulo = new javax.swing.JLabel();
        jLblDescricao = new javax.swing.JLabel();
        jLblMidlePic = new javax.swing.JLabel();
        jLblRigthPic = new javax.swing.JLabel();
        jMnuBar = new javax.swing.JMenuBar();
        jMnuFile = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JSeparator();
        jMnuExit = new javax.swing.JMenuItem();
        jMnuContainer = new javax.swing.JMenu();
        jMnuContainerQuery = new javax.swing.JMenuItem();
        jMnuUnit = new javax.swing.JMenu();
        jMnuManagmentUnit = new javax.swing.JMenuItem();
        jMnuIndexable = new javax.swing.JMenu();
        jMnuIndexFiles = new javax.swing.JMenuItem();
        jMnuSearchFiles = new javax.swing.JMenuItem();
        jMnuAbout = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLblLeftPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/filetypes.png"))); // NOI18N

        jLblTitulo.setFont(new java.awt.Font("Tahoma", 0, 48));
        jLblTitulo.setForeground(new java.awt.Color(0, 0, 153));
        jLblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblTitulo.setText("j");
        jLblTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLblDescricao.setFont(new java.awt.Font("Tahoma", 0, 12));
        jLblDescricao.setForeground(new java.awt.Color(0, 0, 153));
        jLblDescricao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblDescricao.setText("j");
        jLblDescricao.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLblMidlePic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/filetypes.png"))); // NOI18N

        jLblRigthPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/filetypes.png"))); // NOI18N

        jMnuFile.setForeground(new java.awt.Color(153, 0, 51));
        jMnuFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/t1.png"))); // NOI18N
        jMnuFile.setText("File");
        jMnuFile.setFont(new java.awt.Font("Segoe UI", 0, 32));
        jMnuFile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMnuFile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMnuFile.add(jSeparator1);

        jMnuExit.setFont(new java.awt.Font("Segoe UI", 0, 32));
        jMnuExit.setForeground(new java.awt.Color(153, 0, 51));
        jMnuExit.setText("Exit");
        jMnuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuExitActionPerformed(evt);
            }
        });
        jMnuFile.add(jMnuExit);

        jMnuBar.add(jMnuFile);

        jMnuContainer.setForeground(new java.awt.Color(153, 0, 51));
        jMnuContainer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/t.png"))); // NOI18N
        jMnuContainer.setText("Container");
        jMnuContainer.setFont(new java.awt.Font("Segoe UI", 0, 32));
        jMnuContainer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMnuContainer.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jMnuContainerQuery.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMnuContainerQuery.setFont(new java.awt.Font("Segoe UI", 0, 32));
        jMnuContainerQuery.setForeground(new java.awt.Color(153, 0, 51));
        jMnuContainerQuery.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/Zoom24.gif"))); // NOI18N
        jMnuContainerQuery.setText("Managment");
        jMnuContainerQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuContainerQueryActionPerformed(evt);
            }
        });
        jMnuContainer.add(jMnuContainerQuery);

        jMnuBar.add(jMnuContainer);

        jMnuUnit.setForeground(new java.awt.Color(153, 0, 51));
        jMnuUnit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/t3.png"))); // NOI18N
        jMnuUnit.setText("Unit");
        jMnuUnit.setFont(new java.awt.Font("Segoe UI", 0, 32));
        jMnuUnit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMnuUnit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jMnuManagmentUnit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMnuManagmentUnit.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
        jMnuManagmentUnit.setForeground(new java.awt.Color(153, 0, 51));
        jMnuManagmentUnit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/Zoom24.gif"))); // NOI18N
        jMnuManagmentUnit.setText("Managment");
        jMnuManagmentUnit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuManagmentUnitActionPerformed(evt);
            }
        });
        jMnuUnit.add(jMnuManagmentUnit);

        jMnuBar.add(jMnuUnit);

        jMnuIndexable.setForeground(new java.awt.Color(153, 0, 51));
        jMnuIndexable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/t5.png"))); // NOI18N
        jMnuIndexable.setText("Indexable");
        jMnuIndexable.setFont(new java.awt.Font("Segoe UI", 0, 32));
        jMnuIndexable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMnuIndexable.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jMnuIndexFiles.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
        jMnuIndexFiles.setForeground(new java.awt.Color(153, 0, 51));
        jMnuIndexFiles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/ComposeMail24.gif"))); // NOI18N
        jMnuIndexFiles.setText("Index Files");
        jMnuIndexFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuIndexFilesActionPerformed(evt);
            }
        });
        jMnuIndexable.add(jMnuIndexFiles);

        jMnuSearchFiles.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMnuSearchFiles.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
        jMnuSearchFiles.setForeground(new java.awt.Color(153, 0, 51));
        jMnuSearchFiles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/Find24.gif"))); // NOI18N
        jMnuSearchFiles.setText("Search Files");
        jMnuIndexable.add(jMnuSearchFiles);

        jMnuBar.add(jMnuIndexable);

        jMnuAbout.setForeground(new java.awt.Color(153, 0, 51));
        jMnuAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/t2.png"))); // NOI18N
        jMnuAbout.setText("About");
        jMnuAbout.setFont(new java.awt.Font("Segoe UI", 0, 32));
        jMnuAbout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMnuAbout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jMenuItem4.setText("jMenuItem1");
        jMnuAbout.add(jMenuItem4);

        jMnuBar.add(jMnuAbout);

        setJMenuBar(jMnuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 1275, Short.MAX_VALUE)
            .addComponent(jLblDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 1275, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLblLeftPic)
                .addGap(60, 60, 60)
                .addComponent(jLblMidlePic)
                .addGap(74, 74, 74)
                .addComponent(jLblRigthPic)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLblDescricao)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLblLeftPic)
                    .addComponent(jLblRigthPic)
                    .addComponent(jLblMidlePic))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private SearchContainer container = new SearchContainer();
    private SearchUnit unit = new SearchUnit();
    private FileIndexing fileIndexing = new FileIndexing();

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    }//GEN-LAST:event_formWindowOpened

    private void jMnuContainerQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuContainerQueryActionPerformed
        SwingUtil.center(container);
        container.getjTxtTerm().setText("");
        SwingUtil.setDefaultButton(container, container.getjBtnSearch());
        container.setVisible(true);
    }//GEN-LAST:event_jMnuContainerQueryActionPerformed

    private void jMnuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuExitActionPerformed
        dispose();
        System.exit(0);
    }//GEN-LAST:event_jMnuExitActionPerformed

    private void jMnuManagmentUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuManagmentUnitActionPerformed
        SwingUtil.center(unit);
        unit.getjTxtTerm().setText("");
        SwingUtil.setDefaultButton(unit, unit.getjBtnSearch());
        SwingUtil.setDefaultButton(unit.getNewUnit(), unit.getNewUnit().getjBtnSearch());
        unit.setVisible(true);
    }//GEN-LAST:event_jMnuManagmentUnitActionPerformed

    private void jMnuIndexFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuIndexFilesActionPerformed
        SwingUtil.center(fileIndexing);
        fileIndexing.getjTxtTerm().setText("");
        SwingUtil.setDefaultButton(fileIndexing, fileIndexing.getjBtnSearch());
        fileIndexing.setVisible(true);
    }//GEN-LAST:event_jMnuIndexFilesActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLblDescricao;
    private javax.swing.JLabel jLblLeftPic;
    private javax.swing.JLabel jLblMidlePic;
    private javax.swing.JLabel jLblRigthPic;
    private javax.swing.JLabel jLblTitulo;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenu jMnuAbout;
    private javax.swing.JMenuBar jMnuBar;
    private javax.swing.JMenu jMnuContainer;
    private javax.swing.JMenuItem jMnuContainerQuery;
    private javax.swing.JMenuItem jMnuExit;
    private javax.swing.JMenu jMnuFile;
    private javax.swing.JMenuItem jMnuIndexFiles;
    private javax.swing.JMenu jMnuIndexable;
    private javax.swing.JMenuItem jMnuManagmentUnit;
    private javax.swing.JMenuItem jMnuSearchFiles;
    private javax.swing.JMenu jMnuUnit;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    private final void setupMenu() {
        setInternationalizedText("mnu.file", jMnuFile);
        setInternationalizedText("mnu.container", jMnuContainer);
        setInternationalizedText("mnu.container.search", jMnuContainerQuery);
        setInternationalizedText("mnu.management.unit", jMnuManagmentUnit);
        setInternationalizedText("mnu.unit", jMnuUnit);
        setInternationalizedText("mnu.index", jMnuIndexable);
        setInternationalizedText("mnu.about", jMnuAbout);
        setInternationalizedText("exit", jMnuExit);
    }

    private final String getInternationalizedText(final String key) {
        return Configurator.getInternationlizedText(key);
    }

    private void configContainerWindows() {
        container.setTitle(getInternationalizedText("container.title"));
        setInternationalizedText("container.info", container.getjLblContainerInfo());
        setInternationalizedText("container.searchlabel", container.getjLblSearchText());
        setInternationalizedText("container.searchbutton", container.getjBtnSearch());
        setInternationalizedText("container.tip", container.getjLblContainerTip());
        setInternationalizedText("container.new", container.getjBtnContainerNew());
        setInternationalizedText("container.edit", container.getjBtnContainerEdit());
        setInternationalizedText("container.delete", container.getjBtnContainerDelete());
        setInternationalizedText("container.back", container.getjBtnContainerBack());
        configureContainerNew(container.getNewContainer());
    }

    public final void internationalize() {
        setupMain();
        setupMenu();
        configContainerWindows();
        configUnitWindows();
    }

    private final void setupMain() {
        setTitle(getInternationalizedText("main.title"));
        jLblTitulo.setText("<html>" + getInternationalizedText("main.label.title") +
                " " + getInternationalizedText("main.version") + "</html>");
        jLblDescricao.setText("<html>" + getInternationalizedText("main.label.description") + "</html>");
    }

    private final void setInternationalizedText(final String text, final javax.swing.JButton jbtn) {
        jbtn.setText(getInternationalizedText(text));
    }

    private final void setInternationalizedText(final String text, final javax.swing.JLabel jlbl) {
        jlbl.setText(getInternationalizedText(text));
    }

    private final void setInternationalizedText(final String text, final javax.swing.JMenu jmnu) {
        jmnu.setText(getInternationalizedText(text));
    }

    private final void setInternationalizedText(final String text, final javax.swing.JMenuItem jmnu) {
        jmnu.setText(getInternationalizedText(text));
    }

    private final void setInternationalizedText(final String text, final JCheckBox jchk) {
        jchk.setText(getInternationalizedText(text));
    }

    private void configureContainerNew(NewContainer newContainer) {
        setInternationalizedText("container.new.info", newContainer.getjLblContainerNewInfo());
        setInternationalizedText("container.new.labelcontainer", newContainer.getjLblContainerParent());
        setInternationalizedText("container.table.description", newContainer.getjLblDescription());
        setInternationalizedText("save", newContainer.getjBtnSave());
        setInternationalizedText("container.searchlabel", newContainer.getjLblSearchText());
        setInternationalizedText("container.searchbutton", newContainer.getjBtnSearch());
        setInternationalizedText("select", newContainer.getjBtnSelect());
        setInternationalizedText("back", newContainer.getjBtnBack());
        setInternationalizedText("container.new.isroot", newContainer.getjCheckIsRoot());
        newContainer.getjTabPanel().setTitleAt(0, getInternationalizedText("container.new.tabnew"));
        newContainer.getjTabPanel().setTitleAt(1, getInternationalizedText("container.new.tabchoose"));
    }

    private final void configUnitWindows() {
        setInternationalizedText("window.unit.info", unit.getjLblUnitInfo());
        setInternationalizedText("window.unit.search.label", unit.getjLblSearchText());
        setInternationalizedText("search", unit.getjBtnSearch());
        setInternationalizedText("container.tip",unit.getjLblContainerTip());
        setInternationalizedText("new",unit.getjBtnNew());
        setInternationalizedText("edit",unit.getjBtnEdit());
        setInternationalizedText("delete",unit.getjBtnDelete());
        setInternationalizedText("back",unit.getjBtnBack());
        NewUnit nUnit = unit.getNewUnit();
        setInternationalizedText("back", nUnit.getjBtnBack());
        setInternationalizedText("save", nUnit.getjBtnSave());
        setInternationalizedText("search", nUnit.getjBtnSearch());
        setInternationalizedText("select", nUnit.getjBtnSelect());
        setInternationalizedText("window.unit.chkcontainer", nUnit.getjChk());
        setInternationalizedText("mnu.container", nUnit.getjLblContainerParent());
        setInternationalizedText("window.unit.info", nUnit.getjLblInfo());
        setInternationalizedText("name", nUnit.getjLblName());
        setInternationalizedText("window.unit.search.label", nUnit.getjLblSearchText());
        setInternationalizedText("type", nUnit.getjLblType());
    }
}
