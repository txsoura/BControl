/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcionario;

import controle.Sobredao;
import controle.Vendadao;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Victor
 */
public class Productos extends javax.swing.JFrame {

    /**
     * Creates new form Productos
     */
    public Productos() {
        initComponents();
        limpar();
    }

    Adicionar Adicionar = new Adicionar();

    public void visualizar() {
        DecimalFormat mt = new DecimalFormat("######0.00 Mt");
        DecimalFormat ud = new DecimalFormat("##0 Und");
        DefaultTableModel modelo = (DefaultTableModel) jTableproducto.getModel();
        modelo.setNumRows(0);
        Vendadao ndao = new Vendadao();
        ndao.visualizarProducto().forEach((n) -> {
            modelo.addRow(new Object[]{
                n.getCodigo(),
                ud.format(n.getQuantidade()),
                mt.format(n.getPreco())
            });
        });
        total();
    }

    public void limpar() {
        visualizar();
        total();
    }

    public void procurar(String data, String data1) {
        DecimalFormat mt = new DecimalFormat("######0.00 Mt");
        DecimalFormat ud = new DecimalFormat("##0 Und");
        DefaultTableModel modelo = (DefaultTableModel) jTableproducto.getModel();
        modelo.setNumRows(0);
        Vendadao ndao = new Vendadao();
        ndao.procurarProducto(data, data1).forEach((n) -> {
            modelo.addRow(new Object[]{
                n.getCodigo(),
                ud.format(n.getQuantidade()),
                mt.format(n.getPreco())
            });
        });
        total();
    }

    public void total() {
        double x = 0;
        String s;
        byte y = 0;
        DecimalFormat mt = new DecimalFormat("#,###,##0.00 Mt");
        DefaultTableModel modelo = (DefaultTableModel) jTableproducto.getModel();
        for (int i = 0; i < jTableproducto.getRowCount(); i++) {
            s = (String) jTableproducto.getValueAt(i, 2);
            y = (byte) s.length();
            x += Double.parseDouble(s.substring(0, (y - 2)));
        }
        total.setText(mt.format(x));
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
        btnprocurar = new javax.swing.JButton();
        btnlimpar = new javax.swing.JButton();
        jLabelqtdproducto1 = new javax.swing.JLabel();
        jLabelqtdproducto = new javax.swing.JLabel();
        btnrelatorio = new javax.swing.JButton();
        data = new com.toedter.calendar.JDateChooser();
        data1 = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        total = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Productos");
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
                "Código", "Quantidade", "Total"
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
            jTableproducto.getColumnModel().getColumn(0).setResizable(false);
            jTableproducto.getColumnModel().getColumn(0).setPreferredWidth(11);
            jTableproducto.getColumnModel().getColumn(1).setResizable(false);
            jTableproducto.getColumnModel().getColumn(1).setPreferredWidth(11);
            jTableproducto.getColumnModel().getColumn(2).setResizable(false);
        }

        Painel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 700, 400));

        btnprocurar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/procurar.png"))); // NOI18N
        btnprocurar.setText("Procurar");
        btnprocurar.setPreferredSize(new java.awt.Dimension(80, 40));
        btnprocurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprocurarActionPerformed(evt);
            }
        });
        Painel.add(btnprocurar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 110, 40));

        btnlimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/actualizar.png"))); // NOI18N
        btnlimpar.setText("Limpar");
        btnlimpar.setPreferredSize(new java.awt.Dimension(80, 40));
        btnlimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimparActionPerformed(evt);
            }
        });
        Painel.add(btnlimpar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 100, 40));

        jLabelqtdproducto1.setText("Data (AAAA-MM-DD)");
        Painel.add(jLabelqtdproducto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, -1));

        jLabelqtdproducto.setText("Data Fim (AAAA-MM-DD)");
        Painel.add(jLabelqtdproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 120, -1));

        btnrelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/relatorio.png"))); // NOI18N
        btnrelatorio.setText("Relatório");
        btnrelatorio.setPreferredSize(new java.awt.Dimension(80, 40));
        btnrelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrelatorioActionPerformed(evt);
            }
        });
        Painel.add(btnrelatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 110, 40));

        data.setDateFormatString("yyyy-MM-dd");
        Painel.add(data, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 120, -1));

        data1.setDateFormatString("yyyy-MM-dd");
        Painel.add(data1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 120, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText(" Total:   ");
        Painel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, -1, -1));

        total.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        total.setText("0.00 Mt");
        Painel.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, -1, -1));

        getContentPane().add(Painel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnprocurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprocurarActionPerformed
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String txtdata = sdf.format(data.getDate());
        String txtdata1 = sdf.format(data1.getDate());
        procurar(txtdata, txtdata1);

    }//GEN-LAST:event_btnprocurarActionPerformed

    private void btnlimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimparActionPerformed
        limpar();
    }//GEN-LAST:event_btnlimparActionPerformed

    private void jTableproductoMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableproductoMouseReleased

    }//GEN-LAST:event_jTableproductoMouseReleased

    private void jTableproductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableproductoMouseClicked

    }//GEN-LAST:event_jTableproductoMouseClicked

    private void btnrelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrelatorioActionPerformed

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String txtdata = sdf.format(data.getDate());
        String txtdata1 = sdf.format(data1.getDate());
        Vendadao ndao = new Vendadao();

        JasperPrint jasperPrint = null;
        JRResultSetDataSource rel = new JRResultSetDataSource((ResultSet) ndao.relatorioProducto(txtdata, txtdata1));
        HashMap params = new HashMap<>();

        //Passândo parâmetros e convertendo o dados pra ser compativel
        params.put("dataInicio", txtdata);
        params.put("dataFim", txtdata1);
        Sobredao sdao = new Sobredao();
        sdao.visualizar().forEach((s) -> {
            params.put("nomeLoja", s.getNome());
        });

        try {

            jasperPrint = JasperFillManager.fillReport("report/RelatorioProdutos.jasper", params, rel);
            String data = new SimpleDateFormat("dd MM yyyy_HH mm ss").format(Calendar.getInstance().getTime());
            JasperExportManager.exportReportToPdfFile(jasperPrint, "C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\BControl\\Producto(" + data + ").pdf");
        } catch (JRException ex) {
            Logger.getLogger(Productos.class.getName()).log(Level.SEVERE, null, ex);
        }
        JasperViewer view = new JasperViewer(jasperPrint, false);
        view.setVisible(false);


    }//GEN-LAST:event_btnrelatorioActionPerformed

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
            java.util.logging.Logger.getLogger(Productos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Productos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Painel;
    private javax.swing.JButton btnlimpar;
    private javax.swing.JButton btnprocurar;
    private javax.swing.JButton btnrelatorio;
    private com.toedter.calendar.JDateChooser data;
    private com.toedter.calendar.JDateChooser data1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelqtdproducto;
    private javax.swing.JLabel jLabelqtdproducto1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableproducto;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables

}
