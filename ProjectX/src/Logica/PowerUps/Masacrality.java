package Logica.PowerUps;


import java.util.*;

import Grafica.PowerUps.PowerUpGrafico;
import Logica.PowerUp;
import Logica.Jugador.Bomberman;

/**
 * 
 */
public class Masacrality extends PowerUp {

    /**
     * 
     */
    public Masacrality(PowerUpGrafico p) {
       super(p);
    }

    /**
     * @param b
     */
    public void setAction(Bomberman b) {
        b.convertirEnDios();
    }

}