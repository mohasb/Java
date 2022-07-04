public class Autobus extends Vehiculo implements PuedeCircular
{
    //Variables
    private String tipoRecorrido;
    private boolean esEscolar;
    //Constructor sin parámatros
    public Autobus() {
        super();
    }
    public Autobus(String marca, String modelo, String color, double kilometros, int numPuertas, int numPlazas, String tipoRecorrido, boolean esEscolar) {
        super(marca, modelo, color, kilometros, numPuertas, numPlazas);
        this.tipoRecorrido = tipoRecorrido;
        this.esEscolar = esEscolar;
    }
    //Setters y getters
    public void setTipoRecorrido(String tipoRecorrido) {this.tipoRecorrido = tipoRecorrido;}
    public String getTipoRecorrido() {return tipoRecorrido;}
    public void setEsEscolar(boolean esEscolar) {this.esEscolar = esEscolar;}
    public boolean getEscolar() {return esEscolar;}
    //Demás métodos
    @Override
    public String toString() {
        return super.toString() + "\nTipo de recorrido: " + getTipoRecorrido() + "\nEs escolar: " + (getEscolar() ? "Si" : "No");
    }
    @Override
    public String arrancar() {
        return "Se arranca el autobús";
    }
    @Override
    public String acelerar() {
        return "Se acelera el autobús";
    }
    @Override
    public String frenar() {
        return "Se frena el autobús";
    }
    @Override
    public String circular() {
        return "Esto es un autobús y un autobús puede circular por carreteras, autovías y autopistas";
    }
    //Métodos propios de autobús
    public String abrirPuertas() {
        return "Se abren las puertas del autobús";
    }
    public String aparcar() {
        return "El autobús está aparcando";
    }
}
