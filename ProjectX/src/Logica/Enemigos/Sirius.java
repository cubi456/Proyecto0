package Logica.Enemigos;

import java.util.*;

import Grafica.Personajes.SiriusGrafico;
import HilosPersonajes.EnemigoThread;
import Logica.Juego;
import Logica.Bloques.Celda;

/**
 *@author Barreix, Iñaki.
 *@author Comellas, Juan Manuel.
 *@version 1.0
 */
public class Sirius extends Enemigo {

	
	/**
     * Crea un nuevo Enemigo de tipo Sirus
     * con la velocidad, la posición en X,
     * la posición en Y, el puntaje que va a tener el Enemigo
     * y el Juego que va a pertenecer.
     * @param velocidad
     * @param posición en X
     * @param posición en Y 
     * @param Puntaje
     * @param Juego 
     */
    public Sirius(int s, int x, int y, int p,Juego j) {
        super(s, x, y, p,j);
        grafico= new SiriusGrafico(s, x, y, miJuego.getCargadorGrafico());
    	et= new EnemigoThread(this);
    	et.start();
    }

    
    /**
     * Genera un movimiento en el Enemigo.
     */
	public void mover(int dir) 
	{
		if(vivo)
		{
			boolean encontre=false;
			Celda c=miJuego.getNivel(0).getCelda(this.posX, this.posY);
			Celda aux=null;
			Vector<Celda> ady=c.getAdyacentes(6);
			for(int i=0;i<ady.size() && !encontre;i++)
			{
				if(ady.elementAt(i).getBomberman()!=null)
				{
					encontre=true;
					aux=ady.elementAt(i);
				}
			}
			if(encontre && aux!=null)
				dir=calcularDir(aux);
			else
			{
				Random rnd = new Random();
				dir=rnd.nextInt(4);
			}
			moverHacia(dir);
		}
		
	}
	
	private int calcularDir(Celda c)
	{
		int toReturn;
		if(posX-c.getX()>0)
			toReturn=0;
		else
		{
			if(posX-c.getX()<0)
				toReturn=2;
			else
				if(posY-c.getY()>0)
					toReturn=1;
				else
					toReturn=3;
		}
		return toReturn;
	}
	
}