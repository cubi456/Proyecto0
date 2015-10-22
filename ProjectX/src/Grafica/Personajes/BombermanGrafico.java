package Grafica.Personajes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BombermanGrafico extends PersonajeGrafico {

	public BombermanGrafico(int v, int px, int py) {
		super(v, px, py);

		this.imagen[0] = new ImageIcon(this.getClass().getResource("../Sprites/BmanL.png"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("../Sprites/BmanB.png"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("../Sprites/BmanR.png"));
		this.imagen[3] = new ImageIcon(this.getClass().getResource("../Sprites/BmanF.png"));
		this.imagen[4] = new ImageIcon(this.getClass().getResource("../Sprites/BmanDead.png"));
	}

}
