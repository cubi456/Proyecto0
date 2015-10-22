package Logica;

import javax.swing.JLabel;

import Grafica.Personajes.PersonajeGrafico;

/**
 * 
 */
public abstract class Personaje {

    protected int speed, posX, posY;
    protected Juego miJuego;
    protected PersonajeGrafico grafico;

    /**
     * @param s 
     * @param x 
     * @param y
     */
    protected Personaje(int s, int x, int y,Juego j) {
        speed=s;
        posX=x;
        posY=y;
        miJuego=j;
    }

    /**
     * @param s
     */
    /** ISB tendria que ser aumentar el doble**/
    public void doubleSpeed() { // Aumenta el doble la velocidad
        speed*=2;
    }

    /**
     * 
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * @return
     */
    public int getPosX() {
        return posX;
    }

    /**
     * @return
     */
    public int getPosY() {
        return posY;
    }

    /**
     * 
     */
    abstract public void avanzarIzq();

    /**
     * 
     */
    abstract public void avanzarDer();
    /**
     * 
     */
    abstract public void avanzarArriba();

    /**
     * 
     */
    abstract public void avanzarAbajo();

    /**
     * 
     */
    abstract public void morir();
    
    public JLabel getGrafico(){
		return this.grafico.getGrafico();
	}
    
}