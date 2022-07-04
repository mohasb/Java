
public class TablasFor
{
    public static void main(String[] args) {
        
        int numero = 1;
        
        for (int j = 0; j < 10; j++) {
        System.out.println("\nTabla del: "+ numero + "\n");

        
        
            for (int i = 0; i <= 10; i++) {
            
            System.out.println(numero + " * " + i + " = " + numero * i);
            
            
            }
        
            numero++;
        }
    }
}
