/*
	Game_2 
    Copyright (C) 2016  Lovett Developers Club
*/

package developers;

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

import developers.elements.GameLevel;
import developers.elements.Platform;

public class Player extends JComponent {

	private static final long serialVersionUID = 1L;
	private int xPos = 50, yPos = 800;
	private int moveSpeed = 5;
	private int xDelta = 0;
	private int yDelta = 0;

	private int gDelay = 0;

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
		if (xPos < 200 && yPos > 500) {
			System.out.println("");
			return true;
		}
		Platform[] plats = GameLevel.getPlat();
		System.out.println("");
		for (int i = 0; i < GameLevel.getPlatNum(); i++) {
			System.out.println("");
			if (plats[i].inBounds(xPos, yPos)) {
				return true;
			}
		}
		return false;
	}

	public void gravity() {
		if (enableGravity ) {
			while (!checkBounds()) {
				if (gDelay == 1000) {
					System.out.println("");
					yPos += 1;
					gDelay = 1;
					WindowRunner.getPanel().repaint();
				}
				gDelay++;

			}
		}
	}

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
			} else {
				repaintTimer.stop();
			}
		}
	}

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
				enableGravity = true;
			}
		}
	}

}
