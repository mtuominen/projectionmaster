package mpt.auctionmaster.players.stats.build;

import java.math.BigDecimal;

import mpt.auctionmaster.players.stats.ReceivingStats;

public class ReceivingStatsBuilder {

	public BigDecimal receptions;
	
	public BigDecimal receivingYards;
	
	public BigDecimal receivingTouchdowns;
	
	public ReceivingStatsBuilder() {}
	
	private ReceivingStatsBuilder(BigDecimal receptions,
			BigDecimal receivingYards, BigDecimal receivingTouchdowns) {
	    this.receptions = receptions;
	    this.receivingYards = receivingYards;
	    this.receivingTouchdowns = receivingTouchdowns;
    }
	
	public ReceivingStats build() {
		return new ReceivingStats(receptions,
                receivingYards, receivingTouchdowns);
    }

	public void setReceptions(BigDecimal receptions) {
    	this.receptions = receptions;
    }

	public void setReceivingYards(BigDecimal receivingYards) {
    	this.receivingYards = receivingYards;
    }

	public void setReceivingTouchdowns(BigDecimal receivingTouchdowns) {
    	this.receivingTouchdowns = receivingTouchdowns;
    }
	
	
}
