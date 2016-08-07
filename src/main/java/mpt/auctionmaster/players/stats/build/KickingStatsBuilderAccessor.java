package mpt.auctionmaster.players.stats.build;

import java.math.BigDecimal;

/**
 * Created by UTUOMMA on 8/18/2015.
 */
public class KickingStatsBuilderAccessor {

	private final KickingStatsBuilder kickingStatsBuilder;

	public KickingStatsBuilderAccessor(KickingStatsBuilder kickingStatsBuilder) {
		this.kickingStatsBuilder = kickingStatsBuilder;
	}

	public BigDecimal getMadeFieldGoals() {
		return kickingStatsBuilder.getMadeFieldGoals();
	}


	public BigDecimal getMadeExtraPoints() {
		return kickingStatsBuilder.getMadeExtraPoints();
	}
}
