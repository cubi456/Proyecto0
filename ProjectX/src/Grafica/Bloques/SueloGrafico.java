package Grafica.Bloques;


import Grafica.CargadorGrafico;

/**
 *@author Barreix, Iñaki.
 *@author Comellas, Juan Manuel.
 *@version 1.0
 */
public class SueloGrafico extends BloqueGrafico{
	/**
	 * Crea el SueloGrafico donde le pasaran en que poscion se lo debe asignar
	 * @param px ubicacion horizontal
	 * @param py ubicacion vertial
	 */
	public SueloGrafico(int px, int py, CargadorGrafico cg){
		super(px,py);
		imagen=cg.getBSuelo();
	}
	
	/**
	 * En esta implementación no hace nada el suelo si se destruye
	 */
	public void destruir(){
		
	}
	
}
