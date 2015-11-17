package HilosPersonajes;

import Logica.Enemigos.Enemigo;

public class EnemigoThread extends Thread {
	private Enemigo rLogic;
	private volatile boolean rStop;
	
	public EnemigoThread(Enemigo r){
		rLogic=r;
		rStop=false; 
		//Bandera que indica cuando debe detenerse la ejecuci�n del hilo.
	}
	
	
	public void run(){
		while(!rStop){
			//try {
				//Thread.sleep(vel); 
				rLogic.mover(0);
			//} catch (InterruptedException e) { }
		}
	}
	
	/**
	 * Detiene el hilo de ejecucion por ejemplo para cuando muere un personaje
	 * 
	 */
	public void destruir() {
		this.interrupt();
		rStop=true;
	}


		
}