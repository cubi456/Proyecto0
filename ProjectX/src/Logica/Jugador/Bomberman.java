package Logica.Jugador;

import java.awt.event.KeyEvent;
import java.util.*;

import Grafica.Personajes.BombermanGrafico;
import HilosPersonajes.BombermanThread;
import HilosPersonajes.ModoDios;
import Logica.Juego;
import Logica.Personaje;
import Logica.PowerUp;
import Logica.Bloques.Celda;


/**
 *@author Barreix, Iñaki.
 *@author Comellas, Juan Manuel.
 *@version 1.0
 */
public class Bomberman extends Personaje 
{

    protected boolean dios;
    protected Puntaje puntaje;
    protected Vector<Bomba> misBombas;
    protected BombermanThread bt;
    private boolean vivo;
    protected int alc;

    /**
     * Crea un nuevo Bomberman con la velocidad,
     * y la posición recibida como parámetro.
     * @param velocidad 
     * @param posición en x
     * @param posición en y
     */
    public Bomberman(int s, int x, int y,Juego j) {
    	super(s, x, y,j);
    	dios=false;
    	vivo=true;
    	alc=1;
    	puntaje= new Puntaje();
    	misBombas= new Vector<Bomba>();
    	addBomba();
    	grafico=new BombermanGrafico(s, x, y);
    	bt=new BombermanThread(miJuego.getGui(),this);
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
     * Cambia el valor del estado dios en verdadero.
     */
    
    public void Dios()
    {
    	if(!dios)
    		grafico.cambiarA(0);
    	else
    		grafico.cambiarA(1);
       dios=!dios;
    }
    
    public void convertirEnDios()
    {
    	ModoDios m=new ModoDios(this);
    	m.start();
    }
    
    /**
     * Devuelve el puntaje obtenido por el Bomberman.
     * @return int Puntaje
     */
    public Puntaje getPuntaje() 
    {
        return puntaje;
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
        	Bomba bom;
        	if(!dios)
        		bom=misBombas.remove(misBombas.size()-1);
        	else
        		bom=misBombas.lastElement();
        	bom.setUbicacion(c);
    		miJuego.getGui().getContenedor().add(bom.getGrafico().getGrafico(),20);
        	miJuego.getGui().getContenedor().repaint();
        	miJuego.getGui().toggleLock();
        	bom.getGrafico().setPos(posX, posY);
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
      	if((c.getPared()== null && c.getBomba()==null) || (dios && (c.getPared()==null || c.getPared().isDestructible())))
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
    	if((c.getPared()== null && c.getBomba()==null) || (dios && (c.getPared()==null || c.getPared().isDestructible())))
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
    	if((c.getPared()== null && c.getBomba()==null) || (dios && (c.getPared()==null || c.getPared().isDestructible())))
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
    	if((c.getPared()== null && c.getBomba()==null) || (dios && (c.getPared()==null || c.getPared().isDestructible())))
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
    		if(!dios && (c.getEnemigo()!=null || c.getFuego()))
    			morir();
    		PowerUp pup=c.getPowerUp();
    		if(pup!=null){
    			pup.setAction(this);
    			miJuego.getGui().remove(pup.getGrafico().getGrafico());
    			miJuego.getGui().repaint();
    			c.setPowerUp(null);
    		}
    }
    public void morir() {
    	vivo=false;
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
    	this.speed= speed/2;
    	grafico.setVelocidad(speed);
    }
    
    /**
     * Retorna una colección de bombas representadas
     * con un Vector.
     * @return Vector<Bomba>
     */
    public Vector<Bomba> getBombas(){
    	return misBombas;
    }
    
    public int getAlc()
    {
    	return alc;
    }
    
    public void setAlc(int a)
    {
    	alc=a;
    }

    public boolean getDios()
    {
    	return dios;
    }
    
	public void mover(int dir){
		if(vivo)
		switch (dir){
		case KeyEvent.VK_LEFT : //Izquierda
			this.avanzarIzq();
			break;
		case KeyEvent.VK_UP : //Arriba
			this.avanzarArriba();
			break;
		case KeyEvent.VK_RIGHT : //Derecha
			this.avanzarDer();
			break;
		case KeyEvent.VK_DOWN : //Abajo
			this.avanzarAbajo();
			break;
		case KeyEvent.VK_SPACE :
			this.colocarBomba();
		}
	}
}