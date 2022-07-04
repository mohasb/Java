import javax.swing.JOptionPane;
public class Coche
{
    //Atributos de instáncia
    private String matricula ="";
    private String marca = "Seat";
    private String modelo = "Altea";
    private String color = "Blanco";
    private boolean techoSolar = false;
    private double kilometros = 0.0d;
    private int numPuertas = 3;
    private int numPlazas = 5;
    //Variables estáticas que son comunes a todos los Coches
    //Si la pongo privada no puedo acceder a un método no estático(getNumCoches) desde uno estático(main)
    static int numCoches = 0;
    //He probado a ponerla privada y al intentar acceder a ella con el getter y es como si no existiera
    static final int MAX_COCHES = 5;
    //Constructores  
    public Coche() {
        this.matricula = Coche.matAleatoria();
        Coche.numCoches++;
    }
    public Coche(String matricula) {
        matricular(matricula);
        Coche.numCoches++;
    }
    public Coche(int numPuertas, int numPlazas) {
        this.numPuertas = numPuertas;
        this.numPlazas = numPlazas;
        Coche.numCoches++;
    }
    public Coche(String marca, String modelo, String color) {
        matricular(matricula);
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        Coche.numCoches++;
    }
    //Setters y getters
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getMarca() {
        return marca;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public String getModelo() {
        return modelo;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getColor() {
        return color;
    }
    public void setTechoSolar(boolean techoSolar) {
        this.techoSolar = techoSolar;
    }
    public boolean getTechoSolar() {
        return techoSolar;
    }
    public void setKilometros(double kilometros) {
        if (kilometros < 0) {
            JOptionPane.showMessageDialog(null, "Los kilometros no pueden ser menores que 0", "Fabrica coches Java", JOptionPane.INFORMATION_MESSAGE);
        }else {
            this.kilometros = kilometros;
        }
    }
    public double getKilometros() {
        return kilometros;
    }
    public void setNumPuertas(int numPuertas) {
        if (numPuertas < 0 ||  numPuertas > 5) {
            JOptionPane.showMessageDialog(null, "EL numero de puertas no puede ser  menor a 0 ó superior a 5", "Fabrica coches Java", JOptionPane.INFORMATION_MESSAGE);
        }else {
            this.numPuertas = numPuertas;
        }
    }
    public int getNumPuertas() {
        return numPuertas;
    }
    public void setNumPlazas(int numPlazas) {
        if (numPlazas < 0 || numPlazas > 7) {
            JOptionPane.showMessageDialog(null, "EL numero de plazas no puede ser  menor a 0 ó superior a 7", "Fabrica coches Java", JOptionPane.INFORMATION_MESSAGE);
        }else {
            this.numPlazas = numPlazas;
        }
    }
    public int getNumPlazas() {
        return numPlazas;
    }
    //Métodos
    public void avanzar(double kilometros) {
        if (kilometros > 0) {
            setKilometros(getKilometros() + kilometros);
        }else {
            JOptionPane.showMessageDialog(null, "Debe introducir un valor positivo para poder avanzar", "Fabrica coches Java", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void tunear() {
        this.kilometros = 0;
        this.techoSolar = true;
    }
    public void tunear(String color) {
        setColor(color);
        this.kilometros = 0;
        this.techoSolar = true;
    }
    public void matricular(String matricula) {
        setMatricula(matricula);
    }
    //Matricula aleatória
    public static String matAleatoria() {
        String matricula = "";
        String numeroAleatorio = "";
        for (int i = 0; i < 5; i++) {
            numeroAleatorio = String.valueOf((int)(Math.random() * (9 - 0)) + 0);
            
            matricula += numeroAleatorio;
        }
        return matricula;
    }
}
