package Grafica.Personajes;

import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BombermanGrafico extends PersonajeGrafico {
	/**
	 * Recibe los parametros px , py y setea la grafica en la celda correspondiente.
	 * El otro parametro es la velocidad, la cual sera utilizada para el corrimiento animado.
	 * @param px ubicacion horizontal del bloque
	 * @param py ubicacion vertical del bloque
	 */
	private Vector<Vector<Icon>> spritesDios, spritesAux;
	public BombermanGrafico(int v, int px, int py) {
		super(v, px, py);
		sprites=cargarNormal();
		spritesAux=sprites;
		spritesDios=cargarDios();
		this.grafico = new JLabel(sprites.elementAt(3).elementAt(0)); // Comienza de enfrente
		this.grafico.setBounds(pos.x , pos.y, ancho, alto);
	}
	/**
	 * cambia graficamente a bomberman, haciendolo del color puesto del estado en que esta(dios=azul),(normal=blanco)
	 */
	
	public void cambiarA(int i){
		//Redefine
		//0 cambiar a Dios
		if(i==0)		
			sprites=spritesDios;
		else{// carga normal
			sprites=spritesAux;
		}
	}
	/**
	 * Carga las imagenes pertenecientes a Bomberman en estado Normal
	 * @return Vector<Vector<Icon>> la coleccion de secuencia Normal
	 */
	
	private Vector<Vector<Icon>> cargarNormal(){
		Vector<Vector<Icon>> sp=new Vector<Vector<Icon>>();
		sp.addElement(new Vector<Icon>());
		for(int i=0;i<=7;i++)
			sp.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Sprites/Bomberman/Left/Left0"+i+".png")));
		sp.addElement(new Vector<Icon>());
		for(int i=0;i<=7;i++)
			sp.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Sprites/Bomberman/UP/UP0"+i+".png")));
		sp.addElement(new Vector<Icon>());
		for(int i=0;i<=7;i++)
			sp.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Sprites/Bomberman/Right/Right0"+i+".png")));
		sp.addElement(new Vector<Icon>());
		for(int i=0;i<=7;i++)
			sp.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Sprites/Bomberman/Down/Down0"+i+".png")));
		sp.addElement(new Vector<Icon>());
		for(int i=0;i<5;i++)
			sp.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Sprites/Bomberman/Dead/Dead0"+i+".png")));
		return sp;
	}
	/**
	 * Carga las imagenes pertenecientes a Bomberman en estado Dios
	 * @return Vector<Vector<Icon>> la coleccion de secuencia Dios
	 */
	private Vector<Vector<Icon>> cargarDios(){
		Vector<Vector<Icon>> spritesDios=new Vector<Vector<Icon>>();
		spritesDios.addElement(new Vector<Icon>());
		for(int i=0;i<=7;i++)
			spritesDios.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Sprites/Dios/Left/Left0"+i+".png")));
		spritesDios.addElement(new Vector<Icon>());
		for(int i=0;i<=7;i++)
			spritesDios.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Sprites/Dios/UP/UP0"+i+".png")));
		spritesDios.addElement(new Vector<Icon>());
		for(int i=0;i<=7;i++)
			spritesDios.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Sprites/Dios/Right/Right0"+i+".png")));
		spritesDios.addElement(new Vector<Icon>());
		for(int i=0;i<=7;i++)
			spritesDios.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Sprites/Dios/Down/Down0"+i+".png")));
		return spritesDios;
	}
}
