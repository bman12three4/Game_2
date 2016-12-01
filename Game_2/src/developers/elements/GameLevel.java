package developers.elements;

public class GameLevel {

	public GameLevel() {
		// TODO Auto-generated constructor stub
	}
	
	private static LargePlatform[] lPlatforms = new LargePlatform[6];
	private static int platNum = 0;
	
	public static LargePlatform getPlat(int plat){
		return lPlatforms[plat];
	}
	
	public static LargePlatform[] getPlat(){
		return lPlatforms;
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
	
	public static void addPlatform(LargePlatform plat){
		lPlatforms[platNum] = plat;
		platNum++;
		for (int i = 0; i < platNum; i++){
			lPlatforms[i].repaint();
			System.out.println("repainting plats");
		}
	}

}
