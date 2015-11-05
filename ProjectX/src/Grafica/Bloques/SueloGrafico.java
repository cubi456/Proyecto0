package Grafica.Bloques;

import javax.swing.ImageIcon;

public class SueloGrafico extends BloqueGrafico{
	public SueloGrafico(int px, int py){
		super(px,py);
		imagen=new ImageIcon(this.getClass().getResource("../Sprites/Piso.png"));
	}
	
}
