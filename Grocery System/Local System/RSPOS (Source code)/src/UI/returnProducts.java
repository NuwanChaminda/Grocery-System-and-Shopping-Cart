/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UI;

import database.dbConnection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dhanuka
 */
public class returnProducts extends javax.swing.JFrame {

    /**
     * Creates new form returnProducts
     */
    public returnProducts() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        return_txt_billID = new javax.swing.JTextField();
        purchase_btn_dlt = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        purchaseReturn_tbl_cart = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        purchase_lbl_grandTotal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        return_update = new javax.swing.JButton();

        setTitle("Rajaguru Stores | Return Products");
        setBackground(new java.awt.Color(255, 255, 204));
        setMaximumSize(new java.awt.Dimension(700, 400));
        setMinimumSize(new java.awt.Dimension(700, 400));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setText("Enter Bill ID :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(70, 70, 80, 14);

        return_txt_billID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                return_txt_billIDKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                return_txt_billIDKeyReleased(evt);
            }
        });
        getContentPane().add(return_txt_billID);
        return_txt_billID.setBounds(160, 60, 100, 30);

        purchase_btn_dlt.setText("Delete");
        purchase_btn_dlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purchase_btn_dltActionPerformed(evt);
            }
        });
        getContentPane().add(purchase_btn_dlt);
        purchase_btn_dlt.setBounds(550, 250, 90, 25);

        purchaseReturn_tbl_cart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Barcode", "Product ID", "Product Name", "Quantity", "Price", "Sub Price"
            }
        ));
        purchaseReturn_tbl_cart.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        purchaseReturn_tbl_cart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                purchaseReturn_tbl_cartMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(purchaseReturn_tbl_cart);
        if (purchaseReturn_tbl_cart.getColumnModel().getColumnCount() > 0) {
            purchaseReturn_tbl_cart.getColumnModel().getColumn(2).setPreferredWidth(100);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(60, 120, 580, 120);

        jLabel5.setText("Grand Total :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(470, 300, 70, 14);
        getContentPane().add(purchase_lbl_grandTotal);
        purchase_lbl_grandTotal.setBounds(550, 290, 90, 30);

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel2.setText("Return");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(310, 20, 80, 20);

        return_update.setText("Update");
        return_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                return_updateActionPerformed(evt);
            }
        });
        getContentPane().add(return_update);
        return_update.setBounds(300, 340, 80, 30);

        setSize(new java.awt.Dimension(716, 439));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void purchase_btn_dltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purchase_btn_dltActionPerformed
             if(purchaseReturn_tbl_cart.getSelectedRowCount()>0){
             
                  try {
        
                        Statement con = dbConnection.db().createStatement();
                        con.executeUpdate("DELETE FROM purchased_products WHERE bar_code='"+purchaseReturn_tbl_cart.getValueAt(purchaseReturn_tbl_cart.getSelectedRow(), 0)+"' ");
            
                        Statement con2 = dbConnection.db().createStatement();
                        con2.executeUpdate("UPDATE transactions SET total_price='"+purchase_lbl_grandTotal.getText()+"' WHERE transaction_id='"+return_txt_billID.getText()+"' ");
                  }catch(Exception ex){
                        Logger.getLogger(mainWindow.class.getName()).log(Level.SEVERE, null, ex);
                   }
                 
                 
                 removeRows();
                 grandTotal();
                 
             }else{
                JOptionPane.showMessageDialog(null, "Please select an Item in the table");
                }
        
    }//GEN-LAST:event_purchase_btn_dltActionPerformed
     public void removeRows(){
       DefaultTableModel table = (DefaultTableModel) purchaseReturn_tbl_cart.getModel();
        int slectedRows [] = purchaseReturn_tbl_cart.getSelectedRows();
        
        for(int i=0;i<slectedRows.length;i++){
            table.removeRow(slectedRows[i]-i);
          }
    } 
    
    
    private void return_txt_billIDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_return_txt_billIDKeyReleased
       
        tableUpdate();
        
        
    }//GEN-LAST:event_return_txt_billIDKeyReleased

    private void purchaseReturn_tbl_cartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_purchaseReturn_tbl_cartMouseClicked
       
    }//GEN-LAST:event_purchaseReturn_tbl_cartMouseClicked

    private void return_txt_billIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_return_txt_billIDKeyPressed
        purchase_lbl_grandTotal.setText("");
    }//GEN-LAST:event_return_txt_billIDKeyPressed

    private void return_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_return_updateActionPerformed
            
        try{
            
            Statement con = dbConnection.db().createStatement();
            con.executeUpdate("UPDATE transactions SET total_price='"+purchase_lbl_grandTotal.getText()+"' WHERE transaction_id='"+return_txt_billID.getText()+"' ");
            JOptionPane.showMessageDialog(null,"Successfull....!");
            
        
        }catch(Exception ex){
                        Logger.getLogger(mainWindow.class.getName()).log(Level.SEVERE, null, ex);
                   }
        
        
        
    }//GEN-LAST:event_return_updateActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(returnProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(returnProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(returnProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(returnProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new returnProducts().setVisible(true);
            }
        });
    }

    public void tableUpdate(){
    try {
        
            DefaultTableModel table = (DefaultTableModel) purchaseReturn_tbl_cart.getModel();
            table.setRowCount(0);
            Statement con = dbConnection.db().createStatement();
            ResultSet record = con.executeQuery( "SELECT purchased_products. * , products. * , supplied_products.product_id\n" +
                                                "FROM purchased_products\n" +
                                                "INNER JOIN supplied_products ON supplied_products.bar_code = purchased_products.bar_code\n" +
                                                "INNER JOIN products ON products.product_id = supplied_products.product_id\n" +
                                                "WHERE purchased_products.transaction_id =  '"+return_txt_billID.getText()+"'");
            
            while(record.next()){   
            double unitPrice = Double.valueOf(record.getString("products.product_price"));
            double total = 0.00;
            int qty = Integer.parseInt(record.getString("purchased_products.quantity"));
            
            
            total = unitPrice*qty;
            
            Vector rc = new Vector();
            rc.add(record.getString("purchased_products.bar_code"));
            rc.add(record.getString("products.product_id"));
            rc.add(record.getString("products.product_name"));
            rc.add(record.getString("purchased_products.quantity"));
            rc.add(record.getString("products.product_price"));
            rc.add(total);
                 
            rc.add(total);
            table.addRow(rc);
          
            }
            
            
          
   } catch (Exception ex) {
            Logger.getLogger(mainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    grandTotal();
    }
    
     public void grandTotal(){
    
    double total = 0.0;

        for (int x = 0; x < purchaseReturn_tbl_cart.getRowCount(); x++) {
            total += Double.valueOf(String.valueOf(purchaseReturn_tbl_cart.getValueAt(x, 5)));
        }

        purchase_lbl_grandTotal.setText(String.valueOf(total));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable purchaseReturn_tbl_cart;
    private javax.swing.JButton purchase_btn_dlt;
    private javax.swing.JLabel purchase_lbl_grandTotal;
    private javax.swing.JTextField return_txt_billID;
    private javax.swing.JButton return_update;
    // End of variables declaration//GEN-END:variables
}