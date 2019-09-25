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
public class Cupomdao {

    private Connection con = null;
    private Producto[] p;

    public Cupomdao() {
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
            stmt = con.prepareStatement("SELECT * FROM produto where preco<0");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Producto Producto = new Producto();
                Producto.setCodigo(rs.getString("codigo"));
                Producto.setNome(rs.getString("nome"));
                Producto.setQuantidade(rs.getInt("quantidade"));
                Producto.setPreco(rs.getDouble("preco"));
                Productos.add(Producto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Cupomdao.class.getName()).log(Level.SEVERE, null, ex);
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
            stmt = con.prepareStatement("SELECT * FROM produto WHERE codigo LIKE ? and preco<0");
            stmt.setString(1, codigo);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Producto Producto = new Producto();
                Producto.setCodigo(rs.getString("codigo"));
                Producto.setNome(rs.getString("nome"));
                Producto.setQuantidade(rs.getInt("quantidade"));
                Producto.setPreco(rs.getDouble("preco"));
                Productos.add(Producto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Cupomdao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Coneccao.closeconnection(con, stmt, rs);
        }
        return Productos;
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

//metodo para adicionar productos
    public boolean cadastrar(String nome, int quantidade, double preco, String categoria) throws Exception {
        String sql = "INSERT INTO produto (nome,preco,desconto,quantidade,codigo,data) VALUES (?,?,0,?,?,NOW())";
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, "-" + preco);
            stmt.setDouble(3, quantidade);
            stmt.setString(4, categoria);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro" + ex);
            return false;
        }

    }

    //metodo para apagar cupom
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
