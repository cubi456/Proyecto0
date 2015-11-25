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
	
	public void removePared()
	{
		paredes--;
		cant.setText("Paredes restantes: "+paredes);
	}
	
	public JLabel getGrafico()
	{
		return cant;
	}
}
