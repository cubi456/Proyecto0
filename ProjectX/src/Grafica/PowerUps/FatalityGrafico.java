package Grafica.PowerUps;

import javax.swing.ImageIcon;

public class FatalityGrafico extends PowerUpGrafico{
	public FatalityGrafico(){
		super();
		imagen=new ImageIcon(this.getClass().getResource("../Sprites/PU_Fatality.png"));
	}
}