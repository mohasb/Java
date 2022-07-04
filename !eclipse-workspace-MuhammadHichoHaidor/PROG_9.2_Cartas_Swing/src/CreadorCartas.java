
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JFileChooser;

public class CreadorCartas extends JFrame {

	/**
	 * Variables
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextPane tPanePregunta;
	private JTextPane tPaneRespuesta;
	private JMenuItem menuGuardar;
	private ArrayList<Carta> coleccionCartas = new ArrayList<Carta>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreadorCartas frame = new CreadorCartas();
					//Instancia del juego
					Juego juego = new Juego();
					frame.setVisible(true);
					juego.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CreadorCartas() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 385, 369);
		setTitle("Creador de cartas");
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Juego");
		menuBar.add(mnNewMenu);
		
		menuGuardar = new JMenuItem("Guardar");
		menuGuardar.addActionListener(new CreaArchivoCartas());
		mnNewMenu.add(menuGuardar);
		
		JMenuItem menuSalir = new JMenuItem("Salir");
		menuSalir.addActionListener(new Salir());
		mnNewMenu.add(menuSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pregunta");
		lblNewLabel.setBounds(10, 10, 171, 13);
		panel.add(lblNewLabel);
		
		tPanePregunta = new JTextPane();
		tPanePregunta.setBounds(10, 33, 336, 81);
		panel.add(tPanePregunta);
		
		JLabel lblNewLabel_1 = new JLabel("Respuesta");
		lblNewLabel_1.setBounds(10, 124, 228, 13);
		panel.add(lblNewLabel_1);
		
		tPaneRespuesta = new JTextPane();
		tPaneRespuesta.setBounds(10, 147, 336, 81);
		panel.add(tPaneRespuesta);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new GuardarCarta());
		btnSiguiente.setBounds(122, 254, 104, 21);
		panel.add(btnSiguiente);
	}
	//Action Events
	class CreaArchivoCartas implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//Si hay cartas que guardar
			if (coleccionCartas.size() != 0) {
				//Creo instancia filechooser y la enlazo al botón guardar
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File(".\\src\\com\\muhammad\\"));
				FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT", "txt", "TXT");			
				fileChooser.setFileFilter(filter);
				int seleccion = fileChooser.showSaveDialog(menuGuardar);
				//Si se da a guardar archivo
				if (seleccion == JFileChooser.APPROVE_OPTION) {
					File archivo = fileChooser.getSelectedFile();
					File archivoConExtension = new File(archivo.getAbsolutePath() + ".txt");
					
					
					
					//Comprueba si se ha escrito la extensión y si no tiene le añade .txt
					if (!archivo.getAbsolutePath().contains(".txt")) {
						fileChooser.getSelectedFile().renameTo(archivoConExtension);
												
					}else {
						archivoConExtension = new File(archivo.getAbsolutePath());
					}
					
					
					try {
						//Creo el archivo
						FileWriter fw = new FileWriter(archivoConExtension);
						//Creo el escritor
			            BufferedWriter bw = new BufferedWriter(fw);
			            //Recorro ael arraylist añadiendo todas las cartas 
			            for (Carta carta : coleccionCartas) {
			            	  bw.write(carta.toString() + "\n");
						}
			            //Cierro escritor
		            	 bw.close();
		            	 
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		}
	}
	class Salir implements ActionListener {

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
	class GuardarCarta implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//Si hay texto el los texpane crea objeto y añade al arrayList y borra los texpane
			if (!tPanePregunta.getText().isBlank() && !tPaneRespuesta.getText().isBlank()) {
				Carta c = new Carta(tPanePregunta.getText(), tPaneRespuesta.getText());
				coleccionCartas.add(c);
				tPanePregunta.setText("");
				tPaneRespuesta.setText("");
				return;
			}
			JOptionPane.showMessageDialog(null, "No se ha introducido la pregunta o la respuesta", "Creador de cartas", JOptionPane.OK_OPTION);
					
		}
		
	}
}

