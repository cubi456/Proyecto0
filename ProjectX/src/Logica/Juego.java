package Logica;
import java.util.*;

/**
 * 
 */
public class Juego {
    protected Timer Tiempo;

    protected Nivel[] misNiveles;

    protected Personaje[] misPersonajes;
    
    /**
     * Default constructor
     */
    public Juego() {
    	misNiveles= new Nivel[1];
    	misPersonajes= new Personaje[8];// 7 enemigos 1 malo
    	misNiveles[0]= crearNivel();
    }


    /**
     * @return
     */
    public Personaje[] misPersonajes() {
        return misPersonajes;
    }

    /**
     * @return
     */
    public Nivel[] misNiveles() {
        return misNiveles;
    }
    

    /**
     * @param pj
     */
    public void matarPersonaje(Personaje pj) {
        // TODO implement here
    }

    /**
     * 
     */
    /** ISB El nivel crea el juego el juego crea el nivel **/
    public Nivel crearNivel() {
    	/** Esto es asi cubo?*/
    	PowerUp[] pu= new PowerUp[11];
        Nivel nivel= new Nivel(pu, this);
        return nivel;
    }

    /**
     * @param pos 
     * @return
     */
    public Nivel getNivel(int pos) {
        return misNiveles[pos];
    }

    /**
     * @param int 
     * @return
     */
    public Personaje getPersonaje(int pos) {
        return misPersonajes[pos];
    }

    /**
     * 
     */
    public void addRugulus() {
    	Rugulus r= new Rugulus(1, 0, 0, 15);
    	/** ISB Y ACA comom seguimos? **/ 
    }

    /**
     * 
     */
    public void addAltair() {
       Altair a= new Altair(1, 0, 0, 20);
    }

    /**
     * 
     */
    public void addSirius() {
    	Sirius s= new Sirius(1, 0, 0, 50);
    }

    /**
     * 
     */
    public void addBomberman() {
    	Bomberman b= new Bomberman(1, 0, 0);
    }
    
}