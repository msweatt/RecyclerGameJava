package frontEnd;

import util.Global;

public class Conveyer {
	private Global global;
	private int speed;
	private int image;
	
	public int getSpeed(){
		return speed;
	}
	public void update(){
		
	}
	public Conveyer(){
		speed=global.conveyerStartSpeed; 
	}
}
