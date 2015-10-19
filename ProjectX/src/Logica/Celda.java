package Logica;


import java.util.*;

/**
 * 
 */
public class Celda {

    protected Bomberman bomberman;
    protected Enemigo[] enemigos;
    protected int x, y;
    protected Nivel Celdas;
    protected Pared Estado;
    protected PowerUp power;

    /**
     * @param int x 
     * @param int y
     */
    public void Celda(int x, int y) {
        // TODO implement here
    }

    /**
     * @return
     */
    public boolean getDestructible() {
        // TODO implement here
        return false;
    }

    /**
     * @param b
     */
    public void colocarBomba(Bomba b) {
        // TODO implement here
    }

    /**
     * 
     */
    public void destruir() {
        // TODO implement here
    }

    /**
     * @param PowerUp p
     */
    public void setPonerPowerUp(PowerUp p) {
        // TODO implement here
    }

    /**
     * @return
     */
    public PowerUp getPowerUp() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Pared getPared() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Bomberman estaBomberman() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Enemigo [] getEnemegio() {
        // TODO implement here
        return null;
    }

    /**
     * @param alc 
     * @return
     */
    public Celda[] getAdyacentes(int alc) {
        // TODO implement here
        return null;
    }

}