
public class Persona  {
    //Variables persona
    private String nombre;
    private String dni;
    //Variables calculaNIF
    private String letras;
    private int resto;
    private char letraNif;

    //Constructor
    public Persona(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    //Setters y Getters Persona
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDni() {
        return dni;
    }
    public void setDni(String dni) {
        this.dni = dni;
    }

    //Setters y Getters calculaNif()
    public String getLetras() {
        return letras;
    }
    public void setLetras(String letras) {
        this.letras = letras;
    }
    public int getResto() {
        return resto;
    }
    public void setResto(int resto) {
        this.resto = resto;
    }
    public char getLetraNif() {
        return letraNif;
    }
    public void setLetraNif(char letraNif) {
        this.letraNif = letraNif;
    }

    //Método que calcula el NIF
    private String calculaNIF() {
        letras = "TRWAGMYFPDXBNJZSQV";
        resto = Integer.parseInt(this.getDni())%23;
        letraNif = letras.charAt(resto);
        return this.getDni() + letraNif;
    }
    //Método sobreescrito para mostrar los detalles
    @Override
    public String toString() {
        return "El NIF de " + this.getNombre() + " es: " + this.calculaNIF();
    }
}
