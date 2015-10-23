package Logica;
import java.util.*;

import Grafica.GUI;
import HilosPersonajes.BombermanThread;
import HilosPersonajes.RugulusThread;
import Logica.Enemigos.Altair;
import Logica.Enemigos.Rugulus;
import Logica.Enemigos.Sirius;
import Logica.Jugador.Bomberman;

/**
 *@author Barreix, Iñaki.
 *@author Comellas, Juan Manuel.
 *@version 1.0
 */
public class Juego 
{
    protected Timer tiempo;
    protected Vector<Nivel> misNiveles;

    protected Vector<Personaje> misPersonajes;
    protected GUI gui;
    
/**
 * Recibe un atributo de tipo GUI como parámetro y
 * crea un nuevo juego.
 * 
 * @param g
 */
    public Juego(GUI g) 
    {
    	gui=g;
    	misNiveles= new Vector<Nivel>();
    	misPersonajes=new Vector<Personaje>();
    }


    /**
     * Retorna una colección representada con un vector 
     * que contiene objetos de tipo Personaje.
     * @return Vector<Personaje>
     */
    public Vector<Personaje> misPersonajes() 
    {
        return misPersonajes;
    }

    /**
     * Retorna una colección representada con un vector
     * que contiene objetos de tipo Nivel.
     * @return Vector<Nivel>
     */
    public Vector<Nivel> misNiveles()
    {
        return misNiveles;
    }
    

    /**
     * Recibe un Personaje como parámetro y lo elimina del juego.
     * @param pj
     */
    public void matarPersonaje(Personaje pj) 
    {
        misPersonajes.remove(pj);
    }

    /**
     * Crea el nivel del juego. 
     */
    
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
     * Recibe como parámetro el número de nivel, tomando 0 como nivel inicial
     * y retorna el Nivel.
     * @param pos 
     * @return Nivel
     */
    public Nivel getNivel(int pos)
    {
        return misNiveles.get(pos);
    }

    /**
     * Recibe como parámetro el número de personaje, tomando 0 como personaje 
     * inicial y luego lo retorna.
     * 
     * @param int 
     * @return Personaje.
     */
    public Personaje getPersonaje(int pos) 
    {
        return misPersonajes.get(pos);
    }

    /**
     * Crea un Personaje de tipo rugulus en el juego.
     */
    public void addRugulus()
    {
    	Personaje r= new Rugulus(1, 1, 11, 15,this);
    	misPersonajes.addElement(r);
    	gui.add(r.getGrafico(), 1);    	
    }

    /**
     * Crea un Personaje de tipo Altair en el juego.
     */
    public void addAltair()
    {
       Personaje a= new Altair(1, 0, 0, 20,this);
       misPersonajes.addElement(a);
    }

    /**
     * Crea un Personaje de tipo Sirius en el juego.
     */
    public void addSirius()
    {
    	Personaje s= new Sirius(1, 0, 0, 50,this);
    	misPersonajes.addElement(s);
    }

    /**
     * Crea un personaje de tipo Bomberman en el juego y lo retorna.
     * @return Personaje
     */
    public Personaje addBomberman()
    {
    	Personaje b= new Bomberman(8, 1, 1,this);
    	misPersonajes.addElement(b);

    	return b;
    } 
    
    /**
     * Retorna el objeto de tipo GUI asociado al juego.
     * @return GUI
     */
    public GUI getGui()
    {
    	return gui;
    }
    
}