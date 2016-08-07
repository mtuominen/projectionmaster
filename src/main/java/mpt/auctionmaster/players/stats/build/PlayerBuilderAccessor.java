package mpt.auctionmaster.players.stats.build;

/**
 * Created by UTUOMMA on 8/19/2015.
 */
public class PlayerBuilderAccessor {

	private final PlayerBuilder playerBuilder;

	public PlayerBuilderAccessor(PlayerBuilder playerBuilder) {
		this.playerBuilder = playerBuilder;
	}

	public String getName() {
		return playerBuilder.getName();
	}
}
