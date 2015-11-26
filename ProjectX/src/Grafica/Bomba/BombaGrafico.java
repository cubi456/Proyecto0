package Grafica.Bomba;



import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Grafica.AnimacionFuego;
import Grafica.GUI;
import Logica.Bloques.Celda;

public class BombaGrafico{
	protected JLabel grafico;
	protected Icon[] detonar;
	protected final int ancho = 32;
	protected final int alto = 32;
	protected int x,y;
	protected GUI g;
	
	public BombaGrafico(GUI gui){
		detonar= new Icon[3];
		for(int i=0; i<detonar.length; i++)
			detonar[i] = new ImageIcon(this.getClass().getResource("../Sprites/Bomba/Bomb0"+i+".png"));
		g=gui;
	}
	
	public void setPos(int px,int py)
	{
		this.x=px* ancho;
		this.y=py* alto;
	}
	
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(detonar[0]);
			this.grafico.setBounds(x , y, ancho, alto);
		}
		
		return this.grafico;
	}
	
	public void detonar(Celda c,int a) throws InterruptedException
	{
		for(int i=0;i<detonar.length;i++)
		{
			grafico.setIcon(detonar[i]);
			grafico.setBounds(x,y,ancho,alto);
			Thread.sleep(1000);
		}
		//Coloca el fuego en la casilla de la bomba.
		AnimacionFuego aux=new AnimacionFuego(c,g);
		aux.start();
		//Coloca el fuego en las casillas adyacentes.
		for(Celda cel:c.getAdyacentes(a))
		{
			if(cel.getPared()==null)
			{
				AnimacionFuego fg=new AnimacionFuego(cel,g);
				fg.start();
					
			}
		}
	}
	
}


