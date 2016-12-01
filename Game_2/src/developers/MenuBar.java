/*
	Game_2 
    Copyright (C) 2016  Lovett Developers Club
*/

package developers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar implements ActionListener {

	private static final long serialVersionUID = 1L;

	public static final int HELP_ID = 1001;

	JMenu menu, submenu;
	JMenuItem menuItem;

	public MenuBar() {
		menu = new JMenu("Help");
		menu.setMnemonic(KeyEvent.VK_H);
		add(menu);

		menuItem = new JMenuItem("How to play");
		menuItem.addActionListener(this);
		menu.add(menuItem);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getID() == HELP_ID){
			
		}	

	}

}
