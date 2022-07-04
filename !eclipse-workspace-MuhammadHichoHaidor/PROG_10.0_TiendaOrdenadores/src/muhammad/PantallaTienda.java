package muhammad;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaTienda extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaTienda frame = new PantallaTienda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PantallaTienda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel basePanel = new JPanel();
		contentPane.add(basePanel, BorderLayout.CENTER);
		basePanel.setLayout(null);
		
		JTextArea txAreaResultado = new JTextArea();
		txAreaResultado.setBounds(10, 10, 594, 211);
		basePanel.add(txAreaResultado);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem menuCargar = new JMenuItem("Cargar Categorías");
		menuCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 //Cargar Base de datos
		    	  ConectorBaseDatos baseDatos = new ConectorBaseDatos();
		    	  
		    	  baseDatos.setConection();
		    	  String consulta = baseDatos.getConsulta();
		    	  
		    	  txAreaResultado.setText(consulta);

				
				
				
			}
		});
		mnArchivo.add(menuCargar);
		
		JMenuItem menuSalir = new JMenuItem("Salir");
		menuSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Boton salir
				System.exit(0);
				
			}
		});
		mnArchivo.add(menuSalir);
	}
}
