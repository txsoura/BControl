package coneccao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author victor tesoura jr
 */
public class Coneccao {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/bcontrol?zeroDateTimeBehavior=convertToNull";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conneccao", ex);
        }
    }

    public static void closeconnection(Connection con) {

        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            System.err.println("erro" + ex);
        }

    }

    public static void closeconnection(Connection con, PreparedStatement stnt) {

        try {
            if (stnt != null) {
                stnt.close();
            }
        } catch (SQLException ex) {
            System.err.println("erro" + ex);
        }

        closeconnection(con);
    }

    public static void closeconnection(Connection con, PreparedStatement stnt, ResultSet rs) {

        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            System.err.println("erro" + ex);
        }

        closeconnection(con, stnt);
    }
}
