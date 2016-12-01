package developers.elements;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import developers.Game2;

public class LargePlatform extends JComponent{

	private static final long serialVersionUID = 1L;
	
	ClassLoader cl = this.getClass().getClassLoader();
	
	private BufferedImage img;
	private Dimension dim;
	private int x, y;
	
	public Dimension getDim(){
		return dim;
	}
	
	public void setDim(Dimension dim){
		this.dim = dim;
	}

	public void setDim(int x, int y){
		dim.setSize(x, y);
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}

	public LargePlatform(int x, int y) throws IOException {
		this.x = x;
		this.y = y;
		dim = new Dimension(500, 20);
		this.img = ImageIO.read(cl.getResource("img/largeplatform.png"));
		GameLevel.addPlatform(this);
	}
	
	public LargePlatform(int x, int y, Dimension dim, BufferedImage img) {
		this.x = x;
		this.y = y;
		this.dim = dim;
		this.img = img;
		GameLevel.addPlatform(this);
	}
	
	public LargePlatform(int x, int y, int xPos, int yPos, BufferedImage img) {
		this.x = x;
		this.y = y;
		setDim(xPos, yPos);
		this.img = img;
		GameLevel.addPlatform(this);
		repaint();
	}
	
	public LargePlatform(int x, int y, Dimension dim, String path) throws IOException {
		this.x = x;
		this.y = y;
		this.dim = dim;
		this.img = ImageIO.read(cl.getResource(path));
		GameLevel.addPlatform(this);
	}
	
	public LargePlatform(int x, int y, int xPos, int yPos, String path) throws IOException {
		this.x = x;
		this.y = y;
		setDim(xPos, yPos);
		this.img = ImageIO.read(cl.getResource(path));
		GameLevel.addPlatform(this);
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Game2.log("drew platform");
		g.drawImage(img, x, y, this);
	}

}
