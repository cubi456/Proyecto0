package Logica;

/**
 * 
 */
public abstract class Enemigo extends Personaje {

    protected int puntaje;

    /**
     * @param s 
     * @param x 
     * @param y 
     * @param p
     */
    protected Enemigo(int s, int x, int y, int p) {
        super(s, x, y);
        puntaje=p;
    }

    /**
     * @return
     */
    public int getPuntaje() {
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
    public abstract void avanzarArriba();

    /**
     * 
     */
    public abstract void avanzarAbajo();

    /**
     * 
     */
    public abstract void MatarBomberman();

    /**
     * 
     */
    public abstract void morir();

}