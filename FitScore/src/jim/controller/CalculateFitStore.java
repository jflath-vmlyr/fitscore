package jim.controller;

import java.text.DecimalFormat;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import jim.domain.FitScore;
import jim.service.FITScoreService;

@Path("/Service")
public class CalculateFitStore {

/*
 *	{
 *		"distance": "5.18",
 *		"pace": "8.14",
 *		"time": "40.01"
 *	} 
 */
	static DecimalFormat df = new DecimalFormat("00.00");
	
	private FITScoreService fitScoreService = new FITScoreService();
	
	@GET
	@Path("/calculate")
	public Response calculate( @QueryParam("distance") String distance,  @QueryParam("pace") String pace, @QueryParam("time")String time  ) {

		pace = pace.replaceAll(":", ".");
	
		if( pace.isEmpty() && time.isEmpty() )
			return Response.status(500).entity( "ERROR" ).build();
		else {
			
			FitScore fitScoreAnswer = fitScoreService.calculateFitScore( distance, pace, time );

			return Response.status(200).entity( fitScoreAnswer.getFitScore().toString() ).build();
		}
		
	}

}
