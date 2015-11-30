package Timer;


import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

import Grafica.CargadorGrafico;

/**
 *@author Barreix, Iñaki.
 *@author Comellas, Juan Manuel.
 *@version 1.0
 */
public class Cronometro extends Thread 
{
 
	private volatile JLabel tiempo, tiempo2;
	private int m,s;
	private volatile boolean stop;
	/**
	 * Clase absoluta solo para controlar el tiempo
	 * @param cg Utiliza el CargadorGrafico para obtener la fuente
	 */
	public Cronometro(CargadorGrafico cg)
	{
		stop=false;
		m=s=0;
		tiempo = new JLabel("Tempo: 0:0");
		tiempo2= new JLabel("");
		Font fuente=cg.getFPrototype();
		tiempo.setFont(fuente.deriveFont(1, 18));
		tiempo.setForeground(Color.white);
		tiempo2.setFont(fuente.deriveFont(1, 52));
		tiempo2.setForeground(Color.white);
	}
	
	public void run()
	{
		while(!stop)
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			s++;
            if(s==60) 
            {
                s = 0;
                m++;
            }
            actualizarLabel();
		}
	}
	
	public void destruir()
	{
		this.stop=true;
		
	}
	
	public void actualizarLabel()
	{
		tiempo.setText("Tiempo: "+m+":"+s);
	}
	
	public JLabel getGrafico()
	{
		return tiempo;
	}
	
	public JLabel getGrafico2(){
		tiempo2.setText("Tiempo: "+m+":"+s);
		return tiempo2;
	}
}
