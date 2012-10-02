package frontEnd;


import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

import util.GameConstants;

import frontEnd.GameManager;
import gui.GameScreen;

public class Scheduler {
	
	private final static Logger _log = Logger.getLogger(Scheduler.class.getName());
	
	
	static long time1,time2;
	static GameManager gameManager;
	static GameScreen gameScreen;
	static boolean printTime2 = true;
	static int count=0;
	
	public Scheduler(GameManager _gameManager){
		gameManager=_gameManager;
		time1 = new Date().getTime();
		//_log.info("Date() - Time in milliseconds: " + time1);
	}
	
	public static void update(){
		_log.info("Scheduler Update");
		_log.info("time1="+time1);
		
		time2=new Date().getTime();
		_log.info("time2="+time2);
		if(time2>time1+GameConstants.DELAY){
			_log.info("Updating");
			gameManager.update();
			time1=time2;
			printTime2=true;
		}else {
			if(printTime2){
				//_log.info("time2="+time2);
				_log.info("NotTime");
				printTime2=false;
			}
		}
	
	}
	
}
