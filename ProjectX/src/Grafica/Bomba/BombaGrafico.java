package Grafica.Bomba;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class BombaGrafico{
	protected JLabel grafico;
	protected Icon[] detonar, exp ;
	protected final int ancho = 32;
	protected final int alto = 32;
	protected int x,y;
	
	public BombaGrafico(){
		detonar= new Icon[4];
		detonar[0] = new ImageIcon(this.getClass().getResource("../Sprites/Bomb01.png"));
		detonar[1] = new ImageIcon(this.getClass().getResource("../Sprites/Bomb02.png"));
		detonar[2] = new ImageIcon(this.getClass().getResource("../Sprites/Bomb03.png"));
		/**
		 * Para cubitooo:
		 * Creo que deberiamos tener una entndiad fuego, 
		 * ya que la bomba explota en una sola celda, luego
		 * el cuando se expande no hay entidades/objetos bombas
		 * y aguante el club.
		 * 
		 * PD: Maiame
		 */
		exp= new Icon[5];
		exp[0] = new ImageIcon(this.getClass().getResource("../Sprites/fire00.png"));
		exp[1] = new ImageIcon(this.getClass().getResource("../Sprites/fire01.png"));
		exp[2] = new ImageIcon(this.getClass().getResource("../Sprites/fire02.png"));
		exp[3] = new ImageIcon(this.getClass().getResource("../Sprites/fire03.png"));
		exp[4] = new ImageIcon(this.getClass().getResource("../Sprites/fire04.png"));	
		
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
	
	public void detonar() throws InterruptedException
	{
		for(int i=0;i<3;i++)
		{
			grafico.setIcon(detonar[i]);
			grafico.setBounds(x,y,ancho,alto);
			Thread.sleep(1000);
		}
		explotar();
	}
	
	public void explotar() throws InterruptedException{
		for(int i=0;i<5;i++)
		{
			grafico.setIcon(exp[i]);
			grafico.setBounds(x,y,ancho,alto);
			Thread.sleep(100);
		}
	}
	
}

