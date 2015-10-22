package HilosPersonajes;

import Logica.Enemigos.Rugulus;

public class RugulusThread extends Thread {
	private Rugulus rLogic;
	private volatile boolean rStop;
	
	public RugulusThread(Rugulus r){
		rLogic=r;
		rStop=false; 
		//Bandera que indica cuando debe detenerse la ejecución del hilo.
	}
	
	
	public void run(){
		while(!rStop){
			try {
				Thread.sleep(500); //cada un segundo
				rLogic.moverConInteligencia();
			} catch (InterruptedException e) { }
		}
	}
	
	/**
	 * Detiene el hilo de ejecucion por ejemplo para cuando muere un personaje
	 * 
	 */
	public void destruir() {
		rStop=true;
	}


		
}