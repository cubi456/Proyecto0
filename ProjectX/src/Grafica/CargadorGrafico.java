package Grafica;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class CargadorGrafico{
	/**
	 * Esta clase es la encargada de cargar todos los sprites de todo el juego
	 */
	
	private Icon[] bDestAnimacion, bomb, fire, background, twin, tlose, bmgif, gover, bComenzar, bSalir, bSonido, rsg;
	private Icon bDest, bSuelo, bInd, bombality, masacrality, fatality, speed, bombRender, title;
	private Vector<Vector<Icon>> bm, altair, sirius,rugulus, bombDios;
	private Font fPrototype;
	private BufferedInputStream abombality, aspeed, amasacrality, abomba, acomenzar, asalir, agame, amenu;
	public CargadorGrafico(){
		//	Sprite Juego
		crearBgYCarteles();
		crearBombGif();
		crearGO();
		crearPrincipal();
		crearBotones();
		crearRSG();
		//	Sprites Nivel
		crearbSuelo();
		crearbInd();
		crearbDest();
		crearpDestAnimacion();
		crearFuego();
		crearBomba();
		//	Sprites Personajes
		crearPersonajes();
		
		//	Sprites PU
		crearPU();
		crearFonts();
		
	}

	
	private void crearRSG(){
		rsg= new Icon[3];
		for(int i=0; i<rsg.length;i++)
			rsg[i]=new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/CartelesSalida/rsg0"+i+".png"));
	}
	private void crearBotones(){
		bComenzar= new Icon[2];
		bSalir=	new Icon[2];
		bSonido= new Icon[2];
		for(int i=0; i<bComenzar.length;i++){
			bComenzar[i]= new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/Botones/comenzar0"+i+".png"));
			bSalir[i]= new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/Botones/salir0"+i+".png"));
			bSonido[i]= new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/Botones/musica0"+i+".png"));
		}
	}
	private void crearBgYCarteles(){
		this.background=new Icon[5];
		this.twin=new Icon[5];
		this.tlose=new Icon[5];				
		for(int i=0; i<background.length; i++){
			background[i]=new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/Backgrounds/Background0"+i+".png"));	
			twin[i]=new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/CartelesSalida/win0"+i+".png"));
			tlose[i]=new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/CartelesSalida/lose0"+i+".png"));
		}
	}
	
	private void crearBombGif(){
		//Bomberman giff
		this.bmgif= new Icon[2];
		bmgif[0]=new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/Bombermanwin.gif"));
		bmgif[1]=new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/Bombermanlose.gif"));
	}
	
	private void crearGO(){
	// cartel de gameOver
	gover=new Icon[8];
	for(int i=0; i<gover.length; i++)
		gover[i]=new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/CartelesSalida/gameover0"+i+".png"));
	}
	
	private void crearPrincipal(){
		bombRender=new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/BombermanRender00.png"));
		title=new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/title.png"));
	}
	private void crearPU(){
		bombality= new ImageIcon(this.getClass().getResource("../Grafica/Sprites/PU/PU_Bombality.png"));
		masacrality= new ImageIcon(this.getClass().getResource("../Grafica/Sprites/PU/PU_Masacrality.png"));
		fatality= new ImageIcon(this.getClass().getResource("../Grafica/Sprites/PU/PU_Fatality.png"));
		speed= new ImageIcon(this.getClass().getResource("../Grafica/Sprites/PU/PU_Speedup.png"));
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
	
	private void crearFonts(){
		InputStream is=this.getClass().getResourceAsStream("../Grafica/Fonts/Prototype.ttf");
		try {
			fPrototype =Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * GETTERS
	 * 
	 */
	
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
	
	public Icon[] getBackground(){
		return background;
	}
	
	public Icon[] getWin(){
		return twin;
	}
	
	public Icon[] getLose(){
		return tlose;
	}
	
	public Icon[] getBombGif(){
		return bmgif;
	}
	
	public Icon[] getGameOver(){
		return gover;
	}
	
	public Icon getFatality(){
		return fatality;
	}
	
	public Icon getMasacrality(){
		return masacrality;
	}
	
	public Icon getBombality(){
		return bombality;
	}
	
	public Icon getSpeed(){
		return speed;
	}
	
	public Icon getBombRender(){
		return bombRender;
	}
	
	public Icon getTitle(){
		return title;
	}
	
	public Icon[] getBComenzar(){
		return bComenzar;
	}
	
	public Icon[] getBSalir(){
		return bSalir;
	}
	
	public Icon[] getBSonido(){
		return bSonido;
	}
	
	public Font getFPrototype(){
		return fPrototype;
	}
	
	public Icon[] getRSG(){
		return rsg;
	}
	
	public BufferedInputStream getABombality(){
		return abombality;
	}
	
	public BufferedInputStream getASpeed(){
		return aspeed;
	}
	
	public BufferedInputStream getAMasacrality(){
		return amasacrality;
	}
	
	public BufferedInputStream getABomba(){
		return abomba;
	}
	
	public BufferedInputStream getASalir(){
		return asalir;
	}
	public BufferedInputStream getAComenzar(){
		return acomenzar;
	}
	
	public BufferedInputStream getAGame(){
		return agame;
	}
	
	public BufferedInputStream getAMenu(){
		return amenu;
	}
}
