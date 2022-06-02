import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Map {
	
	public int map[][];
	public int brickwidth;
	public int brickheight;
	
	
	public Map(int row,int column) {
		
		map = new int[row][column];
		
		for(int i =0; i<row;i++) {
			for(int j=0;j<column;j++) {
				
				map[i][j]= 1;
			}
		}
		
		brickwidth= 540/column;
		brickheight= 150/row;
		
	}
	
	public void setbrick(int value,int r, int c) {
		
		map[r][c]= value;
	}
	
	public void draw(Graphics2D g) {
		
		for(int i=0;i<map.length;i++) {
			for(int j =0;j<map[0].length;j++) {
				if(map[i][j] > 0) {
					
					g.setColor(Color.white);
					g.fillRect(j*brickwidth+70,i*brickheight+50, brickwidth, brickheight);
					
					g.setColor(Color.black);
					g.setStroke(new BasicStroke(3));
					g.drawRect(j*brickwidth+70,i*brickheight+50, brickwidth, brickheight);
					
				}
			}
		}
		
		
	}
	
	
	
}
	