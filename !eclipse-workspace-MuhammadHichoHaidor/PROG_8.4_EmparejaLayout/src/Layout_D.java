
import javax.swing.*;
import java.awt.*;
//Este Layout(D) equivale a la ventana Nº2
public class Layout_D {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);
        JButton button = new JButton("tesuji");
        JButton buttonTwo = new JButton("watari");
        frame.getContentPane().add(BorderLayout.NORTH, panel);
        panel.add(buttonTwo);
        frame.getContentPane().add(BorderLayout.CENTER, button);

        frame.setBounds(20,20,400,250);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
