package jim.util;

import java.io.InputStream;
import java.util.Properties;

public class FordProperties {
	private static Properties props;
	private static String ENV_PREPEND;
	
	
	static {
		props = new Properties();
		
		System.out.println( "using the static properties");
		System.getProperties().setProperty("ENV", "DEV");
		props = new StaticProperties().getStaticProperties();
		
//		try{
//			InputStream in = FordProperties.class.getResourceAsStream("ford.properties");
//			props.load( in );
//									
//		} catch( Exception e){
//			Logger.error(e);
//		}
		
		ENV_PREPEND=System.getProperty("ENV") == null ? "DEV." : System.getProperty("ENV") + ".";
		
		
	}
	
	public static String getProperty( String key ){
		String retVal = "";
		
		if( props.containsKey(ENV_PREPEND + key) ){
			retVal = props.getProperty( ENV_PREPEND + key );
		} else {
			retVal = props.getProperty(key);
		}
		
		System.out.println( "key=["+key+"] value=["+retVal+"]");
		return retVal != null ? retVal : "";
	}
}
