package motion;


import frontEnd.Arm;
import frontEnd.GameManager;
import gui.GameScreen;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Logger;

import util.LoggerConstants;

public class MouseMotionDetector implements MouseListener, MotionDetector {
	
	private final static Logger _log = Logger.getLogger(MouseMotionDetector.class.getName());
	
	
	private GameScreen screen;
	private Point startPoint;
	private Point endPoint;
	
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
		startPoint = new Point(arg0.getX(), arg0.getY());
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		endPoint = new Point(arg0.getX(), arg0.getY());
		
		if( LoggerConstants.isFine() ) _log.fine("Sending " + startPoint.getX() + " " + endPoint.getX() + " " + startPoint.getY() + " " + endPoint.getY());
		
		screen.processMotion(startPoint, endPoint);
		
		screen.repaint();
	}

}
