package Grafica.Personajes;

import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class AltairGrafico extends PersonajeGrafico {

	public AltairGrafico(int v, int px, int py) {
		super(v, px, py);

			this.sprites.addElement(new Vector<Icon>());
			for(int i=0;i<=7;i++)
			{
				this.sprites.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Sprites/Altair/Left/Left0"+i+".png")));
			}
			this.sprites.addElement(new Vector<Icon>());
			for(int i=0;i<=7;i++)
			{
				this.sprites.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Sprites/Altair/UP/UP0"+i+".png")));
			}
			this.sprites.addElement(new Vector<Icon>());
			for(int i=0;i<=7;i++)
			{
				this.sprites.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Sprites/Altair/Right/Right0"+i+".png")));
			}
			this.sprites.addElement(new Vector<Icon>());
			for(int i=0;i<=7;i++)
			{
				this.sprites.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Sprites/Altair/Down/Down0"+i+".png")));
			}
			this.sprites.addElement(new Vector<Icon>());
			for(int i=0;i<5;i++)
			{
				this.sprites.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Sprites/Altair/Dead/Dead0"+i+".png")));
			}
			this.grafico = new JLabel(sprites.elementAt(3).elementAt(0)); // Comienza de enfrente
			this.grafico.setBounds(pos.x , pos.y, ancho, alto);
	}

}
