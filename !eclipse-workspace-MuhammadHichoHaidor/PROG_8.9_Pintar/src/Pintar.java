
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Pintar extends JPanel{
	

	private static final long serialVersionUID = 1L;
	private int r = 0;
	private int g = 0;
	private int b = 0;
	
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	public int getG() {
		return g;
	}
	public void setG(int g) {
		this.g = g;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	
	public Pintar() {
			
	}

	public void paintComponent(Graphics g){
		 //Establezco el color
		 g.setColor(new Color(getR(), getG(), getB()));
		 //pinto componente
		 g.fillRect(0, 0, getWidth(), getHeight());
	 }

}
