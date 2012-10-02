package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Logger;

import javax.swing.JPanel;

import util.GameConstants;
import frontEnd.Arm;
import frontEnd.Item;

public class PaintableItem extends JPanel {
	
	private final static Logger _log = Logger.getLogger(PaintableItem.class.getName());
	
	private Item item;
	
	public PaintableItem(Item item) {
		this.item = item;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.blue);
		g.drawRect(item.getX(), item.getY(), item.getWidth(), item.getHeight());
		g.drawLine(180, GameConstants.CONVEYOR_END_POS, 400, GameConstants.CONVEYOR_END_POS);
	}

}