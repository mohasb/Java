
import java.io.Serializable;

public class Carta implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String pregunta;
    private String respuesta;

    public Carta(String pregunta, String respuesta) {
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    public String getPregunta() {
        return pregunta;
    }
    public String getRespuesta() {
        return respuesta;
    }

    @Override
    public String toString() {
        return pregunta + "#" + respuesta;
    }
}
