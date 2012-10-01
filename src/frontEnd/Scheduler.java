package frontEnd;


import java.util.Calendar;
import java.util.Date;

import util.Global;

import frontEnd.GameManager;

public class Scheduler {
	static long time1,time2;
	static GameManager gameManager;
	static boolean printTime2 = true;
	static int count=0;
	
	public Scheduler(GameManager _gameManager){
		gameManager=_gameManager;
		time1 = new Date().getTime();
		//System.out.println("Date() - Time in milliseconds: " + time1);
	}
	
	public static void update(){
		System.out.println("Scheduler Update");
		System.out.println("time1="+time1);
		
		time2=new Date().getTime();
		System.out.println("time2="+time2);
		if(time2>time1+Global.delay){
			System.out.println("Updating");
			gameManager.update();
			time1=time2;
			printTime2=true;
		}else {
			if(printTime2){
				//System.out.println("time2="+time2);
				System.out.println("NotTime");
				printTime2=false;
			}
		}
	
	}
	
}
