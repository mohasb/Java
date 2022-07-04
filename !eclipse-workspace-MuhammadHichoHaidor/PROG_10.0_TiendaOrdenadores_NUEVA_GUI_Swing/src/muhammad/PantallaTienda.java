package muhammad;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JTextArea;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PantallaTienda extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int xMouse, yMouse;

	public int getxMouse() {
		return xMouse;
	}
	public void setxMouse(int xMouse) {
		this.xMouse = xMouse;
	}
	public int getyMouse() {
		return yMouse;
	}
	public void setyMouse(int yMouse) {
		this.yMouse = yMouse;
	}

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
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(PantallaTienda.class.getResource("/muhammad/icono.png")));
		setLocationByPlatform(true);
		setUndecorated(true);
		setTitle("Tienda de Informática");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 267);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel basePanel = new JPanel();
		basePanel.setBounds(0, 0, 773, 266);
		contentPane.add(basePanel);
		basePanel.setLayout(null);
		
		JPanel panelTitulo = new JPanel();
		panelTitulo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});
		panelTitulo.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				
				setLocation(x - xMouse, y - yMouse);
			}
		});
		panelTitulo.setBackground(Color.BLACK);
		panelTitulo.setBounds(0, 0, 773, 25);
		basePanel.add(panelTitulo);
		panelTitulo.setLayout(null);
		
		JLabel btnSalir = new JLabel("X");
		btnSalir.setBackground(Color.BLACK);
		btnSalir.setOpaque(true);
		btnSalir.setForeground(Color.WHITE);
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSalir.setBackground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSalir.setBackground(Color.BLACK);

			}
		});
		btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalir.setBounds(743, 0, 30, 25);
		panelTitulo.add(btnSalir);
		btnSalir.setHorizontalAlignment(SwingConstants.CENTER);
		btnSalir.setFont(new Font("Roboto Light", Font.BOLD, 20));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(0, 0, 26, 25);
		panelTitulo.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(PantallaTienda.class.getResource("/muhammad/icono.png")));
		
		JLabel lblNewLabel_1 = new JLabel("Tienda de Informática");
		lblNewLabel_1.setBounds(33, 8, 157, 13);
		panelTitulo.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 14));
		
		JLabel lblNewLabel_2 = new JLabel("___");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBackground(Color.BLACK);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setBounds(722, 0, 26, 26);
		panelTitulo.add(lblNewLabel_2);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 25, 773, 25);
		basePanel.add(menuBar);
		
		JMenu menuArchivo = new JMenu("Archivo");
		menuArchivo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuBar.add(menuArchivo);
		
		JTextArea txAreaResultado = new JTextArea();
		txAreaResultado.setFont(new Font("Monospaced", Font.PLAIN, 12));
		txAreaResultado.setForeground(Color.BLACK);
		txAreaResultado.setBounds(10, 60, 751, 196);
		basePanel.add(txAreaResultado);
		
		JMenuItem menuCargar = new JMenuItem("Cargar Componentes");
		menuCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Cargar Base de datos
		    	  ConectorBaseDatos baseDatos = new ConectorBaseDatos();
		    	  
		    	  if (baseDatos.setConection() == null) {
		    		  
					muestraDialogError();
					
				  }
		    	  
		    	  
		    	  
		    	  
		    	  
		    	  String consulta = baseDatos.getConsulta();
		    	  
		    	  txAreaResultado.setText(consulta);
			}
		});
		menuCargar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuArchivo.add(menuCargar);
		
		JMenuItem menuSalir = new JMenuItem("Salir");
		menuSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuArchivo.add(menuSalir);
		
		
	}
	
	
	void muestraDialogError() {
		ErrorDialog error = new ErrorDialog(this, true);
		error.setLocationRelativeTo(this);
		error.setVisible(true);
	}
	
}
