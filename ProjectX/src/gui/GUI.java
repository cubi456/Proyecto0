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

public class GUI extends JFrame {
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
		
		// Oyente a las teclas
		ventana.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				OyenteTeclado(arg0);
			}
		});
		
		}
	
	private void OyenteTeclado(KeyEvent key) {
		Bomberman b=new Bomberman(1,1,3, juego);// ESTO NO VA, tendria que pedirle al juego bomb
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
			case KeyEvent.VK_SPACE:
				b.colocarBomba();
			//case ENTER. PAUSA		
		}
	}
}