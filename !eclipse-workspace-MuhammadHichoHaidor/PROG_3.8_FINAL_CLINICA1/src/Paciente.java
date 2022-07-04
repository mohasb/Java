import javax.swing.JOptionPane;
public class Paciente
{
    //Variables clase Paciente
    String nombre = "";
    int edad = 0;
    double peso = 0f;
    double estatura = 0d;
    double imc = 0d;
    String estado = "";
    
    void obtenDatos(int i) {
        try {
            nombre = JOptionPane.showInputDialog(null,"Introduce el nombre del paciente " + (i + 1) + ":", "Clínica de dietética",JOptionPane.QUESTION_MESSAGE);
            edad = Integer.parseInt(JOptionPane.showInputDialog(null,"Introduce la edad de "+ nombre, "Clínica de dietética",JOptionPane.QUESTION_MESSAGE));
            peso = Double.parseDouble(JOptionPane.showInputDialog(null,"Introduce el peso (Kg) de " + nombre, "Clínica de dietética",JOptionPane.QUESTION_MESSAGE).replace(",", "."));
            estatura = Double.parseDouble(JOptionPane.showInputDialog(null,"Introduce la estatura (m) de " + nombre, "Clínica de dietética",JOptionPane.QUESTION_MESSAGE).replace(",", "."));
        }catch (Exception error) {
            JOptionPane.showMessageDialog(null, "Ha habido un error en la introducción de datos:\n" + error, "Clínica de dietética",JOptionPane.ERROR_MESSAGE);
        }
    }
    void muestraDatos() {
        JOptionPane.showMessageDialog(null, nombre + " su IMC es: " + String.format("%,.2f", imc) + "; Su estado es: " + estado, "Clínica de dietética",JOptionPane.INFORMATION_MESSAGE);
    }
    void calculaImc() {
        imc = peso / Math.pow(estatura, 2);
    }
    void calculaEstado() {
        if (imc <= 16) {
            estado = "Desnutrición grado 3";
        }else if (imc > 16 && imc <= 17 ) {
            estado = "Desnutrición grado 2";
        }else if (imc > 17 && imc <= 18.5 ) {
            estado = "Desnutrición grado 1";
        }else if (imc > 18.5 && imc <= 25 ) {
            estado = "Normal";
        }else if (imc > 25 && imc <= 30 ) {
            estado = "Sobrepeso grado 1";
        }else if (imc > 30 && imc <= 40 ) {
            estado = "Sobrepeso grado 2";
        }else if (imc > 40) {
            estado = "Sobrepeso grado 3";
        } 
    }
}  