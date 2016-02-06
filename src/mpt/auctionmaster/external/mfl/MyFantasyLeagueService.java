package mpt.auctionmaster.external.mfl;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 * Created by UTUOMMA on 8/3/2015.
 */
@Path("2015")
@Consumes("application/x-www-form-urlencoded")
@Produces("application/json")
public interface MyFantasyLeagueService {

	@Path("export")
	@GET
	MyFantasyLeaguePlayersExport getPlayerExport(
		@QueryParam("TYPE") String exportType,
		@QueryParam("L") String leagueId,
		@QueryParam("W") String week,
		@QueryParam("JSON") int json);
}
