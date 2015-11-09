package Grafica;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Juego;
import Logica.Personaje;
import Logica.Jugador.Bomberman;
import Timer.Cronometro;
//import Timer.ContadorTiempo;

public class GUI extends JFrame {
	// ISB VER
	private Personaje b;
	private static final long serialVersionUID = 1L;

	private JPanel contenedor;
	private JFrame ventana;
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
 *	Creacion de la ventana 
 * 
*/
	public GUI(){
		ventana= new JFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(10, 100, 100, 600);
		setSize(new Dimension(998, 500));
		ventana.setTitle("Proyecto X");
		setResizable(false);
		contenedor = new JPanel();
		contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contenedor);
		contenedor.setLayout(null);
		juego= new Juego(this);
		tiempo = new Cronometro();
		tiempo.getGrafico().setBounds(10, 410, 128, 64);
		contenedor.add(tiempo.getGrafico(),10);
		tiempo.start();
		b=juego.getBomberman();
		
		
		// Oyente a las teclas
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				OyenteTeclado(arg0);
			}
		});
		}
	
	private void opcionesJugador(int dir)
	{
		switch (dir) {
		case KeyEvent.VK_LEFT :
			b.avanzarIzq();
			break;
		case KeyEvent.VK_UP : 
			b.avanzarArriba();
			break;
		case KeyEvent.VK_RIGHT : 
			b.avanzarDer();
			break;
		case KeyEvent.VK_DOWN : 
			b.avanzarAbajo();
			break;
		case KeyEvent.VK_SPACE:
			 ((Bomberman)b).colocarBomba();
			 break;
		//case ENTER. PAUSA	
		default: 
			break;
	}
}
	
	public void detectarOpciones(int dir)
	{
		if(!lock)
		{
			opcionesJugador(dir);
			this.lock=true;
			direccion=-1;
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
	
	protected void OyenteTeclado(KeyEvent key) 
	{
		direccion=key.getKeyCode();
	}
}