package developers.elements;

import java.awt.Graphics;
import java.io.IOException;

import developers.Game2;
import developers.elements.Platform.Size;

public class GameLevel {
	
	private static Platform[] platforms = new Platform[6];
	private static int platNum = 0;
	
	private static Ladder[] ladders = new Ladder[10];
	private static int ladNum = 0;
	
	private static Floor floor = new Floor(100);
	
	public static Floor getFloor(){
		return floor;
	}
	
	public static int getPlatNum(){
		return platNum;
	}
	public static Platform getPlat(int plat){
		return platforms[plat];
	}
	
	public static Platform[] getPlat(){
		return platforms;
	}
	
	public static int getLadNum(){
		return ladNum;
	}
	
	public static Ladder getLadder(int lad){
		return ladders[lad];
	}
	
	public static Ladder[] getLadder(){
		return ladders;
	}
	
	public static final int[] xBoundLeft = {0};
	public static final int[] xBoundRight = {800};
	
	public static boolean isInRange(int pos){
		for (int i = 0; i < xBoundRight.length && i < xBoundRight.length; i++){
			if (pos > xBoundLeft[i] && pos < xBoundRight[i]){
				return true;
			}
		}
		return false;
	}
	
	public static void addPlatform(Platform plat){
		platforms[platNum] = plat;
		platNum++;
		for (int i = 0; i < platNum; i++){
			platforms[i].repaint();
			Game2.log("repainting plats " + i);
		}
	}
	
	public static void addLadder(Ladder lad){
		ladders[ladNum] = lad;
		ladNum++;
		for (int i = 0; i < ladNum; i++){
			ladders[i].repaint();
			Game2.log("repainting lads " + i);
		}
	}
	
	public static void paintPlats(Graphics g){
		for (int i = 0; i < platNum; i++){
			platforms[i].paintComponent(g);
		}
	}
	
	public static void paintLads(Graphics g){
		for (int i = 0; i < ladNum; i++){
			ladders[i].paintComponent(g);
		}
	}
	
	public static void paintFloor(Graphics g){
		floor.paintComponent(g);
	}

	public static void generateLevel() throws IOException {
		new Platform(25, 300, Size.Full);
		new Platform(25, 500, Size.Full);
		new Platform(25, 700, Size.Full);
		new Ladder(100, 700);
		new Ladder(600, 500);
		new Ladder(200, 300);
		
	}

}
