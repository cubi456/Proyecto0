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
 *@author Barreix, Iñaki.
 *@author Comellas, Juan Manuel.
 *@version 1.0
 */
public class Bomberman extends Personaje 
{

    protected boolean dios;
    protected int puntaje;
    protected Vector<Bomba> misBombas;
    protected BombermanThread bt;

    /**
     * Crea un nuevo Bomberman con la velocidad,
     * y la posición recibida como parámetro.
     * @param velocidad 
     * @param posición en x
     * @param posición en y
     */
    public Bomberman(int s, int x, int y,Juego j) {
    	super(s, x, y,j);
    	dios= false;
    	puntaje=0;
    	bt=new BombermanThread(miJuego.getGui());
    	misBombas= new Vector<Bomba>();
    	addBomba();
    	grafico=new BombermanGrafico(s, x, y);
    	miJuego.getGui().getContenedor().add(grafico.getGrafico(),2);
    	miJuego.getNivel(0).getCelda(x, y).setBomberman(this);
    	bt.start();
    }

   /**
    * Agrega una bomba al bomberman.
    */
    public void addBomba() 
    {
       misBombas.add(new Bomba(this));
    }
    /**
     * Agrega la bomba recibida como parámetro al Bomberman.
     * @param Bomba
     */
    public void addBomba(Bomba b) 
    {
       misBombas.add(b);    
    }
    /**
     * Inicializa el esta dios en verdadero.
     */
    public void convertirEnDios()
    {
       dios=true;
       //hilo
    }

    /**
     * Devuelve el puntaje obtenido por el Bomberman.
     * @return int Puntaje
     */
    public int getPuntaje() {
        return puntaje;
    }

    /**
     * Le suma el puntaje recibido como parámetro
     * al puntaje obtenido por el bomberman.
     * @param int p
     */
    public void addPuntaje(int p) {
        puntaje+=p;
    }

    /**
     * Coloca una Bomba en la celda que se encuentra
     * el Bomberman.
     */
    public void colocarBomba() 
    {
        if(misBombas.size()>0)
        {
        	Celda c= miJuego.getNivel(0).getCelda(this.posX, this.posY);
        	Bomba bom=misBombas.remove(misBombas.size()-1);
        	bom.getGrafico().setPos(posX, posY);
        	miJuego.getGui().getContenedor().add(bom.getGrafico().getGrafico(),4);
        	miJuego.getGui().repaint();
        	miJuego.getGui().toggleLock();
        	c.colocarBomba(bom);
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
    /**
     * Detecta si en la Celda recibida como Parámetro
     * existe un enemigo o un powerUp y realiza la acción
     * correspondiente.
     * @param Celda
     */
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
    /**
     * Duplica la velocidad del Bomberman.
     */
    public void doubleSpeed()
    {
    	bt.duplicarVel();
    }
    
    /**
     * Retorna una colección de bombas representadas
     * con un Vector.
     * @return Vector<Bomba>
     */
    public Vector<Bomba> getBombas(){
    	return misBombas;
    }

}