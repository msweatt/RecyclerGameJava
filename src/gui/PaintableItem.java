package gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

import util.Global;
import frontEnd.Item;

public class PaintableItem extends JPanel {
	
	private Item item;
	
	public PaintableItem(Item item) {
		this.item = item;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.blue);
		g.drawRect(item.getX(), item.getY(), item.getWidth(), item.getHeight());
		g.drawLine(180, Global.conveyerEndPosition, 400, Global.conveyerEndPosition);
	}

}