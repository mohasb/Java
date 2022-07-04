import java.io.Serializable;

public class Jugador implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int poder;
    private String tipo;
    private String[] armas;

    public Jugador(int p, String t, String[] a) {
        this.poder = p;
        this.tipo = t;
        this.armas = a;
    }

    public int getPoder() {
        return poder;
    }

    public String getTipo() {
        return tipo;
    }

    public String getArmas() {
        String arnasString = "";
        //Recorrer array y crear el String a partir del array
        for (String arma : armas) {
            arnasString += arma + ",";
        }
        //Quitar ultima coma con substring
        return  arnasString.substring(0, arnasString.length() - 1);
    }

    @Override
    public String toString() {
        return "Poder = " + poder +
                ", Tipo = " + tipo +
                ", armas = " + getArmas();
    }
}
