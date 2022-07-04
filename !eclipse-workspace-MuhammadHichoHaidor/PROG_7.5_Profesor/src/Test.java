
public class Test
{
    public static void main(String[] args) {
        Profesor p = new Profesor();
        Alumno a = new Alumno();

        p.existir();
        p.calificar();
        
        a.existir();
        a.estudiar();
        
        /*Pruebas
        Persona pp = new Profesor();
        Persona aa = new Alumno();
        Persona pp2 = pp;
        
        System.out.println(pp.getClass());
        System.out.println(aa.getClass());
        if (pp.equals(pp2)) {
            System.out.println("Son iguales");
        }else {
            System.out.println("No son iguales");
        }
        System.out.println(pp.hashCode());
        System.out.println(pp.toString());*/
    }
}
