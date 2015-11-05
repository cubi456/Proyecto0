package Logica.Jugador;

import Grafica.Bomba.BombaGrafico;
import HilosPersonajes.BombaThread;
import Logica.Bloques.Celda;

/**
 *@author Barreix, Iñaki.
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
     * de tipo Bomberman que recibe como parámetro.
     * @param Bomberman.
     */
    public Bomba(Bomberman bom) 
    {
    	ubicacion=null;
    	alcance=bom.getAlc();
    	bg=new BombaGrafico();
    	b=bom;
    }

    /**
     * Dublica el alcance de la bomba en dos.
     */
    public void duplicarAlcance() {
        alcance*=10;
    }

    /**
     * Retorna el alcance de explosión de la bomba.
     * @return int alcance.
     */
    public int getAlcance() {
        return alcance;
    }

    /**
     * Indica la ubicación de la bomba en la
     * Celda recibida como parámetro.
     * @param Celda c
     */
    public void setUbicacion(Celda c) {
        ubicacion=c;
    }
    /**
     * Retorna la entidad gráfica de la bomba.
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
    	bt=new BombaThread(this);
    	bt.start();
    }
    
    /**
     * Genera la explosión de la bomba.
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
    			if(c.getPared()!=null)
    				c.destruir();
    			else{
    			c.incendiar();
    			if(c.getBomberman()!=null)
    				c.getBomberman().morir();
    			if(ubicacion.getBomberman()!=null)
    				ubicacion.getBomberman().morir();
    			if(c.getEnemigo()!=null)
    				c.getEnemigo().morir();
    			}
    		}
    	}
    	bt.destruir();
    	bg=null;
    	bg=new BombaGrafico();
    	ubicacion=null;
    	b.addBomba(this);
    }

}