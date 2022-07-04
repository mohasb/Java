/**
 * Fabrica de vehiculos Java
 * 
 * @author (Muhammad Hicho Abdeselam) 
 * @version (v3.0)
 */
import javax.swing.JOptionPane;
import java.util.ArrayList;
public class Parque
{
    static ArrayList<Vehiculo> parqueVehiculos = new ArrayList<>();
    static String respuestaMenu;
    static String [] botonesInput = {"Sin datos", "Con datos"};
    
    public static void main(String[] args) {
        try {
            menu(); 
        }catch(NullPointerException e) {
            menu();
        }
    }

    public static void menu() {
        do {
            
            respuestaMenu = JOptionPane.showInputDialog(null, "1. Crear un coche (con o sin datos)"
                                                              + "\n2. Crear un autobús (con o sin datos)"
                                                              + "\n3. Crear un motocicleta (con o sin datos)"
                                                              + "\n4. Crear un avioneta (con o sin datos)"
                                                              + "\n5. Crear un yate (con o sin datos)" 
                                                              + "\n6. Mostrar características de todos los vehículos del parque"
                                                              + "\n7. Mostrar cracteristicas de un vehiculo(a traves de la matrícula)" 
                                                              + "\n8. Mostrar capacidades de un vehiculo(a traves de la matrícula)" 
                                                              + "\n9. Eliminar vehiculos(a traves de la matrícula) o vaciár parque" 
                                                              + "\n0. Salir del programa"
                                                              , "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
            if (respuestaMenu != null) {
                switch(respuestaMenu) {
                    case "1":
                        /*Llama al método creaCoche()que, en base a la respuesta del usuario, crea un coche con el constructor sin parámetros o con parámetros
                           -Utiliza el método datosVehiculo() para obtener los valores comunes de la clase vehiculo mediante el retorno de un array de Strings  */
                        creaCoche();
                        break;
                    case "2":
                        //Igual que los Coches pero con Autobuses
                        creaAutobus();
                        break;
                    case "3":
                        //Igual que los Coches pero con Motocicletas
                        creaMotocicleta();
                        break;
                    case "4":
                        //Igual que los Coches pero con Avionetas
                        creaAvioneta();
                        break;
                    case "5":
                        //Igual que los Coches pero con Yates
                        creaYate();
                        break;
                    case "6":
                        /*Mediante el método tipoVehiculo(Vehiculo) se determina el tipo del vehiculos mediante un índice -> Mediante ese índice se realiza el casting de los vehiculos 
                        y se muestra las caracteristicas y capacidades de todos los coches*/
                        mostrarArray(parqueVehiculos);
                        break;
                    case "7":
                        /*Mediante el método muestraMatriculas() obtengo las matriculas de los coches del parque -> Obtengo la matricula del usuario -> si existe muestra caracteristicas de ese vehiculo */
                        muestraCaracteristicas();
                        break;
                    case "8":
                        /*Método que muestra matriculas de los vehiculos del garage; filtra por la matricula proporcionada por el usuario -> muestra y permite ejecutar los métodos concretos de cada vehiculo*/
                        ejecutaAcciones();
                        break;
                    case "9":
                        eliminaVehiculo();
                        break;
                    case "0":
                        //Salir
                        JOptionPane.showMessageDialog(null, "Hasta la próxima", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                        break;
                    default:
                        //Si no se selecciona ninguna opción de la lista
                        JOptionPane.showMessageDialog(null, "Por favor elija una opción de la lista", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                        break;
                }
            }else {
                    //Si se pulsa cancelar o salir se pregunta si desea salir realmente y en base a la respuesta se sale de la app o se ejecuta el menú de nuevo 
                    if (JOptionPane.showConfirmDialog(null, "Quieres salir?", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE,
                            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(null, "Hasta la próxima", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                            System.exit(0); 
                    } else {
                            continue;
                    }
            }
        }while(respuestaMenu != "7");
    }
    
                        /*----------------------------------------Métodos del menú que crean los vehiculos----------------------------------------*/
    public static void creaCoche() {
        //Comprobar que no se ha superado el número maximo de Vehiculos
        if (Vehiculo.numVehiculos < Vehiculo.MAX_VEHICULOS) {
            //Determino si se quiere usar constructor sin parámetros o con parámetros
            int respuesta = JOptionPane.showOptionDialog(null, "¿Crear un coche con datos o sin datos?", "Fábrica de Vehículos Java", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesInput, botonesInput[0]);
                //0 sin parámetros y 1 con parámetros
                if (respuesta == 0) {
                    //Añado al ArrayList un coche del constructor sin parámetros
                    parqueVehiculos.add(new Coche());
                }else if (respuesta == 1) {
                    //Guardo los valores del vehiculo en el array datos
                    String[] datos = datosVehiculo();
                    //Obtener demás valores de Coche
                    int numAirbags = Integer.parseInt(JOptionPane.showInputDialog(null, "Número de airbags: ", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE));
                    int SiNo = JOptionPane.showConfirmDialog(null, "¿Tiene techo solar?", "Fábrica de Vehículos Java", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    boolean techoSolar = (SiNo == 0 ? true : false);
                    SiNo = JOptionPane.showConfirmDialog(null, "¿Tiene radio?", "Fábrica de Vehículos Java", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    boolean tieneRadio = (SiNo == 0 ? true : false);
                    //Añado al ArrayList un coche del constructor con parámetros
                    parqueVehiculos.add(new Coche(datos[0], datos[1], datos[2], Double.parseDouble(datos[3]), Integer.parseInt(datos[4]), Integer.parseInt(datos[5]), numAirbags, techoSolar, tieneRadio));
                }
        }else {
            //Si hay mas de 5 vehiculos aviso y vuelvo a menú
            JOptionPane.showMessageDialog(null, "El garage está lleno", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public static void creaAutobus() {
        //Comprobar que no se ha superado el número maximo de Vehiculos
        if (Vehiculo.numVehiculos < Vehiculo.MAX_VEHICULOS) {
            //Determino si se quiere usar constructor sin parámetros o con parámetros
            int respuesta = JOptionPane.showOptionDialog(null, "¿Crear un Autobús con datos o sin datos?", "Fábrica de Vehículos Java", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesInput, botonesInput[0]);
                //0 sin parámetros y 1 con parámetros
                if (respuesta == 0) {
                    //Añado al ArrayList un Autobus del constructor sin parámetros
                    parqueVehiculos.add(new Autobus());
                }else if (respuesta == 1) {
                    //Guardo los valores del vehiculo en el array datos
                    String[] datos = datosVehiculo();
                    //Obtener demás valores de Autobús
                    String tipoRecorrido = JOptionPane.showInputDialog(null, "Tipo de recorrido: ", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                    int SiNo = JOptionPane.showConfirmDialog(null, "¿Es escolar?", "Fábrica de Vehículos Java", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    boolean esEscolar = (SiNo == 0 ? true : false);
                    //Añado al ArrayList un Autobus del constructor con parámetros
                    parqueVehiculos.add(new Autobus(datos[0], datos[1], datos[2], Double.parseDouble(datos[3]), Integer.parseInt(datos[4]), Integer.parseInt(datos[5]), tipoRecorrido, esEscolar));
                }
        }else {
            //Si hay mas de 5 vehiculos aviso y vuelvo a menú
            JOptionPane.showMessageDialog(null, "El garage está lleno", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public static void creaMotocicleta() {
        //Comprobar que no se ha superado el número maximo de Vehiculos
        if (Vehiculo.numVehiculos < Vehiculo.MAX_VEHICULOS) {
            //Determino si se quiere usar constructor sin parámetros o con parámetros
            int respuesta = JOptionPane.showOptionDialog(null, "¿Crear una Motocicleta con datos o sin datos?", "Fábrica de Vehículos Java", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesInput, botonesInput[0]);
                //0 sin parámetros y 1 con parámetros
                if (respuesta == 0) {
                    //Añado al ArrayList un Motocicleta del constructor sin parámetros
                    parqueVehiculos.add(new Motocicleta());
                }else if (respuesta == 1) {
                    //Guardo los valores del vehiculo en el array datos
                    String[] datos = datosVehiculo();
                    //Obtener demás valores de Motocicleta
                    double potenciaMotor = Double.parseDouble(JOptionPane.showInputDialog(null, "Potencia del motor: ", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE));
                    int SiNo = JOptionPane.showConfirmDialog(null, "¿Tiene maletero?", "Fábrica de Vehículos Java", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    boolean tieneMaletero = (SiNo == 0 ? true : false);
                    //Añado al ArrayList un Motocicleta del constructor con parámetros
                    parqueVehiculos.add(new Motocicleta(datos[0], datos[1], datos[2], Double.parseDouble(datos[3]), Integer.parseInt(datos[4]), Integer.parseInt(datos[5]),potenciaMotor, tieneMaletero));
                }
        }else {
            //Si hay mas de 5 vehiculos aviso y vuelvo a menú
            JOptionPane.showMessageDialog(null, "El garage está lleno", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public static void creaAvioneta() {
        //Comprobar que no se ha superado el número maximo de Vehiculos
        if (Vehiculo.numVehiculos < Vehiculo.MAX_VEHICULOS) {
            //Determino si se quiere usar constructor sin parámetros o con parámetros
            int respuesta = JOptionPane.showOptionDialog(null, "¿Crear una Avioneta con datos o sin datos?", "Fábrica de Vehículos Java", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesInput, botonesInput[0]);
                //0 sin parámetros y 1 con parámetros
                if (respuesta == 0) {
                    //Añado al ArrayList un Avioneta del constructor sin parámetros
                    parqueVehiculos.add(new Avioneta());
                }else if (respuesta == 1) {
                    //Guardo los valores del vehiculo en el array datos
                    String[] datos = datosVehiculo();
                    //Obtener demás valores de Avioneta
                    String aeropuerto = JOptionPane.showInputDialog(null, "Aeropuerto de origen: ", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                    double maxKg = Double.parseDouble(JOptionPane.showInputDialog(null, "Carga máxima: ", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE));
                    //Añado al ArrayList un Avioneta del constructor con parámetros
                    parqueVehiculos.add(new Avioneta(datos[0], datos[1], datos[2], Double.parseDouble(datos[3]), Integer.parseInt(datos[4]), Integer.parseInt(datos[5]),aeropuerto, maxKg));
                }
        }else {
            //Si hay mas de 5 vehiculos aviso y vuelvo a menú
            JOptionPane.showMessageDialog(null, "El garage está lleno", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public static void creaYate() {
        //Comprobar que no se ha superado el número maximo de Vehiculos
        if (Vehiculo.numVehiculos < Vehiculo.MAX_VEHICULOS) {
            //Determino si se quiere usar constructor sin parámetros o con parámetros
            int respuesta = JOptionPane.showOptionDialog(null, "¿Crear un Yate con datos o sin datos?", "Fábrica de Vehículos Java", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null/*icono*/, botonesInput, botonesInput[0]);
                //0 sin parámetros y 1 con parámetros
                if (respuesta == 0) {
                    //Añado al ArrayList un Yate del constructor sin parámetros
                    parqueVehiculos.add(new Yate());
                }else if (respuesta == 1) {
                    //Guardo los valores del vehiculo en el array datos
                    String[] datos = datosVehiculo();
                    //Obtener demás valores de Yate
                    int SiNo = JOptionPane.showConfirmDialog(null, "¿Tiene cocina?", "Fábrica de Vehículos Java", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    boolean tieneCocina = (SiNo == 0 ? true : false);
                    int numMotores = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero de motores:", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE));
                    double metrosEslora = Double.parseDouble(JOptionPane.showInputDialog(null, "Metros de Eslora: ", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE));
                    //Añado al ArrayList un Yate del constructor con parámetros
                    parqueVehiculos.add(new Yate(datos[0], datos[1], datos[2], Double.parseDouble(datos[3]), Integer.parseInt(datos[4]), Integer.parseInt(datos[5]),tieneCocina, numMotores, metrosEslora));
                }
        }else {
            //Si hay mas de 5 vehiculos aviso y vuelvo a menú
            JOptionPane.showMessageDialog(null, "El garage está lleno", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    //Obtener valores comunes de los vehiculos
    public static String[] datosVehiculo() {
        String marca = JOptionPane.showInputDialog(null, "Introduzca la marca", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
        String modelo = JOptionPane.showInputDialog(null, "Introduzca el Modelo: ", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
        String color = JOptionPane.showInputDialog(null, "Introduzca el Color: ", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
        double kilometros = Double.parseDouble(JOptionPane.showInputDialog(null, "Introduzca los kilómetros: ", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE));
        int numPuertas = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca el número de Puertas: ", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE));
        int numPlazas = Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca el número de Plazas: ", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE));
        
        String[] datosVehiculo = new String[] {marca, modelo, color, String.valueOf(kilometros), String.valueOf(numPuertas), String.valueOf(numPlazas)};
        
        return datosVehiculo;
    }
                           
            /*----------------------------------------Método encargado de determinar el tipo de Vehiculo----------------------------------------*/
    public static int tipoVehiculo(Vehiculo uno) {
        Object o = uno;
        if (o instanceof Coche) {
            return 0;
        }else if (o instanceof Autobus) {
            return 1;
        }else if (o instanceof Motocicleta) {
            return 2;
        }else if (o instanceof Avioneta) {
            return 3;
        }else if (o instanceof Yate) {
            return 4;
        }else {
            return -1;
        }
    }
    
            /*--------Método encargado de hacer el casting de los Object en base al indice proporcionado por el método tipoVehiculo() y mostrar sus carácteristicas y capacidades------------------*/
    public static void mostrarArray(ArrayList<Vehiculo> parqueVehiculos) {
        if (Vehiculo.numVehiculos != 0) {
            for(Object vehiculo : parqueVehiculos) {
                //indiceVehiculo: 0=Coche, 1=Autobus, 2=Motocicleta, 3=Avioneta, 4=Yate, -1=Error  
                int indiceVehiculo = tipoVehiculo((Vehiculo) vehiculo);
                if (indiceVehiculo == 0) {
                    Coche c = (Coche) vehiculo;
                    JOptionPane.showMessageDialog(null, "Tipo Vehiculo: Coche\n" + c + "\n\nCapacidades del Coche:" 
                                                                                     + "\n" + c.circular(), "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                }else if (indiceVehiculo == 1) {
                    Autobus a = (Autobus) vehiculo;
                    JOptionPane.showMessageDialog(null, "Tipo Vehiculo: Autobus\n" + a + "\n\nCapacidades del Autobús:" 
                                                                                       + "\n" + a.circular(), "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                }else if (indiceVehiculo == 2) {
                    Motocicleta m = (Motocicleta) vehiculo;
                    JOptionPane.showMessageDialog(null, "Tipo Vehiculo: Motocicleta\n" + m + "\n\nCapacidades de la Motocicleta:" 
                                                                                           + "\n" + m.circular(), "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                }else if (indiceVehiculo == 3) {
                    Avioneta av = (Avioneta) vehiculo;
                    JOptionPane.showMessageDialog(null, "Tipo Vehiculo: Avioneta\n" + av + "\n\nCapacidades de la Avioneta:"
                                                                                    + "\n" + av.circular()
                                                                                    + "\n" + av.volar(), "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                }else if (indiceVehiculo == 4) {
                    Yate y = (Yate) vehiculo;
                    JOptionPane.showMessageDialog(null, "Tipo Vehiculo: Yate\n" + y + "\n\nCapacidades del Yate:" 
                                                                                    + "\n" + y.navegar(), "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }else {
            //Si no hay vehiculos aviso
            JOptionPane.showMessageDialog(null, "No hay vehiculos en el parque", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    /*----------------------------------------Mostrar las caracteristicas de los coches del parque por matricula----------------------------------------*/
    public static void muestraCaracteristicas() {
        if (Vehiculo.numVehiculos != 0) {
            String matriculaABuscar = JOptionPane.showInputDialog(null, muestraMatriculas() + "\nEscribe la matricula del vehiculo del que deseas ver las características", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
            if (!matriculaABuscar.equals("")) {
                buscaVehiculo(matriculaABuscar);
            }else {
                JOptionPane.showMessageDialog(null, "No has escrito ninguna matricula", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
            }
        }else {
            //Si no hay vehiculos aviso
            JOptionPane.showMessageDialog(null, "No hay vehiculos en el parque", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
        }
    }
            /*-----------Encargado del hacer el casting, recoger las matrículas de los vehiculos y pasarlas al método mostrarVehiculo()-----------------------------*/
    
    public static String muestraMatriculas() {
        //Creo un String para pode ver las matriculas de los coches que haya creado
        String titulo = "Vehiculos en el parque:\n";
        String matriculasVehiculos = "";
            //Casting
            for(Object vehiculo : parqueVehiculos) {
                //indiceVehiculo: 0=Coche, 1=Autobus, 2=Motocicleta, 3=Avioneta, 4=Yate, -1=Error  
                int indiceVehiculo = tipoVehiculo((Vehiculo) vehiculo);
                if (indiceVehiculo == 0) {
                    Coche c = (Coche) vehiculo;
                    matriculasVehiculos += "Coche con matrícula: " + c.getMatricula() + "\n";
                }else if (indiceVehiculo == 1) {
                    Autobus a = (Autobus) vehiculo;
                    matriculasVehiculos += "Autobús con matrícula: " + a.getMatricula() + "\n";
                }else if (indiceVehiculo == 2) {
                    Motocicleta m = (Motocicleta) vehiculo;
                    matriculasVehiculos += "Motocicleta con matrícula: " + m.getMatricula() + "\n";
                }else if (indiceVehiculo == 3) {
                    Avioneta av = (Avioneta) vehiculo;
                    matriculasVehiculos += "Avioneta con matrícula: " + av.getMatricula() + "\n";
                }else if (indiceVehiculo == 4) {
                    Yate y = (Yate) vehiculo;
                    matriculasVehiculos += "Yate con matrícula: " + y.getMatricula() + "\n";
                }
            }
            return titulo + matriculasVehiculos;
    }
                                                    /*-----------------------------EXTRAS-----------------------------*/
                /*-----------Encargado de comparar la matrícula proporcionada y compararla con todas las del parque de vehiculos-----------------------------*/
    public static void buscaVehiculo(String matricula) {
        boolean existe = false;
        for(Vehiculo vehiculo : parqueVehiculos) {
            if (matricula.toUpperCase().equals(vehiculo.getMatricula())) {
                JOptionPane.showMessageDialog(null, vehiculo, "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                existe = true;
                break;
            }else {
                existe = false;
            }
        }
        if (!existe) {
                JOptionPane.showMessageDialog(null, "No se encuentra el coche", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public static void ejecutaAcciones() {
        String respuesta = "";
        if (Vehiculo.numVehiculos != 0) {
            String matriculaABuscar = JOptionPane.showInputDialog(null, muestraMatriculas() + "\nEscribe la matricula del vehiculo del que deseas ver las capacidades", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
            if (!matriculaABuscar.equals("")) {
                boolean existe = false;
                for(Vehiculo vehiculo : parqueVehiculos) {
                    if (matriculaABuscar.toUpperCase().equals(vehiculo.getMatricula())) {
                        //indiceVehiculo: 0=Coche, 1=Autobus, 2=Motocicleta, 3=Avioneta, 4=Yate, -1=Error  
                        int indiceVehiculo = tipoVehiculo((Vehiculo) vehiculo);
                        if (indiceVehiculo == 0) {
                            Coche c = (Coche) vehiculo;
                            do {
                                respuesta = JOptionPane.showInputDialog(null, "Ejecutar capacidades del Coche:\n1. Circular" + "\n2. Arrancar" + "\n3. Acelerar" + "\n4. Frenar" + "\n5. Tunear" + "\n6. Aparcar" + "\n7. Salir", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                switch (respuesta) {
                                    case "1":
                                        JOptionPane.showMessageDialog(null, c.circular(), "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    case "2":
                                        JOptionPane.showMessageDialog(null, c.arrancar(), "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    case "3":
                                        JOptionPane.showMessageDialog(null, c.acelerar(), "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    case "4":
                                        JOptionPane.showMessageDialog(null, c.frenar(), "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    case "5":
                                        JOptionPane.showMessageDialog(null, c.tunear(JOptionPane.showInputDialog(null, "¿De que color quieres pintar el coche?", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE)), "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    case "6":
                                        JOptionPane.showMessageDialog(null, c.aparcar(), "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    case "7":
                                        JOptionPane.showMessageDialog(null, "Hasta la próxima", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                        return;
                                    default:
                                        JOptionPane.showMessageDialog(null, "Por favor elija una opción de la lista", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                }
                            }while (respuesta != "7");
                        }else if (indiceVehiculo == 1) {
                            Autobus a = (Autobus) vehiculo;
                            do {
                                respuesta = JOptionPane.showInputDialog(null, "Ejecutar capacidades del Autobús:\n1. Circular" + "\n2. Arrancar" + "\n3. Acelerar" + "\n4. Abrir puertas" + "\n5. Frenar" + "\n6. Aparcar" + "\n7. Salir", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                switch (respuesta) {
                                    case "1":
                                        JOptionPane.showMessageDialog(null, a.circular(), "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    case "2":
                                        JOptionPane.showMessageDialog(null, a.arrancar(), "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    case "3":
                                        JOptionPane.showMessageDialog(null, a.acelerar(), "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    case "4":
                                        JOptionPane.showMessageDialog(null, a.abrirPuertas(), "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    case "5":
                                        JOptionPane.showMessageDialog(null, a.frenar(), "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    case "6":
                                        JOptionPane.showMessageDialog(null, a.aparcar(), "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    case "7":
                                        JOptionPane.showMessageDialog(null, "Hasta la próxima", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                        return;
                                    default:
                                        JOptionPane.showMessageDialog(null, "Por favor elija una opción de la lista", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                }
                            }while (respuesta != "7");
                        }else if (indiceVehiculo == 2) {
                            Motocicleta m = (Motocicleta) vehiculo;
                            do {
                                respuesta = JOptionPane.showInputDialog(null, "Ejecutar capacidades de la Motocicleta:\n1. Circular" + "\n2. Arrancar" + "\n3. Acelerar" + "\n4. Brincar" + "\n5. Frenar" + "\n6. Aparcar" + "\n7. Salir", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                switch (respuesta) {
                                    case "1":
                                        JOptionPane.showMessageDialog(null,  m.circular(), "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    case "2":
                                        JOptionPane.showMessageDialog(null,  m.arrancar(), "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    case "3":
                                        JOptionPane.showMessageDialog(null,  m.acelerar(), "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    case "4":
                                        JOptionPane.showMessageDialog(null,   m.brincar(), "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    case "5":
                                        JOptionPane.showMessageDialog(null,  m.frenar(), "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    case "6":
                                        JOptionPane.showMessageDialog(null,  m.aparcar(), "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    case "7":
                                        JOptionPane.showMessageDialog(null, "Hasta la próxima", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    default:
                                        JOptionPane.showMessageDialog(null, "Por favor elija una opción de la lista", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                }
                            }while (respuesta != "7");
                        }else if (indiceVehiculo == 3) {
                            Avioneta av = (Avioneta) vehiculo;
                            do {
                                respuesta = JOptionPane.showInputDialog(null, "Ejecutar capacidades del Autobús:\n1. Circular" + "\n2. Volar" + "\n3. Despegar" + "\n4. Arrancar" + "\n5. Acelerar" + "\n6. Frenar" + "\n7. Aterrizar" + "\n8. Salir", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                switch (respuesta) {
                                    case "1":
                                        JOptionPane.showMessageDialog(null,  av.circular(), "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    case "2":
                                        JOptionPane.showMessageDialog(null,  av.volar(), "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    case "3":
                                        JOptionPane.showMessageDialog(null,  av.despegar(), "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    case "4":
                                        JOptionPane.showMessageDialog(null,  av.arrancar(), "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    case "5":
                                        JOptionPane.showMessageDialog(null,  av.acelerar(), "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    case "6":
                                        JOptionPane.showMessageDialog(null,  av.frenar(), "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    case "7":
                                        JOptionPane.showMessageDialog(null,  av.aterrizar(), "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    case "8":
                                        JOptionPane.showMessageDialog(null, "Hasta la próxima", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                        return;
                                    default:
                                        JOptionPane.showMessageDialog(null, "Por favor elija una opción de la lista", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                }
                            }while (respuesta != "8");
                        }else if (indiceVehiculo == 4) {
                            Yate y = (Yate) vehiculo;
                            do {
                                respuesta = JOptionPane.showInputDialog(null, "Ejecutar capacidades del Autobús:\n1. Navegar" + "\n2. Arrancar" + "\n3. Zarpar" + "\n4. Acelerar" + "\n5. Frenar" + "\n6. Atracar" + "\n7. Salir", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                switch (respuesta) {
                                    case "1":
                                        JOptionPane.showMessageDialog(null,  y.navegar(), "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    case "2":
                                        JOptionPane.showMessageDialog(null,  y.arrancar(), "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    case "3":
                                        JOptionPane.showMessageDialog(null,  y.zarpar(), "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    case "4":
                                        JOptionPane.showMessageDialog(null,  y.acelerar(), "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    case "5":
                                        JOptionPane.showMessageDialog(null,  y.frenar(), "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    case "6":
                                        JOptionPane.showMessageDialog(null,  y.atracar(), "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                    case "7":
                                        JOptionPane.showMessageDialog(null, "Hasta la próxima", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                        return;
                                    default:
                                        JOptionPane.showMessageDialog(null, "Por favor elija una opción de la lista", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                                        break;
                                }
                            }while (respuesta != "7");
                        }
                        existe = true;
                        break;
                    }else {
                        existe = false;
                    }
                }
                if (!existe) {
                    JOptionPane.showMessageDialog(null, "No se encuentra el coche", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                }
            }else {
                JOptionPane.showMessageDialog(null, "No has escrito ninguna matricula", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
            }
        }else {
            //Si no hay vehiculos aviso
            JOptionPane.showMessageDialog(null, "No hay vehiculos en el parque", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public static void eliminaVehiculo() {
        int indiceVehiculo = 0;
        String[] botones = {"SI", "NO"};
        if (Vehiculo.numVehiculos != 0) {
            String matriculaABuscar = JOptionPane.showInputDialog(null, muestraMatriculas() + "\nEscribe la matricula del vehiculo que deseas eliminar(Escribe \"Todos\" para vaciar el parque)", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
            if (!matriculaABuscar.equals("")) {
                boolean existe = false;
                boolean eliminaTodos = false;
                for(Vehiculo vehiculo : parqueVehiculos) {
                    if (matriculaABuscar.toUpperCase().equals(vehiculo.getMatricula())) {
                        indiceVehiculo = parqueVehiculos.indexOf(vehiculo);
                        existe = true;
                        break;
                    }else if (matriculaABuscar.toUpperCase().equals("TODOS")) {
                            eliminaTodos = true;
                            break;
                    }else {
                        existe = false;
                    }
                }
                if (existe) {
                    int respuesta = JOptionPane.showOptionDialog(null, "¿Seguro que quieres eliminar el vehiculo con matricula: " + matriculaABuscar.toUpperCase(), "Fábrica de Vehículos Java", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null/*icono*/, botones, botones[0]);
                    if (respuesta == 0) {
                        parqueVehiculos.remove(indiceVehiculo);
                        Vehiculo.numVehiculos--;
                    }
                }else if (eliminaTodos) {
                    int respuesta = JOptionPane.showOptionDialog(null, "¿Seguro que quieres eliminar todos los vehiculos", "Fábrica de Vehículos Java", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null/*icono*/, botones, botones[0]);
                    if (respuesta == 0) {
                        parqueVehiculos.clear();
                        Vehiculo.numVehiculos = 0;
                    }
                }else {
                    JOptionPane.showMessageDialog(null, "No se encuentra el Vehiculo", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
                }
            }else {
                JOptionPane.showMessageDialog(null, "No has escrito ninguna matricula", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
            }
        }else {
            //Si no hay vehiculos aviso
            JOptionPane.showMessageDialog(null, "No hay vehiculos en el parque", "Fábrica de Vehículos Java", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
