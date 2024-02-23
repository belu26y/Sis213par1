package ProyectoTareas.igu;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import ProyectoTareas.logica.Tarea;
public class Tareas extends JFrame {
	
	private JPanel contentPane;
	DefaultTableModel modelo = new DefaultTableModel();
	private JTable tblProductos;
	private JTextField txtEliminar;
	private JTextField txtNombre;
	private JTextField txtDescripcion;
	private JTextField txtEstado;
	
	private TablaHashProductos tablaProductos;
	private JTextField txtBuscar;
	private JTextField txtPrioridad;
	private JTextField txtFecha;
	private JTextField txtNro;

	private void ActualizarTablaProductos() {
	    modelo.setRowCount(0); // Limpiar el modelo de la tabla antes de actualizar

	    for (Map.Entry<String, Producto> entry : tablaProductos.getTablaProductos().entrySet()) {
	        Producto producto = entry.getValue();
	        modelo.addRow(new Object[]{producto.getNombre(), producto.getDescripcion(), producto.getPrecio()});
	    }

	    tblProductos.setModel(modelo);
	    tblProductos.repaint();
	}
	
	public Tareas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(0, 0, 1000, 1000);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTareas = new JLabel("TAREAS");
		lblTareas.setBounds(355, 10, 328, 66);
		lblTareas.setHorizontalAlignment(SwingConstants.CENTER);
		lblTareas.setForeground(Color.BLACK);
		lblTareas.setFont(new Font("Impact", Font.BOLD | Font.ITALIC, 60));
		lblTareas.setBackground(Color.WHITE);
		panel.add(lblTareas);
		
		tablaProductos = new TablaHashProductos();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 107, 557, 405);
		panel.add(scrollPane);
		
		tblProductos = new JTable();
		tblProductos.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				
			},
			new String[] {
				"ID", "Nombre", "Descripcion", "Estado", "Prioridad", "Fecha"
			}
		));
		
		tblProductos.getColumnModel().getColumn(0).setPreferredWidth(10);
		tblProductos.getColumnModel().getColumn(1).setPreferredWidth(64);
		tblProductos.getColumnModel().getColumn(2).setPreferredWidth(150);
		tblProductos.getColumnModel().getColumn(3).setPreferredWidth(32);
		tblProductos.getColumnModel().getColumn(4).setPreferredWidth(32);
		tblProductos.getColumnModel().getColumn(5).setPreferredWidth(32);
		
		scrollPane.setViewportView(tblProductos);
		modelo.addColumn("ID");
		modelo.addColumn("Nombre");
		modelo.addColumn("Descripcion");
		modelo.addColumn("Estado");
		modelo.addColumn("Prioridad");
		modelo.addColumn("Fecha");
		
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(164, 675, 192, 43);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = txtEliminar.getText();
                Producto productoEncontrado = tablaProductos.buscarProducto(nombre);

                if (productoEncontrado != null) {
                    JOptionPane.showMessageDialog(null, "Producto encontrado:\nNombre: " + productoEncontrado.getNombre()
                            + "\nDescripción: " + productoEncontrado.getDescripcion() + "\nPrecio: " + productoEncontrado.getPrecio() + "\nProducto Eliminado Exitosamente");
                    tablaProductos.eliminarProducto(nombre);
    				ActualizarTablaProductos();
                } else {
                    JOptionPane.showMessageDialog(null, "Producto no encontrado");
                }
			}
		});
		panel.add(btnEliminar);
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setFont(new Font("Impact", Font.BOLD | Font.ITALIC, 30));
		btnEliminar.setBackground(Color.WHITE);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(690, 675, 192, 43);
		panel.add(btnBuscar);
		btnBuscar.setForeground(Color.BLACK);
		btnBuscar.setFont(new Font("Impact", Font.BOLD | Font.ITALIC, 30));
		btnBuscar.setBackground(Color.WHITE);
		
		JLabel lblNombreEliminar = new JLabel("Nombre (Eliminar):");
		lblNombreEliminar.setBounds(31, 574, 166, 30);
		lblNombreEliminar.setForeground(Color.BLACK);
		lblNombreEliminar.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreEliminar.setFont(new Font("Impact", Font.ITALIC, 20));
		panel.add(lblNombreEliminar);
		
		txtEliminar = new JTextField();
		txtEliminar.setBounds(216, 570, 118, 34);
		txtEliminar.setColumns(10);
		panel.add(txtEliminar);
		
		JButton btnBack = new JButton("");
		btnBack.setBounds(608, 335, 75, 75);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaginaPrincipal pantalla = new PaginaPrincipal();
				pantalla.setVisible(true);
				pantalla.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnBack.setIcon(new ImageIcon("C:\\Users\\Rodrigo Edgar Tarifa\\Downloads\\Proyecto\\descarga.png"));
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(btnBack);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(579, 108, 122, 25);
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setFont(new Font("Impact", Font.ITALIC, 20));
		panel.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(724, 108, 237, 25);
		txtNombre.setColumns(10);
		panel.add(txtNombre);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(589, 143, 122, 25);
		lblDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescripcion.setForeground(Color.BLACK);
		lblDescripcion.setFont(new Font("Impact", Font.ITALIC, 20));
		panel.add(lblDescripcion);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(579, 178, 122, 25);
		lblEstado.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstado.setForeground(Color.BLACK);
		lblEstado.setFont(new Font("Impact", Font.ITALIC, 20));
		panel.add(lblEstado);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(724, 143, 237, 25);
		txtDescripcion.setColumns(10);
		panel.add(txtDescripcion);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(724, 178, 237, 25);
		txtEstado.setColumns(10);
		panel.add(txtEstado);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(752, 320, 192, 43);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = txtNombre.getText();
                String descripcion = txtDescripcion.getText();
                double precio = Double.parseDouble(txtEstado.getText());
                
                Producto nuevoProducto = new Producto(nombre, descripcion, precio);

                tablaProductos.agregarProducto(nuevoProducto);
                
                ActualizarTablaProductos();
                
                JOptionPane optionPane = new JOptionPane("Se agrego Correctamente");
				optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
				JDialog dialog = optionPane.createDialog("Agregado Exitoso");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
			}
		});
		btnAgregar.setForeground(Color.BLACK);
		btnAgregar.setFont(new Font("Impact", Font.BOLD | Font.ITALIC, 30));
		btnAgregar.setBackground(Color.WHITE);
		panel.add(btnAgregar);
		
		JLabel lblNombreBuscar = new JLabel("Nombre (Buscar):");
		lblNombreBuscar.setBounds(618, 574, 166, 30);
		lblNombreBuscar.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreBuscar.setForeground(Color.BLACK);
		lblNombreBuscar.setFont(new Font("Impact", Font.ITALIC, 20));
		panel.add(lblNombreBuscar);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(808, 570, 118, 34);
		txtBuscar.setColumns(10);
		panel.add(txtBuscar);
		
		JButton btnRefresh = new JButton("");
		btnRefresh.setIcon(new ImageIcon("C:\\Users\\Rodrigo Edgar Tarifa\\Downloads\\Proyecto\\Recarga (1).png"));
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNombre.setText("");
				txtDescripcion.setText("");
				txtEstado.setText("");
				txtEliminar.setText("");
				txtBuscar.setText("");
			}
		});
		btnRefresh.setForeground(new Color(255, 140, 0));
		btnRefresh.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD | Font.ITALIC, 30));
		btnRefresh.setBackground(Color.BLACK);
		btnRefresh.setBounds(496, 643, 75, 75);
		panel.add(btnRefresh);
		
		txtPrioridad = new JTextField();
		txtPrioridad.setColumns(10);
		txtPrioridad.setBounds(724, 213, 237, 25);
		panel.add(txtPrioridad);
		
		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(724, 248, 237, 25);
		panel.add(txtFecha);
		
		txtNro = new JTextField();
		txtNro.setColumns(10);
		txtNro.setBounds(843, 47, 118, 25);
		panel.add(txtNro);
		
		JLabel lblNro = new JLabel("Nro:");
		lblNro.setHorizontalAlignment(SwingConstants.CENTER);
		lblNro.setForeground(Color.BLACK);
		lblNro.setFont(new Font("Impact", Font.ITALIC, 20));
		lblNro.setBounds(742, 47, 87, 25);
		panel.add(lblNro);
		
		JLabel lblPrioridad = new JLabel("Prioridad:");
		lblPrioridad.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrioridad.setForeground(Color.BLACK);
		lblPrioridad.setFont(new Font("Impact", Font.ITALIC, 20));
		lblPrioridad.setBounds(579, 213, 122, 25);
		panel.add(lblPrioridad);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha.setForeground(Color.BLACK);
		lblFecha.setFont(new Font("Impact", Font.ITALIC, 20));
		lblFecha.setBounds(579, 248, 122, 25);
		panel.add(lblFecha);
		
		
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                String nombreBusqueda = txtBuscar.getText();
                Producto productoEncontrado = tablaProductos.buscarProducto(nombreBusqueda);

                if (productoEncontrado != null) {
                    JOptionPane.showMessageDialog(null, "Producto encontrado:\nNombre: " + productoEncontrado.getNombre()
                            + "\nDescripción: " + productoEncontrado.getDescripcion() + "\nPrecio: " + productoEncontrado.getPrecio());
                } else {
                    JOptionPane.showMessageDialog(null, "Producto no encontrado");
                }
            }
        });
	}
}
