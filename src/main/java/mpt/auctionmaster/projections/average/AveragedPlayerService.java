package mpt.auctionmaster.projections.average;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import mpt.auctionmaster.enums.PlayerIDGetterStrategies;
import mpt.auctionmaster.enums.Position;
import mpt.auctionmaster.players.Player;
import mpt.auctionmaster.players.PlayerIDGetterStrategy;
import mpt.auctionmaster.projections.ProjectionService;
import mpt.auctionmaster.projections.ProjectionSource;
import mpt.auctionmaster.projections.ProjectionSourceContext;
import mpt.auctionmaster.projections.ProjectionWeightService;

/**
 * Created by UTUOMMA on 8/23/2015.
 */
@Component
public class AveragedPlayerService {

	@Autowired
	private ProjectionWeightService projectionWeightService;
	
	@Autowired
	private ProjectionService projectionService;
	
	@Autowired
	private ProjectionSourceContext projectionSourceContext;
	
	@Autowired
	private Environment env;

	public List<Player> getAveragedPlayers(Position position) throws IOException, URISyntaxException {
		final Map<ProjectionSource, BigDecimal> projectionWeights = projectionWeightService.getProjectionWeight(position);
		final List<List<Player>> playerLists = new ArrayList<>();
		final List<BigDecimal> weights = new ArrayList<>();
		for (final ProjectionSource source : projectionWeights.keySet()) {
			projectionSourceContext.setProjectionSource(source);
			final List<Player> playerList = projectionService.getPlayerMap().get(position);
			if (playerList != null) {
				playerLists.add(playerList);
			}

			weights.add(projectionWeights.get(source));
		}

		final PlayerIDGetterStrategy strategy = PlayerIDGetterStrategies.valueOf(env.getProperty(position.name() + "-idStrategy")).getStrategy();
		
		if (playerLists.size() == 1) {
			return playerLists.get(0);
		}
		
		return ProjectionAveragingService.getWeightedAverages(
			playerLists.get(0),
			playerLists.get(1),
			weights.get(0),
			weights.get(1),
			strategy
		);

	}

	public void setProjectionWeightService(ProjectionWeightService projectionWeightService) {
		this.projectionWeightService = projectionWeightService;
	}

	public void setProjectionService(ProjectionService projectionService) {
		this.projectionService = projectionService;
	}
	
	
}
