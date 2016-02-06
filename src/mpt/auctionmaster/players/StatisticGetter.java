package mpt.auctionmaster.players;

import java.math.BigDecimal;

/**
 * Created by UTUOMMA on 8/21/2015.
 */
public interface StatisticGetter<I> {

	/**
	 * Gets the value for the given statistic.
	 *
	 * @param player
	 * 		the player to get it from
	 */
	I get(Player player);
}
