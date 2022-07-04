
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;


public class PantallaPintar2 extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton bRojo;
	private JButton bVerde;
	private JButton bAzul;
	private JSlider sliderRed;
	private JSlider sliderGreen;
	private JSlider sliderBlue;
	private JButton btnPaint;
	private Pintar2 pintura;
	private JMenu menuAcciones;
	private JMenuItem accionesInicializar;
	private JMenuItem AccionesSalir;
	private JMenu menuColores;
	private ButtonGroup grupo;
	private JRadioButtonMenuItem ColoresAleatorio;
	private JRadioButtonMenuItem ColoresRojo;
	private JRadioButtonMenuItem ColoresVerde;
	private JRadioButtonMenuItem ColoresAzul;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPintar2 frame = new PantallaPintar2();
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
	public PantallaPintar2() {
		setResizable(false);
		setTitle("Vamos a pintar!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 250);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuAcciones = new JMenu("Acciones");
		menuBar.add(menuAcciones);
		
		accionesInicializar = new JMenuItem("Inicializar");
		accionesInicializar.addActionListener(new InicializarListener());
		menuAcciones.add(accionesInicializar);
		
		AccionesSalir = new JMenuItem("Salir");
		//AccionesSalir.addActionListener(new SalirListener());
		AccionesSalir.addActionListener(
			e -> {
				String[] options = {"S�","NO"};

		        int respuesta = JOptionPane.showOptionDialog(null, "�Seguro que quieres salir?", getTitle(),
		                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
		        if (respuesta == 0) {
		        	System.exit(0);
		        }
			}
		);
		menuAcciones.add(AccionesSalir);
		
		menuColores = new JMenu("Colores");
		menuBar.add(menuColores);
		
		ColoresAleatorio = new JRadioButtonMenuItem("Aleatorio");
		ColoresAleatorio.addActionListener(new ColoresListener());
		menuColores.add(ColoresAleatorio);
		
		ColoresRojo = new JRadioButtonMenuItem("Rojo");
		ColoresRojo.addActionListener(new ColoresListener());
		menuColores.add(ColoresRojo);
		
		ColoresVerde = new JRadioButtonMenuItem("Verde");
		ColoresVerde.addActionListener(new ColoresListener());
		menuColores.add(ColoresVerde);
		
		ColoresAzul = new JRadioButtonMenuItem("Azul");
		ColoresAzul.addActionListener(new ColoresListener());
		menuColores.add(ColoresAzul);
		
		
		grupo = new ButtonGroup();
		grupo.add(ColoresAleatorio);
		grupo.add(ColoresRojo);
		grupo.add(ColoresVerde);
		grupo.add(ColoresAzul);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		bRojo = new JButton("Rojo");
		bRojo.setBounds(10, 26, 85, 21);
		//El actionEvent lo maneja la InnerClass 'BRojoListener'
		bRojo.addActionListener(new BRojoListener());
		panel.add(bRojo);
		
		bVerde = new JButton("Verde");
		bVerde.setBounds(10, 67, 85, 21);
		//El actionEvent lo maneja la InnerClass 'BVerdeListener'
		bVerde.addActionListener(new BVerdeListener());
		panel.add(bVerde);
		
		bAzul = new JButton("Azul");
		bAzul.setBounds(10, 110, 85, 21);
		//El actionEvent lo maneja la InnerClass 'bAzulListener'
		bAzul.addActionListener(new BAzulListener());
		panel.add(bAzul);
		
		sliderRed = new JSlider(0, 250, 0);
		sliderRed.setBounds(105, 26, 200, 22);
		//El ChangeEvent lo maneja la InnerClass 'sliderChangeListener'
		sliderRed.addChangeListener(new SliderChangeListener());
		panel.add(sliderRed);
		
		sliderGreen = new JSlider(0, 250, 0);
		sliderGreen.setBounds(105, 67, 200, 22);
		//El ChangeEvent lo maneja la InnerClass 'sliderChangeListener'
		sliderGreen.addChangeListener(new SliderChangeListener());
		panel.add(sliderGreen);
		
		sliderBlue = new JSlider(0, 250, 0);
		sliderBlue.setBounds(105, 109, 200, 22);
		//El ChangeEvent lo maneja la InnerClass 'sliderChangeListener'
		sliderBlue.addChangeListener(new SliderChangeListener());
		panel.add(sliderBlue);
		
		btnPaint = new JButton("Colorea");
		//El action event lo maneja la InnerClass 'bPaintListener'
		btnPaint.addActionListener(new BPaintListener());
		btnPaint.setBounds(161, 141, 85, 21);
		panel.add(btnPaint);
		
		pintura = new Pintar2();
		pintura.setBounds(328, 26, 98, 105);
		panel.add(pintura);
	}
	//ActionEvents botones
	class BRojoListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//Coloco los slider en sus posiciones
			sliderRed.setValue(255);
			sliderGreen.setValue(0);
			sliderBlue.setValue(0);
			//Establezco el valor RGB
			pintura.setR(sliderRed.getValue());
			pintura.setG(sliderGreen.getValue());
			pintura.setB(sliderBlue.getValue());
			//Repinto el panel
			pintura.repaint();
		}
	}
	class BVerdeListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//Coloco los slider en sus posiciones
			sliderRed.setValue(0);
			sliderGreen.setValue(255);
			sliderBlue.setValue(0);
			//Establezco el valor RGB
			pintura.setR(sliderRed.getValue());
			pintura.setG(sliderGreen.getValue());
			pintura.setB(sliderBlue.getValue());
			//Repinto el panel
			pintura.repaint();
		}
	}
	class BAzulListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//Coloco los slider en sus posiciones
			sliderRed.setValue(0);
			sliderGreen.setValue(0);
			sliderBlue.setValue(255);
			//Establezco el valor RGB
			pintura.setR(sliderRed.getValue());
			pintura.setG(sliderGreen.getValue());
			pintura.setB(sliderBlue.getValue());
			//Repinto el panel
			pintura.repaint();
		}
	}
	class BPaintListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//Establezco el valor RGB
			pintura.setR(sliderRed.getValue());
			pintura.setG(sliderGreen.getValue());
			pintura.setB(sliderBlue.getValue());
			//Repinto el panel
			pintura.repaint();
		}
	}
	//ChangeEvents sliders
	class SliderChangeListener implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			pintura.setR(sliderRed.getValue());
			pintura.setG(sliderGreen.getValue());
			pintura.setB(sliderBlue.getValue());
			//Repinto el panel
			pintura.repaint();
			
		}
	}
	//ActionEvents men� Inicializar
	class InicializarListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//Coloco los slider en sus posiciones
			sliderRed.setValue(0);
			sliderGreen.setValue(0);
			sliderBlue.setValue(0);
			//Establezco el valor RGB
			pintura.setR(sliderRed.getValue());
			pintura.setG(sliderGreen.getValue());
			pintura.setB(sliderBlue.getValue());
			//Repinto el panel
			pintura.repaint();
		}
	}
	//ActionEvents men� Salir
	//	HE COMENTADO ESTA CLASE PARA PROBAR EXPRESI�N LAMBDA
	/*class SalirListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String[] options = {"S�","NO"};

	        int respuesta = JOptionPane.showOptionDialog(null, "�Seguro que quieres salir?", getTitle(),
	                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
	        if (respuesta == 0) {
	        	System.exit(0);
	        }
	        
		}
		
	}*/
	//ActionEvents men� Colores
	class ColoresListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			 Random random = new Random();
			if (ColoresAleatorio.isSelected()) {
				//Valores aleatorios de RGB
				sliderRed.setValue((int) (Math.random()*255 + 1));
				sliderGreen.setValue(random.nextInt(250));
				sliderBlue.setValue(random.nextInt(250));
				//Repinto el panel
				pintura.repaint();
			}
			if (ColoresRojo.isSelected()) {
				bRojo.doClick();
			}
			if (ColoresVerde.isSelected()) {
				bVerde.doClick();
			}
			if (ColoresAzul.isSelected()) {
				bAzul.doClick();
			}
		}
		
	}



}
