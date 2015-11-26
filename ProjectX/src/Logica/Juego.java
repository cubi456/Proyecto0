package Logica;
import java.awt.Point;
import java.util.*;

import Grafica.GUI;
import Logica.Enemigos.Altair;
import Logica.Enemigos.Enemigo;
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
    protected Vector<Nivel> misNiveles;
    protected Bomberman b;
    protected Vector<Enemigo> misPersonajes;
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
    	misPersonajes=new Vector<Enemigo>();
    	this.crearNivel();
    	this.addBomberman();
    	this.addRugulus();
		this.addRugulus();
		this.addRugulus();
		this.addAltair();
		this.addAltair();
		this.addSirius();
    }


    /**
     * Retorna una colección representada con un vector 
     * que contiene objetos de tipo Personaje.
     * @return Vector<Personaje>
     */
    public Vector<Enemigo> misPersonajes() 
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
    	pu[3]=1;
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
    	Point p= asignarPos();
    	Enemigo r= new Rugulus(1000, (int)p.getX(), (int)p.getY(), 15,this);
    	misPersonajes.addElement(r);
    	gui.agregarJuego(r.getGrafico(), 2);    	
    }

    /**
     * Crea un Personaje de tipo Altair en el juego.
     */
    public void addAltair()
    {
    	Point p= asignarPos();
    	Enemigo a= new Altair(1000, (int)p.getX(), (int)p.getY(), 20,this);
    	misPersonajes.addElement(a);
        gui.agregarJuego(a.getGrafico(),2);
    }

    /**
     * Crea un Personaje de tipo Sirius en el juego.
     */
    public void addSirius()
    {
    	Enemigo s= new Sirius(600, 29,11, 50,this);
    	misPersonajes.addElement(s);
    	gui.agregarJuego(s.getGrafico(), 2);
    }

    /**
     * Crea un personaje de tipo Bomberman en el juego y lo retorna.
     * @return Personaje
     */
    public Personaje addBomberman()
    {
    	//Por convencion Bomberman se asigna en la celda 1,1 con una velocidad inicial designada.
    	Bomberman b= new Bomberman(1000, 1, 1,this);
    	this.b=b;

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
    public Bomberman getBomberman(){
    	//	Por convencion Bomberman es el primer personaje creado por eso siempre estara en la pos 0.
    	return b;
    }
/**
 * Designa la posicion aleatoria de los personajes
 * @return Point la posicion donde se los va a asignar
 */
    public Point asignarPos(){
    	Random pos= new Random();
    	int x=0,y=0;
    	boolean designe=false;
    	while(!designe){
    		x=pos.nextInt(29)+1;
    		y=pos.nextInt(11)+1;
    		if(x>3 && y>3)
    			if(this.misNiveles.get(0).getCelda(x, y).getPared()==null)
    				designe=true;
    	}
    	return new Point(x, y);
    }
    /**
     * Avisa a la grafica que murio bomberman y detiene a los enemigos
     */
    public void matarBomberman(){
    	gui.muerteBomberman(b.getPuntaje().getPuntos());
    	frenarEnemigos();
    	borrarNivel();
    	b=null;
    }
    
    /**
     * Avisa a la grafica la victoria de el juego y detiene a los personajes
     */
    public void avisarVictoria(){
    	gui.noHayMasCajas(b.getPuntaje().getPuntos()); 
    	frenarEnemigos();
    	frenarBomberman();
    	borrarNivel();
    }
    
    private void borrarNivel(){
    	this.misNiveles.remove(misNiveles().size()-1);
    	misNiveles=null;
    }
    private void frenarEnemigos(){
    	for(Personaje p: misPersonajes){
    		p.detenerHilo();
    		p=null;
    	}
    	misPersonajes=null;    
    }
    
    private void frenarBomberman(){
    	b.detenerHilo();
    	b=null;
    }
}