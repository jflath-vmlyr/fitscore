package jim.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/CallBack")
public class CallBackController {
	//http://localhost:8080/FitScore/rest/CallBack/OAuthCallback
	
	@GET
	@Path("/OAuthCallback")
	public Response handleCallback( @QueryParam("code") String code   ) {

		System.out.println(code);
		return Response.status(500).entity( "ERROR" ).build();
	}

	@GET
	@Path("/FromCode")
	public Response handleCallbackFromCode( @QueryParam("code") String code   ) {

		System.out.println(code);
		return Response.status(500).entity( "ERROR" ).build();
	}
	
//redirect_uri = 'http://localhost:8080/FitScore/rest/CallBack/FromCode'

}
