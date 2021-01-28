/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgnew;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;


/**
 *
 * @author nattachar
 */

class Player{
    public  static BufferedImage playermotor;
    public String name;
    private int count;
    private int n;
    
    public void setdata(String n){
        name = n;
        count ++;
              
    }
    public void setmodel(int n){
        if(n==0){
            playermotor = imageL("char1.png");
        }
        else if (n==1){
            playermotor = imageL("char2.png");
        
        }
   
    }
    public BufferedImage getimag(){
        return playermotor;
    }
    public static BufferedImage imageL(String path){
        try{
            return ImageIO.read(Player.class.getResource(path));
        }catch(IOException e){
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
   
}

public class Start extends javax.swing.JFrame {
    public  static BufferedImage playermotor;
   
    public Start() {
        initComponents();
        setLocationRelativeTo(null);
        
        lbl_U.setVisible(false);
 
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
        jLabel4 = new javax.swing.JLabel();
        Male = new javax.swing.JButton();
        Female = new javax.swing.JButton();
        jTextField_name = new javax.swing.JTextField();
        lbl_U = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgnew/gigi_button.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(170, 400, 200, 100);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgnew/lala_button.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(460, 400, 190, 100);

        Male.setText("GIGI");
        Male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MaleActionPerformed(evt);
            }
        });
        getContentPane().add(Male);
        Male.setBounds(210, 420, 120, 50);

        Female.setText("LALA");
        Female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FemaleActionPerformed(evt);
            }
        });
        getContentPane().add(Female);
        Female.setBounds(490, 420, 120, 50);

        jTextField_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_nameActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_name);
        jTextField_name.setBounds(300, 520, 220, 30);

        lbl_U.setFont(new java.awt.Font("Pump Demi Bold LET", 0, 18)); // NOI18N
        lbl_U.setForeground(new java.awt.Color(255, 102, 51));
        lbl_U.setText("*");
        getContentPane().add(lbl_U);
        lbl_U.setBounds(530, 520, 31, 40);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Sawyer's Whitewash", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NAME :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(210, 490, 180, 80);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pkgnew/charactor_bg.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 800, 630);

        setBounds(0, 0, 812, 647);
    }// </editor-fold>//GEN-END:initComponents

    private void MaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MaleActionPerformed
        
        
        if(jTextField_name.getText().equals("")){
            lbl_U.setVisible(true);
        }
        else{
            Player p = new Player();
            p.setmodel(0);

            Rungame r = new Rungame(); 
            r.setVisible(true);
            setVisible(false);     
        }
        
    }//GEN-LAST:event_MaleActionPerformed

    private void FemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FemaleActionPerformed
        if(jTextField_name.getText().equals("")){
            lbl_U.setVisible(true);
        }
        else{
            Player p = new Player();
            p.setmodel(1);
            Rungame r = new Rungame();
            r.setVisible(true);
            setVisible(false);     
        }
    }//GEN-LAST:event_FemaleActionPerformed

    private void jTextField_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_nameActionPerformed
        Player p = new Player();
        p.setdata(jTextField_name.getText());
        
    }//GEN-LAST:event_jTextField_nameActionPerformed

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
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Start().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Female;
    private javax.swing.JButton Male;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField_name;
    private javax.swing.JLabel lbl_U;
    // End of variables declaration//GEN-END:variables
}