/*
	Game_2 
    Copyright (C) 2016  Lovett Developers Club
*/

package developers;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends Component{

	private static final long serialVersionUID = 1L;
	private int xPos = 0, yPos = 0;

	BufferedImage img;
	ClassLoader cl = this.getClass().getClassLoader();
	
	/**
	 * @return the X position of the player
	 */
	public int getxPos() {
		return xPos;
	}

	/**
	 * @param xPos the X position of the player to set
	 */
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	/**
	 * @return the Y position of the player
	 */
	public int getyPos() {
		return yPos;
	}

	/**
	 * @param yPos the Y position of the player to set
	 */
	public void setyPos(int yPos) {
		this.yPos = yPos;
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
