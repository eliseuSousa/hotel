package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class MenuUsuario extends JFrame {
	
	private JPanel contentPane;
	int xMouse, yMouse;
	private JLabel lblExit;
	private JLabel lblRegistro;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				MenuUsuario frame = new MenuUsuario();
				frame.setVisible(true);
			}
		});
	}
	
	public MenuUsuario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuUsuario.class.getResource("/img/hotel_40px.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 944, 609);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		JPanel header = new JPanel();
		header.addMouseMotionListener(new MouseAdapter() {
		
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
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(12, 138, 199));
		panelMenu.setBounds(0, 0, 257, 609);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JPanel btnBuscar = new JPanel();
		btnBuscar.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBuscar.setBackground(new Color(118, 187, 223));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnBuscar.setBackground(new Color(12, 138, 199));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				TabelasViews buscar = new TabelasViews();
				buscar.setVisible(true);
				dispose();
			}
		});
		
		btnBuscar.setBounds(0, 312, 257, 56);
		btnBuscar.setBackground(new Color(12, 138, 199));
		btnBuscar.setLayout(null);
		btnBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panelMenu.add(btnBuscar);
		
		JLabel lblBuscaDeReservas = new JLabel("Busca");
		lblBuscaDeReservas.setIcon(new ImageIcon(MenuUsuario.class.getResource("/img/pessoas.png")));
		lblBuscaDeReservas.setBounds(30, 11, 200, 34);
		lblBuscaDeReservas.setHorizontalAlignment(SwingConstants.LEFT);
		lblBuscaDeReservas.setForeground(Color.WHITE);
		lblBuscaDeReservas.setFont(new Font("Roboto", Font.PLAIN, 18));
		btnBuscar.add(lblBuscaDeReservas);
		
		JLabel logo = new JLabel("");
		logo.setBounds(50, 	50, 150, 150);
		panelMenu.add(logo);
		logo.setIcon(new ImageIcon(MenuUsuario.class.getResource("/img/hotel_150px.png")));
		
		JPanel btnRegistro = new JPanel();
		btnRegistro.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseEntered(MouseEvent e) {
				btnRegistro.setBackground(new Color(118, 187, 223));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnRegistro.setBackground(new Color(12, 138, 199));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				RegistroReserva reservas = new RegistroReserva();
				reservas.setVisible(true);
				dispose();
			}
		});
		btnRegistro.setBounds(0, 255, 257, 56);
		btnRegistro.setBackground(new Color(12, 138, 199));
		panelMenu.add(btnRegistro);
		btnRegistro.setLayout(null);
		btnRegistro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		lblRegistro = new JLabel("Registro");
		lblRegistro.setIcon(new ImageIcon(MenuUsuario.class.getResource("/img/reservado.png")));
		lblRegistro.setForeground(SystemColor.text);
		lblRegistro.setBounds(25, 11, 205, 34);
		lblRegistro.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblRegistro.setHorizontalAlignment(SwingConstants.LEFT);
		btnRegistro.add(lblRegistro);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(26, 219, 201, 2);
		panelMenu.add(separator);
		header.setLayout(null);
		header.setBackground(Color.WHITE);
		header.setBounds(0, 0, 944, 36);
		contentPane.add(header);
		
		JPanel btnExit = new JPanel();
		btnExit.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseClicked(MouseEvent e) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnExit.setBackground(Color.red);
				lblExit.setForeground(Color.white);
			}
			
			@Override 
			public void mouseExited(MouseEvent e) {
				btnExit.setBackground(Color.white);
				lblExit.setForeground(Color.black);
			}
		});
	
		btnExit.setLayout(null);
		btnExit.setBounds(891, 0, 53, 36);
		header.add(btnExit);
		
		lblExit = new JLabel("X");
		lblExit.setBounds(0, 0, 53, 36);
		btnExit.add(lblExit);
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		JPanel panelFecha = new JPanel();
		panelFecha.setBackground(new Color(118, 187, 223));
		panelFecha.setBounds(256, 84, 688, 121);
		contentPane.add(panelFecha);
		panelFecha.setLayout(null);
		
		JLabel lblTituloPrincipal = new JLabel("Sistema de reservas Hotel");
		lblTituloPrincipal.setBounds(180, 11, 356, 42);
		panelFecha.add(lblTituloPrincipal);
		lblTituloPrincipal.setForeground(Color.white);
		lblTituloPrincipal.setFont(new Font("Roboto", Font.PLAIN, 24));
		
		JLabel labelFecha = new JLabel("New Label");
		labelFecha.setBounds(35, 64, 294, 36);
		panelFecha.add(labelFecha);
		labelFecha.setForeground(Color.white);
		labelFecha.setFont(new Font("Roboto", Font.PLAIN, 30));
		// Data atual
		Date fechaAtual = new Date();
		// Formata a data em uma string
		String fecha = new SimpleDateFormat("dd/MM/yyyy").format(fechaAtual);
		// Estabelece a data na label
		labelFecha.setText("Hoje é "+fecha);
		
		JLabel lblTitulo = new JLabel("Bem-vindo");
		lblTitulo.setFont(new Font("Roboto", Font.BOLD, 24));
		lblTitulo.setBounds(312, 234, 147, 46);
		contentPane.add(lblTitulo);
		
		String descricao = "<html><body>Sistema de reservas de hotéis. Controle e gerencie de forma otimizada e fácil o fluxo de reservas e hóspedes do hotel.</body></html>";
		JLabel lblDescricao = new JLabel(descricao);
		lblDescricao.setFont(new Font("Roboto", Font.PLAIN, 17));
		lblDescricao.setBounds(312, 291, 598, 66);
		contentPane.add(lblDescricao);
		
		String descricao1 = "<html><body> Esta ferramenta permitirá que você mantenha um controle completo e detalhado de suas reservas e hóspedes, você terá acesso a ferramentas especiais para tarefas específicas como:</body></html>";
		JLabel lblDescricao1 = new JLabel(descricao1);
		lblDescricao1.setFont(new Font("Roboto", Font.PLAIN, 17));
		lblDescricao1.setBounds(312, 345, 569, 88);
		contentPane.add(lblDescricao1);
		
		JLabel descricao2 = new JLabel("- Registro de Reservas e Hóspedes");
		descricao2.setFont(new Font("Roboto", Font.PLAIN, 17));
		descricao2.setBounds(332, 444, 295, 27);
		contentPane.add(descricao2);
		
		JLabel descricao3 = new JLabel("- Edição de Reservas e Hóspedes existentes");
		descricao3.setFont(new Font("Roboto", Font.PLAIN, 17));
		descricao3.setBounds(332, 482, 375, 27);
		contentPane.add(descricao3);
		
		JLabel descricao4 = new JLabel("- Excluir todos os tipos de registros");
		descricao4.setFont(new Font("Roboto", Font.PLAIN, 17));
		descricao4.setBounds(332, 520, 295, 27);
		contentPane.add(descricao4);
	}
	
	private void headerMousePressed(java.awt.event.MouseEvent event) {
        xMouse = event.getX();
        yMouse = event.getY();
    }
	
	public void headerMouseDragged(java.awt.event.MouseEvent event) {
		int x = event.getXOnScreen();
        int y = event.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
	}
}
