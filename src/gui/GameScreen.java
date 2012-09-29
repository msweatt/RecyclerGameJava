package gui;

import frontEnd.GameManager;
import frontEnd.Item;
import util.Global;
import gui.paintItem;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import motion.MouseMotionDetector;


public class GameScreen extends JFrame {
	private JFrame frame;
	private Global global;
	
	public GameScreen() {
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
	
	
	public void paintObject(Item _item) {
		// TODO Auto-generated method stub
	    //frame.add(new PaintableItem(_item));
	}
	
	public void repaint() {
		frame.repaint();
	}

}