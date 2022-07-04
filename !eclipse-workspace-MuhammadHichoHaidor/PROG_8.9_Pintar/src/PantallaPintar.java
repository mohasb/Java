
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JSlider;


public class PantallaPintar extends JFrame {

	/**
	 * Variables de clase para poder usar InnerClass en los ActionEvents
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton bRojo;
	private JButton bVerde;
	private JButton bAzul;
	private JSlider sliderRed;
	private JSlider sliderGreen;
	private JSlider sliderBlue;
	private JButton btnPaint;
	private Pintar pintura;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaPintar frame = new PantallaPintar();
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
	public PantallaPintar() {
		setResizable(false);
		setTitle("Vamos a pintar!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 220);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		bRojo = new JButton("Rojo");
		bRojo.setBounds(10, 26, 85, 21);
		//El action event lo maneja la InnerClass 'bRojoListener'
		bRojo.addActionListener(new bRojoListener());
		panel.add(bRojo);
		
		bVerde = new JButton("Verde");
		bVerde.setBounds(10, 67, 85, 21);
		//El action event lo maneja la InnerClass 'bVerdeListener'
		bVerde.addActionListener(new bVerdeListener());
		panel.add(bVerde);
		
		bAzul = new JButton("Azul");
		bAzul.setBounds(10, 110, 85, 21);
		//El action event lo maneja la InnerClass 'bAzulListener'
		bAzul.addActionListener(new bAzulListener());
		panel.add(bAzul);
		
		sliderRed = new JSlider(0, 250, 0);
		sliderRed.setBounds(105, 26, 200, 22);
		panel.add(sliderRed);
		
		sliderGreen = new JSlider(0, 250, 0);
		sliderGreen.setBounds(105, 67, 200, 22);
		panel.add(sliderGreen);
		
		sliderBlue = new JSlider(0, 250, 0);
		sliderBlue.setBounds(105, 109, 200, 22);
		panel.add(sliderBlue);
		
		btnPaint = new JButton("Colorea");
		//El action event lo maneja la InnerClass 'bPaintListener'
		btnPaint.addActionListener(new bPaintListener());
		btnPaint.setBounds(161, 141, 85, 21);
		panel.add(btnPaint);
		
		pintura = new Pintar();
		pintura.setBounds(328, 26, 98, 105);
		panel.add(pintura);
		
	}
	
	class bRojoListener implements ActionListener {
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
	class bVerdeListener implements ActionListener {
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
	class bAzulListener implements ActionListener {
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
	class bPaintListener implements ActionListener {
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
}
