package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Sucesso extends JDialog{
	
	private final JPanel contentPanel = new JPanel();
	
	public static void main(String[] args) {
		Sucesso dialog = new Sucesso();
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}
	
	public Sucesso() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sucesso.class.getResource("/img/hotel_40px.png")));
		setBounds(100, 100, 394, 226);
		getContentPane().setLayout(new 	BorderLayout());
		contentPanel.setBackground(SystemColor.control);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		contentPanel.setLayout(null);
		
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(Sucesso.class.getResource("/img/hotel_100px.png")));
			lblNewLabel.setBounds(143, 11, 100, 100);
			contentPanel.add(lblNewLabel);
		}
		
		{
			JLabel lblNewLabel_1 = new JLabel("Registro adicionado com sucesso");
			lblNewLabel_1.setForeground(new Color(12, 138, 199));
			lblNewLabel_1.setFont(new Font("Roboto", Font.BOLD, 18));
			lblNewLabel_1.setBounds(27, 122, 364, 21);
			contentPanel.add(lblNewLabel_1);
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton buttonOk = new JButton("OK");
				buttonOk.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
						MenuUsuario usuario =  new MenuUsuario();
						usuario.setVisible(true);
					}
				});
				buttonOk.setActionCommand("OK");
				buttonPane.add(buttonOk);
				getRootPane().setDefaultButton(buttonOk);
			}
			
		}
	}
}
