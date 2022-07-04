
public class Persona {
    private String nombre;
    private int edad;
    private double peso;
    private double estatura;
    private double IMC;
    private String provincia;
    private String sexo;
    private boolean dieta;
    private String estado;


    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public double getEstatura() {
        return estatura;
    }
    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }
    public double getIMC() {
		return IMC;
	}
	public void setIMC(double iMC) {
		IMC = iMC;
	}
    public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public boolean isDieta() {
		return dieta;
	}
	public void setDieta(boolean dieta) {
		this.dieta = dieta;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	
	
	
	
	public Persona(String nombre, String provincia,  int edad, double peso, double estatura, String sexo, boolean dieta) {
        this.nombre = nombre;
        this.provincia = provincia;
        this.edad = edad;
        this.peso = peso;
        this.estatura = estatura;
        this.sexo = sexo;
        this.dieta = dieta;
        IMC = calculaIMC(peso, estatura);
        estado = calculaEstado(IMC);
    }
	
	double calculaIMC(double peso, double estatura) {
		
		return peso / Math.pow(estatura, 2);
	}
	
	String calculaEstado(double imc) {
        if (IMC <= 16) {
            estado = "Desnutrici�n grado 3";
        }else if (IMC > 16 && IMC <= 17 ) {
            estado = "Desnutrici�n grado 2";
        }else if (IMC > 17 && IMC <= 18.5 ) {
            estado = "Desnutrici�n grado 1";
        }else if (IMC > 18.5 && IMC <= 25 ) {
            estado = "Normal";
        }else if (IMC > 25 && IMC <= 30 ) {
            estado = "Sobrepeso grado 1";
        }else if (IMC > 30 && IMC <= 40 ) {
            estado = "Sobrepeso grado 2";
        }else if (IMC > 40) {
            estado = "Sobrepeso grado 3";
        }
        return estado;
	}
    @Override
    public String toString() {
    	String texto;
    	texto = "Paciente:\n" + "Nombre: " + this.getNombre() + "\nProvincia: "+ getProvincia() +  "\nEdad: " + getEdad() + "\tSexo: " + (getSexo() == null ? "No especificado" : getSexo()) + "\nPeso: " + getPeso() +
    			"\tDieta: " + (isDieta() ? "Ha hecho dieta alguna vez" : "No ha hecho dieta") + "\nEstatura: " + getEstatura() + "\tIMC: " + String.format("2%f", getIMC())  + "\nEstado: " + getEstado();
    	return texto;
    }
	  
}
