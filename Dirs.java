package jeux;

import javax.swing.JPanel;

public class Dirs extends JPanel{
	
	
	private static final long serialVersionUID = 1L;
	
	private int[] dirs = {
			0,
			90,
			180,
			270
	};
	public int dir = 0;
	public int vraiDir = dirs[dir];
	
	public Dirs() {
			
	}
	
	private void reinit(int x) {
		this.dir = x;
		this.vraiDir = this.dirs[this.dir];
		//System.out.println("direction : " + vraiDir);
	}
	
	private void tourner(int pos) {
		reinit(pos);
	}	

	public void haut() {
		tourner(1);
	}
		
	public void gauche() {
		tourner(2);
	}	
	
	public void bas() {
		tourner(3);
	}

	public void droite() {
		tourner(0);
	}

}

