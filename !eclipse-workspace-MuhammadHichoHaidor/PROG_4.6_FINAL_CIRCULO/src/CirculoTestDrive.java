import javax.swing.JOptionPane;
public class CirculoTestDrive
{
    public static void main(String[] args) {
       //Instancia de un objeto de la clase Circulo llamado 'c' 
       Circulo c = new Circulo();
       //El método 'obtenDatos' tiene como argumento una variable de referencia al objeto circulo
       obtenDatos(c);
       //El método 'muestraDatos' tiene como argumento la variable radio del objeto y el retorno de los métodos de la clase circulo
       muestraDatos(c.getRadio(), c.getArea(), c.getPerimetro());
    }
    //El método 'obtenDatos' recibe como parámetro una variable de referencia al objeto (c)
    public static void obtenDatos(Circulo c) {
        do {
            try {
                //obtengo valor del rádio mediante reglas de encapsulación
                c.setRadio(Double.parseDouble(JOptionPane.showInputDialog(null, "Introduce el valor del radio del círculo en metros(m)", "Creando círculos", JOptionPane.QUESTION_MESSAGE)));
                //Si radio es mayor que 0 esta correcto y salimos del 'if' y del 'try-catch'
                if (c.getRadio() > 0) {
                    continue;
                //Si es menor que 0 muestro mensaje y vuelve a iniciar el bloque 'do' al no cumplirse la regla del 'while'
                }else {
                    JOptionPane.showMessageDialog(null, "Error, el valor introducido debe ser mayor que 0", "Creando círculos", JOptionPane.ERROR_MESSAGE);
                }
            //Captura de excepción si el valor no es numérico
            }catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error, el valor introducido debe ser un número", "Creando círculos", JOptionPane.ERROR_MESSAGE);
            //Captura de excepción si se pulsa cancelar o la 'X' de cerrar(no hace nada y vuelve a solicitar el rádio) 
            }catch (NullPointerException e) {
            //Captura del resto de excepciones    
            }catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error" + "\n" + e, "Creando círculos", JOptionPane.ERROR_MESSAGE);
            }
        }while (c.getRadio() <= 0);
    }
    //El método 'muestraDatos' recibe como parametro las tres variables(que se rellenan con los valores introducidos en los arguemntos del método del main) 
    public static void muestraDatos(double radio, double area, double perimetro) {
        JOptionPane.showMessageDialog(null, "El radio del círculo pedido es de: " + radio + " metros" + "\nEl área es igual a: " + String.format("%,.2f", area) + " metros²" +
                                            "\nEl perímetro es igual a: " + String.format("%,.2f", perimetro) + " metros", "Creando círculos", JOptionPane.INFORMATION_MESSAGE);
    }
}
