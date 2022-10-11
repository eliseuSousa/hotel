package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.ConnectionFactory;
import model.bean.Hospede;
import views.Sucesso;

public class HospedeDAO {
	
	public boolean insert(Hospede h) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		boolean status = false;
		
		String sql = "INSERT INTO HOTEL.HOSPEDES("
				+ "ID_HOSPEDE,"
				+ "NOME,"
				+ "SOBRENOME,"
				+ "DATA_NASCIMENTO,"
				+ "NACIONALIDADE,"
				+ "TELEFONE,"
				+ "ID_RESERVA)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?);";
		
		try {
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, h.getIdHospede());
			stmt.setString(2, h.getNome());
			stmt.setString(3, h.getSobrenome());
			stmt.setString(4, h.getDataNascimento());
			stmt.setString(5, h.getNacionalidade());
			stmt.setString(6, h.getTelefone());
			stmt.setString(7, h.getIdReserva());
			
			stmt.executeUpdate();
			
			status = true;
			
			Sucesso newView = new Sucesso();
			newView.setVisible(true);
		} catch (SQLException e) {
			System.out.println("erro ao inserir um novo hóspede: "+e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(conn, stmt);
		}
		
		return status;
	}
	
	public List<Hospede> read() {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Hospede> hospedes = new ArrayList<>();
		String sql = "SELECT * FROM HOTEL.HOSPEDES;";
		
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				Hospede h = new Hospede();
				
				h.setIdHospede(rs.getString("ID_HOSPEDE"));
				h.setNome(rs.getString("NOME"));
				h.setSobrenome(rs.getString("SOBRENOME"));
				h.setDataNascimento(rs.getString("DATA_NASCIMENTO"));
				h.setNacionalidade(rs.getString("NACIONALIDADE"));
				h.setTelefone(rs.getString("TELEFONE"));
				h.setIdReserva(rs.getString("ID_RESERVA"));
				
				hospedes.add(h);
				
			}
		} catch (SQLException e) {
			System.out.println("Erro ao buscar dados dos hóspedes.");
		} finally {
			ConnectionFactory.closeConnection(conn, stmt);
		}
		
		return hospedes;
	}

	public boolean update(Hospede h) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		boolean status = false;
		
		String sql = "UPDATE HOTEL.HOSPEDES SET "
				+ "NOME = ?,"
				+ "SOBRENOME = ?,"
				+ "DATA_NASCIMENTO = ?,"
				+ "NACIONALIDADE = ?,"
				+ "TELEFONE = ? "
				+ "WHERE ID_HOSPEDE = ?;";
		
		try {
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, h.getNome());
			stmt.setString(2, h.getSobrenome());
			stmt.setString(3, h.getDataNascimento());
			stmt.setString(4, h.getNacionalidade());
			stmt.setString(5, h.getTelefone());
			stmt.setString(6, h.getIdHospede());
			
			stmt.executeUpdate();
			
			status = true;
			
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar hóspede: "+e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(conn, stmt);
		}
		
		return status;
	}
	
	public boolean delete(String idReserva) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		boolean status = false;
		
		String sql = "DELETE FROM HOTEL.HOSPEDES WHERE ID_RESERVA = ?;";
		
		try {
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, idReserva);
			
			stmt.executeUpdate();
			
			status = true;
			
		} catch(SQLException e) {
			System.out.println("Erro ao deletar hóspede: "+e.getMessage());
		} finally {
			 ConnectionFactory.closeConnection(conn, stmt);
		}
		
		return status;
	}
	
	public List<Hospede> searchHospedes(String nome) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		ResultSet rs = null;
		List<Hospede> hospedes = new ArrayList<>();
		
		String sql = "SELECT * FROM HOTEL.HOSPEDES WHERE NOME LIKE ?;";
		
		try {
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, "%"+nome+"%");
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				Hospede h = new Hospede();
				h.setIdHospede(rs.getString("ID_HOSPEDE"));
				h.setNome(rs.getString("NOME"));
				h.setSobrenome(rs.getString("SOBRENOME"));
				h.setDataNascimento(rs.getString("DATA_NASCIMENTO"));
				h.setNacionalidade(rs.getString("NACIONALIDADE"));
				h.setTelefone(rs.getString("TELEFONE"));
				h.setIdReserva(rs.getString("ID_RESERVA"));
				
				hospedes.add(h);
			}
			
		} catch(SQLException e) {
			System.out.println("Erro ao pesquisar hóspedes: "+e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(conn, stmt);
		}

		return hospedes;
	}
}