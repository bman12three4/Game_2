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

public class Player extends JComponent {

	private static final long serialVersionUID = 1L;
	private int xPos = 50, yPos = 50;
	private int moveSpeed = 4;
	private int xDelta = 0;
	
	private Timer repaintTimer;

	BufferedImage img;
	ClassLoader cl = this.getClass().getClassLoader();

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
        
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, false), "pressed.left");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, false), "pressed.right");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true), "released.left");
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, true), "released.right");

        am.put("pressed.left", new HorizAction(-1, true));
        am.put("pressed.right", new HorizAction(1, true));
        am.put("released.left", new HorizAction(0, false));
        am.put("released.right", new HorizAction(0, false));
		
		repaintTimer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xPos += xDelta;
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

	class HorizAction extends AbstractAction {
		
		boolean keyDown;
		int dir;
		
		public HorizAction(int dir, boolean down) {
			keyDown = down;
			this.dir = dir;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			xDelta = -moveSpeed;
			if (dir == 0){
				xDelta = 0;
			} else {
				xDelta = dir*moveSpeed;
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

}
