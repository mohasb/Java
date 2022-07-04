
public class Alumno extends Persona implements Estudiar
{
    void existir() {
        System.out.println("El alumno existe");
    }
    public void estudiar() {
        System.out.println("El alumno estudia");
    }
}
