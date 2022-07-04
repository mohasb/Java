import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaNIF extends JFrame implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Variables
    private JPanel panel;
    private JLabel nombre;
    private JLabel dni;
    private JLabel resultado;
    private JTextField inputNombre;
    private JTextField inputDni;
    private JButton botonCalcular;
    private JButton botonBorrar;
    //Constructor
    public PantallaNIF() {
        //titulo del frame
        this.setTitle("Cálculo del NIF");
        //Creación de los componentes
        panel = new JPanel();
        nombre = new JLabel("Nombre");
        dni = new JLabel("DNI");
        resultado = new JLabel();
        inputNombre = new JTextField();
        inputDni = new JTextField();
        botonCalcular = new JButton("Calcula NIF");
        botonBorrar = new JButton("Borrar datos");

        //Añadir los componentes al panel
        panel.add(nombre);
        panel.add(dni);
        panel.add(resultado);
        panel.add(inputNombre);
        panel.add(inputDni);
        panel.add(botonCalcular);
        panel.add(botonBorrar);
        //Borrar el layout por defecto(FlowLayout) y establecer que no se pueda redimensionar para que deje mover elementos y
        panel.setLayout(null);

        //Establecer posición de los objetos
        nombre.setBounds(30, 20, 100, 30);
        dni.setBounds(30, 40, 50, 50);
        inputNombre.setBounds(90, 25, 150, 20);
        inputDni.setBounds(90, 55, 75, 20);
        botonCalcular.setBounds(30, 100, 130, 20);
        botonBorrar.setBounds(30, 130, 130, 20);
        resultado.setBounds(170, 85, 200, 50);
        botonCalcular.addActionListener(this);
        botonBorrar.addActionListener(this);

        //Añadir panel al frame
        this.add(panel);
        //posición y tamaño del frame
        this.setBounds(200, 200, 400, 200);
        //Hacer visible el frame
        this.setVisible(true);
        //Establecer acción al cerrar
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //No permito que se redimensione
        this.setResizable(false);

    }

    public static void main(String[] args) {
        @SuppressWarnings("unused")
		PantallaNIF CalculaNif = new PantallaNIF();

    }
    //Método encargado de devolver true si el nombre y el dni cumple los requisitos
    private static boolean validarDatos(String nombre, String dni) {
        boolean isNombreOk;
        boolean isDniOk;

        //Validación campo nombre
        if (nombre.equals("") || dni.equals("")) {
            JOptionPane.showMessageDialog(null, "Primero introduce tu nombre y dni", "Cálculo del NIF", JOptionPane.INFORMATION_MESSAGE);
            isNombreOk = false;
            isDniOk = false;
        } else {
            isNombreOk = true;
            //Validación campo dni
            try {
                Integer.parseInt(dni);
                if (dni.length() != 8) {
                    JOptionPane.showMessageDialog(null, "El número de DNI deben ser 8 números", "Cálculo del NIF", JOptionPane.ERROR_MESSAGE);
                    isNombreOk = false;
                }
                isDniOk = true;
            }catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "El número de DNI debe ser numérico", "Cálculo del NIF", JOptionPane.ERROR_MESSAGE);
                isDniOk = false;
            }
        }

        //retorno del método validarDatos()
        if (isNombreOk && isDniOk) {
            return true;
        }else {
            return false;
        }
    }

    //Método sobrescrito de la clase implementada que se encarga de ejecutar las acciones de los botones
    @Override
    public void actionPerformed(ActionEvent e) {

        String nombre = inputNombre.getText();
        String dni = inputDni.getText();

        if (e.getSource().equals(botonCalcular)) {
            if (validarDatos(nombre, dni)) {
                Persona cliente = new Persona(nombre, dni);
                resultado.setText(cliente.toString());
            }

        }
        if (e.getSource().equals(botonBorrar)) {
            inputNombre.setText("");
            inputDni.setText("");
            resultado.setText("");
        }

    }

}
