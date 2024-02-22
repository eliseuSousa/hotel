package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import jdbc.ConnectionFactory;
import model.bean.Hospede;
import views.Sucesso;

public class HospedeDAO {
	
	public boolean insert(Hospede h) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		boolean status = false;
		
		String sql = "insert into hotel.hospedes("
			+ "id_hospede,"
			+ "nome,"
			+ "sobrenome,"
			+ "data_nascimento,"
			+ "nacionalidade,"
			+ "telefone,"
			+ "id_reserva)"
			+ "values(?, ?, ?, ?, ?, ?, ?);";
		
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
			JOptionPane.showMessageDialog(null, "Erro ao inserir novo hóspede.");
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
		String sql = "select * from hotel.hospedes;";
		
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				Hospede h = new Hospede();
				
				h.setIdHospede(rs.getString("id_reserva"));
				h.setNome(rs.getString("nome"));
				h.setSobrenome(rs.getString("sobrenome"));
				h.setDataNascimento(rs.getString("data_nascimento"));
				h.setNacionalidade(rs.getString("nacionalidade"));
				h.setTelefone(rs.getString("telefone"));
				h.setIdReserva(rs.getString("id_reserva"));
				
				hospedes.add(h);
				
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar dados dos hóspedes.");
		} finally {
			ConnectionFactory.closeConnection(conn, stmt);
		}
		
		return hospedes;
	}

	public boolean update(Hospede h) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		boolean status = false;
		
		String sql = "update hotel.hospedes set "
			+ "nome = ?,"
			+ "sobrenome = ?,"
			+ "data_nascimento = ?,"
			+ "nacionalidade = ?,"
			+ "telefone = ? "
			+ "where id_hospede = ?;";
		
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
			JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados dos hóspedes.");
		} finally {
			ConnectionFactory.closeConnection(conn, stmt);
		}
		
		return status;
	}
	
	public boolean delete(String idReserva) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		boolean status = false;
		
		String sql = "delete from hotel.hospedes where id_reserva = ?;";
		
		try {
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, idReserva);
			
			stmt.executeUpdate();
			
			status = true;
			
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao deletar hóspede.");
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
		
		String sql = "select * from hotel.hospedes where nome like ?;";
		
		try {
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, "%"+nome+"%");
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				Hospede h = new Hospede();
				h.setIdHospede(rs.getString("id_hospede"));
				h.setNome(rs.getString("nome"));
				h.setSobrenome(rs.getString("sobrenome"));
				h.setDataNascimento(rs.getString("data_nascimento"));
				h.setNacionalidade(rs.getString("nacionalidade"));
				h.setTelefone(rs.getString("telefone"));
				h.setIdReserva(rs.getString("id_reserva"));
				
				hospedes.add(h);
			}
			
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao pesquisar hóspedes.");
		} finally {
			ConnectionFactory.closeConnection(conn, stmt);
		}

		return hospedes;
	}
}