
public class FinalTema1
{
   public static void main(String[] args) {
       //Variables
       int numero = 1;
       int numero2 = 0;
       //Imprimir por pantalla los primeros 25 numeros enteros pero si es el 25 imprimir sin coma
       System.out.print("Primeros 25 enteros:\n");
       while(numero <= 25) {
           
           if(numero == 25) {
               System.out.print(numero);
           }else {
                System.out.print(numero + ",");
           }
           numero++;
       }
       System.out.print("\n-----------------------------");
       //Imprimir por pantalla los primeros 50 numeros pares pero si es el 50 imprimir sin coma
       System.out.print("\nLos primeros pares hasta el 50:\n");
       numero = 2;
       while (numero <= 50) {
           if(numero == 50) {
               System.out.print(numero);
           }else {
              System.out.print(numero + ","); 
           }
           numero += 2;
       }
       System.out.print("\n-----------------------------");
       //Imprimir por pantalla los primeros 49 numeros impares pero si es el 49 imprimir sin coma
       System.out.print("\nLos primeros impares hasta el 49\n");
       numero = 1;
       while (numero <= 49) {
           if(numero == 49) {
               System.out.print(numero);
           }else {
              System.out.print(numero + ","); 
           }
           numero += 2;
       }
       System.out.print("\n-----------------------------");
       //Imprimir por consola las tablas de multiplicar hasta el 10
       System.out.print("\nTABLAS DE MULTIPLICAR");
       System.out.print("\n-----------------------------\n");
       //Inicializo a 1 por que 'numero' venia valiendo 51
       numero = 1; 
       
       while (numero <= 10) {
           System.out.println("Tabla de multiplicar del " + numero + ":");
           //inicializo a 0 para que vuelva a entrar en el bucle de abajo por que venia valiendo 10
           numero2 = 0; 
           while(numero2 <= 10) {
               System.out.println(numero + " * " + numero2 + " = " + numero * numero2);
               numero2++;
           }
           System.out.print("--------------\n");
           numero++;
       }
       
       
   }
}
