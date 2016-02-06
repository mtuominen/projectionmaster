package mpt.auctionmaster.players;

import mpt.auctionmaster.players.stats.build.PlayerBuilder;

/**
 * Created by UTUOMMA on 8/21/2015.
 */
public interface StatisticSetter<I> {
	/**
	 * Sets the value for the given statistic.
	 *
	 * @param value
	 * 		the value to set
	 */
	PlayerBuilder set(I value);
}
