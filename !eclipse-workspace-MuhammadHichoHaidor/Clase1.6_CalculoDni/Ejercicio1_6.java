
/**
 * Write a description of class Ejercicio1_6 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Ejercicio1_6
{
    public static void main(String []args)
    {
        Scanner tec = new Scanner(System.in);
        int dni;
        char[] letra={'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        System.out.println("Introduce tu DNI y te diré la letra.");
        dni=tec.nextInt();
        System.out.println("Tu DNI es: "+dni+""+letra[dni%23]);
        
        
     
     tec.close();
    }
}
