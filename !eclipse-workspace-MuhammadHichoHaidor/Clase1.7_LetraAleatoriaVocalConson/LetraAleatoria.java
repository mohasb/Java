import java.util.Scanner;
import java.lang.Math;

public class LetraAleatoria
{
    public static void main(String[] args) {
        //Variables
        char letra;
        int max = 90;
        int min = 65;
        int numeroRandom = 0;
        boolean vocal = false;
        String respuesta = "";
        Scanner teclado = new Scanner(System.in);
        do {
            //Obtenci�n nummero aleatorio y conversion a caracter
            numeroRandom = (int) Math.round((Math.random()*(min - max) + max));
            letra = (char) numeroRandom;
            //Determinar de si es vocal o consonante 
            if ((letra == 'A') || (letra == 'E') || (letra == 'I') || (letra == 'O') || (letra == 'U')){
                vocal = true;
            }else {
                vocal = false;
            }
            //Impresion por pantalla del resultado y preguntar si desea volver a generar
            System.out.println("> La letra obtenida al azar es la " + letra + ", que corresponde a una " + ((vocal) ? "Vocal" : "Consonante"));
            System.out.println("> �Desea que vuelva a generar otra letra? y/n");
            respuesta = teclado.next();
            
        }while ((respuesta.charAt(0) == 'y') ||(respuesta.charAt(0) == 'Y'));
        teclado.close();
    }
}
