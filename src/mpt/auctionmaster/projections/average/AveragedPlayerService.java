package mpt.auctionmaster.projections.average;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import mpt.auctionmaster.enums.PlayerIDGetterStrategies;
import mpt.auctionmaster.enums.Position;
import mpt.auctionmaster.players.Player;
import mpt.auctionmaster.players.PlayerIDGetterStrategy;
import mpt.auctionmaster.projections.ProjectionService;
import mpt.auctionmaster.projections.ProjectionSource;
import mpt.auctionmaster.projections.ProjectionWeightService;
import mpt.auctionmaster.properties.ApplicationProperties;

/**
 * Created by UTUOMMA on 8/23/2015.
 */
public class AveragedPlayerService {

	private final ProjectionWeightService projectionWeightService;
	private final ProjectionService projectionService = new ProjectionService();
	private final ApplicationProperties applicationProperties;

	public AveragedPlayerService(ApplicationProperties applicationProperties) {
		projectionWeightService = new ProjectionWeightService(applicationProperties);
		this.applicationProperties = applicationProperties;
	}

	public List<Player> getAveragedPlayers(Position position) throws IOException, URISyntaxException {
		final Map<ProjectionSource, BigDecimal> projectionWeights = projectionWeightService.getProjectionWeight(position);
		final List<List<Player>> playerLists = new ArrayList<>();
		final List<BigDecimal> weights = new ArrayList<>();
		for (final ProjectionSource source : projectionWeights.keySet()) {
			final List<Player> playerList = projectionService.getPlayerMap(source).get(position);
			if (playerList != null) {
				playerLists.add(playerList);
			}

			weights.add(projectionWeights.get(source));
		}

		final PlayerIDGetterStrategy strategy = PlayerIDGetterStrategies.valueOf(applicationProperties.getProperty(position.name() + "-idStrategy")).getStrategy();
		
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
}
