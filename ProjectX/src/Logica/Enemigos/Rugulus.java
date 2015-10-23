package Logica.Enemigos;

import java.util.Random;

import Grafica.Personajes.RugulusGrafico;
import HilosPersonajes.RugulusThread;
import Logica.Juego;
import Logica.Bloques.Celda;
import Logica.Jugador.Bomberman;

/**
 *@author Barreix, Iñaki.
 *@author Comellas, Juan Manuel.
 *@version 1.0
 */

public class Rugulus extends Enemigo {

    /**
     * @param s 
     * @param x 
     * @param y 
     * @param p
     */
	protected RugulusThread rt;
	
    public Rugulus(int s, int x, int y, int p,Juego j) {
        super(s, x, y, p,j);
        grafico= new RugulusGrafico(s, x, y);
    	miJuego.getNivel(0).getCelda(x, y).setEnemigo(this);
    	rt= new RugulusThread(this);
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
     * 
     */
    
    private void analizar(Celda c)
    {
    		c.setEnemigo(this);
    		if(c.getBomberman()!=null)
    			MatarBomberman(c.getBomberman());
    }
    
    public void morir()
    {
    	miJuego.getNivel(0).getCelda(this.posX,this.posY).setEnemigo(null);
    	miJuego.matarPersonaje(this);
    	grafico.morir();
    	rt.destruir();
    }
    
	public void moverConInteligencia() {
	// Calculo la siguiente direccion aleatoriamente.
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
		
		//super.mover(dir);
		/*	Bueno aca vengo a explicar Jojo
		 * la onda de esto seria hacer exactamente lo que hizo juanma
		 * teniendo un mover en la clase Personaje para tener el movimiento super
		 * enchulado de los graficos, ademas podriamos usar un arreglo de graficos,
		 * como atributo de personaje, ya que eso es grafico.
		 * 
		 */
	}

}