
public class Ejercicio1_4_2
{
    public static void main(String []args){
        
        final int SEG=8432100;
        int auxSeg=0;
        int auxMin=0;
        int auxHora=0;
        int auxDia=0;
        int auxMes=0;
        int auxAno=0;

        
        for (int i=0;i<=SEG;i++){
            auxSeg++;
            if(auxSeg==60)
            {
                auxMin++;
                auxSeg=0;   
            }        
            if(auxMin==60)
            {
                auxHora++;
                auxMin=0;
            }
            if(auxHora==24)
            {
                auxDia++;
                auxHora=0;
            }
            if(auxDia==30)
            {
                auxMes++;
                auxDia=0;
            }
            if(auxMes==12)
            {
                auxAno++;
                auxMes=0;
            }
        }
     System.out.println("Años: "+auxAno+ "\nMeses: "+auxMes+"\nDias: "+auxDia+"\nHora: "+auxHora + "\nMinutos: "+auxMin+ "\nSegungos: " +auxSeg);
     
    }
}
