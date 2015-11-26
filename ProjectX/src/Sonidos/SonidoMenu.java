package Sonidos;

import java.io.BufferedInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SonidoMenu extends Sonido
{
	
	public SonidoMenu()
	{
		try {
			clip=AudioSystem.getClip();
			BufferedInputStream bis= new BufferedInputStream(getClass().getResourceAsStream("Sounds/MenuSound.wav"));
			audio=AudioSystem.getAudioInputStream(bis);
			clip.open(audio);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
	}
	
	public void mute()
	{
		if(mute)
			clip.stop();
		else
		{
			super.reproducir();
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		}
		mute=!mute;
	}
}