package Logica;

import java.awt.event.KeyEvent;


/**
 * 
 */
public class Bomberman extends Personaje {

    protected boolean dios;
    protected int puntaje;/**ISB NO CONTROLA EL JOGO? **/
    protected Bomba[] misBombas;
    protected int cantBombas;

    /**
     * @param s 
     * @param x 
     * @param y
     */
    public Bomberman(int s, int x, int y) {
    	super(s, x, y);
    	dios= false;
    	puntaje=0;
    	misBombas= new Bomba[15];// SE PUEDEN HASTA 20 bombas
    	for(int i=0; i<15; i++)
    		misBombas[i]=new Bomba();
    	
    }

    /**
     * ISB QUE ONDA CON ESTO?
     */
    public void setBomba() {
        // TODO implement here
    }

    /**
     * 
     */
    /** ISB CAMBIO DE NOMBRE **/
    public void convertirEnDios() {
       dios=true;
    }

    /**
     * @return
     */
    public int getPuntaje() {
        return puntaje;
    }

    /**
     * @param int p
     */
    public void addPuntaje(int p) {
        puntaje+=p;
    }

    /**
     * 
     */
    public void colocarBomba() {
        if(cantBombas!=0){
        	Celda c= miJuego.getNivel(0).getCelda(this.posX, this.posY);
        	Bomba bom=misBombas[cantBombas-1];
        	c.colocarBomba(bom);
        	cantBombas--;
        }
        
    }

    /**
     * 
     */
    public void avanzarIzq() {
    	Celda c=miJuego.getNivel(0).getCelda(this.posX, this.posY);
    	if(c.getPared()!= null){ // Si celda no es pared.
    		posX-=1;
    		PowerUp pup=c.getPowerUp();
    		if(pup!=null)
    			pup.setAction(this);
    	}
    			
    }

    /**
     * 
     */
    public void avanzarDer() {
    	Celda c=miJuego.getNivel(0).getCelda(this.posX, this.posY);
    	if(c.getPared()!= null){ // Si celda no es pared.
    		posX+=1;
    		PowerUp pup=c.getPowerUp();
    		if(pup!=null)
    			pup.setAction(this);
    	}
    }

    /**
     * 
     */
    public void avanzarAriba() {
    	Celda c=miJuego.getNivel(0).getCelda(this.posX, this.posY);
    	if(c.getPared()!= null){ // Si celda no es pared.
    		posY+=1;
    		PowerUp pup=c.getPowerUp();
    		if(pup!=null)
    			pup.setAction(this);
    	}
    }

    /**
     * 
     */
    public void avanzarAbajo() {
    	Celda c=miJuego.getNivel(0).getCelda(this.posX, this.posY);
    	if(c.getPared()!= null){ // Si celda no es pared.
    		posY-=1;
    		PowerUp pup=c.getPowerUp();
    		if(pup!=null)
    			pup.setAction(this);
    	}
    }

    
/*
    
*/
    /**ISB ALTERNATIVA **/
public void avanzar(int dir){
	Celda c=miJuego.getNivel(0).getCelda(this.posX, this.posY);
	if(c.getPared()!= null){ // Si celda no es pared.
		switch (dir){
			case 0: // Movimiento a izquierda
				posX-=1;
				break;
			case 1: // Movimiento a Arriba
				posY+=1;
				break;
			case 2: // Movimiento a Derecha
				posX+=1;
				break;
			case 3: //Movimiento a Abajo
				posY-=1;
				break;
		}
			
		PowerUp pup=c.getPowerUp();
		if(pup!=null)
			pup.setAction(this);
		if(c.hayEnemigo())
			morir();
	}
		
}
    public void morir() {
    	miJuego.matarPersonaje(this);
    }
    
    public Bomba[] getBombas(){
    	return misBombas;
    }

}