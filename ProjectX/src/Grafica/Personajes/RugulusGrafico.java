package Grafica.Personajes;

import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class RugulusGrafico extends PersonajeGrafico {

	public RugulusGrafico(int v, int px, int py) {
		super(v, px, py);
		
		
			this.sprites.addElement(new Vector<Icon>());
			this.sprites.lastElement().add(new ImageIcon(this.getClass().getResource("../Sprites/Rugulus_L_f00.png")));
			this.sprites.addElement(new Vector<Icon>());
			this.sprites.lastElement().add(new ImageIcon(this.getClass().getResource("../Sprites/Rugulus_B_f00.png")));
			this.sprites.addElement(new Vector<Icon>());
			this.sprites.lastElement().add(new ImageIcon(this.getClass().getResource("../Sprites/Rugulus_R_f00.png")));
			this.sprites.addElement(new Vector<Icon>());
			this.sprites.lastElement().add(new ImageIcon(this.getClass().getResource("../Sprites/Rugulus_F_f00.png")));
			this.sprites.addElement(new Vector<Icon>());
			this.sprites.lastElement().add(new ImageIcon(this.getClass().getResource("../Sprites/Rugulus_L_f00.png")));
			
	}

}
