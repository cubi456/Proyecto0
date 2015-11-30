package Grafica.Bomba;

import javax.swing.Icon;
import javax.swing.JLabel;

import Grafica.CargadorGrafico;

public class FuegoGrafico{
	protected JLabel grafico;
	protected Icon[] exp ;
	protected final int ancho = 32;
	protected final int alto = 32;
	protected int x,y;
	protected int acl;
	
	public FuegoGrafico(int px,int py, CargadorGrafico gc)
	{
		exp=gc.getFuego();
		this.x=px* ancho;
		this.y=py* alto;
		
	}
	
	public JLabel getGrafico()
	{
		if(this.grafico == null){
			this.grafico = new JLabel(exp[0]);
			this.grafico.setBounds(x , y, ancho, alto);
		}
		
		return this.grafico;
	}
	
	public void iniciar()
	{
		for(int i=0;i<exp.length;i++)
		{
			grafico.setIcon(exp[i]);
			grafico.setBounds(x,y,ancho,alto);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

