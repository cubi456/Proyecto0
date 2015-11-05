package Grafica.Bloques;


import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class BloqueGrafico{
	protected JLabel grafico;
	protected Icon imagen;
	protected final int ancho = 32;
	protected final int alto = 32;
	protected int x,y;
	protected Icon[] exp;
	
	protected BloqueGrafico(int px, int py){
		this.x=px*ancho;
		this.y=py*alto;
		exp= new Icon[5];
		exp[0] = new ImageIcon(this.getClass().getResource("../Sprites/fire00.png"));
		exp[1] = new ImageIcon(this.getClass().getResource("../Sprites/fire01.png"));
		exp[2] = new ImageIcon(this.getClass().getResource("../Sprites/fire02.png"));
		exp[3] = new ImageIcon(this.getClass().getResource("../Sprites/fire03.png"));
		exp[4] = new ImageIcon(this.getClass().getResource("../Sprites/fire04.png"));
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
	
	public void prenderFuego() throws InterruptedException{
		for(int i=0;i<5;i++){
			grafico.setIcon(exp[i]);
			grafico.setBounds(x,y,ancho,alto);
			Thread.sleep(100);
		}
	}
}
