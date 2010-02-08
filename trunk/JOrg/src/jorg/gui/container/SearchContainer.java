package jorg.gui.container;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jorg.gui.SwingUtil;
import jorg.gui.config.Configurator;
import jorgcore.entity.Container;

public class SearchContainer extends javax.swing.JFrame {

    private NewContainer newContainer = new NewContainer(this);

    public SearchContainer() {
        newContainer.getRootPane().setDefaultButton(newContainer.getjBtnSearch());
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLblContainerInfo = new javax.swing.JLabel();
        jLblSearchText = new javax.swing.JLabel();
        jBtnSearch = new javax.swing.JButton();
        jTxtTerm = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblContainer = new javax.swing.JTable();
        jLblContainerTip = new javax.swing.JLabel();
        jBtnContainerNew = new javax.swing.JButton();
        jBtnContainerEdit = new javax.swing.JButton();
        jBtnContainerDelete = new javax.swing.JButton();
        jBtnContainerBack = new javax.swing.JButton();
        jLblMessage = new javax.swing.JLabel();
        jBtnShow = new javax.swing.JButton();

        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLblContainerInfo.setFont(new java.awt.Font("Tahoma", 0, 32));
        jLblContainerInfo.setForeground(new java.awt.Color(51, 51, 255));
        jLblContainerInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblContainerInfo.setText("Container Central");
        jLblContainerInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLblSearchText.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLblSearchText.setText("Search by description:");

        jBtnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/Zoom24.gif"))); // NOI18N
        jBtnSearch.setText("Search");
        jBtnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSearchActionPerformed(evt);
            }
        });

        jTxtTerm.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jTblContainer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTblContainer);

        jLblContainerTip.setForeground(new java.awt.Color(0, 51, 204));
        jLblContainerTip.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblContainerTip.setText("Tip: Try to search using * operator as wildchar. (ex: find anything which starts with pic: pic*)");

        jBtnContainerNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/Add24.gif"))); // NOI18N
        jBtnContainerNew.setText("Create New");
        jBtnContainerNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnContainerNewActionPerformed(evt);
            }
        });

        jBtnContainerEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/Edit24.gif"))); // NOI18N
        jBtnContainerEdit.setText("Edit");
        jBtnContainerEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnContainerEditActionPerformed(evt);
            }
        });

        jBtnContainerDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/Delete24.gif"))); // NOI18N
        jBtnContainerDelete.setText("Delete");
        jBtnContainerDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnContainerDeleteActionPerformed(evt);
            }
        });

        jBtnContainerBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/Rewind24.gif"))); // NOI18N
        jBtnContainerBack.setText("Back");
        jBtnContainerBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnContainerBackActionPerformed(evt);
            }
        });

        jLblMessage.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLblMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblMessage.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBtnShow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/Search24.gif"))); // NOI18N
        jBtnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnShowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLblMessage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
                    .addComponent(jLblContainerInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLblSearchText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtTerm, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLblContainerTip, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 669, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jBtnContainerNew, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnContainerEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnContainerDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnContainerBack, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(jBtnShow)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLblContainerInfo)
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
                    .addComponent(jBtnContainerNew)
                    .addComponent(jBtnContainerEdit)
                    .addComponent(jBtnContainerDelete)
                    .addComponent(jBtnContainerBack)
                    .addComponent(jBtnShow))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLblMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnContainerBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnContainerBackActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jBtnContainerBackActionPerformed

    private void jBtnContainerEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnContainerEditActionPerformed
        SwingUtil.resetMessage(jLblMessage);
        int id = new Integer(jTblContainer.getValueAt(jTblContainer.getSelectedRow(), 0).toString());
        SwingUtil.resetMessage(jLblMessage);
        SwingUtil.center(newContainer);
        newContainer.setInfoTitle("container.title.edit");
        try {
            fillEditForm(Container.findBy(id));
            newContainer.setEditedId(id);
            newContainer.setInsertableMode(false);
            newContainer.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(SearchContainer.class.getName()).log(Level.SEVERE, null, ex);
            SwingUtil.setupJLblToErrorMessage(jLblMessage, ex.toString());
        }
    }//GEN-LAST:event_jBtnContainerEditActionPerformed

    private void jBtnContainerNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnContainerNewActionPerformed
        SwingUtil.resetMessage(jLblMessage);
        SwingUtil.center(newContainer);
        newContainer.setInsertableMode(true);
        newContainer.setInfoTitle("container.new");
        newContainer.getjTabPanel().setSelectedIndex(0);
        newContainer.getjCheckIsRoot().setSelected(true);
        newContainer.getjTxtParent().setText("");
        newContainer.getjTxtDescription().setText("");
        newContainer.getjTxtTerm().setText("");
        newContainer.setVisible(true);
    }//GEN-LAST:event_jBtnContainerNewActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        SwingUtil.resetMessage(jLblMessage);
        try {
            Iterator<Container> it = Container.findAll().iterator();
            SwingUtil.populateJTableContainer(jTblContainer, Container.count(), it);
        } catch (SQLException ex) {
            Logger.getLogger(SearchContainer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            pack();
        }
    }//GEN-LAST:event_formWindowOpened

    private void jBtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSearchActionPerformed
        if (!jTxtTerm.getText().equals("")) {
            try {
                String term = jTxtTerm.getText();
                if (!term.contains("*")) {
                    term = "*" + term + "*";
                }
                SwingUtil.resetMessage(jLblMessage);
                List<Container> set = Container.findBy(term);
                Iterator<Container> it = set.iterator();
                SwingUtil.populateJTableContainer(jTblContainer, set.size(), it);
            } catch (SQLException ex) {
                Logger.getLogger(SearchContainer.class.getName()).log(Level.SEVERE, null, ex);
                SwingUtil.setupJLblToErrorMessage(jLblMessage, ex.toString());
            } catch (Exception ex) {
                Logger.getLogger(SearchContainer.class.getName()).log(Level.SEVERE, null, ex);
                SwingUtil.setupJLblToErrorMessage(jLblMessage, ex.toString());
            } 
        }
    }//GEN-LAST:event_jBtnSearchActionPerformed

    private void jBtnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnShowActionPerformed
        String trees = "";
        SwingUtil.resetMessage(jLblMessage);
        try {
            String id = jTblContainer.getValueAt(jTblContainer.getSelectedRow(), 0).toString();
            trees = (Container.giveMeFullAdresOf(Container.findBy(new Integer(id))));
            if (trees.length() > 70) {
                JOptionPane.showMessageDialog(this, trees, Configurator.getInternationlizedText("location"), JOptionPane.INFORMATION_MESSAGE);
            } else {
                SwingUtil.setupJLblToInfoMessage(jLblMessage, trees);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SearchContainer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBtnShowActionPerformed

    private void jBtnContainerDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnContainerDeleteActionPerformed
        int answer = JOptionPane.showConfirmDialog(this, Configurator.getInternationlizedText("deletequestion"));
        if (answer == 0) {
            String id = jTblContainer.getValueAt(jTblContainer.getSelectedRow(), 0).toString();
            try {
                Container.delete(Container.findBy(new Integer(id)));
            } catch (SQLException ex) {
                Logger.getLogger(NewContainer.class.getName()).log(Level.SEVERE, null, ex);
                SwingUtil.setupJLblToErrorMessage(jLblMessage, ex.toString());
            } catch (Exception ex) {
                Logger.getLogger(NewContainer.class.getName()).log(Level.SEVERE, null, ex);
                SwingUtil.setupJLblToErrorMessage(jLblMessage, ex.toString());
            } 
            formWindowOpened(null);
        }
    }//GEN-LAST:event_jBtnContainerDeleteActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new SearchContainer().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnContainerBack;
    private javax.swing.JButton jBtnContainerDelete;
    private javax.swing.JButton jBtnContainerEdit;
    private javax.swing.JButton jBtnContainerNew;
    private javax.swing.JButton jBtnSearch;
    private javax.swing.JButton jBtnShow;
    private javax.swing.JLabel jLblContainerInfo;
    private javax.swing.JLabel jLblContainerTip;
    private javax.swing.JLabel jLblMessage;
    private javax.swing.JLabel jLblSearchText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTblContainer;
    private javax.swing.JTextField jTxtTerm;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the jBtnContainerBack
     */
    public javax.swing.JButton getjBtnContainerBack() {
        return jBtnContainerBack;
    }

    /**
     * @return the jBtnContainerDelete
     */
    public javax.swing.JButton getjBtnContainerDelete() {
        return jBtnContainerDelete;
    }

    /**
     * @return the jBtnContainerEdit
     */
    public javax.swing.JButton getjBtnContainerEdit() {
        return jBtnContainerEdit;
    }

    /**
     * @return the jBtnContainerNew
     */
    public javax.swing.JButton getjBtnContainerNew() {
        return jBtnContainerNew;
    }

    /**
     * @return the jBtnSearch
     */
    public javax.swing.JButton getjBtnSearch() {
        return jBtnSearch;
    }

    /**
     * @return the jLblContainerInfo
     */
    public javax.swing.JLabel getjLblContainerInfo() {
        return jLblContainerInfo;
    }

    /**
     * @return the jLblContainerTip
     */
    public javax.swing.JLabel getjLblContainerTip() {
        return jLblContainerTip;
    }

    /**
     * @return the jLblSearchText
     */
    public javax.swing.JLabel getjLblSearchText() {
        return jLblSearchText;
    }

    /**
     * @return the jScrollPane1
     */
    public javax.swing.JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    /**
     * @return the jTblContainer
     */
    public javax.swing.JTable getjTblContainer() {
        return jTblContainer;
    }

    /**
     * @return the jTxtTerm
     */
    public javax.swing.JTextField getjTxtTerm() {
        return jTxtTerm;
    }

    /**
     * @return the newContainer
     */
    public NewContainer getNewContainer() {
        return newContainer;
    }

    private void fillEditForm(Container container) throws SQLException {
        newContainer.getjTabPanel().setSelectedIndex(0);
        if (Container.hasParent(container.id)) {
            Container parent = Container.findParentBy(container.id);
            newContainer.getjCheckIsRoot().setSelected(false);
            newContainer.getjTxtParent().setText(parent.id + " - " + parent.description);
        } else {
            newContainer.getjCheckIsRoot().setSelected(true);
            newContainer.getjTxtParent().setText("");
        }
        newContainer.getjTxtDescription().setText(container.description);
        newContainer.getjTxtTerm().setText("");
    }
}
