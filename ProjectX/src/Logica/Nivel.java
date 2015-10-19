
package Logica;

/**
 * 
 */
public class Nivel {

    protected Juego miJuego;
    protected Celda[][] celdas;
    protected PowerUp[] misPower;
    /**
     * @param powerUp int Arr
     */
    /**ISB Modificacion constructor, se pasa el jeugo a si mismo*/
    public Nivel(PowerUp[] pu, Juego j) {
        //miJuego= new Juego(); /** SI CREAMOS EL JUEGO NO ES EL MISMO **/
        miJuego=j;
        misPower= pu;
        celdas= new Celda[31][13];
        for(int f=0; f<celdas.length-1; f++)
        	for(int c=0; c< celdas.length-1; c++){
        		    celdas[f][c]= new Celda(f, c);  
        		    //POner o no power UP
        	}
    }

 
	/**
     * @return
     */
    public Juego MiJuego() {
        return miJuego;
    }

    /**
     * @return
     */
    public PowerUp[] getPowerUps() {
        return misPower;
    }

    /**
     * @param int x 
     * @param int y 
     * @return
     */
    public Celda getCelda(int x, int y){
        return celdas[x][y];
    }

    /**
     * 
     */
    private void addSpeedUp() {
        // TODO implement here
    }

    /**
     * 
     */
    private void addFatality() {
        // TODO implement here
    }

    /**
     * 
     */
    private void addBombality() {
        // TODO implement here
    }

    /**
     * 
     */
    private void addMasacrality() {
        // TODO implement here
    }

}