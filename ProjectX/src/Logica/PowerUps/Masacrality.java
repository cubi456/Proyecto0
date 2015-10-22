package Logica.PowerUps;


import java.util.*;

import Logica.PowerUp;
import Logica.Jugador.Bomberman;

/**
 * 
 */
public class Masacrality extends PowerUp {

    /**
     * 
     */
    public Masacrality() {
       
    }

    /**
     * @param b
     */
    public void setAction(Bomberman b) {
        b.convertirEnDios();
    }

}