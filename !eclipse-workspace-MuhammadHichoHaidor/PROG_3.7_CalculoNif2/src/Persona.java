import javax.swing.JOptionPane;

public class Persona
{
    String letras = "TRWAGMYFPDXBNJZSQV";
    char[] vectorLetras = letras.toCharArray();
    String nombre = "";
    int dni = 0;
    int resto = 0;
    char letraNif;
    void obtenDatos() {
        nombre = JOptionPane.showInputDialog(null, "Introduce tu nombre");
        dni = Integer.parseInt(JOptionPane.showInputDialog(null, nombre + ", introduce los 8 numeros de tu dni")); 
        resto = dni%23;
        letraNif = vectorLetras[resto];
    }
    void muestraDatos() {
        JOptionPane.showMessageDialog(null, nombre + ", tu NIF es: " + dni + letraNif);
    }
}