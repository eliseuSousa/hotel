package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.Format;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class ReservasView extends JFrame{

	private JPanel contentPane;
	public static JTextField campoValor;
	public static JDateChooser dataEntrada;
	public static JDateChooser dataSaida;
	public static JComboBox<Format> formaPagamento;
	int xMouse, yMouse;
	private JLabel labelExit;
	private JLabel labelValorSimbolo;
	private JLabel labelAtras;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				ReservasView frame = new ReservasView();
				frame.setVisible(true);
			}
		});
	}
	
	public ReservasView() {
		super("Reserva");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ReservasView.class.getResource("/img/hotel_40px.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 560);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 910, 560);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JSeparator separatorCheckIn= new JSeparator();
		separatorCheckIn.setForeground(new Color(12, 138, 199));
		separatorCheckIn.setBackground(new Color(12, 138, 199));
		separatorCheckIn.setBounds(68, 195, 289, 2);
		panel.add(separatorCheckIn);
		
		JSeparator separatorCheckOut = new JSeparator();
		separatorCheckOut.setForeground(new Color(12, 138, 199));
		separatorCheckOut.setBackground(new Color(12, 138, 199));
		separatorCheckOut.setBounds(68, 281, 289, 11);
		panel.add(separatorCheckOut);
		
		JSeparator separatorValorReserva = new JSeparator();
		separatorValorReserva.setBackground(new Color(12, 138, 199));
		separatorValorReserva.setForeground(new Color(12, 138, 199));
		separatorValorReserva.setBounds(68, 362, 289, 2);
		panel.add(separatorValorReserva);
		
		JSeparator separatorFormaPagamento = new JSeparator();
		separatorFormaPagamento.setForeground(new Color(12, 138, 199));
		separatorFormaPagamento.setBackground(new Color(12, 138, 199));
		separatorFormaPagamento.setBounds(68, 453, 289, 2);
		panel.add(separatorFormaPagamento);
		
		dataEntrada = new JDateChooser();
		dataEntrada.getCalendarButton().setBackground(new Color(12, 138, 199));
		dataEntrada.getCalendarButton().setIcon(new ImageIcon(ReservasView.class.getResource("/img/icon-reservas.png")));
		dataEntrada.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 12));
		dataEntrada.setBounds(68, 161, 289, 35);
		dataEntrada.getCalendarButton().setBounds(268, 0, 21, 33);
		dataEntrada.setBackground(Color.WHITE);
		dataEntrada.setBorder(new LineBorder(SystemColor.window));
		dataEntrada.setDateFormatString("yyyy-MM-dd");
		dataEntrada.setFont(new Font("Roboto", Font.PLAIN, 18));
		panel.add(dataEntrada);
		
		labelValorSimbolo = new JLabel("$");
		labelValorSimbolo.setVisible(true);
		labelValorSimbolo.setBounds(68, 332, 17, 25);
		labelValorSimbolo.setBackground(new Color(12, 138, 199));
		labelValorSimbolo.setForeground(new Color(12, 138, 199));
		labelValorSimbolo.setFont(new Font("Roboto", Font.BOLD, 17));
		panel.add(labelValorSimbolo);
		
		JLabel labelCheckIn = new JLabel("DATA DE CHECK IN");
		labelCheckIn.setBackground(SystemColor.textInactiveText);
		labelCheckIn.setBounds(68, 136, 200, 14);
		labelCheckIn.setFont(new Font("Roboto Black", Font.BOLD, 18));
		panel.add(labelCheckIn);
		
		JLabel labelCheckOut = new JLabel("DATA DE CHECK OUT");
		labelCheckOut.setBackground(SystemColor.textHighlight);
		labelCheckOut.setBounds(68, 221, 220, 14);
		labelCheckOut.setFont(new Font("Roboto Black", Font.BOLD, 18));
		panel.add(labelCheckOut);
		
		dataSaida = new JDateChooser();
		dataSaida.getCalendarButton().setIcon(new ImageIcon(ReservasView.class.getResource("/img/icon-reservas.png")));
		dataSaida.getCalendarButton().setFont(new Font("Roboto", Font.PLAIN, 11));
		dataSaida.setBounds(68, 246, 289, 35);
		dataSaida.getCalendarButton().setBounds(267, 1, 21, 31);
		dataSaida.setBackground(new Color(12, 138, 199));
		dataSaida.getCalendarButton().setBackground(new Color(12, 138, 199));
		dataSaida.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		dataSaida.addPropertyChangeListener(new PropertyChangeListener() {
			
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				//Ativa o evento, após o usuário selecionar as datas, o valor da reserva deve ser calculado
			}
		});
		
		dataSaida.setDateFormatString("yyyy-MM-dd");
		dataSaida.setBorder(new LineBorder(new Color(255, 255, 255), 0));
		panel.add(dataSaida);
		
		campoValor = new JTextField();
		campoValor.setBackground(SystemColor.text);
		campoValor.setHorizontalAlignment(SwingConstants.LEFT);
		campoValor.setForeground(Color.BLACK);
		campoValor.setBounds(90, 328, 270, 33);
		campoValor.setFont(new Font("Roboto Black", Font.BOLD, 17));
		campoValor.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		campoValor.setColumns(10);
		panel.add(campoValor);
		
		JLabel labelValor = new JLabel("VALOR DA RESERVA");
		labelValor.setForeground(SystemColor.textHighlight);
		labelValor.setBounds(72, 303, 220, 14);
		labelValor.setFont(new Font("Roboto Black", Font.BOLD, 18));
		panel.add(labelValor);
		
		formaPagamento = new JComboBox();
		formaPagamento.setBounds(68, 417, 289, 38);
		formaPagamento.setBackground(SystemColor.text);
		formaPagamento.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		formaPagamento.setFont(new Font("Roboto", Font.PLAIN, 16));
		formaPagamento.setModel(new DefaultComboBoxModel(new String[] {"Cartão de Crédito", "Cartão de Débito", "Dinheiro"}));
		panel.add(formaPagamento);
		
		JLabel labelFormaPagamento = new JLabel("FORMA DE PAGAMENTO");
		labelFormaPagamento.setForeground(SystemColor.textHighlight);
		labelFormaPagamento.setBounds(68, 382, 240, 24);
		labelFormaPagamento.setFont(new Font("Roboto Black", Font.BOLD, 18));
		panel.add(labelFormaPagamento);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(428, 0, 482, 560);
		panel_1.setBackground(new Color(12, 138, 199));
		panel_1.setLayout(null);
		panel.add(panel_1);
		
		JLabel logo = new JLabel("");
		logo.setBounds(197, 68, 104, 107);
		panel_1.add(logo);
		logo.setIcon(new ImageIcon(ReservasView.class.getResource("/img/hotel_100px.png")));
		
		JLabel imgBg = new JLabel("");
		imgBg.setBounds(0, 140, 500, 409);
		imgBg.setIcon(new ImageIcon(ReservasView.class.getResource("/img/reservas-img-3.png")));
		imgBg.setBackground(Color.WHITE);
		panel_1.add(imgBg);
		
		JPanel btnExit = new JPanel();
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuPrincipal principal = new MenuPrincipal();
				principal.setVisible(true);
				dispose();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnExit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnExit.setBackground(new Color(12, 138, 199));
			     labelExit.setForeground(Color.white);
			}
		});
		
		btnExit.setLayout(null);
		btnExit.setBackground(new Color(12, 138, 199));
		btnExit.setBounds(429, 0, 53, 36);
		panel_1.add(btnExit);
		
		labelExit = new JLabel("X");
		labelExit.setForeground(Color.WHITE);
		labelExit.setBounds(0, 0, 53, 36);
		btnExit.add(labelExit);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		
		JPanel header = new JPanel();
		header.setBounds(0, 0, 910, 36);
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
		panel.add(header);
		
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
				labelAtras.setForeground(Color.white);
			}			
			@Override
			public void mouseExited(MouseEvent e) {
				 btnAtras.setBackground(Color.white);
			     labelAtras.setForeground(Color.black);
			}
		});
		
		btnAtras.setLayout(null);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(0, 0, 53, 36);
		header.add(btnAtras);
		
		labelAtras = new JLabel("<");
		labelAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelAtras);
		labelAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		
		JPanel btnNext = new JPanel();
		btnNext.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseClicked(MouseEvent e) {
				if(ReservasView.dataEntrada.getDate() != null && ReservasView.dataSaida.getDate() != null) {
					RegistroHospede registroHospede = new RegistroHospede();
					registroHospede.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Deve preencher todos os campos.");
				}
		 	}
		});
		
		btnNext.setLayout(null);
		btnNext.setBackground(new Color(12, 138, 199));
		btnNext.setBounds(238, 473, 122, 35);
		panel.add(btnNext);
		btnNext.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		JLabel lblBtnNext= new JLabel("PRÓXIMO");
		lblBtnNext.setHorizontalAlignment(SwingConstants.CENTER);
		lblBtnNext.setForeground(Color.WHITE);
		lblBtnNext.setFont(new Font("Roboto", Font.PLAIN, 18));
		lblBtnNext.setBounds(0, 0, 122, 35);
		btnNext.add(lblBtnNext);
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
