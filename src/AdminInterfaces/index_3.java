/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminInterfaces;

import Interfaces.index;
import javax.swing.JOptionPane;
import DBCONNECT.db_connect1;
import Interfaces.index;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author Toshiba
 */
public class index_3 extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    private static String id;
    
    public String get_id()
    {
      return id;
    }
    
    public index_3()
    {
        initComponents();
        con = db_connect1.connect();
        
        this.setdata();       
    }
    
    private void setdata(){
        String sql = "SELECT id AS ID,name AS Name,conductor AS Conductor,description as Description,status AS Status FROM course";
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            System.out.println("Error in quering data about course. Error = "+e.getMessage());
        }
    }

    private void get_data(){
        
        int rr = jTable1.getSelectedRow();
        String name,conductor,description,status;
        
        this.id = jTable1.getValueAt(rr,0).toString();
        name = jTable1.getValueAt(rr,1).toString();
        conductor = jTable1.getValueAt(rr,2).toString();
        description = jTable1.getValueAt(rr,3).toString();
        status = jTable1.getValueAt(rr,4).toString();
       
        
        name_box.setText(name);
        con_box.setText(conductor);
        jTextArea1.setText(description);
        status_box.setText(status);
           
    }
    private void view_data(){
       String pp=jTextField1.getText();
        
        String sql= "";
        
        if(pp.length() == 0){
            sql = "SELECT id AS ID,name AS Name,conductor AS Conductor,description as Description,status AS Status FROM course WHERE status = 0";
        }
        else{
            sql = "SELECT id AS ID,name AS Name,conductor AS Conductor,description as Description,status AS Status FROM course WHERE  name LIKE '%"+pp+"%'";
        }

        
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            //this will count the number of results
            //rs.last();
            //count = rs.getRow();
            //rs.beforeFirst();//set current row into begining

            //this.count_box.setText(""+count);
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
            System.out.println("Error to Search data. Error = "+e.getMessage());
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
        jTextArea1 = new javax.swing.JTextArea();
        name_box = new javax.swing.JTextField();
        con_box = new javax.swing.JTextField();
        status_box = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(810, 540));
        getContentPane().setLayout(null);

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(420, 120, 330, 320);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(200, 200, 170, 90);
        getContentPane().add(name_box);
        name_box.setBounds(200, 90, 170, 30);
        getContentPane().add(con_box);
        con_box.setBounds(200, 150, 170, 30);
        getContentPane().add(status_box);
        status_box.setBounds(200, 310, 170, 30);

        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 10, 120, 40);

        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3);
        jLabel3.setBounds(170, 10, 120, 40);

        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4);
        jLabel4.setBounds(420, 10, 120, 40);

        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5);
        jLabel5.setBounds(550, 10, 120, 40);

        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel6);
        jLabel6.setBounds(700, 470, 60, 20);

        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel7);
        jLabel7.setBounds(50, 400, 140, 40);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(420, 80, 160, 30);

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(600, 80, 80, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagess/Admin_update.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 500);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        index_1 in2 = new index_1();
        in2.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        index_2 in2 = new index_2();
        in2.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        index_4 in2 = new index_4();
        in2.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        index_5 in2 = new index_5();
        in2.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        int cl,s,ids;
        String name,status,conductor,description;
        name = name_box.getText();
        status = status_box.getText();
        conductor = con_box.getText();
        description = jTextArea1.getText();
        
        if(name.equals(""))
            JOptionPane.showConfirmDialog(null,"Enter Name !");
        else if(conductor.equals(""))
            JOptionPane.showConfirmDialog(null,"Enter conductor !");
        else if(description.equals(""))
            JOptionPane.showConfirmDialog(null,"Enter Description !");
        else if(status.equals(""))
            JOptionPane.showConfirmDialog(null,"Enter Facilities !");
        else{          
            s = Integer.parseInt(status);
            ids = Integer.parseInt(this.id);

            String sql = "UPDATE course SET name = '"+name+"',conductor = '"+conductor+"',description = '"+description+"',status = "+s+" WHERE id = "+ids+"";

            try{
                ps = con.prepareStatement(sql);
                ps.execute();

                JOptionPane.showConfirmDialog(null,"Update Successful !...");
                this.setdata();

                name_box.setText("");    
                con_box.setText("");
                status_box.setText("");
                jTextArea1.setText("");
            }
            catch(Exception e){
                System.out.println("Error in update course table. Error = "+e.getMessage());
            }
        }
        
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
            int x = JOptionPane.showConfirmDialog(null,"Do you want to signout ?");
            if(x == 0){
            index in1 = new index();
            in1.setVisible(true);
            this.dispose();
            }
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        this.get_data(); 
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        this.get_data();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        view_data();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(index_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(index_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(index_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(index_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new index_3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField con_box;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField name_box;
    private javax.swing.JTextField status_box;
    // End of variables declaration//GEN-END:variables
}