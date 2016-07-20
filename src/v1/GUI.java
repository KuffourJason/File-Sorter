package v1;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class GUI {

public static JFrame done(){
		
		JFrame done = new JFrame("The Sorting is Complete");
		done.setLayout(new BorderLayout() );
		done.setVisible(true);
		done.setForeground(Color.WHITE);
		done.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel banner = new JLabel("The download folder has been successfully sorted to your liking");
		done.add(banner, "Center");
		banner.setBackground(Color.WHITE);
		banner.setVisible(true);
		
		JButton close = new JButton("close");
		done.add(close, "South");

		
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		done.setSize(380, 150);
		banner.setBackground(Color.WHITE);  
		done.setLocation(320, 200);
		
		ImageIcon ImageIcon = new ImageIcon("images/icon.png");
	    Image Image = ImageIcon.getImage();
	    done.setIconImage(Image);
		
		return done;
	}

	public static JFrame error(){
	
		JFrame error = new JFrame("Error");
		error.setLayout(new BorderLayout() );
		error.setVisible(true);
		error.setForeground(Color.WHITE);
		error.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel banner = new JLabel("Could not find downloads folder");
		error.add(banner, "Center");
		banner.setBackground(Color.WHITE);
		banner.setVisible(true);
		
		error.setSize(380, 150);
		banner.setBackground(Color.WHITE);  
		error.setLocation(320, 200);
		
		JButton close = new JButton("close");
		error.add(close, "South");

		
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		return error;
	}
}
