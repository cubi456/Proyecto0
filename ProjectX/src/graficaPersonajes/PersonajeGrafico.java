package graficaPersonajes;

import javax.swing.Icon;
import javax.swing.JLabel;

public abstract class PersonajeGrafico{
	protected JLabel grafico;
	protected Icon imagen[];
	protected final int ancho= 32;
	protected final int alto= 32;
	protected int velocidad, x, y;
	protected PersonajeGrafico(int px, int py, int v){
		this.x=px;
		this.y=py;
		this.velocidad=v;
		imagen= new Icon[4];
	}
	public int getVelocidad(){
		return velocidad;
	}
	
	public void cambiarDirec(int dir){
		// La logica le pasa la direccion donde se va a mover
		grafico.setIcon(this.imagen[dir]);
		
		/* 0 izq
		 * 1 up
		 * 2 der
		 * 3 down
		 */
	}
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(imagen[1]); // Comienza de enfrente
			this.grafico.setBounds(x*ancho , y*alto, ancho, alto);
		}
		
		return this.grafico;
	}

}