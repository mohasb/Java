import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Juego {

    public static void main(String[] args) {
        //Crear Jugadores
        Jugador jugador1 = new Jugador(50, "Elfo", new String[]{"arco", "espada", "polvo"});
        Jugador jugador2 = new Jugador(200, "Troll", new String[]{"garras", "brazos gigantes"});
        Jugador jugador3 = new Jugador(120, "Mago", new String[]{"hechizos", "invisibilidad"});

        //Mostrar características antes serializacion
        System.out.println();
        System.out.println("Jugadores antes de la serializacion");
        System.out.println("Jugador 1: \n" + jugador1);
        System.out.println("Jugador 2: \n" + jugador2);
        System.out.println("Jugador 3: \n" + jugador3);

        //Serializar
        try {
            FileOutputStream fs = new FileOutputStream("Jugador.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(jugador1);
            os.writeObject(jugador2);
            os.writeObject(jugador3);
            os.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
         //Desserializar
        try {
            FileInputStream fis = new FileInputStream("jugador.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object copiaJugador1 = ois.readObject();
            Object copiaJugador2 = ois.readObject();
            Object copiaJugador3 = ois.readObject();
            ois.close();
            Jugador elfo = (Jugador) copiaJugador1;
            Jugador troll = (Jugador) copiaJugador2;
            Jugador mago = (Jugador) copiaJugador3;

            //Mostrar características después de serialización
            System.out.println();
            System.out.println("Jugadores despues de la serializacion");
            System.out.println("Jugador 1: \n" + elfo);
            System.out.println("Jugador 2: \n" + troll);
            System.out.println("Jugador 3: \n" + mago);

        }catch (Exception ex) {
            ex.printStackTrace();
        }

    }



}
