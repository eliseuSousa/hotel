package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConexaoDB {
	private String url = "jdbc:mysql://localohos/HOTEL";
	private String user = "root";
	private String password = "";
	
	public void insertReservaDB(String idReserva, String dataE, String dataS, float valor, String formaPagamento) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexao = DriverManager.getConnection(url, user, password);
			
			String insert = "INSERT INTO HOTEL.RESERVAS("
					+ "ID_RESERVA,"
					+ "DATA_ENTRADA,"
					+ "DATA_SAIDA,"
					+ "VALOR,"
					+ "FORMA_PAGAMENTO)"
					+ "VALUES(?, ?, ?, ?, ?);";
			
			PreparedStatement ps = conexao.prepareStatement(insert);
			
			ps.setString(1, idReserva);
			ps.setString(2, dataE);
			ps.setString(3, dataS);
			ps.setFloat(4, valor);
			ps.setString(5, formaPagamento);
			
			ps.execute();
		} 
		catch(ClassNotFoundException e) {
			System.out.println("Driver não encontrado");
		}
		catch (SQLException e) {
			System.out.println("Ocorreu um erro com o banco de dados: "+e.getMessage());
		}
	}
	
}
