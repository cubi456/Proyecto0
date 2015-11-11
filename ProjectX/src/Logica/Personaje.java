package Logica;

import javax.swing.JLabel;

import Grafica.Personajes.PersonajeGrafico;

/**
 *@author Barreix, Iñaki.
 *@author Comellas, Juan Manuel.
 *@version 1.0
 */
public abstract class Personaje {

    protected int speed, posX, posY;
    protected Juego miJuego;
    protected PersonajeGrafico grafico;

    /**
     * Crea un nuevo Personaje con la velocidad,
     * la posición en X,la posición en Y
     * y el Juego que va a pertenecer.
     * @param velocidad
     * @param Posición en X
     * @param Posición en Y
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
     * Retorna la posición en X del Personaje.
     * @return Posición en X.
     */
    public int getPosX() {
        return posX;
    }

    /**
     * Retorna la Posición en Y del Personaje.
     * @return Posición en Y.
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
     * Retorna el componente gráfico asociado al Personaje.
     * @return JLabel
     */
    
    public abstract void mover(int dir);
    
    public JLabel getGrafico(){
		return this.grafico.getGrafico();
	}
    
}