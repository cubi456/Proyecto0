package HilosPersonajes;


import Grafica.GUI;
import Grafica.Personajes.PersonajeGrafico;

public class BombermanThread extends Thread 
{
	private GUI gui;
	private volatile boolean stop=false;
	int vel;
	
	public BombermanThread(GUI gui,int vel)
	{
		this.gui=gui;
		this.vel=vel;
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
				gui.detectarOpciones(gui.getDireccion());
				gui.toggleLock();
		    
	}
 }
	public void destruir()
	{
		this.interrupt();
		this.stop=true;
	}
	
	public void duplicarVel()
	{
		//Para duplicar la velocidad el atributo vel
		//debería estar dividido por 2. Se dividio por
		//un número más grande para que se note el efecto.
		vel=vel/16;
	}
	
}
