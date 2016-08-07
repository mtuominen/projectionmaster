package mpt.auctionmaster.players.stats;

import java.math.BigDecimal;

/**
 * Created by UTUOMMA on 8/19/2015.
 */
public final class ReturningStats {

	private final BigDecimal kickReturnTouchdowns;

	private final BigDecimal puntReturnTouchdowns;


	public ReturningStats(BigDecimal kickReturnTouchdowns, BigDecimal puntReturnTouchdowns) {
		this.kickReturnTouchdowns = kickReturnTouchdowns;
		this.puntReturnTouchdowns = puntReturnTouchdowns;
	}


	public BigDecimal getKickReturnTouchdowns() {
		return kickReturnTouchdowns;
	}


	public BigDecimal getPuntReturnTouchdowns() {
		return puntReturnTouchdowns;
	}

	public boolean isEmpty() {
		return null == kickReturnTouchdowns
				&& null == puntReturnTouchdowns;
	}
}
