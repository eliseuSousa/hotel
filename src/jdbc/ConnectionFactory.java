package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ConnectionFactory {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/HOTEL";
	private static final String USER = "root";
	private static final String PASS = "";
	
	public static Connection getConnection() {
		Connection myConn = null;
		try {
			Class.forName(DRIVER);
			myConn = DriverManager.getConnection(URL, USER, PASS);
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Driver não encontrado.");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados.");
		}
		
		return myConn;
	}
	
	public static void closeConnection(Connection conn) {
		try {
			if(conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao fechar conexão com o banco de dados");
		}
	}
	
	public static void closeConnection(Connection conn, PreparedStatement stmt) {
		closeConnection(conn);
		try {
			if(stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão com o banco de dados.");
		}
	}
}
