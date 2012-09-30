package gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import frontEnd.Item;

public class PaintableItem extends JPanel{
	private Item item;
	
	public PaintableItem(Item _item) {
		this.item=_item;
	}

	public void paintComponent(Graphics _g) {
		super.paintComponent(_g);
		_g.setColor(Color.blue);
		_g.drawRect(item.getX(), item.getY(), item.getWidth(), item.getHeight());
	}

}