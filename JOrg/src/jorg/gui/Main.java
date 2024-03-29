package jorg.gui;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import jorg.gui.config.Configurator;
import jorg.gui.config.ConfiguratorWindow;
import jorg.gui.container.NewContainer;
import jorg.gui.container.SearchContainer;
import jorg.gui.file.FileIndexing;
import jorg.gui.file.FileSearching;
import jorg.gui.statistics.Statistics;
import jorg.gui.unit.NewUnit;
import jorg.gui.unit.SearchUnit;
import jorg.indexing.LuceneSearcher;
import jorgcore.database.DataBase;

public class Main extends javax.swing.JFrame {

    public Main() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLblTitulo = new javax.swing.JLabel();
        jLblDescricao = new javax.swing.JLabel();
        jMnuBar = new javax.swing.JMenuBar();
        jMnuFile = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JSeparator();
        jMnuPreferences = new javax.swing.JMenuItem();
        jMnuExit = new javax.swing.JMenuItem();
        jMnuContainer = new javax.swing.JMenu();
        jMnuContainerQuery = new javax.swing.JMenuItem();
        jMnuUnit = new javax.swing.JMenu();
        jMnuManagmentUnit = new javax.swing.JMenuItem();
        jMnuIndexable = new javax.swing.JMenu();
        jMnuIndexFiles = new javax.swing.JMenuItem();
        jMnuSearchFiles = new javax.swing.JMenuItem();
        jMnuAbout = new javax.swing.JMenu();
        jMnuStatistics = new javax.swing.JMenuItem();
        jMnuAboutSub = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened1(evt);
            }
        });

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

        jMnuFile.setForeground(new java.awt.Color(153, 0, 51));
        jMnuFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/t1.png"))); // NOI18N
        jMnuFile.setText("File");
        jMnuFile.setFont(new java.awt.Font("Segoe UI", 0, 32));
        jMnuFile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMnuFile.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jMnuFile.add(jSeparator1);

        jMnuPreferences.setFont(new java.awt.Font("Segoe UI", 0, 32));
        jMnuPreferences.setForeground(new java.awt.Color(153, 0, 51));
        jMnuPreferences.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/ComposeMail24.gif"))); // NOI18N
        jMnuPreferences.setText("Preferences");
        jMnuPreferences.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuPreferencesActionPerformed(evt);
            }
        });
        jMnuFile.add(jMnuPreferences);

        jMnuExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMnuExit.setFont(new java.awt.Font("Segoe UI", 0, 32));
        jMnuExit.setForeground(new java.awt.Color(153, 0, 51));
        jMnuExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/Rewind24.gif"))); // NOI18N
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
        jMnuManagmentUnit.setFont(new java.awt.Font("Segoe UI", 0, 32));
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

        jMnuIndexFiles.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMnuIndexFiles.setFont(new java.awt.Font("Segoe UI", 0, 32));
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
        jMnuSearchFiles.setFont(new java.awt.Font("Segoe UI", 0, 32));
        jMnuSearchFiles.setForeground(new java.awt.Color(153, 0, 51));
        jMnuSearchFiles.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/Zoom24.gif"))); // NOI18N
        jMnuSearchFiles.setText("Search Files");
        jMnuSearchFiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuSearchFilesActionPerformed(evt);
            }
        });
        jMnuIndexable.add(jMnuSearchFiles);

        jMnuBar.add(jMnuIndexable);

        jMnuAbout.setForeground(new java.awt.Color(153, 0, 51));
        jMnuAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/t2.png"))); // NOI18N
        jMnuAbout.setText("About");
        jMnuAbout.setFont(new java.awt.Font("Segoe UI", 0, 32));
        jMnuAbout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMnuAbout.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jMnuStatistics.setFont(new java.awt.Font("Segoe UI", 0, 32));
        jMnuStatistics.setForeground(new java.awt.Color(153, 0, 51));
        jMnuStatistics.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/Host24.gif"))); // NOI18N
        jMnuStatistics.setText("Statistics");
        jMnuStatistics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuStatisticsActionPerformed(evt);
            }
        });
        jMnuAbout.add(jMnuStatistics);

        jMnuAboutSub.setFont(new java.awt.Font("Segoe UI", 0, 32));
        jMnuAboutSub.setForeground(new java.awt.Color(153, 0, 51));
        jMnuAboutSub.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/Information24.gif"))); // NOI18N
        jMnuAboutSub.setText("About");
        jMnuAboutSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMnuAboutSubActionPerformed(evt);
            }
        });
        jMnuAbout.add(jMnuAboutSub);

        jMnuBar.add(jMnuAbout);

        setJMenuBar(jMnuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
            .addComponent(jLblDescricao, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLblDescricao)
                .addContainerGap(272, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private final SearchContainer container = new SearchContainer();
    private final SearchUnit unit = new SearchUnit();
    private final FileIndexing fileIndexing = new FileIndexing(this);
    private final FileSearching fileSearching = new FileSearching(this);
    private final Statistics statisticsWindow = new Statistics();
    private final ConfiguratorWindow configurationWindow = new ConfiguratorWindow(this);

    private void formWindowOpened1(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened1
    }//GEN-LAST:event_formWindowOpened1

    private void jMnuContainerQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuContainerQueryActionPerformed
        SwingUtil.center(getContainer());
        getContainer().getjTxtTerm().setText("");
        SwingUtil.setDefaultButton(getContainer(), getContainer().getjBtnSearch());
        getContainer().setVisible(true);
    }//GEN-LAST:event_jMnuContainerQueryActionPerformed

    private void jMnuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuExitActionPerformed
        closing(null);
        dispose();
        System.exit(0);
    }//GEN-LAST:event_jMnuExitActionPerformed

    private void jMnuManagmentUnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuManagmentUnitActionPerformed
        SwingUtil.center(getUnit());
        getUnit().getjTxtTerm().setText("");
        SwingUtil.setDefaultButton(getUnit(), getUnit().getjBtnSearch());
        SwingUtil.setDefaultButton(getUnit().getNewUnit(), getUnit().getNewUnit().getjBtnSearch());
        getUnit().setVisible(true);
    }//GEN-LAST:event_jMnuManagmentUnitActionPerformed

    private void jMnuIndexFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuIndexFilesActionPerformed
        SwingUtil.center(getFileIndexing());
        getFileIndexing().getjTxtTerm().setText("");
        SwingUtil.setDefaultButton(getFileIndexing(), getFileIndexing().getjBtnSearch());
        getFileIndexing().setVisible(true);
    }//GEN-LAST:event_jMnuIndexFilesActionPerformed

    private void jMnuAboutSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuAboutSubActionPerformed
        JOptionPane.showMessageDialog(this, "JOrg\n" +
                "version: " + Configurator.getInternationlizedText("main.version") 
                + "\n" + "devblog: " + Configurator.getInternationlizedText("main.developer.blog")
                + "\n" + "srcsite: " + Configurator.getSetupProprerty("source.code.site")
                + "\n------------------------------------------------------", "JOrg - "
                + Configurator.getInternationlizedText("main.version"),
                JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jMnuAboutSubActionPerformed

    private void closing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closing
        try {
            DataBase.getConnection().close();
            LuceneSearcher.closeReader();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_closing

    private void jMnuSearchFilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuSearchFilesActionPerformed
        SwingUtil.center(getFileSearching());
        SwingUtil.setDefaultButton(getFileSearching(), getFileSearching().getjBtnSearch());
        getFileSearching().setVisible(true);
    }//GEN-LAST:event_jMnuSearchFilesActionPerformed

    private void jMnuStatisticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuStatisticsActionPerformed
        SwingUtil.center(getStatisticsWindow());
        getStatisticsWindow().setVisible(true);
    }//GEN-LAST:event_jMnuStatisticsActionPerformed

    private void jMnuPreferencesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMnuPreferencesActionPerformed
        SwingUtil.center(getConfigurationWindow());
        getConfigurationWindow().setVisible(true);
    }//GEN-LAST:event_jMnuPreferencesActionPerformed

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
    private javax.swing.JLabel jLblTitulo;
    private javax.swing.JMenu jMnuAbout;
    private javax.swing.JMenuItem jMnuAboutSub;
    private javax.swing.JMenuBar jMnuBar;
    private javax.swing.JMenu jMnuContainer;
    private javax.swing.JMenuItem jMnuContainerQuery;
    private javax.swing.JMenuItem jMnuExit;
    private javax.swing.JMenu jMnuFile;
    private javax.swing.JMenuItem jMnuIndexFiles;
    private javax.swing.JMenu jMnuIndexable;
    private javax.swing.JMenuItem jMnuManagmentUnit;
    private javax.swing.JMenuItem jMnuPreferences;
    private javax.swing.JMenuItem jMnuSearchFiles;
    private javax.swing.JMenuItem jMnuStatistics;
    private javax.swing.JMenu jMnuUnit;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    private final void setupMenu() {
        setInternationalizedText("mnu.file", getjMnuFile());
        setInternationalizedText("mnu.file.preferences", getjMnuPreferences());
        setInternationalizedText("exit", getjMnuExit());
        setInternationalizedText("mnu.container", getjMnuContainer());
        setInternationalizedText("mnu.container.search", getjMnuContainerQuery());
        setInternationalizedText("mnu.management.unit", getjMnuManagmentUnit());
        setInternationalizedText("mnu.unit", getjMnuUnit());
        setInternationalizedText("mnu.index", getjMnuIndexable());
        setInternationalizedText("mnu.index.file", getjMnuIndexFiles());
        setInternationalizedText("mnu.index.search", getjMnuSearchFiles());
        setInternationalizedText("mnu.about", getjMnuAbout());
        setInternationalizedText("mnu.about", getjMnuAboutSub());
        setInternationalizedText("mnu.about.statistics", getjMnuStatistics());

    }

    private final String getInternationalizedText(final String key) {
        return Configurator.getInternationlizedText(key);
    }

    private void configContainerWindows() {
        getContainer().setTitle(getInternationalizedText("container.title"));
        setInternationalizedText("container.info", getContainer().getjLblContainerInfo());
        setInternationalizedText("container.searchlabel", getContainer().getjLblSearchText());
        setInternationalizedText("container.searchbutton", getContainer().getjBtnSearch());
        setInternationalizedText("container.tip", getContainer().getjLblContainerTip());
        setInternationalizedText("container.new", getContainer().getjBtnContainerNew());
        setInternationalizedText("container.edit", getContainer().getjBtnContainerEdit());
        setInternationalizedText("container.delete", getContainer().getjBtnContainerDelete());
        setInternationalizedText("container.back", getContainer().getjBtnContainerBack());
        configureContainerNew(getContainer().getNewContainer());
    }

    public final void internationalize() {
        setupMain();
        setupMenu();
        configConfigWindows();
        configContainerWindows();
        configUnitWindows();
        configFileIndexWindow();
        configSearchFileWindow();
        configStatisticsWindow();
    }

    private void configStatisticsWindow() {
        getStatisticsWindow().setTitle(getInternationalizedText("statistics.title"));
        setInternationalizedText("statistics.title", getStatisticsWindow().getjLblInfo());
        getStatisticsWindow().getjTabPanel().setTitleAt(0, getInternationalizedText("statistics.tab.general.title"));
        getStatisticsWindow().getjTabPanel().setTitleAt(1, getInternationalizedText("statistics.tab.grouping.title"));
        getStatisticsWindow().getjTabPanel().setTitleAt(2, getInternationalizedText("statistics.tab.top10.title"));
    }

    private void configSearchFileWindow() {
        getFileSearching().setTitle(getInternationalizedText("file.window.info"));
        setInternationalizedText("search", getFileSearching().getjBtnSearch());
        setInternationalizedText("file.window.info", getFileSearching().getjLblInfo());
        setInternationalizedText("file.searching.for", getFileSearching().getjLblSearchingFor());
        setInternationalizedText("file.wext", getFileSearching().getjLblWithExtension());
        setInternationalizedText("file.wmis", getFileSearching().getjLblWithMinSize());
        setInternationalizedText("file.wmas", getFileSearching().getjLblWithMaxSize());
    }

    private void configConfigWindows() {
        getConfigurationWindow().setTitle(getInternationalizedText("config.title"));
        setInternationalizedText("back", getConfigurationWindow().getJbtBack());
        setInternationalizedText("save", getConfigurationWindow().getJbtSave());
        setInternationalizedText("config.title", getConfigurationWindow().getjLblInfo());
        getConfigurationWindow().getjTabPanel().setTitleAt(0, getInternationalizedText("config.general"));
        getConfigurationWindow().getjTabPanel().setTitleAt(1, getInternationalizedText("config.grouping"));
        setInternationalizedText("config.lang", getConfigurationWindow().getJlblLanguage());
        setInternationalizedText("config.laf", getConfigurationWindow().getJlblLookAndFeel());
        setInternationalizedText("config.fni", getConfigurationWindow().getJlblFilesNotIndexable());
        setInternationalizedText("config.wni", getConfigurationWindow().getjLblWordsNotIndexable());
        setInternationalizedText("config.number.of.results", getConfigurationWindow().getjLblNumberOfResults());
        setInternationalizedText("config.personal", getConfigurationWindow().getjLblPersonal());
        setInternationalizedText("config.video", getConfigurationWindow().getjLblVideo());
        setInternationalizedText("config.audio", getConfigurationWindow().getjLblAudio());
        setInternationalizedText("config.picture", getConfigurationWindow().getjLblPicture());
        setInternationalizedText("config.html", getConfigurationWindow().getjLblHtml());
        setInternationalizedText("config.docs", getConfigurationWindow().getjLblOfficeDocs());
        setInternationalizedText("config.disk.image", getConfigurationWindow().getjLblDiskImages());
        setInternationalizedText("config.compression", getConfigurationWindow().getjLblCompression());
    }

    private final void setupMain() {
        setTitle(getInternationalizedText("main.title"));
        getjLblTitulo().setText("<html>" + getInternationalizedText("main.label.title") +
                " " + getInternationalizedText("main.version") + "</html>");
        getjLblDescricao().setText("<html>" + getInternationalizedText("main.label.description") + "</html>");
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
        setInternationalizedText("window.unit.info", getUnit().getjLblUnitInfo());
        setInternationalizedText("window.unit.search.label", getUnit().getjLblSearchText());
        setInternationalizedText("search", getUnit().getjBtnSearch());
        setInternationalizedText("container.tip", getUnit().getjLblContainerTip());
        setInternationalizedText("new", getUnit().getjBtnNew());
        setInternationalizedText("edit", getUnit().getjBtnEdit());
        setInternationalizedText("delete", getUnit().getjBtnDelete());
        setInternationalizedText("rent", getUnit().getjBtnRent());
        setInternationalizedText("giveback", getUnit().getjBtnGiveBack());
        setInternationalizedText("back", getUnit().getjBtnBack());
        NewUnit nUnit = getUnit().getNewUnit();
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

    private void configFileIndexWindow() {
        setInternationalizedText("window.file.info", getFileIndexing().getjLblInfo());
        getFileIndexing().getjTabPanel().setTitleAt(0, getInternationalizedText("window.file.info"));
        getFileIndexing().getjTabPanel().setTitleAt(1, getInternationalizedText("search"));
        setInternationalizedText("window.unit.search.label", getFileIndexing().getjLblSearchText());
        setInternationalizedText("window.file.isitfrom", getFileIndexing().getjChk());
        setInternationalizedText("mnu.unit", getFileIndexing().getjLblContainerParent());
        setInternationalizedText("window.file.choselocation", getFileIndexing().getjLblName());
        setInternationalizedText("index", getFileIndexing().getjBtnIndex());
        setInternationalizedText("search", getFileIndexing().getjBtnSearch());
        setInternationalizedText("back", getFileIndexing().getjBtnBack());
        setInternationalizedText("cancel", getFileIndexing().getjBtnStop());
        setInternationalizedText("name.unit.indexing", getFileIndexing().getjChkNameUnit());
    }

    /**
     * @return the container
     */
    public SearchContainer getContainer() {
        return container;
    }

    /**
     * @return the unit
     */
    public SearchUnit getUnit() {
        return unit;
    }

    /**
     * @return the fileIndexing
     */
    public FileIndexing getFileIndexing() {
        return fileIndexing;
    }

    /**
     * @return the jLblDescricao
     */
    public javax.swing.JLabel getjLblDescricao() {
        return jLblDescricao;
    }

    /**
     * @param jLblDescricao the jLblDescricao to set
     */
    public void setjLblDescricao(javax.swing.JLabel jLblDescricao) {
        this.jLblDescricao = jLblDescricao;
    }

    /**
     * @return the jLblTitulo
     */
    public javax.swing.JLabel getjLblTitulo() {
        return jLblTitulo;
    }

    /**
     * @param jLblTitulo the jLblTitulo to set
     */
    public void setjLblTitulo(javax.swing.JLabel jLblTitulo) {
        this.jLblTitulo = jLblTitulo;
    }

    /**
     * @return the jMnuAbout
     */
    public javax.swing.JMenu getjMnuAbout() {
        return jMnuAbout;
    }

    /**
     * @param jMnuAbout the jMnuAbout to set
     */
    public void setjMnuAbout(javax.swing.JMenu jMnuAbout) {
        this.jMnuAbout = jMnuAbout;
    }

    /**
     * @return the jMnuAboutSub
     */
    public javax.swing.JMenuItem getjMnuAboutSub() {
        return jMnuAboutSub;
    }

    /**
     * @param jMnuAboutSub the jMnuAboutSub to set
     */
    public void setjMnuAboutSub(javax.swing.JMenuItem jMnuAboutSub) {
        this.jMnuAboutSub = jMnuAboutSub;
    }

    /**
     * @return the jMnuBar
     */
    public javax.swing.JMenuBar getjMnuBar() {
        return jMnuBar;
    }

    /**
     * @param jMnuBar the jMnuBar to set
     */
    public void setjMnuBar(javax.swing.JMenuBar jMnuBar) {
        this.jMnuBar = jMnuBar;
    }

    /**
     * @return the jMnuContainer
     */
    public javax.swing.JMenu getjMnuContainer() {
        return jMnuContainer;
    }

    /**
     * @param jMnuContainer the jMnuContainer to set
     */
    public void setjMnuContainer(javax.swing.JMenu jMnuContainer) {
        this.jMnuContainer = jMnuContainer;
    }

    /**
     * @return the jMnuContainerQuery
     */
    public javax.swing.JMenuItem getjMnuContainerQuery() {
        return jMnuContainerQuery;
    }

    /**
     * @param jMnuContainerQuery the jMnuContainerQuery to set
     */
    public void setjMnuContainerQuery(javax.swing.JMenuItem jMnuContainerQuery) {
        this.jMnuContainerQuery = jMnuContainerQuery;
    }

    /**
     * @return the jMnuExit
     */
    public javax.swing.JMenuItem getjMnuExit() {
        return jMnuExit;
    }

    /**
     * @param jMnuExit the jMnuExit to set
     */
    public void setjMnuExit(javax.swing.JMenuItem jMnuExit) {
        this.jMnuExit = jMnuExit;
    }

    /**
     * @return the jMnuFile
     */
    public javax.swing.JMenu getjMnuFile() {
        return jMnuFile;
    }

    /**
     * @param jMnuFile the jMnuFile to set
     */
    public void setjMnuFile(javax.swing.JMenu jMnuFile) {
        this.jMnuFile = jMnuFile;
    }

    /**
     * @return the jMnuIndexFiles
     */
    public javax.swing.JMenuItem getjMnuIndexFiles() {
        return jMnuIndexFiles;
    }

    /**
     * @param jMnuIndexFiles the jMnuIndexFiles to set
     */
    public void setjMnuIndexFiles(javax.swing.JMenuItem jMnuIndexFiles) {
        this.jMnuIndexFiles = jMnuIndexFiles;
    }

    /**
     * @return the jMnuIndexable
     */
    public javax.swing.JMenu getjMnuIndexable() {
        return jMnuIndexable;
    }

    /**
     * @param jMnuIndexable the jMnuIndexable to set
     */
    public void setjMnuIndexable(javax.swing.JMenu jMnuIndexable) {
        this.jMnuIndexable = jMnuIndexable;
    }

    /**
     * @return the jMnuManagmentUnit
     */
    public javax.swing.JMenuItem getjMnuManagmentUnit() {
        return jMnuManagmentUnit;
    }

    /**
     * @param jMnuManagmentUnit the jMnuManagmentUnit to set
     */
    public void setjMnuManagmentUnit(javax.swing.JMenuItem jMnuManagmentUnit) {
        this.jMnuManagmentUnit = jMnuManagmentUnit;
    }

    /**
     * @return the jMnuSearchFiles
     */
    public javax.swing.JMenuItem getjMnuSearchFiles() {
        return jMnuSearchFiles;
    }

    /**
     * @param jMnuSearchFiles the jMnuSearchFiles to set
     */
    public void setjMnuSearchFiles(javax.swing.JMenuItem jMnuSearchFiles) {
        this.jMnuSearchFiles = jMnuSearchFiles;
    }

    /**
     * @return the jMnuUnit
     */
    public javax.swing.JMenu getjMnuUnit() {
        return jMnuUnit;
    }

    /**
     * @param jMnuUnit the jMnuUnit to set
     */
    public void setjMnuUnit(javax.swing.JMenu jMnuUnit) {
        this.jMnuUnit = jMnuUnit;
    }

    /**
     * @return the jSeparator1
     */
    public javax.swing.JSeparator getjSeparator1() {
        return jSeparator1;
    }

    /**
     * @param jSeparator1 the jSeparator1 to set
     */
    public void setjSeparator1(javax.swing.JSeparator jSeparator1) {
        this.jSeparator1 = jSeparator1;
    }

    /**
     * @return the fileSearching
     */
    public FileSearching getFileSearching() {
        return fileSearching;
    }

    /**
     * @return the jMnuPreferences
     */
    public javax.swing.JMenuItem getjMnuPreferences() {
        return jMnuPreferences;
    }

    /**
     * @param jMnuPreferences the jMnuPreferences to set
     */
    public void setjMnuPreferences(javax.swing.JMenuItem jMnuPreferences) {
        this.jMnuPreferences = jMnuPreferences;
    }

    /**
     * @return the jMnuStatistics
     */
    public javax.swing.JMenuItem getjMnuStatistics() {
        return jMnuStatistics;
    }

    /**
     * @param jMnuStatistics the jMnuStatistics to set
     */
    public void setjMnuStatistics(javax.swing.JMenuItem jMnuStatistics) {
        this.jMnuStatistics = jMnuStatistics;
    }

    /**
     * @return the statisticsWindow
     */
    public Statistics getStatisticsWindow() {
        return statisticsWindow;
    }


    /**
     * @return the configurationWindow
     */
    public ConfiguratorWindow getConfigurationWindow() {
        return configurationWindow;
    }

}
