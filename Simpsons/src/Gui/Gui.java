package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;


public class Gui extends JFrame {
	
	private JPanel  panel;
	private JLabel  text,image; 
	private JButton button;
	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public Gui() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 514, 404);
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		setContentPane(panel);
		
		
		text = new JLabel("Marge no voy a mentirte ..");
		text.setVisible(false);
		text.setFont(text.getFont().deriveFont(18.0f));
		
	    button = new JButton("Generar");
		button.setBounds(0, 0, 200, 100);
		OyenteBoton oyente= new OyenteBoton();
		button.addActionListener(oyente);
		
		ImageIcon imageicon = new ImageIcon(getClass().getResource("/Imagenes/imagen1.jpg"));
		image = new JLabel();
		image.setIcon(imageicon);
		
		
		panel.add(text, BorderLayout.NORTH);
		panel.add(image,BorderLayout.CENTER);
		panel.add(button,BorderLayout.SOUTH);
		
		
	}
	
	private class OyenteBoton implements ActionListener{
        public void actionPerformed(ActionEvent e){
        	text.setVisible(true);
        }
	}
	
}