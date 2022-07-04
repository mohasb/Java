
/* Realiza un aplicación Java que calcule el área y la longitud 
 * de una circunferencia de radio indicado por teclado en metros.*/
import java.util.*;
import java.lang.Math;
public class Ejercicio1_5{
    public static void main(String[]args){
        
        Scanner tec= new Scanner(System.in);
        System.out.println("Introducir el radio de la circunferencia : ");
        Double radio = tec.nextDouble();
        Double longitud = radio * 2 * Math.PI;
        Double area = Math.PI * Math.pow(radio, 2);
        System.out.println( "Longitud circunferencia : " + longitud + "\nArea  : " + area );
    }
}
        
        