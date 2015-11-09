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
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			b.Dios();
			this.detener();
		}
	}
	
	public void detener()
	{
		this.stop=true;
		this.interrupt();
	}
	
}
