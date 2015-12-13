package Logica.Jugador;

import Grafica.GUI;
import Grafica.Bomba.BombaGrafico;
import HilosPersonajes.BombaThread;
import Logica.PowerUp;
import Logica.Bloques.Celda;
import Sonidos.SonidoBomba;

/**
 *@author Barreix, Iñaki.
 *@author Comellas, Juan Manuel.
 *@version 1.0
 */
public class Bomba 
{

    protected int alcance;
    protected Celda ubicacion;
    protected BombaGrafico bg;
    protected BombaThread bt;
    protected Bomberman b;
    protected SonidoBomba sonido;
    protected boolean dios;
    /**
     * Crea una nueva Bomba con el atributo
     * de tipo Bomberman que recibe como parámetro.
     * @param Bomberman.
     */
    public Bomba(Bomberman bom) 
    {
    	ubicacion=null;
    	dios=bom.getDios();
    	alcance=bom.getAlc();
    	b=bom;
    }

    /**
     * Dublica el alcance de la bomba en dos.
     */
    public void duplicarAlcance() {
    	//aumenta cada llama 1, "duplicandola"
        alcance+=1;
    }
    
    /**
     * Setea el alcance de la bomba
     * @param a
     */
    
    public void setAlcance(int a)
    {
    	alcance=a;
    }
    
    /**
     * Retorna el alcance de explosión de la bomba.
     * @return int alcance.
     */
    public int getAlcance() {
        return alcance;
    }

    /**
     * Indica la ubicación de la bomba en la
     * Celda recibida como parámetro.
     * @param Celda c
     */
    public void setUbicacion(Celda c) {
        ubicacion=c;
        bg=new BombaGrafico(ubicacion.getNivel().getJuego().getGui());
    }
    /**
     * Retorna la entidad gráfica de la bomba.
     * @return BombaGrafico.
     */
    public BombaGrafico getGrafico()
    {
    	return bg;
    }
    
    /**
     * Crea el thread que le da vida a la bomba y lo inicializa.
     */
    public void activarBomba()
    {
    	bt=new BombaThread(this,ubicacion,alcance);
    	bt.start();
    }
    
    /**
     * Genera la explosión de la bomba.
     */
    public void explotar()
    {
    	if(ubicacion!=null)
    	{
    		GUI gui= ubicacion.getNivel().getJuego().getGui();
    		if(!gui.getSilencio()){
    			sonido=new SonidoBomba();
    			sonido.reproducir();
    		}
    		ubicacion.destruirBomba();
    		gui.sacarJuego(bg.getGrafico());
    		for(Celda c:ubicacion.getAdyacentes(alcance))
    		{
    			if(c.getBomberman()!=null && !c.getBomberman().getDios() && c.getBomba()==null)
    				c.getBomberman().morir();
    			if(ubicacion.getBomberman()!=null && !ubicacion.getBomberman().getDios())
    				ubicacion.getBomberman().morir();
    			if(c.getEnemigo()!=null){
    				b.getPuntaje().addPuntaje(c.getEnemigo().getPuntaje());
					c.getEnemigo().morir();
    			}
    			PowerUp pup=c.getPowerUp();
    			if(pup!=null){
    				c.setPowerUp(null);
    				gui.sacarJuego(pup.getGrafico().getGrafico());
    				gui.repaint();
    			}
    			if(c.getPared()!=null && c.getPared().isDestructible())
    			{
    				b.getPuntaje().addPuntaje(10);
    				c.destruir();
    			}
    		}
    	}
    	if(!dios)
    		b.addBomba(this);
    	bt.destruir();
    }
}