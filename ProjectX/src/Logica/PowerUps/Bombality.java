package Logica.PowerUps;

import Logica.PowerUp;
import Logica.Jugador.Bomberman;

/**
 * 
 */
public class Bombality extends PowerUp {

    /**
     * 
     */
    public Bombality()
    {
    	super();
    }

    /**
     * @param b
     */
    public void setAction(Bomberman b) 
    {
        b.addBomba();
    }

}