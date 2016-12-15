/*
	Game_2 
    Copyright (C) 2016  Lovett Developers Club
*/

package developers.elements;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import developers.WindowRunner;

public class Player extends JComponent implements KeyListener{

	private static final long serialVersionUID = 1L;
	private int xPos = 50, yPos = 775;
	private int moveSpeed = 5;
	private int xDelta = 0;
	private int yDelta = 0;

	BufferedImage img;
	ClassLoader cl = this.getClass().getClassLoader();
	private boolean enableGravity = true;

	/**
	 * @return the X position of the player
	 */
	public int getxPos() {
		return xPos;
	}

	/**
	 * @param xPos
	 *            the X position of the player to set
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
	 * @param yPos
	 *            the Y position of the player to set
	 */
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	/**
	 * Creates a player object, with a sprite.
	 * 
	 * @author Byron Lathi
	 * @param path
	 *            The path of the sprite (currently just one)
	 * @throws IOException
	 */
	public Player(String path) throws IOException {
		try {
			img = ImageIO.read(cl.getResource(path));
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public void run(){
		
	}

	/**
	 * Draws the player on the screen.
	 * 
	 * @author Byron Lathi
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, xPos, yPos, this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
