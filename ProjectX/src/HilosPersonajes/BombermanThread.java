package HilosPersonajes;


import Grafica.GUI;
import Logica.Personaje;

public class BombermanThread extends Thread 
{
	private GUI gui;
	private Personaje p;
	private volatile boolean stop=false;
	
	public BombermanThread(GUI gui,Personaje pj)
	{
		this.gui=gui;
		p=pj;
	}
	
	public void run()
	{
		while(!stop)
		{
			
			if(gui.getLock())
			 	{
			 		p.mover(gui.getDireccion());
					gui.toggleLock();
			 	}
	}
 }
	public void destruir()
	{
		this.interrupt();
		this.stop=true;
	}
	
}
