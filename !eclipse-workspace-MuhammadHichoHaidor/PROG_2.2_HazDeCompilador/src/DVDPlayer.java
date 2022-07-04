
public class DVDPlayer
{
   boolean canRecord = false;
   
   void recordDVD() {
       System.out.println("DVD recording");
   }
   //El método de abajo es el que faltaba y por eso no compilaba
   void playDVD() { 
       System.out.println("DVD playing");
   }
}
