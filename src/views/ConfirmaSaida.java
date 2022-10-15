package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ConfirmaSaida extends JDialog {
	
	private static final long serialVersionUID = 1L;
	private final JPanel contentPane = new JPanel();
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				ConfirmaSaida frame = new ConfirmaSaida();
				frame.setVisible(true);
			}
		});
	}
	
	public ConfirmaSaida() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ConfirmaSaida.class.getResource("/img/hotel_40px.png")));
		setBounds(100, 100, 394, 226);
		getContentPane().setLayout(new 	BorderLayout());
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPane, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ConfirmaSaida.class.getResource("/img/ponto-de-interrogacao.png")));
		lblNewLabel.setBounds(143, 11, 100, 100);
		contentPane.add(lblNewLabel);
		
		JLabel labelTitulo = new JLabel("Deseja fechar a aplicação?");
		labelTitulo.setForeground(new Color(12, 138, 199));
		labelTitulo.setFont(new Font("Roboto", Font.BOLD, 18));
		labelTitulo.setBounds(62, 122, 364, 21);
		contentPane.add(labelTitulo);
		
		JPanel btnExit = new JPanel();
		btnExit.addMouseListener(new MouseAdapter() {
		
			@Override 
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnExit.setBackground(new Color(124, 198, 254));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnExit.setBackground(new Color(12, 138, 199));
			}
		});
		btnExit.setLayout(null);
		btnExit.setBounds(110, 155, 73, 25);
		btnExit.setBackground(new Color(12, 138, 199));
		contentPane.add(btnExit);
		btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		JLabel labelBtnExit = new JLabel("SIM");
		labelBtnExit.setHorizontalAlignment(SwingConstants.CENTER);
		labelBtnExit.setForeground(Color.WHITE);
		labelBtnExit.setFont(new Font("Roboto", Font.BOLD, 18));
		labelBtnExit.setBounds(0, 2, 70, 22);
		btnExit.add(labelBtnExit);
		
		JPanel btnCancelar = new JPanel();
		btnCancelar.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCancelar.setBackground(new Color(124, 198, 254));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btnCancelar.setBackground(new Color(12, 138, 199));
			}
		});
		btnCancelar.setLayout(null);
		btnCancelar.setBounds(207, 155, 120, 25);
		btnCancelar.setBackground(new Color(12, 138, 199));
		contentPane.add(btnCancelar);
		btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		JLabel labelBtnCancelar = new JLabel("CANCELAR");
		labelBtnCancelar.setHorizontalAlignment(SwingConstants.CENTER);
		labelBtnCancelar.setBounds(4, 2, 110, 22);
		labelBtnCancelar.setForeground(Color.WHITE);
		labelBtnCancelar.setFont(new Font("Roboto", Font.BOLD, 18));
		btnCancelar.add(labelBtnCancelar);
	}
	
}
