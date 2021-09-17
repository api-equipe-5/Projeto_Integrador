package br.com.fatec.model;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserInterface {
    private static DataBase dataBase;
    
    public static ArrayList<String> tables() throws SQLException, ClassNotFoundException {
        UserInterface.dataBase = new DataBase();
        return UserInterface.dataBase.getTables();
    }
    
    @SuppressWarnings("rawtypes")
	public static ArrayList<ArrayList> columns(final String tableName) throws ClassNotFoundException, SQLException {
        UserInterface.dataBase = new DataBase();
        return UserInterface.dataBase.getColumns(tableName);
    }
    
    public static void insert(final String t, final String tCol, final String sCol, final String s) throws ClassNotFoundException, SQLException {
        (UserInterface.dataBase = new DataBase()).insertInto(t, tCol, sCol, s);
    }
}