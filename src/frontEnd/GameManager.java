package frontEnd;

import gui.GameScreen;
import java.util.ArrayList;
import motion.MotionDetector;
import motion.MouseMotionDetector;
import frontEnd.Item;
import util.Global;


public class GameManager {
	private GameScreen screen;
	private ArrayList<Item> items = new ArrayList<Item>();
	private ArrayList<Bin> bins = new ArrayList<Bin>();
	private Arm arm;
	private Conveyer conveyer;
	private Scheduler scheduler;
	private int highScore;
	
	public GameManager(){
		screen = new GameScreen();;
	}
	public GameScreen getScreen(){
		return screen;
	}
	private void addItem(Item _item){
		items.add(_item);
	}
	private void addBin(Bin _bin){
		bins.add(_bin);
	}
	
	public void processMotion()	{
		System.out.println("Processing motion...");
		
	}
	public void update(){}
	
	
	public static void main(String[] args){
		GameManager game = new GameManager();
		GameScreen screen = game.getScreen();
		MotionDetector detector = new MouseMotionDetector(screen);
		
	}
}