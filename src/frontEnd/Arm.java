package frontEnd;

import util.Global;

public class Arm {
	private Global global;
	private int xPos,yPos,direction,velocity;
	public int image;
	
	public Arm(){
		xPos=global.xResolution/2;
		yPos=global.yResolution/2;
		direction=global.left;
	}
	
	public void init(){}
	public void update(int _x,int _y){
		xPos=_x;
		yPos=_y;
	}
}
