package Logica;

/**
 * 
 */
public abstract class Personaje {

    protected int speed, posX, posY;
    protected Juego miJuego[];

    /**
     * @param s 
     * @param x 
     * @param y
     */
    protected Personaje(int s, int x, int y) {
        // TODO implement here
    }

    /**
     * @param s
     */
    public void setSpeed(int s) {
        // TODO implement here
    }

    /**
     * 
     */
    public void getSpeed() {
        // TODO implement here
    }

    /**
     * @return
     */
    public int getPosX() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public int getPosY() {
        // TODO implement here
        return 0;
    }

    /**
     * 
     */
    public abstract void avanzarIzq();

    /**
     * 
     */
    public abstract void avanzarDer();

    /**
     * 
     */
    public void avanzarArriba() {
        // TODO implement here
    }

    /**
     * 
     */
    public abstract void avanzarAbajo();

    /**
     * 
     */
    public abstract void morir();

}