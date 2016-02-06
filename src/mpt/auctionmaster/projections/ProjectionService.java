package mpt.auctionmaster.projections;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mpt.auctionmaster.csv.loading.CSVPlayerLoader;
import mpt.auctionmaster.enums.Position;
import mpt.auctionmaster.players.Player;
import mpt.auctionmaster.properties.ApplicationProperties;

public class ProjectionService {

	public Map<Position, List<Player>> getPlayerMap(ProjectionSource projectionSource) throws IOException, URISyntaxException {
			try {
				final CSVPlayerLoader loader = new CSVPlayerLoader(projectionSource.getPropertyManager());
				return loader.loadPlayers();
			} catch (IOException io) {
				io.printStackTrace();
				return new EnumMap<>(Position.class);
			}
	}

}
