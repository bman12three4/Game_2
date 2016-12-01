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

public class Game2 {

	private static boolean init = false;

	private static Player player;

	public static Player getPlayer() {
		return player;
	}

	public static boolean isInit() {
		return init;
	}

	public static void main(String[] args) throws IOException {
		if (!init) {
			player = new Player("img/dude.png");
			WindowRunner.init("Game_2");
			init = true;
		}
		WindowRunner.getPanel().repaint();
	}

}
