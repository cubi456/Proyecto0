package Logica;


import java.util.*;

/**
 * 
 */
public class Celda {

    protected Bomberman bomberman;
    protected Enemigo[] enemigos;
    protected int x, y;
    protected Pared estado;
    protected PowerUp power;

    /**
     * @param int x 
     * @param int y
     */
    public Celda(int x, int y) {
        this.x=x;
        this.y=y;
        power=null;
        estado=null;
        /** ISB BOMBERMAN Y ENEMIGOS QUE ONDA **/ 
    }

    /**
     * @return
     */
    public boolean getDestructible() {
        return estado!=null && estado.isDestructible();
    }

    /**
     * @param b
     */
    public void colocarBomba(Bomba b) {
    		b.setUbicacion(this);
    		b.explotar();
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
        power=p;
    }

    /**
     * @return
     */
    public PowerUp getPowerUp() {
        return power;
    }

    /**
     * @return
     */
    public Pared getPared() {
        return estado;
    }

    /**
     * @return
     */
    public boolean estaBomberman() {
        return bomberman.getPosX()==x && bomberman.getPosY()==y;
    }

    /**
     * @return
     */
    public Enemigo[] getEnemigo() {
        return enemigos;
    }

    /**
     * @param alc 
     * @return
     */
    public Celda[] getAdyacentes(int alc) {
        // TODO implement here
        return null;
    }
    /** ISB AGREGADO */
    public boolean hayEnemigo(){
    	for(Enemigo e: enemigos)
    		if(e.getPosX()==x && e.getPosY()==y)
    			return true;
    	return false;
    }

}