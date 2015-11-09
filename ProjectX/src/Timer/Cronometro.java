package Timer;

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
		tiempo = new JLabel("00:00:00");
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
	
	public void detener()
	{
		stop=true;
		this.interrupt();
	}
	
	public void actualizarLabel()
	{
		tiempo.setText(m+":"+s+":"+cs);
	}
	
	public JLabel getGrafico()
	{
		return tiempo;
	}
}
