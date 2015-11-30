package Logica.Enemigos;

import java.util.Random;

import HilosPersonajes.EnemigoThread;
import Logica.Juego;
import Logica.Personaje;
import Logica.Bloques.Celda;
import Logica.Jugador.Bomberman;

/**
 *@author Barreix, Iñaki.
 *@author Comellas, Juan Manuel.
 *@version 1.0
 */
public abstract class Enemigo extends Personaje {

    protected int puntaje;
    protected EnemigoThread et;
    /**
     * Crea un nuevo Enemigo con la velocidad,
     * la posición en X,la posición en Y,
     * el puntaje que va a tener el Enemigo
     * y el Juego que va a pertenecer.
     * @param velocidad
     * @param posición en X
     * @param posición en Y 
     * @param Puntaje
     * @param Juego 
     */
    protected Enemigo(int s, int x, int y, int p,Juego j) {
        super(s, x, y,j);
        puntaje=p;
        miJuego.getNivel(0).getCelda(x, y).setEnemigo(this);
    }
    
    /**
     * Retorna puntaje asociado al Enemigo
     *@return Puntaje del enemigo.
     */
    public int getPuntaje() 
    {
        return puntaje;
    }

    /**
     * Genera la muerte del Bomberman recibido como parámetro.
     * @param Bomberman
     */
    public void MatarBomberman(Bomberman b) 
    {
        b.morir();
    }

    /**
     * 
     */
    public void morir()
    {
    	synchronized(this)
    	{
    		vivo=false;
        	miJuego.getNivel(0).getCelda(this.posX,this.posY).setEnemigo(null);
        	miJuego.matarPersonaje(this);
        	grafico.morir();
        	et.destruir();
        	for(Celda c:miJuego.getNivel(0).getCelda(posX, posY).getAdyacentes(1))
        		c.setEnemigo(null);
    	}
    }
  
    /**
     * Detecta si en la celda pasada por parámetro
     * se encuentra el Bomberman.
     * @param Celda
     */
    protected void analizar(Celda c)
    {
    		c.setEnemigo(this);
    		if(c.getFuego())
    			morir();
    		if(c.getBomberman()!=null && !c.getBomberman().getDios())
    			MatarBomberman(c.getBomberman());
    }
 
    protected void quererPasar(Celda c, int dir){
    	//Rugulus y sirius utilizaran este. ALtair lo redifinirá
    	if(c.getPared()== null && c.getBomba()==null)// && c.getEnemigo()==null)
    		pasar(c, dir);
    }
    protected void setearEnCeldaPersonaje(){
    	miJuego.getNivel(0).getCelda(this.posX,this.posY).setEnemigo(null);
    }

    /**
     * Genera un movimiento en el Enemigo.
     */
    public void mover(int dir) {
    	// Calculo la siguiente direccion aleatoriamente.
    		if(vivo)
    		{
    		Random rnd = new Random();
    	    dir=rnd.nextInt(4);
    		moverHacia(dir);
    		}
    	}
    	
    	protected void moverHacia(int dir){
    		switch (dir){
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
    
    	public void detenerHilo(){
    		synchronized(this)
    		{
    			vivo=false;
        		et.destruir();
        		et=null;
    		}
    	}
    	
    	public void comenzarHilo(){
    		et.start();
    	}

}