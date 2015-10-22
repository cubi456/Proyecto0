package HilosPersonajes;

import Logica.Jugador.Bomba;

public class BombaThread extends Thread
{
	private volatile boolean stop=false;
	private Bomba b;
	
	public BombaThread(Bomba b)
	{
		this.b=b;
	}
	
	public void run()
	{
		while(!stop)
		{
			try {
				this.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			b.explotar();
		}
	}
	
	public void destruir()
	{
		stop=true;
	}
}
