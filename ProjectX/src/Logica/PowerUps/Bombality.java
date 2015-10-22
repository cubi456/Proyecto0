package Logica.PowerUps;

import Grafica.PowerUps.PowerUpGrafico;
import Logica.PowerUp;
import Logica.Jugador.Bomberman;

/**
 * 
 */
public class Bombality extends PowerUp {

    /**
     * 
     */
    public Bombality(PowerUpGrafico p)
    {
    	super(p);
    }

    /**
     * @param b
     */
    public void setAction(Bomberman b) 
    {
        b.addBomba();
    }

}