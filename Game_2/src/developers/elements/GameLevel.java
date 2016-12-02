package developers.elements;

import java.awt.Graphics;

import developers.Game2;

public class GameLevel {
	
	private static Platform[] platforms = new Platform[6];
	private static int platNum = 0;
	
	public static int getPlatNum(){
		return platNum;
	}
	public static Platform getPlat(int plat){
		return platforms[plat];
	}
	
	public static Platform[] getPlat(){
		return platforms;
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
	
	public static void paintPlats(Graphics g){
		for (int i = 0; i < platNum; i++){
			platforms[i].paintComponent(g);
		}
	}

}
