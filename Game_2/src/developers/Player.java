package developers;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends Component{

	private static final long serialVersionUID = 1L;
	
	public int xPos = 0, yPos = 0;
	
	BufferedImage img;
	ClassLoader cl = this.getClass().getClassLoader();

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
			System.out.println(e);
		}
		WindowRunner.getPanel().add(this);
	}
	
	/**
	 * Draws the player on the screen.
	 * @author Byron Lathi
	 */
	public void paintComponent(Graphics g){
		super.paint(g);
		g.drawImage(img, xPos, yPos, this);
	}

}
