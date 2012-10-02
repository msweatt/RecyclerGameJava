package frontEnd;

import gui.GameScreen;
import java.util.ArrayList;
import java.util.logging.Logger;

import motion.MotionDetector;
import motion.MouseMotionDetector;
import frontEnd.Item;
import frontEnd.Scheduler;
import util.Direction;
import util.GameConstants;


public class GameManager {
	
	private final static Logger _log = Logger.getLogger(GameManager.class.getName());
	
	
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
		_log.info("Processing motion...");
		int x,y;
		for(Item i : items)
		{
			y = i.getY()+(i.getHeight()/2);
			if(startY>y && startY<y+i.getHeight()){
				x = i.getX();
				_log.info("itemX="+x);
				if(x > startX && x < endX)
				{
					_log.info("Moving Right!");
					i.update(i.getX() + 100, i.getY());
					screen.repaint();
				}
				if(x < startX && x > endX)
				{
					_log.info("Moving Left!");
					i.update(i.getX() - 100,i.getY());
					screen.repaint();
				}
			}else 
				_log.info("Y not in box.");
		}
	}
	
	public static void update() {
		_log.info("GameManager Update");
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
		while(yPos<GameConstants.CONVEYOR_END_POS && items.get(0).getX()==GameConstants.ITEM_START_X_POS){
			screen.repaint();
			scheduler.update();
			count++;
			yPos=items.get(0).getY();
		}
		_log.info("x="+items.get(0).getX());
		_log.info("x="+items.get(0).getY());
		
		if(items.get(0).getX()!=GameConstants.ITEM_START_X_POS)
			_log.info("You win!");
		if(items.get(0).getY()>=400)
			_log.info("You lose..");
			
	}
	
}