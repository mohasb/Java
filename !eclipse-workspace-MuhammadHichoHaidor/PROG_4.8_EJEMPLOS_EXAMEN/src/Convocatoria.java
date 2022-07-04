
public class Convocatoria
{
   private int codConvocatoria;
   private String idioma;
   private int numCandidatos = 0;
   private boolean completada;
   
   public void setCodConvocatoria(int codConvocatoria) {
       if (codConvocatoria < 0) {
           return;
       }else {
          this.codConvocatoria = codConvocatoria; 
       }
   }
   public int getCodConvocatoria() {
       return codConvocatoria;
   }
   public void setIdioma(String idioma) {
       this.idioma = idioma;
   }
   public String getIdioma() {
       return idioma;
   }
   public void setNumCandidatos(int numCandidatos) {
       if (numCandidatos <= 0) {
           return;
       }else {
            this.numCandidatos = numCandidatos;
       }
   }
   public int getNumCandidatos() {
       return numCandidatos;
   }
   public void setCompletada(boolean completada) {
       this.completada = completada;
   }
   public boolean getCompletada() {
       return completada;
   }
   public String completado() {
       String completado;
       if (completada == true) {
           completado = "La convocatoria está completada";
       }else {
           completado = "La convocatoria está por completar";
       }
       return completado;
   }
}
