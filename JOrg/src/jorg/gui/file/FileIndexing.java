package jorg.gui.file;

import jorg.gui.Main;
import jorg.gui.unit.*;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jorg.gui.SwingUtil;
import jorg.gui.container.SearchContainer;
import jorgcore.entity.Unit;

public class FileIndexing extends javax.swing.JFrame {

    public FileIndexing() {
        initComponents();
    }
    private boolean insertMode;
    private SearchUnit search;

    public FileIndexing(SearchUnit search) {
        this.search = search;
        initComponents();
    }
    private Main delegate;

    public FileIndexing(Main main) {
        this();
        delegate = main;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabPanel = new javax.swing.JTabbedPane();
        jPnNew = new javax.swing.JPanel();
        jChk = new javax.swing.JCheckBox();
        jLblContainerParent = new javax.swing.JLabel();
        jTxtBind = new javax.swing.JTextField();
        jLblName = new javax.swing.JLabel();
        jBtnIndex = new javax.swing.JButton();
        jBtnBack = new javax.swing.JButton();
        jCboLocation = new javax.swing.JComboBox();
        jPrg = new javax.swing.JProgressBar();
        jBtnStop = new javax.swing.JButton();
        jPnChoose = new javax.swing.JPanel();
        jLblSearchText = new javax.swing.JLabel();
        jTxtTerm = new javax.swing.JTextField();
        jBtnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblChose = new javax.swing.JTable();
        jBtnSelect = new javax.swing.JButton();
        jLblMessage = new javax.swing.JLabel();
        jLblInfo = new javax.swing.JLabel();

        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jChk.setText("Is it from a unit?");
        jChk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChkActionPerformed(evt);
            }
        });

        jLblContainerParent.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLblContainerParent.setText("Unit:");

        jTxtBind.setEditable(false);
        jTxtBind.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLblName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLblName.setText("Chose unit or type location to be addressed:");

        jBtnIndex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/SaveAll24.gif"))); // NOI18N
        jBtnIndex.setText("Index");
        jBtnIndex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIndexActionPerformed(evt);
            }
        });

        jBtnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/Rewind24.gif"))); // NOI18N
        jBtnBack.setText("Back");
        jBtnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBackActionPerformed(evt);
            }
        });

        jCboLocation.setEditable(true);

        jPrg.setMaximum(3000);

        jBtnStop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/Stop24 (2).gif"))); // NOI18N
        jBtnStop.setText("Cancel");
        jBtnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnStopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPnNewLayout = new javax.swing.GroupLayout(jPnNew);
        jPnNew.setLayout(jPnNewLayout);
        jPnNewLayout.setHorizontalGroup(
            jPnNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnNewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPnNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPrg, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
                    .addGroup(jPnNewLayout.createSequentialGroup()
                        .addGroup(jPnNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLblContainerParent, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLblName, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPnNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jChk, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                            .addGroup(jPnNewLayout.createSequentialGroup()
                                .addComponent(jBtnIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTxtBind, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                            .addComponent(jCboLocation, 0, 443, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPnNewLayout.setVerticalGroup(
            jPnNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnNewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jChk)
                .addGap(18, 18, 18)
                .addGroup(jPnNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblContainerParent)
                    .addComponent(jTxtBind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPnNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblName, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCboLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addComponent(jPrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPnNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnIndex)
                    .addComponent(jBtnBack)
                    .addComponent(jBtnStop))
                .addContainerGap())
        );

        jLblContainerParent.getAccessibleContext().setAccessibleName("Container");

        jTabPanel.addTab("File Indexing", jPnNew);

        jLblSearchText.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLblSearchText.setText("Search by name:");

        jTxtTerm.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jBtnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/Zoom24.gif"))); // NOI18N
        jBtnSearch.setText("Search");
        jBtnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSearchActionPerformed(evt);
            }
        });

        jTblChose.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTblChose);

        jBtnSelect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/Open24.gif"))); // NOI18N
        jBtnSelect.setText("Select");
        jBtnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSelectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPnChooseLayout = new javax.swing.GroupLayout(jPnChoose);
        jPnChoose.setLayout(jPnChooseLayout);
        jPnChooseLayout.setHorizontalGroup(
            jPnChooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnChooseLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPnChooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
                    .addComponent(jBtnSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPnChooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnChooseLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLblSearchText)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jTxtTerm, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jBtnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        jPnChooseLayout.setVerticalGroup(
            jPnChooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnChooseLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnSelect)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPnChooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnChooseLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPnChooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLblSearchText)
                        .addComponent(jTxtTerm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtnSearch))
                    .addGap(309, 309, 309)))
        );

        jTabPanel.addTab("Bind", jPnChoose);

        jLblMessage.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLblMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblMessage.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLblInfo.setFont(new java.awt.Font("Tahoma", 0, 32));
        jLblInfo.setForeground(new java.awt.Color(51, 51, 255));
        jLblInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblInfo.setText("File Indexing");
        jLblInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLblMessage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
                    .addComponent(jTabPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
                    .addComponent(jLblInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLblInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLblMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jChkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jChkActionPerformed
        if (getjChk().isSelected()) {
            getjTabPanel().setSelectedIndex(1);
        } else {
            getjTxtBind().setText("");
        }
}//GEN-LAST:event_jChkActionPerformed
    private IndexingThread thread;

    private void jBtnIndexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIndexActionPerformed
        disableEverythingButStopButton();
        String path = getjCboLocation().getSelectedItem().toString();
        thread = new IndexingThread(jLblMessage, jPrg, path, jTxtBind.getText());
        thread.setDelegate(this);
        thread.start();

}//GEN-LAST:event_jBtnIndexActionPerformed

    private void jBtnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBackActionPerformed
        setVisible(false);
}//GEN-LAST:event_jBtnBackActionPerformed

    private void jBtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSearchActionPerformed
        if (!jTxtTerm.getText().equals("")) {
            try {
                SwingUtil.resetMessage(getjLblMessage());
                Unit.begin();
                List<Unit> set = Unit.findBy(getjTxtTerm().getText());
                Iterator<Unit> it = set.iterator();
                SwingUtil.populateJTableUnit(getjTblChose(), set.size(), it);
            } catch (SQLException ex) {
                Logger.getLogger(SearchContainer.class.getName()).log(Level.SEVERE, null, ex);
                SwingUtil.setupJLblToErrorMessage(getjLblMessage(), ex.toString());
            } catch (Exception ex) {
                Logger.getLogger(SearchContainer.class.getName()).log(Level.SEVERE, null, ex);
                SwingUtil.setupJLblToErrorMessage(getjLblMessage(), ex.toString());
            } finally {
                try {
                    Unit.commit();
                } catch (SQLException ex) {
                    Logger.getLogger(SearchContainer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
}//GEN-LAST:event_jBtnSearchActionPerformed

    private void jBtnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSelectActionPerformed
        String idSelected = getjTblChose().getValueAt(getjTblChose().getSelectedRow(), 0).toString();
        String description = getjTblChose().getValueAt(getjTblChose().getSelectedRow(), 1).toString();
        getjTxtBind().setText(idSelected + " - " + description);
        getjTabPanel().setSelectedIndex(0);
}//GEN-LAST:event_jBtnSelectActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        getjCboLocation().setModel(new javax.swing.DefaultComboBoxModel(FileManager.getDrives()));

        try {
            SwingUtil.resetMessage(getjLblMessage());
            Unit.begin();
            List<Unit> set = Unit.listLast();
            Iterator<Unit> it = set.iterator();
            SwingUtil.populateJTableUnit(getjTblChose(), set.size(), it);
        } catch (SQLException ex) {
            Logger.getLogger(SearchContainer.class.getName()).log(Level.SEVERE, null, ex);
            SwingUtil.setupJLblToErrorMessage(getjLblMessage(), ex.toString());
        } catch (Exception ex) {
            Logger.getLogger(SearchContainer.class.getName()).log(Level.SEVERE, null, ex);
            SwingUtil.setupJLblToErrorMessage(getjLblMessage(), ex.toString());
        } finally {
            try {
                Unit.commit();
            } catch (SQLException ex) {
                Logger.getLogger(SearchContainer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_formWindowActivated

    private void jBtnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnStopActionPerformed
        thread.safetyStop();
        enableEverything();
        jPrg.setIndeterminate(false);
        jPrg.setValue(jPrg.getMinimum());
    }//GEN-LAST:event_jBtnStopActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new FileIndexing().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnBack;
    private javax.swing.JButton jBtnIndex;
    private javax.swing.JButton jBtnSearch;
    private javax.swing.JButton jBtnSelect;
    private javax.swing.JButton jBtnStop;
    private javax.swing.JComboBox jCboLocation;
    private javax.swing.JCheckBox jChk;
    private javax.swing.JLabel jLblContainerParent;
    private javax.swing.JLabel jLblInfo;
    private javax.swing.JLabel jLblMessage;
    private javax.swing.JLabel jLblName;
    private javax.swing.JLabel jLblSearchText;
    private javax.swing.JPanel jPnChoose;
    private javax.swing.JPanel jPnNew;
    private javax.swing.JProgressBar jPrg;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabPanel;
    private javax.swing.JTable jTblChose;
    private javax.swing.JTextField jTxtBind;
    private javax.swing.JTextField jTxtTerm;
    // End of variables declaration//GEN-END:variables

    void setInsertableMode(boolean b) {
        this.setInsertMode(b);
    }

    /**
     * @return the insertMode
     */
    public boolean isInsertMode() {
        return insertMode;
    }

    /**
     * @param insertMode the insertMode to set
     */
    public void setInsertMode(boolean insertMode) {
        this.insertMode = insertMode;
    }

    /**
     * @return the jBtnBack
     */
    public javax.swing.JButton getjBtnBack() {
        return jBtnBack;
    }

    /**
     * @param jBtnBack the jBtnBack to set
     */
    public void setjBtnBack(javax.swing.JButton jBtnBack) {
        this.jBtnBack = jBtnBack;
    }

    /**
     * @return the jBtnSearch
     */
    public javax.swing.JButton getjBtnSearch() {
        return jBtnSearch;
    }

    /**
     * @param jBtnSearch the jBtnSearch to set
     */
    public void setjBtnSearch(javax.swing.JButton jBtnSearch) {
        this.jBtnSearch = jBtnSearch;
    }

    /**
     * @return the jBtnSelect
     */
    public javax.swing.JButton getjBtnSelect() {
        return jBtnSelect;
    }

    /**
     * @param jBtnSelect the jBtnSelect to set
     */
    public void setjBtnSelect(javax.swing.JButton jBtnSelect) {
        this.jBtnSelect = jBtnSelect;
    }

    /**
     * @return the jChk
     */
    public javax.swing.JCheckBox getjChk() {
        return jChk;
    }

    /**
     * @param jChk the jChk to set
     */
    public void setjChk(javax.swing.JCheckBox jChk) {
        this.jChk = jChk;
    }

    /**
     * @return the jLblContainerParent
     */
    public javax.swing.JLabel getjLblContainerParent() {
        return jLblContainerParent;
    }

    /**
     * @param jLblContainerParent the jLblContainerParent to set
     */
    public void setjLblContainerParent(javax.swing.JLabel jLblContainerParent) {
        this.jLblContainerParent = jLblContainerParent;
    }

    /**
     * @return the jLblInfo
     */
    public javax.swing.JLabel getjLblInfo() {
        return jLblInfo;
    }

    /**
     * @param jLblInfo the jLblInfo to set
     */
    public void setjLblInfo(javax.swing.JLabel jLblInfo) {
        this.jLblInfo = jLblInfo;
    }

    /**
     * @return the jLblMessage
     */
    public javax.swing.JLabel getjLblMessage() {
        return jLblMessage;
    }

    /**
     * @param jLblMessage the jLblMessage to set
     */
    public void setjLblMessage(javax.swing.JLabel jLblMessage) {
        this.jLblMessage = jLblMessage;
    }

    /**
     * @return the jLblName
     */
    public javax.swing.JLabel getjLblName() {
        return jLblName;
    }

    /**
     * @param jLblName the jLblName to set
     */
    public void setjLblName(javax.swing.JLabel jLblName) {
        this.jLblName = jLblName;
    }

    /**
     * @return the jLblSearchText
     */
    public javax.swing.JLabel getjLblSearchText() {
        return jLblSearchText;
    }

    /**
     * @param jLblSearchText the jLblSearchText to set
     */
    public void setjLblSearchText(javax.swing.JLabel jLblSearchText) {
        this.jLblSearchText = jLblSearchText;
    }

    /**
     * @return the jPnChoose
     */
    public javax.swing.JPanel getjPnChoose() {
        return jPnChoose;
    }

    /**
     * @param jPnChoose the jPnChoose to set
     */
    public void setjPnChoose(javax.swing.JPanel jPnChoose) {
        this.jPnChoose = jPnChoose;
    }

    /**
     * @return the jPnNew
     */
    public javax.swing.JPanel getjPnNew() {
        return jPnNew;
    }

    /**
     * @param jPnNew the jPnNew to set
     */
    public void setjPnNew(javax.swing.JPanel jPnNew) {
        this.jPnNew = jPnNew;
    }

    /**
     * @return the jScrollPane1
     */
    public javax.swing.JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    /**
     * @param jScrollPane1 the jScrollPane1 to set
     */
    public void setjScrollPane1(javax.swing.JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    /**
     * @return the jTabPanel
     */
    public javax.swing.JTabbedPane getjTabPanel() {
        return jTabPanel;
    }

    /**
     * @param jTabPanel the jTabPanel to set
     */
    public void setjTabPanel(javax.swing.JTabbedPane jTabPanel) {
        this.jTabPanel = jTabPanel;
    }

    /**
     * @return the jTblChose
     */
    public javax.swing.JTable getjTblChose() {
        return jTblChose;
    }

    /**
     * @param jTblChose the jTblChose to set
     */
    public void setjTblChose(javax.swing.JTable jTblChose) {
        this.jTblChose = jTblChose;
    }

    /**
     * @return the jTxtBind
     */
    public javax.swing.JTextField getjTxtBind() {
        return jTxtBind;
    }

    /**
     * @param jTxtBind the jTxtBind to set
     */
    public void setjTxtBind(javax.swing.JTextField jTxtBind) {
        this.jTxtBind = jTxtBind;
    }

    /**
     * @return the jTxtTerm
     */
    public javax.swing.JTextField getjTxtTerm() {
        return jTxtTerm;
    }

    /**
     * @param jTxtTerm the jTxtTerm to set
     */
    public void setjTxtTerm(javax.swing.JTextField jTxtTerm) {
        this.jTxtTerm = jTxtTerm;
    }

    private void goBack() {
        try {
            Unit.begin();
            Iterator<Unit> it = Unit.findAll().iterator();
            SwingUtil.populateJTableUnit(getSearch().getjTblUnit(), Unit.count(), it);
            setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(SearchContainer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                pack();
                Unit.commit();
            } catch (SQLException ex) {
                Logger.getLogger(SearchContainer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * @return the search
     */
    public SearchUnit getSearch() {
        return search;
    }

    /**
     * @param search the search to set
     */
    public void setSearch(SearchUnit search) {
        this.search = search;
    }
    private int editedId;

    public void setEditedId(int id) {
        editedId = id;
    }

    /**
     * @return the jBtnIndex
     */
    public javax.swing.JButton getjBtnIndex() {
        return jBtnIndex;
    }

    /**
     * @param jBtnIndex the jBtnIndex to set
     */
    public void setjBtnIndex(javax.swing.JButton jBtnIndex) {
        this.jBtnIndex = jBtnIndex;
    }

    /**
     * @return the jCboLocation
     */
    public javax.swing.JComboBox getjCboLocation() {
        return jCboLocation;
    }

    /**
     * @param jCboLocation the jCboLocation to set
     */
    public void setjCboLocation(javax.swing.JComboBox jCboLocation) {
        this.jCboLocation = jCboLocation;
    }

    /**
     * @return the editedId
     */
    public int getEditedId() {
        return editedId;
    }

    private void disableEverythingButStopButton() {
        apply(false);
    }

    public void enableEverything() {
        apply(true);
    }

    private void apply(boolean value) {
        delegate.getjMnuContainer().setEnabled(value);
        delegate.getjMnuUnit().setEnabled(value);
        delegate.getjMnuIndexable().setEnabled(value);
        jBtnIndex.setEnabled(value);
        jBtnBack.setEnabled(value);
        jBtnSearch.setEnabled(value);
        jBtnSelect.setEnabled(value);
        jTxtBind.setEnabled(value);
        jTxtTerm.setEnabled(value);
        jCboLocation.setEnabled(value);
        jChk.setEnabled(value);
    }

    /**
     * @return the jBtnStop
     */
    public javax.swing.JButton getjBtnStop() {
        return jBtnStop;
    }

    /**
     * @param jBtnStop the jBtnStop to set
     */
    public void setjBtnStop(javax.swing.JButton jBtnStop) {
        this.jBtnStop = jBtnStop;
    }
}
