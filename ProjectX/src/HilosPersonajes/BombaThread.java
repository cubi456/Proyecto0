package HilosPersonajes;

import Logica.Bloques.Celda;
import Logica.Jugador.Bomba;

public class BombaThread extends Thread
{
	private volatile boolean stop=false;
	private Bomba b;
	private Celda ubicacion;
	private int alc;
	
	public BombaThread(Bomba b,Celda c,int a)
	{
		this.b=b;
		ubicacion=c;
		alc=a;
	}
	
	public void run()
	{
		while(!stop)
		{
			try {
				b.getGrafico().detonar(ubicacion,alc);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			b.explotar();
		}
	}
	
	public void destruir()
	{
		this.stop=true;
	}
}
