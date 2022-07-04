
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class Calculadora extends JFrame implements ActionListener {

        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JPanel contentPane;
        private JTextField tFieldPantalla;
        private JButton btnIgual;
        private String stringPantalla = "";
        private double numero1 = 0;
        private double numero2 = 0;
        private String operacion;


        /**
         * Launch the application.
         */
        public static void main(String[] args) {
            EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        Calculadora frame = new Calculadora();
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
        public Calculadora() {
            setResizable(false);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(100, 100, 260, 274);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            contentPane.setLayout(new BorderLayout(0, 0));
            setContentPane(contentPane);

            JPanel panel = new JPanel();
            contentPane.add(panel, BorderLayout.CENTER);
            panel.setLayout(null);

            tFieldPantalla = new JTextField();
            tFieldPantalla.setFont(new Font("Source Serif Pro", Font.BOLD, 20));
            tFieldPantalla.setText("");
            tFieldPantalla.setBounds(11, 10, 212, 35);
            tFieldPantalla.setColumns(10);
            tFieldPantalla.setHorizontalAlignment(JTextField.RIGHT);
            panel.add(tFieldPantalla);
            

            JButton btn1 = new JButton("1");
            btn1.setBounds(12, 96, 46, 21);
            panel.add(btn1);
            btn1.addActionListener(this);

            JButton btn2 = new JButton("2");
            btn2.setBounds(62, 96, 46, 21);
            panel.add(btn2);
            btn2.addActionListener(this);

            JButton btn3 = new JButton("3");
            btn3.setBounds(112, 96, 46, 21);
            panel.add(btn3);
            btn3.addActionListener(this);

            JButton btn4 = new JButton("4");
            btn4.setBounds(12, 127, 46, 21);
            panel.add(btn4);
            btn4.addActionListener(this);

            JButton btn5 = new JButton("5");
            btn5.setBounds(62, 127, 46, 21);
            panel.add(btn5);
            btn5.addActionListener(this);

            JButton btn6 = new JButton("6");
            btn6.setBounds(112, 127, 46, 21);
            panel.add(btn6);
            btn6.addActionListener(this);

            JButton btn7 = new JButton("7");
            btn7.setBounds(12, 158, 46, 21);
            panel.add(btn7);
            btn7.addActionListener(this);

            JButton btn8 = new JButton("8");
            btn8.setBounds(62, 158, 46, 21);
            panel.add(btn8);
            btn8.addActionListener(this);

            JButton btn9 = new JButton("9");
            btn9.setBounds(112, 158, 46, 21);
            panel.add(btn9);
            btn9.addActionListener(this);

            JButton btnDecimal = new JButton(".");
            btnDecimal.setBounds(11, 189, 46, 21);
            panel.add(btnDecimal);
            btnDecimal.addActionListener(this);

            JButton btn0 = new JButton("0");
            btn0.setBounds(61, 189, 46, 21);
            panel.add(btn0);
            btn0.addActionListener(this);

            btnIgual = new JButton("=");
            btnIgual.setBounds(111, 189, 46, 21);
            panel.add(btnIgual);
            btnIgual.addActionListener(this);

            JButton btnMas = new JButton("+");
            btnMas.setBounds(178, 96, 46, 21);
            panel.add(btnMas);
            btnMas.addActionListener(this);

            JButton btnMenos = new JButton("-");
            btnMenos.setBounds(178, 127, 46, 21);
            panel.add(btnMenos);
            btnMenos.addActionListener(this);

            JButton btnMultiplicar = new JButton("*");
            btnMultiplicar.setBounds(178, 158, 46, 21);
            panel.add(btnMultiplicar);
            btnMultiplicar.addActionListener(this);

            JButton btnDividir = new JButton("/");
            btnDividir.setBounds(177, 189, 46, 21);
            panel.add(btnDividir);
            btnDividir.addActionListener(this);

            
            JButton btnAC = new JButton("AC");
            btnAC.setFont(new Font("Tahoma", Font.PLAIN, 8));
            btnAC.setBounds(177, 65, 46, 21);
            panel.add(btnAC);
            btnAC.addActionListener(this);
            
        }

        @Override
        public void actionPerformed(ActionEvent e) {
        	
        	String textoBoton = ((JButton) e.getSource()).getText();

        	ColocaNumero(textoBoton);
        }
        
         void ColocaNumero(String textoBoton) {
        	//seg�n el texto del boton haz:
             switch (textoBoton) {
             
             case "+":
            	 try {
                 	numero1 = Double.parseDouble(tFieldPantalla.getText());
                 	tFieldPantalla.setText("+");
                 	operacion = "+";
                 	stringPantalla = "";
                 	break;
            	 }catch (Exception e) {              
            		tFieldPantalla.setText("+");
                  	operacion = "+";
                  	stringPantalla = "";
            		break;
            	 }
             case "-":
            	 try {
                 	 numero1 = Double.parseDouble(tFieldPantalla.getText());
                 	tFieldPantalla.setText("-");
                 	operacion = "-";
                 	stringPantalla = "";
                 	break;
            	 }catch (Exception e) {
            		 tFieldPantalla.setText("-");
            		 operacion = "-";
            		 stringPantalla = "";
            		 break;
            	 }
             case "*":
            	 try {
                 	 numero1 = Double.parseDouble(tFieldPantalla.getText());
                 	 tFieldPantalla.setText("*");
                	 operacion = "*";
                     stringPantalla = "";
                     break;
            	 }catch (Exception e) {
            		 tFieldPantalla.setText("*");
                 	 operacion = "*";
                     stringPantalla = "";
                     break; 
				 }
             	 
             case "/":
            	 try {
                 	numero1 = Double.parseDouble(tFieldPantalla.getText());
                 	tFieldPantalla.setText("/");
                 	operacion = "/";
                 	stringPantalla = "";
                 	break;
            	 }catch (Exception e) {
            		 tFieldPantalla.setText("/");
            		 operacion = "/";
            		 stringPantalla = "";
            		 break;
            	 }
             case ".":
                 if (stringPantalla.contains(".")) {
                     break;
                 }
                 stringPantalla += textoBoton;
                 tFieldPantalla.setText(stringPantalla);
                 break;
             case "=":
             	if (operacion == "+") {
             		numero2 = (Double.parseDouble(tFieldPantalla.getText()));
             		tFieldPantalla.setText(String.valueOf(Operacion.Sumar(numero1, numero2)));
             	}
             	if (operacion == "-") {
             		numero2 = Double.parseDouble(tFieldPantalla.getText());
             		tFieldPantalla.setText(String.valueOf(Operacion.Restar(numero1, numero2)));
				}
                if (operacion == "*") {
                	numero2 = Double.parseDouble(tFieldPantalla.getText());
             		tFieldPantalla.setText(String.valueOf(Operacion.Multiplicar(numero1, numero2)));
				}
                if (operacion == "/") {
                	try {
                		numero2 = Double.parseDouble(tFieldPantalla.getText());
                	}catch (Exception e) {
						numero2 = 0;
					}
                	
                	
             		tFieldPantalla.setText(String.valueOf(Operacion.Dividir(numero1, numero2)));
				}

                 break;
             case "AC":
            	 tFieldPantalla.setText("");
            	 stringPantalla = "";
            	 numero1 = 0;
            	 numero2 = 0;
            	 break;
            
             default:
             		stringPantalla += textoBoton;
            	 	tFieldPantalla.setText(stringPantalla);
             	
             }
             
        }
}
