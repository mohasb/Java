public class Yate extends Vehiculo implements PuedeNavegar
{
    //Variables
    private boolean tieneCocina;
    private int numMotores;
    private double metrosEslora;
    //Constructor sin Parámetros
    public Yate() {
        super();
    }
    public Yate(String marca, String modelo, String color, double kilometros, int numPuertas, int numPlazas,boolean tieneCocina, int numMotores, double metrosEslora) {
        super(marca, modelo, color, kilometros, numPuertas, numPlazas);
        this.tieneCocina = tieneCocina;
        this.numMotores = numMotores;
        this.metrosEslora = metrosEslora;
    }

    //Setters y getters
    public void setTieneCocina(boolean tieneCocina) {this.tieneCocina = tieneCocina;}
    public boolean getTieneCocina() {return tieneCocina;}
    public void setNumMotores(int numMotores) {this.numMotores = numMotores;}
    public int getNumMotores() {return numMotores;}
    public void setMetrosEslora(double metrosEslora) {this.metrosEslora = metrosEslora;}
    public double getMetrosEslora() {return metrosEslora;}
    
    //Demás métodos
    @Override
    public String toString() {
        return super.toString() + "\nTiene cocina: " + (getTieneCocina() ? "Si" : "No") + "\nNúmero de Motores: " + getNumMotores() + "\nMetros de eslora: " + getMetrosEslora();
    }
    @Override
    public String arrancar() {
        return "El Yate puede arrancar";
    }
    @Override
    public String acelerar() {
        return "El Yate puede acelerar";
    }
    @Override
    public String frenar() {
        return "El Yate puede frenar";
    }
    @Override
    public String navegar() {
        return "Esto es un Yate y los Yates pueden navegar por el agua";
    }
    //Métodos propios de Yate
    public String zarpar() {
        return "El Yate puede zarpar";
    }
    public String atracar() {
        return "El Yate puede atracar";
    }
}
