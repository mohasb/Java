import javax.swing.JOptionPane;

public class entregaP42
{
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "");
        int a = calcArea(7, 12);JOptionPane.showMessageDialog(null,"La sentencia: int a = calcArea(7, 12);" +
                                           "\nError: non-static metod calcArea(int, int) cannot xbe referenced from a static context" +
                                           "\nExplicación: nos dice que hay que no se puede hacer una referencia estatica a un metodo no estatico aunque se le pasen sus dos argumentos" +
                                           "\nSolución: Poner static al metodo calcArea()");
        short c = 7;JOptionPane.showMessageDialog(null,"La sentencia:  short c = 7; es correcta");
        calcArea(c, 15);JOptionPane.showMessageDialog(null,"La sentencia: calcArea(c, 15);" + 
                                           "\nError: non-static metod calcArea(int, int) cannot xbe referenced from a static context" +
                                           "\nExplicación: nos dice que hay que no se puede hacer una referencia estatica a un metodo no estatico aunque se le pasen sus dos argumentos" +
                                           "\nSolución: Poner static al metodo calcArea()");
        @SuppressWarnings("unused")
		int d = calcArea(57,2);JOptionPane.showMessageDialog(null,"La sentencia: int d = calcArea(57);" + 
                                           "\nError: method calcArea in entregaP42 cannot be applied to given types;Required: int,int;Found: int;Reason: actual and formal arguments lists differ in length" + 
                                           "\nNos Dice que se le ha proporcionado solo un argumento y el metodo necesita dos;Ademas de que llama a un método no estático" + 
                                           "\nSolución: Poner static al metodo calcArea() y añadir un argumento entero");
        calcArea(2,3);JOptionPane.showMessageDialog(null,"La sentencia: calcArea(2,3);" +
                                           "\nError: non-static metod calcArea(int, int) cannot xbe referenced from a static context" +
                                           "\nSolución: Poner static al metodo calcArea()"); 
        int t = 42;JOptionPane.showMessageDialog(null,"La sentencia: long t = 42;  es correcta");
        @SuppressWarnings("unused")
		int f = calcArea(t, 17);JOptionPane.showMessageDialog(null,"La sentencia; int f = calcArea(t, 17); " +
                                           "\nError: method calcArea in entregaP42 cannot be applied to given types;Required: int,int;Found: int;Reason: actual and formal arguments lists differ in length" +
                                           "\nExplicación: nos Dice que no se le ha proporcionado ningun argumnto y el metodo necesita dos;Ademas de que llama a un método no estático" + 
                                           "\nSolución: Poner static al metodo calcArea() y añadir un argumento entero");
        @SuppressWarnings("unused")
		int g = calcArea(1,2);JOptionPane.showMessageDialog(null,"\n\nLa sentencia; int g = calcArea(); " +
                                           "\nError: method calcArea in entregaP42 cannot be applied to given types;Required: int,int;Found: int;Reason: actual and formal arguments lists differ in length" +
                                           "\nExplicación: nos Dice que se le ha proporcionado ningun argumento y el metodo necesita dos;Ademas de que llama a un método no estático" +
                                           "\nSolución: Poner static al metodo calcArea() y añadir dos argumento enteros");
        calcArea(1,2);JOptionPane.showMessageDialog(null,"La sentencia; calcArea(); " +
                                           "\nError: method calcArea in entregaP42 cannot be applied to given types;Required: int,int;Found: int;Reason: actual and formal arguments lists differ in length" +
                                           "\nExplicación: nos Dice que se le ha proporcionado ningun argumento y el metodo necesita dos;Ademas de que llama a un método no estático" +
                                           "\nSolución: Poner static al metodo calcArea() y añadir dos argumento enteros");
        @SuppressWarnings("unused")
		int h = calcArea(4, 20);JOptionPane.showMessageDialog(null,"La sentencia: byte h = calcArea(4, 20); " + 
                                           "\nError: non-static metod calcArea(int, int) cannot xbe referenced from a static context" +
                                           "\nExplicación: nos dice que hay que no se puede hacer una referencia estatica a un metodo no estatico aunque se le pasen sus dos argumentos" +
                                           "\nSolución: Poner static al metodo calcArea()");
        @SuppressWarnings("unused")
		int j = calcArea(2, 3);JOptionPane.showMessageDialog(null,"\n\nLa sentencia: int j = calcArea(2, 3, 5);" +
                                           "\nError: method calcArea in entregaP42 cannot be applied to given types;Required: int,int;Found: int,int,int;Reason: actual and formal arguments lists differ in length" +
                                           "\nEplicación: Nos Dice que se le ha proporcionadotres argumentos y el metodo necesita dos;Ademas de que llama a un método no estático" +
                                           "\nSolución: Poner static al metodo calcArea() y añadir un argumento entero\n");
        JOptionPane.showMessageDialog(null,a + "-");        
    }
    static int calcArea(int height, int width) {
        return height * width;
    }
}
