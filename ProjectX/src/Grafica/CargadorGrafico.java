package Grafica;

import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class CargadorGrafico{
	/**
	 * Esta clase es la encargada de cargar todos los sprites de todo el juego
	 */
	private Icon[] bDestAnimacion, bomb, fire;
	private Icon bDest, bSuelo, bInd;
	private Vector<Vector<Icon>> bm, altair, sirius,rugulus, bombDios;
	public CargadorGrafico(){
		//Sprites del Juego
		
		//Sprites Nivel
		crearbSuelo();
		crearbInd();
		crearbDest();
		crearpDestAnimacion();
		crearFuego();
		crearBomba();
		crearPersonajes();
	}
	
	private void crearbSuelo(){
		bSuelo=new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Bloque/Piso.png"));
	}
	
	private void crearbInd(){
		bInd=new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Bloque/ParedSolida.png"));
	}
	
	private void crearbDest(){
		bDest=new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Bloque/ParedSolida.png"));
	}
	private void crearpDestAnimacion(){
		bDestAnimacion=new Icon[5];
		for(int i=0; i<bDestAnimacion.length;i++)
			bDestAnimacion[i]=new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Bloque/Destructible0"+i+".png"));
	}
	private void crearFuego(){
		fire= new Icon[5];
		for(int i=0; i<fire.length; i++)
			fire[i] = new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Fire/fire0"+i+".png"));		
	}
	private void crearBomba(){
		bomb= new Icon[3];
		for(int i=0; i<bomb.length; i++)
			bomb[i] = new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Bomba/Bomb0"+i+".png"));	
	}
	private void crearPersonajes(){

		//todos contienen la misma cantidad de vectores.
		bm=new Vector<Vector<Icon>>();
		altair=new Vector<Vector<Icon>>();
		sirius=new Vector<Vector<Icon>>();
		rugulus=new Vector<Vector<Icon>>();
		bombDios=new Vector<Vector<Icon>>();
		// Creamos la secuencia de imagenes para la izuierda
		bm.addElement(new Vector<Icon>());
		altair.addElement(new Vector<Icon>());
		sirius.addElement(new Vector<Icon>());
		rugulus.addElement(new Vector<Icon>());
		bombDios.addElement(new Vector<Icon>());
		for(int i=0;i<=7;i++){
			bm.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Bomberman/Left/Left0"+i+".png")));
			altair.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Altair/Left/Left0"+i+".png")));
			sirius.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Sirius/Left/Left0"+i+".png")));
			rugulus.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Rugulus/Left/Left0"+i+".png")));
			bombDios.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Dios/Left/Left0"+i+".png")));
		}	
		// Creamos la secuencia de imagenes para arriba
		bm.addElement(new Vector<Icon>());
		altair.addElement(new Vector<Icon>());
		sirius.addElement(new Vector<Icon>());
		rugulus.addElement(new Vector<Icon>());
		bombDios.addElement(new Vector<Icon>());
		
		for(int i=0;i<=7;i++){
			bm.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Bomberman/UP/UP0"+i+".png")));
			altair.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Altair/UP/UP0"+i+".png")));
			sirius.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Sirius/UP/UP0"+i+".png")));
			rugulus.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Rugulus/UP/UP0"+i+".png")));
			bombDios.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Dios/UP/UP0"+i+".png")));
		}
		
		// Creamos la secuencia de imagenes para derecha
		bm.addElement(new Vector<Icon>());
		altair.addElement(new Vector<Icon>());
		sirius.addElement(new Vector<Icon>());
		rugulus.addElement(new Vector<Icon>());
		bombDios.addElement(new Vector<Icon>());
		for(int i=0;i<=7;i++){
			bm.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Bomberman/Right/Right0"+i+".png")));
			altair.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Altair/Right/Right0"+i+".png")));
			sirius.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Sirius/Right/Right0"+i+".png")));
			rugulus.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Rugulus/Right/Right0"+i+".png")));
			bombDios.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Dios/Right/Right0"+i+".png")));
		}
		// Creamos la secuencia de imagenes para abajo
		bm.addElement(new Vector<Icon>());
		altair.addElement(new Vector<Icon>());
		sirius.addElement(new Vector<Icon>());
		rugulus.addElement(new Vector<Icon>());
		bombDios.addElement(new Vector<Icon>());
		for(int i=0;i<=7;i++){
			bm.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Bomberman/Down/Down0"+i+".png")));
			altair.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Altair/Down/Down0"+i+".png")));
			sirius.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Sirius/Down/Down0"+i+".png")));
			rugulus.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Rugulus/Down/Down0"+i+".png")));
			bombDios.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Dios/Down/Down0"+i+".png")));
		}
		
		// Creamos la secuencia de imagenes de muerte
		//OBS modo Dios no tiene muerte
		bm.addElement(new Vector<Icon>());
		altair.addElement(new Vector<Icon>());
		sirius.addElement(new Vector<Icon>());
		rugulus.addElement(new Vector<Icon>());
		for(int i=0;i<5;i++){
			bm.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Bomberman/Dead/Dead0"+i+".png")));
			altair.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Altair/Dead/Dead0"+i+".png")));
			sirius.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Sirius/Dead/Dead0"+i+".png")));
			rugulus.lastElement().addElement(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Rugulus/Dead/Dead0"+i+".png")));
		}
	}
	public Icon getBSuelo(){
		return bSuelo;
	}
	public Icon getBInd(){
		return bInd;
	}
	public Icon getBDest(){
		return bDest;
	}
	
	public Icon[] getBDestAnimacion(){
		return bDestAnimacion;
	}
	
	public Icon[] getFuego(){
		return fire;
	}
	
	public Icon[] getBomba(){
		return bomb;
	}

	
	public Vector<Vector<Icon>> getBomberman(){
		return bm;
	}
	
	public Vector<Vector<Icon>> getSirius(){
		return sirius;
	}
	
	public Vector<Vector<Icon>> getAltair(){
		return altair;
	}
	public Vector<Vector<Icon>> getBombDios(){
		return bombDios;
	}
	public Vector<Vector<Icon>> getRugulus(){
		return rugulus;
	}
}
