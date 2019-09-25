/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import coneccao.Coneccao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Producto;

/**
 *
 * @author Victor
 */
public class Productodao {

    private Connection con = null;
    private Producto[] p;

    public Productodao() {
        con = Coneccao.getConnection();
        p = new Producto[100];
    }
//metodo para visualizar productos

    public List<Producto> visualizar() {
        Connection con = Coneccao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Producto> Productos = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM produto WHERE preco>0");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Producto Producto = new Producto();
                Producto.setCodigo(rs.getString("codigo"));
                Producto.setNome(rs.getString("nome"));
                Producto.setQuantidade(rs.getInt("quantidade"));
                Producto.setPreco(rs.getDouble("preco"));
                Producto.setDesconto(rs.getByte("desconto"));
                Productos.add(Producto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Productodao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Coneccao.closeconnection(con, stmt, rs);
        }
        return Productos;
    }
//metodo para procurar productos

    public List<Producto> procurar(String codigo) {
        Connection con = Coneccao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Producto> Productos = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM produto WHERE codigo LIKE ? AND preco>0 ");
            stmt.setString(1, codigo);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Producto Producto = new Producto();
                Producto.setCodigo(rs.getString("codigo"));
                Producto.setNome(rs.getString("nome"));
                Producto.setQuantidade(rs.getInt("quantidade"));
                Producto.setPreco(rs.getDouble("preco"));
                Producto.setDesconto(rs.getByte("desconto"));
                Productos.add(Producto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Productodao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Coneccao.closeconnection(con, stmt, rs);
        }
        return Productos;
    }
//metodo para adicionar productos ao cesto 

    public boolean adicionar(String codigo, String nome, int quantidade, double total) throws Exception {
        String sql = "INSERT INTO cesto (codigo,nome,quantidade,total) VALUES (?,?,?,?)";
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement(sql);
            stmt.setString(1, codigo);
            stmt.setString(2, nome);
            stmt.setInt(3, quantidade);
            stmt.setDouble(4, total);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro" + ex);
            return false;
        }

    }
//metodo para reduzir estoque

    public boolean reduzir(String codigo, int quantidade) throws Exception {
        String sql = "UPDATE  produto SET quantidade=? WHERE codigo=?";
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement(sql);
            stmt.setInt(1, quantidade);
            stmt.setString(2, codigo);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro" + ex);
            return false;
        }

    }
//metodo para actualizar estoque

    public boolean quantidade(String codigo, int q) {
        Connection con = Coneccao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT (quantidade) FROM produto WHERE codigo=?");
            stmt.setString(1, codigo);
            rs = stmt.executeQuery();
            while (rs.next()) {
                q = q + rs.getInt("quantidade");
            }
            try {
                aumentar(codigo, q);
            } catch (Exception ex) {
                Logger.getLogger(Productodao.class.getName()).log(Level.SEVERE, null, ex);
            }

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Productodao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            Coneccao.closeconnection(con, stmt, rs);
        }

    }
//metodo para aumentar estoque

    public boolean aumentar(String codigo, int quantidade) throws Exception {
        String sql = "UPDATE  produto SET quantidade=?,data=NOW() WHERE codigo=?";
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement(sql);
            stmt.setInt(1, quantidade);
            stmt.setString(2, codigo);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro" + ex);
            return false;
        }

    }

    //metodo para editar o desconto
    public boolean desconto(String codigo, byte desconto) throws Exception {
        String sql = "UPDATE  produto SET desconto=? WHERE codigo=?";
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement(sql);
            stmt.setByte(1, desconto);
            stmt.setString(2, codigo);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro" + ex);
            return false;
        }

    }
//metodo para visualizar productos no cesto

    public List<Producto> visualizarcesto() {
        Connection con = Coneccao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Producto> Productos = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT codigo,nome,sum(quantidade) as q, sum(total) as t FROM cesto GROUP BY codigo");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Producto Producto = new Producto();
                Producto.setCodigo(rs.getString("codigo"));
                Producto.setNome(rs.getString("nome"));
                Producto.setQuantidade(rs.getInt("q"));
                Producto.setPreco(rs.getDouble("t"));
                Productos.add(Producto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Productodao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Coneccao.closeconnection(con, stmt, rs);
        }
        return Productos;
    }
//metodo para calcular total dos productos no cesto

    public double total() {
        double t = 0;
        Connection con = Coneccao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM cesto ");
            rs = stmt.executeQuery();
            while (rs.next()) {
                t += rs.getDouble("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Productodao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Coneccao.closeconnection(con, stmt, rs);
        }
        return t;
    }

//metodo para limpar o cesto
    public boolean limparcesto() throws Exception {
        String sql = "TRUNCATE TABLE cesto";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro" + ex);
            return false;
        } finally {
            Coneccao.closeconnection(con, stmt);
        }

    }
//metodo para tirar producto do cesto 

    public boolean apagar(String codigo) {
        String sql = "DELETE FROM cesto WHERE codigo=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, codigo);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro" + ex);
            return false;
        } finally {
            Coneccao.closeconnection(con, stmt);
        }
    }
//metodo para adicionar productos

    public boolean cadastrar(String nome, int quantidade, double preco, String categoria, byte desconto) throws Exception {
        String sql = "INSERT INTO produto (nome,preco,desconto,quantidade,codigo,data) VALUES (?,?,?,?,?,NOW())";
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setDouble(2, preco);
            stmt.setByte(3, desconto);
            stmt.setDouble(4, quantidade);
            stmt.setString(5, categoria);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro" + ex);
            return false;
        }

    }

    //metodo para apagar producto
    public boolean apagar(Producto producto) {
        String sql = "DELETE FROM produto WHERE codigo=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, producto.getCodigo());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro" + ex);
            return false;
        } finally {
            Coneccao.closeconnection(con, stmt);
        }
    }

}
