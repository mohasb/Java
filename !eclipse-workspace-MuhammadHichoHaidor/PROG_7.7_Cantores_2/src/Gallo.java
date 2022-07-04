
public class Gallo extends Animal implements PuedeCantar
{
    private String color;
    
    public void setColor(String color) {this.color = color;}
    public String getColor() {return color;}
    
    @Override
    public void cantar() {
        System.out.println("El gallo canta: Ki-ki-ri-kiiii");
    }
    @Override
    String alimentacion() {
        return "pienso";
    }
    @Override
    public String toString() {
        String caracteristicas = "\nNombre: ".concat(this.getNombre()) + "\nTiene ".concat(String.valueOf(super.getnumPatas())).concat(" patas")+
                                    "\nSu color es: ".concat(this.getColor()) + "\nSe alimenta de: ".concat(this.alimentacion()) + "\nLa clase a la que pertenece es: " + String.valueOf(this.getClass()) + "\n";
        return caracteristicas;
    }
    
}
