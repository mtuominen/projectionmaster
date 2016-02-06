package mpt.auctionmaster.players.stats;

import java.math.BigDecimal;

public final class ReceivingStats {
	
	public final BigDecimal receptions;
	
	public final BigDecimal receivingYards;
	
	public final BigDecimal receivingTouchdowns;

    public ReceivingStats(
		BigDecimal receptions,
		BigDecimal receivingYards,
		BigDecimal receivingTouchdowns
	) {
	    this.receptions = receptions;
	    this.receivingYards = receivingYards;
	    this.receivingTouchdowns = receivingTouchdowns;
    }
	
	public BigDecimal getReceptions() {
    	return receptions;
    }

	public BigDecimal getReceivingYards() {
    	return receivingYards;
    }

	public BigDecimal getReceivingTouchdowns() {
    	return receivingTouchdowns;
    }
	
	public boolean isEmpty() {
		return null == receptions 
				&& null == receivingYards 
				&& null == receivingTouchdowns;
	}

}