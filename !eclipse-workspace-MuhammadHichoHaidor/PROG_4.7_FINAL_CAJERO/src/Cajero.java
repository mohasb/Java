import javax.swing.*;
import java.awt.*;
/*
 * falta . o , y letras donde ingreso/retirada
 */
public class Cajero
{
   public static void main(String[] args) {
       //Variables
       String respuesta = "";   //Contendrá el valor de la operación del usuario
       Cuenta c = new Cuenta(); //Instancia de objeto de la clase Cuenta llamado 'c'
       UIManager um = new UIManager();  //Instancia de objeto de la clase UIManager llamado 'um'(Encargado de cambiar el color de texto a rojo)
              
       do {
           try {
               //Establezco el color del mensaje JoptionPane en negro
        	   UIManager.put("OptionPane.messageForeground", Color.black);
               //Recibo el valor de la operación a realizar
               respuesta = JOptionPane.showInputDialog(null, "Bienvenido, ¿que operación quiere realizar?\n\nSaldo-1\nImposición-2\nReintegro-3\nSalir-4", "Cuenta Corriente", JOptionPane.QUESTION_MESSAGE);
               
                   switch(respuesta) {
                       case "1":
                           //Recibe como argumento el objeto 'c' y 'um' para poder usarlos en el método 
                           obtenerSaldo(c, um);
                           break;
                       case "2":
                            // Recibe como argumento el retorno del método solicitaCantidad y el objeto 'c' (solicitaCantidad(true) -> true para que la operacón ternaria determine que es un ingreso)
                           ingresar(solicitaCantidad(true), c);
                           break;
                           // Recibe como argumento el retorno del método solicitaCantidad y el objeto 'c' (solicitaCantidad(false) -> false para que la operacón ternaria determine que es un reintegro)
                       case "3":
                           extraer(solicitaCantidad(false), c);
                           break;
                       case "4":
                           //Salir
                           JOptionPane.showMessageDialog(null, "Hasta la próxima", "Cuenta Corriente", JOptionPane.INFORMATION_MESSAGE);
                           return;
                       default:
                           //Si no se pone ninguna opción válida
                           JOptionPane.showMessageDialog(null, "Debe eligir una operacion válida", "Cuenta Corriente", JOptionPane.INFORMATION_MESSAGE);
                           break;
                   }
            //Captura de excepciones al pulsar cancelar/salir
           }catch (NullPointerException e) {
               JOptionPane.showMessageDialog(null, "Error: No se ha seleccionado ninguna operación (\"4\" para salir)", "Cuenta Corriente",JOptionPane.ERROR_MESSAGE);
            //Captura de excepciones al poner un dato no numérico a ingresar o retirar
           }catch (NumberFormatException e) {
               JOptionPane.showMessageDialog(null, "Error: Ha introducido un valor no numérico", "Cuenta Corriente",JOptionPane.ERROR_MESSAGE);
            //Captura demas excepciones
           }catch (Exception e) {
               JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Cuenta Corriente",JOptionPane.ERROR_MESSAGE);
           }
           //Mientras no se escriba '4' pide más operaciónes
       } while (respuesta != "4");
   }
   /*Método statico que tiene como parámetro el boleano para determinar si es un ingreso o una retirada,Capturo como String
     para poder usar el método .replace(',','.') y cambiar la coma por punto y evitar excepción -> para retornar convierto a Double*/
   static double solicitaCantidad(boolean ingresoRetirada) {
       String cantidad = JOptionPane.showInputDialog(null, "¿Cuanto desea " + ((ingresoRetirada)? "Ingresar?": "Retirar?"), "Cuenta Corriente", JOptionPane.QUESTION_MESSAGE);
       return Double.parseDouble(cantidad.replace(',', '.'));
   }
   //Método encargado de capturar el valor del ingreso pasado por argumento mediante el método solicitaCantidad y establecer el nuevo valor del saldo
   static void ingresar(double ingreso, Cuenta c) {
       c.setSaldo(c.getSaldo() + ingreso);
       JOptionPane.showMessageDialog(null, "Se han ingresado " + String.format("%,.2f", ingreso) + "€ en su cuenta ", "Cuenta Corriente", JOptionPane.INFORMATION_MESSAGE);
   }
   //Método encargado de capturar el valor del reintegro pasado por argumento mediante el método solicitaCantidad y establecer el nuevo valor del saldo
   static void extraer(double reintegro, Cuenta c) {
       c.setSaldo(c.getSaldo() - reintegro);
       //Si al retirar la cuenta se queda con menos de 0€ avisa
       if (c.getSaldo() < 0) {
           JOptionPane.showMessageDialog(null, "Esta operación dejará su cuenta en numeros rojos", "Cuenta Corriente", JOptionPane.INFORMATION_MESSAGE);
       }
       JOptionPane.showMessageDialog(null, "Se ha retirado " + String.format("%,.2f", reintegro) + "€ de su cuenta ", "Cuenta Corriente", JOptionPane.INFORMATION_MESSAGE);
   }
   //Método para mostrar el saldo
   static void obtenerSaldo(Cuenta c, UIManager um) {
       //Si la cuenta tiene menos de 0€ pongo las letras en rojo
       if (c.getSaldo() < 0 ) {
           UIManager.put("OptionPane.messageForeground", Color.red);
           JOptionPane.showMessageDialog(null, "Su saldo es de: " + String.format("%,.2f", c.getSaldo()) + "€", "Cuenta Corriente", JOptionPane.INFORMATION_MESSAGE);
       }else {
           JOptionPane.showMessageDialog(null, "Su saldo es de: " + String.format("%,.2f", c.getSaldo()) + "€", "Cuenta Corriente", JOptionPane.INFORMATION_MESSAGE);
       }
   }
}
