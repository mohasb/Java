
public abstract class SerVivo
{
    private String nombre;
    
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getNombre() {return nombre;}
        
    abstract String alimentacion();
}
