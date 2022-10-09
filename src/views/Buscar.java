package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.bean.Hospede;
import model.bean.Reserva;
import model.dao.HospedeDAO;
import model.dao.ReservaDAO;

@SuppressWarnings("serial")
public class Buscar extends JFrame {
	
	private JPanel contentPane;
	private JTextField barraPesqisa;
	private JTable tabelaHospedes;
	private JTable tbReservas;
	private DefaultTableModel modeloReservas;
	private DefaultTableModel modeloHospedes;
	private JLabel labelBtnAtras;
	private JLabel labelBtnExit;
	int xMouse, yMouse;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Buscar frame = new Buscar();
				frame.setVisible(true);
			}
		});
	}
	
	public Buscar() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Buscar.class.getResource("/img/LOGO_50PX.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		setLocationRelativeTo(null);
		
		barraPesqisa = new JTextField();
		barraPesqisa.setBounds(536, 127, 193, 31);
		barraPesqisa.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(barraPesqisa);
		barraPesqisa.setColumns(10);
		
		JLabel lblTitulo = new JLabel("SISTEMA DE BUSCA");
		lblTitulo.setForeground(new Color(12, 138, 199));
		lblTitulo.setFont(new Font("Roboto Black", Font.BOLD, 18));
		lblTitulo.setBounds(368, 48, 280, 42);
		contentPane.add(lblTitulo);
		
		JTabbedPane panel = new JTabbedPane(JTabbedPane.TOP);
		panel.setBackground(new Color(12, 138, 199));
		panel.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.setBounds(20, 169, 865, 328);
		contentPane.add(panel);
		
		tbReservas = new JTable() {
			@Override
			public boolean isCellEditable(int rowIndex, int ColIndex) {
				return false;
			}
		};
		JScrollPane barraRolagemTbReservas = new JScrollPane(tbReservas);
		modeloReservas = (DefaultTableModel) tbReservas.getModel();
		modeloReservas.addColumn("Numero de Reserva");
		modeloReservas.addColumn("Data Check In");
		modeloReservas.addColumn("Data Check Out");
		modeloReservas.addColumn("Valor");
		modeloReservas.addColumn("Forma de Pagamento");
		tbReservas.getColumnModel().getColumn(0).setCellEditor(null);
		tbReservas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbReservas.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.addTab("Reservas", new ImageIcon(Buscar.class.getResource("/img/reservado.png")), barraRolagemTbReservas, null);
		
		ReservaDAO rdao = new ReservaDAO();
		for(Reserva r: rdao.read()) {
			modeloReservas.addRow(new Object[]{
					r.getIdReserva(),
					r.getDataE(),
					r.getDataS(),
					r.getValor(),
					r.getFormaPagamento()
			});
		}
		
		tabelaHospedes = new JTable() {
			@Override
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;
			}
		};
		JScrollPane barraRolagemTbHospedes = new JScrollPane(tabelaHospedes); 
		modeloHospedes = (DefaultTableModel) tabelaHospedes.getModel();
		modeloHospedes.addColumn("ID hóspede");
		modeloHospedes.addColumn("Nome");
		modeloHospedes.addColumn("Sobrenome");
		modeloHospedes.addColumn("Data de nasc.");
		modeloHospedes.addColumn("Nacionalidade");
		modeloHospedes.addColumn("Telefone");
		modeloHospedes.addColumn("ID reserva");
		tabelaHospedes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabelaHospedes.setFont(new Font("Roboto", Font.PLAIN, 16));
		panel.addTab("Hóspedes", new ImageIcon(Buscar.class.getResource("/img/pessoas.png")), barraRolagemTbHospedes, null);
		
		HospedeDAO hDAO = new HospedeDAO();
		for(Hospede h: hDAO.read()) {
			modeloHospedes.addRow(new Object[] {
				h.getIdHospede(),
				h.getNome(),
				h.getSobrenome(),
				h.getDataNascimento(),
				h.getNacionalidade(),
				h.getTelefone(),
				h.getIdReserva()
			});
		}
		
		JLabel newLabel = new JLabel("");
		newLabel.setIcon(new ImageIcon(Buscar.class.getResource("/img/hotel_100px.png")));
		newLabel.setBounds(56, 51, 104, 107);
		contentPane.add(newLabel);
		
		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseMotionAdapter() {
		
			@Override
			public void mouseDragged(MouseEvent e) {
				headerMouseDragged(e);
			}
		});
		
		header.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mousePressed(MouseEvent e) {
				headerMousePressed(e);	
			}
		});
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 910, 36);
		contentPane.add(header);
		
		JPanel btnAtras = new JPanel();
		btnAtras.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAtras.setBackground(new Color(12, 138, 199));
				labelBtnAtras.setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnAtras.setBackground(Color.WHITE);
				labelBtnAtras.setForeground(Color.BLACK);
			}
		});
		
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);
		
		labelBtnAtras = new JLabel("<");
		labelBtnAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelBtnAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelBtnAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelBtnAtras);
		
		JPanel btnExit = new JPanel();
		btnExit.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuUsuario usuario = new MenuUsuario();
				usuario.setVisible(true);
				dispose();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnExit.setBackground(Color.red);
				labelBtnExit.setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnExit.setBackground(Color.WHITE);
				labelBtnExit.setForeground(Color.BLACK);
			}
		});
		btnExit.setLayout(null);
		btnExit.setBackground(Color.white);
		btnExit.setBounds(857, 0, 53, 36);
		header.add(btnExit);
		
		labelBtnExit = new JLabel("X");
		labelBtnExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelBtnExit.setForeground(Color.BLACK);
		labelBtnExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelBtnExit.setBounds(0, 0, 53, 36);
		btnExit.add(labelBtnExit);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(12, 138, 199));
		separator.setBackground(new Color(12, 138, 199));
		separator.setBounds(539, 159, 193, 2);
		contentPane.add(separator);
		
		// Desenvolver lógica necessária
		JPanel btnBusca = new JPanel();
		btnBusca.addMouseListener(new MouseAdapter() {
		
			@Override 
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btnBusca.setLayout(null);
		btnBusca.setBackground(new Color(12, 138, 199));
		btnBusca.setBounds(748, 125, 122, 35);
		btnBusca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnBusca);
		
		JLabel labelBtnBusca = new JLabel("BUSCAR");
		labelBtnBusca.setHorizontalAlignment(SwingConstants.CENTER);
		labelBtnBusca.setForeground(Color.WHITE);
		labelBtnBusca.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelBtnBusca.setBounds(0, 0, 122, 35);
		btnBusca.add(labelBtnBusca);
		
		JPanel btnEditar = new JPanel();
		btnEditar.setLayout(null);
		btnEditar.setBackground(new Color(12, 138, 199));
		btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnEditar.setBounds(635, 508, 122, 35);
		btnEditar.addMouseListener(new MouseAdapter() {
					
			@Override
			public void mouseClicked(MouseEvent e) {
				int tabelaAtiva = panel.getSelectedIndex();
				
				if(tabelaAtiva == 0) {
					
					if(tbReservas.getSelectedRow() != -1) {
						
						Reserva reserva = new Reserva();
						
						reserva.setIdReserva(tbReservas.getValueAt(tbReservas.getSelectedRow(), 0).toString());
						reserva.setDataE(tbReservas.getValueAt(tbReservas.getSelectedRow(), 1).toString());
						reserva.setDataS(tbReservas.getValueAt(tbReservas.getSelectedRow(),2).toString());
						reserva.setValor((float) tbReservas.getValueAt(tbReservas.getSelectedRow(), 3));
						reserva.setFormaPagamento(tbReservas.getValueAt(tbReservas.getSelectedRow(), 4).toString());
						
						UpdateReservas updateReserva = new UpdateReservas(reserva);
						updateReserva.setVisible(true);
						
						dispose();
						
					} else {
						System.out.println("Selecione uma linha");
					}
					
				} else if(tabelaAtiva == 1) {
					
				} else {
					System.out.print("Algo inesperado aconteceu.");
				}
			}
		});
		contentPane.add(btnEditar);
		
		JLabel labelBtnEditar = new JLabel("EDITAR");
		labelBtnEditar.setHorizontalAlignment(SwingConstants.CENTER);
		labelBtnEditar.setForeground(Color.WHITE);
		labelBtnEditar.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelBtnEditar.setBounds(0, 0, 122, 35);
		btnEditar.add(labelBtnEditar);
		
		JPanel btnDeletar = new JPanel();
		btnDeletar.setLayout(null);
		btnDeletar.setBackground(new Color(12, 138, 199));
		btnDeletar.setBounds(767, 508, 122, 35);
		btnDeletar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		contentPane.add(btnDeletar);
		
		JLabel labelBtnDelatar = new JLabel("DELETAR");
		labelBtnDelatar.setHorizontalAlignment(SwingConstants.CENTER);
		labelBtnDelatar.setForeground(Color.WHITE);
		labelBtnDelatar.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelBtnDelatar.setBounds(0, 0, 122, 35);
		btnDeletar.add(labelBtnDelatar);
		setResizable(false);
	}
	
	private void headerMousePressed(java.awt.event.MouseEvent event) {
		xMouse = event.getX();
		yMouse = event.getY();
	}
	
	private void headerMouseDragged(java.awt.event.MouseEvent event) {
		int x = event.getXOnScreen();
		int y = event.getYOnScreen();
		this.setLocation(x - xMouse, y - yMouse);
	}
}