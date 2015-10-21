package Logica;
import gui.GUI;

import java.util.*;

/**
 * 
 */
public class Juego {
    protected Timer Tiempo;

    protected Vector<Nivel> misNiveles;

    protected Vector<Personaje> misPersonajes;
    protected GUI gui;
    

    public Juego(GUI g) 
    {
    	gui=g;
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
    
    public void crearNivel() 
    {
    	int[] pu= new int[4];
    	pu[0]=4;
    	pu[1]=3;
    	pu[2]=3;
    	pu[1]=1;
        Nivel nivel= new Nivel(pu, this, gui);
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
    	Personaje b= new Bomberman(1, 1, 1,this);
    	misNiveles.get(1).getCelda(1,1).setBomberman((Bomberman)b);
    	misPersonajes.addElement(b);
    	gui.add(b.getGrafico());
    }
    
}