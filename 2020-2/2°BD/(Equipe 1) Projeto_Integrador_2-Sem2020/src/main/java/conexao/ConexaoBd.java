package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoBd {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/cadastro_contas?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "digitador";
    private static final String PASS = "admin";
    
    // Metodo para fazer a conexao junto a base de dados mysql.
    public static Connection getConnection() {

        try {
            //Buscando a classe for name do Driver.
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
            // Criando uma exceção com throw caso a conexao não de certo
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexão: ", ex);
        }
    }
    // Metodo para fechar a conexao quando ela deixar de ser usada
    public static void closeConnection(Connection con) {
        try {
            // Verificando se a conexão é diferente de nulo, ou seja caso a conexão esteja aberta
            if (con != null) {
                con.close();
            }
            // Exceção caso se caso a conexão não seja fechada
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Metodo inicia fechando a conexão, usando o metodo anterior, e fechando o statement (sobrecarga)
    public static void closeConnection(Connection con, PreparedStatement stmt) {
        
        closeConnection(con);

        try {

            if (stmt != null) {
                stmt.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Metodo inicia fechando a conexão e o statement, usando o metodo anterior, e fechando o result (sobrecarga)
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {

        closeConnection(con, stmt);

        try {

            if (rs != null) {
                rs.close();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBd.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
