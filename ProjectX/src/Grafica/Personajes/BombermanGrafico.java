package Grafica.Personajes;

import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class BombermanGrafico extends PersonajeGrafico {

	public BombermanGrafico(int v, int px, int py) {
		super(v, px, py);

			this.sprites.addElement(new Vector<Icon>());
			for(int i=0;i<=7;i++)
			{
				this.sprites.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Sprites/Bomberman/Left/Left0"+i+".png")));
			}
			this.sprites.addElement(new Vector<Icon>());
			for(int i=0;i<=7;i++)
			{
				this.sprites.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Sprites/Bomberman/UP/UP0"+i+".png")));
			}
			this.sprites.addElement(new Vector<Icon>());
			for(int i=0;i<=7;i++)
			{
				this.sprites.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Sprites/Bomberman/Right/Right0"+i+".png")));
			}
			this.sprites.addElement(new Vector<Icon>());
			for(int i=0;i<=7;i++)
			{
				this.sprites.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Sprites/Bomberman/Down/Down0"+i+".png")));
			}
			this.sprites.addElement(new Vector<Icon>());
			for(int i=0;i<5;i++)
			{
				this.sprites.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Sprites/Bomberman/Dead/Dead0"+i+".png")));
			}
	}

}
