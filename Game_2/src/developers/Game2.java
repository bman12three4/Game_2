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

import java.io.IOException;

import developers.elements.Ladder;
import developers.elements.Platform;
import developers.elements.Player;
import developers.elements.Platform.Size;

public class Game2 {

	private static boolean init = false;
	private static boolean halt = false;

	private static Player player;
	
	static int i = 0;

	public static Player getPlayer() {
		return player;
	}

	public static boolean isInit() {
		return init;
	}

	public static void main(String[] args) throws IOException {
		if (!init) {
			printLicense();
			System.out.println("licnse");
			player = new Player("img/player2.jpg");
			WindowRunner.init("Game_2");
			System.out.println("window");
			new Platform(25, 300, Size.Full);
			System.out.println("firstplat");
			new Platform(25, 500, Size.Full);
			new Platform(25, 700, Size.Full);
			new Ladder(100, 700);
			new Ladder(600, 500);
			new Ladder(200, 300);
			System.out.println("platforms");
			WindowRunner.getPanel().repaint();
			System.out.println("first paint");
			init = true;
		}
		while (!halt){
			System.out.println("asdfasdfasdf");
			WindowRunner.run();
		}
	}
	
	public static final void printLicense(){
		System.out.println("Game_2  Copyright (C) 2016  Lovett Developers Club\n"
				+ "This program comes with ABSOLUTELY NO WARRANTY; for details type `show w'.\n"
				+ "This is free software, and you are welcome to redistribute it\n"
				+ "under certain conditions; type `show c' for details.\n"
				+ "\n(don't though, this doesn't take arguments)\n\n\n");
	}
	
	public static void log(String s){
		if (Settings.verboseMode){
			System.out.println(s);
		}
	}

}
