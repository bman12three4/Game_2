package developers.elements;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

import developers.WindowRunner;

public class Mother extends JComponent{
	
	private int xPos = 50, yPos = 50;
	private int moveSpeed = 5;
	private int xDelta = 0;
	private int yDelta = 0;

	BufferedImage img;
	ClassLoader cl = this.getClass().getClassLoader();
	
	public Mother(String path){
		try {
			img = ImageIO.read(cl.getResource(path));
		} catch (IOException e) {
			System.out.println(e);
		}
		setFocusable(true);
		WindowRunner.getPanel().add(this);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, xPos, yPos, this);
	}

}
