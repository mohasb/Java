import java.util.Scanner;
public class Candidato
{
    private String nombre;
    private int dni;
    private int telefono;
    Scanner sc = new Scanner(System.in);
    
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setDni(int dni) {
        this.dni = dni;
    }
    public int getDni() {
        return dni;
    }
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    public int getTelefono() {
        return telefono;
    }
    
    public static String resultado(int puntuacion) {
        String resultado = "";
        
        if (puntuacion < 120) {
            resultado = "No se expide ningún certificado";
        }else if (puntuacion >= 120 && puntuacion <= 139) {
            resultado = "Se expide certificado A2";
        }else if (puntuacion >= 140 && puntuacion <= 152) {
            resultado = "Se expide certificado B1";
        }else if (puntuacion >= 153 && puntuacion <= 159) {
            resultado = "Se expide certificado B1 (con Méritos)";
        }else if (puntuacion >= 160 && puntuacion <= 170) {
            resultado = "Se expide certificado B1 (con Distinción)";
        }

        return resultado;
    }
    public void obtenDatos() {
        System.out.println("Nombre");
        nombre = sc.next();
        System.out.println("Dni");
        dni = sc.nextInt();
        System.out.println("Telefono");
        telefono = sc.nextInt();
    }
}
