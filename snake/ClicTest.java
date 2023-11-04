package jeux;

import java.awt.event.*;

public class ClicTest implements KeyListener{
	
	Dirs dirs = new Dirs();
	
	@Override
	  public void keyTyped(KeyEvent e) {
		
	  }
	
	@Override
	  public void keyPressed(KeyEvent e) {
	    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
	    	if (dirs.dir != 2 && dirs.dir != 0) {
	    		dirs.droite();
	    	}
	    } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
	    	if (dirs.dir != 0 && dirs.dir != 2) {
	    		dirs.gauche();
	    	}
	    } else if (e.getKeyCode() == KeyEvent.VK_UP) {
	    	if (dirs.dir != 3 && dirs.dir != 1) {
	    		dirs.haut();
	    	}
	    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
	    	if (dirs.dir != 1 && dirs.dir != 3) {
	    		dirs.bas();
	    	}
	    }
	  }

	
	
	@Override
	  public void keyReleased(KeyEvent e) {

	}
	  
}
