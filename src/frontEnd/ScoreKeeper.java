package frontEnd;

import java.util.HashSet;

/**
 * Keeps the score of the game. You can also subscribe to updates via the addScoreChangedListener()
 * @author jzeimen
 *
 */
public class ScoreKeeper {
	
	private int score;
	private String playerName;
	
	public ScoreKeeper(String playerName){
		this.playerName = playerName;
		score = 0;
	}
	
	public int getScore(){
		return score;
	}
	
	public String getName(){
		return playerName;
	}
	
	public void addPoints(int points){
		score+=points;
		notifyScoreChangedListeners();
	}
	
	
	HashSet<ScoreChangedListener> scoreChangedListeners= new HashSet<ScoreChangedListener>();
	/**
	 * @param scoreChangedListener
	 * The listener you wish to add to the set.  
	 * @return  
	 * true if this set did not already contain the specified element 
	 */
	public boolean addScoreChangedListener(ScoreChangedListener scoreChangedListener){
		return scoreChangedListeners.add(scoreChangedListener);
	}
	
	
	/**
	 * Tells all of the listeners added that the score has been updated with its new value.
	 */
	private void notifyScoreChangedListeners(){
		for( ScoreChangedListener i :scoreChangedListeners){
			i.scoreUpdated(score);
		}
	}
	
}
