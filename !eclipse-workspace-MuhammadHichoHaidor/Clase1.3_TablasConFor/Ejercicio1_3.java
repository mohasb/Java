
/**
Realiza un aplicación Java que muestre por pantalla las tablas de multiplicar desde el 1 al 10, 
usando las estructura for. Compara con las soluciones de los ejercicios realizados con la estructura while.
 */
public class Ejercicio1_3
{
    public static void main(String[] args){
     final int NUMAX = 10;
        
        for(int i=1;i<=NUMAX;i++){
            for(int j=0;j<=NUMAX;j++){
                System.out.println(i+" x "+j+" = "+i*j);
            }
            System.out.println("");
        }
    }
}
