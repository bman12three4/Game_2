package developers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Player {
	
	JLabel sprite;

	/**
	 * Default Constructor
	 */
	public Player() {
		// Default Constructor, nothing here
	}
	
	public Player(String path) throws IOException{
        File file = new File(path);
        BufferedImage image = ImageIO.read(file);
        sprite = new JLabel(new ImageIcon(image));
	}

}
