import java.lang.Math;
public class Circulo
{
    private double radio;
    public void setRadio(double radio) {
        this.radio = radio;
    }
    public double getRadio() {
        return radio;
    }
    double getArea() {
        double area = Math.PI * (Math.pow(getRadio(), 2));
        return area;
    }
    double getPerimetro() {
        double perimetro = 2 * Math.PI * getRadio();
        return perimetro;
    }
}
