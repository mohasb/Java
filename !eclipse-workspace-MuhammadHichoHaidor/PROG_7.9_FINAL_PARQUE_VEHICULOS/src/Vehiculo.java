import javax.swing.JOptionPane;
public abstract class Vehiculo
{
    //Variables de instancia
    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private double kilometros;
    private int numPuertas;
    private int numPlazas;
    static int numVehiculos = 0;
    static final int MAX_VEHICULOS = 5;
    //Constructor sin parámetros
    public Vehiculo() {
        this.matricula = matAleatoria();
        this.marca = "";
        this.modelo = "";
        this.color = "blanco";
        this.kilometros = 0.0d;
        this.numPuertas = 0;
        this.numPlazas = 0;
        numVehiculos++;}
    //Constructor con parámetros
    public Vehiculo(String marca, String modelo, String color, double kilometros, int numPuertas, int numPlazas) {
        this.matricula = matAleatoria();
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.kilometros = kilometros;
        this.numPuertas = numPuertas;
        this.numPlazas = numPlazas;
        numVehiculos++;
    }
    //Setters y getters
    public String getMatricula() {return matricula;}
    public void setMarca(String marca) {this.marca = marca;}
    public String getMarca() {return marca;}
    public void setModelo(String modelo) {this.modelo = modelo;}
    public String getModelo() {return modelo;}
    public void setColor(String color) {this.color = color;}
    public String getColor() {return color;}
    public void setKilometros(double kilometros) {
        if (kilometros < 0) {
            JOptionPane.showMessageDialog(null, "Los kilometros no pueden ser menores que 0", "Fabrica coches Java", JOptionPane.INFORMATION_MESSAGE);
        }else {
            this.kilometros = kilometros;
        }
    }
    public double getKilometros() {return kilometros;}
    public void setNumPuertas(int numPuertas) {
        if (numPuertas < 0) {
            JOptionPane.showMessageDialog(null, "EL numero de puertas no puede ser  menor a 0 ó superior a 5", "Fabrica coches Java", JOptionPane.INFORMATION_MESSAGE);
        }else {
            this.numPuertas = numPuertas;
        }
    }
    public int getNumPuertas() {return numPuertas;}
    public void setNumPlazas(int numPlazas) {
        if (numPlazas < 0) {
            JOptionPane.showMessageDialog(null, "EL numero de plazas no puede ser  menor a 0 ó superior a 7", "Fabrica coches Java", JOptionPane.INFORMATION_MESSAGE);
        }else {
            this.numPlazas = numPlazas;
        }
    }
    public int getNumPlazas() {return numPlazas;}
    //Demas métodos
    abstract String arrancar();
    abstract String acelerar();
    abstract String frenar();
    @Override
    public String toString() {
        
        String cracteristicas = "Matricula: " + getMatricula() + "\nMarca: " + getMarca()
                                + "\nModelo: " + getModelo() + "\nColor: " + getColor()
                                + "\nKilómetros: " + getKilometros() + "\nNúmero de puertas: " + getNumPuertas()
                                + "\nNúmero de plazas: " + getNumPlazas();
        return cracteristicas;
    }
    //Matricula aleatória
    public static String matAleatoria() {
        String matricula = "";
        String numeroAleatorio = "";
        String letras = "";
        for (int i = 0; i < 4; i++) {
            numeroAleatorio = String.valueOf((int)(Math.random() * (9 - 0)) + 0);
            matricula += numeroAleatorio;
        }
        for (int i = 0; i < 3; i++) {
            char letra = (char) (Math.random() * (90 - 65) + 65);
            letras += letra;
        } 
        return matricula += letras;
    }
}
