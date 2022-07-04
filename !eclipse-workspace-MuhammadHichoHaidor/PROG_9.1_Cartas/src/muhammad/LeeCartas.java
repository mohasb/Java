package muhammad;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class LeeCartas {



    public static void main(String[] args) {
        //Variables
        Scanner teclado = new Scanner(System.in);
        String linea;
        ArrayList<Carta> cartasArrayList = new ArrayList<>();
        //Comprobar si se ha introducido sólo un parámetro
        if (args.length != 1) {
            System.out.println("Error falta parámetro del main");
            teclado.close();
            return;
        }
    	



        try {
            FileReader fis = new FileReader(args[0]);
            BufferedReader br = new BufferedReader(fis);

            //Rellenar ArrayList
            linea = br.readLine();
            while (linea != null) {
                String[] partes = linea.split("#");
                Carta c = new Carta(partes[0], partes[1]);
                cartasArrayList.add(c);
                linea = br.readLine();
            }
            //Mostrar ArrayList
            for (Carta ca : cartasArrayList) {
                System.out.println(ca.getPregunta());
                String respuesta = teclado.next();
                if (respuesta.equalsIgnoreCase(ca.getRespuesta())) {
                    System.out.println("!Correcto!");
                }else {
                    System.out.println("Has fallado");
                }
                br.close();
            }
        }catch (Exception ex) {
            ex.printStackTrace();
        }
        teclado.close();
    }
}

