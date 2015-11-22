package Grafica.Bloques;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ParedDesctGrafico extends BloqueGrafico {
	protected Icon[] bloque; 
	public ParedDesctGrafico(int px, int py){
		super(px, py);
		bloque=new Icon[5];
		for(int i=0; i<5;i++)
		bloque[i]=new ImageIcon(this.getClass().getResource("../Sprites/Bloque/Destructible0"+i+".png"));
		imagen= bloque[0];// pone el bloque comun
	}
	
	public void destruir(){
		for(int i=0; i<5;i++){
			this.getGrafico().setIcon(bloque[i]);
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		imagen= new ImageIcon(this.getClass().getResource("../Sprites/Bloque/Piso.png")); 
		this.getGrafico().setIcon(imagen);
	}
}
