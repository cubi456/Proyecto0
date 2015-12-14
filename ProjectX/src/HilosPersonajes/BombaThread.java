package HilosPersonajes;

import Logica.Bloques.Celda;
import Logica.Jugador.Bomba;

public class BombaThread extends Thread
{
	private volatile boolean stop=false;
	private Bomba b;
	private Celda ubicacion;
	private int alc;
	private boolean corte;
	
	public BombaThread(Bomba b,Celda c,int a)
	{
		this.b=b;
		ubicacion=c;
		alc=a;
		corte=false;
	}
	
	public void run()
	{
		while(!stop)
		{
			if(!corte){
				try {
					b.getGrafico().detonar(ubicacion,alc);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			b.explotar();
		}
	}
	
	public void destruir()
	{
		this.stop=true;
	}
	
	public void cortar(){
		corte=true;
	}
}
