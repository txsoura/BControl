/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import coneccao.Coneccao;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;

/**
 *
 * @author Victor
 */
public class Usuariodao {

    private Connection con = null;

    public Usuariodao() {
        con = Coneccao.getConnection();
    }
//metodo para visualizar usuario no inicio 

    public List<Usuario> funcionario() {
        Connection con = Coneccao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Usuario> Usuarios = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM usuario");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario Usuario = new Usuario();
                Usuario.setNome(rs.getString("nome"));
                Usuarios.add(Usuario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Usuariodao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Coneccao.closeconnection(con, stmt, rs);
        }
        return Usuarios;
    }
//metodo para verificar se usuario existe no inicio

    public boolean verificar(String nome, String senha) throws UnsupportedEncodingException {
        Connection con = Coneccao.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        boolean check = false;
        List<Usuario> usuarios = new ArrayList<>();
        try {

            stmt = con.prepareStatement("SELECT * FROM usuario WHERE nome=? and senha=SHA1(?)");
            stmt.setString(1, nome);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();

            if (rs.next()) {
                check = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Usuariodao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Coneccao.closeconnection(con, stmt, rs);
        }
        return check;
    }
//metodo para editar senha o usuario

    public boolean editar(String nome, String senha) throws UnsupportedEncodingException {
        String sql = "UPDATE usuario SET senha=SHA1(?) WHERE nome=?";
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement(sql);
            stmt.setString(1, senha);
            stmt.setString(2, nome);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro" + ex);
            return false;
        } finally {
            Coneccao.closeconnection(con, stmt);
        }
    }

    //metodo que cadastra usuario
    public boolean adicionar(String nome) throws Exception {
        String sql = "INSERT INTO usuario (nome,senha) VALUES (?,SHA1(12345))";
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.err.println("Erro" + ex);
            return false;
        }

    }

    //metodo para apagar usuario
    public boolean apagar(Usuario usuario) {
        String sql = "DELETE FROM usuario WHERE nome=?";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
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
