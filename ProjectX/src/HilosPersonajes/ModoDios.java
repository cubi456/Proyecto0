package HilosPersonajes;

import Logica.Jugador.Bomberman;

public class ModoDios extends Thread
{
	private volatile boolean stop;
	private Bomberman b;
	
	public ModoDios (Bomberman b)
	{
		this.b=b;
		stop=false;
	}
	
	public void run()
	{
		while(!stop)
		{
			b.Dios();
			try {
				//Subido a 8 segundos para mejorar la jugabilidad
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			b.Dios();
			this.destruir();
		}
	}
	
	public void destruir()
	{
		this.stop=true;
	}
	
}
