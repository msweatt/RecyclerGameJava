package gui;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

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
	JLabel playerNameLabel;
	JLabel scoreLabel;
	
	public ScoreBoard(ScoreKeeper scoreKeeper) {
		this.scoreKeeper= scoreKeeper;
		this.scoreKeeper.addScoreChangedListener(this);
		this.setLayout(new FlowLayout());
		this.setSize(new Dimension(100,20));
		playerNameLabel = new JLabel(scoreKeeper.getName() + ":");
		scoreLabel = new JLabel(Integer.toString(scoreKeeper.getScore()));
		
		this.add(playerNameLabel);
		this.add(scoreLabel);
	}

	@Override
	public void scoreUpdated(int score) {
		scoreLabel.setText(Integer.toString(score));
	}

}
