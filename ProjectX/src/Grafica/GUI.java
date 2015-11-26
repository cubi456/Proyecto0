package Grafica;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
//import Timer.ContadorTiempo;

public class GUI extends JFrame implements ActionListener,KeyListener
{
	// ISB VER
	private Bomberman b;
	private static final long serialVersionUID = 1L;
	private Vector<JComponent> componentes;
	private JPanel contenedor;
	private Juego juego;
	private JButton comenzar,salir,musica;
	private int direccion=-1;
	private Cronometro tiempo;
	private boolean silencio;
	private Icon activo,inactivo;
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
		setIconImage(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/icon03.png")).getImage());
		contenedor = new JPanel();
		contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contenedor);
		contenedor.setLayout(null);
		componentes = new Vector<JComponent>();
		this.addKeyListener(this);
		this.setFocusable(true);
		crearMenu();
		
	}
	

	private void crearMenu(){
		sonidoM=new SonidoMenu();
		JLabel bg=new JLabel(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/Background.png"))); 
		bg.setBounds(0, 0,998, 500);
		contenedor.add(bg,0);
		JLabel bm=new JLabel(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/BombermanRender00.png")));
		bm.setBounds(570, 20, 420, 423);
		contenedor.add(bm,0);
		JLabel tl=new JLabel(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/title.png")));
		tl.setBounds(100, 20, 458, 117);
		contenedor.add(tl,0);
		componentes.add(bm);
		
		//Botones
		
		
		comenzar=new JButton(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/comenzar00.png")));
		comenzar.setActionCommand("comenzar");
		comenzar.addActionListener(this);
		comenzar.setRolloverIcon(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/comenzar01.png")));
		comenzar.setOpaque(false);
		comenzar.setContentAreaFilled(false);
		comenzar.setBorderPainted(false);
		comenzar.setBounds(160,160,350,50);
		contenedor.add(comenzar,0);
		componentes.add(comenzar);
		
		salir=new JButton(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/salir01.png")));
		salir.setActionCommand("salir");
		salir.addActionListener(this);
		salir.setRolloverIcon(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/salir00.png")));
		salir.setOpaque(false);
		salir.setContentAreaFilled(false);
		salir.setBorderPainted(false);
		salir.setBounds(200,220,350,50);
		contenedor.add(salir,0);
		componentes.add(salir);
		
		
		activo=new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/conMusica.png"));
		inactivo=new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/sinMusica.png"));
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
		
		sonidoM.reproducir();
	}
	
	private void iniciarJuego(){
		sonidoJ=new SonidoJuego();
		juego= new Juego(this);
		b=juego.getBomberman();
		b.getPuntaje().getGrafico().setBounds(870, 410, 128,64);
		contenedor.add(b.getPuntaje().getGrafico(),1);
		juego.getNivel(0).getControlador().getGrafico().setBounds(140, 410, 256, 64);
		contenedor.add(juego.getNivel(0).getControlador().getGrafico(),1);
		tiempo = new Cronometro();
		tiempo.getGrafico().setBounds(10, 410, 128, 64);
		contenedor.add(tiempo.getGrafico(),1);
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
		this.remove(contenedor);
		contenedor = new JPanel();
		contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contenedor);
		contenedor.setLayout(null);
		juego=null;
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
			musica.setIcon(activo);
			musica.setRolloverIcon(inactivo);
			silencio=true;
		}	
		else
		{
			musica.setIcon(inactivo);
			musica.setRolloverIcon(activo);
			silencio=false;
		}
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
}