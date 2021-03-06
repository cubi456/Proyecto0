package Logica.Bloques;


import java.util.*;

import javax.swing.JLabel;

import Grafica.Bloques.BloqueGrafico;
import Grafica.Bloques.ParedDesctGrafico;
import Grafica.Bloques.ParedSolidaGrafico;
import Grafica.Bloques.SueloGrafico;
import Logica.Nivel;
import Logica.PowerUp;
import Logica.Enemigos.Enemigo;
import Logica.Jugador.Bomba;
import Logica.Jugador.Bomberman;

/**
 *@author Barreix, I�aki.
 *@author Comellas, Juan Manuel.
 *@version 1.0
 */
public class Celda {

    protected Bomberman bomberman;
    protected Enemigo enemigo;
    protected Bomba bomb;
    protected int x, y;
    protected Pared estado;
    protected Nivel miNivel;
    protected BloqueGrafico grafico;
    protected boolean fuego;
    protected PowerUp pu;

    /**
     * Crea una nueva celda con o sin pared 
     * en el nivel.
     * @param int x 
     * @param int y
     * @param Pared p
     * @param Nivel n
     */
    public Celda(int x, int y,Pared p,Nivel n) 
    {
    	fuego=false;
        this.x=x;
        this.y=y;
        enemigo=null;
        bomb=null;
        miNivel=n;
        estado=p;
        if(estado==null)
        	grafico=new SueloGrafico(x, y, miNivel.getCargadorGrafico());
        else
        	if(estado.isDestructible())
        		grafico=new ParedDesctGrafico(x, y, miNivel.getCargadorGrafico());
        	else
        		grafico=new ParedSolidaGrafico(x, y, miNivel.getCargadorGrafico());
        		
        
    }

    /**
     * Coloca una Bomba en la celda.
     * @param Bomba
     */
    public void colocarBomba(Bomba b) 
    {
    	if(estado==null)
    	{	
    		bomb=b;
    		b.activarBomba();
    		
    	}
    }
    
    /**
     * Retorna la Bomba que se encuentra en la celda,
     * si la bomba no existe retorna null.
     * @return Bomba
     */
    public Bomba getBomba()
    {
    	return bomb;
    }
    /**
     * Destruye la bomba que se encuentra en la celda.
     */
    public void destruirBomba()
    {
    	bomb=null;
    }
    
    /**
     * Retorna el Nivel donde se encuentra
     * la celda.
     * @return Nivel.
     */
    public Nivel getNivel()
    {
    	return miNivel;
    }
    /**
     * Destruye la pared que se encuentra en la celda.
     * Si no hay mas cajas en el nivel termina el juego
     */
    public void destruir() 
    {
    	if(estado!=null && estado.isDestructible())
    	{    		
    		grafico.destruir();
    		ControladorBloques cont= miNivel.getControlador();
    		cont.removePared();
    		if(cont.getParedes()==0)
    			miNivel.getJuego().avisarVictoria();
    		PowerUp power= estado.getPowerUp();
    		if(power!=null){
    			power.getGrafico().setPos(x, y);
    			miNivel.getJuego().getGui().agregarJuego(power.getGrafico().getGrafico(),20);
    			this.setPowerUp(power);
    		}
    		estado=null;
    	}
    }

    /**
     * Retorna la pared de la celda,
     * en caso de no existir retorna null.
     * @return
     */
    public Pared getPared() {
        return estado;
    }
    
    /**
     * Retorna el Bomberman que se encuentra 
     * en la celda, en caso de que no exista 
     * un Bomberman retorna null.
     * @return Bomberman
     */
    public Bomberman getBomberman()
    {
    	return bomberman;
    }
    /**
     * Coloca un Bomberman en la Celda.
     * @param Bomberman.
     */
    public void setBomberman(Bomberman b)
    {	
    	bomberman=b;
    }
    /**
     * Retorna el Enemigo que se encuentra en la celda,
     * en caso contrario retorna null.
     * @return Enemigo.
     */
    public Enemigo getEnemigo() {
        return enemigo;
    }
    /**
     * Coloca un Enemigo en la celda.
     * @param Enemigo.
     */
    public void setEnemigo(Enemigo e)
    {
    	enemigo=e;
    }
    /**
     * Retorna las celdas que se encuentran
     * en forma lineal a una ditancia recibida
     * como par�metro.
     * @param int alc 
     * @return Vector<Celda>
     */
    public Vector<Celda> getAdyacentes(int alc) 
    {
       Vector<Celda> salida=new Vector<Celda>();
       boolean izq,der,arr,abj;
       izq=der=arr=abj=true;
       for(int i=1;i<=alc && (izq || der || arr || abj);i++)
       {
    	   if(izq)
    	   {
    		   Celda aux=miNivel.getCelda(x-i, y);
    		   salida.addElement(aux);
    		   if(aux.getPared()!=null || aux.getBomba()!=null || aux.getPowerUp()!= null)
    			   izq=false;
    	   }
    	   if(der)
    	   {
    		   Celda aux=miNivel.getCelda(x+i, y);
    		   salida.addElement(aux);
    		   if(aux.getPared()!=null || aux.getBomba()!=null || aux.getPowerUp()!= null)
    			   der=false;
    	   }
    	   if(arr)
    	   {
    		   Celda aux=miNivel.getCelda(x, y-i);
    		   salida.addElement(aux);
    		   if(aux.getPared()!=null || aux.getBomba()!=null || aux.getPowerUp()!= null)
    			   arr=false;
    	   }
    	   if(abj)
    	   {
    		   Celda aux=miNivel.getCelda(x, y+i);
    		   salida.addElement(aux);
    		   if(aux.getPared()!=null || aux.getBomba()!=null || aux.getPowerUp()!= null)
    			   abj=false;
    	   }
       }
       return salida;
    }
    /**
     * Retorna el componente gr�fico 
     * asociado a la celda.
     * @return JLabel.
     */
    public JLabel getGrafico()
    {
		return this.grafico.getGrafico();
	}
    
    public int getX()
    {
    	return x;
    }
    
    public int getY()
    {
    	return y;
    }
    
    public void setFuego(boolean f)
    {
    	fuego=f;
    }
    
    public boolean getFuego()
    {
    	return fuego;
    }
    
    public void setPowerUp(PowerUp p){
    	pu=p;
    }
    
    public PowerUp getPowerUp(){
    	return pu;
    }
    
}