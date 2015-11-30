package Sonidos;

import java.io.BufferedInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import Grafica.CargadorGrafico;

public class SonidoComenzar extends Sonido
{
	public SonidoComenzar(CargadorGrafico cg)
	{
		try {
			clip=AudioSystem.getClip();
			BufferedInputStream bis= new BufferedInputStream(getClass().getResourceAsStream("Sounds/Comenzar.wav"));
			audio=AudioSystem.getAudioInputStream(bis);
			//audio=AudioSystem.getAudioInputStream(cg.getAComenzar());
			clip.open(audio);
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
	}
	
}
