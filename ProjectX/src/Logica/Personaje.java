package Logica;

import javax.swing.JLabel;

import Grafica.Personajes.PersonajeGrafico;

/**
 *@author Barreix, I�aki.
 *@author Comellas, Juan Manuel.
 *@version 1.0
 */
public abstract class Personaje {

    protected int speed, posX, posY;
    protected Juego miJuego;
    protected PersonajeGrafico grafico;

    /**
     * Crea un nuevo Personaje con la velocidad,
     * la posici�n en X,la posici�n en Y
     * y el Juego que va a pertenecer.
     * @param velocidad
     * @param Posici�n en X
     * @param Posici�n en Y
     * @param Juego
     */
    protected Personaje(int s, int x, int y,Juego j) {
        speed=s;
        posX=x;
        posY=y;
        miJuego=j;
    }
    /**
     * Retorna la velocidad asociada a un personaje.
     * @return Velocidad del personaje.
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Retorna la posici�n en X del Personaje.
     * @return Posici�n en X.
     */
    public int getPosX() {
        return posX;
    }

    /**
     * Retorna la Posici�n en Y del Personaje.
     * @return Posici�n en Y.
     */
    public int getPosY() {
        return posY;
    }

    /**
     * Genera el movimiento del personaje hacia 
     * la izquierda.
     */
    abstract public void avanzarIzq();

    /**
     * Genera el movimiento del Personaje hacia
     * la derecha.
     */
    public abstract void avanzarDer();
    /**
     * Genera el movimiento del Personaje hacia arriba.
     */
    public abstract void avanzarArriba();

    /**
     * Genera el movimiento del personaje hacia abajo.
     */
    public abstract void avanzarAbajo();

    /**
     * Genera la muerte del Personaje en el juego.
     */
    public abstract void morir();
    
    /**
     * Retorna el componente gr�fico asociado al Personaje.
     * @return JLabel
     */
    
    public abstract void mover(int dir);
    
    public JLabel getGrafico(){
		return this.grafico.getGrafico();
	}
    
}