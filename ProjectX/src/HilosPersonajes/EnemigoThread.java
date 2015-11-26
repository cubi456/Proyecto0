package HilosPersonajes;

import Logica.Enemigos.Enemigo;

public class EnemigoThread extends Thread {
	private Enemigo rLogic;
	private volatile boolean rStop;
	
	public EnemigoThread(Enemigo r){
		rLogic=r;
		rStop=false; 
		//Bandera que indica cuando debe detenerse la ejecución del hilo.
	}
	
	
	public void run(){
		while(!rStop){
				rLogic.mover(0);
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