package Logica;

import java.util.*;
import java.awt.event.KeyEvent;


/**
 * 
 */
public class Bomberman extends Personaje 
{

    protected boolean dios;
    protected int puntaje;/**ISB NO CONTROLA EL JOGO? **/
    protected Vector<Bomba> misBombas;

    /**
     * @param s 
     * @param x 
     * @param y
     */
    public Bomberman(int s, int x, int y,Juego j) {
    	super(s, x, y,j);
    	dios= false;
    	puntaje=0;
    	misBombas= new Vector<Bomba>();
    	addBomba();
    }

    /**
     * ISB QUE ONDA CON ESTO?
     */
    public void addBomba() 
    {
       misBombas.add(new Bomba());
    }

    /**
     * 
     */
    /** ISB CAMBIO DE NOMBRE **/
    public void convertirEnDios()
    {
       dios=true;
       //Hilo
    }

    /**
     * @return
     */
    public int getPuntaje() {
        return puntaje;
    }

    /**
     * @param int p
     */
    public void addPuntaje(int p) {
        puntaje+=p;
    }

    /**
     * 
     */
    public void colocarBomba() 
    {
        if(misBombas.size()>0)
        {
        	Celda c= miJuego.getNivel(0).getCelda(this.posX, this.posY);
        	Bomba bom=misBombas.remove(misBombas.size());
        	c.colocarBomba(bom);
        	//hilo
        	addBomba();
        }
      
    }

    /**
     * 
     */
    public void avanzarIzq() 
    {
    	Celda c=miJuego.getNivel(1).getCelda(this.posX-1,this.posY);
      	if(c.getPared()!= null)
      	{
      		miJuego.getNivel(1).getCelda(this.posX,this.posY).setBomberman(null);
      		posX-=1;
      		analizar(c);
      	}
    		
   	}
    			


    /**
     * 
     */
    public void avanzarDer()
    {
    	Celda c=miJuego.getNivel(1).getCelda(this.posX+1,this.posY);
      	if(c.getPared()!= null)
      	{
      		miJuego.getNivel(1).getCelda(this.posX,this.posY).setBomberman(null);
      		posX+=1;
      		analizar(c);
      	}
    }
    
    private void analizar(Celda c)
    {
    		c.setBomberman(this);
    		if(c.getEnemigo()!=null)
    			morir();
    		PowerUp pup=c.getPowerUp();
    		if(pup!=null)
    			pup.setAction(this);
    }
    /**
     * 
     */
    public void avanzarArriba()
    {
    	Celda c=miJuego.getNivel(1).getCelda(this.posX,this.posY+1);
      	if(c.getPared()!= null)
      	{
      		miJuego.getNivel(1).getCelda(this.posX,this.posY).setBomberman(null);
      		posY+=1;
      		analizar(c);
      	}
    }

    /**
     * 
     */
    public void avanzarAbajo() 
    {
    	Celda c=miJuego.getNivel(1).getCelda(this.posX,this.posY-1);
      	if(c.getPared()!= null)
      	{
      		miJuego.getNivel(1).getCelda(this.posX,this.posY).setBomberman(null);
      		posY-=1;
      		analizar(c);
      	}
    }

    
/*
    
*/
    public void morir() {
    	miJuego.matarPersonaje(this);
    	//hilo
    }
    
    public Vector<Bomba> getBombas(){
    	return misBombas;
    }

}