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

import developers.elements.LargePlatform;

public class Game2 {

	private static boolean init = false;

	private static Player player;
	static LargePlatform plat1;

	public static Player getPlayer() {
		return player;
	}

	public static boolean isInit() {
		return init;
	}

	public static void main(String[] args) throws IOException {
		if (!init) {
			printLicense();
			player = new Player("img/dude.png");
			WindowRunner.init("Game_2");
			plat1 = new LargePlatform(200, 300);
			init = true;
		}
		WindowRunner.run();
	}
	
	public static final void printLicense(){
		System.out.println("Game_2  Copyright (C) 2016  Lovett Developers Club\n"
				+ "This program comes with ABSOLUTELY NO WARRANTY; for details type `show w'.\n"
				+ "This is free software, and you are welcome to redistribute it\n"
				+ "under certain conditions; type `show c' for details.\n"
				+ "\n(don't though, this doesn't take arguments)\n\n\n");
	}
	
	public static void log(String s){
		if (Settings.testMode){
			System.out.println(s);
		}
	}

}
