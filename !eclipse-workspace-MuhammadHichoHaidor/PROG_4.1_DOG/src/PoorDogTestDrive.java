
public class PoorDogTestDrive
{
     public static void main(String[] args) {
        PoorDog one  = new PoorDog();
        /*El programa si compila pero como no se ha inicializado la variable
        ni se ha usado los metodos set para inicializarlos devuelve los valores 0 y null */
        System.out.println("Dog size is " + one.getSize());
        System.out.println("Dog name is " + one.getName());
     }
}
