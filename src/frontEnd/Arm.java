package frontEnd;

import util.Global;

public class Arm {
	private int xPos, yPos, direction, velocity;
	public int image;
	
	public Arm() {
		xPos = Global.screenX / 2;
		yPos = Global.screenY/ 2;
		direction = Global.left;
	}
	
	public void init(){
		
	}
	
	public void update(int x,int y) {
		xPos = x;
		yPos = y;
	}
	
}
