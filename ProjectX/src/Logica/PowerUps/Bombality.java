package Logica.PowerUps;

import Grafica.PowerUps.PowerUpGrafico;
import Logica.PowerUp;
import Logica.Jugador.Bomberman;
import Sonidos.SonidoBombality;

/**
 *@author Barreix, I�aki.
 *@author Comellas, Juan Manuel.
 *@version 1.0
 */
public class Bombality extends PowerUp 
{

	/**
	 * Recibe como par�metro el componente gr�fico
	 * del power up correspondiente y crea un nuevo
	 * Bombality.
	 * @param PowerUpGrafico
	 */
    public Bombality(PowerUpGrafico p)
    {
    	super(p);
    	super.sonido=new SonidoBombality();
    }

    /**
     * @param b
     */
    public void setAction(Bomberman b) 
    {
    	sonido.reproducir();
        b.addBomba();
        b.getPuntaje().addPuntaje(35);
    }

}