package hilosMalos;

import Logica.Rugulus;

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
				Thread.sleep(1000); //cada un segundo
				rLogic.mover();
			} catch (InterruptedException e) { }
		}
	}
	
	/**
	 * Detiene el hilo de ejecucion por ejemplo para cuando muere un personaje
	 * 
	 */
	public void destruir() {
		stopThread(); //	Detenemos el hilo
		rLogic.morir();	//avisamos a la logica
	}
	/**
	 *  Detiene el hilo de ejecucion.
	 */
	private void stopThread(){ 
			this.interrupt(); //interrumpimos el hilo para que no se vuelva a ejecutar
	    	rStop = true; // Detenemos la bandera para que no siga iterando
		
	}
		
}