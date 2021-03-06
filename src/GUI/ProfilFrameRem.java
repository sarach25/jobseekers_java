/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entities.*;
import DAO.*;
import static GUI.EnvoieMessageFrame.idmembertosend;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utils.DataSource;

/**
 *
 * @author user
 */
public class ProfilFrameRem extends javax.swing.JFrame {
Connection conn;
 PreparedStatement pst = null;
 ResultSet rs = null;
 int t;
 
 membre mm=null;
 Competances c=null;
 membreDAO mdao=new membreDAO();

 
    /**
     * Creates new form ProfilFrame
     */
    public ProfilFrameRem() {
        initComponents();
        conn=DataSource.getInstance().getConnection();
        FillcomboBox();
        
        
    }
    private void FillcomboBox(){
            try{
                String  sql="select * from competance ";
                        pst=conn.prepareStatement(sql);
                        rs=pst.executeQuery();
                        while(rs.next()){
                            String name=rs.getString("nom_competance");
                            CBcomp.addItem(name);
                        }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
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

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        CP = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        CA = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        Statut_ac = new javax.swing.JTextArea();
        CBcomp = new javax.swing.JComboBox<>();
        txtcomp = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        ajouter = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblCompetances = new javax.swing.JTable();
        lmessage = new javax.swing.JLabel();
        ajouter1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lg.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 50, 40);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Profil");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(431, 431, 431)
                .addComponent(jLabel2)
                .addContainerGap(456, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(50, 0, 940, 40);

        jButton1.setText("remplir Profil");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(870, 680, 100, 25);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Resume");
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 460, 340, 280);

        CP.setColumns(20);
        CP.setRows(5);
        CP.setText("Cursus Pro");
        jScrollPane2.setViewportView(CP);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(30, 330, 340, 100);

        CA.setColumns(20);
        CA.setRows(5);
        CA.setText("Cursus Academique");
        jScrollPane3.setViewportView(CA);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(30, 210, 340, 100);

        Statut_ac.setColumns(20);
        Statut_ac.setRows(5);
        Statut_ac.setText("Statut Actuel");
        jScrollPane4.setViewportView(Statut_ac);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(30, 70, 340, 110);

        getContentPane().add(CBcomp);
        CBcomp.setBounds(410, 80, 200, 40);
        getContentPane().add(txtcomp);
        txtcomp.setBounds(570, 150, 170, 40);

        jLabel3.setFont(new java.awt.Font("Verdana", 2, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("Nom de la compétance ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(390, 140, 180, 50);

        ajouter.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ajouter.setText("Ajouter");
        ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouterActionPerformed(evt);
            }
        });
        getContentPane().add(ajouter);
        ajouter.setBounds(660, 80, 100, 40);

        tblCompetances.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom Competance"
            }
        ));
        jScrollPane6.setViewportView(tblCompetances);

        getContentPane().add(jScrollPane6);
        jScrollPane6.setBounds(430, 280, 452, 190);
        getContentPane().add(lmessage);
        lmessage.setBounds(490, 250, 370, 70);

        ajouter1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ajouter1.setText("Ajouter");
        ajouter1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajouter1ActionPerformed(evt);
            }
        });
        getContentPane().add(ajouter1);
        ajouter1.setBounds(770, 150, 100, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         membreDAO mmb = new membreDAO();
        mm = mmb.findObjectById(RegisterFrame.idmemberinscri);
         t =mm.getId_membre();
                System.out.println(t);
        
        
        
        profile m = new profile();
        profileDAO pdao=new profileDAO();
        
       
        
     m.setStatut_ac(Statut_ac.getText());
     if(Statut_ac.getText().equals(""))
     {
         JOptionPane.showMessageDialog(null,"saisir votre statut actuel") ;
     }
     
     m.setCurus_ac(CA.getText());
     if(CA.getText().equals(""))
     {
         JOptionPane.showMessageDialog(null,"saisir votre cursus académique") ;
     }
     
     m.setCursus_pro(CP.getText());
     if(CP.getText().equals(""))
     {
         JOptionPane.showMessageDialog(null,"saisir votre cursus professionnel") ;
     }
     
     m.setResume(jTextArea1.getText());
     if(jTextArea1.getText().equals(""))
     {
         JOptionPane.showMessageDialog(null,"saisir votre résumé") ;
     }
     
     pdao.add(m,t);
     JOptionPane.showMessageDialog(null," remplissage du statut ,cursus ,resume avec succés") ;
     
     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouterActionPerformed
        // TODO add your handling code here:
       
        DefaultTableModel model = (DefaultTableModel) tblCompetances.getModel() ;
        
        model.addRow(new Object[]{CBcomp.getSelectedItem().toString()});
        
        
       
        
    
        membreDAO mmb = new membreDAO();
        mm = mmb.findObjectById(RegisterFrame.idmemberinscri);
        Competances c=new Competances();
        
        String  x=  CBcomp.getSelectedItem().toString();
        CompetancesDAO cdao=new CompetancesDAO();
                c=cdao.findCompetanceByname(x);
                int idcomp=c.getIdcomp();
                System.out.println(idcomp);
                System.out.println(x);
                CompetancesAff cf=new CompetancesAff( idcomp,RegisterFrame.idmemberinscri);
                cdao.add(mm, cf);
        
        
                
                
    }//GEN-LAST:event_ajouterActionPerformed

    private void ajouter1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajouter1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ajouter1ActionPerformed

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
            java.util.logging.Logger.getLogger(ProfilFrameRem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfilFrameRem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfilFrameRem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfilFrameRem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProfilFrameRem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea CA;
    private javax.swing.JComboBox<String> CBcomp;
    private javax.swing.JTextArea CP;
    private javax.swing.JTextArea Statut_ac;
    private javax.swing.JButton ajouter;
    private javax.swing.JButton ajouter1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lmessage;
    private javax.swing.JTable tblCompetances;
    private javax.swing.JTextField txtcomp;
    // End of variables declaration//GEN-END:variables
}
