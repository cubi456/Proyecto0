package graficaPersonajes;

import javax.swing.ImageIcon;

public class RugulusGrafico extends PersonajeGrafico {

	public RugulusGrafico(int px, int py, int v) {
		super(px, py, v);
		
		this.imagen[0] = new ImageIcon(this.getClass().getResource("/Sprites/Rugulus_L_f00.png"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/Sprites/Rugulus_B_f00.png"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/Sprites/Rugulus_R_f00.png"));
		this.imagen[3] = new ImageIcon(this.getClass().getResource("/Sprites/Rugulus_F_f00.png"));
	}

}
