package Logica;

import javax.swing.JLabel;

import Grafica.Personajes.PersonajeGrafico;
import Logica.Bloques.Celda;

/**
 *@author Barreix, Iñaki.
 *@author Comellas, Juan Manuel.
 *@version 1.0
 */
public abstract class Personaje {

    protected int speed, posX, posY;
    protected Juego miJuego;
    protected boolean vivo;
    protected PersonajeGrafico grafico;

    /**
     * Crea un nuevo Personaje con la velocidad,
     * la posición en X,la posición en Y
     * y el Juego que va a pertenecer.
     * @param velocidad
     * @param Posición en X
     * @param Posición en Y
     * @param Juego
     */
    protected Personaje(int s, int x, int y,Juego j) {
        speed=s;
        posX=x;
        posY=y;
        miJuego=j;
        vivo=true;
    }
    /**
     * Retorna la velocidad asociada a un personaje.
     * @return Velocidad del personaje.
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Retorna la posición en X del Personaje.
     * @return Posición en X.
     */
    public int getPosX() {
        return posX;
    }

    /**
     * Retorna la Posición en Y del Personaje.
     * @return Posición en Y.
     */
    public int getPosY() {
        return posY;
    }

    /**
     * Genera el movimiento del personaje hacia 
     * la izquierda.
     */
    public void avanzarIzq() 
    {
    	grafico.cambiarDirec(0);
    	Celda c=miJuego.getNivel(0).getCelda(this.posX-1 ,this.posY);
      	quererPasar(c,0);
    }

    /**
     * Genera el movimiento del Personaje hacia arriba.
     */
    public void avanzarArriba() 
    {
    	grafico.cambiarDirec(1);
    	Celda c=miJuego.getNivel(0).getCelda(this.posX,this.posY-1);
    	quererPasar(c, 1);
    }
    
    /**
     * Genera el movimiento del Personaje hacia
     * la derecha.
     */
    public void avanzarDer() 
    {
    	grafico.cambiarDirec(2);
    	Celda c=miJuego.getNivel(0).getCelda(this.posX+1,this.posY);
    	quererPasar(c,2);
    }

    /**
     * Genera el movimiento del personaje hacia abajo.
     */
    public void avanzarAbajo() 
    {
    	grafico.cambiarDirec(3);
    	Celda c=miJuego.getNivel(0).getCelda(this.posX,this.posY+1);
    	quererPasar(c,3);
    }

    /**
     * Genera la muerte del Personaje en el juego.
     */
    protected void pasar(Celda c, int dir){
  		if(vivo)
  			grafico.mover(dir);
    	setearEnCeldaPersonaje();
    	switch (dir) {
			case 0 : // izq
				posX-=1;
			break;
			case 1: // arriba
				posY-=1;
			break;
			case 2: // derecha
				posX+=1;	
			break;
			case 3 : //abajo
				posY+=1;
			break;
		}
  		analizar(c);
    }
    
    public abstract void morir();
    
    /**
     * Retorna el componente gráfico asociado al Personaje.
     * @return JLabel
     */
    
    public abstract void mover(int dir);
    
    protected abstract void analizar(Celda c);
    
    protected abstract void setearEnCeldaPersonaje();
    
    protected abstract void quererPasar(Celda c, int dir);
    
    public JLabel getGrafico(){
		return this.grafico.getGrafico();
	}    
}