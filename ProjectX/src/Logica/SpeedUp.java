package Logica;

/**
 * 
 */
public class SpeedUp extends PowerUp {

    /**
     * 
     */
    public SpeedUp() 
    {
    	super();
    }

    /**
     * @param b
     */
    
    public void setAction(Bomberman b) 
    {
        b.doubleSpeed(); //Dobla la velocidad del personaje
    }
}