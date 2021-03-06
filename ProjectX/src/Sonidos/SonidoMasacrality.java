package Sonidos;

import java.io.BufferedInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class SonidoMasacrality extends Sonido
{
	public SonidoMasacrality()
	{
		try {
			clip=AudioSystem.getClip();
			BufferedInputStream bis= new BufferedInputStream(getClass().getResourceAsStream("Sounds/Masacrality.wav"));
			audio=AudioSystem.getAudioInputStream(bis);
			clip.open(audio);
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
	}
	public void reproducir(){
		super.reproducir();
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
}
