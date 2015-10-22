package Grafica.PowerUps;

import javax.swing.Icon;
import javax.swing.JLabel;

public abstract class PowerUpGrafico {
	protected JLabel grafico;
	protected Icon imagen;
	protected final int ancho = 32;
	protected final int alto = 32;
	protected int x,y;
	
	protected PowerUpGrafico(){
		this.x=0;
		this.y=0;
	}
	
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(imagen);
			this.grafico.setBounds(x * ancho, y* alto, ancho, alto);
		}
		
		return this.grafico;
	}
	public void setPos(int px, int py)
	{
		x=px;
		y=py;
	}
}

