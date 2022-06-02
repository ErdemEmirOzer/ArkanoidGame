
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;



public class GamePlay extends JPanel implements KeyListener, ActionListener{
	
	
	private boolean play = false;
	private int totalbrick = 21;
	private Timer timer;
	private int score = 0;
	private int life =3;
	private int delay = 1;
	private int ballX=120;
	private int ballY= 350;
	private int balldirX= -1;
	private int balldirY = -2;
	private int playerX = 350;
	private Map map;

	public GamePlay() {
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(true);
		timer = new Timer(delay,this);
		timer.start();
		
		map = new Map(3,7);
	}
	
	
	
		
	
	public void paint(Graphics g) {
		super.paint(g);
				//background
				g.setColor(Color.black);
				g.fillRect(1, 1, 700,700 );
				
				
				// paddle board
				g.setColor(Color.gray);
				g.fillRect(playerX, 550, 100, 10);
				
				//brick
				map.draw((Graphics2D)g);
				
				//score
				g.setColor(Color.white);
				g.drawString("Score : "+score,50,30);
				
				//life
				g.setColor(Color.white);
				g.drawString("Remaining life :"+life,300,30);
				
				//create ball
				g.setColor(Color.white);
				g.fillOval(ballX, ballY, 20,20);
				
				if(life ==0) {
					g.setColor(Color.white);
					g.drawString("Game Over Press Enter to Restart or press 'E' to Exit", 350, 350);
				}
				
				if(totalbrick <=0) {
					g.setColor(Color.white);
					g.drawString("All bricks are breaked you won! Game will close for 4 seconds...", 250, 350);
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
					System.exit(0);
				}
				
	}


	
	public void repaint() {
		super.repaint();
		
		
	}





	private void moveleft() {
		play =true;
		playerX = playerX -20;
	}
	
	private void moveright() {
		play = true;
		playerX = playerX + 20;
	}

	

	
	public void keyPressed(KeyEvent e) {
		
		if(e.getKeyCode()== KeyEvent.VK_LEFT) {
			if(playerX<=0) {
				playerX =0;
			}
			else {
			moveleft();
			}
	}
		
		else if(e.getKeyCode()== KeyEvent.VK_RIGHT) {
			if(playerX >= 600) {
				playerX=600;
			}
			else {
			moveright();
			}
	}
		
		if(e.getKeyCode()== KeyEvent.VK_ENTER) {
			if(!play) {
				
				score =0;
				totalbrick = 21;
				ballX = 120;
				ballY = 350;
				balldirX = -1;
				balldirY = -2;
				playerX = 350;
				
				map = new Map(3,7);
				
				
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_E) {
			if(!play) {
				setVisible(false);
				MainMenu menu = new MainMenu();
				menu.setVisible(true);
			}
		}
		
		
		repaint();
		
	}


	public void actionPerformed(ActionEvent e) {
		timer.start();
		if(play) {
			
			if(ballY >= 600) {
				life--;
				balldirY = -balldirY;
			}
			if(life == 0) {
				play = false;
				
				
			}
			
			if(new Rectangle(ballX,ballY,20,20).intersects(new Rectangle(playerX,550,100,10))) {
				balldirY = -balldirY;
			}
			
			for(int i=0;i < map.map.length;i++) {
				for(int j =0;j <map.map[0].length; j++ ) {
					
					if(map.map[i][j] > 0) {
						
						int width = map.brickwidth;
						int height = map.brickheight;
						int brickX = 70+j*width;
						int brickY = 50+ i*height;
						
						
						Rectangle brickrect = new Rectangle(brickX,brickY,width,height);
						Rectangle ballrect = new Rectangle(ballX,ballY,20,20);
						
						if(ballrect.intersects(brickrect)) {
							
							map.setbrick(0, i, j);
							
							totalbrick--;
							score = score +10;
							
							
							if(ballX <= brickX || ballX >= brickX+width) {
								
								balldirX = -balldirX;
							}
							else {
								balldirY = -balldirY;
							}
							
							
							
							
						}
						
					}	
				}
			
			}
			
			
			
			ballX = ballX + balldirX;
			ballY = ballY + balldirY;
			if(ballX < 0) {
				balldirX = -balldirX;
			}
			if(ballY < 0) {
				balldirY = -balldirY;
			}
			if(ballX > 670) {
				balldirX = -balldirX;
			}
		}
		repaint();
		
	}
	

	public void keyReleased(KeyEvent e) {
	
		
	}


	
	public void keyTyped(KeyEvent e) {
		
		
	}
	
}
