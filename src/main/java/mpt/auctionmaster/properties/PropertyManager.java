/**
 * 
 */
package mpt.auctionmaster.properties;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import mpt.auctionmaster.enums.Position;
import mpt.auctionmaster.enums.Statistic;
import mpt.auctionmaster.enums.Team;

/**
 * @author Matthew Tuominen
 *
 */
public interface PropertyManager {

	String PROJECTION_DIRECTORY = "projections";
	
	String getProjectionsDirectory();
	
	String getAuctionBreakdownDirectory();
	
	Map<String, Team> getTeamProperties() throws IOException, URISyntaxException;
	
	Map<Team, Integer> getByeProperties() throws IOException, URISyntaxException;
	
	Map<String, Statistic> getStatisticProperties() throws IOException, URISyntaxException;
	
	Map<String, Position> getPositionProperties() throws IOException, URISyntaxException;
	
	List<Statistic> getUnlabeledStatisticOrder() throws IOException, URISyntaxException;

	ProjectionFormat getProjectionFormat();

	int getProjectorId();
}
