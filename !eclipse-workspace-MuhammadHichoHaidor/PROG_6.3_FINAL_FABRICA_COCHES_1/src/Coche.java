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
    //Constructores
    public Coche() {
        
    }
    public Coche(String matricula) {
        matricular(matricula);
    }
    public Coche(int numPuertas, int numPlazas) {
        this.numPuertas = numPuertas;
        this.numPlazas = numPlazas;
    }
    public Coche(String marca, String modelo, String color) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
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
            JOptionPane.showMessageDialog(null, "Los kilometros no pueden ser menores que 0", "Fábrica coches Java", JOptionPane.INFORMATION_MESSAGE);
        }else {
            this.kilometros = kilometros;
        }
    }
    public double getKilometros() {
        return kilometros;
    }
    public void setNumPuertas(int numPuertas) {
        if (numPuertas < 0 ||  numPuertas > 5) {
            JOptionPane.showMessageDialog(null, "EL numero de puertas no puede ser  menor a 0 ó superior a 5", "Fábrica coches Java", JOptionPane.INFORMATION_MESSAGE);
        }else {
            this.numPuertas = numPuertas;
        }
    }
    public int getNumPuertas() {
        return numPuertas;
    }
    public void setNumPlazas(int numPlazas) {
        if (numPlazas < 0 || numPlazas > 7) {
            JOptionPane.showMessageDialog(null, "EL numero de plazas no puede ser  menor a 0 ó superior a 7", "Fábrica coches Java", JOptionPane.INFORMATION_MESSAGE);
        }else {
            this.numPlazas = numPlazas;
        }
    }
    public int getNumPlazas() {
        return numPlazas;
    }
    //Métodos
    public void avanzar(double kilometros) {
        setKilometros(getKilometros() + kilometros);
        JOptionPane.showMessageDialog(null,"El mecánico ha probado el coche con matrícula: " + matricula + "\nAhora el coche tiene: " + kilometros + "KM", "Fábrica coches Java", JOptionPane.INFORMATION_MESSAGE);
    }
    public void tunear() {
        this.kilometros = 0;
        techoSolar = true;
        JOptionPane.showMessageDialog(null, "Se ha tuneado el coche con matrícula: " + matricula + "\nAhora tiene 0 KM y techo solar", "Fábrica coches Java", JOptionPane.INFORMATION_MESSAGE);
    }
    public void tunear(String color) {
        setColor(color);
        this.kilometros = 0;
        this.techoSolar = true;
        JOptionPane.showMessageDialog(null, "Se ha tuneado el coche con matrícula: " + matricula + "\nAhora tiene 0 KM, techo solar y se ha puesto el color: " + color , "Fábrica coches Java", JOptionPane.INFORMATION_MESSAGE);
    }
    public void matricular(String matricula) {
        setMatricula(matricula);
        JOptionPane.showMessageDialog(null,"Se ha matriculado el coche con matrícula: " + matricula , "Fábrica coches Java", JOptionPane.INFORMATION_MESSAGE);
    }
}
