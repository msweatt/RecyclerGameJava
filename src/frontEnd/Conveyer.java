package frontEnd;

import java.util.logging.Logger;

import util.GameConstants;

public class Conveyer {
	
	private final static Logger _log = Logger.getLogger(Conveyer.class.getName());
	
	private int speed;
	private int image;
	
	public Conveyer() {
		speed = GameConstants.CONVEYOR_START_SPEED; 
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void init() {
		
	}
	
	public void update() {
		
	}
	
}
