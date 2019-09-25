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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Venda;

/**
 *
 * @author Victor
 */
public class Vendadao {

    private Connection con = null;

    public Vendadao() {
        con = Coneccao.getConnection();
    }

//metodo para procurar vendas do funcionario

    public List<Venda> procurarminha(String data, String data1, String funcionario) {
        Connection con = Coneccao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Venda> Vendas = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM venda WHERE data BETWEEN ? and ? and funcionario=?");
            stmt.setString(1, data);
            stmt.setString(2, data1);
            stmt.setString(3, funcionario);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Venda Venda = new Venda();
                Venda.setCodigo(rs.getString("codigo"));
                Venda.setNome(rs.getString("nome"));
                Venda.setQuantidade(rs.getInt("quantidade"));
                Venda.setPreco(rs.getDouble("total"));
                Venda.setData(rs.getString("data"));
                Vendas.add(Venda);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Vendadao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Coneccao.closeconnection(con, stmt, rs);
        }
        return Vendas;
    }

    //metodo para adicionar vendas ao relatorio
    public ResultSet relatorioVendas(String data, String data1) {
        Connection con = Coneccao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT codigo,sum(quantidade) as quantidade ,sum( total) as total,funcionario,data FROM venda WHERE data BETWEEN ? and ? GROUP BY codigo");
            stmt.setString(1, data);
            stmt.setString(2, data1);
            rs = stmt.executeQuery();
            ResultSetMetaData rsMetaData = rs.getMetaData();

        } catch (SQLException ex) {

        }
        return rs;
    }

//metodo para adicionar vendas do funcionario ao relatorio
    public ResultSet relatorioFuncionario(String data, String data1, String funcionario) {
        Connection con = Coneccao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM venda WHERE data BETWEEN ? and ? and funcionario=?");
            stmt.setString(1, data);
            stmt.setString(2, data1);
            stmt.setString(3, funcionario);
            rs = stmt.executeQuery();
            ResultSetMetaData rsMetaData = rs.getMetaData();

        } catch (SQLException ex) {

        }
        return rs;
    }
//metodo para visualizar vendas 

    public List<Venda> visualizar() {
        Connection con = Coneccao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Venda> Vendas = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM venda");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Venda Venda = new Venda();
                Venda.setCodigo(rs.getString("codigo"));
                Venda.setNome(rs.getString("nome"));
                Venda.setQuantidade(rs.getInt("quantidade"));
                Venda.setPreco(rs.getDouble("total"));
                Venda.setFuncionario(rs.getString("funcionario"));
                Venda.setData(rs.getString("data"));
                Vendas.add(Venda);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Vendadao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Coneccao.closeconnection(con, stmt, rs);
        }
        return Vendas;
    }
//metodo para procurar vendas 

    public List<Venda> procurar(String data, String data1) {
        Connection con = Coneccao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Venda> Vendas = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM venda WHERE data BETWEEN ? and ?");
            stmt.setString(1, data);
            stmt.setString(2, data1);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Venda Venda = new Venda();
                Venda.setCodigo(rs.getString("codigo"));
                Venda.setNome(rs.getString("nome"));
                Venda.setQuantidade(rs.getInt("quantidade"));
                Venda.setPreco(rs.getDouble("total"));
                Venda.setFuncionario(rs.getString("funcionario"));
                Venda.setData(rs.getString("data"));
                Vendas.add(Venda);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Vendadao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Coneccao.closeconnection(con, stmt, rs);
        }
        return Vendas;
    }
//metodo para calcular o total das vendas

    public double total() {
        double t = 0;
        Connection con = Coneccao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM Venda ");
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
//metodo para procurar total das vendas

    public double procurartotal(String data, String data1) {
        double t = 0;
        Connection con = Coneccao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM Venda WHERE data BETWEEN ? and ? ");
            stmt.setString(1, data);
            stmt.setString(2, data1);
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

    //metodo para efectuar venda
    public boolean vender() throws Exception {
        String sql = "INSERT INTO venda (codigo,nome,quantidade,total) SELECT codigo,nome,quantidade,total FROM cesto";
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro" + ex);
            return false;
        }

    }
//metodo para definir dados da venda

    public boolean funcionario(String funcionario, String cliente, int contacto) throws Exception {
        String sql = "UPDATE  venda SET funcionario=?,data=NOW() ,cliente=? ,contacto=? WHERE funcionario is null";
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement(sql);
            stmt.setString(1, funcionario);
            stmt.setString(2, cliente);
            stmt.setInt(3, contacto);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro" + ex);
            return false;
        }

    }
    //metodo para visualizar productos

    public List<Venda> visualizarProducto() {
        Connection con = Coneccao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Venda> Productos = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT codigo,sum(quantidade) as q ,sum( total) as t FROM venda GROUP BY codigo");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Venda Producto = new Venda();
                Producto.setCodigo(rs.getString("codigo"));
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
//metodo para procurar productos

    public List<Venda> procurarProducto(String data, String data1) {
        Connection con = Coneccao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Venda> Productos = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT codigo,sum(quantidade) as q ,sum( total) as t FROM venda WHERE data BETWEEN ? and ? GROUP BY codigo");
            stmt.setString(1, data);
            stmt.setString(2, data1);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Venda Producto = new Venda();
                Producto.setCodigo(rs.getString("codigo"));
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

    //metodo para adicionar productos vendidos ao relatorio
    public ResultSet relatorioProducto(String data, String data1) {
        Connection con = Coneccao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement("SELECT codigo,sum(quantidade) as quantidade ,sum( total) as total FROM venda WHERE data BETWEEN ? and ? GROUP BY codigo");
            stmt.setString(1, data);
            stmt.setString(2, data1);
            rs = stmt.executeQuery();
            ResultSetMetaData rsMetaData = rs.getMetaData();

        } catch (SQLException ex) {

        }
        return rs;
    }

    //metodo para visualizar cliente
    public List<Venda> visualizarCliente() {
        Connection con = Coneccao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Venda> Productos = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT sum(quantidade) as q ,sum( total) as t,cliente FROM venda GROUP BY cliente");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Venda Producto = new Venda();
                Producto.setQuantidade(rs.getInt("q"));
                Producto.setPreco(rs.getInt("t"));
                Producto.setCliente(rs.getString("cliente"));
                Productos.add(Producto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Productodao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Coneccao.closeconnection(con, stmt, rs);
        }
        return Productos;
    }

//metodo para procurar cliente
    public List<Venda> procurarCliente(String cliente) {
        Connection con = Coneccao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Venda> Productos = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT sum(quantidade) as q ,sum( total) as t,cliente FROM venda WHERE cliente LIKE ? GROUP BY cliente");
            stmt.setString(1, cliente);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Venda Producto = new Venda();
                Producto.setQuantidade(rs.getInt("q"));
                Producto.setPreco(rs.getInt("t"));
                Producto.setCliente(rs.getString("cliente"));
                Productos.add(Producto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Productodao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Coneccao.closeconnection(con, stmt, rs);
        }
        return Productos;
    }

}
