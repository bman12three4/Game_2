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
		player = new Player("img/dude.png");
		WindowRunner.init("Game_2");
		WindowRunner.getPanel().repaint();
	}

}
