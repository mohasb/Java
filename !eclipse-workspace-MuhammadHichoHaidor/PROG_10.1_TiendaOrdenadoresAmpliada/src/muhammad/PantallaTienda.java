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

//Vista de la ventana de carga principal de la tienda ordenadores
public class PantallaTienda extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea txAreaResultado;

	/**
	 * 
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
	 * 
	 * Create the frame.
	 */
	public PantallaTienda() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel basePanel = new JPanel();
		contentPane.add(basePanel, BorderLayout.CENTER);
		basePanel.setLayout(null);

		txAreaResultado = new JTextArea();
		txAreaResultado.setBounds(10, 10, 594, 211);
		basePanel.add(txAreaResultado);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		// Accion del botón menu cargar
		JMenuItem menuCargar = new JMenuItem("Cargar Categorías");
		menuCargar.addActionListener(new menuCargar());
		mnArchivo.add(menuCargar);
		// Accion del botón menu salir
		JMenuItem menuSalir = new JMenuItem("Salir");
		menuSalir.addActionListener(new menuSalir());
		mnArchivo.add(menuSalir);
		
		JMenu menuComponentes = new JMenu("Componentes");
		menuBar.add(menuComponentes);
		
		JMenuItem menuMonitor = new JMenuItem("Monitor");
		menuMonitor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				muestraVistaMonitor();
			}

		
		});
		menuComponentes.add(menuMonitor);
	}

	// Clase encargada del boton de carga del menú
	class menuCargar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			// Cargar Base de datos
			ConectorBaseDatos baseDatos = new ConectorBaseDatos();

			baseDatos.setConection();
			String consulta = baseDatos.ObetenerCategorias();

			txAreaResultado.setText(consulta);
		}

	}

	// Clase encargada del botón salir del menú
	class menuSalir implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}

	}

	void muestraVistaMonitor() {
		
	PantallaMonitor v = new PantallaMonitor(this, true);
	v.setLocationRelativeTo(this);
	v.setVisible(true);

	
}



}