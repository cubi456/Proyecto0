
package Logica;
import java.util.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Grafica.GUI;
import Grafica.PowerUps.BombalityGrafico;
import Grafica.PowerUps.FatalityGrafico;
import Grafica.PowerUps.MasacralityGrafico;
import Grafica.PowerUps.PowerUpGrafico;
import Grafica.PowerUps.SpeedUpGrafico;
import Logica.Bloques.Celda;
import Logica.Bloques.Pared;
import Logica.PowerUps.Bombality;
import Logica.PowerUps.Fatality;
import Logica.PowerUps.Masacrality;
import Logica.PowerUps.SpeedUp;

/**
 *@author Barreix, Iñaki.
 *@author Comellas, Juan Manuel.
 *@version 1.0
 */
public class Nivel
{

    protected Juego miJuego;
    protected Celda[][] celdas;
    protected Vector<PowerUp> misPower;
    /**
     * Recibe un arreglo de enteros con la cantidad de cada power up
     * y el juego donde se encuentra y crea un nuevo nivel.
     * @param int [] pu, Juego j.
     */
    public Nivel(int[] pu, Juego j) {
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
        		 miJuego.getGui().getContenedor().add(celdas[f][c].getGrafico(), 0); 
        	}
        }
        //Prueba speedUp
       celdas[2][1].setPowerUp(misPower.elementAt(0)); 
       misPower.elementAt(0).getGrafico().setPos(2, 1);
       miJuego.getGui().getContenedor().add(misPower.elementAt(0).getGrafico().getGrafico(),2);
       //Prueba Bombality
       celdas[5][1].setPowerUp(misPower.elementAt(4)); 
       misPower.elementAt(4).getGrafico().setPos(4, 1);
       miJuego.getGui().getContenedor().add(misPower.elementAt(4).getGrafico().getGrafico(),2);

    }
    

 


    /**
     * Retorna una colección de powerUps representada con un vector.
     * @return Vector<PowerUp>
     */
    public Vector<PowerUp> getPowerUps() {
        return misPower;
    }

    /**
     * Recibe las cordenadas de una celda del nivel y la retorna.
     * @param int x 
     * @param int y 
     * @return Celda
     */
    public Celda getCelda(int x, int y){
        return celdas[x][y];
    }

    /**
     * Agrega elementos a una colección de powerUp.
     * @param int i.
     */
    
    private void addPowerUp(int i)
    {
    	PowerUpGrafico p;
    	switch(i)
    	{
    		case 0:{
    				p=new SpeedUpGrafico();
    				PowerUp aux=new SpeedUp(p);
    				misPower.addElement(aux);
    				break;
    			   }
    		case 1:{
    				p=new FatalityGrafico();
    				PowerUp aux=new Fatality(p);
    				misPower.addElement(aux);
    				break;
    			   }
    		case 2:{
    				p= new BombalityGrafico();
    				PowerUp aux=new Bombality(p);
    				misPower.addElement(aux);
    				break;
    			   }
    		case 3:{
    				p=new MasacralityGrafico();
    				PowerUp aux=new Masacrality(p);
    				misPower.addElement(aux);
    				break;
    			   }
    	}
    }
    
    /**
     * Retorna el juego donde se encuentra el Nivel.
     * @return Juego.
     */
    public Juego getJuego()
    {
    	return miJuego;
    }
    /**
     * 
     * Genera los powerUp del nivel.
     * @param pu
     */
    private void crearPowerUps(int []pu)
    {
    	misPower=new Vector<PowerUp>();
    	for(int i=0;i<pu.length;i++)
    	   for(int j=pu[i];j>0;j--)
    		   addPowerUp(i);    
    }
    /** */

}