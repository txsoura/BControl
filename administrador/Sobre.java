/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador;

import controle.Numero;
import controle.Sobredao;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class Sobre extends javax.swing.JFrame {

    /**
     * Creates new form Sobre
     */
    public Sobre() {
        initComponents();
        txtcontacto.setDocument(new Numero());
        txtnuit.setDocument(new Numero());
        visualizar();
    }

    public void visualizar() {
        txtnome.setText("");
        txtnuit.setText("");
        txtcontacto.setText("");
        txtendereco.setText("");
        Sobredao ndao = new Sobredao();
        ndao.visualizar().forEach((n) -> {
            txtnome.setText(n.getNome());
            txtnuit.setText(n.getNuit() + "");
            txtcontacto.setText(n.getContacto() + "");
            txtendereco.setText(n.getEndereco());
        });
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
        btnalterar = new javax.swing.JButton();
        txtcontacto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtnuit = new javax.swing.JTextField();
        txtnome = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtendereco = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sobre Nos");
        setMinimumSize(new java.awt.Dimension(240, 350));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Nome:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, -1));

        btnalterar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnalterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/editar.png"))); // NOI18N
        btnalterar.setText("Alterar");
        btnalterar.setPreferredSize(new java.awt.Dimension(80, 30));
        btnalterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnalterarActionPerformed(evt);
            }
        });
        jPanel1.add(btnalterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 130, 50));
        jPanel1.add(txtcontacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 210, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Contacto:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 130, -1));
        jPanel1.add(txtnuit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 210, 30));

        txtnome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnomeActionPerformed(evt);
            }
        });
        jPanel1.add(txtnome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 210, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("NUIT:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 170, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Endereço:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 170, -1));

        txtendereco.setColumns(20);
        txtendereco.setRows(5);
        jScrollPane1.setViewportView(txtendereco);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 210, 70));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnalterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnalterarActionPerformed
        if (txtnuit.getText().equals("") || txtnome.getText().equals("") || txtcontacto.getText().equals("") || txtendereco.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha o campo em branco.", "Campo em branco", JOptionPane.WARNING_MESSAGE);
        } else if (Integer.parseInt(txtcontacto.getText()) < 0 || Integer.parseInt(txtnuit.getText()) < 0) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha Contacto e/ou Nuit válido.", "Valor invalido", JOptionPane.WARNING_MESSAGE);
        } else {
            Sobredao udao = new Sobredao();

            try {
                if (udao.alterar(txtnome.getText(), Integer.parseInt(txtcontacto.getText()), Integer.parseInt(txtnuit.getText()), txtendereco.getText())) {
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Falha ao alterar dados.", "Desculpa", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                Logger.getLogger(Sobre.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btnalterarActionPerformed

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
            java.util.logging.Logger.getLogger(Sobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sobre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Sobre().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnalterar;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField txtcontacto;
    private javax.swing.JTextArea txtendereco;
    public javax.swing.JTextField txtnome;
    public javax.swing.JTextField txtnuit;
    // End of variables declaration//GEN-END:variables

}