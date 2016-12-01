package developers;

public class GameLevel {

	public GameLevel() {
		// TODO Auto-generated constructor stub
	}
	
	public static final int[] xBoundLeft = {100};
	public static final int[] xBoundRight = {500};
	
	public static boolean isInRange(int pos){
		for (int i = 0; i < xBoundRight.length && i < xBoundRight.length; i++){
			if (pos > xBoundLeft[i] && pos < xBoundRight[i]){
				return true;
			}
		}
		return false;
	}

}
