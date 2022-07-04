
public class Clock
{
  String time;
  public void setTime(String t) {
      time = t;
  }
  //un método get con retotno no puede ser void;hay que añadir el tipo de retorno y poner que es público
  public String getTime() {
      return time;
  }
}
