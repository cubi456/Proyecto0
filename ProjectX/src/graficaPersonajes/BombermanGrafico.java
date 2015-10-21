package graficaPersonajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BombermanGrafico extends PersonajeGrafico {

	public BombermanGrafico(int px, int py, int v) {
		super(px, py, v);

		this.imagen[0] = new ImageIcon(this.getClass().getResource("/Sprites/BmanL.png"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("/Sprites/BmanF.png"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("/Sprites/BmanR.png"));
		this.imagen[3] = new ImageIcon(this.getClass().getResource("/Sprites/BmanB.png"));
	}

}
