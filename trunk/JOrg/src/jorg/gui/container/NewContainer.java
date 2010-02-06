package jorg.gui.container;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jorg.gui.SwingUtil;
import jorg.gui.config.Configurator;
import jorgcore.entity.Container;

public class NewContainer extends javax.swing.JFrame {

    private SearchContainer search;

    public NewContainer(SearchContainer search) {
        this.search = search;
        initComponents();
    }

    public NewContainer() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLblContainerNewInfo = new javax.swing.JLabel();
        jTabPanel = new javax.swing.JTabbedPane();
        jPnContainerNew = new javax.swing.JPanel();
        jCheckIsRoot = new javax.swing.JCheckBox();
        jLblContainerParent = new javax.swing.JLabel();
        jTxtParent = new javax.swing.JTextField();
        jLblDescription = new javax.swing.JLabel();
        jTxtDescription = new javax.swing.JTextField();
        jBtnSave = new javax.swing.JButton();
        jBtnBack = new javax.swing.JButton();
        jPnContainerChooseParent = new javax.swing.JPanel();
        jLblSearchText = new javax.swing.JLabel();
        jTxtTerm = new javax.swing.JTextField();
        jBtnSearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblContainer = new javax.swing.JTable();
        jBtnSelect = new javax.swing.JButton();
        jLblMessage = new javax.swing.JLabel();

        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLblContainerNewInfo.setFont(new java.awt.Font("Tahoma", 0, 32));
        jLblContainerNewInfo.setForeground(new java.awt.Color(51, 51, 255));
        jLblContainerNewInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblContainerNewInfo.setText("Create New Container");
        jLblContainerNewInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jCheckIsRoot.setSelected(true);
        jCheckIsRoot.setText("Root container");
        jCheckIsRoot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckIsRootActionPerformed(evt);
            }
        });

        jLblContainerParent.setText("Parent to this container:");

        jTxtParent.setEditable(false);
        jTxtParent.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLblDescription.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLblDescription.setText("Description:");

        jTxtDescription.setHorizontalAlignment(javax.swing.JTextField.CENTER);

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

        javax.swing.GroupLayout jPnContainerNewLayout = new javax.swing.GroupLayout(jPnContainerNew);
        jPnContainerNew.setLayout(jPnContainerNewLayout);
        jPnContainerNewLayout.setHorizontalGroup(
            jPnContainerNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnContainerNewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPnContainerNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jCheckIsRoot, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLblDescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLblContainerParent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPnContainerNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTxtParent, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                    .addComponent(jTxtDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPnContainerNewLayout.createSequentialGroup()
                        .addComponent(jBtnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPnContainerNewLayout.setVerticalGroup(
            jPnContainerNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnContainerNewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCheckIsRoot)
                .addGap(18, 18, 18)
                .addGroup(jPnContainerNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblContainerParent)
                    .addComponent(jTxtParent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPnContainerNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblDescription)
                    .addComponent(jTxtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPnContainerNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnSave)
                    .addComponent(jBtnBack))
                .addContainerGap(108, Short.MAX_VALUE))
        );

        jTabPanel.addTab("New Container", jPnContainerNew);

        jLblSearchText.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLblSearchText.setText("Search by description:");

        jTxtTerm.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jBtnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/Zoom24.gif"))); // NOI18N
        jBtnSearch.setText("Search");
        jBtnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSearchActionPerformed(evt);
            }
        });

        jTblContainer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTblContainer);

        jBtnSelect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jorg/gui/picture/Open24.gif"))); // NOI18N
        jBtnSelect.setText("Select");
        jBtnSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSelectActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPnContainerChooseParentLayout = new javax.swing.GroupLayout(jPnContainerChooseParent);
        jPnContainerChooseParent.setLayout(jPnContainerChooseParentLayout);
        jPnContainerChooseParentLayout.setHorizontalGroup(
            jPnContainerChooseParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnContainerChooseParentLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPnContainerChooseParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
                    .addComponent(jBtnSelect, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPnContainerChooseParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnContainerChooseParentLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLblSearchText)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jTxtTerm, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jBtnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        jPnContainerChooseParentLayout.setVerticalGroup(
            jPnContainerChooseParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnContainerChooseParentLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnSelect)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPnContainerChooseParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPnContainerChooseParentLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPnContainerChooseParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLblSearchText)
                        .addComponent(jTxtTerm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBtnSearch))
                    .addGap(309, 309, 309)))
        );

        jTabPanel.addTab("Chose a parent", jPnContainerChooseParent);

        jLblMessage.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLblMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblMessage.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLblMessage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
                    .addComponent(jTabPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
                    .addComponent(jLblContainerNewInfo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLblContainerNewInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLblMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        getjPnContainerChooseParent().setVisible(false);
    }//GEN-LAST:event_formWindowGainedFocus

    public void setInfoTitle(final String key) {
        getjLblContainerNewInfo().setText(Configurator.getInternationlizedText(key));
    }

    private void jBtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSearchActionPerformed
        if (!jTxtTerm.getText().equals("")) {
            try {
                String term = jTxtTerm.getText();
                if (!term.contains("*")){
                    term = "*" + term + "*";
                }
                SwingUtil.resetMessage(getjLblMessage());
                Container.begin();
                List<Container> set = Container.findBy(term);
                Iterator<Container> it = set.iterator();
                SwingUtil.populateJTableContainer(getjTblContainer(), set.size(), it);
            } catch (SQLException ex) {
                Logger.getLogger(SearchContainer.class.getName()).log(Level.SEVERE, null, ex);
                SwingUtil.setupJLblToErrorMessage(getjLblMessage(), ex.toString());
            } catch (Exception ex) {
                Logger.getLogger(SearchContainer.class.getName()).log(Level.SEVERE, null, ex);
                SwingUtil.setupJLblToErrorMessage(getjLblMessage(), ex.toString());
            } finally {
                try {
                    Container.commit();
                } catch (SQLException ex) {
                    Logger.getLogger(SearchContainer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
}//GEN-LAST:event_jBtnSearchActionPerformed

    private void jBtnSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSelectActionPerformed
        String idSelected = getjTblContainer().getValueAt(getjTblContainer().getSelectedRow(), 0).toString();
        String description = getjTblContainer().getValueAt(getjTblContainer().getSelectedRow(), 1).toString();
        getjTxtParent().setText(idSelected + " - " + description);
        getjTabPanel().setSelectedIndex(0);
    }//GEN-LAST:event_jBtnSelectActionPerformed

    private void jBtnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSaveActionPerformed
        SwingUtil.resetMessage(getjLblMessage());
        if (insertMode) {
            insert();
        } else {
            update();
        }
    }//GEN-LAST:event_jBtnSaveActionPerformed

    private void jCheckIsRootActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckIsRootActionPerformed
        if (!jCheckIsRoot.isSelected()) {
            getjTabPanel().setSelectedIndex(1);
        }else{
            jTxtParent.setText("");
        }
    }//GEN-LAST:event_jCheckIsRootActionPerformed

    private void jBtnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnBackActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jBtnBackActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try{
                Container.begin();
                List<Container> set = Container.findAll();
                Iterator<Container> it = set.iterator();
                SwingUtil.populateJTableContainer(getjTblContainer(), set.size(), it);
            } catch (SQLException ex) {
                Logger.getLogger(SearchContainer.class.getName()).log(Level.SEVERE, null, ex);
                SwingUtil.setupJLblToErrorMessage(getjLblMessage(), ex.toString());
            } catch (Exception ex) {
                Logger.getLogger(SearchContainer.class.getName()).log(Level.SEVERE, null, ex);
                SwingUtil.setupJLblToErrorMessage(getjLblMessage(), ex.toString());
            } finally {
                try {
                    Container.commit();
                } catch (SQLException ex) {
                    Logger.getLogger(SearchContainer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }//GEN-LAST:event_formWindowActivated

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new NewContainer().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnBack;
    private javax.swing.JButton jBtnSave;
    private javax.swing.JButton jBtnSearch;
    private javax.swing.JButton jBtnSelect;
    private javax.swing.JCheckBox jCheckIsRoot;
    private javax.swing.JLabel jLblContainerNewInfo;
    private javax.swing.JLabel jLblContainerParent;
    private javax.swing.JLabel jLblDescription;
    private javax.swing.JLabel jLblMessage;
    private javax.swing.JLabel jLblSearchText;
    private javax.swing.JPanel jPnContainerChooseParent;
    private javax.swing.JPanel jPnContainerNew;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabPanel;
    private javax.swing.JTable jTblContainer;
    private javax.swing.JTextField jTxtDescription;
    private javax.swing.JTextField jTxtParent;
    private javax.swing.JTextField jTxtTerm;
    // End of variables declaration//GEN-END:variables

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
     * @return the jCheckIsRoot
     */
    public javax.swing.JCheckBox getjCheckIsRoot() {
        return jCheckIsRoot;
    }

    /**
     * @param jCheckIsRoot the jCheckIsRoot to set
     */
    public void setjCheckIsRoot(javax.swing.JCheckBox jCheckIsRoot) {
        this.jCheckIsRoot = jCheckIsRoot;
    }

    /**
     * @return the jLblContainerNewInfo
     */
    public javax.swing.JLabel getjLblContainerNewInfo() {
        return jLblContainerNewInfo;
    }

    /**
     * @param jLblContainerNewInfo the jLblContainerNewInfo to set
     */
    public void setjLblContainerNewInfo(javax.swing.JLabel jLblContainerNewInfo) {
        this.jLblContainerNewInfo = jLblContainerNewInfo;
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
     * @return the jLblDescription
     */
    public javax.swing.JLabel getjLblDescription() {
        return jLblDescription;
    }

    /**
     * @param jLblDescription the jLblDescription to set
     */
    public void setjLblDescription(javax.swing.JLabel jLblDescription) {
        this.jLblDescription = jLblDescription;
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
     * @return the jPnContainerChooseParent
     */
    public javax.swing.JPanel getjPnContainerChooseParent() {
        return jPnContainerChooseParent;
    }

    /**
     * @param jPnContainerChooseParent the jPnContainerChooseParent to set
     */
    public void setjPnContainerChooseParent(javax.swing.JPanel jPnContainerChooseParent) {
        this.jPnContainerChooseParent = jPnContainerChooseParent;
    }

    /**
     * @return the jPnContainerNew
     */
    public javax.swing.JPanel getjPnContainerNew() {
        return jPnContainerNew;
    }

    /**
     * @param jPnContainerNew the jPnContainerNew to set
     */
    public void setjPnContainerNew(javax.swing.JPanel jPnContainerNew) {
        this.jPnContainerNew = jPnContainerNew;
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
     * @return the jTblContainer
     */
    public javax.swing.JTable getjTblContainer() {
        return jTblContainer;
    }

    /**
     * @param jTblContainer the jTblContainer to set
     */
    public void setjTblContainer(javax.swing.JTable jTblContainer) {
        this.jTblContainer = jTblContainer;
    }

    /**
     * @return the jTxtDescription
     */
    public javax.swing.JTextField getjTxtDescription() {
        return jTxtDescription;
    }

    /**
     * @param jTxtDescription the jTxtDescription to set
     */
    public void setjTxtDescription(javax.swing.JTextField jTxtDescription) {
        this.jTxtDescription = jTxtDescription;
    }

    /**
     * @return the jTxtParent
     */
    public javax.swing.JTextField getjTxtParent() {
        return jTxtParent;
    }

    /**
     * @param jTxtParent the jTxtParent to set
     */
    public void setjTxtParent(javax.swing.JTextField jTxtParent) {
        this.jTxtParent = jTxtParent;
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
     * @return the jBtnBack
     */
    public javax.swing.JButton getjBtnBack() {
        return jBtnBack;
    }

    private void goBack() {
        try {
            Container.begin();
            Iterator<Container> it = Container.findAll().iterator();
            SwingUtil.populateJTableContainer(getSearch().getjTblContainer(), Container.count(), it);
            setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(SearchContainer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                pack();
                Container.commit();
            } catch (SQLException ex) {
                Logger.getLogger(SearchContainer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * @return the search
     */
    public SearchContainer getSearch() {
        return search;
    }

    /**
     * @param search the search to set
     */
    public void setSearch(SearchContainer search) {
        this.search = search;
    }

    /**
     * @param jBtnBack the jBtnBack to set
     */
    public void setjBtnBack(javax.swing.JButton jBtnBack) {
        this.jBtnBack = jBtnBack;
    }
    private int id;

    public void setEditedId(int id) {
        this.id = id;
    }
    private boolean insertMode;

    public void setInsertableMode(boolean b) {
        insertMode = b;
    }

    private void insert() {
        if (getjCheckIsRoot().isSelected()) {
            if (getjTxtDescription().getText().trim().equals("")) {
                SwingUtil.setupJLblToInfoMessage(getjLblMessage(), SwingUtil.getInternationalizedText("description.required"));
                return;
            }
            try {
                Container.begin();
                Container newContainer = new Container();
                newContainer.description = getjTxtDescription().getText().trim();
                Container.insert(newContainer);
            } catch (SQLException ex) {
                Logger.getLogger(NewContainer.class.getName()).log(Level.SEVERE, null, ex);
                SwingUtil.setupJLblToErrorMessage(getjLblMessage(), ex.toString());
            } catch (Exception ex) {
                Logger.getLogger(NewContainer.class.getName()).log(Level.SEVERE, null, ex);
                SwingUtil.setupJLblToErrorMessage(getjLblMessage(), ex.toString());
            } finally {
                try {
                    Container.commit();
                } catch (SQLException ex) {
                    Logger.getLogger(NewContainer.class.getName()).log(Level.SEVERE, null, ex);
                    SwingUtil.setupJLblToErrorMessage(getjLblMessage(), ex.toString());
                }
            }

        } else {
            if (getjTxtDescription().getText().trim().equals("")) {
                SwingUtil.setupJLblToInfoMessage(getjLblMessage(), SwingUtil.getInternationalizedText("description.required"));
                return;
            }
            if (getjTxtParent().getText().trim().equals("")) {
                SwingUtil.setupJLblToInfoMessage(getjLblMessage(), SwingUtil.getInternationalizedText("parent.required"));
                return;
            }
            try {
                Container.begin();
                Container newContainer = new Container();
                newContainer.description = getjTxtDescription().getText().trim();
                int id_pai = new Integer(getjTxtParent().getText().split("-")[0].trim());
                Container.insert(newContainer, id_pai);
            } catch (SQLException ex) {
                Logger.getLogger(NewContainer.class.getName()).log(Level.SEVERE, null, ex);
                SwingUtil.setupJLblToErrorMessage(getjLblMessage(), ex.toString());
            } catch (Exception ex) {
                Logger.getLogger(NewContainer.class.getName()).log(Level.SEVERE, null, ex);
                SwingUtil.setupJLblToErrorMessage(getjLblMessage(), ex.toString());
            } finally {
                try {
                    Container.commit();
                } catch (SQLException ex) {
                    Logger.getLogger(NewContainer.class.getName()).log(Level.SEVERE, null, ex);
                    SwingUtil.setupJLblToErrorMessage(getjLblMessage(), ex.toString());
                }
            }
        }
        goBack();
    }

    private void update() {
        if (getjCheckIsRoot().isSelected()) {
            if (getjTxtDescription().getText().trim().equals("")) {
                SwingUtil.setupJLblToInfoMessage(getjLblMessage(), SwingUtil.getInternationalizedText("description.required"));
                return;
            }
            try {
                Container.begin();
                Container editedContainer = Container.findBy(id);
                editedContainer.description = getjTxtDescription().getText().trim();
                Container.becomeRoot(editedContainer);
                Container.update(editedContainer);
            } catch (SQLException ex) {
                Logger.getLogger(NewContainer.class.getName()).log(Level.SEVERE, null, ex);
                SwingUtil.setupJLblToErrorMessage(getjLblMessage(), ex.toString());
            } catch (Exception ex) {
                Logger.getLogger(NewContainer.class.getName()).log(Level.SEVERE, null, ex);
                SwingUtil.setupJLblToErrorMessage(getjLblMessage(), ex.toString());
            } finally {
                try {
                    Container.commit();
                } catch (SQLException ex) {
                    Logger.getLogger(NewContainer.class.getName()).log(Level.SEVERE, null, ex);
                    SwingUtil.setupJLblToErrorMessage(getjLblMessage(), ex.toString());
                }
            }

        } else {
            if (getjTxtDescription().getText().trim().equals("")) {
                SwingUtil.setupJLblToInfoMessage(getjLblMessage(), SwingUtil.getInternationalizedText("description.required"));
                return;
            }
            if (getjTxtParent().getText().trim().equals("")) {
                SwingUtil.setupJLblToInfoMessage(getjLblMessage(), SwingUtil.getInternationalizedText("parent.required"));
                return;
            }
            try {
                Container.begin();
                Container editedContainer = Container.findBy(id);
                editedContainer.description = getjTxtDescription().getText().trim();
                int id_pai = new Integer(getjTxtParent().getText().split("-")[0].trim());
                Container.update(editedContainer, id_pai);
            } catch (SQLException ex) {
                Logger.getLogger(NewContainer.class.getName()).log(Level.SEVERE, null, ex);
                SwingUtil.setupJLblToErrorMessage(getjLblMessage(), ex.toString());
            } catch (Exception ex) {
                Logger.getLogger(NewContainer.class.getName()).log(Level.SEVERE, null, ex);
                SwingUtil.setupJLblToErrorMessage(getjLblMessage(), ex.toString());
            } finally {
                try {
                    Container.commit();
                } catch (SQLException ex) {
                    Logger.getLogger(NewContainer.class.getName()).log(Level.SEVERE, null, ex);
                    SwingUtil.setupJLblToErrorMessage(getjLblMessage(), ex.toString());
                }
            }
        }
        goBack();
    }
}
