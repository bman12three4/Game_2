package developers;

import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar{
	
	private static final long serialVersionUID = 1L;
	
	JMenu menu, submenu;
	JMenuItem menuItem;

	public MenuBar() {
		menu = new JMenu("Help");
		menu.setMnemonic(KeyEvent.VK_H);
		add(menu);
		
		menuItem = new JMenuItem("How to play");
		menu.add(menuItem);
	}

}
