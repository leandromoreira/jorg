package jorg.gui.config;

import javax.swing.JOptionPane;
import jorg.gui.Main;
import jorg.gui.SwingUtil;

public class ConfiguratorWindow extends javax.swing.JFrame {

    private Main main;

    public ConfiguratorWindow(Main main) {
        this();
        this.main = main;
    }

    private ConfiguratorWindow() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabPanel = new javax.swing.JTabbedPane();
        jPnGeneral = new javax.swing.JPanel();
        jlblLanguage = new javax.swing.JLabel();
        jTxtLanguage = new javax.swing.JTextField();
        jlblLookAndFeel = new javax.swing.JLabel();
        jTxtLookAndFeel = new javax.swing.JTextField();
        jlblFilesNotIndexable = new javax.swing.JLabel();
        jTxtFilesNotIndexable = new javax.swing.JTextField();
        jLblWordsNotIndexable = new javax.swing.JLabel();
        jTxtWordsNotIndexable = new javax.swing.JTextField();
        jLblNumberOfResults = new javax.swing.JLabel();
        jTxtNumberOfResults = new javax.swing.JTextField();
        jPnGrouping = new javax.swing.JPanel();
        jLblPersonal = new javax.swing.JLabel();
        jLblVideo = new javax.swing.JLabel();
        jLblAudio = new javax.swing.JLabel();
        jLblPicture = new javax.swing.JLabel();
        jLblHtml = new javax.swing.JLabel();
        jLblOfficeDocs = new javax.swing.JLabel();
        jLblDiskImages = new javax.swing.JLabel();
        jLblCompression = new javax.swing.JLabel();
        jTxtPersonal = new javax.swing.JTextField();
        jTxtVideo = new javax.swing.JTextField();
        jTxtAudio = new javax.swing.JTextField();
        jTxtPicture = new javax.swing.JTextField();
        jTxtHtml = new javax.swing.JTextField();
        jTxtOfficeDocs = new javax.swing.JTextField();
        jTxtDiskImage = new javax.swing.JTextField();
        jTxtCompression = new javax.swing.JTextField();
        jLblInfo = new javax.swing.JLabel();
        jbtBack = new javax.swing.JButton();
        jbtSave = new javax.swing.JButton();

        setTitle("Jorg - Config");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTabPanel.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jlblLanguage.setForeground(new java.awt.Color(0, 0, 153));
        jlblLanguage.setText("Language (filename of lang)");

        jlblLookAndFeel.setForeground(new java.awt.Color(0, 0, 153));
        jlblLookAndFeel.setText("Look & Feel (Metal, Nimbus, System, Motif, GTK)\n");

        jlblFilesNotIndexable.setForeground(new java.awt.Color(0, 0, 153));
        jlblFilesNotIndexable.setText("Files not indexable (ex: *.ini,Folder.jpg,Thumbs.db,albumart_*)\n");

        jLblWordsNotIndexable.setForeground(new java.awt.Color(0, 0, 153));
        jLblWordsNotIndexable.setText("Words not indexable (Stop words -> Words that doesn't mean nothing when you are searching)\n");

        jLblNumberOfResults.setForeground(new java.awt.Color(0, 0, 153));
        jLblNumberOfResults.setText("Number of results");

        javax.swing.GroupLayout jPnGeneralLayout = new javax.swing.GroupLayout(jPnGeneral);
        jPnGeneral.setLayout(jPnGeneralLayout);
        jPnGeneralLayout.setHorizontalGroup(
            jPnGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPnGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnGeneralLayout.createSequentialGroup()
                        .addComponent(jLblWordsNotIndexable)
                        .addContainerGap())
                    .addGroup(jPnGeneralLayout.createSequentialGroup()
                        .addComponent(jlblFilesNotIndexable)
                        .addGap(413, 413, 413))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnGeneralLayout.createSequentialGroup()
                        .addGroup(jPnGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTxtFilesNotIndexable, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
                            .addComponent(jTxtWordsNotIndexable, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPnGeneralLayout.createSequentialGroup()
                        .addGroup(jPnGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPnGeneralLayout.createSequentialGroup()
                                .addComponent(jLblNumberOfResults)
                                .addGap(142, 142, 142))
                            .addComponent(jTxtNumberOfResults, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(493, Short.MAX_VALUE))
                    .addGroup(jPnGeneralLayout.createSequentialGroup()
                        .addGroup(jPnGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlblLanguage))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPnGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblLookAndFeel)
                            .addComponent(jTxtLookAndFeel, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPnGeneralLayout.setVerticalGroup(
            jPnGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPnGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblLanguage)
                    .addComponent(jlblLookAndFeel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addGroup(jPnGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtLookAndFeel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jlblFilesNotIndexable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtFilesNotIndexable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLblWordsNotIndexable, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtWordsNotIndexable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLblNumberOfResults)
                .addGap(2, 2, 2)
                .addComponent(jTxtNumberOfResults, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        jTabPanel.addTab("General", new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/Server24.gif")), jPnGeneral); // NOI18N

        jLblPersonal.setForeground(new java.awt.Color(0, 0, 102));
        jLblPersonal.setText("Personal");

        jLblVideo.setForeground(new java.awt.Color(0, 0, 102));
        jLblVideo.setText("Video");

        jLblAudio.setForeground(new java.awt.Color(0, 0, 102));
        jLblAudio.setText("Audio");

        jLblPicture.setForeground(new java.awt.Color(0, 0, 102));
        jLblPicture.setText("Picture");

        jLblHtml.setForeground(new java.awt.Color(0, 0, 102));
        jLblHtml.setText("Html");

        jLblOfficeDocs.setForeground(new java.awt.Color(0, 0, 102));
        jLblOfficeDocs.setText("Office Docs");

        jLblDiskImages.setForeground(new java.awt.Color(0, 0, 102));
        jLblDiskImages.setText("Disk Image (Iso)");

        jLblCompression.setForeground(new java.awt.Color(0, 0, 102));
        jLblCompression.setText("Compression");

        javax.swing.GroupLayout jPnGroupingLayout = new javax.swing.GroupLayout(jPnGrouping);
        jPnGrouping.setLayout(jPnGroupingLayout);
        jPnGroupingLayout.setHorizontalGroup(
            jPnGroupingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnGroupingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPnGroupingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnGroupingLayout.createSequentialGroup()
                        .addComponent(jLblPersonal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtPersonal, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE))
                    .addGroup(jPnGroupingLayout.createSequentialGroup()
                        .addComponent(jLblVideo)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtVideo, javax.swing.GroupLayout.DEFAULT_SIZE, 666, Short.MAX_VALUE))
                    .addGroup(jPnGroupingLayout.createSequentialGroup()
                        .addComponent(jLblAudio)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtAudio, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE))
                    .addGroup(jPnGroupingLayout.createSequentialGroup()
                        .addComponent(jLblPicture)
                        .addGap(12, 12, 12)
                        .addComponent(jTxtPicture, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE))
                    .addGroup(jPnGroupingLayout.createSequentialGroup()
                        .addComponent(jLblHtml)
                        .addGap(24, 24, 24)
                        .addComponent(jTxtHtml, javax.swing.GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE))
                    .addGroup(jPnGroupingLayout.createSequentialGroup()
                        .addComponent(jLblOfficeDocs)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtOfficeDocs, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE))
                    .addGroup(jPnGroupingLayout.createSequentialGroup()
                        .addComponent(jLblDiskImages)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtDiskImage, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE))
                    .addGroup(jPnGroupingLayout.createSequentialGroup()
                        .addComponent(jLblCompression)
                        .addGap(18, 18, 18)
                        .addComponent(jTxtCompression, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPnGroupingLayout.setVerticalGroup(
            jPnGroupingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnGroupingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPnGroupingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblPersonal)
                    .addComponent(jTxtPersonal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPnGroupingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblVideo)
                    .addComponent(jTxtVideo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPnGroupingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblAudio)
                    .addComponent(jTxtAudio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPnGroupingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblPicture)
                    .addComponent(jTxtPicture, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPnGroupingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblHtml)
                    .addComponent(jTxtHtml, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPnGroupingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblOfficeDocs)
                    .addComponent(jTxtOfficeDocs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPnGroupingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblDiskImages)
                    .addComponent(jTxtDiskImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPnGroupingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblCompression)
                    .addComponent(jTxtCompression, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jTabPanel.addTab("Grouping", new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/ComposeMail24.gif")), jPnGrouping); // NOI18N

        jLblInfo.setFont(new java.awt.Font("Tahoma", 0, 32));
        jLblInfo.setForeground(new java.awt.Color(51, 51, 255));
        jLblInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblInfo.setText("Configuration");
        jLblInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jbtBack.setText("Back");
        jbtBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtBackActionPerformed(evt);
            }
        });

        jbtSave.setText("Save");
        jbtSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabPanel)
                    .addComponent(jLblInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbtSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtBack)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLblInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtBack)
                    .addComponent(jbtSave))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        loadFileValuesToFiedls();
    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    }//GEN-LAST:event_formWindowOpened

    private void jbtBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtBackActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jbtBackActionPerformed

    private void jbtSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSaveActionPerformed
        saveAll();
    }//GEN-LAST:event_jbtSaveActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new ConfiguratorWindow().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLblAudio;
    private javax.swing.JLabel jLblCompression;
    private javax.swing.JLabel jLblDiskImages;
    private javax.swing.JLabel jLblHtml;
    private javax.swing.JLabel jLblInfo;
    private javax.swing.JLabel jLblNumberOfResults;
    private javax.swing.JLabel jLblOfficeDocs;
    private javax.swing.JLabel jLblPersonal;
    private javax.swing.JLabel jLblPicture;
    private javax.swing.JLabel jLblVideo;
    private javax.swing.JLabel jLblWordsNotIndexable;
    private javax.swing.JPanel jPnGeneral;
    private javax.swing.JPanel jPnGrouping;
    private javax.swing.JTabbedPane jTabPanel;
    private javax.swing.JTextField jTxtAudio;
    private javax.swing.JTextField jTxtCompression;
    private javax.swing.JTextField jTxtDiskImage;
    private javax.swing.JTextField jTxtFilesNotIndexable;
    private javax.swing.JTextField jTxtHtml;
    private javax.swing.JTextField jTxtLanguage;
    private javax.swing.JTextField jTxtLookAndFeel;
    private javax.swing.JTextField jTxtNumberOfResults;
    private javax.swing.JTextField jTxtOfficeDocs;
    private javax.swing.JTextField jTxtPersonal;
    private javax.swing.JTextField jTxtPicture;
    private javax.swing.JTextField jTxtVideo;
    private javax.swing.JTextField jTxtWordsNotIndexable;
    private javax.swing.JButton jbtBack;
    private javax.swing.JButton jbtSave;
    private javax.swing.JLabel jlblFilesNotIndexable;
    private javax.swing.JLabel jlblLanguage;
    private javax.swing.JLabel jlblLookAndFeel;
    // End of variables declaration//GEN-END:variables

    private void loadFileValuesToFiedls() {
        jTxtLanguage.setText(Configurator.getSetupProprerty("language.file"));
        jTxtLookAndFeel.setText(Configurator.getSetupProprerty("lookandfeel"));
        jTxtFilesNotIndexable.setText(Configurator.getSetupProprerty("files.not.indexable"));
        jTxtWordsNotIndexable.setText(Configurator.getSetupProprerty("stop.words"));
        jTxtNumberOfResults.setText(Configurator.getSetupProprerty("number.results"));
        jTxtPersonal.setText(Configurator.getSetupProprerty("types.personal"));
        jTxtCompression.setText(Configurator.getSetupProprerty("types.compression"));
        jTxtDiskImage.setText(Configurator.getSetupProprerty("types.image"));
        jTxtOfficeDocs.setText(Configurator.getSetupProprerty("types.docs"));
        jTxtHtml.setText(Configurator.getSetupProprerty("types.html"));
        jTxtPicture.setText(Configurator.getSetupProprerty("types.picture"));
        jTxtAudio.setText(Configurator.getSetupProprerty("types.audio"));
        jTxtVideo.setText(Configurator.getSetupProprerty("types.video"));
    }

    private void saveAll() {
        try {
            String previousLangFile = Configurator.getSetupProprerty("language.file");
            String settedLangFile = jTxtLanguage.getText();
            Configurator.saveSetup("language.file", jTxtLanguage.getText());
            if (!previousLangFile.equals(settedLangFile)) {
                main.internationalize();
                main.repaint();
                main.pack();
                JOptionPane.showMessageDialog(this, "This option could requires the restart of the application!");
            }
            String previousLookAndFeel = Configurator.getSetupProprerty("lookandfeel");
            String settedLookAndFeel = jTxtLookAndFeel.getText();
            Configurator.saveSetup("lookandfeel", jTxtLookAndFeel.getText());
            if (!previousLookAndFeel.equals(settedLookAndFeel)) {
                JOptionPane.showMessageDialog(this, "This option requires the restart of the application!");
            }
            Configurator.saveSetup("files.not.indexable", jTxtFilesNotIndexable.getText());
            Configurator.saveSetup("stop.words", jTxtWordsNotIndexable.getText());
            Configurator.saveSetup("number.results", jTxtNumberOfResults.getText());
            Configurator.saveSetup("types.personal", jTxtPersonal.getText());
            Configurator.saveSetup("types.compression", jTxtCompression.getText());
            Configurator.saveSetup("types.image", jTxtDiskImage.getText());
            Configurator.saveSetup("types.docs", jTxtOfficeDocs.getText());
            Configurator.saveSetup("types.html", jTxtHtml.getText());
            Configurator.saveSetup("types.picture", jTxtPicture.getText());
            Configurator.saveSetup("types.audio", jTxtAudio.getText());
            Configurator.saveSetup("types.video", jTxtVideo.getText());
        } catch (ConfiguratorException ex) {
            JOptionPane.showMessageDialog(this, "There was an error when it was trying to save -- " + ex);
        }
        loadFileValuesToFiedls();
    }
}
