package Logica;

import graficaPersonajes.BombermanGrafico;

import java.util.*;
import java.awt.event.KeyEvent;


/**
 * 
 */
public class Bomberman extends Personaje 
{

    protected boolean dios;
    protected int puntaje;
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
    	grafico=new BombermanGrafico(s, x, y);
    }

   
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
    	grafico.cambiarDirec(0);
    	Celda c=miJuego.getNivel(0).getCelda(this.posX-1,this.posY);
      	if(c.getPared()!= null)
      	{
      		miJuego.getNivel(0).getCelda(this.posX,this.posY).setBomberman(null);
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
    	Celda c=miJuego.getNivel(0).getCelda(this.posX,this.posY+1);
      	if(c.getPared()!= null)
      	{
      		miJuego.getNivel(0).getCelda(this.posX,this.posY).setBomberman(null);
      		posY+=1;
      		analizar(c);
      	}
    }
    
    public void avanzarDer()
    {
    	grafico.cambiarDirec(2);
    	Celda c=miJuego.getNivel(0).getCelda(this.posX+1,this.posY);
      	if(c.getPared()!= null)
      	{
      		miJuego.getNivel(0).getCelda(this.posX,this.posY).setBomberman(null);
      		posX+=1;
      		analizar(c);
      	}
    }
    /**
     * 
     */
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
    public void avanzarAbajo() 
    {
    	grafico.cambiarDirec(3);
    	Celda c=miJuego.getNivel(0).getCelda(this.posX,this.posY-1);
      	if(c.getPared()!= null)
      	{
      		miJuego.getNivel(0).getCelda(this.posX,this.posY).setBomberman(null);
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