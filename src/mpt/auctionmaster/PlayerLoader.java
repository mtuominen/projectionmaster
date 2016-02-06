package mpt.auctionmaster;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import mpt.auctionmaster.enums.Position;
import mpt.auctionmaster.players.Player;

public interface PlayerLoader {
	
	/**
	 * @return a map key=position and value=all players at that position
	 */
	Map<Position, List<Player>> loadPlayers() throws IOException, URISyntaxException;

}
