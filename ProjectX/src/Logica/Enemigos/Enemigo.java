package Logica.Enemigos;

import Logica.Juego;
import Logica.Personaje;
import Logica.Jugador.Bomberman;

/**
 *@author Barreix, Iñaki.
 *@author Comellas, Juan Manuel.
 *@version 1.0
 */
public abstract class Enemigo extends Personaje {

    protected int puntaje;

    /**
     * @param s 
     * @param x 
     * @param y 
     * @param p
     * @param j
     */
    protected Enemigo(int s, int x, int y, int p,Juego j) {
        super(s, x, y,j);
        puntaje=p;
    }

    /**
     * Retorna puntaje asociado al Enemigo
     *@return Puntaje del enemigo.
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
     * Elimina al Bomberman recibido como parámetro.
     * @param Bomberman
     */
    public abstract void MatarBomberman(Bomberman b);

    /**
     * 
     */
    public abstract void morir();

}