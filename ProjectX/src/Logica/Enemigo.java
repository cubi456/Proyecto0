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
    protected Enemigo(int s, int x, int y, int p,Juego j) {
        super(s, x, y,j);
        puntaje=p;
    }

    /**
     * @return
     */
    public int getPuntaje() 
    {
        return puntaje;
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
    public abstract void MatarBomberman(Bomberman b);

    /**
     * 
     */
    public abstract void morir();

}