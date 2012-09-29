package frontEnd;

import gui.GameScreen;
import java.util.ArrayList;
import motion.MotionDetector;
import motion.MouseMotionDetector;
import frontEnd.Item;
import util.Global;


public class GameManager {
	private GameScreen screen;
	ArrayList<Item> items = new ArrayList<Item>();
	
	public GameManager(){
		screen = new GameScreen(this);;
	}
	
	public GameScreen getScreen(){
		return screen;
	}
	
	public void addItem(Item item){
		items.add(item);
	}
	
	public void processMotion()	{
		System.out.println("Processing motion...");
		
	}
	
	public static void main(String[] args){
		GameManager game = new GameManager();
		GameScreen screen = game.getScreen();
		MotionDetector detector = new MouseMotionDetector(screen);
		
	}

}