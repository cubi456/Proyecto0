package Logica.PowerUps;


import Grafica.PowerUps.PowerUpGrafico;
import Logica.PowerUp;
import Logica.Jugador.Bomberman;

/**
 *@author Barreix, Iñaki.
 *@author Comellas, Juan Manuel.
 *@version 1.0
 */
public class Masacrality extends PowerUp 
{

	/**
	 * Recibe como parámetro el componente gráfico
	 * del power up correspondiente y crea un nuevo
	 * Masacrality.
	 * @param PowerUpGrafico
	 */
    public Masacrality(PowerUpGrafico p) 
    {
       super(p);
    }

    /**
     * @param b
     */
    public void setAction(Bomberman b) 
    {
    	b.getPuntaje().addPuntaje(50);
        b.convertirEnDios();
    }

}