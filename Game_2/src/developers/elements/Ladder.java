package developers.elements;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Ladder extends JComponent{
	
	private static final long serialVersionUID = 1L;
	
	private Dimension dim;
	private int xPos, yPos;
	private BufferedImage img;
	
	ClassLoader cl = this.getClass().getClassLoader();
	
	/**
	 * @return the dim
	 */
	public Dimension getDim() {
		return dim;
	}

	/**
	 * @param dim the dim to set
	 */
	public void setDim(Dimension dim) {
		this.dim = dim;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return xPos;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.xPos = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return yPos;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.yPos = y;
	}

	/**
	 * @return the img
	 */
	public BufferedImage getImg() {
		return img;
	}

	/**
	 * @param img the img to set
	 */
	public void setImg(BufferedImage img) {
		this.img = img;
	}

	public Ladder() throws IOException {
		this.dim = null;
		this.img = null;
		GameLevel.addLadder(this);
	}
	
	public Ladder(int x, int y) throws IOException{
		this.xPos = x;
		this.yPos = y;
		dim = new Dimension(75, 150);
		img = ImageIO.read(cl.getResource("img/ladder.png"));
		GameLevel.addLadder(this);
	}

	public Ladder(int x, int y, String img, Dimension dim) throws IOException{
		this.xPos = x;
		this.yPos = y;
		this.dim = dim;
		this.img = ImageIO.read(cl.getResource(img));
		GameLevel.addLadder(this);
	}
	
	public Ladder(int x, int y, BufferedImage img, Dimension dim) throws IOException{
		this.xPos =x;
		this.yPos = y;
		this.dim = dim;
		this.img = img;
		GameLevel.addLadder(this);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, xPos, yPos, this);
	}

}
