
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JFormattedTextField;
import java.awt.Color;

public class FabricaCoches extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFormattedTextField fTextFldMatricula;
	@SuppressWarnings("rawtypes")
	private JComboBox cbBoxMarca;
	@SuppressWarnings("rawtypes")
	private JComboBox cbBoxModelo;
    @SuppressWarnings("rawtypes")
	private ComboBoxModel[] modelos = new ComboBoxModel[4];
    ArrayList<Coche> parqueCoches = new ArrayList<Coche>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FabricaCoches frame = new FabricaCoches();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FabricaCoches() {
		/**
		 * Create the frame.
		 */
		setTitle("F\u00E1brica de coches P8.11");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 311);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		//Jlist con un model que acepta Coches
	    DefaultListModel<Coche> modelCoche = new DefaultListModel<Coche>();
	    JList<Coche> listaParque = new JList<Coche>();
		listaParque.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaParque.setModel(modelCoche);
		listaParque.setSelectedIndex(0);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(202, 79, 237, 152);
		panel.add(scrollPane);
		scrollPane.setViewportView(listaParque);

		JLabel lblMatricula = new JLabel("Matr\u00EDcula");
		lblMatricula.setBounds(21, 44, 55, 13);
		panel.add(lblMatricula);
		
		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(21, 81, 45, 13);
		panel.add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setBounds(21, 120, 45, 13);
		panel.add(lblModelo);

		cbBoxMarca = new JComboBox(new DefaultComboBoxModel(Coche.cbBoxMarca));
		cbBoxMarca.setSelectedIndex(-1);
		cbBoxMarca.setBounds(86, 77, 96, 21);
		panel.add(cbBoxMarca);
		
		cbBoxModelo = new JComboBox(new DefaultComboBoxModel());
		cbBoxModelo.setBounds(86, 116, 96, 21);
		panel.add(cbBoxModelo);
		
		JComboBox cbBoxColor = new JComboBox(new DefaultComboBoxModel(Coche.cbBoxColor));
		cbBoxColor.setSelectedIndex(-1);
		cbBoxColor.setBounds(86, 154, 96, 21);
		panel.add(cbBoxColor);
		
		JLabel lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		lblError.setBounds(21, 241, 378, 13);
		panel.add(lblError);

		
		JButton btnMatriuculaAleatoria = new JButton("Aleatoria");
		btnMatriuculaAleatoria.addActionListener(e -> {
			fTextFldMatricula.setText(Coche.matAleatoria());
		});
		btnMatriuculaAleatoria.setBounds(202, 40, 101, 21);
		panel.add(btnMatriuculaAleatoria);
		
		JButton btnFabricar = new JButton("Fabricar Coche");
		btnFabricar.addActionListener(e->{
			
			String matricula;
			String marca;
			String modelo;
			String color;
			
			try {
				matricula = fTextFldMatricula.getText();
				marca = cbBoxMarca.getSelectedItem().toString();
				modelo = cbBoxModelo.getSelectedItem().toString();
				color = cbBoxColor.getSelectedItem().toString();
			}catch (Exception ex) {
				lblError.setText("Debe seleccionar marca, modelo y color de coche\n");
				return;
			}
			
			
			if (!fTextFldMatricula.isEditValid()) {
				matricula = Coche.matAleatoria();
			}
			if (Coche.numCoches < 5) {
									
					Coche c = new Coche(matricula, marca ,modelo, color);
					parqueCoches.add(c);
					//modelCoche.addElement(c);
					modelCoche.removeAllElements();
					for(Coche car : parqueCoches) {
						modelCoche.addElement(car);

					}
					lblError.setText("");
					cbBoxMarca.setSelectedIndex(-1);
					cbBoxModelo.setModel(modelos[3]);
					cbBoxColor.setSelectedIndex(-1);
					fTextFldMatricula.setValue(null);
			}else {
				lblError.setText("No es posible crear m�s coches, el parque est� lleno");
			}
	
		});
		btnFabricar.setBounds(21, 210, 161, 21);
		panel.add(btnFabricar);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setBounds(21, 158, 45, 13);
		panel.add(lblColor);
		
		try {
			fTextFldMatricula = new JFormattedTextField( new MaskFormatter("####-UUU"));
			fTextFldMatricula.setToolTipText("1111-AAA");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		fTextFldMatricula.setBounds(86, 41, 96, 19);
		panel.add(fTextFldMatricula);
		
		setComboBoxModelo();
	}
	//M�todo encargado de colocar los modelos en funci�n de la marca escogida
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public void setComboBoxModelo() {
			modelos[0] = new DefaultComboBoxModel(Coche.cbBoxModeloVW);
			modelos[1] = new DefaultComboBoxModel(Coche.cbBoxModeloAD);
			modelos[2] = new DefaultComboBoxModel(Coche.cbBoxModeloMD);
			modelos[3] = new DefaultComboBoxModel(Coche.cboxVacio);
			cbBoxModelo.setModel(new DefaultComboBoxModel(new String[] {" "}));

			cbBoxMarca.addActionListener(e -> {
						
						if (cbBoxMarca.getSelectedIndex() == -1) {
							cbBoxModelo.setModel(modelos[3]);
						}else {
							int i = cbBoxMarca.getSelectedIndex();
							cbBoxModelo.setModel(modelos[i]);
						}
			});
		}
}
