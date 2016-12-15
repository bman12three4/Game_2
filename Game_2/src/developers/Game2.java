/*
	Game_2 
    Copyright (C) 2016  Lovett Developers Club

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package developers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Timer;

import developers.elements.GameLevel;
import developers.elements.Player;

public class Game2 {


	private static Player player;

	static int i = 0;

	public static Player getPlayer() {
		return player;
	}

	public static void main(String[] args) throws IOException {
		init();
		int delay = 20; // milliseconds
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				run();
			}
		};
		new Timer(delay, taskPerformer).start();
	}

	public static void init() throws IOException {
		printLicense();
		player = new Player("img/player2.jpg");
		WindowRunner.init("Game_2");
		GameLevel.generateLevel();
		WindowRunner.getPanel().repaint();
	}

	public static void run() {

	}

	public static final void printLicense() {
		System.out.println("Game_2  Copyright (C) 2016  Lovett Developers Club\n"
				+ "This program comes with ABSOLUTELY NO WARRANTY; for details type `show w'.\n"
				+ "This is free software, and you are welcome to redistribute it\n"
				+ "under certain conditions; type `show c' for details.\n"
				+ "\n(don't though, this doesn't take arguments)\n\n\n");
	}

	public static void log(String s) {
		if (Settings.verboseMode) {
			System.out.println(s);
		}
	}

}
