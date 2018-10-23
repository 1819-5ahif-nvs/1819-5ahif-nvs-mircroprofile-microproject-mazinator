package at.htl.nvs.nfl.rest;

import at.htl.nvs.nfl.entities.Player;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import java.util.Date;

@ApplicationScoped
@Path("/hello")
public class HelloWorldEndpoint {

	@GET
	@Produces("text/plain")
	public Response doGet() {
		return Response.ok("Hello from Thorntail!").build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/player")
	public Player getPlayer(){
		Player p = new Player();
		p.setEnterDate(null);
		p.setPlayerName("Brady");
		p.setPosition("QB");
		return p;
	}
}
