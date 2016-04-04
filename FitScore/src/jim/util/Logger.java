package jim.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Logger {
	
	SimpleDateFormat sdf = new SimpleDateFormat( "HH:mm:ss.SSS");
	Calendar c = GregorianCalendar.getInstance();
	Map<String, String> piiDataMask = new HashMap<String, String>();
	
	String matchKey="piiDataMask.matches";
	String replaceKey="piiDataMask.replace";
	
	private static Logger singleton=null;
	
	private static Logger getSingleton(){
		if( singleton == null){
			singleton = new Logger();
		}
		
		return singleton;
	}
	
	private Logger(){
		int index=1;
		
		while( !FordProperties.getProperty(matchKey+index).equals("") ){
			piiDataMask.put( FordProperties.getProperty(matchKey+index), FordProperties.getProperty(replaceKey+index));
			index++;
		}
	}

	public static void log( Object message){
		getSingleton().concreteLog(message);
	}

	private void concreteLog( Object message){
		System.out.println( sdf.format( c.getTime() ) + " - " + cleanOutput(message.toString() ) );
	}
	
	public static void error( Object message){
		getSingleton().concreteError(message);
	}
	
	private void concreteError( Object message){
		System.err.println( sdf.format( c.getTime() ) + " - " + cleanOutput( message.toString()) );
	}
	
	private String cleanOutput( String output ){
		StringBuilder builder = new StringBuilder( output );
		String s1=builder.toString();
		String match;

		Set<String> keys = piiDataMask.keySet();
		for( String key : keys ){
			if( s1.matches( key )) {
				match = piiDataMask.get(key);
				int start = builder.indexOf( match ) + match.length();
				int end = builder.indexOf("&", start);
				builder.replace( start , end, "********");
			}
		}
		
		return builder.toString();
	}
}
