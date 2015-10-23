package Logica.Bloques;

import Logica.PowerUp;

/**
 *@author Barreix, Iñaki.
 *@author Comellas, Juan Manuel.
 *@version 1.0
 */
public class Pared {
    protected boolean destructible;
    protected PowerUp miPower;
  
    /**
     * Crea una nueva pared que puede contener
     * un PowerUp, y puede ser destructible
     * o no destructible.
     * @param PowerUp
     * @param Boolean
     */
    public Pared(PowerUp pu , boolean esDesc) {
        destructible= esDesc;
        miPower=pu;
    }

    /**
     * Retorna verdadero si la pared es destructible,
     * falso en caso contrario.
     * @return boolean
     */
    public boolean isDestructible() 
    {
        return destructible;
    }

    /**
     * Retorna el PowerUp asociado a la pared,
     * en caso de no existir retorna null.
     * @return PowerUp.
     */
    public PowerUp getPowerUp()
    {
    	return miPower;
    }
   
}