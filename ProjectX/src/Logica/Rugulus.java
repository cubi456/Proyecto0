package Logica;

import java.util.Random;


public class Rugulus extends Enemigo {

    /**
     * @param s 
     * @param x 
     * @param y 
     * @param p
     */
    public Rugulus(int s, int x, int y, int p,Juego j) {
        super(s, x, y, p,j);
    }

    /**
     * 
     */
    public void avanzarIzq() 
    {
    	Celda c=miJuego.getNivel(1).getCelda(this.posX-1,this.posY);
      	if(c.getPared()!= null && c.getEnemigo()==null)
      	{
      		miJuego.getNivel(1).getCelda(this.posX,this.posY).setEnemigo(null);
      		posX-=1;
      		analizar(c);
      	}
    		
    }

    /**
     * 
     */
    public void avanzarDer() 
    {
    	Celda c=miJuego.getNivel(1).getCelda(this.posX+1,this.posY);
      	if(c.getPared()!= null && c.getEnemigo()==null)
      	{
      		miJuego.getNivel(1).getCelda(this.posX,this.posY).setEnemigo(null);
      		posX+=1;
      		analizar(c);
      	}
    }

    /**
     * 
     */
    public void avanzarArriba() 
    {
    	Celda c=miJuego.getNivel(1).getCelda(this.posX,this.posY+1);
      	if(c.getPared()!= null && c.getEnemigo()==null)
      	{
      		miJuego.getNivel(1).getCelda(this.posX,this.posY).setEnemigo(null);
      		posY+=1;
      		analizar(c);
      	}
    }

    /**
     * 
     */
    public void avanzarAbajo() 
    {
    	Celda c=miJuego.getNivel(1).getCelda(this.posX,this.posY-1);
      	if(c.getPared()!= null && c.getEnemigo()==null)
      	{
      		miJuego.getNivel(1).getCelda(this.posX,this.posY).setEnemigo(null);
      		posY-=1;
      		analizar(c);
      	}
    }

    /**
     * 
     */
    public void MatarBomberman(Bomberman b) 
    {
        b.morir();
    }

    /**
     * 
     */
    
    private void analizar(Celda c)
    {
    		c.setEnemigo(this);
    		if(c.getBomberman()!=null)
    			MatarBomberman(c.getBomberman());
    }
    
    public void morir()
    {
        miJuego.matarPersonaje(this);
    }
    
	public void mover() {
		// Calculo la siguiente direccion aleatoriamente.
		Random rnd = new Random();
		int dir = rnd.nextInt(4);
		
		switch (dir) {
			case 0 : // a izq
				this.avanzarIzq();
				break;
			case 1: // a arriba
				this.avanzarArriba();
				break;
			case 2:
				this.avanzarDer();
				break;
			case 3 :
				this.avanzarAbajo();
				break;
		}
		
		//super.mover(dir);
		/*	Bueno aca vengo a explicar Jojo
		 * la onda de esto seria hacer exactamente lo que hizo juanma
		 * teniendo un mover en la clase Personaje para tener el movimiento super
		 * enchulado de los graficos, ademas podriamos usar un arreglo de graficos,
		 * como atributo de personaje, ya que eso es grafico.
		 * 
		 */
	}

}