package Grafica.Personajes;

import javax.swing.JLabel;

import Grafica.CargadorGrafico;
/**
 *@author Barreix, Iñaki.
 *@author Comellas, Juan Manuel.
 *@version 1.0
 */
public class SiriusGrafico extends PersonajeGrafico {
/**
	 * Recibe los parametros px , py y setea la grafica en la celda correspondiente.
	 * El otro parametro es la velocidad, la cual sera utilizada para el corrimiento animado.
	 * @param px ubicacion horizontal del bloque
	 * @param py ubicacion vertical del bloque
	 */
	public SiriusGrafico(int v, int px, int py, CargadorGrafico gc) {
		super(v, px, py);
		this.sprites=gc.getSirius();
		this.grafico = new JLabel(sprites.elementAt(3).elementAt(0)); // Comienza de enfrente
		this.grafico.setBounds(pos.x , pos.y, ancho, alto);
	}
	/**
	 * En esta implentacion Sirus no cambiara nada
	 */
	public void cambiarA(int i){
		
	}

}
