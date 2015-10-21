package gui;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Bomberman;
import Logica.Juego;
import Logica.Personaje;

public class GUI extends JFrame {
	// ISB VER
	private Personaje b;
	private static final long serialVersionUID = 1L;

	private JPanel contenedor;
	private JFrame ventana;
	private Juego juego;
	
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
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		// Oyente a las teclas
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				OyenteTeclado(arg0);
			}
		});
		}
	
	protected void OyenteTeclado(KeyEvent key) {
		switch (key.getKeyCode()) {
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
}