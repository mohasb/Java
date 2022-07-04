import javax.swing.JOptionPane;
public class Main
{
    public static void main(String[] args) {
        //Primero obtengo el valor del numero de pacientes(tamaño del arrayPacientes)
        int numeroPacientes = 0;
        numeroPacientes = Integer.parseInt(JOptionPane.showInputDialog(null,"Introduce el número de pacientes","Clínica de dietética",JOptionPane.QUESTION_MESSAGE));
        //Creo e inicializo una array de objetos de la clase Paciente de tamaño del numero de pacientes
        Paciente[] arrayPacientes = new Paciente[numeroPacientes];
        //Para cada iteración -> creo objeto -> obtengo los datos -> calculo imc -> calculo estado -> muestro los resultados
        for (int i = 0; i < arrayPacientes.length; i++) {
            arrayPacientes[i] = new Paciente();
            arrayPacientes[i].obtenDatos(i);
            arrayPacientes[i].calculaImc();
            arrayPacientes[i].calculaEstado();
            arrayPacientes[i].muestraDatos();
        }
        //Llamo al método resumen pasandole como argumento el arrayPacientes para los calculos(Podria haber puesto los calculos a continuación pero me ha parecido mas limpio asi...)
        mensajeResumen(arrayPacientes);

    }
    public static void mensajeResumen(Paciente[] arrayPacientes) {
        int edadMaxima = 0;
        int edadMinima = 0;
        edadMaxima = edadMinima = arrayPacientes[0].edad;
        for (int j = 0; j < arrayPacientes.length; j++) {
            if (arrayPacientes[j].edad > edadMaxima) {
                edadMaxima = arrayPacientes[j].edad;
            }
            if (arrayPacientes[j].edad < edadMinima) {
                edadMinima = arrayPacientes[j].edad;
            }
        }
        double estaturaMedia = 0;
        for (int k = 0; k < arrayPacientes.length; k++) {
            estaturaMedia += arrayPacientes[k].estatura / arrayPacientes.length;
        }
        double pesoMedio = 0;
        for (int l = 0; l < arrayPacientes.length; l++) {
            pesoMedio += arrayPacientes[l].peso / arrayPacientes.length;
        }
        JOptionPane.showMessageDialog(null,"La edad máxima de los pacientes es: " + edadMaxima 
                                            + "\nLa edad mínima de los pacientes es: " + edadMinima 
                                            + "\nLa estatura media de los pacientes es: " + String.format("%,.2f", estaturaMedia) 
                                            + "\nEl peso medio de los pacientes es: " + String.format("%,.2f", pesoMedio)
                                            , "Clínica de dietética",JOptionPane.INFORMATION_MESSAGE);

    }
}