/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.gui;

import com.system.db.SaleDB;
import com.system.model.GetItem;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.plaf.synth.SynthLookAndFeel;

/**
 *
 * @author Acer
 */
public class SaleUI extends javax.swing.JFrame {

    /**
     * Creates new form SaleUI
     */
    public SaleUI() {
        initComponents();
        loadCustomComponent();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField5 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel2.setText("Date & Time : ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, -1, -1));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel1.setText("User : ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, -1, -1));

        jLabel10.setFont(new java.awt.Font("Sylfaen", 0, 18)); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, -1));

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel11.setText("Prem");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 970, 80));

        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 130, 40));

        jLabel3.setFont(new java.awt.Font("Verdana Pro Light", 1, 18)); // NOI18N
        jLabel3.setText("ItemCode");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        jLabel4.setFont(new java.awt.Font("Verdana Pro Light", 1, 18)); // NOI18N
        jLabel4.setText("ItemName");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        jTextField2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jTextField2.setEnabled(false);
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 130, 40));

        jTextField3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jPanel2.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 130, 40));

        jLabel5.setFont(new java.awt.Font("Verdana Pro Light", 1, 18)); // NOI18N
        jLabel5.setText("Item Qty");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, -1, -1));

        jTextField4.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jTextField4.setEnabled(false);
        jPanel2.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, 130, 40));

        jLabel6.setFont(new java.awt.Font("Verdana Pro Light", 1, 18)); // NOI18N
        jLabel6.setText("Unit Price");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, -1, -1));

        jButton1.setBackground(new java.awt.Color(51, 51, 255));
        jButton1.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 102));
        jButton1.setText("Add");
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 50, 140, 40));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ItemName", "UnitPrice", "Qty", "SubTotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 830, 120));

        jTextField5.setFont(new java.awt.Font("Verdana Pro Light", 1, 14)); // NOI18N
        jPanel2.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 260, 150, -1));

        jLabel7.setFont(new java.awt.Font("Verdana Pro Light", 1, 14)); // NOI18N
        jLabel7.setText("Grand Total");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 260, -1, -1));

        jLabel8.setFont(new java.awt.Font("Verdana Pro Light", 1, 14)); // NOI18N
        jLabel8.setText("Payment");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 300, -1, -1));

        jTextField6.setFont(new java.awt.Font("Verdana Pro Light", 1, 14)); // NOI18N
        jPanel2.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 300, 150, -1));

        jTextField7.setFont(new java.awt.Font("Verdana Pro Light", 1, 14)); // NOI18N
        jPanel2.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 340, 150, -1));

        jLabel9.setFont(new java.awt.Font("Verdana Pro Light", 1, 14)); // NOI18N
        jLabel9.setText("Balance");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 340, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 970, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            SaleDB sdb = new SaleDB();
            String code = jTextField1.getText();
            GetItem item = sdb.getItemBySpecificCode(Integer.parseInt(code));
            jTextField2.setText(item.getItemName());
            jTextField4.setText(String.valueOf(item.getItemRate()));

            jTextField3.requestFocus();
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.put("Synthetica.window.decoration", Boolean.FALSE);
            
            // select the Look and Feel
            UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");

        } catch (Exception ex) {

        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SaleUI().setVisible(true);
            }
        });
    }

    public void loadCustomComponent() {
        String timeStamp = new SimpleDateFormat("E yyyy.MM.dd").format(Calendar.getInstance().getTime());
        jLabel10.setText(timeStamp);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}