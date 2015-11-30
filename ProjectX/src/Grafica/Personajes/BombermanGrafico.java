package Grafica.Personajes;

import java.util.Vector;

import javax.swing.Icon;
import javax.swing.JLabel;

import Grafica.CargadorGrafico;

public class BombermanGrafico extends PersonajeGrafico {
	/**
	 * Recibe los parametros px , py y setea la grafica en la celda correspondiente.
	 * El otro parametro es la velocidad, la cual sera utilizada para el corrimiento animado.
	 * @param px ubicacion horizontal del bloque
	 * @param py ubicacion vertical del bloque
	 */
	private Vector<Vector<Icon>> spritesDios, spritesAux;
	public BombermanGrafico(int v, int px, int py, CargadorGrafico gc) {
		super(v, px, py);
		sprites=gc.getBomberman();
		spritesAux=sprites;
		spritesDios=gc.getBombDios();
		this.grafico = new JLabel(gc.getBomberman().elementAt(0).elementAt(0));
		this.grafico.setBounds(pos.x , pos.y, ancho, alto);
	}
	/**
	 * cambia graficamente a bomberman, haciendolo del color puesto del estado en que esta(dios=azul),(normal=blanco)
	 */
	
	public void cambiarA(int i){
		//Redefine
		//0 cambiar a Dios
		if(i==0)		
			sprites=spritesDios;
		else{// carga normal
			sprites=spritesAux;
		}
	}
}
