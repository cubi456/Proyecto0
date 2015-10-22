package Logica.Bloques;


import java.util.*;

import javax.swing.JLabel;

import Grafica.Bloques.BloqueGrafico;
import Grafica.Bloques.ParedDesctGrafico;
import Grafica.Bloques.ParedSolidaGrafico;
import Grafica.Bloques.SueloGrafico;
import Logica.Enemigo;
import Logica.Nivel;
import Logica.PowerUp;
import Logica.Jugador.Bomba;
import Logica.Jugador.Bomberman;

/**
 * 
 */
public class Celda {

    protected Bomberman bomberman;
    protected Enemigo enemigo;
    protected int x, y;
    protected Pared estado;
    protected PowerUp power;
    protected Nivel miNivel;
    protected BloqueGrafico grafico;

    /**
     * @param int x 
     * @param int y
     */
    public Celda(int x, int y,Pared p,Nivel n) 
    {
        this.x=x;
        this.y=y;
        power=null;
        enemigo=null;
        miNivel=n;
        /**ISB ESTO PARA PROBAR EL MAPA**/
        if(x==0|| x==30 || y==0 || y==12){
        	grafico=new ParedSolidaGrafico(x, y);
        	estado=new Pared(null, false);
        }
        else
        if(x%2!=0 || y%2!=0){
        	grafico=new SueloGrafico(x, y);
        	estado=null;
        }
        else
        	if(x%4==0 && y%4!=0|| x%4!=0 && y%4==0){
        		grafico=new ParedSolidaGrafico(x, y);
        		estado=new Pared(null, false);
        	}
        	else{
        		grafico=new ParedDesctGrafico(x, y);
        		estado=new Pared(null, true);
        	}
        
    }

    /**
     * @return
     */
    public boolean getDestructible()
    {
        return estado!=null && estado.isDestructible();
    }

    /**
     * @param b
     */
    public void colocarBomba(Bomba b) 
    {
    	if(estado==null)
    	{	
    		b.setUbicacion(this);
    		b.explotar();
    	}
    }

    /**
     * 
     */
    public void destruir() 
    {
       power=estado.getPowerUp();
       estado=null;
    }

    /**
     * @return
     */
    public PowerUp getPowerUp() {
        return power;
    }

    /**
     * @return
     */
    public Pared getPared() {
        return estado;
    }
    
    /**
     * @return
     */
    
    public Bomberman getBomberman()
    {
    	return bomberman;
    }
    
    public void setBomberman(Bomberman b)
    {	
    	bomberman=b;
    		
    }
    /**
     * @return
     */
    public Enemigo getEnemigo() {
        return enemigo;
    }
    
    public void setEnemigo(Enemigo e)
    {
    	enemigo=e;
    }
    /**
     * @param alc 
     * @return
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
    		   if(aux.getPared()!=null)
    			   izq=false;
    	   }
    	   if(der)
    	   {
    		   Celda aux=miNivel.getCelda(x+i, y);
    		   salida.addElement(aux);
    		   if(aux.getPared()!=null)
    			   der=false;
    	   }
    	   if(arr)
    	   {
    		   Celda aux=miNivel.getCelda(x, y+1);
    		   salida.addElement(aux);
    		   if(aux.getPared()!=null)
    			   arr=false;
    	   }
    	   if(abj)
    	   {
    		   Celda aux=miNivel.getCelda(x, y-1);
    		   salida.addElement(aux);
    		   if(aux.getPared()!=null)
    			   abj=false;
    	   }
       }
       return salida;
    }
    
    public JLabel getGrafico(){
		return this.grafico.getGrafico();
	}
}