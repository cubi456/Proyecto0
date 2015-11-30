package Grafica.Bloques;

import Grafica.CargadorGrafico;

/**
 *@author Barreix, Iñaki.
 *@author Comellas, Juan Manuel.
 *@version 1.0
 */
public class ParedSolidaGrafico extends BloqueGrafico{
	/**
	 * Crea el ParedSolida donde le pasaran en que poscion se lo debe asignar
	 * @param px ubicacion horizontal
	 * @param py ubicacion vertial
	 */
	public ParedSolidaGrafico(int px, int py, CargadorGrafico cg){
		super(px, py);
		imagen= cg.getBInd();
	}
	/**
	 * En esta implementación no hace nada el suelo si se destruye
	 */
	public void destruir(){
		
	}

}
