
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import javax.swing.SpinnerNumberModel;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;

public class Clinica extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private int edad;
	private double peso;
	private double estatura;
	private String sexo;
	private String provincia;
	private boolean dieta;
	private double imc;
	
	
	/**
	 * Create the frame.
	 */
	public Clinica() {
		setTitle("Clinica Diet\u00E9tica Swing");
		setResizable(false);
		
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lbl_Nombre = new JLabel("*Nombre");
		lbl_Nombre.setBounds(10, 27, 57, 13);
		panel.add(lbl_Nombre);
		
		JLabel lbl_Edad = new JLabel("*Edad");
		lbl_Edad.setBounds(10, 53, 45, 13);
		panel.add(lbl_Edad);
		
		JSpinner inputEdad = new JSpinner();
		inputEdad.setModel(new SpinnerNumberModel(0, 0, 120, 0));
		inputEdad.setBounds(77, 50, 43, 20);
		panel.add(inputEdad);
		
		JTextField inputNombre = new JTextField();
		inputNombre.setBounds(77, 21, 208, 19);
		panel.add(inputNombre);
		inputNombre.setColumns(10);
		
		JLabel lblPeso = new JLabel("*Peso");
		lblPeso.setBounds(10, 82, 45, 13);
		panel.add(lblPeso);
		
		JLabel lblEstatura = new JLabel("*Estatura");
		lblEstatura.setBounds(10, 106, 45, 13);
		panel.add(lblEstatura);
		
		JSpinner inputEstatura = new JSpinner();
		inputEstatura.setModel(new SpinnerNumberModel(0.00, 0.00, 2.50, 0.5));
		inputEstatura.setBounds(77, 103, 43, 20);
		panel.add(inputEstatura);
		
		JSpinner inputPeso = new JSpinner();
		inputPeso.setModel(new SpinnerNumberModel(0.00, 0.00, 300.0, 0.5));
		inputPeso.setBounds(77, 75, 43, 20);
		panel.add(inputPeso);
		
		JLabel lbl_Provincia = new JLabel("Provincia");
		lbl_Provincia.setBounds(130, 51, 59, 13);
		panel.add(lbl_Provincia);
		
		JComboBox<String> cBoxProvincia = new JComboBox<>();
		cBoxProvincia.setModel(new DefaultComboBoxModel<String>(new String[] {"Alicante", "Valencia", "Castell\u00F3n"}));
		cBoxProvincia.setBounds(199, 47, 86, 21);
		panel.add(cBoxProvincia);
		
		final ButtonGroup buttonGroup = new ButtonGroup();

		JRadioButton rbtnHombre = new JRadioButton("Hombre");
		buttonGroup.add(rbtnHombre);
		rbtnHombre.setBounds(130, 76, 103, 21);
		panel.add(rbtnHombre);
		
		JRadioButton rbtnMujer = new JRadioButton("Mujer");
		buttonGroup.add(rbtnMujer);
		rbtnMujer.setBounds(130, 100, 103, 21);
		panel.add(rbtnMujer);
		
		JLabel lblImc = new JLabel("IMC:");
		lblImc.setBounds(10, 139, 96, 13);
		panel.add(lblImc);
		
		JCheckBox cboxDieta = new JCheckBox("\u00BFHa hecho dieta?");
		cboxDieta.setBounds(130, 123, 130, 21);
		panel.add(cboxDieta);
		
		JTextPane tPaneResultado = new JTextPane();
		tPaneResultado.setEditable(false);
		tPaneResultado.setBounds(10, 216, 275, 119);
		panel.add(tPaneResultado);
		
		JButton btnCalcular = new JButton("Calcular mi estado");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				nombre = inputNombre.getText();
				edad = (int) inputEdad.getValue();
				peso = (double) inputPeso.getValue();
				estatura = (double) inputEstatura.getValue();
				if (rbtnHombre.isSelected()) {
					sexo = rbtnHombre.getText();
				}
				if (rbtnMujer.isSelected()) {
					sexo = rbtnMujer.getText();
				}
				provincia = cBoxProvincia.getSelectedItem().toString();
				dieta = cboxDieta.isSelected();
						
				if (validarDatos(nombre, edad, peso, estatura, sexo, provincia)) {

					Persona Cliente = new Persona(nombre, provincia, edad, peso, estatura, sexo, dieta);
					setBounds(100, 100, 320, 400);
					lblImc.setText("IMC: " + Cliente.getIMC());					
					tPaneResultado.setText(Cliente.toString());
					
				}
				
			}
		});
		btnCalcular.setBounds(77, 154, 144, 21);
		panel.add(btnCalcular);
		JButton btnBorrar = new JButton("Borrar datos");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBounds(100, 100, 320, 260);
				inputNombre.setText("");
				inputEdad.setValue(0);
				inputPeso.setValue(0);
				inputEstatura.setValue(0);
				buttonGroup.clearSelection();
				cboxDieta.setSelected(false);
				
			}
		});
		btnBorrar.setBounds(77, 185, 144, 21);
		panel.add(btnBorrar);

	}

	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getEstatura() {
		return estatura;
	}
	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public boolean isDieta() {
		return dieta;
	}
	public void setDieta(boolean dieta) {
		this.dieta = dieta;
	}
	public double getImc() {
		return imc;
	}
	public void setImc(double imc) {
		this.imc = imc;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clinica frame = new Clinica();
					frame.setBounds(100, 100, 320, 260);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	boolean validarDatos(String nombre, int edad, double peso, double estatura, String sexo, String provincia) {
		
		if (nombre.isBlank() || edad == 0 || peso == 0 || estatura == 0 ) {
			JOptionPane.showInternalMessageDialog(null, "Por favor rellene todos los campos con asterisco(*) del formulario");
			return false;
		}
		return true;
	}
	
}
