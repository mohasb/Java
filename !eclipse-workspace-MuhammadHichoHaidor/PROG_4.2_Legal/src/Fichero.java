
public class Fichero
{
  public static void main(String[] args) {
		
		int a = calcArea (7, 12);
		short c = 7;
		calcArea(c, 15);
		int d = calcArea(57, 12);
		calcArea (2, 3);
		int t = 42;
		int f = calcArea(t, 17);
		int g =  calcArea(4, 6);
		calcArea(7, 8);
		int h = calcArea(4, 20);
		int j = calcArea(2, 3);
		
		
		
		
		System.out.println(a);
		System.out.println(c);
		System.out.println(d);
		System.out.println(t);
		System.out.println(f);
		System.out.println(g);
		System.out.println(h);
		System.out.println(j);

  }
    static int calcArea(int heigth, int width) {
		return heigth * width;
  } 
}
