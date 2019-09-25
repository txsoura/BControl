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
import modelo.Funcionario;

/**
 *
 * @author Victor
 */
public class Funcionariodao {

    private Connection con = null;

    public Funcionariodao() {
        con = Coneccao.getConnection();
    }

    //metodo que visualiza os funcionarios
    public List<Funcionario> visualizar() {
        Connection con = Coneccao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Funcionario> Funcionarios = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM funcionario");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario Funcionario = new Funcionario();
                Funcionario.setNome(rs.getString("nome"));
                Funcionario.setContacto(rs.getInt("contacto"));
                Funcionario.setEndereco(rs.getString("endereco"));
                Funcionarios.add(Funcionario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Funcionariodao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Coneccao.closeconnection(con, stmt, rs);
        }
        return Funcionarios;
    }

    //metodo que procura os funcionarios
    public List<Funcionario> procurar(String funcionario) {
        Connection con = Coneccao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Funcionario> Funcionarios = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM funcionario WHERE nome=?");
            stmt.setString(1, funcionario);
            rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionario Funcionario = new Funcionario();
                Funcionario.setNome(rs.getString("nome"));
                Funcionario.setContacto(rs.getInt("contacto"));
                Funcionario.setEndereco(rs.getString("endereco"));
                Funcionarios.add(Funcionario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Funcionariodao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Coneccao.closeconnection(con, stmt, rs);
        }
        return Funcionarios;
    }

    //metodo que cadastra o funcionario
    public boolean adicionar(String nome, String endereco, int contacto) throws Exception {
        String sql = "INSERT INTO funcionario (nome,contacto,endereco) VALUES (?,?,?)";
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setInt(2, contacto);
            stmt.setString(3, endereco);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro" + ex);
            return false;
        }

    }

    //metodo para apagar funcioanrio
    public boolean apagar(Funcionario funcionario) {
        String sql = "DELETE FROM funcionario WHERE nome=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, funcionario.getNome());
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
