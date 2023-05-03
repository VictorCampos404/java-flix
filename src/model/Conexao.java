package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static final String DATABASE = "javaflix_db";
	private static final String HOST = "localhost:3306";
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String	URL = "jdbc:mysql://" + HOST + "/" + DATABASE;
	private static final String USR = "root";
	private static final String PWD = "";
	
	public static Connection getConnection(){
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USR, PWD);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Erro: " + e.getMessage());
			return null;
		}
	}
	
	public static void dispose(Connection con) {
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}
