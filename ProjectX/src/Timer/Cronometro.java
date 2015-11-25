package Timer;


import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JLabel;

public class Cronometro extends Thread 
{
 
	private volatile JLabel tiempo;
	private int m,s,cs;
	private volatile boolean stop;
	
	public Cronometro()
	{
		stop=false;
		m=s=cs=0;
		tiempo = new JLabel("Time: 00:00:00");
		InputStream is=this.getClass().getResourceAsStream("../Grafica/Fonts/Prototype.ttf");
		try {
			tiempo.setFont(Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(1, 18));
			tiempo.setForeground(Color.white);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run()
	{
		while(!stop)
		{
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			cs++;
			if(cs==100)
			{
                cs = 0;
                s++;
            }
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
		this.interrupt();
		this.stop=true;
	}
	
	public void actualizarLabel()
	{
		tiempo.setText("Time: "+m+":"+s+":"+cs);
	}
	
	public JLabel getGrafico()
	{
		return tiempo;
	}
}
