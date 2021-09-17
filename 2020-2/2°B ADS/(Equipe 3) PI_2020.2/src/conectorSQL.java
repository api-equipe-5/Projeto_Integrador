package br.com.cliente.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conectar {
static String url = "jdbc:mysql://localhost/iacit";
static String usuario = "root";
static String senha = "";
static Connection con;

        public static Connection getConexao() throws SQLException{
            try{
                Class.forName("org.gjt.mm.mysql.Driver");
                   if(con == null){
                    con = (Connection) DriverManager.getConnection(url, usuario, senha);
                    }
                return con;
                }catch(ClassNotFoundException e){
                throw new SQLException(e.getMessage());
                }
            }
}
