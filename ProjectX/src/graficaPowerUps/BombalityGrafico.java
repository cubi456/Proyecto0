package graficaPowerUps;

import javax.swing.ImageIcon;

public class BombalityGrafico extends PowerUpGrafico{
	public BombalityGrafico(int px, int py){
		super(px,py);
		imagen=new ImageIcon(this.getClass().getResource("/Sprites/PU_Bombality.png"));
	}
}