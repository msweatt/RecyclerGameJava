package util;

public class LoggerConstants
{
	/* 
	*	Set the desired level of logging here.
	* Types:
	* 		SEVERE -- Lowest level of detail, highest value of importance (mostly errors in the program)
	* 		INFO   -- Reports Severe and Info logging, just simple information about the runtime.
	* 		FINE   -- Higher level of detail, includes Info and Severe, is used for debugging. 
	* 		FINEST -- Highest level of detail, this will trace all the information through out the program.
	*/
	
	
	public static String loggingType = "";
	
	
	
	/*
	 * Public Functions to check the logging state
	 */
	public static boolean isSevere(){
		
		if( loggingType == "SEVERE"){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean isInfo(){
			
			if( loggingType == "INFO"){
				return true;
			}else{
				return false;
			}
		}
	
	public static boolean isFine(){
			
			if( loggingType == "FINE"){
				return true;
			}else{
				return false;
			}
		}
	
	public static boolean isFinest(){
			
			if( loggingType == "FINEST"){
				return true;
			}else{
				return false;
			}
		}
}