
package Logica;
import java.util.*;


import Grafica.PowerUps.BombalityGrafico;
import Grafica.PowerUps.FatalityGrafico;
import Grafica.PowerUps.MasacralityGrafico;
import Grafica.PowerUps.PowerUpGrafico;
import Grafica.PowerUps.SpeedUpGrafico;
import Logica.Bloques.Celda;
import Logica.Bloques.ControladorBloques;
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
    protected ControladorBloques paredes;
    /**
     * Recibe un arreglo de enteros con la cantidad de cada power up
     * y el juego donde se encuentra y crea un nuevo nivel.
     * @param int [] pu, Juego j.
     */
    public Nivel(int[] pu, Juego j) {
        miJuego=j;
        crearPowerUps(pu);
        celdas= new Celda[31][13];
        Random random= new Random();
        int cant=0;
        int  cantDest=145;
        for(int f=0; f<celdas.length; f++)
        {
        	for(int c=0; c< celdas[0].length; c++){        
        		boolean espLibre = ((f==1 && c==1)||(f==1 && c==2)||(f==2 && c==1)||(f==28 && c==11)||(f==29 && c==10)||(f==29 && c==11));
        		 if((c+1==celdas[0].length || c==0)||(f==0 || f+1==celdas.length) || (f%2==0 && c%2==0))
        		    celdas[f][c]= new Celda(f, c,new Pared(null,false),this);
        		 else{
        			 //Hay 360 casilleros, 70 ya utilizados por los bloques, ahora se desparraman en 
        			 //teoria 290
        			 if((random.nextInt(2)== 0 && cantDest>0 && !espLibre)){ // numero entre 0 o 1;
             			celdas[f][c]= new Celda(f, c,new Pared(null,true),this);
             			cant++;
             			cantDest--;
             		}
             		else
             				celdas[f][c]=new Celda(f,c,null,this);
        		 }
        		 miJuego.getGui().getContenedor().add(celdas[f][c].getGrafico(), 0); 
        	}
        }
        crearPowerUps(pu);
        designarPowerUps();
        paredes=new ControladorBloques(cant);
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
     * @param pu[]
     */
    private void crearPowerUps(int []pu)
    {
    	misPower=new Vector<PowerUp>();
    	for(int i=0;i<pu.length;i++)
    	   for(int j=pu[i];j>0;j--)
    		   addPowerUp(i);    
    }
    /**
     * Asigna los lugares correspondientes de los PowerUps de manera Aleatoria
     */
    private void designarPowerUps(){
    	Random gen= new Random();
    	int x,y;
    	boolean asigne=false;
    	while(!misPower.isEmpty()){
    		while (!asigne){
    			x=gen.nextInt(29)+1;
    			y=gen.nextInt(11)+1;
    			Pared p= this.getCelda(x, y).getPared();
    			if(p!=null && p.isDestructible() && p.getPowerUp()==null){
    				p.setPowerUp(misPower.remove(misPower.size()-1));
    				//System.out.println("PU en X: "+x+" Y: "+y);
    				asigne=true;
    			}
    		}
    		asigne=false;
    	}
    }
    /**
     * Devuelve el controlador de bloques
     * @return ControladorBloques 
     */

    public ControladorBloques getControlador()
    {
    	return paredes;
    }
 
}