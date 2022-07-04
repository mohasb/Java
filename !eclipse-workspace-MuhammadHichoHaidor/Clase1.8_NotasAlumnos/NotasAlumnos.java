
import java.util.Scanner;

public class NotasAlumnos
{
   public static void main(String[] args) {
       //Variables 
       int numeroNotas = 0;
       int aprobados = 0;
       int suspendidos = 0;
       int condicionados = 0;
       Scanner teclado = new Scanner(System.in);
       
       
       System.out.println("Introduce el numero de notas de alumnos a añadir:");
       numeroNotas = teclado.nextInt();
        double[] notas = new double[numeroNotas];

       
       for (int i = 0; i < numeroNotas; i++) {
           System.out.println("Introduce la nota del alumno " + (i + 1));
           notas[i] = teclado.nextDouble();
       }
       
       for (int i = 0; i < numeroNotas; i++) {
           if (notas[i] >= 5 ) {
               aprobados++;
           }else {
               suspendidos++;
               if (notas[i] >= 4 && notas[i] <= 4.9) {
                   condicionados++;
               }
           }
       }
       
       System.out.println("Aprobados: " + aprobados + "\nSuspendidos: " + suspendidos + "\nCondicionados: " + condicionados);
       
       
       
       teclado.close();

       
   }      
}
