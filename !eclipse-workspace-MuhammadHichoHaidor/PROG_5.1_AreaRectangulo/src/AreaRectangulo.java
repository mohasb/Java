import java.util.Scanner;

public class AreaRectangulo
{
    public static void main(String[] args) {
        
        String numero;
        int altura;
        int base;
        int area;
        Scanner sc = new Scanner(System.in);
        
        numero = sc.next();
        char[] numeros = numero.toCharArray();
        
        base = numeros[2] - numeros[0];
        altura = numeros[3] - numeros[1];
        area = base * altura;
        
        if (numeros[2] < numeros[0]) {
            sc.close();
            return;
        }
        System.out.println(area);
        sc.close();
    }
}
