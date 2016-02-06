package mpt.auctionmaster.value;

import java.util.List;
import java.util.Map;

import mpt.auctionmaster.enums.Position;
import mpt.auctionmaster.players.Player;

public interface AuctionAlgorithm {
	
	public void populateAuctionValues(
			Map<Position, List<Player>> playerMap, 
			AuctionAlgorithmConfiguration configuration);

}
