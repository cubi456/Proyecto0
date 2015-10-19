package Logica;

import java.util.*;

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
    public boolean isDestructible() {
        return destructible;
    }

    /**
     * @return
     */
    public PowerUp setPowerUp() {
    	/**ISB ver **/
        return null;
    }

}