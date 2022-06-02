import javax.swing.JFrame;

public class Main {

	
	
	public static void main(String[] args) {
	
		
		JFrame frame1 = new JFrame();
		GamePlay game = new GamePlay();
		MainMenu menu = new MainMenu();
		
		menu.setVisible(true);
		
		
		
		
		frame1.setTitle("Arkanoid Game");
		frame1.setBounds(10,10,700, 600);
		frame1.setResizable(false);
		frame1.setVisible(true);
		
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.add(game);
		
		
		
		
		
	}
}
