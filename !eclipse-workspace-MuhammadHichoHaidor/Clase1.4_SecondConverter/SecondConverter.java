
public class SecondConverter
{
    public static void main(String[] args) {
        
        final int segundos = 8432100;   //Segundos dados para convertir
        int dias  = segundos / 86400;   //Un dia tiene 86400 segundos
        int aux = segundos % 86400;     //Utilizamos variable auxiliar para almacenar el resto de segundos 
        int horas = aux / 3600;         // Una hora tiene 3600 segundos
        aux %= 3600;                    //Actualizamos valor de segundos restantes
        int minutos = aux / 60;         //Un minuto tiene 60 segundos
        aux %= 60;                      //Actualizamos valor de segundos restantes
        
        System.out.println(dias + " dias, " + horas + " horas, " + minutos +" minutos, " + aux + " segundos\n"); //Impresion por pantalla del resultado
        
        if (dias == 0) {
            System.out.println("No hay ningun día");
        }
        
        if (horas == 0) {
            System.out.println("No hay ninguna hora");
        }
        
        if (minutos == 0) {
            System.out.println("No hay ningun minuto");          
        }
        
        if (aux == 0) {
            System.out.println("No hay ningun segundo");           
        }
    }   
}
