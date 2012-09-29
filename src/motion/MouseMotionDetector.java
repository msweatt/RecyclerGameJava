package motion;


import frontEnd.GameManager;
import gui.GameScreen;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseMotionDetector implements MouseListener, MotionDetector {
	private GameScreen screen;
	private int startX, startY, endX, endY;
	
	public MouseMotionDetector(GameScreen screen)
	{
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
		
		System.out.println("Sending " + startX + " " + endX + " " + startY + " " + endY);
		
		//screen.processMotion(startX, endX, startY, endY);
		
		screen.repaint();
	}

}
