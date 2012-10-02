package gui;

import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Logger;

import javax.swing.JFrame;

import motion.MouseMotionDetector;
import util.GameConstants;
import frontEnd.Arm;
import frontEnd.GameManager;
import frontEnd.Item;


public class GameScreen extends JFrame {
	
	private final static Logger _log = Logger.getLogger(GameScreen.class.getName());
	private GameManager game;
	
	public GameScreen(GameManager game, ScoreBoard scoreBoard) {
		this.game = game;
		this.setSize(GameConstants.SCREEN_X_SIZE, GameConstants.SCREEN_Y_SIZE);
		this.setVisible(true);
	    this.addWindowListener(new WindowAdapter() {
	        public void windowClosing(WindowEvent e) {
	          System.exit(0);
	        }
	      });
	    this.addMouseListener(new MouseMotionDetector(this));
	    this.add(scoreBoard);   
	}
	
	public void processMotion(Point startPoint, Point endPoint) {
		game.processMotion(startPoint, endPoint);
	}
	
	public void paintObject(Item item) {
	    this.add(new PaintableItem(item));
	}
	
}