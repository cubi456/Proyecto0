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
	
	public BombaGrafico(){
		imagen= new Icon[4];
		this.imagen[0] = new ImageIcon(this.getClass().getResource("../Sprites/Bomb01.png"));
		this.imagen[1] = new ImageIcon(this.getClass().getResource("../Sprites/Bomb02.png"));
		this.imagen[2] = new ImageIcon(this.getClass().getResource("../Sprites/Bomb03.png"));
		this.imagen[3] = new ImageIcon(this.getClass().getResource("../Sprites/fire00.png"));
		
		
	}
	
	public void setPos(int px,int py)
	{
		this.x=px* ancho;
		this.y=py* alto;
	}
	
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(imagen[0]);
			//hilo o gif.
			this.grafico.setBounds(x , y, ancho, alto);
		}
		
		return this.grafico;
	}
	
	public void detonar() throws InterruptedException
	{
		for(int i=0;i<3;i++)
		{
			grafico.setIcon(imagen[i]);
			grafico.setBounds(x,y,ancho,alto);
			Thread.sleep(1000);
		}
		grafico.setIcon(imagen[3]);
		grafico.setBounds(x,y,ancho,alto);
		Thread.sleep(100);
	}
	
}

