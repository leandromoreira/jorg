package jorg.gui.unit;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import jorg.gui.SwingUtil;
import jorg.gui.container.SearchContainer;
import jorgcore.entity.Container;
import jorgcore.entity.Unit;

public class SearchUnit extends javax.swing.JFrame {

    public SearchUnit() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLblUnitInfo = new javax.swing.JLabel();
        jLblSearchText = new javax.swing.JLabel();
        jTxtTerm = new javax.swing.JTextField();
        jBtnSearch = new javax.swing.JButton();
        jLblContainerTip = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblUnit = new javax.swing.JTable();
        jLblMessage = new javax.swing.JLabel();
        jBtnBack = new javax.swing.JButton();
        jBtnDelete = new javax.swing.JButton();
        jBtnEdit = new javax.swing.JButton();
        jBtnNew = new javax.swing.JButton();

        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLblUnitInfo.setFont(new java.awt.Font("Tahoma", 0, 32));
        jLblUnitInfo.setForeground(new java.awt.Color(51, 51, 255));
        jLblUnitInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblUnitInfo.setText("Unit Central");
        jLblUnitInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLblSearchText.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLblSearchText.setText("Search by name:");

        jTxtTerm.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jBtnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/Find24.gif"))); // NOI18N
        jBtnSearch.setText("Search");
        jBtnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSearchActionPerformed(evt);
            }
        });

        jLblContainerTip.setForeground(new java.awt.Color(0, 51, 204));
        jLblContainerTip.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblContainerTip.setText("Tip: Try to search using * operator as wildchar. (ex: find anything which starts with pic: pic*)");

        jTblUnit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTblUnit);

        jLblMessage.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLblMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblMessage.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBtnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/Rewind24.gif"))); // NOI18N
        jBtnBack.setText("Back");
        jBtnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnBackActionPerformed(evt);
            }
        });

        jBtnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/Delete24.gif"))); // NOI18N
        jBtnDelete.setText("Delete");
        jBtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDeleteActionPerformed(evt);
            }
        });

        jBtnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/Edit24.gif"))); // NOI18N
        jBtnEdit.setText("Edit");
        jBtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEditActionPerformed(evt);
            }
        });

        jBtnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/Add24.gif"))); // NOI18N
        jBtnNew.setText("Create New");
        jBtnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 689, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLblMessage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
                        .addComponent(jLblUnitInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLblSearchText)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTxtTerm, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jBtnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLblContainerTip, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jBtnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jBtnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jBtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jBtnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(107, 107, 107)))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addComponent(jLblUnitInfo)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLblSearchText)
                        .addComponent(jTxtTerm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtnSearch))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLblContainerTip)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtnNew)
                        .addComponent(jBtnEdit)
                        .addComponent(jBtnDelete)
                        .addComponent(jBtnBack))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jLblMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addGap(11, 11, 11)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSearchActionPerformed
        /*
        if (!jTxtTerm.getText().equals("")) {
            try {
                SwingUtil.resetMessage(jLblMessage);
                Container.begin();
                List<Container> set = Container.findBy(jTxtTerm.getText());
                Iterator<Container> it = set.iterator();
                SwingUtil.populateJTableContainer(jTblUnit, set.size(), it);
            } catch (SQLException ex) {
                Logger.getLogger(SearchContainer.class.getName()).log(Level.SEVERE, null, ex);
                SwingUtil.setupJLblToErrorMessage(jLblMessage, ex.toString());
            } catch (Exception ex) {
                Logger.getLogger(SearchContainer.class.getName()).log(Level.SEVERE, null, ex);
                SwingUtil.setupJLblToErrorMessage(jLblMessage, ex.toString());
            } finally {
                try {
                    Container.commit();
                } catch (SQLException ex) {
                    Logger.getLogger(SearchContainer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        */
}//GEN-LAST:event_jBtnSearchActionPerformed

    private void jBtnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBackActionPerformed
        setVisible(false);
}//GEN-LAST:event_jBtnBackActionPerformed

    private void jBtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDeleteActionPerformed
        /*int answer = JOptionPane.showConfirmDialog(this, Configurator.getInternationlizedText("deletequestion"));
        if (answer == 0) {
            String id = jTblUnit.getValueAt(jTblUnit.getSelectedRow(), 0).toString();
            try {
                Container.begin();
                Container.delete(Container.findBy(new Integer(id)));
            } catch (SQLException ex) {
                Logger.getLogger(NewContainer.class.getName()).log(Level.SEVERE, null, ex);
                SwingUtil.setupJLblToErrorMessage(jLblMessage, ex.toString());
            } catch (Exception ex) {
                Logger.getLogger(NewContainer.class.getName()).log(Level.SEVERE, null, ex);
                SwingUtil.setupJLblToErrorMessage(jLblMessage, ex.toString());
            } finally {
                try {
                    Container.commit();
                } catch (SQLException ex) {
                    Logger.getLogger(NewContainer.class.getName()).log(Level.SEVERE, null, ex);
                    SwingUtil.setupJLblToErrorMessage(jLblMessage, ex.toString());
                }
            }
            formWindowOpened(null);
        }*/
}//GEN-LAST:event_jBtnDeleteActionPerformed

    private void jBtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditActionPerformed
        /*SwingUtil.resetMessage(jLblMessage);
        int id = new Integer(jTblUnit.getValueAt(jTblUnit.getSelectedRow(), 0).toString());
        SwingUtil.resetMessage(jLblMessage);
        SwingUtil.center(newContainer);
        newContainer.setInfoTitle("container.title.edit");
        try {
            Container.begin();
            fillEditForm(Container.findBy(id));
            newContainer.setEditedId(id);
            newContainer.setInsertableMode(false);
            newContainer.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(SearchContainer.class.getName()).log(Level.SEVERE, null, ex);
            SwingUtil.setupJLblToErrorMessage(jLblMessage, ex.toString());
        } finally {
            try {
                Container.commit();
            } catch (SQLException ex) {
                Logger.getLogger(SearchContainer.class.getName()).log(Level.SEVERE, null, ex);
                SwingUtil.setupJLblToErrorMessage(jLblMessage, ex.toString());
            }
        }*/
}//GEN-LAST:event_jBtnEditActionPerformed

    private void jBtnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNewActionPerformed
       /* SwingUtil.resetMessage(jLblMessage);
        SwingUtil.center(newContainer);
        newContainer.setInsertableMode(true);
        newContainer.setInfoTitle("container.new");
        newContainer.getjTabPanel().setSelectedIndex(0);
        newContainer.getjCheckIsRoot().setSelected(true);
        newContainer.getjTxtParent().setText("");
        newContainer.getjTxtDescription().setText("");
        newContainer.getjTxtTerm().setText("");
        newContainer.setVisible(true);*/
}//GEN-LAST:event_jBtnNewActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        SwingUtil.resetMessage(jLblMessage);
        try {
            Unit.begin();
            Iterator<Unit> it = Unit.findAll().iterator();
            SwingUtil.populateJTableUnit(jTblUnit, Unit.count(), it);
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

    }//GEN-LAST:event_formWindowOpened

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchUnit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnBack;
    private javax.swing.JButton jBtnDelete;
    private javax.swing.JButton jBtnEdit;
    private javax.swing.JButton jBtnNew;
    private javax.swing.JButton jBtnSearch;
    private javax.swing.JLabel jLblContainerTip;
    private javax.swing.JLabel jLblMessage;
    private javax.swing.JLabel jLblSearchText;
    private javax.swing.JLabel jLblUnitInfo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTblUnit;
    private javax.swing.JTextField jTxtTerm;
    // End of variables declaration//GEN-END:variables

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
     * @return the jBtnDelete
     */
    public javax.swing.JButton getjBtnDelete() {
        return jBtnDelete;
    }

    /**
     * @param jBtnDelete the jBtnDelete to set
     */
    public void setjBtnDelete(javax.swing.JButton jBtnDelete) {
        this.jBtnDelete = jBtnDelete;
    }

    /**
     * @return the jBtnEdit
     */
    public javax.swing.JButton getjBtnEdit() {
        return jBtnEdit;
    }

    /**
     * @param jBtnEdit the jBtnEdit to set
     */
    public void setjBtnEdit(javax.swing.JButton jBtnEdit) {
        this.jBtnEdit = jBtnEdit;
    }

    /**
     * @return the jBtnNew
     */
    public javax.swing.JButton getjBtnNew() {
        return jBtnNew;
    }

    /**
     * @param jBtnNew the jBtnNew to set
     */
    public void setjBtnNew(javax.swing.JButton jBtnNew) {
        this.jBtnNew = jBtnNew;
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
     * @return the jLblContainerTip
     */
    public javax.swing.JLabel getjLblContainerTip() {
        return jLblContainerTip;
    }

    /**
     * @param jLblContainerTip the jLblContainerTip to set
     */
    public void setjLblContainerTip(javax.swing.JLabel jLblContainerTip) {
        this.jLblContainerTip = jLblContainerTip;
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
     * @return the jLblUnitInfo
     */
    public javax.swing.JLabel getjLblUnitInfo() {
        return jLblUnitInfo;
    }

    /**
     * @param jLblUnitInfo the jLblUnitInfo to set
     */
    public void setjLblUnitInfo(javax.swing.JLabel jLblUnitInfo) {
        this.jLblUnitInfo = jLblUnitInfo;
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
     * @return the jTblUnit
     */
    public javax.swing.JTable getjTblUnit() {
        return jTblUnit;
    }

    /**
     * @param jTblUnit the jTblUnit to set
     */
    public void setjTblUnit(javax.swing.JTable jTblUnit) {
        this.jTblUnit = jTblUnit;
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

}
