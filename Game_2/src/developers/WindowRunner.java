package developers;

import java.io.IOException;

import javax.swing.JFrame;

/**
 * @author Byron Lathi
 *
 * Runs the window 
 */
public class WindowRunner{

	private static JFrame frame;
	
	public static JFrame getFrame(){
		return frame;
	}
		
	public static void init(String name) throws IOException{
		frame = new JFrame(name);
		Window.makeLogo("/img/logo.png");
		frame.setSize(800, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void run(){
		
	}
}
