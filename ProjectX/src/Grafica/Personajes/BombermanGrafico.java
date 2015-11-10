package Grafica.Personajes;

import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class BombermanGrafico extends PersonajeGrafico {

	public BombermanGrafico(int v, int px, int py) {
		super(v, px, py);
		sprites=cargarNormal();
			
	}
	
	public void cambiarA(int i){
		//Redefine
		//0 cambiar a Dios
		if(i==0)		
			sprites=cargarDios();
		else{// carga normal
			sprites=cargarNormal();
		}
	}
	
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
