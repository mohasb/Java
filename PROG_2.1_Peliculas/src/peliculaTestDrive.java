
public class peliculaTestDrive
{
   public static void main(String[] args) {
       pelicula uno = new pelicula();
       uno.titulo = "Blancanieves y los siete enanitos";
       uno.genero = "infantil";
       uno.calificacion = -2;
       uno.proyectar();
       
       pelicula dos = new pelicula();
       dos.titulo = "No habrá paz para los malvados";
       dos.genero = "Thriller";
       dos.calificacion = 127;
       dos.proyectar();
       
       pelicula tres = new pelicula();
       tres.titulo = "Bailando bajo la lluvia";
       tres.genero = "musical";
       tres.calificacion = 5;
       tres.proyectar();
   }
}
