import java.util.Scanner;

public class Hexagonos
{
    public static void main(String[] args) {
    int num = 0;
    char letra = 0;
    Scanner sc = new Scanner(System.in);
    num = sc.nextInt();
    letra = sc.next().charAt(0);
    num += 2;
        for(int i = num/2; i <= num ; i++) {
            for (int j = num - i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print(letra);
            }
            for (int l = 1; l < i - 1; l++) {
                System.out.print(letra);
            }
            System.out.println();
        }   
        for (int m = num - 1; m >=num/2; m--) {
            for (int p = num - m; p > 0; p--) {
                System.out.print(" ");
            }
            for (int n = 1; n <= m - 1; n++) {
                System.out.print(letra);
            }
            for (int l = 1; l < m ; l++) {
                System.out.print(letra);
            }
            System.out.println();
        }
        
        sc.close();
    }
}
