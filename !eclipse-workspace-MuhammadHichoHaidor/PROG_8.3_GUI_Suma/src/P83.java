
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
//import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class P83 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField num1;
	private JTextField num2;
	private JButton bSumar;
	private JLabel eResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					P83 frame = new P83();
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
	public P83() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 409, 151);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
																										//Establecer titulo frame a mano
		setTitle("Pr�ctica P8.3: Suma de dos n�meros");
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		//panel.setLayout(new MigLayout("", "[][][][90.00][28.00][grow]", "[][][][][][][][][][][]"));
		
		JLabel label1 = new JLabel("Introduce el primer n\u00BA");
		panel.add(label1, "cell 1 1");
		
		num1 = new JTextField();
		panel.add(num1, "cell 3 1,growx");
		num1.setColumns(10);
		
		JLabel label2 = new JLabel("Introduce el segundo n\u00BA");
		panel.add(label2, "cell 1 3");
		
		num2 = new JTextField();
		panel.add(num2, "cell 3 3,growx");
		num2.setColumns(10);
		
		bSumar = new JButton("Sumar");
		bSumar.addActionListener(new ActionListener() {
																										//M�todo implementado a mano
			public void actionPerformed(ActionEvent e) {
				double suma;
				suma = Double.parseDouble(num1.getText().replace(',', '.')) + Double.parseDouble(num2.getText().replace(',', '.'));
				eResult.setText("Suma: " + suma);
			}
		});
		panel.add(bSumar, "cell 3 5,growx");
		
		eResult = new JLabel("labelResulatdo");
		panel.add(eResult, "cell 5 5,alignx left");
	}

}
