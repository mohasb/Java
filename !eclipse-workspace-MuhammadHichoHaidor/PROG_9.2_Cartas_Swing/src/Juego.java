
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;

public class Juego extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tFieldRespuesta;
	private JMenuItem menuJuego;
	private JLabel lblPregunta;
	private JLabel lblInstrucciones;
	private JLabel lblTituloPregunta;
	private JButton btnSolucion;
	private JButton btnComprobar;
	private JButton btnSiguiente;
	private JLabel lblTituloRespuesta;
	private JLabel lblRespuesta;
	private JFileChooser fc;
	private File archivo;
	private BufferedReader br;
	private JLabel lblComprobar;
	private ArrayList<Carta> coleccionCartas = new ArrayList<>();
	
	
	public Juego() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(471, 100, 385, 369);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Juego");
		menuBar.add(mnNewMenu);
		
		menuJuego = new JMenuItem("Jugar");
		menuJuego.addActionListener(new btnJuego());
		mnNewMenu.add(menuJuego);
		
		JMenuItem menuSalir = new JMenuItem("Salir");
		menuSalir.addActionListener(new btnSalir() );
		mnNewMenu.add(menuSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblTituloPregunta = new JLabel("");
		lblTituloPregunta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTituloPregunta.setBounds(10, 23, 171, 13);
		panel.add(lblTituloPregunta);
		
		lblPregunta = new JLabel("Seleccionar archivo con preguntas");
		lblPregunta.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPregunta.setBounds(10, 32, 341, 36);
		panel.add(lblPregunta);
		
		btnSolucion = new JButton("Ver solución");
		btnSolucion.addActionListener(new botonSolucion());
		btnSolucion.setEnabled(false);
		btnSolucion.setBounds(42, 155, 107, 21);
		panel.add(btnSolucion);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(
				e -> {muestraPregunta();});
		btnSiguiente.setEnabled(false);
		btnSiguiente.setBounds(189, 155, 100, 21);
		panel.add(btnSiguiente);
		
		tFieldRespuesta = new JTextField();
		tFieldRespuesta.setEnabled(false);
		tFieldRespuesta.setBounds(42, 199, 247, 19);
		panel.add(tFieldRespuesta);
		tFieldRespuesta.setColumns(10);
		
		btnComprobar = new JButton("Comprobar");
		btnComprobar.addActionListener(new btnComprobar());
		btnComprobar.setEnabled(false);
		btnComprobar.setBounds(111, 228, 107, 21);
		panel.add(btnComprobar);
		
		lblInstrucciones = new JLabel("Juego > jugar > seleccionar txt con preguntas");
		lblInstrucciones.setBounds(10, 67, 341, 13);
		panel.add(lblInstrucciones);
		
		lblTituloRespuesta = new JLabel("");
		lblTituloRespuesta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTituloRespuesta.setBounds(10, 90, 171, 13);
		panel.add(lblTituloRespuesta);
		
		lblRespuesta = new JLabel("Respuesta");
		lblRespuesta.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRespuesta.setBounds(10, 99, 341, 36);
		lblRespuesta.setVisible(false);
		panel.add(lblRespuesta);
		
		lblComprobar = new JLabel("");
		lblComprobar.setBounds(121, 259, 107, 13);
		panel.add(lblComprobar);
	}
	class btnJuego implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			fc = new JFileChooser();
			fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fc.setCurrentDirectory(new File(".\\src"));
			FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT", "txt", "TXT");			
			fc.setFileFilter(filter);
			int seleccion = fc.showOpenDialog(menuJuego);
			//Si se da a guardar archivo
			if (seleccion == JFileChooser.APPROVE_OPTION) {
				archivo = fc.getSelectedFile();
				try {
					br = new BufferedReader(new FileReader(archivo));
					
					
					//Rellenar array nuevo con el texto del archivo
					String linea;
					while ((linea = br.readLine()) != null) {
						String[] partes = linea.split("#");
						Carta c = new Carta(partes[0], partes[1]);
						coleccionCartas.add(c);
					}
					
					
					muestraPregunta();
										
				
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}	
	}
	class botonSolucion implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			lblTituloRespuesta.setText("Respuesta:");
			lblRespuesta.setVisible(true);
			
		}
		
	}
	class btnComprobar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String respuesta = tFieldRespuesta.getText();
			
			if (respuesta.equals("")) {
				JOptionPane.showMessageDialog(null, "No se ha escrito ninguna respuesta", "Juego de preguntas y respuestas", JOptionPane.OK_OPTION);
				return;
			}
			if (respuesta.equalsIgnoreCase(lblRespuesta.getText())) {
				lblComprobar.setText("¡CORRECTO!");
				lblComprobar.setForeground(Color.GREEN);
			}else {
				lblComprobar.setText("¡INCORRECTO!");
				lblComprobar.setForeground(Color.RED);

			}
		}
		
	}
	class btnSalir implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String[] options = {"SÍ","NO"};

	        int respuesta = JOptionPane.showOptionDialog(null, "¿Seguro que quieres salir?", "Creador de cartas",
	                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
	        if (respuesta == 0) {
	        	System.exit(0);
	        }
		}
		
	}
	void muestraPregunta() {
		
		Random ran = new Random();
		int indice = ran.nextInt(coleccionCartas.size() + 1);
		
		Carta c = coleccionCartas.get(indice);
		
		String[] partes = {c.getPregunta(), c.getRespuesta()};
		
		
		lblPregunta.setText(partes[0]);
		lblInstrucciones.setText("");
		lblTituloPregunta.setText("Pregunta:");
		btnSolucion.setEnabled(true);
		btnSiguiente.setEnabled(true);
		btnComprobar.setEnabled(true);
		lblRespuesta.setText(partes[1]);
		lblTituloRespuesta.setText("");
		lblRespuesta.setVisible(false);
		tFieldRespuesta.setEnabled(true);
		tFieldRespuesta.setText("");
		lblComprobar.setText("");
	}
	

}
