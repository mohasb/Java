import javax.swing.JOptionPane;

public class Alumno
{
    String nombre = "";
    int nota = 0;
    int numeroAlumnos = 0;
    public void bienvenida() {
        JOptionPane.showMessageDialog(null, "PFinalTema2 desarollada por Muhammad hicho Abdeselam");
   }
    public void obtenerNumAlumnos() {
        numeroAlumnos = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce cuantos alumnos hay en la clase:"));
    }
    public void obtenerDatos() {
        
       for (int i = 1; i <= numeroAlumnos; i++) {
            nombre = JOptionPane.showInputDialog(null, "Introduce el nombre del alumno num. " + i + ":");
            nota = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduce la nota de " + nombre + ":"));
           if(nota >= 5) {
               felicitar();
           }else {
               reprender();
           }
        }
    }
    public void felicitar() {
        JOptionPane.showMessageDialog(null, "¡Enhorabuena " + nombre + ", has aprobado!");
    }
    public void reprender() {
        JOptionPane.showMessageDialog(null, "Necesitas estudiar, " + nombre);
    }
    public void despedida() {
        JOptionPane.showMessageDialog(null, "Hasta la próxima");
    }
}
