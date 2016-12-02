/*
	Game_2 
    Copyright (C) 2016  Lovett Developers Club
*/

package developers;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import developers.elements.GameLevel;

public class Window extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static JLabel name = new JLabel("Game_2");

	ClassLoader cl = this.getClass().getClassLoader();
	BufferedImage img;

	public static JLabel returnName() {
		return name;
	}

	static JLabel logo;

	public void makeLogo(String path) {
		try {
			File file = new File(path);
			BufferedImage image = ImageIO.read(file);
			logo = new JLabel(new ImageIcon(image));
		} catch (IOException e) {
			Game2.log(e + " Window.java:33");
		}

		if (Settings.enableBackground) {
			try {
				img = ImageIO.read(cl.getResource("img/background.png"));
			} catch (IOException e) {
				System.out.println(e);
			}
		}
	}

	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(img, 0, 0, this);
		Game2.getPlayer().paintComponent(g);
		GameLevel.paintPlats(g);
	}

}
