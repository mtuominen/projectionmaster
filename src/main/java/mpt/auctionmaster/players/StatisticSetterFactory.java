package mpt.auctionmaster.players;

import mpt.auctionmaster.players.stats.build.PlayerBuilder;

/**
 * Created by UTUOMMA on 8/21/2015.
 */
public interface StatisticSetterFactory<S extends StatisticSetter> {

	S create(PlayerBuilder player);
}
