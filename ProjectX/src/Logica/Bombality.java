package Logica;


/**
 * 
 */
public class Bombality extends PowerUp {

    /**
     * 
     */
    public Bombality()
    {
    	super();
    }

    /**
     * @param b
     */
    public void setAction(Bomberman b) 
    {
        b.addBomba();
    }

}