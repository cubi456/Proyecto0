package Logica.Jugador;

import Grafica.Bomba.BombaGrafico;
import HilosPersonajes.BombaThread;
import Logica.Bloques.Celda;

public class Bomba {

    protected int alcance;
    protected Celda ubicacion;
    protected BombaGrafico bg;
    protected BombaThread bt;
    protected Bomberman b;
    
    public Bomba(Bomberman bom) {
    	ubicacion=null;
    	alcance=1;
    	bg=new BombaGrafico();
    	b=bom;
    }

    /**
     * @param int a
     */
    public void duplicarAlcance() {
        alcance*=2;
    }

    /**
     * @return
     */
    public int getAlcance() {
        return alcance;
    }

    /**
     * @param Celda c
     */
    public void setUbicacion(Celda c) {
        ubicacion=c;
    }
    
    public BombaGrafico getGrafico()
    {
    	return bg;
    }
    
    public void activarBomba()
    {
    	bt=new BombaThread(this);
    	bt.start();
    }
    
    /**ISB  Esta en LA NOTA pero no en la clase*/
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
    	bg=new BombaGrafico();
    	ubicacion=null;
    	b.addBomba(this);
    }

}