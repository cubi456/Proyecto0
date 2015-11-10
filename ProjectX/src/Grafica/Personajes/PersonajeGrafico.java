package Grafica.Personajes;

import java.awt.Point;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.JLabel;

import Grafica.AnimacionBomberman;

public abstract class PersonajeGrafico{
	protected JLabel grafico;
	protected Vector<Vector<Icon>> sprites;
	protected final int ancho= 32;
	protected final int alto= 32;
	protected int velocidad;
	protected Point pos;
	
	protected PersonajeGrafico(int v, int x, int y){
		this.velocidad=v;
		pos = new Point(ancho * x, alto * y);
		sprites = new Vector<Vector<Icon>>();
				
	}
	public int getVelocidad(){
		return velocidad;
	}
	
	public void cambiarDirec(int dir)
	{
		// La logica le pasa la direccion donde se va a mover
			grafico.setIcon(sprites.elementAt(dir).elementAt(0));
	}
	
	
	public void mover(int direccion)
	{
		AnimacionBomberman animacion=new AnimacionBomberman(direccion,this);
		animacion.start();
	}
	
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(sprites.elementAt(3).elementAt(0)); // Comienza de enfrente
			this.grafico.setBounds(pos.x , pos.y, ancho, alto);
		}
		
		return this.grafico;
	}
	
	public void morir()
	{
		if(this.grafico != null)
		{
			AnimacionBomberman animacion = new AnimacionBomberman(4,this);
			animacion.start();
	    }
	}
	
	public Vector<Vector<Icon>> getSprites()
	{
		return sprites;
	}
	
	public void setVelocidad(int vel)
	{
		velocidad=vel;
	}
	
	public Point getPos()
	{
		return pos;
	}
	//ISB puede ser abstracto
	public void cambiarA(int i){
		//se redefinira para las clases que lo necesitan
	}

}