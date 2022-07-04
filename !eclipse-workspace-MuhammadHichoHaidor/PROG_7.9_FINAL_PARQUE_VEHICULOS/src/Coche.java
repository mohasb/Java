public class Coche extends Vehiculo implements PuedeCircular
{
    //Variables
    private int numAirbags;
    private boolean techoSolar;
    private boolean tieneRadio;
    //Constructor sin parámetros
    public Coche() {
        super();
    }
    //Constructor con parámetros
    public Coche(String marca, String modelo, String color, double kilometros, int numPuertas, int numPlazas,int numAirbags, boolean techoSolar, boolean tieneRadio) {
        super(marca, modelo, color,  kilometros,  numPuertas,  numPlazas);
        this.numAirbags = numAirbags;
        this.techoSolar = techoSolar;
        this.tieneRadio = tieneRadio;
    }
    //Setters y getters
    public void setNumAirbags(int numAirbags) {this.numAirbags = numAirbags;}
    public int getNumAirbags() {return numAirbags;}
    public void setTechoSolar(boolean techoSolar) {this.techoSolar = techoSolar;}
    public boolean getTechoSolar() {return techoSolar;}
    public void setTieneRadio(boolean tieneRadio) {this.tieneRadio = tieneRadio;}
    public boolean getTieneRadio() {return tieneRadio;}
    //Demás métodos
    @Override
    public String toString() {
        return super.toString() + "\nNúmero de Airbags: " + getNumAirbags() + "\nTecho Solar: " + (getTechoSolar() ? "Si" : "No") + "\nTiene radio: " + (getTieneRadio() ? "Si" : "No");
    }
    @Override
    public String arrancar() {
        return "Se arranca el coche";
    }
    @Override
    public String acelerar() {
        return "Se acelera el coche";
    }
    @Override
    public String frenar() {
        return "Se frena el coche";
    }
    @Override
    public String circular() {
        return "Esto es un coche y los coches puede circular por carreteras, autovías y autopistas";
    }
    //Métodos propios de Coche
    public String tunear(String color) {
        this.setKilometros(0.0d);
        this.setTechoSolar(true);
        this.setColor(color);
        return "El coche se ha tuneado poniendo el kilometraje a 0, instalar techo solar y cambiar el color a: " + color;
    }
    public String aparcar() {
        return "El coche está aparcando";
    }
}
