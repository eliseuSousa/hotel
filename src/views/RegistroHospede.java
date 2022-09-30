package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.Format;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

@SuppressWarnings("serial")
public class RegistroHospede extends JFrame {

	private JPanel contentPane;
	private JTextField campoNome;
	private JTextField campoSobrenome;
	private JTextField campoTelefone;
	private JTextField numeroReserva;
	private JDateChooser campoDataNascimento;
	private JComboBox<Format> nacionalidade;
	private JLabel labelExit;
	private JLabel labelBtnAtras;
	int xMouse, yMouse;
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				RegistroHospede frame = new RegistroHospede();
				frame.setVisible(true);
			}
		});
	}
	
	public RegistroHospede() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistroHospede.class.getResource("/img/LOGO_50PX.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 634);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setLayout(null);
		
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
		header.setBounds(0, 0, 910, 36);
		header.setLayout(null);
		header.setBackground(SystemColor.text);
		header.setOpaque(false);
		contentPane.add(header);
		
		JPanel btnExit = new JPanel();
		btnExit.setBounds(857, 0, 53, 36);
		header.add(btnExit);
		btnExit.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseClicked(MouseEvent e) {
				MenuPrincipal framePrincipal = new MenuPrincipal();
				framePrincipal.setVisible(true);
				dispose();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnExit.setBackground(Color.red);
				labelExit.setForeground(Color.white);
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnExit.setBackground(Color.white);
			    labelExit.setForeground(Color.black);
			}
		});
		btnExit.setLayout(null);
		btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btnExit.setBackground(Color.white);
		
		labelExit = new JLabel("X");
		labelExit.setBounds(0, 0, 53, 36);
		btnExit.add(labelExit);
		labelExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelExit.setForeground(SystemColor.black);
		labelExit.setFont(new Font("Roboto", Font.PLAIN, 18));
		
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
		btnAtras.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		header.add(btnAtras);
		
		labelBtnAtras = new JLabel("<");
		labelBtnAtras.setHorizontalAlignment(SwingConstants.CENTER);
		labelBtnAtras.setFont(new Font("Roboto", Font.PLAIN, 23));
		labelBtnAtras.setBounds(0, 0, 53, 36);
		btnAtras.add(labelBtnAtras);
		
		campoNome = new JTextField();
		campoNome.setFont(new Font("Roboto", Font.PLAIN, 16));
		campoNome.setBounds(560, 135, 285, 33);
		campoNome.setBackground(Color.white);
		campoNome.setColumns(10);
		campoNome.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(campoNome);
		
		campoSobrenome = new JTextField();
		campoSobrenome.setFont(new Font("Roboto", Font.PLAIN, 16));
		campoSobrenome.setBounds(560, 204, 285, 33);
		campoSobrenome.setColumns(10);
		campoSobrenome.setBackground(Color.white);
		campoSobrenome.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(campoSobrenome);
		
		campoDataNascimento = new JDateChooser();
		campoDataNascimento.setBounds(560, 278, 285, 36);
		campoDataNascimento.getCalendarButton().setIcon(new ImageIcon(RegistroHospede.class.getResource("/img/icon-reservas.png")));
		campoDataNascimento.getCalendarButton().setBackground(new Color(12, 138, 199));
		campoDataNascimento.setDateFormatString("yyyy-MM-dd");
		contentPane.add(campoDataNascimento);
		
		campoTelefone = new JTextField();
		campoTelefone.setFont(new Font("Roboto", Font.PLAIN, 16));
		campoTelefone.setBounds(560, 424, 285, 33);
		campoTelefone.setColumns(10);
		campoTelefone.setBackground(SystemColor.WHITE);
		campoTelefone.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(campoTelefone);
		
		numeroReserva = new JTextField();
		numeroReserva.setFont(new Font("Roboto Black", Font.PLAIN, 16));
		numeroReserva.setBounds(560, 495, 285, 33);
		numeroReserva.setColumns(10);
		numeroReserva.setBackground(Color.WHITE);
		numeroReserva.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		contentPane.add(numeroReserva);
		
		nacionalidade = new JComboBox<>();
		nacionalidade.setBounds(560, 350, 289, 36);
		nacionalidade.setBackground(SystemColor.text);
		nacionalidade.setFont(new Font("Roboto", Font.PLAIN, 16));
		nacionalidade.setModel(new DefaultComboBoxModel(new String[] {"alemão", "andorrano", "angolano", "antiguano", "saudita", "argelino", "argentino", "armênio", "australiano", "austríaco", "azerbaijano", "bahamense", "bangladês, bangladense", "barbadiano", "bahreinita", "belga", "belizenho", "beninês", "belarusso", "boliviano", "bósnio", "botsuanês", "brasileiro", "bruneíno", "búlgaro", "burkineonse, burkinabé", "burundês", "butanês", "cabo-verdiano", "camerounês", "cambojano", "catariano", "canadense", "cazaque", "chadiano", "chileno", "chinês", "cipriota", "colombiano", "comoriano", "congolês", "congolês", "sul-coreano", "norte-coreano", "costa-marfinense, marfinense", "costa-ricense", "croata", "cubano", "dinamarquês", "djiboutiano", "dominiquense", "egípcio", "salvadorenho", "emiradense, emirático", "equatoriano", "eritreu", "eslovaco", "esloveno", "espanhol", "estadunidense, (norte-)americano", "estoniano", "etíope", "fijiano", "filipino", "finlandês", "francês", "gabonês", "gambiano", "ganês ou ganense", "georgiano", "granadino", "grego", "guatemalteco", "guianês", "guineense", "guineense, bissau-guineense", "equato-guineense", "haitiano", "hondurenho", "húngaro", "iemenita", "cookiano", "marshallês", "salomonense", "indiano", "indonésio", "iraniano", "iraquiano", "irlandês", "islandês", "34", "jamaicano", "japonês", "jordaniano", "kiribatiano", "kuwaitiano", "laosiano", "lesotiano", "letão", "libanês", "liberiano", "líbio", "liechtensteiniano", "lituano", "luxemburguês", "macedônio", "madagascarense", "malásio37", "malawiano", "maldivo", "maliano", "maltês", "marroquino", "mauriciano", "mauritano", "mexicano", "myanmarense", "micronésio", "moçambicano", "moldovo", "monegasco", "mongol", "montenegrino", "namibiano", "nauruano", "nepalês", "nicaraguense", "nigerino", "nigeriano", "niuiano", "norueguês", "neozelandês", "omani", "neerlandês", "palauano", "palestino", "panamenho", "papua, papuásio", "paquistanês", "paraguaio", "peruano", "polonês, polaco", "português", "queniano", "quirguiz", "britânico", "centro-africano", "tcheco", "dominicano", "romeno", "ruandês", "russo", "samoano", "santa-lucense", "são-cristovense", "samarinês", "santomense", "são-vicentino", "seichelense", "senegalês", "sérvio", "singapurense", "sírio", "somaliano, somali", "sri-lankês", "suázi", "sudanês", "sul-sudanês", "sueco", "suíço", "surinamês", "tajique", "tailandês", "tanzaniano", "timorense", "togolês", "tonganês", "trinitário", "tunisiano", "turcomeno", "turco", "tuvaluano", "ucraniano", "ugandês", "uruguaio", "uzbeque", "vanuatuense", "vaticano", "venezuelano", "vietnamita", "zambiano", "zimbabueano"}));
		contentPane.add(nacionalidade);
		
		JLabel labelNome = new JLabel("NOME");
		labelNome.setBounds(562, 119, 255, 14);
		labelNome.setForeground(SystemColor.textInactiveText);
		labelNome.setFont(new Font("Roboto Black", Font.BOLD, 18));
		contentPane.add(labelNome);
		
		JLabel labelSobrenome = new JLabel("SOBRENOME");
		labelSobrenome.setBounds(562, 189, 255, 14);
		labelSobrenome.setForeground(SystemColor.textInactiveText);
		labelSobrenome.setFont(new Font("Roboto Black", Font.BOLD, 18));
		contentPane.add(labelSobrenome);
		
		JLabel labelDataNascimento = new JLabel("DATA DE NASCIMENTO");
		labelDataNascimento.setBounds(560, 256, 255, 14);
		labelDataNascimento.setForeground(SystemColor.textInactiveText);
		labelDataNascimento.setFont(new Font("Roboto Black", Font.BOLD, 18));
		contentPane.add(labelDataNascimento);
		
		JLabel labelNacionalidade = new JLabel("NACIONALIDADE");
		labelNacionalidade.setBounds(560, 326, 255, 14);
		labelNacionalidade.setForeground(SystemColor.textInactiveText);
		labelDataNascimento.setFont(new Font("Roboto Black", Font.BOLD, 18));
		contentPane.add(labelNacionalidade);
		
		JLabel labelTelefone = new JLabel("TELEFONE");
		labelTelefone.setBounds(562, 406, 253, 14);
		labelTelefone.setForeground(SystemColor.textInactiveText);
		labelTelefone.setFont(new Font("Roboto Black", Font.BOLD, 18));
		contentPane.add(labelTelefone);
		
		JLabel labelTitulo = new JLabel("REGISTRO HÓSPEDE");
		labelTitulo.setBounds(570, 55, 300, 30);
		labelTitulo.setBackground(new Color(12, 138, 199));
		labelTitulo.setForeground(new Color(12, 138, 199));
		labelTitulo.setFont(new Font("Roboto Black", Font.BOLD, 23));
		contentPane.add(labelTitulo);
		
		JLabel labelNumReserva = new JLabel("NÚMERO DE RESERVA");
		labelNumReserva.setBounds(558, 474, 253, 14);
		labelNumReserva.setForeground(SystemColor.textInactiveText);
		labelNumReserva.setFont(new Font("Roboto Black", Font.BOLD, 18));
		contentPane.add(labelNumReserva);
		
		JSeparator separatorNome = new JSeparator();
		separatorNome.setBounds(560, 170, 289, 2);
		separatorNome.setForeground(new Color(12, 138, 199));
		separatorNome.setBackground(new Color(12, 138, 199));
		contentPane.add(separatorNome);
		
		JSeparator separatorSobrenome= new JSeparator();
		separatorSobrenome.setBounds(560, 240, 289, 2);
		separatorSobrenome.setForeground(new Color(12, 138, 199));
		separatorSobrenome.setBackground(new Color(12, 138, 199));
		contentPane.add(separatorSobrenome);
		
		JSeparator separatorDataNasc = new JSeparator();
		separatorDataNasc.setBounds(560, 315, 289, 2);
		separatorDataNasc.setBackground(new Color(12, 138, 199));
		separatorDataNasc.setForeground(new Color(12, 138, 199));
		contentPane.add(separatorDataNasc);
		
		JSeparator separatorNacioanildade = new JSeparator();
		separatorNacioanildade.setBounds(560, 387, 289, 2);
		separatorNacioanildade.setBackground(new Color(12, 138, 199));
		separatorNacioanildade.setForeground(new Color(12, 138, 199));
		contentPane.add(separatorNacioanildade);
		
		JSeparator separatorTelefone = new JSeparator();
		separatorTelefone.setBounds(560, 457, 289, 2);
		separatorTelefone.setBackground(new Color(12, 138, 199));
		separatorTelefone.setForeground(new Color(12, 138, 199));
		contentPane.add(separatorTelefone);
		
		JSeparator separatorNumReserva = new JSeparator();
		separatorNumReserva.setBounds(560, 529, 289, 2);
		separatorNumReserva.setBackground(new Color(12, 138, 199));
		separatorNumReserva.setForeground(new Color(12, 138, 199));
		contentPane.add(separatorNumReserva);
		
		JPanel btnSalvar = new JPanel();
		btnSalvar.setBounds(723, 560, 122, 35);
		btnSalvar.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseClicked(MouseEvent e) {
				//String id_reserva = new ReservasView().getCodigoReserva();
				//System.out.println("ID de reserva: "+id_reserva);
			}
		});
		btnSalvar.setLayout(null);
		btnSalvar.setBackground(new Color(12, 138, 199));
		contentPane.add(btnSalvar);
		btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		JLabel labelSalvar = new JLabel("SALVAR");
		labelSalvar.setHorizontalAlignment(SwingConstants.CENTER);
		labelSalvar.setForeground(Color.WHITE);
		labelSalvar.setFont(new Font("Roboto", Font.PLAIN, 18));
		labelSalvar.setBounds(0, 0, 122, 35);
		btnSalvar.add(labelSalvar);
		
		JPanel panelBg = new JPanel();
		panelBg.setBounds(0, 0, 489, 634);
		panelBg.setBackground(new Color(12, 138, 199));
		contentPane.add(panelBg);
		panelBg.setLayout(null);
		
		JLabel imgBackground = new JLabel("");
		imgBackground.setBounds(0, 121, 479, 502);
		panelBg.add(imgBackground);
		imgBackground.setIcon(new ImageIcon(RegistroHospede.class.getResource("/img/registro.png")));
		
		JLabel logo = new JLabel("");
		logo.setBounds(194, 39, 104, 107);
		panelBg.add(logo);
		logo.setIcon(new ImageIcon(RegistroHospede.class.getResource("/img/hotel_100px.png")));
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
