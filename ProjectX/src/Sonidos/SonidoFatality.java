package Sonidos;

import java.io.BufferedInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SonidoFatality extends Sonido
{
	public SonidoFatality()
	{
		try {
			clip=AudioSystem.getClip();
			BufferedInputStream bis= new BufferedInputStream(getClass().getResourceAsStream("Sounds/Fatality.wav"));
			audio=AudioSystem.getAudioInputStream(bis);
			clip.open(audio);
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
	}
	
}
