package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Gui extends JFrame {
	private JTextArea textArea;
	private JPanel contentPane;
	private JLabel image;
	private ImageIcon imageicon, imageicon2;
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

	/*	Creacion del frame
	 * 
	 */
	public Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		
		//	Creacion de contenedor
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		//	Panel Central
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		//	Area de texto
		textArea = new JTextArea();
		panel.add(textArea, BorderLayout.SOUTH);
		textArea.setText("Aprete el boton para obtener frase.");
		
		// Panel de control
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(30, 144, 255));
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		//	Creacion de boton 
		JButton btnNewButton = new JButton("Iniciar");
		panel_1.add(btnNewButton);
		OyenteBoton oyente= new OyenteBoton();
		btnNewButton.addActionListener(oyente);
		
		//	Creacion de labels
		imageicon = new ImageIcon(getClass().getResource("/Imagenes/00.png"));
		imageicon2 = new ImageIcon(getClass().getResource("/Imagenes/01.png"));
		image = new JLabel();
		image.setIcon(imageicon);
		panel.add(image, BorderLayout.CENTER);
		
	}
	
		//Creacion e implementacion de Oyente
	private class OyenteBoton implements ActionListener{
        public void actionPerformed(ActionEvent e){
        	image.setIcon(imageicon2);
        	textArea.setText("Ayy esta grasa no se quita");
        }
	}
	
}