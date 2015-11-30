package Grafica.Personajes;

import javax.swing.JLabel;

import Grafica.CargadorGrafico;

public class RugulusGrafico extends PersonajeGrafico {
	
	/**
		 * Recibe los parametros px , py y setea la grafica en la celda correspondiente.
		 * El otro parametro es la velocidad, la cual sera utilizada para el corrimiento animado.
		 * @param px ubicacion horizontal del bloque
		 * @param py ubicacion vertical del bloque
		 */
	public RugulusGrafico(int v, int px, int py, CargadorGrafico gc) {
		super(v, px, py);
		this.sprites=gc.getRugulus();
		this.grafico = new JLabel(sprites.elementAt(3).elementAt(0)); // Comienza de enfrente
		this.grafico.setBounds(pos.x , pos.y, ancho, alto);
	}
	/**
	 * En esta implementacion Rugulus no cambiará
	 */
	public void cambiarA(int i){
		
	}

}
