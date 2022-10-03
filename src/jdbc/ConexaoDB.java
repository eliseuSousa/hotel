package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConexaoDB {
	
	private String url = "jdbc:mysql://localhost/HOTEL";
	private String user = "root";
	private String password = "";
	
	public boolean insertReservaDB(String idReserva, String dataE, String dataS, float valor, String formaPagamento) {
		
		boolean retornaStatus = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexao = DriverManager.getConnection(url, user, password);
			PreparedStatement ps;
			
			String insertReserva = "INSERT INTO HOTEL.RESERVAS("
					+ "ID_RESERVA,"
					+ "DATA_ENTRADA,"
					+ "DATA_SAIDA,"
					+ "VALOR,"
					+ "FORMA_PAGAMENTO)"
					+ "VALUES(?, ?, ?, ?, ?);";
			
			ps = conexao.prepareStatement(insertReserva);
			
			ps.setString(1, idReserva);
			ps.setString(2, dataE);
			ps.setString(3, dataS);
			ps.setFloat(4, valor);
			ps.setString(5, formaPagamento);
			
			retornaStatus = ps.execute();
		} 
		catch(ClassNotFoundException e) {
			System.out.println("Driver não encontrado");
			return false;
		}
		catch (SQLException e) {
			System.out.println("Ocorreu um erro com o banco de dados: "+e.getMessage());
			return false;
		}
		
		return retornaStatus;
	}
	
	public boolean insertHospedeDB(String idHospede, String nome, String sobrenome, String dataNascimento, String nacionalidade, String telefone, String idReserva) {
		
		boolean retornaStatus = false;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conexao = DriverManager.getConnection(url, user, password);
			PreparedStatement ps;
			
			String inserHospede = "INSERT INTO HOTEL.HOSPEDES ("
					+ "ID_HOSPEDE,"
					+ "NOME,"
					+ "SOBRENOME,"
					+ "DATA_NASCIMENTO,"
					+ "NACIONALIDADE,"
					+ "TELEFONE,"
					+ "ID_RESERVA)"
					+ "VALUES("
					+ "?, ?, ?, ?, ?, ?, ?);";
			
			ps = conexao.prepareStatement(inserHospede);
			
			ps.setString(1, idHospede);
			ps.setString(2, nome);
			ps.setString(3, sobrenome);
			ps.setString(4, dataNascimento);
			ps.setString(5, nacionalidade);
			ps.setString(6, telefone);
			ps.setString(7, idReserva);
			
			retornaStatus = ps.execute();
			
		} 
		catch(ClassNotFoundException e) {
			System.out.println("Driver não encontrado");
		}
		catch (SQLException e) {
			System.out.println("Ocorreu um erro com o banco de dados: "+e.getMessage());
		}
		
		return retornaStatus;
	}
	
}
