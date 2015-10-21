package graficaPowerUps;

import javax.swing.ImageIcon;

public class FatalityGrafico extends PowerUpGrafico{
	public FatalityGrafico(int px, int py){
		super(px,py);
		imagen=new ImageIcon(this.getClass().getResource("/Sprites/PU_Fatality.png"));
	}
}