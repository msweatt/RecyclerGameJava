package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import frontEnd.ScoreChangedListener;
import frontEnd.ScoreKeeper;


/**
 * This class listens for changes to the score and displays that score as it is changed.
 * @author jzeimen
 *
 */
@SuppressWarnings("serial")
public class ScoreBoard extends JPanel implements ScoreChangedListener {
	
	ScoreKeeper scoreKeeper;
	JLabel playerName;
	JLabel scoreLabel;
	
	public ScoreBoard(ScoreKeeper scoreKeeper) {
		this.scoreKeeper= scoreKeeper;
		this.scoreKeeper.addScoreChangedListener(this);
		this.setLayout(new FlowLayout());
		this.setSize(new Dimension(100,20));
		playerName = new JLabel(scoreKeeper.getName() + ":");
		scoreLabel = new JLabel(Integer.toString(scoreKeeper.getScore()));
		
		this.add(playerName);
		this.add(scoreLabel);
	}

	@Override
	public void scoreUpdated(int score) {
		scoreLabel.setText(Integer.toString(score));
	}

}
