public class Motocicleta extends Vehiculo implements PuedeCircular
{
    //Variables
    private double potenciaMotor;
    private boolean tieneMaletero;
    //Constructor sin parámetros
    public Motocicleta() {
        super();
    }
    public Motocicleta(String marca, String modelo, String color, double kilometros, int numPuertas, int numPlazas, double potenciaMotor, boolean tieneMaletero) {
        super(marca, modelo, color, kilometros, numPuertas, numPlazas);
        this.potenciaMotor = potenciaMotor;
        this.tieneMaletero = tieneMaletero;
    }
    //Setters y getters
    public void setPotenciaMotor(double potenciaMotor) {this.potenciaMotor = potenciaMotor;}
    public double getPotenciaMotor() {return potenciaMotor;}
    public void setTieneMaletero(boolean tieneMaletero) {this.tieneMaletero = tieneMaletero;}
    public boolean getTieneMaletero() {return tieneMaletero;}
    //Demás métodos
    @Override
    public String toString() {
        return super.toString() + "\nPotencia de Motor: " + getPotenciaMotor() + "\nTiene maletero: " + (getTieneMaletero() ? "Si" : "No");
    }
    @Override
    public String arrancar() {
        return "Se arranca la motocicleta";
    }
    @Override
    public String acelerar() {
        return "Se acelera la motocicleta";
    }
    @Override
    public String frenar() {
        return "Se frena la motocicleta";
    }
    @Override
    public String circular() {
        return "Esto es una moto y una moto puede circular por carreteras, autovías y autopistas";
    }
    //Métodos propios de Motocicleta
    public String brincar() {
        return "La motocicleta está brincando";
    }
    public String aparcar() {
        return "La motocicleta está aparcando";
    }
}
