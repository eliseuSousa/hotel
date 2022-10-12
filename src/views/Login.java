package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Login extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	private JLabel lblExit;
	int xMouse, yMouse;
	
	private String USUARIO = "adm";
	private String SENHA = "adm";
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				Login frame = new Login();
				frame.setVisible(true);				
			}
		});
	}
	
	public Login() {
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 788, 527);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 788, 527);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(12, 138, 199));
		panel_1.setBounds(484, 0, 304, 527);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel imgHotel = new JLabel();
		imgHotel.setBounds(0, 0, 384, 538);
		panel_1.add(imgHotel);
		imgHotel.setIcon(new ImageIcon(Login.class.getResource("/img/img_hotel_login.png")));
		
		JPanel btnExit = new JPanel();
		btnExit.setBounds(251, 0, 52, 36);
		panel_1.add(btnExit);
		btnExit.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnExit.setBackground(Color.red);
				lblExit.setForeground(Color.WHITE);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnExit.setBackground(new Color(12, 138, 199));
				lblExit.setForeground(Color.WHITE);
			}
		});
		btnExit.setBackground(new Color(12, 138, 199));
		btnExit.setLayout(null);
		btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		lblExit = new JLabel("X");
		lblExit.setBounds(0, 0, 53, 36);
		lblExit.setLayout(null);
		btnExit.add(lblExit);
		lblExit.setForeground(SystemColor.text);
		lblExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		
		txtUsuario = new JTextField();
		txtUsuario.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mousePressed(MouseEvent e) {
				if(txtUsuario.getText().equals("Digite seu nome de usuário")) {
					txtUsuario.setText("");
					txtUsuario.setForeground(Color.black);
				}
				
				if(String.valueOf(txtSenha.getPassword()).isEmpty()) {
					txtSenha.setText("********");
					txtSenha.setForeground(Color.gray);
				}
			}
		});
		txtUsuario.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtUsuario.setText("Digite seu nome de usuário");
		txtUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtUsuario.setForeground(SystemColor.activeCaptionBorder);
		txtUsuario.setBounds(65, 256, 324, 32);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 120, 215));
		separator.setBounds(65, 292, 324, 2);
		panel.add(separator);
		
		JLabel lblTitulo = new JLabel("LOGIN");
		lblTitulo.setForeground(SystemColor.textHighlight);
		lblTitulo.setFont(new Font("Roboto Black", Font.PLAIN, 26));
		lblTitulo.setBounds(196, 150, 89, 26);
		panel.add(lblTitulo);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(SystemColor.textHighlight);
		separator_1.setBounds(65, 393, 324, 2);
		panel.add(separator_1);
		
		txtSenha = new JPasswordField();
		txtSenha.setText("********");
		txtSenha.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mousePressed(MouseEvent e) {
				if(String.valueOf(txtSenha.getPassword()).equals("********")) {
					txtSenha.setText("");
					txtSenha.setForeground(Color.black);
				}
				if(txtUsuario.getText().isEmpty()) {
					txtUsuario.setText("Digite seu nome de usuário");
					txtUsuario.setForeground(Color.gray);
				}
			}
		});
		txtSenha.setForeground(SystemColor.activeCaptionBorder);
		txtSenha.setFont(new Font("Roboto", Font.PLAIN, 16));
		txtSenha.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		txtSenha.setBounds(65, 353, 324, 32);
		panel.add(txtSenha);
		
		JLabel usuarioLabel = new JLabel("USUÁRIO");
		usuarioLabel.setForeground(SystemColor.textInactiveText);
		usuarioLabel.setFont(new Font("Roboto black", Font.PLAIN, 20));
		usuarioLabel.setBounds(65, 219, 107, 26);
		panel.add(usuarioLabel);
		
		JLabel senhaLabel = new JLabel("SENHA");
		senhaLabel.setForeground(SystemColor.textInactiveText);
		senhaLabel.setFont(new Font("Roboto black", Font.PLAIN, 20));
		senhaLabel.setBounds(65, 316, 140, 26);
		panel.add(senhaLabel);
		
		JPanel btnLogin = new JPanel();
		btnLogin.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogin.setBackground(new Color(0, 156, 223));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnLogin.setBackground(SystemColor.textHighlight);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				autenticarLogin();
			}
		});
		btnLogin.setBackground(SystemColor.textHighlight);
		btnLogin.setBounds(65, 431, 122, 44);
		panel.add(btnLogin);
		btnLogin.setLayout(null);
		btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

		JLabel labelEntrar = new JLabel("Entrar");
		labelEntrar.setBounds(0, 0, 122, 44);
		btnLogin.add(labelEntrar);
		labelEntrar.setForeground(SystemColor.controlHighlight);
		labelEntrar.setHorizontalAlignment(SwingConstants.CENTER);
		labelEntrar.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		JLabel logo = new JLabel("");
		logo.setHorizontalAlignment(SwingConstants.CENTER);
		logo.setIcon(new ImageIcon(Login.class.getResource("/img/LOGO_50PX.png")));
		logo.setBounds(65, 65, 48, 59);
		panel.add(logo);
		
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
		header.setBackground(SystemColor.window);
		header.setBounds(0, 0, 784, 36);
		panel.add(header);
		header.setLayout(null);
	}
	
	private void autenticarLogin() {
		
		String usuarioInformado = txtUsuario.getText();
		String senhaInformada = new String(txtSenha.getPassword());

		if(usuarioInformado.equals(USUARIO) && senhaInformada.equals(SENHA)) {
			MenuUsuario  menu = new MenuUsuario();
			menu.setVisible(true);
			dispose();
		} else {
			JOptionPane.showMessageDialog(this, "Usuário ou senha inválidos");
		}
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