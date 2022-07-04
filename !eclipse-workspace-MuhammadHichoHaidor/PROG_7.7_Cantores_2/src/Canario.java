
public class Canario extends Animal implements PuedeCantar
{
    private double peso;
    
    public void setPeso(double peso) {this.peso = peso;}
    public double getPeso() {return peso;}
    
    @Override
    public void cantar() {
        System.out.println("El canario canta: Pioo-Piooo");
    }
    @Override
    String alimentacion() {
        return "alpiste";
    }
    @Override
    public String toString() {
        String caracteristicas = "\nNombre: ".concat(this.getNombre()) + "\nTiene ".concat(String.valueOf(super.getnumPatas())).concat(" patas")+
                                    "\nSu peso es: ".concat(String.valueOf(this.getPeso())) + " Kg"  + "\nSe alimenta de: ".concat(this.alimentacion()) + "\nLa clase a la que pertenece es: " + String.valueOf(this.getClass());
        return caracteristicas;
    }
}
