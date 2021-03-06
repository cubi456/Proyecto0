package Logica.PowerUps;


import Grafica.PowerUps.PowerUpGrafico;
import Logica.PowerUp;
import Logica.Jugador.Bomba;
import Logica.Jugador.Bomberman;
import Sonidos.SonidoFatality;

/**
 *@author Barreix, I�aki.
 *@author Comellas, Juan Manuel.
 *@version 1.0
 */
public class Fatality extends PowerUp 
{

	/**
	 * Recibe como par�metro el componente gr�fico
	 * del power up correspondiente y crea un nuevo
	 * Fatality.
	 * @param PowerUpGrafico
	 */
    public Fatality(PowerUpGrafico p)
    {
       super(p);
       sonido=new SonidoFatality();
    }

    /**
     * @param b
     */
    public void setAction(Bomberman b) 
    {
    	if(!b.getJuego().getGui().getSilencio())
    		sonido.reproducir();
    	b.getPuntaje().addPuntaje(35);
    	for(Bomba bom: b.getBombas())
    		bom.duplicarAlcance();
    	b.setAlc(b.getAlc()+1);
    }

}