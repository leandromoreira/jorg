package jorg.gui.unit;

import java.awt.print.PrinterException;
import jorg.indexing.LuceneUpdater;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jorg.gui.SwingUtil;
import jorg.gui.config.Configurator;
import jorg.gui.container.NewContainer;
import jorg.gui.container.SearchContainer;
import jorg.gui.file.FileSearching;
import jorgcore.entity.Container;
import jorgcore.entity.Unit;

public class SearchUnit extends javax.swing.JFrame {

    private NewUnit newUnit = new NewUnit(this);

    public SearchUnit() {
        initComponents();
    }

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
        jBtnRent = new javax.swing.JButton();
        jBtnGiveBack = new javax.swing.JButton();
        jBtnPrint = new javax.swing.JButton();

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

        jBtnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/Zoom24.gif"))); // NOI18N
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
        jTblUnit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblUnitMouseClicked(evt);
            }
        });
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

        jBtnRent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/Play24.gif"))); // NOI18N
        jBtnRent.setText("Rent");
        jBtnRent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnRentActionPerformed(evt);
            }
        });

        jBtnGiveBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/Refresh24.gif"))); // NOI18N
        jBtnGiveBack.setText("Give Back");
        jBtnGiveBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGiveBackActionPerformed(evt);
            }
        });

        jBtnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/PrintPreview24.gif"))); // NOI18N
        jBtnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jBtnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(jBtnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jBtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnRent, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnGiveBack, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLblContainerTip, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLblSearchText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTxtTerm, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnPrint)
                        .addGap(23, 23, 23))
                    .addComponent(jLblMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 923, Short.MAX_VALUE)
                    .addComponent(jLblUnitInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 923, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 923, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLblUnitInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnPrint)
                        .addGap(8, 8, 8)
                        .addComponent(jLblContainerTip))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jBtnSearch)
                        .addComponent(jLblSearchText)
                        .addComponent(jTxtTerm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnBack)
                    .addComponent(jBtnGiveBack)
                    .addComponent(jBtnRent)
                    .addComponent(jBtnDelete)
                    .addComponent(jBtnNew)
                    .addComponent(jBtnEdit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLblMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSearchActionPerformed
        if (!jTxtTerm.getText().equals("")) {
            try {
                String term = jTxtTerm.getText();
                if (!term.contains("*")) {
                    term = "*" + term + "*";
                }
                SwingUtil.resetMessage(jLblMessage);
                List<Unit> set = Unit.findBy(term);
                Iterator<Unit> it = set.iterator();
                SwingUtil.populateJTableUnit(jTblUnit, set.size(), it);
            } catch (SQLException ex) {
                Logger.getLogger(SearchContainer.class.getName()).log(Level.SEVERE, null, ex);
                SwingUtil.setupJLblToErrorMessage(jLblMessage, ex.toString());
            } catch (Exception ex) {
                Logger.getLogger(SearchContainer.class.getName()).log(Level.SEVERE, null, ex);
                SwingUtil.setupJLblToErrorMessage(jLblMessage, ex.toString());
            }
        }

}//GEN-LAST:event_jBtnSearchActionPerformed

    private void jBtnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBackActionPerformed
        setVisible(false);
}//GEN-LAST:event_jBtnBackActionPerformed

    private void jBtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDeleteActionPerformed
        int answer = JOptionPane.showConfirmDialog(this, Configurator.getInternationlizedText("deletequestion"));
        if (answer == 0) {
            String id = jTblUnit.getValueAt(jTblUnit.getSelectedRow(), 0).toString();
            try {
                int[] ids = Unit.delete(Unit.findBy(new Integer(id)));
                LuceneUpdater.delete(ids);
            } catch (SQLException ex) {
                Logger.getLogger(NewContainer.class.getName()).log(Level.SEVERE, null, ex);
                SwingUtil.setupJLblToErrorMessage(jLblMessage, ex.toString());
            } catch (Exception ex) {
                Logger.getLogger(NewContainer.class.getName()).log(Level.SEVERE, null, ex);
                SwingUtil.setupJLblToErrorMessage(jLblMessage, ex.toString());
            }
            formWindowOpened(null);
        }
}//GEN-LAST:event_jBtnDeleteActionPerformed

    private void jBtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEditActionPerformed
        SwingUtil.resetMessage(jLblMessage);
        int id = new Integer(jTblUnit.getValueAt(jTblUnit.getSelectedRow(), 0).toString());
        SwingUtil.resetMessage(jLblMessage);
        SwingUtil.center(newUnit);
        try {
            fillEditForm(Unit.findBy(id));
            newUnit.setEditedId(id);
            newUnit.setInsertableMode(false);
            newUnit.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(SearchContainer.class.getName()).log(Level.SEVERE, null, ex);
            SwingUtil.setupJLblToErrorMessage(jLblMessage, ex.toString());
        }
}//GEN-LAST:event_jBtnEditActionPerformed

    private void jBtnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNewActionPerformed
        SwingUtil.resetMessage(jLblMessage);
        SwingUtil.center(newUnit);
        newUnit.setInsertableMode(true);
        newUnit.getjTabPanel().setSelectedIndex(0);
        newUnit.getjChk().setSelected(false);
        newUnit.getjTxtName().setText("");
        newUnit.getjTxtTerm().setText("");
        newUnit.getjTxtBind().setText("");
        newUnit.setVisible(true);
}//GEN-LAST:event_jBtnNewActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        SwingUtil.resetMessage(jLblMessage);
        try {
            Iterator<Unit> it = Unit.findAll().iterator();
            SwingUtil.populateJTableUnit(jTblUnit, Unit.count(), it);
        } catch (SQLException ex) {
            Logger.getLogger(SearchContainer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pack();
        }

    }//GEN-LAST:event_formWindowOpened

    private void jBtnRentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnRentActionPerformed
        int answer = JOptionPane.showConfirmDialog(this, Configurator.getInternationlizedText("rentquestion"));
        if (answer == 0) {
            String person = JOptionPane.showInputDialog(this, Configurator.getInternationlizedText("typename"));
            if (person == null) {
                person = "";
            }
            Date today = new Date();
            String id = jTblUnit.getValueAt(jTblUnit.getSelectedRow(), 0).toString();
            try {
                Unit mine = Unit.findBy(Integer.parseInt(id));
                mine.rented_to = person;
                mine.rented_date = today;
                Unit.updateRent(mine);
            } catch (SQLException ex) {
                Logger.getLogger(NewContainer.class.getName()).log(Level.SEVERE, null, ex);
                SwingUtil.setupJLblToErrorMessage(jLblMessage, ex.toString());
            } catch (Exception ex) {
                Logger.getLogger(NewContainer.class.getName()).log(Level.SEVERE, null, ex);
                SwingUtil.setupJLblToErrorMessage(jLblMessage, ex.toString());
            } 
            formWindowOpened(null);
        }
    }//GEN-LAST:event_jBtnRentActionPerformed

    private void jBtnGiveBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGiveBackActionPerformed
        int answer = JOptionPane.showConfirmDialog(this, Configurator.getInternationlizedText("givebackquestion"));
        if (answer == 0) {
            String id = jTblUnit.getValueAt(jTblUnit.getSelectedRow(), 0).toString();
            try {
                Unit mine = Unit.findBy(Integer.parseInt(id));
                mine.rented_date = null;
                mine.rented_to = null;
                Unit.updateForRent(mine);
            } catch (SQLException ex) {
                Logger.getLogger(NewContainer.class.getName()).log(Level.SEVERE, null, ex);
                SwingUtil.setupJLblToErrorMessage(jLblMessage, ex.toString());
            } catch (Exception ex) {
                Logger.getLogger(NewContainer.class.getName()).log(Level.SEVERE, null, ex);
                SwingUtil.setupJLblToErrorMessage(jLblMessage, ex.toString());
            }
            formWindowOpened(null);
        }
    }//GEN-LAST:event_jBtnGiveBackActionPerformed

    private final String stateOf(final Unit unit) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        if (unit.rented_to != null) {
            return " <font color='blue'>(" + Configurator.getInternationlizedText("rented.to") + " " + unit.rented_to + " " + sdf.format(unit.rented_date) + ")</font> ";
        } else {
            return "";
        }
    }

    private void jTblUnitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblUnitMouseClicked
        try {
            Unit unit = Unit.findBy(new Integer(getjTblUnit().getValueAt(getjTblUnit().getSelectedRow(), 0).toString()));
            boolean hasContainer = false;
            try {
                unit = Unit.findUnitWithinContainerBy(new Integer(getjTblUnit().getValueAt(getjTblUnit().getSelectedRow(), 0).toString()));
                hasContainer = true;
            } catch (SQLException sQLException) {
                unit = Unit.findBy(new Integer(getjTblUnit().getValueAt(getjTblUnit().getSelectedRow(), 0).toString()));
            }
            String state = stateOf(unit);
            if (hasContainer) {
                String fullPath = Container.giveMeFullAdresOf(Container.findBy(unit.id_container));
                jLblMessage.setText("<html>" + fullPath + " >> " + unit.name + state + "</html>");
            } else {
                jLblMessage.setText("<html>" + unit.name + state + "</html>");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FileSearching.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FileSearching.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTblUnitMouseClicked

    private void jBtnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPrintActionPerformed
        try {
            jTblUnit.print();
        } catch (PrinterException ex) {
            Logger.getLogger(SearchUnit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBtnPrintActionPerformed

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
    private javax.swing.JButton jBtnGiveBack;
    private javax.swing.JButton jBtnNew;
    private javax.swing.JButton jBtnPrint;
    private javax.swing.JButton jBtnRent;
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

    /**
     * @return the newUnit
     */
    public NewUnit getNewUnit() {
        return newUnit;
    }

    /**
     * @param newUnit the newUnit to set
     */
    public void setNewUnit(NewUnit newUnit) {
        this.newUnit = newUnit;
    }

    private void fillEditForm(Unit unit) {
        newUnit.getjTabPanel().setSelectedIndex(0);
        if (Unit.hasParent(unit)) {
            Container parent = null;
            try {
                parent = Unit.findParentBy(unit);
            } catch (SQLException ex) {
                Logger.getLogger(SearchUnit.class.getName()).log(Level.SEVERE, null, ex);
            }
            newUnit.getjChk().setSelected(true);
            newUnit.getjTxtBind().setText(parent.id + " - " + parent.description);
        } else {
            newUnit.getjChk().setSelected(false);
            newUnit.getjTxtBind().setText("");
        }
        newUnit.getjTxtName().setText(unit.name);
        newUnit.getjTxtTerm().setText("");
        newUnit.getjCboType().setSelectedItem(unit.type);
    }

    /**
     * @return the jBtnGiveBack
     */
    public javax.swing.JButton getjBtnGiveBack() {
        return jBtnGiveBack;
    }

    /**
     * @return the jBtnRent
     */
    public javax.swing.JButton getjBtnRent() {
        return jBtnRent;
    }
}
