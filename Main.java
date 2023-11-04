package jeux;

import java.awt.event.*;

import javax.swing.*;


public class Main {
	
	public JLabel l = new JLabel("Score : ");
	

	public static void main(String[] args) {
		
		
	JFrame f = new JFrame();
    ClicTest k = new ClicTest();
    Jeu jeu = new Jeu();
    
    f.setSize(1600, 870);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.add(jeu);
    f.setVisible(true);
    f.addKeyListener(k);

    
    Timer timer = new Timer(0, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            jeu.setDir(k.dirs.dir);
            if (jeu.mort) {
            	/*
            	JLabel l = new JLabel("Score : " + jeu.vscore);
            	l.setLocation(800, 200);
                f.add(l);
                */
            }
        }
    });
    timer.start();
	}
	
	
	
}