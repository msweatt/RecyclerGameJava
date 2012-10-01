package frontEnd;


import java.util.Calendar;
import java.util.Date;

import util.Global;

import frontEnd.GameManager;

public class Scheduler {
	long time1,time2;
	GameManager gameManager;
	boolean printTime2 = false;
	
	public Scheduler(GameManager _gameManager){
		this.gameManager=_gameManager;
		time1 = new Date().getTime();
		//System.out.println("Date() - Time in milliseconds: " + time1);
	}
	
	public void update(){
		time2=new Date().getTime();
	
		if(time2>time1+Global.delay){
			//System.out.println("Updating");
			gameManager.update();
			time1=time2;
			//printTime2=true;
		}else {
			if(printTime2){
				System.out.println("time2="+time2);
				System.out.println("NotTime");
				printTime2=false;
			}
		}
	}
	
}
