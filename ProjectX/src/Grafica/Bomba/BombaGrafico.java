package Grafica.Bomba;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BombaGrafico{
	protected JLabel grafico;
	protected Icon[] imagen;
	protected final int ancho = 32;
	protected final int alto = 32;
	protected int x,y;
	
	public BombaGrafico(int px, int py){
		this.x=px* ancho;
		this.y=py* alto;
		imagen= new Icon[3];
		this.imagen[0] = new ImageIcon(this.getClass().getResource("../Sprites/Bomb01.png"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("../Sprites/Bman02.png"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("../Sprites/Bman03.png"));
		
	}
	
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(imagen[0]);
			//hilo o gif.
			this.grafico.setBounds(x , y, ancho, alto);
		}
		
		return this.grafico;
	}
	
	
}

