
public class Examenes
{
    public static void main(String[] args) {
        Convocatoria c = new Convocatoria();
        c.setCodConvocatoria(139);
        c.setIdioma("Ingles");
        c.setNumCandidatos(2);
        c.setCodConvocatoria(-1);
        c.setNumCandidatos(0);
        Candidato[] candidatos = new Candidato[c.getNumCandidatos()];
        System.out.println("Convocatoria " + c.getCodConvocatoria() + ": " + c.getIdioma() +
        "\n Nº candidatos: " + c.getNumCandidatos() + " Está completada: " + c.completado() +
         "\n Resultado: " + Candidato.resultado(140));
         
         for (int i = 0; i < candidatos.length; i++) {
              candidatos[i] = new Candidato();
              candidatos[i].obtenDatos();
         }
         for (int j = 0; j < candidatos.length; j++) {
             System.out.println(candidatos[j].getNombre() + candidatos[j].getDni() + candidatos[j].getTelefono());
         }
    }
}
