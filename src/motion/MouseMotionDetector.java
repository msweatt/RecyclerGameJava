package motion;


import frontEnd.Arm;
import frontEnd.GameManager;
import gui.GameScreen;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Logger;

import util.LoggerConstants;

public class MouseMotionDetector implements MouseListener, MotionDetector {
	
	private final static Logger _log = Logger.getLogger(MouseMotionDetector.class.getName());
	
	
	private GameScreen screen;
	private int startX, startY, endX, endY;
	
	public MouseMotionDetector(GameScreen screen) {
		this.screen = screen;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// Do nothing
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// Do nothing
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// Do nothing
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		startX = arg0.getX();
		startY = arg0.getY();
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		endX = arg0.getX();
		endY = arg0.getY();
		
		if( LoggerConstants.isFine() ) _log.fine("Sending " + startX + " " + endX + " " + startY + " " + endY);
		
		screen.processMotion(startX, endX, startY, endY);
		
		screen.repaint();
	}

}
