package jorg.gui.file;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jorg.gui.Main;
import jorg.gui.SwingUtil;
import jorg.gui.config.Configurator;
import jorg.indexing.LuceneSearcher;
import jorgcore.entity.Container;
import jorgcore.entity.File;
import jorgcore.entity.Unit;
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

        jLblMessage.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLblMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblMessage.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLblInfo.setFont(new java.awt.Font("Tahoma", 0, 32));
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
        jTblFile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTblFileMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTblFile);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLblMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 953, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 933, Short.MAX_VALUE)
                    .addComponent(jLblInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 933, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
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
        String query = getjTxtSearch().getText();
        getjLblMessage().setText("");
        try {
            int[] ids = LuceneSearcher.search(query);
            Collection<File> files = File.listBy(ids, null);
            files = orderBy(ids, (List<File>) files);
            SwingUtil.populateJTableFile(getjTblFile(), files.size(), files.iterator());
        } catch (CorruptIndexException ex) {
            Logger.getLogger(FileSearching.class.getName()).log(Level.SEVERE, null, ex);
            getjLblMessage().setText(reduce("Index corrupted! " + ex));
        } catch (IOException ex) {
            Logger.getLogger(FileSearching.class.getName()).log(Level.SEVERE, null, ex);
            getjLblMessage().setText(reduce("IO exception! " + ex));
        } catch (ParseException ex) {
            Logger.getLogger(FileSearching.class.getName()).log(Level.SEVERE, null, ex);
            getjLblMessage().setText(reduce("Parse exception! " + ex));
        } catch (Exception ex) {
            Logger.getLogger(FileSearching.class.getName()).log(Level.SEVERE, null, ex);
            getjLblMessage().setText(reduce("General Exception! " + ex));
        }
    }//GEN-LAST:event_jBtnSearchActionPerformed

    private void jTblFileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTblFileMouseClicked
        try {
            File file = File.listBy(Long.parseLong(getjTblFile().getValueAt(getjTblFile().getSelectedRow(), 0).toString()));
            if (file == null) {
                jLblMessage.setText(Configurator.getInternationlizedText("no.unit.linked"));
            } else {
                Unit.begin();
                Unit unit = null;
                boolean hasContainer = false;
                try {
                    unit = Unit.findUnitWithinContainerBy(file.id_unit);
                    hasContainer = true;
                } catch (SQLException sQLException) {
                    unit = Unit.findBy(file.id_unit);
                }
                String state = stateOf(unit);
                if (hasContainer) {
                    Container.begin();
                    String fullPath = Container.giveMeFullAdresOf(Container.findBy(unit.id_container));
                    jLblMessage.setText("<html>"+fullPath + " >> "+ unit.name + state+"</html>");
                }else{
                    jLblMessage.setText("<html>"+unit.name + state+"</html>");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FileSearching.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FileSearching.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jTblFileMouseClicked

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

    /**
     * @return the delegate
     */
    public Main getDelegate() {
        return delegate;
    }

    /**
     * @return the jBtnSearch
     */
    public javax.swing.JButton getjBtnSearch() {
        return jBtnSearch;
    }

    /**
     * @return the jLblInfo
     */
    public javax.swing.JLabel getjLblInfo() {
        return jLblInfo;
    }

    /**
     * @return the jLblMessage
     */
    public javax.swing.JLabel getjLblMessage() {
        return jLblMessage;
    }

    /**
     * @return the jLblSearchingFor
     */
    public javax.swing.JLabel getjLblSearchingFor() {
        return jLblSearchingFor;
    }

    /**
     * @return the jLblWithExtension
     */
    public javax.swing.JLabel getjLblWithExtension() {
        return jLblWithExtension;
    }

    /**
     * @return the jLblWithMaxSize
     */
    public javax.swing.JLabel getjLblWithMaxSize() {
        return jLblWithMaxSize;
    }

    /**
     * @return the jLblWithMinSize
     */
    public javax.swing.JLabel getjLblWithMinSize() {
        return jLblWithMinSize;
    }

    /**
     * @return the jScrollPane1
     */
    public javax.swing.JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    /**
     * @return the jTblFile
     */
    public javax.swing.JTable getjTblFile() {
        return jTblFile;
    }

    /**
     * @return the jTxtExtension
     */
    public javax.swing.JTextField getjTxtExtension() {
        return jTxtExtension;
    }

    /**
     * @return the jTxtMax
     */
    public javax.swing.JTextField getjTxtMax() {
        return jTxtMax;
    }

    /**
     * @return the jTxtMin
     */
    public javax.swing.JTextField getjTxtMin() {
        return jTxtMin;
    }

    /**
     * @return the jTxtSearch
     */
    public javax.swing.JTextField getjTxtSearch() {
        return jTxtSearch;
    }

    /**
     * @param delegate the delegate to set
     */
    public void setDelegate(Main delegate) {
        this.delegate = delegate;
    }

    /**
     * @param jBtnSearch the jBtnSearch to set
     */
    public void setjBtnSearch(javax.swing.JButton jBtnSearch) {
        this.jBtnSearch = jBtnSearch;
    }

    /**
     * @param jLblInfo the jLblInfo to set
     */
    public void setjLblInfo(javax.swing.JLabel jLblInfo) {
        this.jLblInfo = jLblInfo;
    }

    /**
     * @param jLblMessage the jLblMessage to set
     */
    public void setjLblMessage(javax.swing.JLabel jLblMessage) {
        this.jLblMessage = jLblMessage;
    }

    /**
     * @param jLblSearchingFor the jLblSearchingFor to set
     */
    public void setjLblSearchingFor(javax.swing.JLabel jLblSearchingFor) {
        this.jLblSearchingFor = jLblSearchingFor;
    }

    /**
     * @param jLblWithExtension the jLblWithExtension to set
     */
    public void setjLblWithExtension(javax.swing.JLabel jLblWithExtension) {
        this.jLblWithExtension = jLblWithExtension;
    }

    /**
     * @param jLblWithMaxSize the jLblWithMaxSize to set
     */
    public void setjLblWithMaxSize(javax.swing.JLabel jLblWithMaxSize) {
        this.jLblWithMaxSize = jLblWithMaxSize;
    }

    /**
     * @param jLblWithMinSize the jLblWithMinSize to set
     */
    public void setjLblWithMinSize(javax.swing.JLabel jLblWithMinSize) {
        this.jLblWithMinSize = jLblWithMinSize;
    }

    /**
     * @param jScrollPane1 the jScrollPane1 to set
     */
    public void setjScrollPane1(javax.swing.JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    /**
     * @param jTblFile the jTblFile to set
     */
    public void setjTblFile(javax.swing.JTable jTblFile) {
        this.jTblFile = jTblFile;
    }

    /**
     * @param jTxtExtension the jTxtExtension to set
     */
    public void setjTxtExtension(javax.swing.JTextField jTxtExtension) {
        this.jTxtExtension = jTxtExtension;
    }

    /**
     * @param jTxtMax the jTxtMax to set
     */
    public void setjTxtMax(javax.swing.JTextField jTxtMax) {
        this.jTxtMax = jTxtMax;
    }

    /**
     * @param jTxtMin the jTxtMin to set
     */
    public void setjTxtMin(javax.swing.JTextField jTxtMin) {
        this.jTxtMin = jTxtMin;
    }

    /**
     * @param jTxtSearch the jTxtSearch to set
     */
    public void setjTxtSearch(javax.swing.JTextField jTxtSearch) {
        this.jTxtSearch = jTxtSearch;
    }

    private Collection<File> orderBy(int[] ids, List<File> list) {
        Collection<File> newList = new ArrayList<File>();
        for (int id : ids) {
            if (id < 0) {
                break;
            }
            File unit = list.get(list.indexOf(new File().setId(id)));
            newList.add(unit);
        }
        return newList;
    }

    private final String stateOf(final Unit unit) {
        if (unit.rented_to!=null){
            return " <font color='blue'>(" + Configurator.getInternationlizedText("rented.to") + " " + unit.rented_to + ")</font> ";
        }else{
            return "";
        }
    }
}
