
public class Coche {
	//Variables para combobox
	final static String[] cbBoxMarca = {"Volkswagen", "Audi", "Mercedes"};
	final static String[] cbBoxModeloVW = {"Golf", "California", "Polo"};
	final static String[] cbBoxModeloAD = {"A1", "A3", "A5"};
	final static String[] cbBoxModeloMD = {"Clase C", "Clase E", "Clase GLC"};
	final static String[] cboxVacio = {""};

	final static String[] cbBoxColor = {"Rojo", "Negro", "Amarillo", "Naranja", "Azul", "Verde"};;
	//Variables control del parque
	static int numCoches;
	static final int MAX_COCHES = 5;
	//Variables para Coches
	private String matricula;
	private String marca;
	private String modelo;
	private String color;

	//Contructor
	public Coche(String matricula, String marca, String modelo, String color) {
		super();
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
        Coche.numCoches++;
	}
	//Setter Getters
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getNumCoches() {
		return numCoches;
	}

	@Override
	public String toString() {
		return matricula + " " + marca + " " + " " + modelo + " " + color;
	}
	
	
	//Matricula aleatoria
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
        return matricula += "-" + letras;
    }
}
