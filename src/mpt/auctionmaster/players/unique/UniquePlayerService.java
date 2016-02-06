package mpt.auctionmaster.players.unique;

import java.util.List;

/**
 * Created by UTUOMMA on 8/10/2015.
 */
public interface UniquePlayerService {

	void addUniquePlayer(UniquePlayer player);

	UniquePlayer getUniquePlayer(String position, String firstName, String lastName, Integer id, String team, String status);
}
