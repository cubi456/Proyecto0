package Grafica.Bloques;

import javax.swing.ImageIcon;

public class ParedDesctGrafico extends BloqueGrafico {

	public ParedDesctGrafico(int px, int py){
		super(px, py);
		imagen= new ImageIcon(this.getClass().getResource("../Sprites/Destructible.png"));
	}
	
	public void seDestruyo(){
		imagen= new ImageIcon(this.getClass().getResource("../Sprites/Piso.png")); 
		
	}
}
