import java.util.Scanner;

public class Dni
{
   public static void main(String[] args) {
       //Variables
       int dni = 0;
       int indice = 0;
       final char[] LETRAS = new char[]{'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
       Scanner sc = new Scanner(System.in);
       
       //Obtencion y guardado en variable del numero de dni
       System.out.println("Introduce tu numero dni y te dire su letra");
       dni = sc.nextInt();
       
       //obtencion del indice de la letra del dni en el array "LETRAS"
       indice = dni % 23;
       
       System.out.println("La letra correspondiente al DNI " + dni + " es: " + LETRAS[indice]);
       sc.close();
   }
}
