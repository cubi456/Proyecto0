package Logica.Bloques;

import Logica.PowerUp;

/**
 * 
 */
public class Pared {
    protected boolean destructible;
    protected PowerUp miPower;
  
    /**
     * @param pu PowerUp 
     * @param esDesc
     */
    public Pared(PowerUp pu , boolean esDesc) {
        destructible= esDesc;
        miPower=pu;
    }

    /**
     * @return
     */
    public boolean isDestructible() 
    {
        return destructible;
    }

    /**
     * @return
     */
    public PowerUp getPowerUp()
    {
    	return miPower;
    }
   
}