/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import DBCONNECT.db_connect1;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import e.learning.member;
import java.awt.HeadlessException;
import java.sql.SQLException;

public class Login extends javax.swing.JFrame {

   Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    index in1 = new index();
    member m1 = new member();
    public Login() {
        initComponents();
        
               
        con = db_connect1.connect();//set up database connection
        
        /*jTextField1.addKeyListener(new KeyAdapter() {
            
            public void keyPressed(KeyEvent e){
                int key = e.getKeyCode();
                if(key == KeyEvent.VK_ENTER){
                     submit();
                }
            }
        
        });
        jPasswordField1.addKeyListener(new KeyAdapter() {
            
            public void keyPressed(KeyEvent e){
                int key = e.getKeyCode();
                if(key == KeyEvent.VK_ENTER){
                     submit();
                }
            }
        
        });*/
    }
    
    public boolean check_user(String username,String password){
        
        boolean succ = false;
        
        String sql = "SELECT lm.id as ID FROM login_member lm,member m WHERE lm.username = '"+username+"' AND lm.password = '"+password+"' AND lm.mem_no = m.id";
        
        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            //this will check for record is available or not
            int size=0;
            while (rs.next()) {
                size++;
            }
            //-----------------
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.next();
            m1.set_id(rs.getString("ID").toString());
            //--------- this part will handel user selection when no result found -----------
            if(size == 0)
            {
                int z = JOptionPane.showConfirmDialog(null,"No Result Found...Try Again");
                if(z == 0){
                    jTextField1.setText("");
                    jPasswordField1.setText("");

                }
                else if(z == 1)
                {
                    in1.setVisible(true);
                    this.dispose();
                }
            }
            else
            {
                succ=true;
            }
            //----------------------------------------------

        }
        catch(SQLException | HeadlessException e){
            
            int z = JOptionPane.showConfirmDialog(null,"No Result Found...Try Again");
                if(z == 0){
                    jTextField1.setText("");
                    jPasswordField1.setText("");
                }
                else if(z == 1)
                {
                    in1.setVisible(true);
                    this.dispose();
                }
        }
        
        return succ;
    }
    
    
    private void submit(){
        
        String user = jTextField1.getText();
        char[] pass = jPasswordField1.getPassword();

        String password = new String(pass);


        if(user.length() == 0)
            JOptionPane.showConfirmDialog(null,"Enter Username");
        else if(password.length() == 0)
            JOptionPane.showConfirmDialog(null,"Enter Password");
        else
        {
            if(check_user(user,password) == true)
            {
                course_search hs1 = new course_search();
                hs1.setVisible(true);
                this.dispose();
                /*JOptionPane.showConfirmDialog(null,m1.get_id());*/
                
            }
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

        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(805, 520));
        getContentPane().setLayout(null);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(160, 130, 160, 30);

        jPasswordField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(160, 170, 160, 30);

        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 10, 50, 40);

        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2);
        jLabel2.setBounds(330, 130, 50, 40);

        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5);
        jLabel5.setBounds(610, 420, 150, 40);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagess/Login.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 790, 480);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPasswordField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField1ActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
                index in1 = new index();
                in1.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.submit();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        signup sp=new signup();
        sp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        signup sp=new signup();
        sp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel5MouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
