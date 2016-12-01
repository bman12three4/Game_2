package developers;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends Component{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	BufferedImage img;
	ClassLoader cl = this.getClass().getClassLoader();

	/**
	 * Default Constructor
	 * @author Byron Lathi
	 */
	public Player() {
		// Default Constructor, nothing here
	}

	/**
	 * Creates a player object, with a sprite. 
	 * @author Byron Lathi
	 * @param path The path of the sprite (currently just one)
	 * @throws IOException
	 */
	public Player(String path) throws IOException {
		try {
			img = ImageIO.read(cl.getResource(path));
		} catch (IOException e) {
			System.out.println("No such File: " + path + "(Player.java:22)");
		}
		WindowRunner.getFrame().add(this);
	}
	
	/**
	 * Draws the player on the screen.
	 * @author Byron Lathi
	 */
	public void paint(Graphics g){
		g.drawImage(img, 0, 0, this);
	}

}
