
/**
 Realiza un aplicación Java que muestre por pantalla los días, horas, 
 minutos y segundos que hay en 8432100 segundos.
Utiliza la estructura de bifurcación if/else para para 
indicar por pantalla que hay "ningún minuto o ningún segundo, etc."

(la solución es: 97 días, 14 horas, 15 minutos  y 0 segundos)

17/09/2019*/
public class Ejercicio1_4
{
    
    public static void main(String []args){ 
        final int SEG=8432100;
        int auxSeg,auxMin,auxHora,auxDia,auxMes,auxAno;
        

            
            auxSeg=SEG%60;
            System.out.println("Segundos: "+auxSeg);
            
            auxMin=SEG/60;
            System.out.println("Minutos: "+auxMin%60);
            
            auxHora=auxMin/60;
            System.out.println("Horas: "+auxHora%24);

            auxDia=auxHora/24;
            System.out.println("Dias: "+auxDia%30);
            
            auxMes=auxDia/30;
            System.out.println("Meses: "+auxMes%12);
            
            auxAno=auxMes/12;
            System.out.println("Años: "+auxAno);

    
    }
    
    
}