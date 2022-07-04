
public class TapeDeckTestDrive
{
   public static void main(String[] args) {
       
       TapeDeck t = new TapeDeck();   //Faltaba la creación del objeto 't'
       t.canRecord = true;
       t.playTape();
       
       if (t.canRecord == true) {
           t.recordTape();
       }
   }
}
