package Logica.Enemigos;

import Grafica.Personajes.RugulusGrafico;
import HilosPersonajes.EnemigoThread;
import Logica.Juego;

/**
 *@author Barreix, I�aki.
 *@author Comellas, Juan Manuel.
 *@version 1.0
 */

public class Rugulus extends Enemigo 
{

	protected EnemigoThread rt;
	
    /**
     * Crea un nuevo Enemigo de tipo Rugulus
     * con la velocidad, la posici�n en X,
     * la posici�n en Y, el puntaje que va a tener el Enemigo
     * y el Juego que va a pertenecer.
     * @param velocidad
     * @param posici�n en X
     * @param posici�n en Y 
     * @param Puntaje
     * @param Juego 
     */
    public Rugulus(int s, int x, int y, int p,Juego j) {
        super(s, x, y, p,j);
        grafico= new RugulusGrafico(s, x, y);
    	rt= new EnemigoThread(this);
    	rt.start();
    }
    
    /**
     * 
     */
    public void morir()
    {
    	vivo=false;
    	miJuego.getNivel(0).getCelda(this.posX,this.posY).setEnemigo(null);
    	miJuego.matarPersonaje(this);
    	grafico.morir();
    	rt.destruir();
    }

}