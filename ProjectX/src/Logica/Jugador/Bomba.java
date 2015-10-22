package Logica.Jugador;

import Grafica.Bomba.BombaGrafico;
import Logica.Bloques.Celda;

public class Bomba {

    protected int alcance;
    protected Celda ubicacion;
    protected BombaGrafico bg;
    private Bomberman b;
    public Bomba() {
    	ubicacion=null;
    	alcance=1;
    	bg=new BombaGrafico();
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
    
    /**ISB  Esta en LA NOTA pero no en la clase*/
    public void explotar()
    {
    	if(ubicacion!=null)
    	{
    		ubicacion.getNivel().getJuego().getGui().remove(bg.getGrafico());
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
    }

}