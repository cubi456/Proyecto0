package graficaPowerUps;

import javax.swing.ImageIcon;

public class SpeedUpGrafico extends PowerUpGrafico{
	public SpeedUpGrafico(int px, int py){
		super(px,py);
		imagen=new ImageIcon(this.getClass().getResource("/Sprites/PU_Speedup.png"));
	}
}
