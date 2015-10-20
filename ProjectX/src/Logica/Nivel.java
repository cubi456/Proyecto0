
package Logica;
import java.util.*;

/**
 * 
 */
public class Nivel {

    protected Juego miJuego;
    protected Celda[][] celdas;
    protected Vector<PowerUp> misPower;
    /**
     * @param powerUp int Arr
     */
    /**ISB Modificacion constructor, se pasa el jeugo a si mismo*/
    public Nivel(int[] pu, Juego j) {
        //miJuego= new Juego(); /** SI CREAMOS EL JUEGO NO ES EL MISMO **/
        miJuego=j;
        crearPowerUps(pu);
        celdas= new Celda[31][13];
        for(int f=0; f<celdas.length; f++)
        {
        	for(int c=0; c< celdas[0].length; c++)
        	{
        		 if(c+1==celdas[0].length || c==0)
        		    celdas[f][c]= new Celda(f, c,new Pared(null,false),this);
        		 else
        		 {
        	        if(f==0 || f+1==celdas.length)
        	        	celdas[f][c]=new Celda(f,c,new Pared(null,false),this);
        	        else
        	        	celdas[f][c]=new Celda(f,c,null,this); 
        		 }
        	}
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
    public Vector<PowerUp> getPowerUps() {
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
    
    private void addPowerUp(int i)
    {
    	switch(i)
    	{
    		case 0:{
    				PowerUp aux=new SpeedUp();
    				misPower.addElement(aux);
    				break;
    			   }
    		case 1:{
    				PowerUp aux=new Fatality();
    				misPower.addElement(aux);
    				break;
    			   }
    		case 2:{
    				PowerUp aux=new Bombality();
    				misPower.addElement(aux);
    				break;
    			   }
    		case 3:{
    				PowerUp aux=new Masacrality();
    				misPower.addElement(aux);
    				break;
    			   }
    	}
    }
    
    private void crearPowerUps(int []pu)
    {
    	misPower=new Vector<PowerUp>();
    	for(int i=0;i<pu.length;i++)
    	   for(int j=pu[i];j>0;j--)
    		   addPowerUp(i);    
    }

}