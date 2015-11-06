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
     * Crea un nuevo Enemigo con la velocidad,
     * la posición en X,la posición en Y,
     * el puntaje que va a tener el Enemigo
     * y el Juego que va a pertenecer.
     * @param velocidad
     * @param posición en X
     * @param posición en Y 
     * @param Puntaje
     * @param Juego 
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
     * Genera la muerte del Bomberman recibido como parámetro.
     * @param Bomberman
     */
    public abstract void MatarBomberman(Bomberman b);

    /**
     * 
     */
    public abstract void morir();
    
    public abstract void moverConInteligencia();

}