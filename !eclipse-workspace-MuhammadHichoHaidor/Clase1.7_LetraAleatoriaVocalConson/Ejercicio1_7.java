
/**
 * Realiza un aplicación Java que genere letras aleatóriamente y distinga si es una vocal  o una consonante.
 * 
 * Por pantalla debería de salir algo como esto:
 * 
 * > La letra obtenida al azar es la A, que corresponde a una vocal
 * >¿Desea que vuelva a generar otra letra? y/n
 */
import java.lang.Math;
import java.util.Scanner;
public class Ejercicio1_7
{
    public static void main(String []args)
    {   
        //codigo ASCII A->65 Z->90 , a->97 z->122, cod min:1, max:255
        int min;
        int max;
        int alea, aux ;
        String tipo;
        Scanner tec = new Scanner(System.in);
        char continuar='y';
        do
        {
            //aux nos proporciona un valor entre 1 y 2 aleatoriamente, este nos dirá si cogemos el grupo
            //de las mayusculas o las minusculas
            aux= (int)(Math.random()*(2-1+1)+1);
            if(aux==1)
            {
                min=65;
                max=90; 
                tipo ="mayuscula";
            }
            else
            {
                min=97;
                max=122;
                tipo="minuscula";
            }
            alea= (int)(Math.random()*(max-min+1)+min);
            System.out.println(alea);
            char ch = (char) alea; 
            System.out.println(ch); 
            if(alea==65||alea==69||alea==73||alea==79||alea==85||alea==97||alea==101||alea==105||alea==111||alea==117)
            {
            System.out.println("La letra obtenida al azar es la : "+ch+" y corresopnde a una vocal "+tipo);
         }else {
            System.out.println("La letra obtenida al azar es la : "+ch+" y corresponde a una consonante "+tipo);
         }
            System.out.println("¿Desea que vuelva a renerar otra letra? y/n");
            continuar=tec.next().charAt(0);
    }while(continuar=='y'||continuar=='Y');
    System.out.println("Gracias por jugar con nosotros, \nAdios");    
    tec.close();

    }
    
}