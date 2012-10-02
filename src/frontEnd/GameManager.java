package frontEnd;

import gui.GameScreen;
import gui.ScoreBoard;

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
	private ScoreKeeper scoreKeeper;
	private ScoreBoard scoreBoard;
	
	public GameManager() {
		scoreKeeper = new ScoreKeeper("Player1");
		scoreBoard = new ScoreBoard(scoreKeeper);
		screen = new GameScreen(this, scoreBoard);
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
		int x, y;
		for(Item i : items)
		{
			y = i.getY() + (i.getHeight() / 2);
			if(startY > y && startY < y + i.getHeight()){
				x = i.getX();
				_log.info("itemX=" + x);
				if(x > startX && x < endX)
				{
					_log.info("Moving Right!");
					i.update(i.getX() + 100, i.getY());
					screen.repaint();
				}
				if(x < startX && x > endX)
				{
					_log.info("Moving Left!");
					i.update(i.getX() - 100, i.getY());
					screen.repaint();
				}
			}else 
				_log.info("Y not in box.");
		}
	}
	
	public static void update() {
		_log.info("GameManager Update");
		
		for (int i = 0; i < items.size(); i++) {
			items.get(i).update();
		}
		screen.repaint();
	}
	
	public static void main(String[] args) {
		GameManager game = new GameManager();
		
		MotionDetector detector = new MouseMotionDetector(screen);
		
		// adds the initial item
		game.addItem(new Item());
		screen.setVisible(true);
		screen.repaint();
		
		// initially gives the player a score of 5 so that we can count down
		game.scoreKeeper.addPoints(5);
		
		while (game.scoreKeeper.getScore() > 0) {
			screen.repaint();
			scheduler.update();
		
			int yPos = items.get(items.size() - 1).getY();
			
			// if the newest item is past the 100 down y position create a new item
			if (yPos >= GameConstants.NEW_ITEM_THRESHOLD) {
				game.addItem(new Item());
				screen.setVisible(true);
			}
			
			// if an item is in the bin (past the line) remove it from the array and decrement the score
			if (items.get(0).getY() >= 400) {
				items.remove(0);
				game.scoreKeeper.addPoints(-1);
			}
		}
	}
	
}