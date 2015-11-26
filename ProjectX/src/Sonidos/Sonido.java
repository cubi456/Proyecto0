package Sonidos;


import java.util.ResourceBundle.Control;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.Clip;

public abstract class Sonido 
{
	protected Clip clip;
	protected boolean mute=false;
	protected AudioInputStream audio;
	
	public void reproducir()
	{
		clip.start();
	}
	public void detener()
	{
		clip.stop();
		clip.close();
	}
	
	public void mute()
	{
		if(mute)
			reproducir();
		else
			clip.stop();
		mute=!mute;
	}
	
}
