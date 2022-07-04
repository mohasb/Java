public class Avioneta extends Vehiculo implements PuedeVolar, PuedeCircular
{
    //Variables
    private String aeropuerto;
    private double maxKg;
    
    //Constructor sin parámetros
    public Avioneta() {
        super();
    }
    //Constructor con parámetros
    public Avioneta(String marca, String modelo, String color, double kilometros, int numPuertas, int numPlazas, String aeropuerto, double maxKg) {
        super(marca, modelo, color, kilometros, numPuertas, numPlazas);
        this.aeropuerto = aeropuerto;
        this.maxKg = maxKg;
    }
    //Setters y getters
    public void setAeropuerto(String aeropuerto) {this.aeropuerto = aeropuerto;}
    public String getAeropuerto() {return aeropuerto;}
    public void setMaxKg(double maxKg) {this.maxKg = maxKg;}
    public double getMaxKg() {return maxKg;}
    //Demás métodos
    @Override
    public String toString() {
        return super.toString() + "\nAeropuerto: " + getAeropuerto() + "\nCarga Máxima: " + getMaxKg() + " Kg";
    }
    @Override
    public String arrancar() {
        return "La avioneta puede arrancar";
    }
    @Override
    public String acelerar() {
        return "La avioneta puede acelerar";
    }
    @Override
    public String frenar() {
        return "La avioneta puede frenar";
    }
    @Override
    public String circular() {
        return "Esto es una avioneta y las avionetas sólo pueden circular dentro de los aeropuertos";
    }
    @Override
    public String volar() {
        return "Esto es una avioneta y las avionetas pueden volar por el aire";
    }
    //Métodos propios de Avioneta
    public String despegar() {
        return "La avioneta puede despegar";
    }
    public String aterrizar() {
        return "La avioneta puede aterrizar";
    }
}
