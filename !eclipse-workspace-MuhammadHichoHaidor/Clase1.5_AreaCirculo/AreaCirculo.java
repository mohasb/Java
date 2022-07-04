
import java.util.Scanner;
import java.lang.Math;

public class AreaCirculo
{   
   public static void  main(String[] args) {
       double radio = 0;
       double area = 0;
       double longitud = 0;

       //Obtención valor del radio por teclado
       Scanner teclado = new Scanner(System.in);
       System.out.println("Introduce el radio (metros) del circulo para calcular su area y su longitud");
       radio = teclado.nextDouble();

       //Calculo del area y la longitud
       area = Math.PI * Math.pow(radio, 2);
       longitud = 2 * Math.PI * radio;
       
       //Impresion por pantalla de resultado
       System.out.print("El area de un circulo de radio " + radio + " metros es: ");
       System.out.printf("%.3f", area );
       System.out.print(" metros² y su longitud es: ");
       System.out.printf("%.3f", longitud);
       System.out.print(" metros.");
   }
}
