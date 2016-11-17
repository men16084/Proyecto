
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;

public class GUI {

	private JFrame frame;
	private JTextField tFCarne_I;
	private JTable tPrestamos;
	private JTextField tFCodigoLibro;
	private JTextField tFCarne_NP;
	private JTextField tFCodigoLibro_BP;
	private JTextField tFCarne_BP;
	
	private JButton btnAceptar_NP;
	private JComboBox<String> cBTiempo_P;
	private JButton btnDevolver;
	
	private Biblioteca biblioteca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
		
		biblioteca = new Biblioteca();

		LocalDate prestado = LocalDate.now();
		LocalDate vence = prestado.plusWeeks(1);

		//biblioteca.agregarPrestamo(new Prestamo(1356123, "Mein Kampf", 156894, "Roberto Robertito", prestado, vence, false));
		llenarTabla();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1102, 433);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel pSuperior = new JPanel();
		frame.getContentPane().add(pSuperior, BorderLayout.NORTH);
		pSuperior.setLayout(new BorderLayout(0, 0));
		
		JPanel pIngreso = new JPanel();
		pIngreso.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ingreso", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pSuperior.add(pIngreso, BorderLayout.WEST);
		pIngreso.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblCarn = new JLabel("Carn\u00E9:");
		lblCarn.setHorizontalAlignment(SwingConstants.CENTER);
		pIngreso.add(lblCarn);
		
		tFCarne_I = new JTextField();
		pIngreso.add(tFCarne_I);
		tFCarne_I.setColumns(10);
		
		JLabel lblCerrado = new JLabel("Cerrado");
		lblCerrado.setHorizontalAlignment(SwingConstants.CENTER);
		pIngreso.add(lblCerrado);
		
		JLabel lblAbierto = new JLabel("Abierto");
		lblAbierto.setHorizontalAlignment(SwingConstants.CENTER);
		pIngreso.add(lblAbierto);
		
		JPanel pEstadisticas = new JPanel();
		pEstadisticas.setBorder(new TitledBorder(null, "Estad\u00EDsticas", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		pSuperior.add(pEstadisticas);
		
		JLabel lblAlumnosDentro = new JLabel("Alumnos Dentro:");
		pEstadisticas.add(lblAlumnosDentro);
		
		JPanel pInferior = new JPanel();
		frame.getContentPane().add(pInferior, BorderLayout.CENTER);
		pInferior.setLayout(new BorderLayout(0, 0));
		
		JPanel pInferiorIzquierda = new JPanel();
		pInferior.add(pInferiorIzquierda, BorderLayout.WEST);
		pInferiorIzquierda.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pNuevoPrestamo = new JPanel();
		pNuevoPrestamo.setBorder(new TitledBorder(null, "Nuevo Pr\u00E9stamo", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		pInferiorIzquierda.add(pNuevoPrestamo);
		pNuevoPrestamo.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblCdigoLibro = new JLabel("C\u00F3digo Libro");
		pNuevoPrestamo.add(lblCdigoLibro);
		
		tFCodigoLibro = new JTextField();
		pNuevoPrestamo.add(tFCodigoLibro);
		tFCodigoLibro.setColumns(10);
		
		JLabel lblCarn_1 = new JLabel("Carn\u00E9:");
		pNuevoPrestamo.add(lblCarn_1);
		
		tFCarne_NP = new JTextField();
		pNuevoPrestamo.add(tFCarne_NP);
		tFCarne_NP.setColumns(10);
		
		JLabel lblTiempo = new JLabel("Tiempo:");
		pNuevoPrestamo.add(lblTiempo);
		
		cBTiempo_P = new JComboBox<String>();
		cBTiempo_P.setModel(new DefaultComboBoxModel<String>(new String[] {"1 semana", "2 semanas", "3 semanas", "1 mes"}));
		cBTiempo_P.setSelectedIndex(1);
		pNuevoPrestamo.add(cBTiempo_P);
		
		btnAceptar_NP = new JButton("Aceptar");
		btnAceptar_NP.addActionListener(new ButtonListener());
		pNuevoPrestamo.add(btnAceptar_NP);
		
		JPanel pBuscarPrestamo = new JPanel();
		pBuscarPrestamo.setBorder(new TitledBorder(null, "Buscar Pr\u00E9stamo", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		pInferiorIzquierda.add(pBuscarPrestamo);
		pBuscarPrestamo.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel label = new JLabel("C\u00F3digo Libro");
		pBuscarPrestamo.add(label);
		
		tFCodigoLibro_BP = new JTextField();
		tFCodigoLibro_BP.setColumns(10);
		pBuscarPrestamo.add(tFCodigoLibro_BP);
		
		JLabel label_1 = new JLabel("Carn\u00E9:");
		pBuscarPrestamo.add(label_1);
		
		tFCarne_BP = new JTextField();
		tFCarne_BP.setColumns(10);
		pBuscarPrestamo.add(tFCarne_BP);
		
		JLabel lblMostrarDevueltos = new JLabel("Mostrar Devueltos:");
		pBuscarPrestamo.add(lblMostrarDevueltos);
		
		JCheckBox checkBox = new JCheckBox("");
		checkBox.setSelected(true);
		pBuscarPrestamo.add(checkBox);
		
		JButton btnBuscar = new JButton("Buscar");
		pBuscarPrestamo.add(btnBuscar);
		
		JPanel pInferiorDerecha = new JPanel();
		pInferior.add(pInferiorDerecha);
		pInferiorDerecha.setLayout(new BorderLayout(0, 0));
		
		JPanel pTabla = new JPanel();
		pTabla.setBorder(new TitledBorder(null, "Tabla de Prestamos", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		pInferiorDerecha.add(pTabla, BorderLayout.CENTER);
		
		String[] columnNames = { "ID", "# Libro", "Nombre Libro", "# Carn�", "Nombre Alumno", "Prestado En", "Vence En", "Devuelto" };
		
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		//model.addRow(rowData);
		
		tPrestamos = new JTable();
		tPrestamos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tPrestamos.setCellSelectionEnabled(false);
		tPrestamos.setColumnSelectionAllowed(false);
		tPrestamos.setRowSelectionAllowed(true);
		tPrestamos.setDefaultEditor(Object.class, null);
		tPrestamos.setModel(model);
		tPrestamos.setPreferredScrollableViewportSize(tPrestamos.getPreferredSize());
		tPrestamos.setFillsViewportHeight(true);
		tPrestamos.setPreferredScrollableViewportSize(new Dimension(800,200));
		tPrestamos.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		JScrollPane scrollPane = new JScrollPane();
		pTabla.add(scrollPane);
		scrollPane.setViewportView(tPrestamos);
		
		JPanel pInferiorDerechaInferior = new JPanel();
		pInferiorDerecha.add(pInferiorDerechaInferior, BorderLayout.SOUTH);
		
		JPanel pRenovar = new JPanel();
		pInferiorDerechaInferior.add(pRenovar);
		pRenovar.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Renovar", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"1 semana", "2 semanas", "3 semanas", "1 mes"}));
		comboBox.setSelectedIndex(1);
		pRenovar.add(comboBox);
		
		JButton btnAceptar = new JButton("Aceptar");
		pRenovar.add(btnAceptar);
		
		JPanel pDevolver = new JPanel();
		pDevolver.setBorder(new TitledBorder(null, "Devolver", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		pInferiorDerechaInferior.add(pDevolver);
		
		btnDevolver = new JButton("Devolver");
		btnDevolver.addActionListener(new ButtonListener());
		pDevolver.add(btnDevolver);
	}
	
	private class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnAceptar_NP){
				try{
					Libro libro = biblioteca.buscarLibro(Integer.parseInt(tFCodigoLibro.getText()));
					if(libro!=null){
						Alumno alumno = biblioteca.buscarCarne(Integer.parseInt(tFCarne_NP.getText()));
						if(alumno != null){
							if(!biblioteca.isLibroPrestado(libro.getCodigo())){
								biblioteca.agregarPrestamo(new Prestamo(biblioteca.getPrestamos().size(), libro.getCodigo(), libro.getNombre(), alumno.getCarne(), alumno.getNombre(), LocalDate.now(), LocalDate.now().plusWeeks(cBTiempo_P.getSelectedIndex()+1), false));
								llenarTabla();
							}else{
								JOptionPane.showMessageDialog(frame,
									    "El libro ingresado ya est� prestado",
									    "Error",
									    JOptionPane.ERROR_MESSAGE);
							}
						}else{
							JOptionPane.showMessageDialog(frame,
								    "El carn� ingresado no existe",
								    "Error",
								    JOptionPane.ERROR_MESSAGE);
						}
					}else{
						JOptionPane.showMessageDialog(frame,
							    "El c�digo de libro ingresado no existe",
							    "Error",
							    JOptionPane.ERROR_MESSAGE);
					}
				}catch(Exception exc){
					JOptionPane.showMessageDialog(frame,
						    "Por favor ingrese solo n�meros en el codigo de libro y carn�",
						    "Error",
						    JOptionPane.ERROR_MESSAGE);
				}
			}else if(e.getSource() == btnDevolver){
				int prestamoID = Integer.parseInt((String) tPrestamos.getModel().getValueAt(tPrestamos.getSelectedRow(), 0));
				
				for(int i=0;i<biblioteca.getPrestamos().size();i++){
					if(biblioteca.getPrestamos().get(i).getId() == prestamoID){
						if(!biblioteca.getPrestamos().get(i).isDevuelto()){
							biblioteca.getPrestamos().get(i).setDevuelto(true);
							llenarTabla();
							JOptionPane.showMessageDialog(frame,
								    "El libro ha sido marcado como devuelto",
								    "Libro Devuelto",
								    JOptionPane.INFORMATION_MESSAGE);
						}else{
							JOptionPane.showMessageDialog(frame,
								    "Este libro ya ha sido devuelto",
								    "Error",
								    JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			}
		}
	}

	public void llenarTabla(){
		String[] columnNames = { "ID", "# Libro", "Nombre Libro", "# Carn�", "Nombre Alumno", "Prestado En", "Vence En", "Devuelto" };
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);
		
		ArrayList<Prestamo> prestamos = biblioteca.getPrestamos();
		
		for(int i=0; i<biblioteca.getPrestamos().size(); i++){
			//String[] rowData = { "1356123", "Mein Kampf", "156894", "Roberto Robertito", "11/06/2016", "16/08/2016", "No" };
			
			Prestamo prestamo = prestamos.get(i);
			String[] rowData = { String.valueOf(prestamo.getId()),String.valueOf(prestamo.getCodigoLibro()), prestamo.getNombreLibro(), String.valueOf(prestamo.getCarne()), prestamo.getNombreAlumno(), prestamo.getPrestado().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), prestamo.getVence().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), String.valueOf(prestamo.isDevuelto()) };
			model.addRow(rowData);
			tPrestamos.setModel(model);
		}
	}

}
