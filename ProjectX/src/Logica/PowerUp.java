package Logica;

import Grafica.PowerUps.PowerUpGrafico;
import Logica.Jugador.Bomberman;

/**
 * 
 */
public abstract class PowerUp {
	
	protected PowerUpGrafico pug;
    protected PowerUp(PowerUpGrafico pug) 
    {
    	this.pug=pug;
    }

    /**
     * @param b
     */
    public abstract void setAction(Bomberman b);
    
    public PowerUpGrafico getGrafico()
    {
    	return pug;
    }
}