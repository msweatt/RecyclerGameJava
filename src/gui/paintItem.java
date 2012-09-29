package gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import frontEnd.Item;

public class paintItem extends JPanel{
	private Item item;
	
	public void PaintableItem(Item _item) {
		this.item=_item;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.blue);
		g.drawRect(item.getX(), item.getY(), item.getWidth(), item.getHeight());
	}

}