package Logica;
import java.awt.Point;
import java.util.*;

import Grafica.GUI;
import HilosPersonajes.BombermanThread;
import HilosPersonajes.EnemigoThread;
import Logica.Enemigos.Altair;
import Logica.Enemigos.Rugulus;
import Logica.Enemigos.Sirius;
import Logica.Jugador.Bomberman;

/**
 *@author Barreix, I�aki.
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
 * Recibe un atributo de tipo GUI como par�metro y
 * crea un nuevo juego.
 * 
 * @param g
 */
    public Juego(GUI g) 
    {
    	gui=g;
    	misNiveles= new Vector<Nivel>();
    	misPersonajes=new Vector<Personaje>();
    	this.crearNivel();
    	this.addBomberman();
    	this.addRugulus();
		this.addRugulus();
		this.addRugulus();
		this.addAltair();
		this.addAltair();
		//this.addAltair();
		//this.addSirius();
    }


    /**
     * Retorna una colecci�n representada con un vector 
     * que contiene objetos de tipo Personaje.
     * @return Vector<Personaje>
     */
    public Vector<Personaje> misPersonajes() 
    {
        return misPersonajes;
    }

    /**
     * Retorna una colecci�n representada con un vector
     * que contiene objetos de tipo Nivel.
     * @return Vector<Nivel>
     */
    public Vector<Nivel> misNiveles()
    {
        return misNiveles;
    }
    

    /**
     * Recibe un Personaje como par�metro y lo elimina del juego.
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
     * Recibe como par�metro el n�mero de nivel, tomando 0 como nivel inicial
     * y retorna el Nivel.
     * @param pos 
     * @return Nivel
     */
    public Nivel getNivel(int pos)
    {
        return misNiveles.get(pos);
    }

    /**
     * Recibe como par�metro el n�mero de personaje, tomando 0 como personaje 
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
    	//Para prueba
    	//Personaje r= new Rugulus(800, 1, 11, 15,this);
    	Point p= asignarPos();
    	Personaje r= new Rugulus(800, (int)p.getX(), (int)p.getY(), 15,this);
    	misPersonajes.addElement(r);
    	gui.add(r.getGrafico(), 1);    	
    }

    /**
     * Crea un Personaje de tipo Altair en el juego.
     */
    public void addAltair()
    {
        //Personaje a= new Altair(400, 1,11, 20,this);
    	Point p= asignarPos();
    	Personaje a= new Altair(400, (int)p.getX(), (int)p.getY(), 20,this);
    	misPersonajes.addElement(a);
        gui.add(a.getGrafico(),1);
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
    	//Por convencion Bomberman se asigna en la celda 1,1 con una velocidad inicial designada.
    	Personaje b= new Bomberman(500, 1, 1,this);
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
    /**
     * Retorna el objeto de tipo Personaje asociado al juego.
     * @return Personaje
     */
    public Personaje getBomberman(){
    	//	Por convencion Bomberman es el primer personaje creado por eso siempre estara en la pos 0.
    	return misPersonajes.get(0);
    }
    
    public Point asignarPos(){
    	Random pos= new Random();
    	int x=0,y=0;
    	boolean designe=false;
    	while(!designe){
    		x=pos.nextInt(29)+1;
    		y=pos.nextInt(11)+1;
    		if(x>5 && y>5)
    			if(this.misNiveles.get(0).getCelda(x, y).getPared()==null)
    				designe=true;
    	}
    	return new Point(x, y);
    }
    
}