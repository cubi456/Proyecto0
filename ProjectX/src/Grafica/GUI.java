package Grafica;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.util.Vector;
import java.awt.event.KeyAdapter;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Juego;
import Logica.Jugador.Bomberman;
import Timer.Cronometro;
//import Timer.ContadorTiempo;

public class GUI extends JFrame {
	// ISB VER
	private Bomberman b;
	private static final long serialVersionUID = 1L;
	private Vector<JComponent> componentes;
	private JPanel contenedor;
	private Juego juego;
	private int direccion=-1;
	private Cronometro tiempo;
	
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
		setResizable(true);
		setIconImage(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/icon03.png")).getImage());
		contenedor = new JPanel();
		contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contenedor);
		contenedor.setLayout(null);
		componentes = new Vector<JComponent>();
		crearMenu();
	
		// Teclas del menu
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					if (juego == null) {
						for(JComponent c:componentes)
							contenedor.remove(c);
						contenedor.repaint();
						iniciarJuego();
					}
				}
				else
					if(arg0.getKeyCode()==KeyEvent.VK_ESCAPE)
						System.exit(0);
					else
						if(arg0.getKeyCode()==KeyEvent.VK_R)
							reset();
			}
		});
		
		// Oyente a las teclas
		addKeyListener(new KeyAdapter() {
		public void keyPressed(KeyEvent arg0) {
			mover(arg0);
		}
		});
	}

	private void crearMenu(){
		JLabel bg=new JLabel(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/Background.png"))); 
		bg.setBounds(0, 0,998, 500);
		contenedor.add(bg,0);
		JLabel bm=new JLabel(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/BombermanRender00.png")));
		bm.setBounds(570, 20, 420, 423);
		contenedor.add(bm,0);
		componentes.add(bm);
	}
	
	private void iniciarJuego(){
		juego= new Juego(this);
		b=juego.getBomberman();
		b.getPuntaje().getGrafico().setBounds(870, 410, 128,64);
		contenedor.add(b.getPuntaje().getGrafico(),1);
		juego.getNivel(0).getControlador().getGrafico().setBounds(140, 410, 256, 64);
		contenedor.add(juego.getNivel(0).getControlador().getGrafico(),1);
		tiempo = new Cronometro();
		tiempo.getGrafico().setBounds(10, 410, 128, 64);
		contenedor.add(tiempo.getGrafico(),1);
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
	
}