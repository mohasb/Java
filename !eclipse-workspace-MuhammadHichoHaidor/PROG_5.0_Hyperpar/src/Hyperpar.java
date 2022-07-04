import java.util.Scanner;
public class Hyperpar
{
  public static void main(String[] args) {
		
    String num = "";
    int par = 0;
    Scanner sc = new Scanner(System.in);
    num = sc.next();

	while (Integer.parseInt(num) != -1) {
			
        	char[] cadena = num.toCharArray();
			
		for (int i = 0; i < cadena.length; i++) {
			if (cadena[i] % 2 == 0) {
				par++;
			}
		}
		if (par == cadena.length) {
			System.out.println("SI");
			par = 0;
		} else {
			System.out.println("No");
        		par = 0;
		}
		num = sc.next();

		}
		sc.close();
	}
}
