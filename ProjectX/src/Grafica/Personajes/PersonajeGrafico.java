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
		if(velocidad<1000)
			moverRapido(direccion);
		else
			moverLento(direccion);
	}
	
	
	private void moverLento(int direccion)
	{
		int mov;
		switch(direccion)
		{
		  case 0:
			    mov=2;
			    for(int j=0;j<2;j++){
			  	for(Icon i:sprites.elementAt(direccion))
		  		{
			  		pos.setLocation(pos.getX()-mov,pos.getY());
			  		grafico.setIcon(i);
			  		grafico.setBounds(pos.x ,pos.y,ancho,alto);
			  		try {
						Thread.sleep(velocidad/(sprites.elementAt(0).size()*2));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		  		}
			    }
			  	grafico.setIcon(sprites.elementAt(0).elementAt(0));
		  		break;
		  case 1:
			    mov=2;
			    for(int j=0;j<2;j++){
			  	for(Icon i:sprites.elementAt(direccion))
		  		{
			  		pos.setLocation(pos.getX(), pos.getY()-mov);
			  		grafico.setIcon(i);
			  		grafico.setBounds(pos.x ,pos.y,ancho,alto);
			  		try {
						Thread.sleep(velocidad/(sprites.elementAt(1).size()*2));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		  		}
			    }
			  	grafico.setIcon(sprites.elementAt(1).elementAt(0));
		  		break;
		  case 2:
			  	mov=2;
			  	for(int j=0;j<2;j++){
			  	for(Icon i:sprites.elementAt(direccion))
		  		{
			  		pos.setLocation(pos.getX()+mov,pos.getY());
			  		grafico.setIcon(i);
			  		grafico.setBounds(pos.x ,pos.y,ancho,alto);
			  		try {
						Thread.sleep(velocidad/(sprites.elementAt(2).size()*2));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		  		}
			  	grafico.setIcon(sprites.elementAt(2).elementAt(0));
			  	}
		  		break;
		  case 3:
			  mov=2;
			  for(int j=0;j<2;j++){
			  	for(Icon i:sprites.elementAt(direccion))
		  		{
			  		pos.setLocation(pos.getX(),pos.getY()+mov);
			  		grafico.setIcon(i);
			  		grafico.setBounds(pos.x ,pos.y,ancho,alto);
			  		try {
						Thread.sleep(velocidad/(sprites.elementAt(3).size()*2));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		  		}
			  }
			  	grafico.setIcon(sprites.elementAt(3).elementAt(0));
		  		break;
		  case 4: //Muerte
			  	 for(Icon i:sprites.elementAt(direccion))
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
			  	 break;
		}
	}
	
	private void moverRapido(int direccion)
	{
		int mov;
		switch(direccion)
		{
		  case 0:
			    mov=4;
			  	for(Icon i:sprites.elementAt(direccion))
		  		{
			  		pos.setLocation(pos.getX()-mov,pos.getY());
			  		grafico.setIcon(i);
			  		grafico.setBounds(pos.x ,pos.y,ancho,alto);
			  		try {
						Thread.sleep(velocidad/sprites.elementAt(0).size());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		  		}
			  	grafico.setIcon(sprites.elementAt(0).elementAt(0));
		  		break;
		  case 1:
			    mov=4;
			  	for(Icon i:sprites.elementAt(direccion))
		  		{
			  		pos.setLocation(pos.getX(), pos.getY()-mov);
			  		grafico.setIcon(i);
			  		grafico.setBounds(pos.x ,pos.y,ancho,alto);
			  		try {
						Thread.sleep(velocidad/sprites.elementAt(1).size());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		  		}
			  	grafico.setIcon(sprites.elementAt(1).elementAt(0));
		  		break;
		  case 2:
			  	mov=4;
			  	for(Icon i:sprites.elementAt(direccion))
		  		{
			  		pos.setLocation(pos.getX()+mov,pos.getY());
			  		grafico.setIcon(i);
			  		grafico.setBounds(pos.x ,pos.y,ancho,alto);
			  		try {
						Thread.sleep(velocidad/sprites.elementAt(2).size());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		  		}
			  	grafico.setIcon(sprites.elementAt(2).elementAt(0));
		  		break;
		  case 3:
			  mov=4;
			  	for(Icon i:sprites.elementAt(direccion))
		  		{
			  		pos.setLocation(pos.getX(),pos.getY()+mov);
			  		grafico.setIcon(i);
			  		grafico.setBounds(pos.x ,pos.y,ancho,alto);
			  		try {
						Thread.sleep(velocidad/sprites.elementAt(3).size());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		  		}
			  	grafico.setIcon(sprites.elementAt(3).elementAt(0));
		  		break;
		  case 4: //Muerte
			  	 for(Icon i:sprites.elementAt(direccion))
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
			  	 break;
		}
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
	//ISB puede ser abstracto
	public void cambiarA(int i){
		//se redefinira para las clases que lo necesitan
	}

}