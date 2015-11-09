package HilosPersonajes;

import Logica.Enemigos.Enemigo;

public class EnemigoThread extends Thread {
	private Enemigo rLogic;
	private volatile boolean rStop;
	private volatile int vel;
	
	public EnemigoThread(Enemigo r,int v){
		rLogic=r;
		rStop=false; 
		vel=v;
		//Bandera que indica cuando debe detenerse la ejecución del hilo.
	}
	
	
	public void run(){
		while(!rStop){
			try {
				Thread.sleep(vel); //cada un segundo
				rLogic.moverConInteligencia();
				Thread.sleep(500);
			} catch (InterruptedException e) { }
		}
	}
	
	/**
	 * Detiene el hilo de ejecucion por ejemplo para cuando muere un personaje
	 * 
	 */
	public void destruir() {
		rStop=true;
		this.interrupt();
	}


		
}