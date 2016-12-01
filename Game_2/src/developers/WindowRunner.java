/*
	Game_2 
    Copyright (C) 2016  Lovett Developers Club
*/

package developers;

import java.io.IOException;

import javax.swing.JFrame;

/**
 * @author Byron Lathi
 *
 *         Runs the window
 */
public class WindowRunner {

	private static JFrame frame;
	private static Window panel = new Window();

	public static Window getPanel() {
		return panel;
	}

	public static JFrame getFrame() {
		return frame;
	}

	public static void init(String name) throws IOException {
		frame = new JFrame(name);
		Window.makeLogo("/img/logo.png");
		frame.add(panel);
		frame.setJMenuBar(new MenuBar());
		frame.setSize(800, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void run() {
		Game2.getPlayer().repaint();
	}
}
