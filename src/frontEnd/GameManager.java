package frontEnd;

import gui.GameScreen;
import gui.ScoreBoard;

import java.awt.Point;
import java.util.ArrayList;
import java.util.logging.Logger;

import motion.MotionDetector;
import motion.MouseMotionDetector;
import frontEnd.Item;
import frontEnd.Scheduler;
import util.Direction;
import util.GameConstants;
import util.LoggerConstants;


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
	
	private void binTracking(Item item){
		double x = item.getX();
		double y = item.getY();
		//This section of code will not be placed here... this is only for testing//
				if ( (y >= 0) && (y <200) ) {
					
					if( LoggerConstants.isFine() ) _log.fine("Box was pushed into bin one.");
				}
				if ( (y >= 200) && (y <400) ) {
					
					if( LoggerConstants.isFine() ) _log.info("Box was pushed into bin two");
				}
		//-----------------------------------------------------------------------//
	}
	
	public void processMotion(Point startPoint, Point endPoint) {
		
		
		//TODO: refactor this to use just point
		double startX = startPoint.getX();
		double startY = startPoint.getY();
		double endX = endPoint.getX();
		double endY = endPoint.getY();
		
		if( LoggerConstants.isInfo() ) _log.info("Processing motion...");
		double x, y;
		for(Item i : items)
		{
			y = i.getY() + (i.getHeight() / 2);
			
			if(startY > y && startY < y + i.getHeight()){
				
				x = i.getX();
				if( LoggerConstants.isFine() ) _log.fine("itemX=" + x);
				
				if(x > startX && x < endX)
				{
					if( LoggerConstants.isFine() ) _log.fine("Moving Right!");
					i.update(i.getX() + 100, i.getY());
					binTracking(i);
					screen.repaint();
				}
				if(x < startX && x > endX)
				{
					if( LoggerConstants.isFine() ) _log.fine("Moving Left!");
					i.update(i.getX() - 100, i.getY());
					binTracking(i);
					screen.repaint();
				}
				
				
			}else{
				if( LoggerConstants.isSevere() ) _log.severe("Y not in box.");
			}
		}
	}
	
	public static void update() {
		if( LoggerConstants.isFinest() ) _log.finest("GameManager Update");
		
		for (int i = 0; i < items.size(); i++) {
			if(items.get(i).getX()==GameConstants.ITEM_START_X_POS){
				if(items.get(i).getY()<GameConstants.CONVEYOR_END_POS){
					items.get(i).update();
				}
			}
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
		
			double yPos = items.get(items.size() - 1).getY();
			
			// if the newest item is past the 100 down y position create a new item
			if (yPos >= GameConstants.NEW_ITEM_THRESHOLD) {
				game.addItem(new Item());
				screen.setVisible(true);
			}
			
			// if an item is in the bin (past the line) remove it from the array and decrement the score
			
			if(items.get(0).getX()!= GameConstants.ITEM_START_X_POS){
				items.remove(0);
			}
			
			if (items.get(0).getY() >= 400) {
				items.remove(0);
				game.scoreKeeper.addPoints(-1);
			}
		}
	}
	
}