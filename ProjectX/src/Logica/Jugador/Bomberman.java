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
    	alc=1;
    	puntaje= new Puntaje();
    	misBombas= new Vector<Bomba>();
    	addBomba();
    	addBomba();
    	grafico=new BombermanGrafico(s, x, y);
    	bt=new BombermanThread(miJuego.getGui(),this);
    	miJuego.getGui().agregarJuego(grafico.getGrafico(),2);
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
    	Bomba bom;
    	Celda c= miJuego.getNivel(0).getCelda(this.posX, this.posY);
    	if(!dios)
    	{
    		if(misBombas.size()>0)
    		{
    			if(c.getBomba()==null){
    				bom=misBombas.remove(misBombas.size()-1);
    				System.out.println("Removi bomba");
    				bom.setUbicacion(c);
    				miJuego.getGui().agregarJuego(bom.getGrafico().getGrafico(),20);
    				bom.getGrafico().setPos(posX, posY);
    				c.colocarBomba(bom);
    				bom=null;
    			}
    		}
    	}
    	else
    	{
    		bom=new Bomba(this);
    		bom.setUbicacion(c);
			miJuego.getGui().agregarJuego(bom.getGrafico().getGrafico(),20);
    		bom.getGrafico().setPos(posX, posY);
    		c.colocarBomba(bom);
    		bom=null;
    	}
      
    }

    protected void quererPasar(Celda c, int dir){
    	if((c.getPared()== null && c.getBomba()==null) || (dios && (c.getPared()==null || c.getPared().isDestructible())))
    		pasar(c, dir);
    }
   
    protected void setearEnCeldaPersonaje(){
    	miJuego.getNivel(0).getCelda(this.posX,this.posY).setBomberman(null);
    }
    /**
     * Detecta si en la Celda recibida como Parámetro
     * existe un enemigo o un powerUp y realiza la acción
     * correspondiente.
     * @param Celda
     */
    protected void analizar(Celda c)
    {
    		c.setBomberman(this);
    		if(!dios && (c.getEnemigo()!=null || c.getFuego()))
    			morir();
    			PowerUp pup=c.getPowerUp(); // una vez que lo tiene ya lo borra de la celda
    			if(pup!=null){
    				pup.setAction(this);
    				miJuego.getGui().remove(pup.getGrafico().getGrafico());
    				miJuego.getGui().repaint();
    			}
    }
    public void morir() 
    {
    	synchronized(this)
    	{
    		vivo=false;
        	miJuego.getNivel(0).getCelda(this.posX,this.posY).setBomberman(null);
        	grafico.morir();
        	bt.destruir();
        	//miJuego.matarPersonaje(this);
        	miJuego.matarBomberman();
    	}
    }
    /**
     * Duplica la velocidad del Bomberman.
     */
    public void doubleSpeed()
    {
    	this.speed= speed-125;
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
			break;
		}
	}
	
	public void detenerHilo(){
		bt.destruir();
	}
}