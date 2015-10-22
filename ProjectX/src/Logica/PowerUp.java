package Logica;

import Logica.Jugador.Bomberman;

/**
 * 
 */
public abstract class PowerUp {

    protected PowerUp() {
    }

    /**
     * @param b
     */
    public abstract void setAction(Bomberman b);

}