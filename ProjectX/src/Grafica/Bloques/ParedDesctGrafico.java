package Grafica.Bloques;

import javax.swing.Icon;

import Grafica.CargadorGrafico;

/**
 *@author Barreix, Iñaki.
 *@author Comellas, Juan Manuel.
 *@version 1.0
 */

public class ParedDesctGrafico extends BloqueGrafico {
	protected Icon[] bloque; 
	protected Icon imgAux;
	/**
	 * Crea el ParedDestructible donde le pasaran en que poscion se lo debe asignar
	 * @param px ubicacion horizontal
	 * @param py ubicacion vertial
	 */
	public ParedDesctGrafico(int px, int py, CargadorGrafico cg){
		super(px, py);
		bloque=cg.getBDestAnimacion();
		imagen= bloque[0];// pone el bloque comun
		imgAux=cg.getBSuelo();
	}
	/**
	 * Genera una pequeña animacion en la destruccion de pared 
	 */
	public void destruir(){
		for(int i=0; i<5;i++){
			this.getGrafico().setIcon(bloque[i]);
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		imagen=imgAux;
		this.getGrafico().setIcon(imagen);
	}
}
