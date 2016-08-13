package mpt.auctionmaster.projections;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mpt.auctionmaster.csv.loading.CSVPlayerLoader;
import mpt.auctionmaster.enums.Position;
import mpt.auctionmaster.json.loading.JSONPlayerLoader;
import mpt.auctionmaster.players.Player;
import mpt.auctionmaster.properties.ProjectionFormat;

@Component
public class ProjectionService {
	
	@Autowired
	private CSVPlayerLoader csvPlayerLoader;

	@Autowired
	private JSONPlayerLoader jsonPlayerLoader;

	@Autowired
	private ProjectionSourceContext projectionSourceContext;

	public Map<Position, List<Player>> getPlayerMap() throws IOException, URISyntaxException {
			try {
				ProjectionFormat projectionFormat = projectionSourceContext.getProjectionSource().getPropertyManager().getProjectionFormat();
				if (ProjectionFormat.CSV == projectionFormat) {
					return csvPlayerLoader.loadPlayers();
				} else if (ProjectionFormat.JSON == projectionFormat) {
					return jsonPlayerLoader.loadPlayers();
				} else {
					throw new IllegalStateException("Only CSV and JSON formats are supported.");
				}
			} catch (IOException io) {
				io.printStackTrace();
				return new EnumMap<>(Position.class);
			}
	}

}
