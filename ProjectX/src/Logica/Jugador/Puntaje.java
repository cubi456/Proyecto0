package Logica.Jugador;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JLabel;

public class Puntaje 
{
	private int puntos;
	private JLabel puntaje;
	
	public Puntaje()
	{
		puntos=0;
		puntaje=new JLabel("Puntaje: 0");
		InputStream is=this.getClass().getResourceAsStream("../../Grafica/Fonts/Prototype.ttf");
		try {
			puntaje.setFont(Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(1, 18));
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
}
