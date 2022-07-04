
/**
 * VARIABLES
suma, i, j: ENTERO 
COMIENZO 
PARA i <- 1 HASTA 4  INC +1
PARA j <- 3 HASTA 0 INC -1 
suma <- i*10+j 
escribir (suma)
FIN PARA 
FIN PARA
FIN
 */
public class Ejercicio1_9
{
    public static void main(String[] args)
    {
        int i,j,suma;
        //int suma=0;
        for( i=1;i<4;i++)
        {
            for (j=3;j>0;j--)
            {
                suma=i*10+j;
                System.out.println("Suma : "+suma);
            }
        }
    }
}
