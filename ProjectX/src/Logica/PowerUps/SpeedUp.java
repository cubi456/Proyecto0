package Logica.PowerUps;

import Grafica.PowerUps.PowerUpGrafico;
import Logica.PowerUp;
import Logica.Jugador.Bomberman;

/**
 *@author Barreix, I�aki.
 *@author Comellas, Juan Manuel.
 *@version 1.0
 */
public class SpeedUp extends PowerUp 
{

	/**
	 * Recibe como par�metro el componente gr�fico
	 * del power up correspondiente y crea un nuevo
	 * SpeedUp.
	 * @param PowerUpGrafico
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