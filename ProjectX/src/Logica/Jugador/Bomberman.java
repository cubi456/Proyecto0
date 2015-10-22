package Logica.Jugador;

import java.util.*;

import Grafica.Personajes.BombermanGrafico;
import Grafica.Personajes.PersonajeGrafico;
import HilosPersonajes.BombermanThread;
import Logica.Juego;
import Logica.Personaje;
import Logica.PowerUp;
import Logica.Bloques.Celda;

import java.awt.event.KeyEvent;


/**
 * 
 */
public class Bomberman extends Personaje 
{

    protected boolean dios;
    protected int puntaje;
    protected Vector<Bomba> misBombas;
    protected BombermanThread bt;

    /**
     * @param s 
     * @param x 
     * @param y
     */
    public Bomberman(int s, int x, int y,Juego j) {
    	super(s, x, y,j);
    	dios= false;
    	puntaje=0;
    	bt=new BombermanThread(miJuego.getGui());
    	misBombas= new Vector<Bomba>();
    	addBomba();
    	grafico=new BombermanGrafico(s, x, y);
    	miJuego.getGui().add(grafico.getGrafico(),1);
    	miJuego.getNivel(0).getCelda(x, y).setBomberman(this);
    	bt.start();
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
        	Bomba bom=misBombas.remove(misBombas.size()-1);
        	bom.getGrafico().setPos(posX, posY);
        	miJuego.getGui().add(bom.getGrafico().getGrafico(),1);
        	miJuego.getGui().repaint();
        	miJuego.getGui().toggleLock();
        	c.colocarBomba(bom);
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
      	if(c.getPared()== null && c.getBomba()==null)
      	{
      		grafico.mover(0);
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
    	Celda c=miJuego.getNivel(0).getCelda(this.posX,this.posY-1);
      	if(c.getPared()== null && c.getBomba()==null)
      	{
      		grafico.mover(1);
      		miJuego.getNivel(0).getCelda(this.posX,this.posY).setBomberman(null);
      		posY-=1;
      		analizar(c);
      	}
    }
    
    public void avanzarDer()
    {
    	grafico.cambiarDirec(2);
    	Celda c=miJuego.getNivel(0).getCelda(this.posX+1,this.posY);
      	if(c.getPared()== null && c.getBomba()==null)//no hay pared
      	{ 
      		grafico.mover(2);
      		miJuego.getNivel(0).getCelda(this.posX,this.posY).setBomberman(null);
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
      	if(c.getPared()== null && c.getBomba()==null)
      	{
      		grafico.mover(3);
      		miJuego.getNivel(0).getCelda(this.posX,this.posY).setBomberman(null);
      		posY+=1;
      		analizar(c);
      	}
    }

    private void analizar(Celda c)
    {
    		c.setBomberman(this);
    		if(c.getEnemigo()!=null)
    			morir();
    		PowerUp pup=c.getPowerUp();
    		if(pup!=null){
    			pup.setAction(this); 
    			c.setPowerUp(null);
    		}
    }
    public void morir() {
    	miJuego.getNivel(0).getCelda(this.posX,this.posY).setBomberman(null);
    	bt.destruir();
    	miJuego.matarPersonaje(this);
    	grafico.morir();
    }
    
    public void doubleSpeed()
    {
    	bt.dublicarVel();
    }
    
    public Vector<Bomba> getBombas(){
    	return misBombas;
    }

}