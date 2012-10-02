package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Logger;

import javax.swing.JPanel;

import util.GameConstants;
import frontEnd.Arm;
import frontEnd.Item;

// TODO:
// 	refactor this class to not be a JPanel - drawing multiple JPanels is not the way to go

public class PaintableItem extends JPanel {
	
	private final static Logger _log = Logger.getLogger(PaintableItem.class.getName());
	private Item item;
	
	public PaintableItem(Item item) {
		this.item = item;
		this.setSize(item.getWidth(), item.getHeight());
		this.setBackground(new Color(0, 0, 0, 0));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.blue);
		g.drawRect(item.getX(), item.getY(), item.getWidth(), item.getHeight());
		g.drawLine(180, GameConstants.CONVEYOR_END_POS, 400, GameConstants.CONVEYOR_END_POS);
	}

}