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
import mpt.auctionmaster.players.Player;

@Component
public class ProjectionService {
	
	@Autowired
	private CSVPlayerLoader csvPlayerLoader;

	public Map<Position, List<Player>> getPlayerMap() throws IOException, URISyntaxException {
			try {
				return csvPlayerLoader.loadPlayers();
			} catch (IOException io) {
				io.printStackTrace();
				return new EnumMap<>(Position.class);
			}
	}

}
