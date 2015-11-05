package Logica.Bloques;


import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Grafica.Bloques.BloqueGrafico;
import Grafica.Bloques.ParedDesctGrafico;
import Grafica.Bloques.ParedSolidaGrafico;
import Grafica.Bloques.SueloGrafico;
import Logica.Nivel;
import Logica.PowerUp;
import Logica.Enemigos.Enemigo;
import Logica.Jugador.Bomba;
import Logica.Jugador.Bomberman;

/**
 *@author Barreix, Iñaki.
 *@author Comellas, Juan Manuel.
 *@version 1.0
 */
public class Celda {

    protected Bomberman bomberman;
    protected Enemigo enemigo;
    protected Bomba bomb;
    protected int x, y;
    protected Pared estado;
    protected PowerUp power;
    protected Nivel miNivel;
    protected BloqueGrafico grafico;

    /**
     * Crea una nueva celda con o sin pared 
     * en el nivel.
     * @param int x 
     * @param int y
     * @param Pared p
     * @param Nivel n
     */
    public Celda(int x, int y,Pared p,Nivel n) 
    {
        this.x=x;
        this.y=y;
        power=null;
        enemigo=null;
        bomb=null;
        miNivel=n;
        /**ISB ESTO PARA PROBAR EL MAPA**/
        if(x==0|| x==30 || y==0 || y==12){
        	grafico=new ParedSolidaGrafico(x, y);
        	estado=new Pared(null, false);
        }
        else
        if(x%2!=0 || y%2!=0){
        	grafico=new SueloGrafico(x, y);
        	estado=null;
        }
        else
        	if(x%4==0 && y%4!=0|| x%4!=0 && y%4==0){
        		grafico=new ParedSolidaGrafico(x, y);
        		estado=new Pared(null, false);
        	}
        	else{
        		grafico=new ParedDesctGrafico(x, y);
        		estado=new Pared(null, true);
        	}
        
    }

    /**
     * Coloca una Bomba en la celda.
     * @param Bomba
     */
    public void colocarBomba(Bomba b) 
    {
    	if(estado==null)
    	{	
    		bomb=b;
    		b.setUbicacion(this);
    		b.activarBomba();
    		
    	}
    }
    
    /**
     * Retorna la Bomba que se encuentra en la celda,
     * si la bomba no existe retorna null.
     * @return Bomba
     */
    public Bomba getBomba()
    {
    	return bomb;
    }
    /**
     * Destruye la bomba que se encuentra en la celda.
     */
    public void destruirBomba()
    {
    	bomb=null;
    }
    
    /**
     * Retorna el Nivel donde se encuentra
     * la celda.
     * @return Nivel.
     */
    public Nivel getNivel()
    {
    	return miNivel;
    }
    /**
     * Destruye la pared que se encuentra en la celda.
     */
    public void destruir() 
    {
    	if(estado.isDestructible())
    	{
    		if(estado.getPowerUp()!=null)
    			power=estado.getPowerUp();
    		ImageIcon image=new ImageIcon (this.getClass().getResource("../../Grafica/Sprites/piso.png"));
    		grafico.getGrafico().setIcon(image);
    		miNivel.getJuego().getGui().repaint();
    	    estado=null;
    	}
    }

    /**
     * Retorna el PowerUp que se encuentra en la celda,
     * en caso de no existir retorna null.
     * @return PowerUp.
     */
    public PowerUp getPowerUp() {
        return power;
    }

    /**
     * Retorna la pared de la celda,
     * en caso de no existir retorna null.
     * @return
     */
    public Pared getPared() {
        return estado;
    }
    
    /**
     * Le asigna un powerUp a la celda.
     * @param PowerUp.
     */
    
    public void setPowerUp(PowerUp p)
    {
    	power=p;
    }
    /**
     * Retorna el Bomberman que se encuentra 
     * en la celda, en caso de que no exista 
     * un Bomberman retorna null.
     * @return Bomberman
     */
    public Bomberman getBomberman()
    {
    	return bomberman;
    }
    /**
     * Coloca un Bomberman en la Celda.
     * @param Bomberman.
     */
    public void setBomberman(Bomberman b)
    {	
    	bomberman=b;
    }
    /**
     * Retorna el Enemigo que se encuentra en la celda,
     * en caso contrario retorna null.
     * @return Enemigo.
     */
    public Enemigo getEnemigo() {
        return enemigo;
    }
    /**
     * Coloca un Enemigo en la celda.
     * @param Enemigo.
     */
    public void setEnemigo(Enemigo e)
    {
    	enemigo=e;
    }
    /**
     * Retorna las celdas que se encuentran
     * en forma lineal a una ditancia recibida
     * como parámetro.
     * @param int alc 
     * @return Vector<Celda>
     */
    public Vector<Celda> getAdyacentes(int alc) 
    {
       Vector<Celda> salida=new Vector<Celda>();
       boolean izq,der,arr,abj;
       izq=der=arr=abj=true;
       for(int i=1;i<=alc && (izq || der || arr || abj);i++)
       {
    	   if(izq)
    	   {
    		   Celda aux=miNivel.getCelda(x-i, y);
    		   salida.addElement(aux);
    		   if(aux.getPared()!=null)
    			   izq=false;
    	   }
    	   if(der)
    	   {
    		   Celda aux=miNivel.getCelda(x+i, y);
    		   salida.addElement(aux);
    		   if(aux.getPared()!=null)
    			   der=false;
    	   }
    	   if(arr)
    	   {
    		   Celda aux=miNivel.getCelda(x, y-i);
    		   salida.addElement(aux);
    		   if(aux.getPared()!=null)
    			   arr=false;
    	   }
    	   if(abj)
    	   {
    		   Celda aux=miNivel.getCelda(x, y+i);
    		   salida.addElement(aux);
    		   if(aux.getPared()!=null)
    			   abj=false;
    	   }
       }
       return salida;
    }
    /**
     * Retorna el componente gráfico 
     * asociado a la celda.
     * @return JLabel.
     */
    public JLabel getGrafico()
    {
		return this.grafico.getGrafico();
	}
    
    public void incendiar(){
    	try {
			this.grafico.prenderFuego();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}