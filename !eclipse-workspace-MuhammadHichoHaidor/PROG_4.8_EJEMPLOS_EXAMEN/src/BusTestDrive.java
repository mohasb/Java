
public class BusTestDrive
{
  public static void main(String[] args) {
      Bus m1 = new Bus();
      Bus m2 = new Bus();
      Bus m3 = new Bus();
      m1.asientos = 65;
      m2.asientos = 65;
      System.out.println("Bus 3: " + m3.asientos);
      m3 = m2;
      if (m1.asientos == m2.asientos) {
          System.out.println("Bus 1");
      }
      if (m1 == m2) {
          System.out.println("Bus 2");
      }
      if (m2 == m3) {
          System.out.println("Bus 3");
      }
      Bus m4 = null;
      m3 = m4;
      m1 = m2;
      m2 = null;
  }
}
