/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador;

import controle.Funcionariodao;
import controle.Usuariodao;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Usuario;

/**
 *
 * @author Victor
 */
public class Funcionario extends javax.swing.JFrame {

    /**
     * Creates new form Funcionario
     */
    public Funcionario() {
        initComponents();
        limpar();
    }

    ActualizarP Adicionar = new ActualizarP();

    public void visualizar() {
        DefaultTableModel modelo = (DefaultTableModel) jTableproducto.getModel();
        modelo.setNumRows(0);
        Funcionariodao ndao = new Funcionariodao();
        ndao.visualizar().forEach((n) -> {
            modelo.addRow(new Object[]{
                n.getNome(),
                n.getContacto(),
                n.getEndereco()
            });
        });
    }

    public void limpar() {
        txtnome.setText("");
        visualizar();
    }

    public void procurar(String funcionario) {
        DefaultTableModel modelo = (DefaultTableModel) jTableproducto.getModel();
        modelo.setNumRows(0);
        Funcionariodao ndao = new Funcionariodao();
        ndao.procurar(funcionario).forEach((n) -> {
            modelo.addRow(new Object[]{
                n.getNome(),
                n.getContacto(),
                n.getEndereco()
            });
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

        Painel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableproducto = new javax.swing.JTable();
        jLabelqtdproducto = new javax.swing.JLabel();
        txtnome = new javax.swing.JTextField();
        btnprocurar = new javax.swing.JButton();
        btnlimpar = new javax.swing.JButton();
        btnremover = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Funcionarios");
        setMinimumSize(new java.awt.Dimension(720, 480));
        setName(""); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Painel.setPreferredSize(new java.awt.Dimension(720, 480));
        Painel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(700, 460));

        jTableproducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Contacto", "Endereço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableproducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableproductoMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTableproductoMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTableproducto);
        if (jTableproducto.getColumnModel().getColumnCount() > 0) {
            jTableproducto.getColumnModel().getColumn(1).setResizable(false);
            jTableproducto.getColumnModel().getColumn(1).setPreferredWidth(11);
        }

        Painel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 700, 410));

        jLabelqtdproducto.setText("Nome do Funcionário:");
        Painel.add(jLabelqtdproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtnome.setPreferredSize(new java.awt.Dimension(60, 20));
        txtnome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnomeActionPerformed(evt);
            }
        });
        Painel.add(txtnome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 120, -1));

        btnprocurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/procurar.png"))); // NOI18N
        btnprocurar.setText("Procurar");
        btnprocurar.setPreferredSize(new java.awt.Dimension(80, 40));
        btnprocurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprocurarActionPerformed(evt);
            }
        });
        Painel.add(btnprocurar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 110, 40));

        btnlimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/actualizar.png"))); // NOI18N
        btnlimpar.setText("Limpar");
        btnlimpar.setPreferredSize(new java.awt.Dimension(80, 40));
        btnlimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimparActionPerformed(evt);
            }
        });
        Painel.add(btnlimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 100, 40));

        btnremover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/apagar.png"))); // NOI18N
        btnremover.setText("Remover");
        btnremover.setPreferredSize(new java.awt.Dimension(80, 40));
        btnremover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnremoverActionPerformed(evt);
            }
        });
        Painel.add(btnremover, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 110, 40));

        getContentPane().add(Painel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnomeActionPerformed

    private void btnprocurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprocurarActionPerformed
        if (txtnome.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Por favor, preencha o Nome do Funcionário.", "Campo em branco", JOptionPane.WARNING_MESSAGE);
        } else {
            procurar(txtnome.getText());
        }
    }//GEN-LAST:event_btnprocurarActionPerformed

    private void jTableproductoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableproductoMouseReleased

    }//GEN-LAST:event_jTableproductoMouseReleased

    private void jTableproductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableproductoMouseClicked

    }//GEN-LAST:event_jTableproductoMouseClicked

    private void btnlimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimparActionPerformed
        limpar();
    }//GEN-LAST:event_btnlimparActionPerformed

    private void btnremoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnremoverActionPerformed
        if (jTableproducto.getSelectedRow() != -1) {
            modelo.Funcionario f = new modelo.Funcionario();
            Funcionariodao fdao = new Funcionariodao();
            f.setNome((String) jTableproducto.getValueAt(jTableproducto.getSelectedRow(), 0));
            fdao.apagar(f);

            Usuario u = new Usuario();
            Usuariodao udao = new Usuariodao();
            u.setNome((String) jTableproducto.getValueAt(jTableproducto.getSelectedRow(), 0));
            udao.apagar(u);

            limpar();
            visualizar();
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecione o Funcionário que pretende Remover.", "Funcionário não selecionado", JOptionPane.WARNING_MESSAGE);

        }
    }//GEN-LAST:event_btnremoverActionPerformed

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
            java.util.logging.Logger.getLogger(Funcionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Funcionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Painel;
    private javax.swing.JButton btnlimpar;
    private javax.swing.JButton btnprocurar;
    private javax.swing.JButton btnremover;
    private javax.swing.JLabel jLabelqtdproducto;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableproducto;
    private javax.swing.JTextField txtnome;
    // End of variables declaration//GEN-END:variables

}
