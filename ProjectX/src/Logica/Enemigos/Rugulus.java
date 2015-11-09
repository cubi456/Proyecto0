package Logica.Enemigos;

import java.util.Random;

import Grafica.Personajes.RugulusGrafico;
import HilosPersonajes.EnemigoThread;
import Logica.Juego;
import Logica.Bloques.Celda;
import Logica.Jugador.Bomberman;

/**
 *@author Barreix, Iñaki.
 *@author Comellas, Juan Manuel.
 *@version 1.0
 */

public class Rugulus extends Enemigo 
{

	protected EnemigoThread rt;
	protected boolean vivo;
	
    /**
     * Crea un nuevo Enemigo de tipo Rugulus
     * con la velocidad, la posición en X,
     * la posición en Y, el puntaje que va a tener el Enemigo
     * y el Juego que va a pertenecer.
     * @param velocidad
     * @param posición en X
     * @param posición en Y 
     * @param Puntaje
     * @param Juego 
     */
    public Rugulus(int s, int x, int y, int p,Juego j) {
        super(s, x, y, p,j);
        vivo=true;
        grafico= new RugulusGrafico(s, x, y);
    	miJuego.getNivel(0).getCelda(x, y).setEnemigo(this);
    	rt= new EnemigoThread(this,speed);
    	rt.start();
    }

    /**
     * 
     */
    public void avanzarIzq() 
    {
    	grafico.cambiarDirec(0);
    	Celda c=miJuego.getNivel(0).getCelda(this.posX-1 ,this.posY);
      	if(c.getPared()== null && c.getBomba()==null)// && c.getEnemigo()==null)
      	{
      		grafico.mover(0);
      		miJuego.getNivel(0).getCelda(this.posX,this.posY).setEnemigo(null);
      		posX-=1;
      		analizar(c);
      	}
    		
    }

    /**
     * 
     */
    public void avanzarArriba() 
    {
    	grafico.cambiarDirec(1);
    	Celda c=miJuego.getNivel(0).getCelda(this.posX,this.posY-1);
    	if(c.getPared()== null && c.getBomba()==null)// && c.getEnemigo()==null)
      	{
      		grafico.mover(1);
      		miJuego.getNivel(0).getCelda(this.posX,this.posY).setEnemigo(null);
      		posY-=1;
      		analizar(c);
      	}
    }

    /**
     * 
     */
    public void avanzarDer() 
    {
    	grafico.cambiarDirec(2);
    	Celda c=miJuego.getNivel(0).getCelda(this.posX+1,this.posY);
      	if(c.getPared()== null && c.getBomba()==null)// && c.getEnemigo()==null)
      	{
      		grafico.mover(2);
      		miJuego.getNivel(0).getCelda(this.posX,this.posY).setEnemigo(null);
      		posX+=1;
      		analizar(c);
      	}
    }

    /**
     * 
     */
    public void avanzarAbajo() 
    {
    	grafico.cambiarDirec(3);
    	Celda c=miJuego.getNivel(0).getCelda(this.posX,this.posY+1);
      	if(c.getPared()== null && c.getBomba()==null)// && c.getEnemigo()==null)
      	{
      		grafico.mover(3);
      		miJuego.getNivel(0).getCelda(this.posX,this.posY).setEnemigo(null);
      		posY+=1;
      		analizar(c);
      	}
    }

    /**
     * 
     */
    public void MatarBomberman(Bomberman b) 
    {
        b.morir();
    }

    /**
     * Detecta si en la celda pasada por parámetro
     * se encuentra el Bomberman.
     * @param Celda
     */
    
    private void analizar(Celda c)
    {
    		c.setEnemigo(this);
    		if(c.getFuego())
    			morir();
    		if(c.getBomberman()!=null && !c.getBomberman().getDios())
    			MatarBomberman(c.getBomberman());
    }
    /**
     * 
     */
    public void morir()
    {
    	vivo=false;
    	miJuego.getNivel(0).getCelda(this.posX,this.posY).setEnemigo(null);
    	miJuego.matarPersonaje(this);
    	grafico.mover(4);
    	rt.destruir();
    }
    
    /**
     * Genera un movimiento en el Enemigo.
     */
	public void moverConInteligencia() 
	{
	// Calculo la siguiente direccion aleatoriamente.
		if(vivo)
		{
		Random rnd = new Random();
		int dir=rnd.nextInt(4);
		
		switch (dir) {
			case 0 : // a izq
				this.avanzarIzq();
				break;
			case 1: // a arriba
				this.avanzarArriba();
				break;
			case 2:
				this.avanzarDer();
				break;
			case 3 :
				this.avanzarAbajo();
				break;
					}
		}
	}

}