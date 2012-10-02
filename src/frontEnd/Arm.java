package frontEnd;

import util.GameConstants;
import java.util.logging.Logger;

public class Arm {
	
	private final static Logger _log = Logger.getLogger(Arm.class.getName());
	
	private int xPos;
	private int yPos;
	private int direction;
	private int velocity;
	public int image;
	
	public Arm() {
		xPos = GameConstants.SCREEN_X_SIZE / 2;
		yPos = GameConstants.SCREEN_Y_SIZE/ 2;
		direction = GameConstants.left;
	}
	
	public void init(){
		
	}
	
	public void update(int x,int y) {
		xPos = x;
		yPos = y;
	}
	
}
