package Grafica;

import Grafica.Bomba.FuegoGrafico;
import Logica.Bloques.Celda;

public class AnimacionFuego extends Thread
{
	protected Celda c;
	protected int alc;
	protected FuegoGrafico fg;
	protected GUI g;
	private volatile boolean stop;
	public AnimacionFuego(Celda c,GUI g)
	{
		this.c=c;
		this.g = g;
		stop=false;
		fg=new FuegoGrafico(c.getX(),c.getY());
		this.g.getContenedor().add(fg.getGrafico(),2);
	}
	
	public void run()
	{
		
		while(!stop)
		{
			c.setFuego(true);
			fg.iniciar();
			c.setFuego(false);
			g.remove(fg.getGrafico());
			g.repaint();
			fg=null;
			this.detener();
		}
	}
	
	public void detener()
	{
		stop=true;
	}
}
