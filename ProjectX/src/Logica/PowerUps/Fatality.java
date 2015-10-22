package Logica.PowerUps;


import java.util.*;

import Logica.PowerUp;
import Logica.Jugador.Bomba;
import Logica.Jugador.Bomberman;

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