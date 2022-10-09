package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.xml.stream.events.EntityReference;

import jdbc.ConnectionFactory;
import model.bean.Reserva;

public class ReservaDAO {

	public boolean insert(Reserva r) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		boolean status = false;
		
		String sql = "INSERT INTO HOTEL.RESERVAS("
				+ "ID_RESERVA,"
				+ "DATA_ENTRADA,"
				+ "DATA_SAIDA,"
				+ "VALOR,"
				+ "FORMA_PAGAMENTO)"
				+ "VALUES (?, ?, ?, ?, ?);";
		
		try {
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, r.getIdReserva());
			stmt.setString(2, r.getDataE());
			stmt.setString(3, r.getDataS());
			stmt.setFloat(4, r.getValor());
			stmt.setString(5, r.getFormaPagamento());
			
			stmt.executeUpdate();
			
			status = true;
			
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: "+e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(conn, stmt);
		}
		
		return status;
	}
	
	public List<Reserva> read() {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		List<Reserva> reservas = new ArrayList<>();
		String sql = "SELECT * FROM HOTEL.RESERVAS;";
		
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				Reserva r = new Reserva();
				
				r.setIdReserva(rs.getString("ID_RESERVA"));
				r.setDataE(rs.getString("DATA_ENTRADA"));
				r.setDataS(rs.getString("DATA_SAIDA"));
				r.setValor(rs.getFloat("VALOR"));
				r.setFormaPagamento(rs.getString("FORMA_PAGAMENTO"));
				
				reservas.add(r);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao conectar com o bannco de dados:"+e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(conn, stmt);
		}
		
		return reservas;
	}
	
	public boolean update(Reserva r) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		boolean status = false;
		
		String sql = "UPDATE HOTEL.RESERVAS SET "
				+ "DATA_ENTRADA = ?,"
				+ "DATA_SAIDA = ?,"
				+ "VALOR = ?,"
				+ "FORMA_PAGAMENTO = ? "
				+ "WHERE ID_RESERVA = ?;";
		
		try {
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, r.getDataE());
			stmt.setString(2, r.getDataS());
			stmt.setFloat(3, r.getValor());
			stmt.setString(4, r.getFormaPagamento());
			stmt.setString(5, r.getIdReserva());
			
			stmt.executeUpdate();
			status = true;
			
		} catch(SQLException e) {
			System.out.println("Problema ao executar o sql: "+e.getMessage());
		} finally {
			ConnectionFactory.closeConnection(conn, stmt);
		}
		
		return status;
	}
}
