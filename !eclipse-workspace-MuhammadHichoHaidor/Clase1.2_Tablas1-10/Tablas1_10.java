
public class Tablas1_10
{
    public static void main(String[] args) {
        
        int tabla = 1;              
        int multiplicador = 0;
        
        while (tabla <= 10) {           //Hasta que llegue a la tabla del 10 imprime el título
            
            multiplicador = 0;          //inicializo a 0 para que vuelva a entrar en el while de abajo
            System.out.println("Tabla del: " + tabla + "\n");
            
            while (multiplicador <= 10) {   
            System.out.println(tabla + " * " + multiplicador + " = " + (tabla * multiplicador));
            
            multiplicador++;
            }
            
            tabla++;
        }
        
    }
}
