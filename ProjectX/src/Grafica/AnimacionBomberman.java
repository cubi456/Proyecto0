package Grafica;

import javax.swing.Icon;

import Grafica.Personajes.PersonajeGrafico;

public class AnimacionBomberman extends Thread
{
	protected int vel;
	protected int dir;
	protected PersonajeGrafico bg;
	private volatile boolean stop;
    private static final int ancho=32;
    private static final int alto=32;
	public AnimacionBomberman(int dir,PersonajeGrafico pj)
	{
		this.dir=dir;
		bg=pj;
		vel=bg.getVelocidad();
	}
	
	public void run()
	{
		
		while(!stop)
		{
			int aux;
			int mov;
			switch(dir)
			{
			  case 0:
					aux=(int)bg.getPos().getX()-ancho;
				    mov=3;
				  	for(Icon i:bg.getSprites().elementAt(dir))
			  		{
				  		mov+=3;
				  		bg.getGrafico().setIcon(i);
				  		bg.getGrafico().setBounds((int)bg.getPos().getX()-mov,(int)bg.getPos().getY(),ancho,alto);
				  		try {
							Thread.sleep(vel/8);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			  		}
					bg.getPos().setLocation(aux, bg.getPos().getY());
					bg.getGrafico().setBounds(aux,(int)bg.getPos().getY(), ancho, alto);
				  	bg.getGrafico().setIcon(bg.getSprites().elementAt(0).elementAt(0));
			  		this.detener();
			  		break;
			  case 1:
				    aux=(int)bg.getPos().getY()-alto;
				    mov=3;
				  	for(Icon i:bg.getSprites().elementAt(dir))
			  		{
				  		mov+=3;
				  		bg.getGrafico().setIcon(i);
				  		bg.getGrafico().setBounds((int)bg.getPos().getX(),(int)bg.getPos().getY()-mov,ancho,alto);
				  		try {
							Thread.sleep(vel/8);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			  		}
					bg.getPos().setLocation(bg.getPos().getX(), aux);
					bg.getGrafico().setBounds((int)bg.getPos().getX(),aux, ancho, alto);
				  	bg.getGrafico().setIcon(bg.getSprites().elementAt(1).elementAt(0));
			  		this.detener();
			  		break;
			  case 2:
					aux=(int)bg.getPos().getX()+ancho;
				    mov=3;
				  	for(Icon i:bg.getSprites().elementAt(dir))
			  		{
				  		mov+=3;
				  		bg.getGrafico().setIcon(i);
				  		bg.getGrafico().setBounds((int)bg.getPos().getX()+mov,(int)bg.getPos().getY(),ancho,alto);
				  		try {
							Thread.sleep(vel/8);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			  		}
					bg.getPos().setLocation(aux, bg.getPos().getY());
					bg.getGrafico().setBounds(aux,(int)bg.getPos().getY(), ancho, alto);
				  	bg.getGrafico().setIcon(bg.getSprites().elementAt(2).elementAt(0));
			  		this.detener();
			  		break;
			  case 3:
				    aux=(int)bg.getPos().getY()+alto;
				    mov=3;
				  	for(Icon i:bg.getSprites().elementAt(dir))
			  		{
				  		mov+=3;
				  		bg.getGrafico().setIcon(i);
				  		bg.getGrafico().setBounds((int)bg.getPos().getX(),(int)bg.getPos().getY()+mov,ancho,alto);
				  		try {
							Thread.sleep(vel/8);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			  		}
					bg.getPos().setLocation(bg.getPos().getX(), aux);
					bg.getGrafico().setBounds((int)bg.getPos().getX(),aux, ancho, alto);
				  	bg.getGrafico().setIcon(bg.getSprites().elementAt(3).elementAt(0));
			  		this.detener();
			  		break;
			  case 4: //Muerte
				  	 for(Icon i:bg.getSprites().elementAt(dir))
				  	 {
				  		 bg.getGrafico().setIcon(i);
				  		 try {
							Thread.sleep(300);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				  	 }
				  	 this.detener();
				  	 break;
			}
		}
	}
	
	public void detener()
	{
		stop=true;
	}
}
