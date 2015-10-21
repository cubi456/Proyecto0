package GraficaBloques;

import javax.swing.ImageIcon;

public class ParedSolidaGrafico extends BloqueGrafico{
	
	public ParedSolidaGrafico(int px, int py){
		super(px, py);
		imagen= new ImageIcon(this.getClass().getResource("/Sprites/ParedSolida.png"));
	}

}
