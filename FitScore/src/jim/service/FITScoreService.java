package jim.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import jim.domain.FitScore;

public class FITScoreService {
	
	
	static Map<Integer, Double> factorMap = new HashMap<Integer, Double>();
	
	static{
		factorMap.put( new Integer(26), new Double(0.1645) );
		factorMap.put( new Integer(25), new Double(0.1630) );
		factorMap.put( new Integer(24), new Double(0.1615) );
		factorMap.put( new Integer(23), new Double(0.1600) );
		factorMap.put( new Integer(22), new Double(0.1585) );
		factorMap.put( new Integer(21), new Double(0.1570) );
		factorMap.put( new Integer(20), new Double(0.1555) );
		factorMap.put( new Integer(19), new Double(0.1540) );
		factorMap.put( new Integer(18), new Double(0.1525) );
		factorMap.put( new Integer(17), new Double(0.1510) );
		factorMap.put( new Integer(16), new Double(0.1495) );
		factorMap.put( new Integer(15), new Double(0.1480) );
		factorMap.put( new Integer(14), new Double(0.1465) );
		factorMap.put( new Integer(13), new Double(0.1450) );
		factorMap.put( new Integer(12), new Double(0.1435) );
		factorMap.put( new Integer(11), new Double(0.1420) );
		factorMap.put( new Integer(10), new Double(0.1405) );
		factorMap.put( new Integer(9), new Double(0.1390) );
		factorMap.put( new Integer(8), new Double(0.1375) );
		factorMap.put( new Integer(7), new Double(0.1360) );
		factorMap.put( new Integer(6), new Double(0.1345) );
		factorMap.put( new Integer(5), new Double(0.1330) );
		factorMap.put( new Integer(4), new Double(0.1315) );
		factorMap.put( new Integer(3), new Double(0.1300) );
		factorMap.put( new Integer(2), new Double(0.1200) );
		factorMap.put( new Integer(1), new Double(0.1100) );
	}	
	
	public FitScore calculateFitScore( String distance, String pace, String time ){
		
		
		FitScore retVal = new FitScore();
		retVal.setDistance( distance );
		if( pace.isEmpty() ) {
			convertTimeToMPH( retVal, distance, time);
		} else {
			
			calculateMPH(retVal, pace );
		}
		
		
		Integer factorDistance = (int) Double.parseDouble( distance );
		BigDecimal factor = BigDecimal.valueOf( factorMap.get(factorDistance));
		
		retVal.setFitScore( retVal.getMph().multiply( BigDecimal.valueOf(100)).multiply(factor).subtract( BigDecimal.valueOf(50)) );
		
		System.out.println( "Distance=["+ distance+"] pace=["+pace+"] time=[" + time +"] mph=[" + retVal.getMph() + "] score=["+retVal.getFitScore()+"]");
		return retVal;
	}
	
	private BigDecimal convertTimeToMPH(FitScore retVal, String distance, String time){
		BigDecimal decimalTime = convertPace( time );
		
		Double d = Double.parseDouble(distance);
		BigDecimal pace = decimalTime.divide( BigDecimal.valueOf( d ), 6, RoundingMode.HALF_UP) ;
		
		retVal.setPace(pace);
		retVal.setTime( time );
		retVal.setMph( BigDecimal.valueOf(60).divide(pace, 6, RoundingMode.HALF_UP));
		return retVal.getMph();
	}
	
	private void calculateMPH( FitScore retVal, String pace ){
		BigDecimal paceDecimal = convertPace( pace );
		
		retVal.setPace( paceDecimal);
		retVal.setMph(BigDecimal.valueOf(60).divide(paceDecimal, 6, RoundingMode.HALF_UP));
		
	}
	
	private BigDecimal convertPace( String pace ){
		
		pace = pace.replace(":", ".");
		pace = new BigDecimal( pace).setScale(2).toString();
		
		double decimal = 0;
//		pace=bigDecimalPace.toString();
		
		if( pace.indexOf(".") > -1 )
			decimal = Integer.valueOf( pace.split("\\.")[1] );
		else
			decimal += 0.00;
		
		decimal = (decimal/60);
		
		return new BigDecimal( decimal + Integer.valueOf(pace.split("\\.")[0]));
	}
}
