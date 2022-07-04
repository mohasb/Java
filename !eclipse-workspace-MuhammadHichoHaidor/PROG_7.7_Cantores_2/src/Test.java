
public class Test
{
    public static void main(String[] ags) {
        //Creaci�n de tres inst�ncias de los tres seres
        Cantante cant = new Cantante();
        Canario cana = new Canario();
        Gallo ga = new Gallo();
        //Ajustar valores a los del ejercicio
        cant.setNombre("Carreras");
        cant.setEdad(66);
        cana.setNombre("Piol�n");
        cana.setPeso(15.5);
        cana.setNumPatas(2);
        ga.setNombre("Claudio");
        ga.setColor("Blanco");
        ga.setNumPatas(2);
        //Impresion de la sobrescritura del m�todo toString()
        System.out.println(cant);
        System.out.println(cana);
        System.out.println(ga);
        //Demostraci�n del canto de cada ser
        cant.cantar();
        cana.cantar();
        ga.cantar();
    }
}
