package Logica.PowerUps;

import Logica.PowerUp;
import Logica.Jugador.Bomberman;

/**
 * 
 */
public class SpeedUp extends PowerUp {

    /**
     * 
     */
    public SpeedUp() 
    {
    	super();
    }

    /**
     * @param b
     */
    
    public void setAction(Bomberman b) 
    {
        b.doubleSpeed(); //Dobla la velocidad del personaje
    }
}