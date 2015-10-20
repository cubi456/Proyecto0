package Logica;
import java.util.*;

/**
 * 
 */
public class Juego {
    protected Timer Tiempo;

    protected Vector<Nivel> misNiveles;

    protected Vector<Personaje> misPersonajes;
    
    /**
     * Default constructor
     */
    public Juego() 
    {
    	misNiveles= new Vector<Nivel>();
    	misPersonajes=new Vector<Personaje>();
    }


    /**
     * @return
     */
    public Vector<Personaje> misPersonajes() {
        return misPersonajes;
    }

    /**
     * @return
     */
    public Vector<Nivel> misNiveles() {
        return misNiveles;
    }
    

    /**
     * @param pj
     */
    public void matarPersonaje(Personaje pj) 
    {
        misPersonajes.remove(pj);
    }

    /**
     * 
     */
    /** ISB El nivel crea el juego el juego crea el nivel **/
    public void crearNivel() 
    {
    	int[] pu= new int[4];
    	pu[0]=4;
    	pu[1]=3;
    	pu[2]=3;
    	pu[1]=1;
        Nivel nivel= new Nivel(pu, this);
        this.misNiveles.addElement(nivel);
    }

    /**
     * @param pos 
     * @return
     */
    public Nivel getNivel(int pos) {
        return misNiveles.get(pos);
    }

    /**
     * @param int 
     * @return
     */
    public Personaje getPersonaje(int pos) {
        return misPersonajes.get(pos);
    }

    /**
     * 
     */
    public void addRugulus()
    {
    	Personaje r= new Rugulus(1, 0, 0, 15,this);
    	misPersonajes.addElement(r);
    }

    /**
     * 
     */
    public void addAltair()
    {
       Personaje a= new Altair(1, 0, 0, 20,this);
       misPersonajes.addElement(a);
    }

    /**
     * 
     */
    public void addSirius()
    {
    	Personaje s= new Sirius(1, 0, 0, 50,this);
    	misPersonajes.addElement(s);
    }

    /**
     * 
     */
    public void addBomberman()
    {
    	Personaje b= new Bomberman(1, 0, 0,this);
    	misPersonajes.addElement(b);
    }
    
}