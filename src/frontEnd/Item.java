package frontEnd;

import util.Global;

public class Item {
	
	private static int x,y;
	private int height,width;
	private int image;
	
	public Item(int image, int height, int width) {
		this.image = image;
		this.height = height;
		this.width = width;
	}
	//public Item(int minX,int maxX,int minY,int maxY){
	public Item(){
		this.width=Global.itemWidth;
		this.height=Global.itemHeight;
		this.x=Global.itemStartX;
		this.y=Global.itemStartY;
		
		
		//System.out.println("minX="+minX);
		//System.out.println("maxX="+maxX);
		//System.out.println("minY="+minY);
		//System.out.println("maxY="+maxY);
		System.out.println("x="+x);
		System.out.println("y="+y);
		System.out.println("width="+this.width);
		System.out.println("height="+this.height);
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
	
	public static void update(){
		y=y+Global.itemMoveY;
		System.out.println("y="+y);
	}
	
	public void update(int x, int y){
		this.x = x;
		this.y = y;
	}
	
}
