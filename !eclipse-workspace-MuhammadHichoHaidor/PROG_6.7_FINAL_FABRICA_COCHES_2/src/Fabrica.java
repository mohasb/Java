import javax.swing.JOptionPane;
public class Fabrica
{
    public static void main(String[] args) {
        //Variables
        String respuesta = "";
        //Vector de Coche
        Coche[] arrayCoches = new Coche[Coche.MAX_COCHES];
        //He hecho un método extra menú para que el main sea mas legible
        menu(respuesta, arrayCoches);
    }
    static void menu(String respuesta, Coche[] arrayCoches) {
        try {
            do {
                respuesta = JOptionPane.showInputDialog(null, "1.Fabricar coche(conociéndo la matrícula)\n" + "2.Fabricar cohe(a partir del nº de puertas y el nº de plazas)\n" 
                             + "3.Fabricar coche (a partir de la marca, el modelo y el color)\n" + "4.Fabricar coche(Cuando no tenemos ningun dato)\n"
                             + "5.Tunear coche(pintandolo de un color)\n" + "6.Tunear coche (sin pintarlo)\n" + "7.Avanzar kilómetros\n" 
                             + "8.Mostrar características de un coche\n" + "9.Salir del programa", "Fábrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE);
                //Si al pedir la respuesta se pulsa en cancelar se pasa al 'else'                                             
                if (respuesta != null) {
                    switch (respuesta) {
                    //Constructor en el que se conoce la matrícula
                    case "1": 
                        //Compruebo que cantidad de coches no supere el máximo
                        if (Coche.numCoches < Coche.MAX_COCHES )  {
                            String matricula = JOptionPane.showInputDialog(null, "Introduzca la matricula", "Fábrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE);
                            if (matricula.equals("")) {
                                JOptionPane.showMessageDialog(null, "No has escrito ninguna matricula", "Fábrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE);
                                //Si no se ecribe matrícula se avisa y sale al menú
                                continue;
                            }
                            /*Busco la matricula y si existe retorno 0;Si NO existe retorno -1
                            Lo creo en la posición de numCoches que le corresponda,con la matricula obtenida por teclado, Demas datos por defecto y muestro las caracteristicas segun posicion*/
                            int indice = buscaCoche(arrayCoches, matricula, respuesta);
                            if (indice == 0) {
                                int posicion = Coche.numCoches;
                                arrayCoches[Coche.numCoches] = new Coche(matricula);
                                JOptionPane.showMessageDialog(null, caracteristicas(arrayCoches[posicion]));
                            }else {
                                //Si existe aviso y vuelvo al menú
                                JOptionPane.showMessageDialog(null, "El coche con esta matricula ya está en el garage", "Fábrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE);
                            }
                            break;
                        }else {
                            //Si hay mas de 5 coches aviso y vuelvo a menú
                            JOptionPane.showMessageDialog(null, "Esta el garage lleno", "Fábrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE);
                        }
                    break;
                    case "2":
                        //Compruebo que cantidad de coches no supere el máximo
                        if (Coche.numCoches < Coche.MAX_COCHES) {
                            //Creo matricula aleatoria
                            String matricula = Coche.matAleatoria();
                            int posicion = Coche.numCoches;
                            int numPuertas = 0;
                            int numPlazas = 0;
                            //Recojo los valores conocidos
                            try {
                                numPuertas = Integer.parseInt(JOptionPane.showInputDialog(null, "Cuantas puertas tiene el coche con matrícula: " + matricula, "Fábrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE));
                                if (numPuertas < 0 ||  numPuertas > 5) {
                                    JOptionPane.showMessageDialog(null, "EL numero de puertas no puede ser  menor a 0 ó superior a 5", "Fábrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE);
                                    continue;
                                }
                                numPlazas = Integer.parseInt(JOptionPane.showInputDialog(null, "Cuantas plazas tiene el coche con matrícula: " + matricula, "Fábrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE));
                                if (numPlazas < 0 || numPlazas > 7) {
                                    JOptionPane.showMessageDialog(null, "EL numero de plazas no puede ser  menor a 0 ó superior a 5", "Fábrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE);
                                    continue;
                                }
                                //Si todo va bien creo una instancia de coche con los valores dados y  la matricula aleatoria;Demas datos por defecto
                                arrayCoches[Coche.numCoches] = new Coche(numPuertas, numPlazas);
                                arrayCoches[posicion].matricular(matricula);
                            }catch (NumberFormatException e) {
                                //Si no escribe un valor para numpuertas o numPlazas aviso y salgo al menú
                                JOptionPane.showMessageDialog(null, "Se debe especificar un número de puertas y un numero de plazas", "Fábrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE);
                                continue;
                            }
                            //muestro las caracteristicas segun posicion
                            JOptionPane.showMessageDialog(null, caracteristicas(arrayCoches[posicion]));
                            break;
                        }else {
                            //Si hay mas de 5 coches aviso y vuelvo a menú
                            JOptionPane.showMessageDialog(null, "Esta el garage lleno", "Fábrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE);
                        }
                    break;
                    case "3":
                        //Compruebo que cantidad de coches no supere el máximo
                        if (Coche.numCoches < Coche.MAX_COCHES) {
                            int posicion = Coche.numCoches;
                            String matricula2 = Coche.matAleatoria();
                            String marca = "";
                            String modelo = "";
                            String color = "";
                            //Recocger valores conocidos
                                marca = JOptionPane.showInputDialog(null, "Marca del coche con matrícula: " + matricula2, "Fábrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE);
                                if (marca.equals("")) {
                                    JOptionPane.showMessageDialog(null,"No has escrito ningun valor", "Fábrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE);
                                    continue;
                                }
                                modelo = JOptionPane.showInputDialog(null, "Modelo del coche con matrícula: " + matricula2, "Fábrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE);
                                if (modelo.equals("")) {
                                    JOptionPane.showMessageDialog(null,"No has escrito ningun valor", "Fábrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE);
                                    continue;
                                }
                                color = JOptionPane.showInputDialog(null, "Color del coche con matrícula: " + matricula2, "Fábrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE);
                                if (color.equals("")) {
                                    JOptionPane.showMessageDialog(null,"No has escrito ningun valor", "Fábrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE);
                                    continue;
                                }
                                //Si todo va bien creo una instancia con los datos aportados
                                arrayCoches[Coche.numCoches] = new Coche(marca, modelo, color);
                                arrayCoches[posicion].matricular(matricula2);
                                //muestro las caracteristicas segun posicion
                            JOptionPane.showMessageDialog(null, caracteristicas(arrayCoches[posicion]));
                            break;
                        }else {
                            //Si hay mas de 5 coches aviso y vuelvo a menú
                            JOptionPane.showMessageDialog(null, "Esta el garage lleno", "Fábrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE);
                        }
                    break;
                    case "4":
                        //Compruebo que cantidad de coches no supere el máximo
                        if (Coche.numCoches < Coche.MAX_COCHES) {
                            //Creo un coche en la ultima posicion con los valores por defecto(no se conoce ninguno)
                            int posicion = Coche.numCoches;
                            arrayCoches[Coche.numCoches] = new Coche();
                            JOptionPane.showMessageDialog(null,"Se ha creado un coche con la matricula aleatoria y los valores por defecto", "Fábrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE);
                            //muestro las caracteristicas segun posicion
                            JOptionPane.showMessageDialog(null, caracteristicas(arrayCoches[posicion]));
                            break; 
                        }else {
                            //Si hay mas de 5 coches aviso y vuelvo a menú
                           JOptionPane.showMessageDialog(null, "Esta el garage lleno", "Fábrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE); 
                        }
                    break;
                    case "5":
                        //Compruebo que haya coches en el garage
                        if (Coche.numCoches != 0) {
                            //Creo un String para pode ver las matriculas de los coches que haya creado
                            String titulo = "Coches en el garage:\n";
                            String matriculasCoches = "";
                            for (int i = 0;i< Coche.numCoches;i++) {
                               matriculasCoches += "Coche con matrícula: " + arrayCoches[i].getMatricula() + "\n";
                            }
                            String buscaMatricula = JOptionPane.showInputDialog(null, titulo + matriculasCoches + "\nIntroduzca la matricula", "Fábrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE);
                            if (buscaMatricula.equals("")) {
                                    JOptionPane.showMessageDialog(null, "No has escrito ninguna matricula", "Fábrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE);
                                    continue;
                            }
                            //Busco la matricula y si existe retorno el valor del indice donde se encuentra en del array;Si NO existe retorno -1
                            int indice = buscaCoche(arrayCoches, buscaMatricula, respuesta);
                                if (indice == -1) {
                                    JOptionPane.showMessageDialog(null, "No se encuentra el coche", "Fábrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE);
                                    break;
                                }
                                JOptionPane.showMessageDialog(null, caracteristicas(arrayCoches[indice]), "Fábrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE);
                            break;
                        }else {
                            //Si no hay coches aviso
                            JOptionPane.showMessageDialog(null, "No hay coches en el garage", "Fábrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE);
                        }
                    break;
                    case "6":
                        //Compruebo que haya coches en el garage
                        if (Coche.numCoches != 0) {
                            //Creo un String para pode ver las matriculas de los coches que haya creado
                            String titulo = "Coches en el garage:\n";
                            String matriculasCoches = "";
                            for (int i = 0;i< Coche.numCoches;i++) {
                               matriculasCoches += "Coche con matrícula: " + arrayCoches[i].getMatricula() + "\n";
                            }
                           String buscaMatricula2 = JOptionPane.showInputDialog(null, titulo + matriculasCoches + "\nIntroduzca la matricula", "Fábrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE);
                           if (buscaMatricula2.equals("")) {
                                    JOptionPane.showMessageDialog(null, "No has escrito ninguna matricula", "Fábrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE);
                                    continue;
                            }
                            //Busco la matricula y si existe retorno el valor del indice donde se encuentra en del array;Si NO existe retorno -1
                            int indice2 = buscaCoche(arrayCoches, buscaMatricula2, respuesta);
                            if (indice2 == -1) {
                                JOptionPane.showMessageDialog(null, "No se encuentra el coche", "Fábrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE);
                                break;
                            }
                            JOptionPane.showMessageDialog(null, caracteristicas(arrayCoches[indice2]), "Fábrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE);
                            break; 
                        }else {
                            //Si no hay coches aviso
                            JOptionPane.showMessageDialog(null, "No hay coches en el garage", "Fábrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE);
                        }
                    break;
                    case "7":
                         //Compruebo que haya coches en el garage
                         if (Coche.numCoches != 0) {
                            //Creo un String para pode ver las matriculas de los coches que haya creado
                            String titulo = "Coches en el garage:\n";
                            String matriculasCoches = "";
                            for (int i = 0;i< Coche.numCoches;i++) {
                               matriculasCoches += "Coche con matrícula: " + arrayCoches[i].getMatricula() + "\n";
                            }
                            String buscaMatricula3 = JOptionPane.showInputDialog(null, titulo + matriculasCoches + "\nIntroduzca la matricula", "Fábrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE);
                            if (buscaMatricula3.equals("")) {
                                    JOptionPane.showMessageDialog(null, "No has escrito ninguna matricula", "Fábrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE);
                                    continue;
                            }
                            //Busco la matricula y si existe retorno el valor del indice donde se encuentra en del array;Si NO existe retorno -1
                            int indice3 = buscaCoche(arrayCoches, buscaMatricula3, respuesta);
                                if (indice3 == -1) {
                                    JOptionPane.showMessageDialog(null, "No se encuentra el coche", "Fábrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE);
                                    break;
                                }
                            JOptionPane.showMessageDialog(null, caracteristicas(arrayCoches[indice3]), "Fábrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE);
                            break;   
                         }else {
                            //Si no hay coches aviso
                            JOptionPane.showMessageDialog(null, "No hay coches en el garage", "Fábrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE);
                         }
                    break;
                    case "8":
                        //Compruebo que haya coches en el garage
                        if (Coche.numCoches != 0) {
                            //Creo un String para pode ver las matriculas de los coches que haya creado
                            String titulo = "Coches en el garage:\n";
                            String matriculasCoches = "";
                                for (int i = 0;i< Coche.numCoches;i++) {
                                   matriculasCoches += "Coche con matrícula: " + arrayCoches[i].getMatricula() + "\n";
                                }
                            String buscaMatricula4 = JOptionPane.showInputDialog(null, titulo + matriculasCoches + "\nIntroduzca la matricula", "Fábrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE);
                                if (buscaMatricula4.equals("")) {
                                    JOptionPane.showMessageDialog(null, "No has escrito ninguna matricula", "Fábrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE);
                                    continue;
                                }
                            //Busco la matricula y si existe retorno el valor del indice donde se encuentra en del array;Si NO existe retorno -1
                            int indice4 = buscaCoche(arrayCoches, buscaMatricula4, respuesta);
                                if (indice4 == -1) {
                                    JOptionPane.showMessageDialog(null, "No se encuentra el coche", "Fábrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE);
                                }
                            break; 
                        }else {
                            //Si no hay coches aviso
                            JOptionPane.showMessageDialog(null, "No hay coches en el garage", "Fábrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case "9":
                        //Si la respuesta es 9 aviso y cierro app
                        JOptionPane.showMessageDialog(null, "Hasta la próxima", "Fábrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);;
                    break;
                    default:
                        //Si no se pulsa ninguna de las opciones del switch
                        JOptionPane.showMessageDialog(null,"Elige una operación de la lista", "Fábrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
                }else {
                    //Si se pulsa cancelar o la  de salir se pregunta si desea salir realmente y en base a la respuesta se sale de la app o se ejecuta el menú de nuevo 
                    if (JOptionPane.showConfirmDialog(null, "Quieres salir?", "Fabrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE,
                            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(null, "Hasta la próxima", "Fábrica coches 2.0 Java", JOptionPane.INFORMATION_MESSAGE);
                            System.exit(0);; 
                    } else {
                            continue;
                    }
                }
            }while(respuesta != "9"); 
                                                         

        }catch(NullPointerException e) {
            //Captacion de excepciones por no introducir datos
            JOptionPane.showMessageDialog(null, "No se ha introducido ningun valor", "Fábrica coches 2.0 Java", JOptionPane.ERROR_MESSAGE);
            //Aviso y vuelvo a llamar al menú
            menu(respuesta, arrayCoches);
        }
    }
    //Método que retorna la informacion de los coches gracias a la variable de referencia
    public static String caracteristicas(Coche c) {
        String informacion = ("\nCaractericticas del coche con matricula " + c.getMatricula() + ":\n----------------------------------------------" + "\nMatricula: " + c.getMatricula() + " \nMarca: " + c.getMarca() + " \nModelo: " + c.getModelo() 
                    + " \nColor: " + c.getColor() + "\nTecho solar: " + ((c.getTechoSolar())?"Si":"No") + "\nKilometraje: " + c.getKilometros() 
                    + "\nNumero de puertas: " + c.getNumPuertas() + "\nNumero de plazas: " + c.getNumPlazas() + "\n----------------------------------------------\n");
        return informacion;
    }
    //Método que busca la amtricula y si existe->hace operaciones y retorna un índice
    public static int buscaCoche(Coche[] garage, String matricula, String respuesta) {
        int indice = 0;
            //El método se comporta diferente segun la operación a realizar
            switch (respuesta) {
            case "1":
                //Si hay coches en el garage, busca la matricula y si existe retorna -1 y si no existe retorna 0
                if (Coche.numCoches != 0) {
                    for (int i = 0; i < Coche.numCoches; i++) {
                        if (matricula.equals(garage[i].getMatricula())) {
                            return -1;
                        }
                    }
                    for (int j = 0; j < Coche.numCoches; j++) {
                          if (!matricula.equals(garage[j].getMatricula())) {
                            return 0;
                        }
                    }
                }
            break;
            
            case "5":
                //Si hay coches en el garage,busca la matricula y si existe lo tunea preguntando un color y retorna el valor de la posición en el array de coches; si no existe retorna -1
                if (Coche.numCoches != 0) {
                  for (int i = 0; i < Coche.numCoches; i++) {
                    if (matricula.equals(garage[i].getMatricula())) {
                        garage[i].tunear(JOptionPane.showInputDialog(null, "Color del coche con matrícula: " + matricula));
                        return i;
                    }
                  } 
                  for (int j = 0; j < Coche.numCoches; j++) {
                          if (!matricula.equals(garage[j].getMatricula())) {
                            return -1;
                        }
                    }
                }
            break;
            //Si hay coches en el garage,busca la matricula y si existe lo tunea y retorna el valor de la posición en el array de coches; si no existe retorna -1
            case "6":
                if (Coche.numCoches != 0) { 
                  for (int i = 0; i < Coche.numCoches; i++) {
                        if (matricula.equals(garage[i].getMatricula())) {
                            garage[i].tunear();
                            return i;
                    }
                  }
                  for (int j = 0; j < Coche.numCoches; j++) {
                          if (!matricula.equals(garage[j].getMatricula())) {
                            return -1;
                        }
                    }
                }
            break;
            //Si hay coches en el garage,busca la matricula->si existe hace avanzar los kilometros con el valor pedido por pantalla y retorna el valor de la posición en el array de coches; si no existe retorna -1
            case "7":
                if (Coche.numCoches != 0) { 
                    for (int i = 0; i < garage.length; i++) {
                        if (matricula.equals(garage[i].getMatricula())) {
                            garage[i].avanzar(Double.parseDouble(JOptionPane.showInputDialog(null, "Cuantos kilometros poner al coche con matrícula: " + matricula)));
                            return i;
                        }
                    }
                    for (int j = 0; j < Coche.numCoches; j++) {
                          if (!matricula.equals(garage[j].getMatricula())) {
                            return -1;
                        }
                    }
                }
              
            break;
            //Si hay coches en el garage,busca la matricula->si existe hace avanzar los kilometros con el valor pedido por pantalla y retorna el valor de la posición en el array de coches; si no existe retorna -1
            case "8":
                for (int i = 0; i < Coche.numCoches; i++) {
                    if (matricula.equals(garage[i].getMatricula())) {
                        JOptionPane.showMessageDialog(null, caracteristicas(garage[i]));
                        return i;
                    }
              }
              for (int j = 0; j < Coche.numCoches; j++) {
                  if (!matricula.equals(garage[j].getMatricula())) {
                        return -1;
                    }
              }
            break;
            default:
                break;
        }
        //retorno el índice
        return indice;
    }
}
