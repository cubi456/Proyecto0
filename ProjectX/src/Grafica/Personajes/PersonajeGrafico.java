package Grafica.Personajes;

import java.awt.Point;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.JLabel;


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
		if(direccion==4)
			muerte();
		else
			{
				int mov=2;
				for(int j=0;j<2;j++){
					movimientoGrafico(direccion, mov);
				}
				grafico.setIcon(sprites.elementAt(direccion).elementAt(0));
			}
	}
	
	private void movimientoGrafico(int direccion, int mov){
		for(Icon i:sprites.elementAt(direccion)){
			switch(direccion){
			case 0:
				pos.setLocation(pos.getX()-mov,pos.getY());
				break;
			case 1:
				pos.setLocation(pos.getX(), pos.getY()-mov);
				break;
			case 2:
				pos.setLocation(pos.getX()+mov,pos.getY());
				break;
			case 3:
				pos.setLocation(pos.getX(),pos.getY()+mov);
				break;	
			}
		  		grafico.setIcon(i);
		  		grafico.setBounds(pos.x ,pos.y,ancho,alto);
		  		try {
					Thread.sleep(velocidad/(sprites.elementAt(direccion).size()*2));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	  	}
	}
	private void muerte(){
		 for(Icon i:sprites.elementAt(4))
	  	 {
	  		 grafico.setIcon(i);
	  		 try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  	 }
	  	 grafico.setIcon(null);
	}
	public JLabel getGrafico()
	{
		return this.grafico;
	}
	
	public void morir()
	{
		if(this.grafico != null)
		{
			this.mover(4);
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
	
	public abstract void cambiarA(int i);
		//Solo redifinira Bomberman en modo Dios
		//se redefinira para las clases que lo necesitan

}