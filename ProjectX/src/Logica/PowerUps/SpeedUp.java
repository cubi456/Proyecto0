package Logica.PowerUps;

import Grafica.PowerUps.PowerUpGrafico;
import Logica.PowerUp;
import Logica.Jugador.Bomberman;
import Sonidos.SonidoSpeedUp;

/**
 *@author Barreix, Iñaki.
 *@author Comellas, Juan Manuel.
 *@version 1.0
 */
public class SpeedUp extends PowerUp 
{

	/**
	 * Recibe como parámetro el componente gráfico
	 * del power up correspondiente y crea un nuevo
	 * SpeedUp.
	 * @param PowerUpGrafico
	 */
    public SpeedUp(PowerUpGrafico p) 
    {
    	super(p);
    	sonido=new SonidoSpeedUp();
    }

    /**
     * @param b
     */
    
    public void setAction(Bomberman b) 
    {
    	if(!b.getJuego().getGui().getSilencio())
    		sonido.reproducir();
        b.getPuntaje().addPuntaje(30);
        b.doubleSpeed(); //Dobla la velocidad del personaje
    }
}