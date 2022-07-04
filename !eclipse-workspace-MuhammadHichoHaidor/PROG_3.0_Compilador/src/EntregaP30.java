
import javax.swing.JOptionPane;

public class EntregaP30 {
	public static void main(String[] args) {  
		JOptionPane.showMessageDialog(null,"1: La sentencia <int x = 34,5> No funciona por que se estan metiendo decimales en una variable tipo entero. Ofrece error de: Type mismatch: cannot convert from double to int");
		JOptionPane.showMessageDialog(null,"2: La sentencia <boolean boo = x> No funciona por que una variable booleana solo puede valer true o false. Ofrece error de: x cannot be resolved to a variable" );
		int g = 17; JOptionPane.showMessageDialog(null, "3: La sentencia <int g = 17;>  es correcta y funciona");
		int y = g; JOptionPane.showMessageDialog(null, "4: La sentencia <int y = g;>  es correcta y funciona");
		y = y + 10; JOptionPane.showMessageDialog(null, "5: La sentencia <y = y + 10;>  es correcta y funciona");
		@SuppressWarnings("unused")
		short s; JOptionPane.showMessageDialog(null, "6: La sentencia <short s;>  es correcta y funciona");
		JOptionPane.showMessageDialog(null, "7: La sentencia <s = y;> No funciona por que no puede convertir de una variable short a una variable int. Ofrece error de: Type mismatch: cannot convert from int to short");
		byte b = 3; JOptionPane.showMessageDialog(null, "8: La sentencia <int g = 17;>  es correcta y funciona");
		@SuppressWarnings("unused")
		byte v = b; JOptionPane.showMessageDialog(null, "9: La sentencia <byte v = b;>  es correcta y funciona");
		@SuppressWarnings("unused")
		short n = 12; JOptionPane.showMessageDialog(null, "10: La sentencia <byte v = b;>  es correcta y funciona");
		JOptionPane.showMessageDialog(null, "11: La sentencia < v = n;> No funciona por que no puede convertir de byte a short. Ofrece error de: Type mismatch: cannot convert from short to byte");
		JOptionPane.showMessageDialog(null, "12: La sentencia <byte k = 128;> No funciona por que los bytes van de -127 a 127. Ofrece error de: Type mismatch: cannot convert from int to byte");

		
		
		
		
		
		
		
		
	}
}
