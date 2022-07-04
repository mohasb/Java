
public class Puzzle4b
{
      int ivar;
      public int doStuff(int factor) {
          if (ivar > 100) {
              return ivar * factor;
          }
          return ivar * (5-factor);
      }
}
