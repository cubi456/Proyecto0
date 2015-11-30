package Grafica.PowerUps;

import Grafica.CargadorGrafico;

public class SpeedUpGrafico extends PowerUpGrafico{
	public SpeedUpGrafico(CargadorGrafico gc){
		super();
		imagen=gc.getSpeed();
	}
}
