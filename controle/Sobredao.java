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
import modelo.Sobre;

/**
 *
 * @author Victor
 */
public class Sobredao {

    private Connection con = null;

    public Sobredao() {
        con = Coneccao.getConnection();
    }

//metodo para aumentar estoque
    public boolean alterar(String nome, int contacto, int nuit, String endereco) throws Exception {
        String sql = "UPDATE  sobre SET nome=?,contacto=?,nuit=?,endereco=? ";
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setInt(2, contacto);
            stmt.setInt(3, nuit);
            stmt.setString(4, endereco);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro" + ex);
            return false;
        }

    }

    //metodo para visualizar sobre
    public List<Sobre> visualizar() {
        Connection con = Coneccao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Sobre> Sobres = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM sobre");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Sobre Sobre = new Sobre();
                Sobre.setNome(rs.getString("nome"));
                Sobre.setNuit(rs.getInt("nuit"));
                Sobre.setContacto(rs.getInt("contacto"));
                Sobre.setEndereco(rs.getString("endereco"));
                Sobres.add(Sobre);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Cupomdao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Coneccao.closeconnection(con, stmt, rs);
        }
        return Sobres;
    }
    //apagar todas tabelas
    public boolean reiniciar() throws Exception {
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("TRUNCATE TABLE cesto");
            stmt.executeUpdate();
            stmt = con.prepareStatement("TRUNCATE TABLE funcionario");
            stmt.executeUpdate();
            stmt = con.prepareStatement("TRUNCATE TABLE produto");
            stmt.executeUpdate();
            stmt = con.prepareStatement("DELETE FROM usuario WHERE nome!=?");
            stmt.setString(1, "DKaras");
            stmt.executeUpdate();
            stmt = con.prepareStatement("TRUNCATE TABLE venda");
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
