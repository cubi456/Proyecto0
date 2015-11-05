package Logica.Jugador;

import Grafica.Bomba.BombaGrafico;
import HilosPersonajes.BombaThread;
import Logica.Bloques.Celda;

/**
 *@author Barreix, I�aki.
 *@author Comellas, Juan Manuel.
 *@version 1.0
 */
public class Bomba 
{

    protected int alcance;
    protected Celda ubicacion;
    protected BombaGrafico bg;
    protected BombaThread bt;
    protected Bomberman b;
    /**
     * Crea una nueva Bomba con el atributo
     * de tipo Bomberman que recibe como par�metro.
     * @param Bomberman.
     */
    public Bomba(Bomberman bom) 
    {
    	ubicacion=null;
    	alcance=bom.getAlc();
    	b=bom;
    }

    /**
     * Dublica el alcance de la bomba en dos.
     */
    public void duplicarAlcance() {
        alcance*=10;
    }

    /**
     * Retorna el alcance de explosi�n de la bomba.
     * @return int alcance.
     */
    public int getAlcance() {
        return alcance;
    }

    /**
     * Indica la ubicaci�n de la bomba en la
     * Celda recibida como par�metro.
     * @param Celda c
     */
    public void setUbicacion(Celda c) {
        ubicacion=c;
        bg=new BombaGrafico(ubicacion.getNivel().getJuego().getGui());
    }
    /**
     * Retorna la entidad gr�fica de la bomba.
     * @return BombaGrafico.
     */
    public BombaGrafico getGrafico()
    {
    	return bg;
    }
    
    /**
     * Crea el thread que le da vida a la bomba y lo inicializa.
     */
    public void activarBomba()
    {
    	bt=new BombaThread(this,ubicacion,alcance);
    	bt.start();
    }
    
    /**
     * Genera la explosi�n de la bomba.
     */
    public void explotar()
    {
    	if(ubicacion!=null)
    	{
    		ubicacion.destruirBomba();
    		ubicacion.getNivel().getJuego().getGui().remove(bg.getGrafico());
    		ubicacion.getNivel().getJuego().getGui().repaint();
    		for(Celda c:ubicacion.getAdyacentes(alcance))
    		{
    			if(c.getBomberman()!=null)
    				c.getBomberman().morir();
    			if(ubicacion.getBomberman()!=null)
    				ubicacion.getBomberman().morir();
    			if(c.getEnemigo()!=null)
    				c.getEnemigo().morir();
    			if(c.getPared()!=null)
    				c.destruir();
    		}
    	}
    	bt.destruir();
    	bg=null;
    	bg=new BombaGrafico(ubicacion.getNivel().getJuego().getGui());
    	ubicacion=null;
    	b.addBomba(this);
    }

}