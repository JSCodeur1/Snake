package jeux;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class Jeu extends JPanel{	
	
	private static final long serialVersionUID = 1L;
	
	ArrayList<int[]> moves = new ArrayList<>();
	Random r = new Random();
		
	public int vscore;
	public boolean mort = false;
	private int[] bords = {50, 50, 1550, 770};
	private int x = r.nextInt(bords[0]+1, 800);
	private int y = 400;
	private int vitesse = 1;
	private int dir = 0;
	private int score = 100;
	private int snakeSize = 6;
	private double truc = 0;
	private int pommex, pommey;
	private int pommeSize = 12;
	
	public void setDir(int dire) {
		this.dir = dire*90;
	}
	
	private void newPomme() {
		this.pommex = this.r.nextInt(bords[0]+10, bords[2]-10);
		this.pommey = this.r.nextInt(bords[1]+10, bords[3]-10);
	}

	public Jeu() {
		
	newPomme();
		
	Thread updateThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                        	repaint();
                        }
                    });

                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        updateThread.start();
        
		
		
	}
	
	protected void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		
		
		if (mort) {
			truc += 5;
		}
		
		int[] pos = {x, y};
		moves.add(pos);
		
		
		for (int i = 0; i < moves.size(); i++) {
			
			if (i<truc) {
				g.setColor(Color.BLACK);
			} else {
				g.setColor(Color.RED);
			}
			g.fillRect(moves.get(i)[0]-(snakeSize/2), moves.get(i)[1]-(snakeSize/2), snakeSize, snakeSize);
		}
		if (!mort) {
			if (dir==0) {
				x += vitesse;
			} else if (dir == 90) {
				y -= vitesse;
			} else if (dir == 180) {
				x-=vitesse;
			} else{
				y+=vitesse;
			}
		} else {
			System.out.println("Score : " + vscore);
		}
		
		if ((x>pommex-pommeSize/2 && x<pommex+pommeSize/2) && (y>pommey-pommeSize/2 && y<pommey+pommeSize/2)) {
			score += 50;
			newPomme();
			vscore += 1;
		}
		
		for (int i = 0; i < moves.size(); i++) {
			if (moves.get(i)[0] == x && moves.get(i)[1] == y) {
				mort = true;
			}
		}
		if (x == bords[2] || x == bords[0] || y == bords[1] || y == bords[3]) {
			mort = true;
		}
		
		if (moves.size() > score && !mort) {
			moves.remove(0);
		}
		g.setColor(Color.BLACK);
		g.drawString("Score : " + vscore, 800, 25);
		g.drawLine(bords[0], bords[1], bords[2], bords[1]);
		g.drawLine(bords[0], bords[1], bords[0], bords[3]);
		g.drawLine(bords[2], bords[3], bords[2], bords[1]);
		g.drawLine(bords[2], bords[3], bords[0], bords[3]);
		g.fillRect(pommex-pommeSize/2, pommey-pommeSize/2, pommeSize, pommeSize);
		g.setColor(Color.RED);
	}		
}
