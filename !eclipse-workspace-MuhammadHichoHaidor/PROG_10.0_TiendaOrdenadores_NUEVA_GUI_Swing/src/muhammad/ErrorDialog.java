package muhammad;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ErrorDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();


	/**
	 * Create the dialog.
	 */
	public ErrorDialog(java.awt.Frame padre, boolean modal) {
		super(padre, modal);
		setUndecorated(true);
		setBounds(100, 100, 290, 140);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panelTitulo = new JPanel();
			panelTitulo.setLayout(null);
			panelTitulo.setBackground(Color.BLACK);
			panelTitulo.setBounds(0, 0, 450, 25);
			contentPanel.add(panelTitulo);
			{
				JLabel btnSalir = new JLabel("X");
				btnSalir.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						dispose();
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
				btnSalir.setOpaque(true);
				btnSalir.setHorizontalAlignment(SwingConstants.CENTER);
				btnSalir.setForeground(Color.WHITE);
				btnSalir.setFont(new Font("Roboto Light", Font.BOLD, 20));
				btnSalir.setBackground(Color.BLACK);
				btnSalir.setBounds(260, 0, 30, 25);
				panelTitulo.add(btnSalir);
			}
			{
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setIcon(new ImageIcon(ErrorDialog.class.getResource("/muhammad/icono.png")));
				lblNewLabel.setOpaque(true);
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBackground(Color.BLACK);
				lblNewLabel.setBounds(0, 0, 26, 25);
				panelTitulo.add(lblNewLabel);
			}
			{
				JLabel lblNewLabel_1 = new JLabel("Tienda de Informática");
				lblNewLabel_1.setForeground(Color.WHITE);
				lblNewLabel_1.setFont(new Font("Roboto", Font.PLAIN, 14));
				lblNewLabel_1.setBounds(33, 8, 157, 13);
				panelTitulo.add(lblNewLabel_1);
			}
		}
		{
			JLabel lblError = new JLabel("Error al conectar a la  Base de Datos");
			lblError.setBounds(38, 58, 224, 13);
			contentPanel.add(lblError);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}

	
}
