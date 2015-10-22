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

public class GUI extends JFrame {
	// ISB VER
	private Personaje b;
	private static final long serialVersionUID = 1L;

	private JPanel contenedor;
	private JFrame ventana;
	private Juego juego;
	
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
		setSize(new Dimension(998, 445));
		ventana.setTitle("Proyecto X");
		setResizable(false);
		contenedor = new JPanel();
		contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contenedor);
		contenedor.setLayout(null);
		
		juego= new Juego(this);
		juego.crearNivel();
		b= juego.addBomberman();
		juego.addRugulus();
		
		// Oyente a las teclas
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				OyenteTeclado(arg0);
			}
		});
		}
	
	protected void opcionesTeclado(int dir)
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
		//case KeyEvent.VK_SPACE:
			//b.colocarBomba();
			//break
		//case ENTER. PAUSA	
		default: 
			break;
	}
}
	
	protected void detectarOpciones(int dir)
	{
		if(!lock)
		{
			opcionesTeclado(dir);
			//this.lock=true;
		}
	}
	
	public void desbloquear()
	{
		this.lock=false;
	}
	
	public boolean getLock()
	{
		return lock;
	}
	
	protected void OyenteTeclado(KeyEvent key) 
	{
		detectarOpciones(key.getKeyCode());
	}
}