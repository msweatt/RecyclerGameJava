package gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import motion.MouseMotionDetector;
import util.Global;
import frontEnd.GameManager;
import frontEnd.Item;


public class GameScreen extends JFrame {
	
	
	private GameManager game;
	
	public GameScreen(GameManager game) {
		//super();// = new JFrame();
		this.game = game;
		this.setSize(Global.screenX, Global.screenY);
		this.setVisible(true);
	    this.addWindowListener(new WindowAdapter() {
	        public void windowClosing(WindowEvent e) {
	          System.exit(0);
	        }
	      });
	    this.addMouseListener(new MouseMotionDetector(this));
	}
	
	public void processMotion(int startX, int endX, int startY, int endY) {
		game.processMotion(startX, endX, startY, endY);
	}
	
	public void paintObject(Item item) {
		// TODO Auto-generated method stub
	    this.add(new PaintableItem(item));
	}
	
	

}