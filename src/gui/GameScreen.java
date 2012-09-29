package gui;

import frontEnd.GameManager;
import frontEnd.Item;
import util.Global;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import motion.MouseMotionDetector;


public class GameScreen extends JFrame{
	private JFrame frame;
	private GameManager game;
	private Global global;
	
	public GameScreen(GameManager game)
	{
		this.game = game;
		frame = new JFrame();
		frame.setSize(global.xResolution,global.yResolution);
		frame.setVisible(true);
	    frame.addWindowListener(new WindowAdapter() {
	        public void windowClosing(WindowEvent e) {
	          System.exit(0);
	        }
	      });
	    frame.addMouseListener(new MouseMotionDetector(this));
	}
	
	
	public void paintObject(Item item) {
		// TODO Auto-generated method stub
	    //frame.add(new PaintableItem(i));
	}

	public void processMotion(int startX, int endX, int startY, int endY) {
		//game.processMotion(startX, endX, startY, endY);
	}
	
	public void repaint()
	{
		frame.repaint();
	}

}