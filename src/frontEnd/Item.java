package frontEnd;

import java.util.logging.Logger;

import util.GameConstants;

public class Item {
	
	private final static Logger _log = Logger.getLogger(Item.class.getName());
	
	private int x,y;
	private int height,width;
	private int image;
	
	public Item(int image, int height, int width) {
		this.image = image;
		this.height = height;
		this.width = width;
	}
	
	//public Item(int minX,int maxX,int minY,int maxY){
	public Item(){
		this.width=GameConstants.ITEM_WIDTH;
		this.height=GameConstants.ITEM_HEIGHT;
		this.x=GameConstants.ITEM_START_X_POS;
		this.y=GameConstants.ITEM_START_Y_POS;
		
		
		//_log.info("minX="+minX);
		//_log.info("maxX="+maxX);
		//_log.info("minY="+minY);
		//_log.info("maxY="+maxY);
		_log.info("x="+x);
		_log.info("y="+y);
		_log.info("width="+this.width);
		_log.info("height="+this.height);
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	public void init() {
		
	}
	
	public void update(){
		y = y + GameConstants.ITEM_MOVE_Y;
		_log.info("y="+y);
	}
	
	public void update(int x, int y){
		this.x = x;
		this.y = y;
	}
	
}
