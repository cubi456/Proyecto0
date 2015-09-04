package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Gui extends JFrame {
	private JTextArea textArea;
	private JPanel contentPane;
	private JLabel image;
	private ImageIcon icon,imageicon, imageicon2;
	private Clip clip;
	private AudioInputStream inputStream;
	private JButton btnNewButton;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*	Creación del frame
	 * 
	 */
	public Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 450);
		
		//	Creación de contenedor
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		super.setResizable(false);
		super.setTitle("Simpsons");
		
		icon= new ImageIcon(getClass().getResource("/Imagenes/02.png"));
		super.setIconImage(icon.getImage());
		//	Panel Central
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		//	Area de texto
		textArea = new JTextArea();
		panel.add(textArea, BorderLayout.SOUTH);
		textArea.setText("Apriete el boton para obtener frase.");
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		//	Cambio de font
		Font font = new Font("Verdana", Font.ITALIC, 16);
		textArea.setFont(font);
		
		//	Panel de control
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(30, 144, 255));
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		//	Creación de botón 
		btnNewButton = new JButton("Iniciar");
		panel_1.add(btnNewButton);
		OyenteBoton oyente= new OyenteBoton();
		btnNewButton.addActionListener(oyente);
		
		//	Creación de labels
		imageicon = new ImageIcon(getClass().getResource("/Imagenes/00.png"));
		imageicon2 = new ImageIcon(getClass().getResource("/Imagenes/01.gif"));
		image = new JLabel();
		image.setIcon(imageicon);
		panel.add(image, BorderLayout.CENTER);
		        
	}

	
		private void Sonidos() {
			//Creacion de sonido

			try {
				clip = AudioSystem.getClip();
				BufferedInputStream bis= new BufferedInputStream(getClass().getResourceAsStream("/Sonidos/00.wav"));
				inputStream= AudioSystem.getAudioInputStream(bis);
				clip.open(inputStream);
			} catch (UnsupportedAudioFileException | IOException |LineUnavailableException e ) {
				e.printStackTrace();
			}
				clip.start();
	        clip.addLineListener(new LineListener() {
	            public void update(LineEvent evt) {
	              if (evt.getType() == LineEvent.Type.STOP) 
	              {
	            	  image.setIcon( new ImageIcon(getClass().getResource("/Imagenes/03.png")));
	            	  btnNewButton.setEnabled(true);
	              }
	            }
	          });
		
	}

		//Creación e implementación de Oyente
	private class OyenteBoton implements ActionListener{
        public void actionPerformed(ActionEvent e){
        	btnNewButton.setText("Reset");
        	btnNewButton.setEnabled(false);
        	Sonidos();
        	image.setIcon(imageicon2);
        	textArea.setText("Sin la presencia de un hombre en la casa, puedes volverte afeminado en un segundo. Ayy esta grasa no se quita.");
        }
	}
	
}