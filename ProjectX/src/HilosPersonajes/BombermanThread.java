package HilosPersonajes;

import Grafica.GUI;

public class BombermanThread extends Thread 
{
	private GUI gui;
	private volatile boolean stop=false;
	int vel=100;
	
	public BombermanThread(GUI gui)
	{
		this.gui=gui;
	}
	
	public void run()
	{
		while(!stop)
		{
			try {
				Thread.sleep(vel);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(gui.getLock()){
				gui.detectarOpciones(gui.getDireccion());
				gui.toggleLock();
		    }
			else
				gui.detectarOpciones(gui.getDireccion());
	}
 }
	public void destruir()
	{
		this.stop=true;
	}
	
	public void dublicarVel()
	{
		vel=vel/100;
	}
}
