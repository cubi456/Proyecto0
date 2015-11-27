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
	private Vector<JComponent> componentes;
	private JPanel contenedor;
	private JLabel bg, tl, bm, bombLose;
	private Juego juego;
	private JButton comenzar,salir,musica;
	private int direccion=-1;
	private Cronometro tiempo;
	private boolean silencio;
	private Icon activo, inactivo;
	private Sonido sonidoM,sonidoJ;
	private Icon[] bombGane, win, lose, backgrounds;
	
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
		componentes = new Vector<JComponent>();
		this.addKeyListener(this);
		this.setFocusable(true);
		armarBackgrounds();
		bg=new JLabel(backgrounds[0]); 
		bg.setBounds(0, 0,998, 500);
		contenedor.add(bg,0);
		crearMenu();
			
	}
	
	private void armarBackgrounds(){		
		this.backgrounds=new Icon[5];
		for(int i=0; i<backgrounds.length; i++)
			backgrounds[i]=new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/Backgrounds/Background0"+i+".png"));
	
	}

	private void crearMenu(){
		sonidoM=new SonidoMenu();
		JLabel bm=new JLabel(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/BombermanRender00.png")));
		bm.setBounds(570, 20, 420, 423);
		contenedor.add(bm,0);
		JLabel tl=new JLabel(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/title.png")));
		tl.setBounds(100, 20, 458, 117);
		contenedor.add(tl,0);
		componentes.add(bm);
		componentes.add(tl);
		
		//Botones
		
		
		comenzar=new JButton(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/Botones/comenzar00.png")));
		comenzar.setActionCommand("comenzar");
		comenzar.addActionListener(this);
		comenzar.setRolloverIcon(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/Botones/comenzar01.png")));
		comenzar.setOpaque(false);
		comenzar.setContentAreaFilled(false);
		comenzar.setBorderPainted(false);
		comenzar.setBounds(160,160,350,50);
		contenedor.add(comenzar,0);
		componentes.add(comenzar);
		
		salir=new JButton(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/Botones/salir00.png")));
		salir.setActionCommand("salir");
		salir.addActionListener(this);
		salir.setRolloverIcon(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/Botones/salir01.png")));
		salir.setOpaque(false);
		salir.setContentAreaFilled(false);
		salir.setBorderPainted(false);
		salir.setBounds(200,220,350,50);
		contenedor.add(salir,0);
		componentes.add(salir);
		
		
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
		
		// Carga imagenes de pantalla score
		// de salida
		this.bombGane=new Icon[7];
		for(int i=0; i<bombGane.length-1; i++)
			bombGane[i]=new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/Ganaste/gane0"+i+".png"));
		bombGane[6]=new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/Ganaste/gane06.gif"));
		
		// carteles de ganar
		this.win=new Icon[4];
		for(int i=0; i<win.length; i++)
			win[i]=new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/CartelesSalida/win0"+i+".png"));
		
		//carteles de perder
		this.lose=new Icon[4];
		for(int i=0; i<lose.length; i++)
			lose[i]=new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/CartelesSalida/lose0"+i+".png"));
		
		bombLose= new JLabel(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/Bombermanlose02.gif")));
		
		// Game Over
		/*		JLabel go=new JLabel(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/gameOver.gif")));
		go.setBounds(356, 150, 285, 199);
		contenedor.add(go,1);
*/	
		sonidoM.reproducir();
	}
	
	private void iniciarJuego(){
		sonidoJ=new SonidoJuego();
		juego= new Juego(this);
		b=juego.getBomberman();
		b.getPuntaje().getGrafico().setBounds(870, 410, 128,64);
		contenedor.add(b.getPuntaje().getGrafico(),1);
		componentes.add(b.getPuntaje().getGrafico());
		juego.getNivel(0).getControlador().getGrafico().setBounds(140, 410, 256, 64);
		contenedor.add(juego.getNivel(0).getControlador().getGrafico(),1);
		componentes.add(juego.getNivel(0).getControlador().getGrafico());
		tiempo = new Cronometro();
		tiempo.getGrafico().setBounds(10, 410, 128, 64);
		contenedor.add(tiempo.getGrafico(),1);
		componentes.add(tiempo.getGrafico());
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
			for(JComponent c:componentes){
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
		for(JComponent c:componentes)
		{
			contenedor.remove(c);
			c=null;
		}
		bg.setIcon(backgrounds[0]);
		musica.setBounds(820,430,32,32);
		System.gc();
		iniciarJuego();
	}

	public void keyPressed(KeyEvent arg0) 
	{
		if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
			iniciar();
		}
		else
			if(arg0.getKeyCode()==KeyEvent.VK_ESCAPE)
				salir();
			else
				if(arg0.getKeyCode()==KeyEvent.VK_R)
					reset();
				else
					if(arg0.getKeyCode()==KeyEvent.VK_S)
						toggleSound();
					else
						if(arg0.getKeyCode()==KeyEvent.VK_D)
							this.b.convertirEnDios();
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
			this.iniciar();
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
		contenedor.add(c,index);
		componentes.add(c);
	}
	
	public void sacarJuego(JComponent c)
	{
		contenedor.remove(c);
		componentes.removeElement(c);
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
	/**
	 * Pantalla victoria
	 * @param p
	 */
	public void noHayMasCajas(int p)
	{
		int colorBg= setearBg();
		prepararPantallaScore(p);
		
		tl=new JLabel(win[colorBg]);
		JLabel bm=new JLabel(bombGane[0]);
		agregarAContenedor();
		
		for(int i=0; i<6; i++){
			bm.setIcon(bombGane[i]);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		bm.setIcon(bombGane[6]);	
		componentes.add(bm);
	}
	
	
	public void muerteBomberman(int p)
	{
		int colorBg= setearBg();
		prepararPantallaScore(p);
		
		//Pantalla perdida
		bm=bombLose;
		tl=new JLabel(lose[colorBg]);
		agregarAContenedor();
		
	}
	
	private void agregarAContenedor(){
		bm.setBounds(570, 77, 400, 400);
		tl.setBounds(115, 40, 860, 100);
		contenedor.add(bm,0);
		contenedor.add(tl,0);
		componentes.add(bm);
		componentes.add(tl);
		contenedor.repaint();
	}
	private int setearBg(){
		Random nro= new Random();
		//bg.setIcon(backgrounds[nro.nextInt(5)+1]); // desinga un background cualquiera
		bg.setIcon(backgrounds[2]);
		return nro.nextInt(5);	//le designa otro color al cartel
	}
	private void acomodarSonido(){
		
		sonidoJ.detener();
		sonidoJ=null;
		sonidoM=new SonidoMenu();
		sonidoM.reproducir();
	}
	private void prepararPantallaScore(int p){
	
		musica.setBounds(860,430,32,32);
		for(JComponent c:componentes)
		{
			contenedor.remove(c);
			c=null;
		}
		contenedor.repaint();
		
		acomodarSonido();

		JLabel puntaje=new JLabel("Puntaje: "+p);
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
		componentes.add(puntaje);		
		tiempo.destruir();
		
	}
}