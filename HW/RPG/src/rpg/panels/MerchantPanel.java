/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rpg.panels;

import javax.swing.JOptionPane;
import rpg.Equipment;
import rpg.Item;
import rpg.Merchant;
import rpg.Player;

/**
 *
 * @author Nate
 */
public class MerchantPanel extends javax.swing.JPanel {
    Merchant m;
    Player p;
    /**
     * Creates new form MerchantPanel
     */
    public MerchantPanel(Merchant m, Player p) {
        this.m = m;
        this.p = p;initComponents();
        reset();
    }
    
    public void reset(){
        for(int i=0;i<10;i++){
            if(m.getItems().length>i&&m.getItems()[i]!=null){
                table.getModel().setValueAt(m.getItems()[i].toString(), i, 0);
                table.getModel().setValueAt(m.getItems()[i].buyValue(), i, 1);
            }
            else{
                table.getModel().setValueAt("", i, 0);
                table.getModel().setValueAt("", i, 1);
            }
        }
        for(int i=0;i<10;i++){
            if(p.getInventory().getInventory()[i]!=null){
                table.getModel().setValueAt(p.getInventory().getInventory()[i].toString(), i, 2);
                table.getModel().setValueAt(p.getInventory().getInventory()[i].sellValue(), i, 3);
            }
            else{
                table.getModel().setValueAt("", i, 2);
                table.getModel().setValueAt("", i, 3);
            }
        }
        jLabel1.setText("Gold: "+p.getGold());
    }
    
    synchronized void done() {
        notifyAll();
    }

    public void waits1() {
        waits();
    }

    synchronized void waits() {
        try {
            wait();
        } catch (InterruptedException ex) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Merchant", "Price", "Player", "Sell Price"
            }
        ));
        jScrollPane2.setViewportView(table);
        table.getColumnModel().getColumn(1).setMaxWidth(40);
        table.getColumnModel().getColumn(3).setMaxWidth(60);

        jButton1.setText("Buy Item");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Sell Item");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Exit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2)
                        .addComponent(jButton3))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int n = table.getSelectedRow();
        if(n==-1)
            return;
        Item e = p.getInventory().getInventory()[n];
        if (table.getSelectedColumn()==2 && e != null) {
            if(p.sellItem(e))
                reset();
            else
                JOptionPane.showMessageDialog(this, "Cannot Sell Item");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int n = table.getSelectedRow();
        if(n==-1)
            return;
        Item e = m.getItems()[n];
        if (table.getSelectedColumn()==0 && e != null) {
            if(p.buyItem(e)){
                reset();
                JOptionPane.showMessageDialog(this, "Bought");
            }
            else
                JOptionPane.showMessageDialog(this, "Cannot Buy Item");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        done();
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
