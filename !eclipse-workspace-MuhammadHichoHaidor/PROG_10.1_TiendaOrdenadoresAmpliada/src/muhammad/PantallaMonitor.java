package muhammad;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

//Calse encargada de la vista de los monitores
public class PantallaMonitor extends JDialog {

	// Variables
	private static final long serialVersionUID = 1L;
	private final JPanel basePanel = new JPanel();
	private JTextField textFieldIdentificador;
	private JTextField textFieldNSerie;
	private JTextField textFieldTipoMonitor;
	private JTextField textFieldPulgadas;
	private JTextField textFieldPrecio;
	private JComboBox<String> cBoxNSerie;
	private Monitor monitor;
	public ConectorBaseDatos conector;

	/**
	 * Create the dialog.
	 */
	public PantallaMonitor(java.awt.Frame padre, boolean modal) {
		super(padre, modal);
		setTitle("Tienda de ordenadores - Monitores");
		setBounds(750, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		basePanel.setMaximumSize(new Dimension(50, 50));
		basePanel.setPreferredSize(new Dimension(50, 50));
		basePanel.setBorder(new EmptyBorder(20, 20, 20, 20));
		getContentPane().add(basePanel, BorderLayout.CENTER);
		GridBagLayout gbl_basePanel = new GridBagLayout();
		gbl_basePanel.columnWidths = new int[] { 215, 136, 0 };
		gbl_basePanel.rowHeights = new int[] { 16, 16, 16, 16, 16, 16, 16, 0 };
		gbl_basePanel.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_basePanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		basePanel.setLayout(gbl_basePanel);
		{
			JLabel lblElige = new JLabel("ELige el monitor que quieras:");
			lblElige.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblElige.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_lblElige = new GridBagConstraints();
			gbc_lblElige.fill = GridBagConstraints.BOTH;
			gbc_lblElige.insets = new Insets(0, 0, 5, 5);
			gbc_lblElige.gridx = 0;
			gbc_lblElige.gridy = 0;
			basePanel.add(lblElige, gbc_lblElige);
		}
		{
			JPanel panelEspacio = new JPanel();
			GridBagConstraints gbc_panelEspacio = new GridBagConstraints();
			gbc_panelEspacio.fill = GridBagConstraints.BOTH;
			gbc_panelEspacio.insets = new Insets(0, 0, 5, 0);
			gbc_panelEspacio.gridx = 1;
			gbc_panelEspacio.gridy = 0;
			basePanel.add(panelEspacio, gbc_panelEspacio);
		}
		{
			cBoxNSerie = new JComboBox<String>();
			cBoxNSerie.setBorder(new EmptyBorder(1, 1, 1, 1));
			GridBagConstraints gbc_cBoxNSerie = new GridBagConstraints();
			gbc_cBoxNSerie.ipadx = 60;
			gbc_cBoxNSerie.insets = new Insets(0, 0, 5, 10);
			gbc_cBoxNSerie.gridx = 0;
			gbc_cBoxNSerie.gridy = 1;
			basePanel.add(cBoxNSerie, gbc_cBoxNSerie);
		}
		{
			JButton btnVisualizar = new JButton("Visualizar");
			btnVisualizar.addActionListener(new btnVisualizar());
			btnVisualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
			GridBagConstraints gbc_btnVisualizar = new GridBagConstraints();
			gbc_btnVisualizar.anchor = GridBagConstraints.WEST;
			gbc_btnVisualizar.insets = new Insets(0, 0, 5, 0);
			gbc_btnVisualizar.gridx = 1;
			gbc_btnVisualizar.gridy = 1;
			basePanel.add(btnVisualizar, gbc_btnVisualizar);
		}
		{
			JLabel lblIdentificador = new JLabel("Identificador");
			lblIdentificador.setBorder(new EmptyBorder(0, 60, 0, 0));
			lblIdentificador.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblIdentificador.setHorizontalAlignment(SwingConstants.LEFT);
			GridBagConstraints gbc_lblIdentificador = new GridBagConstraints();
			gbc_lblIdentificador.fill = GridBagConstraints.BOTH;
			gbc_lblIdentificador.insets = new Insets(0, 0, 5, 5);
			gbc_lblIdentificador.gridx = 0;
			gbc_lblIdentificador.gridy = 2;
			basePanel.add(lblIdentificador, gbc_lblIdentificador);
		}
		{
			textFieldIdentificador = new JTextField();
			textFieldIdentificador.setEditable(false);
			GridBagConstraints gbc_textFieldIdentificador = new GridBagConstraints();
			gbc_textFieldIdentificador.anchor = GridBagConstraints.WEST;
			gbc_textFieldIdentificador.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldIdentificador.gridx = 1;
			gbc_textFieldIdentificador.gridy = 2;
			basePanel.add(textFieldIdentificador, gbc_textFieldIdentificador);
			textFieldIdentificador.setColumns(15);
		}
		{
			JLabel lblNSerie = new JLabel("Nº de serie");
			lblNSerie.setBorder(new EmptyBorder(0, 60, 0, 0));
			lblNSerie.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNSerie.setHorizontalAlignment(SwingConstants.LEFT);
			GridBagConstraints gbc_lblNSerie = new GridBagConstraints();
			gbc_lblNSerie.fill = GridBagConstraints.BOTH;
			gbc_lblNSerie.insets = new Insets(0, 0, 5, 5);
			gbc_lblNSerie.gridx = 0;
			gbc_lblNSerie.gridy = 3;
			basePanel.add(lblNSerie, gbc_lblNSerie);
		}
		{
			textFieldNSerie = new JTextField();
			GridBagConstraints gbc_textFieldNSerie = new GridBagConstraints();
			gbc_textFieldNSerie.anchor = GridBagConstraints.WEST;
			gbc_textFieldNSerie.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldNSerie.gridx = 1;
			gbc_textFieldNSerie.gridy = 3;
			basePanel.add(textFieldNSerie, gbc_textFieldNSerie);
			textFieldNSerie.setColumns(15);
		}
		{
			JLabel lblTipoMonitor = new JLabel("Tipo de monitor");
			lblTipoMonitor.setBorder(new EmptyBorder(0, 60, 0, 0));
			lblTipoMonitor.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblTipoMonitor.setHorizontalAlignment(SwingConstants.LEFT);
			GridBagConstraints gbc_lblTipoMonitor = new GridBagConstraints();
			gbc_lblTipoMonitor.fill = GridBagConstraints.BOTH;
			gbc_lblTipoMonitor.insets = new Insets(0, 0, 5, 5);
			gbc_lblTipoMonitor.gridx = 0;
			gbc_lblTipoMonitor.gridy = 4;
			basePanel.add(lblTipoMonitor, gbc_lblTipoMonitor);
		}
		{
			textFieldTipoMonitor = new JTextField();
			GridBagConstraints gbc_textFieldTipoMonitor = new GridBagConstraints();
			gbc_textFieldTipoMonitor.anchor = GridBagConstraints.WEST;
			gbc_textFieldTipoMonitor.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldTipoMonitor.gridx = 1;
			gbc_textFieldTipoMonitor.gridy = 4;
			basePanel.add(textFieldTipoMonitor, gbc_textFieldTipoMonitor);
			textFieldTipoMonitor.setColumns(15);
		}
		{
			JLabel lblPulgadas = new JLabel("Pulgadas");
			lblPulgadas.setBorder(new EmptyBorder(0, 60, 0, 0));
			lblPulgadas.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblPulgadas.setHorizontalAlignment(SwingConstants.LEFT);
			GridBagConstraints gbc_lblPulgadas = new GridBagConstraints();
			gbc_lblPulgadas.fill = GridBagConstraints.BOTH;
			gbc_lblPulgadas.insets = new Insets(0, 0, 5, 5);
			gbc_lblPulgadas.gridx = 0;
			gbc_lblPulgadas.gridy = 5;
			basePanel.add(lblPulgadas, gbc_lblPulgadas);
		}
		{
			textFieldPulgadas = new JTextField();
			GridBagConstraints gbc_textFieldPulgadas = new GridBagConstraints();
			gbc_textFieldPulgadas.anchor = GridBagConstraints.WEST;
			gbc_textFieldPulgadas.insets = new Insets(0, 0, 5, 0);
			gbc_textFieldPulgadas.gridx = 1;
			gbc_textFieldPulgadas.gridy = 5;
			basePanel.add(textFieldPulgadas, gbc_textFieldPulgadas);
			textFieldPulgadas.setColumns(5);
		}
		{
			JLabel lblPrecio = new JLabel("Precio");
			lblPrecio.setBorder(new EmptyBorder(0, 60, 0, 0));
			lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblPrecio.setHorizontalAlignment(SwingConstants.LEFT);
			GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
			gbc_lblPrecio.fill = GridBagConstraints.BOTH;
			gbc_lblPrecio.insets = new Insets(0, 0, 0, 5);
			gbc_lblPrecio.gridx = 0;
			gbc_lblPrecio.gridy = 6;
			basePanel.add(lblPrecio, gbc_lblPrecio);
		}
		{
			textFieldPrecio = new JTextField();
			GridBagConstraints gbc_textFieldPrecio = new GridBagConstraints();
			gbc_textFieldPrecio.anchor = GridBagConstraints.WEST;
			gbc_textFieldPrecio.gridx = 1;
			gbc_textFieldPrecio.gridy = 6;
			basePanel.add(textFieldPrecio, gbc_textFieldPrecio);
			textFieldPrecio.setColumns(5);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new EmptyBorder(0, 0, 10, 0));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton btnModificar = new JButton("Modificar");
				btnModificar.addActionListener(new btnModificar());
				btnModificar.setFont(new Font("Tahoma", Font.PLAIN, 14));
				btnModificar.setActionCommand("OK");
				buttonPane.add(btnModificar);
				getRootPane().setDefaultButton(btnModificar);
			}
		}
		
		rellenaCbox();
	}

	// rellenar el combobox con los numero de serie de los monitores
	void rellenaCbox() {

		// Creo instancia de la clase encargada de conectar a la base de datos
		ConectorBaseDatos baseDatos = new ConectorBaseDatos();
		// Conectar base de datos
		if (baseDatos.setConection() == null) {
			JOptionPane.showMessageDialog(basePanel, "Error al listar los numeros de serie");
			return;
		}
		
		
		// Creo un arraylist con todos los numeros de serie obtenido de la consulta
		ArrayList<String> consultaNSeries = baseDatos.ObtenerNSerieMonitor();
		// Relleno el comboBox con los elementos del arrayList
		for (String nSerie : consultaNSeries) {

			cBoxNSerie.addItem(nSerie);
		}

	}

	// Mostrar el monitor seleccionado
	class btnVisualizar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			conector = new ConectorBaseDatos();

			String nSerie = cBoxNSerie.getSelectedItem().toString();

			monitor = conector.obtenerMonitor(nSerie);

			String identificador = monitor.getId();
			String numSerie = monitor.getNumSerie();
			String tipo = monitor.getTipo();
			int pulgadas = monitor.getPulgadas();
			Double precio = monitor.getPrecio();

			textFieldIdentificador.setText(identificador);
			textFieldNSerie.setText(numSerie);
			textFieldTipoMonitor.setText(tipo);
			textFieldPulgadas.setText(String.valueOf(pulgadas));
			textFieldPrecio.setText(String.valueOf(precio));
		}

	}

	// Modificar monitor
	class btnModificar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			String identificador = textFieldIdentificador.getText();
			String numSerie = textFieldNSerie.getText();
			String tipo = textFieldTipoMonitor.getText();
			int pulgadas = Integer.parseInt(textFieldPulgadas.getText());
			Double precio = Double.parseDouble(textFieldPrecio.getText());

			// update
			if (conector.modificaMonitor(identificador, monitor.getCategoria(), numSerie, tipo, pulgadas, precio)) {
				JOptionPane.showMessageDialog(null, "Monitor modificado");
			} else {
				JOptionPane.showMessageDialog(null, "Error al modificar monitor");
			}

		}

	}

}
