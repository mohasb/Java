
public class Profesor extends Persona implements Calificar
{
    void existir() {
        System.out.println("El profesor existe");
    }
    
    public void calificar() {
        System.out.println("El profesor califica un alumno");
    }
}
