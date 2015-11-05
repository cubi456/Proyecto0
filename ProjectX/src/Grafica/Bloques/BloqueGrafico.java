package Grafica.Bloques;


import javax.swing.Icon;
import javax.swing.JLabel;

public abstract class BloqueGrafico{
	protected JLabel grafico;
	protected Icon imagen;
	protected final int ancho = 32;
	protected final int alto = 32;
	protected int x,y;
	
	protected BloqueGrafico(int px, int py){
		this.x=px*ancho;
		this.y=py*alto;
	}
	
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(imagen);
			this.grafico.setBounds(x, y, ancho, alto);
		}
		
		return this.grafico;
	}
	public void setGrafico(JLabel b)
	{
		if(grafico!=null)
			this.grafico=b;
	}
	
}
