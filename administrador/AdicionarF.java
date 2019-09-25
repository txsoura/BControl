/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador;

import controle.Funcionariodao;
import controle.Numero;
import controle.Usuariodao;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class AdicionarF extends javax.swing.JFrame {

    /**
     * Creates new form AdicionarF
     */
    public AdicionarF() {
        initComponents();
        txtcontacto.setDocument(new Numero());
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
        jLabel4 = new javax.swing.JLabel();
        btnadicionar = new javax.swing.JButton();
        txtcontacto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtendereco = new javax.swing.JTextField();
        txtnome = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Adicionar");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Nome:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, -1));

        btnadicionar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnadicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/adicionar.png"))); // NOI18N
        btnadicionar.setText("Adicionar");
        btnadicionar.setPreferredSize(new java.awt.Dimension(80, 30));
        btnadicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnadicionarActionPerformed(evt);
            }
        });
        jPanel1.add(btnadicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 130, 50));
        jPanel1.add(txtcontacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 210, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Contacto:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 130, -1));
        jPanel1.add(txtendereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 210, 30));

        txtnome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnomeActionPerformed(evt);
            }
        });
        jPanel1.add(txtnome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 210, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Endereço:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 170, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 270));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnadicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnadicionarActionPerformed
        if (txtendereco.getText().equals("") || txtnome.getText().equals("") || txtcontacto.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha o campo em branco.", "Campo em branco", JOptionPane.WARNING_MESSAGE);
        } else if (Integer.parseInt(txtcontacto.getText()) <= 0) {
            txtcontacto.setText("");
            JOptionPane.showMessageDialog(null, "Por favor, preencha um Contacto válido.", "Contacto invalido", JOptionPane.WARNING_MESSAGE);
        } else {
            Funcionariodao fdao = new Funcionariodao();
            Usuariodao udao = new Usuariodao();

            try {
                if (fdao.adicionar(txtnome.getText(), txtendereco.getText(), Integer.parseInt(txtcontacto.getText()))) {
                    udao.adicionar(txtnome.getText());
                    this.dispose();
                    Tela tela = new Tela();
                    tela.visualizar();
                } else {
                    JOptionPane.showMessageDialog(null, "Falha ao adicionar.", "Desculpa", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                Logger.getLogger(AdicionarF.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btnadicionarActionPerformed

    private void txtnomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnomeActionPerformed

    }//GEN-LAST:event_txtnomeActionPerformed

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
            java.util.logging.Logger.getLogger(AdicionarF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdicionarF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdicionarF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdicionarF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdicionarF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadicionar;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField txtcontacto;
    public javax.swing.JTextField txtendereco;
    public javax.swing.JTextField txtnome;
    // End of variables declaration//GEN-END:variables

}