import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel;
    JButton boton, boton2;
    JLabel texto;
    JTextField input;



    public Ventana() {
        panel = new JPanel();
        boton = new JButton("Presionar");
        boton2 = new JButton("Presionar");
        texto = new JLabel();
        input = new JTextField("Escribe aqui");
        this.add(panel);
        panel.add(boton);
        panel.add(boton2);
        panel.add(input);
        panel.add(texto);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.boton.addActionListener(this);
        this.boton2.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(boton)) {
            this.texto.setText(this.input.getText());
        }
        if (e.getSource().equals(boton2)) {
            this.texto.setText("Has oprimido el botón dos ");
        }
    }
}

