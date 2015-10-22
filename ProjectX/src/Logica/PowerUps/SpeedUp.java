package Logica.PowerUps;

import Grafica.PowerUps.PowerUpGrafico;
import Logica.PowerUp;
import Logica.Jugador.Bomberman;

/**
 * 
 */
public class SpeedUp extends PowerUp {

    /**
     * 
     */
    public SpeedUp(PowerUpGrafico p) 
    {
    	super(p);
    }

    /**
     * @param b
     */
    
    public void setAction(Bomberman b) 
    {
        b.doubleSpeed(); //Dobla la velocidad del personaje
    }
}