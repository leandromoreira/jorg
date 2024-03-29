package jorg.gui.unit;

import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jorg.gui.SwingUtil;
import jorg.gui.container.SearchContainer;
import jorgcore.entity.Container;
import jorgcore.entity.Unit;

public class NewUnit extends javax.swing.JFrame {

    public NewUnit() {
        initComponents();
    }
    private boolean insertMode;
    private SearchUnit search;

    public NewUnit(SearchUnit search) {
        this.search = search;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabPanel = new javax.swing.JTabbedPane();
        jPnNew = new javax.swing.JPanel();
        jChk = new javax.swing.JCheckBox();
        jLblContainerParent = new javax.swing.JLabel();
        jTxtBind = new javax.swing.JTextField();
        jLblName = new javax.swing.JLabel();
        jTxtName = new javax.swing.JTextField();
        jBtnSave = new javax.swing.JButton();
        jBtnBack = new javax.swing.JButton();
        jCboType = new javax.swing.JComboBox();
        jLblType = new javax.swing.JLabel();
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

        jChk.setSelected(true);
        jChk.setText("Is inside of a container?");
        jChk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jChkActionPerformed(evt);
            }
        });

        jLblContainerParent.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLblContainerParent.setText("Container:");

        jTxtBind.setEditable(false);
        jTxtBind.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLblName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLblName.setText("Name:");

        jTxtName.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jBtnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/Save24.gif"))); // NOI18N
        jBtnSave.setText("Save");
        jBtnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSaveActionPerformed(evt);
            }
        });

        jBtnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/Rewind24.gif"))); // NOI18N
        jBtnBack.setText("Back");
        jBtnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBackActionPerformed(evt);
            }
        });

        jCboType.setEditable(true);
        jCboType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "DVD", "CD", "HD", "Pendrive" }));

        jLblType.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLblType.setText("Type:");

        javax.swing.GroupLayout jPnNewLayout = new javax.swing.GroupLayout(jPnNew);
        jPnNew.setLayout(jPnNewLayout);
        jPnNewLayout.setHorizontalGroup(
            jPnNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnNewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPnNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPnNewLayout.createSequentialGroup()
                        .addGroup(jPnNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLblContainerParent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPnNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jChk, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPnNewLayout.createSequentialGroup()
                                .addComponent(jBtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTxtBind, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
                            .addComponent(jTxtName, javax.swing.GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnNewLayout.createSequentialGroup()
                        .addComponent(jLblType, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCboType, 0, 577, Short.MAX_VALUE)))
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
                    .addComponent(jLblName)
                    .addComponent(jTxtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPnNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCboType)
                    .addComponent(jLblType))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addGroup(jPnNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnSave)
                    .addComponent(jBtnBack))
                .addContainerGap())
        );

        jLblContainerParent.getAccessibleContext().setAccessibleName("Container");

        jTabPanel.addTab("Unit Management", jPnNew);

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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
                    .addComponent(jBtnSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPnChooseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnChooseLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLblSearchText)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jTxtTerm, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
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
        jLblInfo.setText("Unit Management");
        jLblInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLblMessage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
                    .addComponent(jTabPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
                    .addComponent(jLblInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE))
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
        if (jChk.isSelected()) {
            getjTabPanel().setSelectedIndex(1);
        } else {
            getjTxtBind().setText("");
        }
}//GEN-LAST:event_jChkActionPerformed

    private void jBtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSaveActionPerformed
        SwingUtil.resetMessage(getjLblMessage());
        if (isInsertMode()) {
            insert();
        } else {
            update();
        }
}//GEN-LAST:event_jBtnSaveActionPerformed

    private void update() {
        if (jTxtName.getText() == null) {
            SwingUtil.setupJLblToInfoMessage(getjLblMessage(), SwingUtil.getInternationalizedText("name.required"));
            return;
        }
        if (jTxtName.getText().trim().equals("")) {
            SwingUtil.setupJLblToInfoMessage(getjLblMessage(), SwingUtil.getInternationalizedText("name.required"));
            return;
        }
        Unit editedUnit = new Unit();
        editedUnit.id = this.editedId;
        editedUnit.type = jCboType.getSelectedItem().toString().trim();
        editedUnit.name = jTxtName.getText();
        if (jChk.isSelected()) {
            editedUnit.id_container = new Integer(jTxtBind.getText().split("-")[0].trim());
        }
        try {
            if (jChk.isSelected()) {
                Unit.update(editedUnit, editedUnit.id_container);
            } else {
                Unit.update(editedUnit);
            }
            goBack();
        } catch (SQLException ex) {
            SwingUtil.setupJLblToInfoMessage(getjLblMessage(), ex.getMessage());
            Logger.getLogger(NewUnit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            SwingUtil.setupJLblToInfoMessage(getjLblMessage(), ex.getMessage());
            Logger.getLogger(NewUnit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void insert() {

        if (jTxtName.getText() == null) {
            SwingUtil.setupJLblToInfoMessage(getjLblMessage(), SwingUtil.getInternationalizedText("name.required"));
            return;
        }
        if (jTxtName.getText().trim().equals("")) {
            SwingUtil.setupJLblToInfoMessage(getjLblMessage(), SwingUtil.getInternationalizedText("name.required"));
            return;
        }
        Unit newUnit = new Unit();
        newUnit.type = jCboType.getSelectedItem().toString().trim();
        newUnit.creation_date = new Date();
        newUnit.name = jTxtName.getText();
        if (jChk.isSelected()) {
            newUnit.id_container = new Integer(jTxtBind.getText().split("-")[0].trim());
        }
        try {
            if (jChk.isSelected()) {
                Unit.insert(newUnit, newUnit.id_container);
            } else {
                Unit.insert(newUnit);
            }
            goBack();
        } catch (SQLException ex) {
            SwingUtil.setupJLblToInfoMessage(getjLblMessage(), ex.getMessage());
            Logger.getLogger(NewUnit.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            SwingUtil.setupJLblToInfoMessage(getjLblMessage(), ex.getMessage());
            Logger.getLogger(NewUnit.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void jBtnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBackActionPerformed
        setVisible(false);
}//GEN-LAST:event_jBtnBackActionPerformed

    private void jBtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSearchActionPerformed
        if (!jTxtTerm.getText().equals("")) {
            try {
                String term = jTxtTerm.getText();
                if (!term.contains("*")) {
                    term = "*" + term + "*";
                }
                SwingUtil.resetMessage(getjLblMessage());
                List<Container> set = Container.findBy(term);
                Iterator<Container> it = set.iterator();
                SwingUtil.populateJTableContainer(getjTblChose(), set.size(), it);
            } catch (SQLException ex) {
                Logger.getLogger(SearchContainer.class.getName()).log(Level.SEVERE, null, ex);
                SwingUtil.setupJLblToErrorMessage(getjLblMessage(), ex.toString());
            } catch (Exception ex) {
                Logger.getLogger(SearchContainer.class.getName()).log(Level.SEVERE, null, ex);
                SwingUtil.setupJLblToErrorMessage(getjLblMessage(), ex.toString());
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
        try {
            List<Container> set = Container.findAll();
            Iterator<Container> it = set.iterator();
            SwingUtil.populateJTableContainer(getjTblChose(), set.size(), it);
        } catch (SQLException ex) {
            Logger.getLogger(SearchContainer.class.getName()).log(Level.SEVERE, null, ex);
            SwingUtil.setupJLblToErrorMessage(getjLblMessage(), ex.toString());
        } catch (Exception ex) {
            Logger.getLogger(SearchContainer.class.getName()).log(Level.SEVERE, null, ex);
            SwingUtil.setupJLblToErrorMessage(getjLblMessage(), ex.toString());
        }
    }//GEN-LAST:event_formWindowActivated

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new NewUnit().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnBack;
    private javax.swing.JButton jBtnSave;
    private javax.swing.JButton jBtnSearch;
    private javax.swing.JButton jBtnSelect;
    private javax.swing.JComboBox jCboType;
    private javax.swing.JCheckBox jChk;
    private javax.swing.JLabel jLblContainerParent;
    private javax.swing.JLabel jLblInfo;
    private javax.swing.JLabel jLblMessage;
    private javax.swing.JLabel jLblName;
    private javax.swing.JLabel jLblSearchText;
    private javax.swing.JLabel jLblType;
    private javax.swing.JPanel jPnChoose;
    private javax.swing.JPanel jPnNew;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabPanel;
    private javax.swing.JTable jTblChose;
    private javax.swing.JTextField jTxtBind;
    private javax.swing.JTextField jTxtName;
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
     * @return the jBtnSave
     */
    public javax.swing.JButton getjBtnSave() {
        return jBtnSave;
    }

    /**
     * @param jBtnSave the jBtnSave to set
     */
    public void setjBtnSave(javax.swing.JButton jBtnSave) {
        this.jBtnSave = jBtnSave;
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
     * @return the jCboType
     */
    public javax.swing.JComboBox getjCboType() {
        return jCboType;
    }

    /**
     * @param jCboType the jCboType to set
     */
    public void setjCboType(javax.swing.JComboBox jCboType) {
        this.jCboType = jCboType;
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
     * @return the jLblType
     */
    public javax.swing.JLabel getjLblType() {
        return jLblType;
    }

    /**
     * @param jLblType the jLblType to set
     */
    public void setjLblType(javax.swing.JLabel jLblType) {
        this.jLblType = jLblType;
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
     * @return the jTxtName
     */
    public javax.swing.JTextField getjTxtName() {
        return jTxtName;
    }

    /**
     * @param jTxtName the jTxtName to set
     */
    public void setjTxtName(javax.swing.JTextField jTxtName) {
        this.jTxtName = jTxtName;
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
            Iterator<Unit> it = Unit.findAll().iterator();
            SwingUtil.populateJTableUnit(getSearch().getjTblUnit(), Unit.count(), it);
            setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(SearchContainer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pack();
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
}
