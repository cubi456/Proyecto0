package HilosPersonajes;

import java.util.Vector;

import javax.swing.Icon;

import Grafica.GUI;
import Grafica.Personajes.PersonajeGrafico;

public class BombermanThread extends Thread 
{
	private GUI gui;
	private volatile boolean stop=false;
	private volatile int dir;
	private PersonajeGrafico p;
	int vel;
	
	public BombermanThread(GUI gui,PersonajeGrafico pj,int vel)
	{
		this.gui=gui;
		p=pj;
		dir=3;
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
	
	public void duplicarVel()
	{
		//Para duplicar la velocidad el atributo vel
		//debería estar dividido por 2. Se dividio por
		//un número más grande para que se note el efecto.
		vel=vel/2;
	}

	
	public void setDir(int i)
	{
		dir=i;
	}
	
}
