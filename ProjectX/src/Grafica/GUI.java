package Grafica;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Juego;
import Sonidos.Sonido;
import Sonidos.SonidoComenzar;
import Sonidos.SonidoJuego;
import Sonidos.SonidoMenu;
import Sonidos.SonidoSalir;
import Timer.Cronometro;

public class GUI extends JFrame implements ActionListener,KeyListener
{
	private static final long serialVersionUID = 1L;
	private Vector<JComponent> componentesJuego, compSalida;
	private JPanel contenedor;
	private JLabel bg, bgAux, bm, tl, score, timer;
	private Juego juego;
	private JButton comenzar,salir,musica;
	private int direccion=-1;
	private Cronometro tiempo;
	private boolean silencio, pantallaJuego;
	private Sonido sonidoM,sonidoJ;
	private CargadorGrafico cargadorGrafico;
	
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
		cargadorGrafico=new CargadorGrafico();
		setIconImage(new ImageIcon(this.getClass().getResource("../Grafica/Sprites/Menu/icon00.png")).getImage());
		contenedor = new JPanel();
		contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contenedor);
		contenedor.setLayout(null);
		componentesJuego = new Vector<JComponent>();
		compSalida=new Vector<JComponent>();
		this.addKeyListener(this);
		this.setFocusable(true);
		bg=new JLabel(cargadorGrafico.getBackground()[0]); 
		bg.setBounds(0, 0,998, 500);
		contenedor.add(bg,0);
		crearMenu();
	}

	private void crearMenu(){
		sonidoM=new SonidoMenu();
		bm=new JLabel(cargadorGrafico.getBombRender());
		bm.setBounds(570, 20, 420, 423);
		contenedor.add(bm,0);
		tl=new JLabel(cargadorGrafico.getTitle());
		tl.setBounds(100, 20, 458, 117);
		contenedor.add(tl,0);
		compSalida.add(bm);
		compSalida.add(tl);
		
		// CargaBotones
		
		
		comenzar=new JButton(cargadorGrafico.getBComenzar()[0]);
		comenzar.setActionCommand("comenzar");
		comenzar.addActionListener(this);
		comenzar.setRolloverIcon(cargadorGrafico.getBComenzar()[1]);
		comenzar.setOpaque(false);
		comenzar.setContentAreaFilled(false);
		comenzar.setBorderPainted(false);
		
		salir=new JButton(cargadorGrafico.getBSalir()[0]);
		salir.setActionCommand("salir");
		salir.addActionListener(this);
		salir.setRolloverIcon(cargadorGrafico.getBSalir()[1]);
		salir.setOpaque(false);
		salir.setContentAreaFilled(false);
		salir.setBorderPainted(false);
		//los agrega a la pantalla
		agregarBotones();
		
		musica=new JButton(cargadorGrafico.getBSonido()[0]);
		musica.setActionCommand("musica");
		musica.addActionListener(this);
		musica.setRolloverIcon(cargadorGrafico.getBSonido()[1]);
		musica.setOpaque(false);
		musica.setContentAreaFilled(false);
		musica.setBorderPainted(false);
		musica.setBounds(820,430,32,32);
		contenedor.add(musica,0);
		silencio=false;
		
		// Se utiliza para que JLabel aparezca mas rapido
		bgAux=new JLabel();
		sonidoM.reproducir();
	}
	

	
	private void iniciarJuego(){
	
		pantallaJuego=true;
		juego= new Juego(this);
		score=juego.getBomberman().getPuntaje().getGrafico();
		score.setBounds(870, 410, 128,64);
		contenedor.add(score,1);
		componentesJuego.add(score);
		juego.getNivel(0).getControlador().getGrafico().setBounds(140, 410, 256, 64);
		contenedor.add(juego.getNivel(0).getControlador().getGrafico(),1);
		componentesJuego.add(juego.getNivel(0).getControlador().getGrafico());
		tiempo = new Cronometro(cargadorGrafico);
		tiempo.getGrafico().setBounds(10, 410, 128, 64);
		contenedor.add(tiempo.getGrafico(),1);
		componentesJuego.add(tiempo.getGrafico());
		// Ya se establecio el juego log y graficamente 
		sonidoJ=new SonidoJuego();
		juego.comenzarHilo();
		if(!silencio)
			toggleSound();
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
			contenedor.repaint();
			if(!silencio)
			{
				Sonido s=new SonidoComenzar();
				s.reproducir();
				sonidoM.detener();
				sonidoM=null;
			}
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
		//bg.setIcon(b);
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
		requestFocus();
	}
	
	private void toggleSound()
	{
		if(sonidoM!=null)
			sonidoM.mute();
		else
			sonidoJ.mute();
		if(silencio)
		{
			musica.setIcon(cargadorGrafico.getBSonido()[1]);
			musica.setEnabled(true);
			musica.setRolloverIcon(cargadorGrafico.getBSonido()[0]);
		}	
		else
		{
			musica.setIcon(cargadorGrafico.getBSonido()[0]);
			musica.setEnabled(true);
			musica.setRolloverIcon(cargadorGrafico.getBSonido()[1]);
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
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		else
			sonidoJ.detener();
		
		System.exit(0);
	}

	@SuppressWarnings("unused")
	private void mostrarRSG(){
		JLabel rsg= new JLabel();
		rsg.setIcon(cargadorGrafico.getRSG()[0]);
		rsg.setBounds(0,50,900,400);
		contenedor.add(rsg, 1);
		contenedor.repaint();
		for(int i=0; i<cargadorGrafico.getRSG().length; i++){
			rsg.setIcon(cargadorGrafico.getRSG()[i]);
			rsg.setBounds(0,50,900,400);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		contenedor.remove(rsg);
	}
	private void mostrarCartel(){
		/**
		 * Ademas de colocar el cartel de juego terminado da lugar a que algunos hilos terminen(logicamente)
		 */
		JLabel go=new JLabel();
		go.setIcon(cargadorGrafico.getGameOver()[0]);
		go.setBounds(356, 100, 285, 199);
		contenedor.add(go, 1);
		contenedor.repaint();
		for(int i=0;i<cargadorGrafico.getGameOver().length;i++)
		{
			go.setIcon(cargadorGrafico.getGameOver()[i]);
			go.setBounds(356, 100, 285, 199);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		contenedor.remove(go);
	
	}
	public void gameOver(boolean victoria){
		// variable game over pregunta si el juego termino bien o mal
		tiempo.destruir();
		pantallaJuego=false;
		score=juego.getBomberman().getPuntaje().getGrafico2();
		mostrarCartel();
		Random gen=new Random();
		int colorbg=gen.nextInt(4)+1;
		bgAux.setIcon(cargadorGrafico.getBackground()[colorbg]);
		bgAux.setBounds(0, 0,998, 500);
		contenedor.add(bgAux,1);
		contenedor.repaint();		
		if(victoria){
			bm.setIcon(cargadorGrafico.getBombGif()[0]);
			tl.setIcon(cargadorGrafico.getWin()[tenerDistinto(colorbg, gen)]);
		}
		else{
			bm.setIcon(cargadorGrafico.getBombGif()[1]);
			tl.setIcon(cargadorGrafico.getLose()[tenerDistinto(colorbg, gen)]);
		}
		bm.setBounds(570, 77, 400, 400);
		tl.setBounds(70, 20, 860, 100);
		contenedor.add(bm,1);
		contenedor.add(tl,1);
		musica.setBounds(860,430,32,32);
		
		compSalida.add(bm);
		compSalida.add(bgAux);
		if(!silencio)
			toggleSound();
		ponerMusicaMenu();
		ponerPuntaje();
		quitarComponentesJuego();
		agregarBotones();	
		ponerTiempo();
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
	
	private void ponerPuntaje(){
		score.setBounds(40, 400, 350, 60);
		contenedor.add(score, 0);
		compSalida.add(score);
	}
	
	private void ponerTiempo(){		
		timer=tiempo.getGrafico2();
		timer.setBounds(40,340,350,60);
		contenedor.add(timer, 1);
		compSalida.add(timer);
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
	public CargadorGrafico getCargadorGrafico(){
		return cargadorGrafico;
	}

}