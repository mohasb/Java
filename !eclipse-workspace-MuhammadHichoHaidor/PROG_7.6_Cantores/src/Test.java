
public class Test
{
    public static void main(String[] ags) {
                                                    //No polimorfico
        Cantante carreras = new Cantante();
        Canario piolin = new Canario();
        Gallo claudio = new Gallo();
        
        carreras.cantar();
        piolin.cantar();
        claudio.cantar();
        
                                                    //Polimorfico
        /*Persona carreras = new Cantante();
        Animal piolin = new Canario();
        Animal claudio = new Gallo();
        //casting
        Cantante c = (Cantante) carreras;
        Canario cro = (Canario) piolin;
        Gallo gllo = (Gallo) claudio;

        c.cantar();
        cro.cantar();
        gllo.cantar();*/
                                                    //Array Polimorfico
                                                    
        /*ArrayList<PuedeCantar> lista = new ArrayList<PuedeCantar>();

        Cantante carreras = new Cantante();
        Canario piolin = new Canario();
        Gallo claudio = new Gallo();
        
        lista.add(carreras);
        lista.add(piolin);
        lista.add(claudio);*/
        
        
        
        
        
        /*Pruebas
        System.out.println(lista.size());
        System.out.println(lista.contains(carreras));
        System.out.println(lista.isEmpty());
        lista.remove(carreras);
        System.out.println(lista.size());
        lista.add(carreras);
        Object o = lista.get(1);
        System.out.println(o.toString());*/
    }
}
