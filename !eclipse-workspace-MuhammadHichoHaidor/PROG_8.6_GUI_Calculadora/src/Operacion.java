
public class Operacion {
		
	 
	 
    static double Sumar(double numero, double numero2) {
		return numero + numero2;
    	
    }
	static double Restar(double numero, double numero2) {
		
		return numero - numero2;
	}
	static double Multiplicar(double numero, double numero2) {
		return numero * numero2;
	}
	static double Dividir(double numero, double numero2) {
		if (numero == 0 || numero2 == 0) {
			return 0;
		}
		return numero / numero2;
	}
}
