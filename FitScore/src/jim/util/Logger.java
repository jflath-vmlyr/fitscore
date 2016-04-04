package jim.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class Logger {


	public static void debug(String message){
		Log logger = LogFactory.getLog(Logger.class);
		logger.debug("Jim Was Here");
	}

}
