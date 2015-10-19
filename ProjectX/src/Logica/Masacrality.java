package Logica;


import java.util.*;

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