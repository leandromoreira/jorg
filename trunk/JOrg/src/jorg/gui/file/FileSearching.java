package jorg.gui.file;

import java.io.IOException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import jorg.gui.Main;
import jorg.gui.SwingUtil;
import jorg.gui.config.Configurator;
import jorg.indexing.LuceneSearcher;
import jorgcore.entity.File;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.queryParser.ParseException;

public class FileSearching extends javax.swing.JFrame {

    public FileSearching() {
        initComponents();
    }
    private Main delegate;

    public FileSearching(Main main) {
        this();
        delegate = main;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLblMessage = new javax.swing.JLabel();
        jLblInfo = new javax.swing.JLabel();
        jTxtSearch = new javax.swing.JTextField();
        jBtnSearch = new javax.swing.JButton();
        jLblSearchingFor = new javax.swing.JLabel();
        jLblWithExtension = new javax.swing.JLabel();
        jTxtExtension = new javax.swing.JTextField();
        jTxtMin = new javax.swing.JTextField();
        jLblWithMinSize = new javax.swing.JLabel();
        jTxtMax = new javax.swing.JTextField();
        jLblWithMaxSize = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblFile = new javax.swing.JTable();

        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLblMessage.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLblMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblMessage.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLblInfo.setFont(new java.awt.Font("Tahoma", 0, 32)); // NOI18N
        jLblInfo.setForeground(new java.awt.Color(51, 51, 255));
        jLblInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblInfo.setText("File Searching");
        jLblInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jBtnSearch.setText("Search");
        jBtnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSearchActionPerformed(evt);
            }
        });

        jLblSearchingFor.setText("Searching for...");

        jLblWithExtension.setText("With extension");

        jTxtExtension.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxtExtension.setText("Any");

        jTxtMin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxtMin.setText("Any");

        jLblWithMinSize.setText("With min. size");

        jTxtMax.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTxtMax.setText("Any");

        jLblWithMaxSize.setText("With max. size");

        jTblFile.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTblFile);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLblMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
                    .addComponent(jLblInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 716, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
                            .addComponent(jLblSearchingFor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jTxtExtension, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLblWithExtension))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTxtMin)
                            .addComponent(jLblWithMinSize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTxtMax, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLblWithMaxSize, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBtnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLblInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblWithExtension)
                    .addComponent(jLblWithMinSize)
                    .addComponent(jLblWithMaxSize)
                    .addComponent(jLblSearchingFor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTxtExtension, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnSearch)
                    .addComponent(jTxtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        /*getjCboLocation().setModel(new javax.swing.DefaultComboBoxModel(FileManager.getDrives()));

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
        }*/
    }//GEN-LAST:event_formWindowActivated

    private final void validate(final String fieldsToSwho) {
        //name,path,size,size_in_bytes,date_last_modified,time_last_modified
    }

    private void jBtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSearchActionPerformed
        String query = jTxtSearch.getText();
        jLblMessage.setText("");
        try {
            int[] ids = LuceneSearcher.search(query);
            Collection<File> files = File.listBy(ids, null);
            SwingUtil.populateJTableFile(jTblFile, files.size(), files.iterator());
        } catch (CorruptIndexException ex) {
            Logger.getLogger(FileSearching.class.getName()).log(Level.SEVERE, null, ex);
            jLblMessage.setText(reduce("Index corrupted! " + ex));
        } catch (IOException ex) {
            Logger.getLogger(FileSearching.class.getName()).log(Level.SEVERE, null, ex);
            jLblMessage.setText(reduce("IO exception! " + ex));
        } catch (ParseException ex) {
            Logger.getLogger(FileSearching.class.getName()).log(Level.SEVERE, null, ex);
            jLblMessage.setText(reduce("Parse exception! " + ex));
        } catch (Exception ex) {
            Logger.getLogger(FileSearching.class.getName()).log(Level.SEVERE, null, ex);
            jLblMessage.setText(reduce("General Exception! " + ex));
        }
    }//GEN-LAST:event_jBtnSearchActionPerformed

    private String reduce(String value) {
        return (value.length() > 85) ? value.substring(0, 85) : value;
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new FileSearching().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnSearch;
    private javax.swing.JLabel jLblInfo;
    private javax.swing.JLabel jLblMessage;
    private javax.swing.JLabel jLblSearchingFor;
    private javax.swing.JLabel jLblWithExtension;
    private javax.swing.JLabel jLblWithMaxSize;
    private javax.swing.JLabel jLblWithMinSize;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTblFile;
    private javax.swing.JTextField jTxtExtension;
    private javax.swing.JTextField jTxtMax;
    private javax.swing.JTextField jTxtMin;
    private javax.swing.JTextField jTxtSearch;
    // End of variables declaration//GEN-END:variables
}
