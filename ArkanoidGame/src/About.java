import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class About extends JFrame {

	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public About() {
		setTitle("About");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel isim = new JLabel("Erdem Emir \u00D6zer");
		isim.setFont(new Font("Tahoma", Font.PLAIN, 18));
		isim.setBounds(167, 10, 182, 119);
		contentPane.add(isim);
		
		JLabel numara = new JLabel("20180702015");
		numara.setFont(new Font("Tahoma", Font.PLAIN, 18));
		numara.setBounds(167, 196, 239, 46);
		contentPane.add(numara);
		
		JLabel eposta = new JLabel("erdememir.ozer@std.yeditepe.edu.tr");
		eposta.setFont(new Font("Tahoma", Font.PLAIN, 18));
		eposta.setBounds(167, 257, 350, 53);
		contentPane.add(eposta);
		
		JButton cýkýs = new JButton("CLOSE");
		cýkýs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			setVisible(false);
			
			}
		});
		cýkýs.setBounds(230, 345, 161, 58);
		contentPane.add(cýkýs);
	}
}
