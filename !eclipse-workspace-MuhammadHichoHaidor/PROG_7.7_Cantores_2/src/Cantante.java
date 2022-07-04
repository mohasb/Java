
public class Cantante extends Persona implements PuedeCantar
{
    @Override
    public void cantar() {
        System.out.println("El cantante canta: Do, Re, Mi, Fa, Sol, La, Si, Do");
    }
    @Override
    String alimentacion() {
        return "comida cocinada";
    }
    @Override
    public String toString() {
        String caracteristicas = "Nombre: ".concat(this.getNombre()) + "\nSe alimenta de: ".concat(this.alimentacion()) +
                                    "\nTiene: ".concat(String.valueOf(super.getEdad())).concat(" años") + "\nLa clase a la que pertenece es: ".concat(String.valueOf(this.getClass()));
        return caracteristicas;
    }
}
