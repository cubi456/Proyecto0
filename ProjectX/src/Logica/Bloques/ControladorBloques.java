package Logica.Bloques;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JLabel;

public class ControladorBloques 
{
	private int paredes;
	private JLabel cant;
	/**
	 * Crea el cartel de cantidad de paredes Destructibles
	 * @param p Cantidad total de paredesDest
	 */
	public ControladorBloques(int p)
	{
		paredes=p;
		cant=new JLabel("Paredes restantes: "+paredes);
		InputStream is=this.getClass().getResourceAsStream("../../Grafica/Fonts/Prototype.ttf");
		try {
			cant.setFont(Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(1, 18));
			cant.setForeground(Color.white);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
