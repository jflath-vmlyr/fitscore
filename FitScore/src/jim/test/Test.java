package jim.test;

import jim.domain.FitScore;
import jim.service.FITScoreService;

public class Test {

	public static void main(String[] args) {
		doit();
//		decimalTest();
	}
/*
	private static void decimalTest() {
		BigDecimal bigDecimal = new BigDecimal("999.4");
		BigDecimal newOne = bigDecimal.setScale(2);
		
		 String string = newOne.toPlainString();
		 int index = string.indexOf(".");
		 
		 System.out.println(string + " - " + index + " - "  + (index < 0 ? 0 : string.length() - index - 1));

		 
		 
		
	}
*/
	private static void doit() {
		
		FITScoreService fitScoreService = new FITScoreService();
		FitScore fitScore = null;
		
//		fitScore = fitScoreService.calculateFitScore( "7", "8.04", "" );
//		System.out.println( fitScore.getFitScore() );
//		
//		fitScore = fitScoreService.calculateFitScore( "7", "", "56.28" );
//		System.out.println( fitScore.getFitScore() );

		fitScore = fitScoreService.calculateFitScore( "7", "8.4", "" );
		System.out.println( fitScore.getFitScore() );
		
		fitScore = fitScoreService.calculateFitScore( "7", "8.40", "" );
		System.out.println( fitScore.getFitScore() );
		
		fitScore = fitScoreService.calculateFitScore( "7", "", "67.40" );
		System.out.println( fitScore.getFitScore() );

		fitScore = fitScoreService.calculateFitScore( "7", "", "67.4" );
		System.out.println( fitScore.getFitScore() );
		
	}

}
