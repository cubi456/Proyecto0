package Grafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Juego;
import Logica.Jugador.Bomberman;
import Sonidos.Sonido;
import Sonidos.SonidoComenzar;
import Sonidos.SonidoJuego;
import Sonidos.SonidoMenu;
import Sonidos.SonidoSalir;
import Timer.Cronometro;

public class GUI extends JFrame implements ActionListener,KeyListener
{
	private Bomberman b;
	private static final long serialVersionUID = 1L;
	private Vector<JComponent> componentesJuego, compSalida;
	private JPanel contenedor;
	private JLabel bg, bgAux, bm, tl, puntaje;
	private Juego juego;
	private JButton comenzar,salir,musica;
	private int direccion=-1;
	private Cronometro tiempo;
	private boolean silencio, pantallaJuego;
	private Icon activo,inactivo;
	private Icon[] background, bmgif, twin, tlose, gover;
	private Sonido sonidoM,sonidoJ;
	
	private boolean lock=false;
	/**
	 *  Enciende la aplicacion
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run(){
				try{
					GUI ventana= new GUI();
					ventana.setVisible(true);
				}catch(Exception e ){
					e.printStackTrace();
				}
			}
			
		});
	}

/**
 * 
 *	Creacion de la ventana 
 * 
*/
	public GUI(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 100, 100, 600);
		setSize(new Dimension(998, 500));
		setTitle("Bomberman");
		setResizable(false);
		setIconImage(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/Iconos/icon03.png")).getImage());
		contenedor = new JPanel();
		contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contenedor);
		contenedor.setLayout(null);
		componentesJuego = new Vector<JComponent>();
		compSalida=new Vector<JComponent>();
		this.addKeyListener(this);
		this.setFocusable(true);
		cargarBackgrounds();
		bg=new JLabel(background[0]); 
		bg.setBounds(0, 0,998, 500);
		contenedor.add(bg,0);
		crearMenu();		
	}


	private void crearMenu(){
		sonidoM=new SonidoMenu();
		bm=new JLabel(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/BombermanRender00.png")));
		bm.setBounds(570, 20, 420, 423);
		contenedor.add(bm,0);
		tl=new JLabel(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/title.png")));
		tl.setBounds(100, 20, 458, 117);
		contenedor.add(tl,0);
		compSalida.add(bm);
		compSalida.add(tl);
		
		// CargaBotones
		
		
		comenzar=new JButton(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/Botones/comenzar00.png")));
		comenzar.setActionCommand("comenzar");
		comenzar.addActionListener(this);
		comenzar.setRolloverIcon(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/Botones/comenzar01.png")));
		comenzar.setOpaque(false);
		comenzar.setContentAreaFilled(false);
		comenzar.setBorderPainted(false);
		
		salir=new JButton(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/Botones/salir00.png")));
		salir.setActionCommand("salir");
		salir.addActionListener(this);
		salir.setRolloverIcon(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/Botones/salir01.png")));
		salir.setOpaque(false);
		salir.setContentAreaFilled(false);
		salir.setBorderPainted(false);
		//los agrega a la pantalla
		agregarBotones();
		
		activo=new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/Botones/conMusica.png"));
		inactivo=new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/Botones/sinMusica.png"));
		musica=new JButton(activo);
		musica.setActionCommand("musica");
		musica.addActionListener(this);
		musica.setRolloverIcon(inactivo);
		musica.setOpaque(false);
		musica.setContentAreaFilled(false);
		musica.setBorderPainted(false);
		musica.setBounds(820,430,32,32);
		contenedor.add(musica,0);
		silencio=false;
		
		//Bomberman giff
		this.bmgif= new Icon[2];
		bmgif[0]=new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/Bombermanwin.gif"));
		bmgif[1]=new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/Bombermanlose.gif"));
		
		puntaje=new JLabel();
		// Se utiliza para que JLabel aparezca mas rapido
		bgAux=new JLabel();
		
		
		// cartel de gameOver
		gover=new Icon[8];
		for(int i=0; i<gover.length; i++)
			gover[i]=new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/CartelesSalida/gameover0"+i+".png"));
		sonidoM.reproducir();
	}
	
	private void cargarBackgrounds(){	
		this.background=new Icon[5];
		this.twin=new Icon[5];
		this.tlose=new Icon[5];				
		for(int i=0; i<background.length; i++){
			background[i]=new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/Backgrounds/Background0"+i+".png"));	
			twin[i]=new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/CartelesSalida/win0"+i+".png"));
			tlose[i]=new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/CartelesSalida/lose0"+i+".png"));
		}
	}
	
	private void iniciarJuego(){
		sonidoJ=new SonidoJuego();
		pantallaJuego=true;
		juego= new Juego(this);
		b=juego.getBomberman();
		b.getPuntaje().getGrafico().setBounds(870, 410, 128,64);
		contenedor.add(b.getPuntaje().getGrafico(),1);
		componentesJuego.add(b.getPuntaje().getGrafico());
		juego.getNivel(0).getControlador().getGrafico().setBounds(140, 410, 256, 64);
		contenedor.add(juego.getNivel(0).getControlador().getGrafico(),1);
		componentesJuego.add(juego.getNivel(0).getControlador().getGrafico());
		tiempo = new Cronometro();
		tiempo.getGrafico().setBounds(10, 410, 128, 64);
		contenedor.add(tiempo.getGrafico(),1);
		componentesJuego.add(tiempo.getGrafico());
		sonidoJ.reproducir();
		tiempo.start();
	}

	public void mover (KeyEvent key)
	{
		if(!lock)
		{
			direccion=key.getKeyCode();
			this.lock=true;
		}
	}
	
	public void toggleLock()
	{
		this.lock=!this.lock;
	}
	
	public boolean getLock()
	{
		return lock;
	}
	
	public int getDireccion()
	{
		return direccion;
	}
	
	public JPanel getContenedor()
	{
		return contenedor;
	}
	
	private void iniciar()
	{
		if (juego == null) {
			//Quita los elementos de pantalla
			for(JComponent c:compSalida){
				contenedor.remove(c);
				c=null;
			}
			Sonido s=new SonidoComenzar();
			s.reproducir();
			sonidoM.detener();
			sonidoM=null;
			this.repaint();
			iniciarJuego();
		}
	}
	
	public void reset()
	{
		for(JComponent d: compSalida){
			contenedor.remove(d);
			d=null;
		}
		for(JComponent c: componentesJuego)
		{
			contenedor.remove(c);
			c=null;
		}
		contenedor.repaint();
		if(sonidoM!=null)
		{
			sonidoM.detener();
			sonidoM=null;
		}
		else
		{
			sonidoJ.detener();
			sonidoJ=null;
		}
		bg.setIcon((new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/Backgrounds/Background00.png"))));
		musica.setBounds(820,430,32,32);
		System.gc();
		iniciarJuego();
	}

	public void keyPressed(KeyEvent arg0) 
	{
		int keyCode= arg0.getKeyCode();
		if (keyCode == KeyEvent.VK_ENTER) {
			if(!pantallaJuego) 		// Si no estoy dentro del juego
				if(juego==null)		// si no hay juego creado comienzo
					iniciar();
				else
					reset();		//Sino restarteo
		}
		else
			if(keyCode==KeyEvent.VK_ESCAPE)
				salir();
			else
				if(keyCode==KeyEvent.VK_R)
					reset();
				else
					if(keyCode==KeyEvent.VK_S)
						toggleSound();
					else
							mover(arg0);
	}

	public void keyReleased(KeyEvent arg0) 
	{

	}

	public void keyTyped(KeyEvent arg0)
	{
		
	}

	public void actionPerformed(ActionEvent arg0) 
	{
		if(arg0.getActionCommand().equals("comenzar"))
			if(juego==null)
				this.iniciar();
			else
				reset();
		if(arg0.getActionCommand().equals("salir"))
			salir();
		if(arg0.getActionCommand().equals("musica"))
			toggleSound();
		this.requestFocus();
	}
	
	private void toggleSound()
	{
		if(sonidoM!=null)
			sonidoM.mute();
		else
			sonidoJ.mute();
		if(silencio)
		{
			musica.setIcon(inactivo);
			musica.setEnabled(true);
			musica.setRolloverIcon(activo);
		}	
		else
		{
			musica.setIcon(activo);
			musica.setEnabled(true);
			musica.setRolloverIcon(inactivo);
		}
		silencio=!silencio;
	}
	
	public void agregarJuego(JComponent c,int index)
	{
		if(pantallaJuego){
		//	Se le suma uno al indice dejando en ind 0 a los comp de pantalla
			contenedor.add(c,index+1);
			componentesJuego.add(c);
		}
	}
	
	public void sacarJuego(JComponent c)
	{
		contenedor.remove(c);
		componentesJuego.removeElement(c);
	}
	
	private void salir()
	{
		if(sonidoM!=null)
		{
			sonidoM.detener();
			Sonido salir=new SonidoSalir();
			salir.reproducir();
			try {
				Thread.sleep(600);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
			sonidoJ.detener();
		
		System.exit(0);
	}

	private void mostrarCartel(){
		/**
		 * Ademas de colocar el cartel de juego terminado da lugar a que algunos hilos terminen(logicamente)
		 */
		JLabel go=new JLabel();
		go.setIcon(gover[0]);
		go.setBounds(356, 150, 285, 199);
		contenedor.add(go, 1);
		for(int i=0;i<gover.length;i++)
		{
			go.setIcon(gover[i]);
			go.setBounds(356, 150, 285, 199);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		contenedor.remove(go);
	
	}
	public void gameOver(boolean victoria, int p){
		// variable game over pregunta si el juego termino bien o mal
		pantallaJuego=false;
		mostrarCartel();
		Random gen=new Random();
		int colorbg=gen.nextInt(4)+1;
		bgAux.setIcon(background[colorbg]);
		bgAux.setBounds(0, 0,998, 500);
		contenedor.add(bgAux,1);
		contenedor.repaint();
		tiempo.destruir();
		
		if(victoria){
			bm.setIcon(bmgif[0]);
			tl.setIcon(twin[tenerDistinto(colorbg, gen)]);
		}
		else{
			bm.setIcon(bmgif[1]);
			tl.setIcon(tlose[tenerDistinto(colorbg, gen)]);
		}
		bm.setBounds(570, 77, 400, 400);
		tl.setBounds(70, 20, 860, 100);
		contenedor.add(bm,1);
		contenedor.add(tl,1);
		musica.setBounds(860,430,32,32);
		
		compSalida.add(bm);
		compSalida.add(bgAux);
		ponerMusicaMenu();
		ponerPuntaje(p);
		ponerTiempo();
		quitarComponentesJuego();
		agregarBotones();		
		contenedor.repaint();
		
	}
	
	private int tenerDistinto(int ant, Random gen){
		int nuevo=gen.nextInt(5);
		if(nuevo!=ant)
			return nuevo;
		else 
			return tenerDistinto(ant, gen);
	}

	private void ponerMusicaMenu(){
		sonidoJ.detener();
		sonidoJ=null;
		sonidoM=new SonidoMenu();
		sonidoM.reproducir();
	}
	
	private void ponerPuntaje(int p){
		puntaje=new JLabel("Puntaje: "+p);
		InputStream is=this.getClass().getResourceAsStream("Fonts/Prototype.ttf");
		try {
			puntaje.setFont(Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(1, 52));
			puntaje.setForeground(Color.white);
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
		}		
		puntaje.setBounds(40, 400, 350, 60);
		contenedor.add(puntaje, 0);
		compSalida.add(puntaje);
	}
	
	private void ponerTiempo(){		
		tiempo.getGrafico().getFont().deriveFont(1, 52);
		tiempo.getGrafico().setBounds(40,340,350,60);
		contenedor.add(tiempo.getGrafico(), 0);
		compSalida.add(tiempo.getGrafico());
	}
	
	private void quitarComponentesJuego(){
		for(JComponent c:componentesJuego)
		{
			contenedor.remove(c);
			c=null;
		}
	}
	
	private void agregarBotones(){
		comenzar.setBounds(160,160,350,50);
		contenedor.add(comenzar,1);
		compSalida.add(comenzar);
		salir.setBounds(200,220,350,50);
		contenedor.add(salir,1);
		compSalida.add(salir);
	}	
}