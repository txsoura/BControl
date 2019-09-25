/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionario;

import controle.Usuariodao;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Victor
 */
public class Inicio extends javax.swing.JFrame {

    static String xStrPath;

    /**
     * Creates new form Inicio
     */
    public Inicio() {
        initComponents();

        pack();
        setLocationRelativeTo(null);

        Usuariodao udao = new Usuariodao();
        udao.funcionario().forEach((u) -> {
            cbofuncionario.addItem(u + "");
        });

        xStrPath = "C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\BControl";
        criarPasta();
//        try {
//            Process p = Runtime.getRuntime().exec("C:\\xampp\\xampp-control.exe");
//        } catch (IOException ex) {
//            Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }

   

    public static void criarPasta() {
        boolean checkDir;

        Path xPath = Paths.get(xStrPath);

        checkDir = Files.exists(xPath);

        if (checkDir) {
//            System.out.println("Pasta nao existe");
            return;
        }

        try {
            Files.createDirectory(xPath);
        } catch (IOException ex) {
            //System.out.println("Nao foi possivel criar pasta");
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

        Painel = new javax.swing.JPanel();
        jLabelcodigo = new javax.swing.JLabel();
        jLabelsenha = new javax.swing.JLabel();
        btnentrar = new javax.swing.JButton();
        txtsenha = new javax.swing.JPasswordField();
        cbofuncionario = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BControl");
        setMaximumSize(new java.awt.Dimension(580, 230));
        setMinimumSize(new java.awt.Dimension(400, 200));
        setName("inicio"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Painel.setAlignmentX(0.0F);
        Painel.setAlignmentY(0.0F);
        Painel.setMaximumSize(new java.awt.Dimension(400, 200));
        Painel.setMinimumSize(new java.awt.Dimension(400, 200));
        Painel.setPreferredSize(new java.awt.Dimension(580, 230));
        Painel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelcodigo.setBackground(new java.awt.Color(204, 204, 204));
        jLabelcodigo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelcodigo.setText("Funcionário:");
        Painel.add(jLabelcodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jLabelsenha.setBackground(new java.awt.Color(204, 204, 204));
        jLabelsenha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelsenha.setText("Senha:");
        Painel.add(jLabelsenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        btnentrar.setBackground(new java.awt.Color(204, 204, 204));
        btnentrar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnentrar.setText("Iniciar Sessão");
        btnentrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnentrarActionPerformed(evt);
            }
        });
        btnentrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnentrarKeyPressed(evt);
            }
        });
        Painel.add(btnentrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 200, -1));

        txtsenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Painel.add(txtsenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 250, 30));

        cbofuncionario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Painel.add(cbofuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 250, 30));

        getContentPane().add(Painel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 200));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnentrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnentrarActionPerformed
        Usuariodao udao = new Usuariodao();

        String n = (String) cbofuncionario.getSelectedItem();

        if (txtsenha.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, digite a Senha.", "Campo em branco", JOptionPane.WARNING_MESSAGE);

        } else {

            try {
                if (cbofuncionario.getSelectedItem().equals("DKaras") && udao.verificar(n, txtsenha.getText())) {
                    administrador.Tela a = new administrador.Tela();
                    a.setVisible(true);
                    a.nome(n);
                    this.dispose();
                } else {
                    try {
                        if (udao.verificar(n, txtsenha.getText())) {
                            Tela tela = new Tela();
                            tela.setVisible(true);
                            tela.nome(n);
                            this.dispose();
                        } else {
                            txtsenha.setText("");
                            JOptionPane.showMessageDialog(null, "Senha incorrecta.", "Desculpa", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (UnsupportedEncodingException ex) {
                        Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnentrarActionPerformed

    private void btnentrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnentrarKeyPressed

    }//GEN-LAST:event_btnentrarKeyPressed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Painel;
    private javax.swing.JButton btnentrar;
    private javax.swing.JComboBox<String> cbofuncionario;
    private javax.swing.JLabel jLabelcodigo;
    private javax.swing.JLabel jLabelsenha;
    private javax.swing.JPasswordField txtsenha;
    // End of variables declaration//GEN-END:variables

}
