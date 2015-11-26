package Logica;

import Grafica.PowerUps.PowerUpGrafico;
import Logica.Jugador.Bomberman;
import Sonidos.Sonido;

/**
 *@author Barreix, Iñaki.
 *@author Comellas, Juan Manuel.
 *@version 1.0
 */
public abstract class PowerUp 
{
	
	protected PowerUpGrafico pug;
	protected Sonido sonido;
	
	/**
	 * Recibe como parámetro el componente gráfico
	 * del power up correspondiente y crea un nuevo
	 * PowerUp.
	 * @param PowerUpGrafico
	 */
    protected PowerUp(PowerUpGrafico pug) 
    {
    	this.pug=pug;	
    }

    /**
     * Realiza una acción sobre el bomberman
     * recibido como parámetro.
     * @param Bomberman
     */
    public abstract void setAction(Bomberman b);
    /**
     * Devuelve el Componetne grafico correspondiente
     * al PowerUp.
     * @return PowerUpGrafico.
     */
    public PowerUpGrafico getGrafico()
    {
    	return pug;
    }
}