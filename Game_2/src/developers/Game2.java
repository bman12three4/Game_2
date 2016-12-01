package developers;

import java.io.IOException;

public class Game2 {

	private static boolean init = false;
	
	public static boolean isInit(){
		return init;
	}

	public static void main(String[] args) throws IOException {
		if (!isInit()) {
			WindowRunner.init("Game_2");
			Player player = new Player("img/dude.png");
			init = true;
		}
		
	}

}
