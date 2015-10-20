package Logica;


import java.util.*;

/**
 * 
 */
public class Fatality extends PowerUp {


    public Fatality() {
       
    }

    /**
     * @param b
     */
    public void setAction(Bomberman b) 
    {
    	for(Bomba bom: b.getBombas())
    		bom.duplicarAlcance();
    }

}