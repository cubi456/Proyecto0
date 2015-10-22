package Logica.Jugador;

import Logica.Bloques.Celda;

public class Bomba {

    protected int alcance;
    protected Celda ubicacion;

    public Bomba() {
    	ubicacion=null;
    	alcance=1;
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
    /**ISB  Esta en LA NOTA pero no en la clase*/
    public void explotar()
    {
    	if(ubicacion!=null)
    	{
    		for(Celda c:ubicacion.getAdyacentes(alcance))
    		{
    			if(c.getBomberman()!=null)
    				c.getBomberman().morir();
    			if(c.getEnemigo()!=null)
    				c.getEnemigo().morir();
    			if(c.getPared()!=null)
    				c.destruir();
    		}
    	}
    }

}