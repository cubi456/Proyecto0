package Logica;


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

}