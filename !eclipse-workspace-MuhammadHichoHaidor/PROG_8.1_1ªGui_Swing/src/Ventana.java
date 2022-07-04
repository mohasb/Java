import javax.swing.*;

public class Ventana extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel;
    JLabel texto;
    JButton boton;

    public Ventana() {

        panel = new JPanel();
        texto = new JLabel();
        boton = new JButton();
        this.add(panel);
        panel.add(texto);
        panel.add(boton);
        texto.setText("Hola mundo!");
        boton.setText("Púlsame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}