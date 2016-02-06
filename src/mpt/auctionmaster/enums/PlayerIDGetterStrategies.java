package mpt.auctionmaster.enums;

import mpt.auctionmaster.players.DefaultPlayerIDGetter;
import mpt.auctionmaster.players.MatchingPlayerIDGetter;
import mpt.auctionmaster.players.PlayerIDGetterStrategy;

/**
 * Created by UTUOMMA on 8/27/2015.
 */
public enum PlayerIDGetterStrategies {
	DEFAULT(new DefaultPlayerIDGetter()),
	MATCHING(new MatchingPlayerIDGetter());

	private final PlayerIDGetterStrategy strategy;

	PlayerIDGetterStrategies(PlayerIDGetterStrategy strategy) {
		this.strategy = strategy;
	}

	public PlayerIDGetterStrategy getStrategy() {
		return strategy;
	}
}
