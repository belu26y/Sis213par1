package igu;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class PaginaPrincipal extends JFrame {

	private JPanel contentPane;



	public PaginaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(0, 0, 900, 600);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 149, 383, 352);
		panel_1.setBackground(Color.RED);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(10, 259, 364, 60);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(WIDTH);
			}
		});
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setForeground(Color.BLACK);
		btnSalir.setFont(new Font("Impact", Font.BOLD | Font.ITALIC, 30));
		panel_1.add(btnSalir);
		
		JButton btnTareas = new JButton("Tareas");
		btnTareas.setBounds(10, 21, 364, 60);
		btnTareas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tareas pantalla = new Tareas();
				pantalla.setVisible(true);
				pantalla.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnTareas.setForeground(Color.BLACK);
		btnTareas.setFont(new Font("Impact", Font.BOLD | Font.ITALIC, 30));
		btnTareas.setBackground(Color.WHITE);
		panel_1.add(btnTareas);
		
		JButton btnReportes = new JButton("Reportes");
		btnReportes.setBounds(10, 98, 364, 60);
		btnReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pedidos pantalla = new Pedidos();
				pantalla.setVisible(true);
				pantalla.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnReportes.setForeground(Color.BLACK);
		btnReportes.setFont(new Font("Impact", Font.BOLD | Font.ITALIC, 30));
		btnReportes.setBackground(Color.WHITE);
		panel_1.add(btnReportes);
		
		JButton btnNosotros = new JButton("Nosotros");
		btnNosotros.setBounds(10, 179, 364, 60);
		btnNosotros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNosotros.setForeground(Color.BLACK);
		btnNosotros.setFont(new Font("Impact", Font.BOLD | Font.ITALIC, 30));
		btnNosotros.setBackground(Color.WHITE);
		panel_1.add(btnNosotros);
		
		JLabel lblNotePadRY = new JLabel("NotePad RY");
		lblNotePadRY.setBounds(120, 43, 648, 66);
		lblNotePadRY.setHorizontalAlignment(SwingConstants.CENTER);
		lblNotePadRY.setForeground(Color.BLACK);
		lblNotePadRY.setFont(new Font("Impact", Font.BOLD | Font.ITALIC, 60));
		lblNotePadRY.setBackground(Color.WHITE);
		panel.add(lblNotePadRY);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(433, 149, 383, 352);
		lblLogo.setIcon(new ImageIcon("C:\\Users\\Rodrigo Edgar Tarifa\\Downloads\\Proyecto\\SABORES_FUSIONADOS-removebg-preview.png"));
		panel.add(lblLogo);
	}
}