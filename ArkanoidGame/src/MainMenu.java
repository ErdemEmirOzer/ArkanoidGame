import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu extends JFrame {

	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public MainMenu() {
		setTitle("Arkanoid Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton play = new JButton("PLAY");
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				GamePlay gameplay = new GamePlay();
				gameplay.setVisible(true);
				
				
		
				
				
				
				
				
				
				
				
				
				
			}
		});
		play.setFont(new Font("Tahoma", Font.PLAIN, 14));
		play.setBounds(225, 68, 155, 66);
		contentPane.add(play);
		
		JButton help = new JButton("HELP");
		help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Help help = new Help();
				help.setVisible(true);
				
			}
		});
		help.setFont(new Font("Tahoma", Font.PLAIN, 14));
		help.setBounds(225, 187, 155, 66);
		contentPane.add(help);
		
		JButton about = new JButton("ABOUT");
		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				About about = new About();
				about.setVisible(true);
				
				
			}
		});
		about.setFont(new Font("Tahoma", Font.PLAIN, 14));
		about.setBounds(225, 321, 155, 66);
		contentPane.add(about);
		
		JButton exit = new JButton("EX\u0130T");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		exit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		exit.setBounds(225, 442, 155, 66);
		contentPane.add(exit);
	}
}
