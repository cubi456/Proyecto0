package Logica.Bloques;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

import Grafica.CargadorGrafico;

public class ControladorBloques 
{
	private int paredes;
	private JLabel cant;
	/**
	 * Crea el cartel de cantidad de paredes Destructibles
	 * @param p Cantidad total de paredesDest
	 */
	public ControladorBloques(int p, CargadorGrafico cg)
	{
		paredes=p;
		cant=new JLabel("Paredes restantes: "+paredes);
		Font fuente=cg.getFPrototype();
		cant.setFont(fuente.deriveFont(1, 18));
		cant.setForeground(Color.white);
	}
	/**
	 * Disminuye la cantidad de paredes, y actualiza cartel
	 */
	public void removePared()
	{
		paredes--;
		cant.setText("Paredes restantes: "+paredes);
	}
	/**
	 * Devuelve la cantidad de paredes que quedan
	 * @return cantidad de paredes destructibles que restan
	 */
	public int getParedes(){
		return paredes;
	}
	/**
	 * Devuelve la imagen asociada al contador
	 * @return cartel contador
	 */
	public JLabel getGrafico()
	{
		return cant;
	}
}
