package Logica.Jugador;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

import Grafica.CargadorGrafico;

/**
 *@author Barreix, Iñaki.
 *@author Comellas, Juan Manuel.
 *@version 1.0
 */
public class Puntaje 
{
	private int puntos;
	private JLabel puntaje, puntaje2;
	/**
	 * Clase absoluta para controlar el puntaje de Bomberman
	 * @param cg Utiliza el cargadorGrafico para obtener la fuente
	 */
	public Puntaje(CargadorGrafico cg)
	{
		puntos=0;
		puntaje=new JLabel("Puntaje: 0");
		puntaje2=new JLabel("");
		Font fuente=cg.getFPrototype();
		puntaje.setFont(fuente.deriveFont(1, 18));
		puntaje.setForeground(Color.white);
		puntaje2.setFont(fuente.deriveFont(1, 52));
		puntaje2.setForeground(Color.white);
	}
	
	public void addPuntaje(int p)
	{
		puntos+=p;
		puntaje.setText("Puntaje: "+puntos);
	}
	

	
	public JLabel getGrafico()
	{
		return puntaje;
	}
	
	public JLabel getGrafico2(){
		puntaje2.setText("Puntaje: "+ puntos);
		return puntaje2;
	}
}
