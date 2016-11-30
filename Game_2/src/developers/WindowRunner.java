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
		
	public static void init(String name) throws IOException{
		frame = new JFrame(name);
		frame.add(Window.gameName());
		Window.makeLogo("/img/logo.png");
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
