
/**
* Estructuras de bifurcación anidadas:
*Realiza un aplicación Java que:
*Pida el numero de notas de alumnos a añadir.
*Que seguidamente se le pida al usuario las x notas.
*el usuario obtendrá por consola el numero de aprobados el numero de "suspendidos" 
*y de estos suspendidos los que tenga de 4 a 4,9 serán "condicionados"
*Que me solicite la opción de finalizar o introducir un nuevo conjunto de notas.
*/
import java.util.Scanner;
public class Ejercicio1_8
{
    public static void main(String[] args)
    {
        Scanner tec = new Scanner(System.in);
        double []notas;
        int num;
        double nota;
        int apro=0;
        int sus=0;
        char rep, aux;
        
        do
        {
            System.out.println("Cuantas notas de alumnos quieres introducir?");
            num=tec.nextInt();
            notas = new double[num];
            int alum =1;
        
            for(int i=0;i<notas.length;i++)
            {
                System.out.println("Introduce la nota del alumno numero: "+alum);
                nota=tec.nextDouble();
                notas[i]=nota;
                alum++;
            }
            alum =1;
            for(int j=0;j<notas.length;j++)
            {   
                
                if(notas[j]>=5)
                {
                    apro++;
                }else if(notas[j]>=4&&notas[j]<5)
                {
                    System.out.println("Quires aprobar al alumno "+alum+"? y/n");
                    rep=tec.next().charAt(0);
                    if(rep=='y'||rep=='Y')
                    {
                        apro++;
                    }else
                    {
                        sus++;
                    }
                }else
                {
                    sus++;
                }
                alum++;
            }
                System.out.println("Hay "+apro+" alumnos aprobados.");
                System.out.println("Hay "+sus+" alumnos suspendidos."); 
        
                System.out.println("Quieres volver a introducir alumnos? s/n");
                aux=tec.next().charAt(0);
            }while(aux=='s'||aux=='S');
            System.out.println("Adios");
            tec.close();

    }

}
