package frontEnd;

import util.Global;

public class Item {
	
	private int x,y;
	private int height,width;
	private int image;
	
	public Item(int image, int height, int width) {
		this.image = image;
		this.height = height;
		this.width = width;
	}
	public Item(int minX,int maxX,int minY,int maxY){
		this.x = minX + (int)(Math.random()*(maxX-minX+1));
		this.y = minY + (int)(Math.random()*(maxY-minY+1));
		
		this.width=25;
		this.height=25;
		
		
		System.out.println("minX="+minX);
		System.out.println("maxX="+maxX);
		System.out.println("minY="+minY);
		System.out.println("maxY="+maxY);
		System.out.println("x="+x);
		System.out.println("y="+y);
		System.out.println("width="+this.width);
		System.out.println("height="+this.height);
		
		this.y = 150;
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
	
	public void update(int x, int y){
		this.x = x;
		this.y = y;
	}
}
