package jim.util;



public class Logger {


	public static void debug(String message, Class messageClass){
//		Log logger = LogFactory.getLog(messageClass);
//		logger.debug("Jim Was Here");
		
//		logger.debug( " log_appender==["+System.getenv("LOG_APPENDER") +"]");
		
		System.out.println(message);
	}

}
