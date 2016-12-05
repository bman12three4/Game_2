package developers.elements;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class Floor extends JComponent{

	private static final long serialVersionUID = 1L;
	int y;

	public Floor() {
		
	}
	
	public Floor(int y){
		this.y = y;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//g.drawImage(img, x, y, this);
		// Change this to an image once you make one
		g.setColor(Color.BLACK);
		g.drawRect(0, 1000-y, 800, y);
	}

}
