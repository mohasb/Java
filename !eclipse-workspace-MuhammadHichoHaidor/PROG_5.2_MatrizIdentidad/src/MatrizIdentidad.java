import java.util.Scanner;

public class MatrizIdentidad {
    public static void main(String[] args) {
        
        byte filas = 1;
        byte columnas = 0;
        Scanner teclado = new Scanner(System.in);
        while (filas != 0) {
            filas = teclado.nextByte();
            columnas = filas;
            if(filas>0 && filas<=50) {
                
                byte [][] matriz = new byte [filas][columnas];
                for (byte i = 0; i < matriz.length; i++) {
                    for (byte j = 0; j < matriz.length; j++) {
                        
                        if(i==j) {
                            matriz[i][j]=1;
                            
                        }
                        else {
                            matriz[i][j]=0;

                        }

                        System.out.print(matriz[i][j]);
                        System.out.print(" ");
                    }
                    System.out.println(" ");
                }
            }
        }
        teclado.close();
    }    
}
