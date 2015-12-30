package version2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class GUI2 extends JFrame implements ActionListener {
	
	private JButton sort;
	
	private static void createAndShowGUI(){
		JFrame main = new JFrame("Folder Sorter"); //main GUI window
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName() );
		} catch (Exception e) {}
	
		main.setVisible(true);

	}
	
	
	public JPanel test(){
		
		sort = new JButton("Sort");
		sort.addActionListener(this);
		
		return new JPanel();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	  public static void main(String[] args) {
	        //Schedule a job for the event-dispatching thread:
	        //creating and showing this application's GUI.
	        javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                createAndShowGUI();
	            }
	        });
	    }
}
