package Grafica.Personajes;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class PersonajeGrafico{
	protected JLabel grafico;
	protected Icon imagen[], mov[];
	protected final int ancho= 32;
	protected final int alto= 32;
	protected int velocidad;
	protected Point pos;
	
	protected PersonajeGrafico(int v, int x, int y){
		this.velocidad=v;
		pos = new Point(ancho * x, alto * y);
		imagen= new Icon[5];
		mov= new Icon[7];
		// mover Derecha
				this.mov[0] = new ImageIcon(this.getClass().getResource("../Sprites/Right.gif"));
				this.mov[1] = new ImageIcon(this.getClass().getResource("../Sprites/CPD/02.png"));
				this.mov[2] = new ImageIcon(this.getClass().getResource("../Sprites/CPD/03.png"));
				this.mov[3] = new ImageIcon(this.getClass().getResource("../Sprites/CPD/04.png"));
				this.mov[4] = new ImageIcon(this.getClass().getResource("../Sprites/CPD/05.png"));
				this.mov[5] = new ImageIcon(this.getClass().getResource("../Sprites/CPD/06.png"));
				this.mov[6] = new ImageIcon(this.getClass().getResource("../Sprites/CPD/07.png"));
	}
	public int getVelocidad(){
		return velocidad;
	}
	
	public void cambiarDirec(int dir){
		// La logica le pasa la direccion donde se va a mover
			grafico.setIcon(this.imagen[dir]);
	}
	
	public void mover(int direccion) {
		switch (direccion) {
			case 0 : // Left
				pos.setLocation(pos.x - ancho, pos.y);
				grafico.setBounds(pos.x, pos.y, ancho, alto);
				break;
			case 1 : // UP
				pos.setLocation(this.pos.x, this.pos.y - alto);
				grafico.setBounds(pos.x, pos.y, ancho, alto);
				break;
			case 2 :  // Right
				pos.setLocation(this.pos.x+ancho, this.pos.y);
				grafico.setBounds(pos.x, pos.y, ancho, alto);
				/*
				 forma juanma
					grafico.setIcon(this.mov[0]);
					int paso = 4;
					
					for(int i=0; i< ancho / paso;i++){
						pos.x += paso;
						//grafico.setIcon(this.mov[i]);
						grafico.setBounds(pos.x, pos.y, ancho, alto);
						Thread.sleep(100);
					}
					//una forma
					//pos.setLocation(pos.x + ancho, pos.y);
					//grafico.setBounds(pos.x, pos.y, ancho, alto);
					/*for(int i=4; i<mov.length;i++){
						grafico.setIcon(this.mov[i]);
						Thread.sleep(100);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				  }*/
				break;
			case 3 : // Down
				pos.setLocation(pos.x, pos.y + alto);
				grafico.setBounds(pos.x, pos.y, ancho, alto);
				break;
		}
	}
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(imagen[3]); // Comienza de enfrente
			this.grafico.setBounds(pos.x , pos.y, ancho, alto);
		}
		
		return this.grafico;
	}
	
	public void morir()
	{
		if(this.grafico != null){
			this.grafico.setIcon(imagen[4]); // Comienza de enfrente
			this.grafico.setBounds(pos.x , pos.y, ancho, alto);
	       }
	}

}