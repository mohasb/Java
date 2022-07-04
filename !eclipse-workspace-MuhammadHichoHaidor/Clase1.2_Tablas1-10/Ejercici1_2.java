
/**
Realiza un aplicación Java que muestre por pantalla las tablas de multiplicar desde el 1 al 10, usando las estructura while
 */
public class Ejercici1_2
{
   public static void main(String [] args){
       final int MAX=10;
       int tabla=1;
       int num=0;
       while(tabla<=MAX){
           while(num<=MAX){
           System.out.println(tabla+" x "+num+" = "+tabla*num);
           num++;
           //System.out.println(3*i++);
        } 
        num=0;
        tabla++;
        }
    
    
    }
    
    
}
