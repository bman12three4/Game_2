package developers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player {

	BufferedImage img;

	/**
	 * Default Constructor
	 */
	public Player() {
		// Default Constructor, nothing here
	}

	public Player(String path) throws IOException {
		try {
			img = ImageIO.read(new File(path));
		} catch (IOException e) {
			System.out.println("No such File (Player.java:22)");
		}
	}

}
