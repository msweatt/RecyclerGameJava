package frontEnd;

import gui.GameScreen;
import java.util.ArrayList;

import motion.MotionDetector;
import motion.MouseMotionDetector;
import frontEnd.Item;
import frontEnd.Scheduler;
import util.Direction;
import util.Global;


public class GameManager {
	
	private static GameScreen screen;
	private static ArrayList<Item> items = new ArrayList<Item>();
	private ArrayList<Bin> bins = new ArrayList<Bin>();
	private Arm arm;
	private Conveyer conveyer;
	private static Scheduler scheduler;
	private int highScore;
	
	public GameManager() {
		screen = new GameScreen(this);
		scheduler= new Scheduler(this);
	}
	
	public GameScreen getScreen() {
		return screen;
	}
	
	private void addItem(Item item) {
		items.add(item);
		screen.paintObject(item);
	}
	
	private void addBin(Bin bin) {
		bins.add(bin);
	}
	
	public void processMotion(int startX, int endX, int startY, int endY) {
		System.out.println("Processing motion...");
		int x,y;
		for(Item i : items)
		{
			y = i.getY()+(i.getHeight()/2);
			if(startY>y && startY<y+i.getHeight()){
				x = i.getX();
				System.out.println("itemX="+x);
				if(x > startX && x < endX)
				{
					System.out.println("Moving Right!");
					i.update(i.getX() + 100, i.getY());
					screen.repaint();
				}
				if(x < startX && x > endX)
				{
					System.out.println("Moving Left!");
					i.update(i.getX() - 100,i.getY());
					screen.repaint();
				}
			}else 
				System.out.println("Y not in box.");
		}
	}
	
	public static void update() {
		System.out.println("GameManager Update");
		items.get(0).update();
		screen.repaint();
		
	}
	
	public static void main(String[] args) {
		GameManager game = new GameManager();
		
		MotionDetector detector = new MouseMotionDetector(screen);
		
		game.addItem(new Item());
		
		screen.setVisible(true);
		screen.repaint();
		
		 
		int count=0;
		int yPos=0;
		while(yPos<400 && items.get(0).getX()==Global.itemStartX){
			screen.repaint();
			scheduler.update();
			count++;
			yPos=items.get(0).getY();
		}
		System.out.println("x="+items.get(0).getX());
		System.out.println("x="+items.get(0).getY());
		
		if(items.get(0).getX()!=Global.itemStartX)
			System.out.println("You win!");
		if(items.get(0).getY()>=400)
			System.out.println("You loose..");
			
	}
	
}