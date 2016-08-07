package mpt.auctionmaster.players.stats.build;

import java.math.BigDecimal;

import mpt.auctionmaster.players.stats.ReturningStats;

/**
 * Created by UTUOMMA on 8/19/2015.
 */
public class ReturningStatsBuilder {

	private BigDecimal kickReturnTouchdowns;

	private BigDecimal puntReturnTouchdowns;

	public ReturningStatsBuilder() {}

	public ReturningStatsBuilder(BigDecimal kickReturnTouchdowns, BigDecimal puntReturnTouchdowns) {
		this.kickReturnTouchdowns = kickReturnTouchdowns;
		this.puntReturnTouchdowns = puntReturnTouchdowns;
	}

	public ReturningStats build() {
		return new ReturningStats(kickReturnTouchdowns, puntReturnTouchdowns);
	}


	public void setKickReturnTouchdowns(BigDecimal kickReturnTouchdowns) {
		this.kickReturnTouchdowns = kickReturnTouchdowns;
	}


	public void setPuntReturnTouchdowns(BigDecimal puntReturnTouchdowns) {
		this.puntReturnTouchdowns = puntReturnTouchdowns;
	}
}
