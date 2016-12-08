/*
	Game_2 
    Copyright (C) 2016  Lovett Developers Club
*/

package developers.elements;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import developers.WindowRunner;

public class Player extends JComponent {

	private static final long serialVersionUID = 1L;
	private int xPos = 50, yPos = 775;
	private int moveSpeed = 5;
	private int xDelta = 0;
	private int yDelta = 0;

	private Timer repaintTimer;

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
		setFocusable(true);
		WindowRunner.getPanel().add(this);
	}

	/**
	 * @deprecated
	 * 
	 * 			This was the old way of moving the player but it was really
	 *             complicated and didn't really work the way that I wanted it
	 *             too.
	 */
	@SuppressWarnings("unused")
	private void theOldWay() {
		InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
		ActionMap am = getActionMap();

		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "pressed.left");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "pressed.right");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), "released.left");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "released.right");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, false), "pressed.up");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, false), "pressed.down");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, true), "released.up");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, true), "released.down");

		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, false), "pressed.left");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, false), "pressed.right");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true), "released.left");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, true), "released.right");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, false), "pressed.up");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, false), "pressed.down");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, true), "released.up");
		im.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, true), "released.down");

		am.put("pressed.left", new HorizAction(-1, true));
		am.put("pressed.right", new HorizAction(1, true));
		am.put("released.left", new HorizAction(0, false));
		am.put("released.right", new HorizAction(0, false));
		am.put("pressed.up", new VertAction(-1, true));
		am.put("pressed.down", new VertAction(1, true));
		am.put("released.up", new VertAction(0, false));
		am.put("released.down", new VertAction(0, false));

		repaintTimer = new Timer(40, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				xPos += xDelta;
				yPos += yDelta;
				WindowRunner.getPanel().repaint();
			}
		});
		repaintTimer.setInitialDelay(0);
		repaintTimer.setRepeats(true);
		repaintTimer.setCoalesce(true);
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

	private boolean checkBounds() {
		System.out.print(""); // These are for timing, idk why
		for (int i = 0; i < GameLevel.getPlatNum(); i++) {
			System.out.print(""); // Timing reasions (idk)
			if (GameLevel.getPlat()[i].inBounds(xPos, yPos)) {
				return true;
			}
		}
		for (int i = 0; i < GameLevel.getLadNum(); i++) {
			System.out.print(""); // Timing reasions (idk)
			if (GameLevel.getLadder()[i].inBounds(xPos, yPos)) {
				return true;
			}
		}
		if (yPos + 110 >= 1000 - GameLevel.getFloor().getY()) {
			System.out.print(""); // Timing reasions (idk)
			return true;
		}
		return false;
	}

	public void gravity() {
		System.out.print("");
		if (enableGravity) {
			// System.out.println("gravity enabled");
			if (!checkBounds()) {
				yDelta = moveSpeed;
				if (!repaintTimer.isRunning()) {
					repaintTimer.start();
				}
			} else {
				yDelta = 0;
				repaintTimer.stop();
				enableGravity = false;
			}

		}
	}
	
	
	////////////////////////////////////////////////////////
	//   												  //
	//		The rest of this class is all deprecated	  //
	//													  //
	////////////////////////////////////////////////////////
	
	
	
	

	/**
	 * @deprecated
	 * @author Byron Lathi
	 *
	 */
	class HorizAction extends AbstractAction {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		boolean keyDown;
		int dir;

		public HorizAction(int dir, boolean down) {
			keyDown = down;
			this.dir = dir;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			xDelta = -moveSpeed;
			if (dir == 0) {
				xDelta = 0;
			} else {
				xDelta = dir * moveSpeed;
			}
			if (keyDown) {
				if (!repaintTimer.isRunning()) {
					repaintTimer.start();
				}
				enableGravity = false;
			} else {
				repaintTimer.stop();
				enableGravity = true;
			}
		}
	}

	/**
	 * @deprecated
	 * @author Byron Lathi
	 *
	 */
	class VertAction extends AbstractAction {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		boolean keyDown;
		int dir;

		public VertAction(int dir, boolean down) {
			keyDown = down;
			this.dir = dir;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			yDelta = -moveSpeed;
			if (dir == 0) {
				yDelta = 0;
			} else {
				if (GameLevel.isInRange(xPos)) {
					yDelta = dir * moveSpeed;
				} else {
					yDelta = 0;
				}
			}
			if (keyDown) {
				if (!repaintTimer.isRunning()) {
					repaintTimer.start();
				}
				enableGravity = false;
			} else {
				repaintTimer.stop();
				// System.out.println("Enabling Gravity");
				enableGravity = true;
			}
		}
	}

}
