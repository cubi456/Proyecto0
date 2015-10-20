package Logica;


import java.util.*;

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

    /**
     * @param int x 
     * @param int y
     */
    public Celda(int x, int y,Pared p,Nivel n) 
    {
        this.x=x;
        this.y=y;
        power=null;
        estado=null;
        miNivel=n;
        /** ISB BOMBERMAN Y ENEMIGOS QUE ONDA **/ 
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
    public boolean estaBomberman() {
        return bomberman !=null;
    }
    
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

}