package Grafica.Personajes;

import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class SiriusGrafico extends PersonajeGrafico {

	public SiriusGrafico(int v, int px, int py) {
		super(v, px, py);

			this.sprites.addElement(new Vector<Icon>());
			for(int i=0;i<=7;i++)
			{
				this.sprites.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Sprites/Sirius/Left/Left0"+i+".png")));
			}
			this.sprites.addElement(new Vector<Icon>());
			for(int i=0;i<=7;i++)
			{
				this.sprites.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Sprites/Sirius/UP/UP0"+i+".png")));
			}
			this.sprites.addElement(new Vector<Icon>());
			for(int i=0;i<=7;i++)
			{
				this.sprites.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Sprites/Sirius/Right/Right0"+i+".png")));
			}
			this.sprites.addElement(new Vector<Icon>());
			for(int i=0;i<=7;i++)
			{
				this.sprites.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Sprites/Sirius/Down/Down0"+i+".png")));
			}
			this.sprites.addElement(new Vector<Icon>());
			for(int i=0;i<5;i++)
			{
				this.sprites.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Sprites/Sirius/Dead/Dead0"+i+".png")));
			}
	}

}
