package Grafica.PowerUps;

import javax.swing.ImageIcon;

public class SpeedUpGrafico extends PowerUpGrafico{
	public SpeedUpGrafico(){
		super();
		imagen=new ImageIcon(this.getClass().getResource("../Sprites/PU/PU_Speedup.png"));
	}
}
