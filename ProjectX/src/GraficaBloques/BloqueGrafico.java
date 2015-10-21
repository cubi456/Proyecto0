package GraficaBloques;


import javax.swing.Icon;
import javax.swing.JLabel;

public abstract class BloqueGrafico{
	protected JLabel grafico;
	protected Icon imagen;
	protected final int ancho = 32;
	protected final int alto = 32;
	protected int x,y;
	
	protected BloqueGrafico(int px, int py){
		this.x=px;
		this.y=py;
	}
	
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(imagen);
			this.grafico.setBounds(x * ancho, y* alto, ancho, alto);
		}
		
		return this.grafico;
	}
}