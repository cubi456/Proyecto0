package Grafica.Bloques;

import javax.swing.ImageIcon;

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
	public ParedSolidaGrafico(int px, int py){
		super(px, py);
		imagen= new ImageIcon(this.getClass().getResource("../Sprites/Bloque/ParedSolida.png"));
	}
	/**
	 * En esta implementación no hace nada el suelo si se destruye
	 */
	public void destruir(){
		
	}

}
