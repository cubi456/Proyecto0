package Thread;
import java.awt.EventQueue;

import Grafica.GUI;
import Logica.*;

public class Starter implements Runnable
{
	
	private volatile boolean detener;
	private static GUI gui;
	
	public static void main(String []args)
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui = new GUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Starter()
	{
		detener=false;
	}
	
	public void run()
	{
		
		while(!this.detener)
		{
			
		}
	}
}
