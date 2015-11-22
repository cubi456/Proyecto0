package Grafica.Bloques;

import javax.swing.ImageIcon;

public class ParedSolidaGrafico extends BloqueGrafico{
	
	public ParedSolidaGrafico(int px, int py){
		super(px, py);
		imagen= new ImageIcon(this.getClass().getResource("../Sprites/Bloque/ParedSolida.png"));
	}
	
	public void destruir(){
		
	}

}
