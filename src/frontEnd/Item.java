package frontEnd;

import java.awt.Point;
import java.util.logging.Logger;

import util.GameConstants;
import util.LoggerConstants;

public class Item {
	
	private final static Logger _log = Logger.getLogger(Item.class.getName());
	
	private int height,width;
	private int image;
	private Point itemPoint;
	
	public Item(int image, int height, int width) {
		this.image = image;
		this.height = height;
		this.width = width;
	}
	
	public Item(){
		this.width=GameConstants.ITEM_WIDTH;
		this.height=GameConstants.ITEM_HEIGHT;
		
		this.itemPoint = new Point(GameConstants.ITEM_START_X_POS, GameConstants.ITEM_START_Y_POS);
		
		if( LoggerConstants.isFine() ) 
			_log.fine("x="+itemPoint.getX());
		if( LoggerConstants.isFine() ) 
			_log.fine("y="+itemPoint.getY());
		if( LoggerConstants.isFine() ) 
			_log.fine("width="+this.width);
		if( LoggerConstants.isFine() )
			_log.fine("height="+this.height);
	}
	
	public Point getPoint() {
		return itemPoint;
	}
	public double getX() {
		return itemPoint.getX();
	}
	
	public double getY() {
		return itemPoint.getY();
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
		itemPoint.setLocation(itemPoint.getX(), itemPoint.getY() + GameConstants.ITEM_MOVE_Y);
		if( LoggerConstants.isFine() ) 
			_log.fine("y="+itemPoint.getY());
		
	}
	
	public void update(double x, double y){
		itemPoint.setLocation(x, y);
	}
	
}
