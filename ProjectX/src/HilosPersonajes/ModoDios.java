package HilosPersonajes;

import Logica.Jugador.Bomberman;
import Sonidos.Sonido;

public class ModoDios extends Thread
{
	private volatile boolean stop;
	private Bomberman b;
	private Sonido sonido;
	
	public ModoDios (Bomberman b, Sonido s)
	{
		this.b=b;
		stop=false;
		sonido=s;
	}
	
	public void run()
	{
		
		while(!stop)
		{
			b.Dios();
			if(!b.getJuego().getGui().getSilencio())
				sonido.reproducir();
			try {
				//Subido a 8 segundos para mejorar la jugabilidad
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			b.Dios();
			if(!b.getJuego().getGui().getSilencio())
				sonido.detener();
			this.destruir();
		}
	}
	
	public void destruir()
	{
		this.stop=true;
	}
	
}
