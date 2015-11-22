package Logica.Enemigos;


import Grafica.Personajes.AltairGrafico;
import HilosPersonajes.EnemigoThread;
import Logica.Juego;
import Logica.Bloques.Celda;
/**
 *@author Barreix, I�aki.
 *@author Comellas, Juan Manuel.
 *@version 1.0
 */

public class Altair extends Enemigo 
{
	
	protected EnemigoThread at;
	 /**
     * Crea un nuevo Enemigo con la velocidad,
     * la posici�n en X,la posici�n en Y,
     * el puntaje que va a tener el Enemigo
     * y el Juego que va a pertenecer.
     * @param velocidad
     * @param posici�n en X
     * @param posici�n en Y 
     * @param Puntaje
     * @param Juego 
     */
    public Altair(int s, int x, int y, int p,Juego j) {
    	super(s, x, y, p,j);
        grafico= new AltairGrafico(s, x, y);
    	at= new EnemigoThread(this);
    	at.start();
    }
    protected void quererPasar(Celda c, int dir){
    	//Rugulus y sirius utilizaran este. ALtair lo redifinir�
    	if(c.getPared()== null || (c.getPared()!=null && c.getPared().isDestructible()))// && c.getEnemigo()==null)
    		pasar(c, dir);
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
    	at.destruir();
    }
}