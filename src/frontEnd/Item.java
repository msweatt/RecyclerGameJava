package frontEnd;

import java.util.logging.Logger;

import util.GameConstants;
import util.LoggerConstants;

public class Item {
	
	private final static Logger _log = Logger.getLogger(Item.class.getName());
	
	private int xCoord,y;
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
		this.xCoord=GameConstants.ITEM_START_X_POS;
		this.y=GameConstants.ITEM_START_Y_POS;
		
		
		//_log.info("minX="+minX);
		//_log.info("maxX="+maxX);
		//_log.info("minY="+minY);
		//_log.info("maxY="+maxY);
		if( LoggerConstants.isFine() ) _log.fine("x="+xCoord);
		if( LoggerConstants.isFine() ) _log.fine("y="+y);
		if( LoggerConstants.isFine() ) _log.fine("width="+this.width);
		if( LoggerConstants.isFine() ) _log.fine("height="+this.height);
	}
	
	public int getX() {
		return xCoord;
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
		if( LoggerConstants.isFine() ) _log.fine("y="+y);
		
	}
	
	public void update(int x, int y){
		this.xCoord = x;
		this.y = y;
	}
	
}
