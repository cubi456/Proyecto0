package Logica;

/**
 * 
 */
public abstract class Personaje {

    protected int speed, posX, posY;
    protected Juego miJuego;

    /**
     * @param s 
     * @param x 
     * @param y
     */
    protected Personaje(int s, int x, int y) {
        speed=s;
        posX=x;
        posY=y;
        miJuego=new Juego();
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
    public void avanzarIzq(){
    
    }

    /**
     * 
     */
    public void avanzarDer(){
    	
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
    public void avanzarAbajo(){
    	
    }

    /**
     * 
     */
    public void morir(){
    	
    }

}