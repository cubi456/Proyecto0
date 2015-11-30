package Logica.Enemigos;

import java.util.Random;

import Grafica.Personajes.RugulusGrafico;
import HilosPersonajes.EnemigoThread;
import Logica.Juego;
import Logica.Bloques.Celda;

/**
 *@author Barreix, Iñaki.
 *@author Comellas, Juan Manuel.
 *@version 1.0
 */

public class Rugulus extends Enemigo 
{
	
    /**
     * Crea un nuevo Enemigo de tipo Rugulus
     * con la velocidad, la posición en X,
     * la posición en Y, el puntaje que va a tener el Enemigo
     * y el Juego que va a pertenecer.
     * @param velocidad
     * @param posición en X
     * @param posición en Y 
     * @param Puntaje
     * @param Juego 
     */
    public Rugulus(int s, int x, int y, int p,Juego j) {
        super(s, x, y, p,j);
        grafico= new RugulusGrafico(s, x, y, miJuego.getCargadorGrafico());
    	et= new EnemigoThread(this);
    }
    
    public void mover(int dir) {
    	// Calculo la siguiente direccion aleatoriamente.
    		if(vivo && mePuedoMover())
    		{
    		Random rnd = new Random();
    	    dir=rnd.nextInt(4);
    		moverHacia(dir);
    		}
    	}
    	
    private boolean mePuedoMover()
    {
    	for(Celda c:miJuego.getNivel(0).getCelda(posX, posY).getAdyacentes(1))
    		if(c.getPared()==null)
    			return true;
    	return false;
    }
    
}