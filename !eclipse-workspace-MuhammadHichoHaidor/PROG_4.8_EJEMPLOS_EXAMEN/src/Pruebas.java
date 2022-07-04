
public class Pruebas
{
  public static void main(String[] args) {
      String[] colores = new String[5];
      colores[0] = new String("azul");
      colores[1] = "verde";
      colores[2] = new String("amarillo");
      colores[3] = "negro";
      colores[4] = "blanco";
      int i = 0;
      while (i < colores.length) {
          char letra = colores[i].charAt(1);
            System.out.println("Letra" + i + letra);
            i++;
        }
  }
}
