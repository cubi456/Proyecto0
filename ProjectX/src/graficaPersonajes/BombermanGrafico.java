package graficaPersonajes;

import javax.swing.ImageIcon;

public class BombermanGrafico extends PersonajeGrafico {

	public BombermanGrafico(int px, int py, int v) {
		super(px, py, v);

		this.imagen[0] = new ImageIcon(this.getClass().getResource("/Sprites/Bman_L_f00"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/BattleCity/Bman_F_f00"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/BattleCity/Bman_R_f00"));
		this.imagen[3] = new ImageIcon(this.getClass().getResource("/BattleCity/Bman_B_f00"));
	}

}
