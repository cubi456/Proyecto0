package graficaPersonajes;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.JLabel;

public abstract class PersonajeGrafico{
	protected JLabel grafico;
	protected Icon imagen[];
	protected final int ancho= 32;
	protected final int alto= 32;
	protected int velocidad;
	protected Point pos;
	
	protected PersonajeGrafico(int v, int x, int y){
		this.velocidad=v;
		pos = new Point(ancho * x, alto * y);
		imagen= new Icon[4];
	}
	public int getVelocidad(){
		return velocidad;
	}
	
	public void cambiarDirec(int dir){
		// La logica le pasa la direccion donde se va a mover
		grafico.setIcon(this.imagen[dir]);
	}
	
	public void mover(int direccion) {
		switch (direccion) {
			case 0 : // Left
				pos.setLocation(pos.x - ancho, pos.y);
				grafico.setBounds(pos.x, pos.y, ancho, alto);
				break;
			case 1 : // UP
				pos.setLocation(this.pos.x, this.pos.y - alto);
				grafico.setBounds(pos.x, pos.y, ancho, alto);
				break;
			case 2 :  // Right
				pos.setLocation(pos.x + ancho, pos.y);
				grafico.setBounds(pos.x, pos.y, ancho, alto);
				break;
			case 3 : // Down
				pos.setLocation(pos.x, pos.y + alto);
				grafico.setBounds(pos.x, pos.y, ancho, alto);
				break;
		}
	}
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(imagen[3]); // Comienza de enfrente
			this.grafico.setBounds(pos.x , pos.y, ancho, alto);
		}
		
		return this.grafico;
	}

}