package Logica.Enemigos;

import Logica.Juego;
import Logica.Jugador.Bomberman;
/**
 *@author Barreix, Iñaki.
 *@author Comellas, Juan Manuel.
 *@version 1.0
 */
public class Altair extends Enemigo 
{

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
    public Altair(int s, int x, int y, int p,Juego j) {
        super(s, x, y, p,j);
    }

    /**
     * 
     */
    public void avanzarIzq() {
        // TODO implement here
    }

    /**
     * 
     */
    public void avanzarDer() {
        // TODO implement here
    }

    /**
     * 
     */
    public void avanzarAbajo() {
        // TODO implement here
    }

    /**
     * 
     */
    public void avanzarArriba() {
        // TODO implement here
    }

    /**
     * 
     */
    public void MatarBomberman(Bomberman b) {
        // TODO implement here
    }

    /**
     * 
     */
    public void morir() {
        // TODO implement here
    }

}