package developers;

import javax.swing.JFrame;

/**
 * @author Byron Lathi
 *
 * Runs the window 
 */
public class WindowRunner{

	private static JFrame frame;
		
	public static void init(String name){
		frame = new JFrame(name);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
