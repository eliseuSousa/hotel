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
import model.bean.Reserva;

public class ReservaDAO {

	public boolean insert(Reserva r) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		boolean status = false;
		
		String sql = "insert into hotel.reservas ("
			+ "id,"
			+ "data_entrada,"
			+ "data_saida,"
			+ "valor,"
			+ "forma_pagamento)"
			+ "values (?, ?, ?, ?, ?);";
		
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
			JOptionPane.showMessageDialog(null, "Erro ao inserir dados.");
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
		String sql = "select * from hotel.reservas;";
		
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				Reserva r = new Reserva();
				
				r.setIdReserva(rs.getString("id"));
				r.setDataE(rs.getString("data_entrada"));
				r.setDataS(rs.getString("data_saida"));
				r.setValor(rs.getFloat("valor"));
				r.setFormaPagamento(rs.getString("forma_pagamento"));
				
				reservas.add(r);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao buscar dados das reservas.");
		} finally {
			ConnectionFactory.closeConnection(conn, stmt);
		}
		
		return reservas;
	}
	
	public boolean update(Reserva r) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		boolean status = false;
		
		String sql = "update hotel.reservas set "
			+ "data_entrada = ?,"
			+ "data_saida = ?,"
			+ "valor = ?,"
			+ "forma_pagamento = ? "
			+ "where id = ?;";
		
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
			JOptionPane.showMessageDialog(null, "Erro ao atualizar dados da reserva.");
		} finally {
			ConnectionFactory.closeConnection(conn, stmt);
		}
		
		return status;
	}
	
	public boolean delete(String idReserva) {
		
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		boolean status = false;
		
		String sql = "delete from hotel.reservas where id = ?;";
		
		try {
			
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, idReserva);
			
			stmt.executeUpdate();	
			status = true;
		
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao deletar reserva.");
		} finally {
			ConnectionFactory.closeConnection(conn, stmt);
		}
		
		return status;
	}
	
	public List<Reserva> searchReservas(List<Hospede> hospedes) {
		
		Connection conn = ConnectionFactory.getConnection();
		
		List<Reserva> reservas = new ArrayList<>();
		
		String sql = "select * from hotel.reservas where id = ?;";
		
		try {
			
			PreparedStatement stmt = null;
			for(Hospede h: hospedes) {
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, h.getIdReserva());
				ResultSet rs = stmt.executeQuery();
				
				while(rs.next()) {
					Reserva reserva = new Reserva();
					reserva.setIdReserva(rs.getString("id"));
					reserva.setDataE(rs.getString("data_entrada"));
					reserva.setDataS(rs.getString("data_saida"));
					reserva.setValor(rs.getFloat("valor"));
					reserva.setFormaPagamento(rs.getString("forma_pagamento"));
					
					reservas.add(reserva);
				}
				
				stmt.close();
				rs.close();
			}
			
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao pesquisar reservas.");
		} finally {
			ConnectionFactory.closeConnection(conn);
		}
		
		return reservas;
	}
}
