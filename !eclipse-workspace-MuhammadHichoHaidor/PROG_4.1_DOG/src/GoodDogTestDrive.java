

public class GoodDogTestDrive
{
    public static void main(String[] args) {
       GoodDog one = new GoodDog();
       one.setSize(70);
       GoodDog two = new GoodDog();
       two.setSize(8);
       //Esta línea si devolvera el valor de 'size' por que se ha establecido 3 lineas mas arriba
       System.out.println("Dog one: " + one.getSize());
       //Esta tambien retorna el valor establecido 2 lineas mas arriba
       System.out.println("Dog two: " + two.getSize());
       //La llamada al método se ejecuta correctamente por que se ha establecido el valor de 'size' anteriormente
       one.bark();
       two.bark();
    }
}
