package jorg.gui.statistics;

import java.util.Date;
import javax.swing.JOptionPane;
import jorg.gui.config.Configurator;
import jorg.importation.FileToCVS;
import jorg.importation.ProgressListener;

public class Statistics extends javax.swing.JFrame {

    private Date olderDate, newerDate;
    private StatisticManager statistic = new StatisticManager(this);

    public Statistics() {
        initComponents();
    }

    public void updateInfo(String value){
        getjLblInfo().setText(Configurator.getInternationlizedText("statistics.calculating")+": "+value+"...");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabGroup = new javax.swing.JTabbedPane();
        jPnNew = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtxtAreaGeneral = new javax.swing.JTextArea();
        jPnGrouping = new javax.swing.JPanel();
        jPnTopExtension = new javax.swing.JPanel();
        jLblInfo = new javax.swing.JLabel();
        jPrgStatistics = new javax.swing.JProgressBar();

        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jtxtAreaGeneral.setColumns(20);
        jtxtAreaGeneral.setFont(new java.awt.Font("Trebuchet MS", 1, 18));
        jtxtAreaGeneral.setForeground(new java.awt.Color(153, 0, 51));
        jtxtAreaGeneral.setRows(5);
        jScrollPane1.setViewportView(jtxtAreaGeneral);

        javax.swing.GroupLayout jPnNewLayout = new javax.swing.GroupLayout(jPnNew);
        jPnNew.setLayout(jPnNewLayout);
        jPnNewLayout.setHorizontalGroup(
            jPnNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnNewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPnNewLayout.setVerticalGroup(
            jPnNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPnNewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabGroup.addTab("General", jPnNew);

        javax.swing.GroupLayout jPnGroupingLayout = new javax.swing.GroupLayout(jPnGrouping);
        jPnGrouping.setLayout(jPnGroupingLayout);
        jPnGroupingLayout.setHorizontalGroup(
            jPnGroupingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 880, Short.MAX_VALUE)
        );
        jPnGroupingLayout.setVerticalGroup(
            jPnGroupingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 379, Short.MAX_VALUE)
        );

        jTabGroup.addTab("Grouping", jPnGrouping);

        javax.swing.GroupLayout jPnTopExtensionLayout = new javax.swing.GroupLayout(jPnTopExtension);
        jPnTopExtension.setLayout(jPnTopExtensionLayout);
        jPnTopExtensionLayout.setHorizontalGroup(
            jPnTopExtensionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 880, Short.MAX_VALUE)
        );
        jPnTopExtensionLayout.setVerticalGroup(
            jPnTopExtensionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 379, Short.MAX_VALUE)
        );

        jTabGroup.addTab("Top 10 extensions", jPnTopExtension);

        jLblInfo.setFont(new java.awt.Font("Tahoma", 0, 32));
        jLblInfo.setForeground(new java.awt.Color(51, 51, 255));
        jLblInfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblInfo.setText("Statistics");
        jLblInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPrgStatistics, javax.swing.GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE)
                    .addComponent(jTabGroup, javax.swing.GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE)
                    .addComponent(jLblInfo, javax.swing.GroupLayout.DEFAULT_SIZE, 885, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLblInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPrgStatistics, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        try {
            new Thread(statistic, "T-StatisticManager").start();
        } catch (Exception ex) {
            getJtxtAreaGeneral().setText(ex.toString());
        }
    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    }//GEN-LAST:event_formWindowOpened

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Statistics().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLblInfo;
    private javax.swing.JPanel jPnGrouping;
    private javax.swing.JPanel jPnNew;
    private javax.swing.JPanel jPnTopExtension;
    private javax.swing.JProgressBar jPrgStatistics;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabGroup;
    private javax.swing.JTextArea jtxtAreaGeneral;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the olderDate
     */
    public Date getOlderDate() {
        return olderDate;
    }

    /**
     * @param olderDate the olderDate to set
     */
    public void setOlderDate(Date olderDate) {
        this.olderDate = olderDate;
    }

    /**
     * @return the newerDate
     */
    public Date getNewerDate() {
        return newerDate;
    }

    /**
     * @param newerDate the newerDate to set
     */
    public void setNewerDate(Date newerDate) {
        this.newerDate = newerDate;
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
     * @return the jPrgStatistics
     */
    public javax.swing.JProgressBar getjPrgStatistics() {
        return jPrgStatistics;
    }

    /**
     * @param jPrgStatistics the jPrgStatistics to set
     */
    public void setjPrgStatistics(javax.swing.JProgressBar jPrgStatistics) {
        this.jPrgStatistics = jPrgStatistics;
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
        return jTabGroup;
    }

    /**
     * @param jTabPanel the jTabPanel to set
     */
    public void setjTabPanel(javax.swing.JTabbedPane jTabPanel) {
        this.jTabGroup = jTabPanel;
    }

    /**
     * @return the jtxtAreaGeneral
     */
    public javax.swing.JTextArea getJtxtAreaGeneral() {
        return jtxtAreaGeneral;
    }

    /**
     * @param jtxtAreaGeneral the jtxtAreaGeneral to set
     */
    public void setJtxtAreaGeneral(javax.swing.JTextArea jtxtAreaGeneral) {
        this.jtxtAreaGeneral = jtxtAreaGeneral;
    }
}
