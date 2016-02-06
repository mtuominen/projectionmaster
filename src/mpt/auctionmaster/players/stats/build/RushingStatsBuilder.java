package mpt.auctionmaster.players.stats.build;

import java.math.BigDecimal;

import mpt.auctionmaster.players.stats.RushingStats;

public class RushingStatsBuilder {
	
	private BigDecimal rushingCarries;
	
	private BigDecimal rushingYards;
	
	private BigDecimal rushingTouchdowns;

	private BigDecimal fumbles;
	
	public RushingStatsBuilder() {}

	/**
     * @param rushingCarries
     * @param rushingYards
     * @param rushingTouchdowns
     */
    private RushingStatsBuilder(BigDecimal rushingCarries, BigDecimal rushingYards,
            BigDecimal rushingTouchdowns, BigDecimal fumbles) {
	    this.rushingCarries = rushingCarries;
	    this.rushingYards = rushingYards;
	    this.rushingTouchdowns = rushingTouchdowns;
		this.fumbles = fumbles;
    }
    
	public RushingStats build() {
		return new RushingStats(rushingCarries, rushingYards,
                rushingTouchdowns, fumbles);
    }

	public void setRushingCarries(BigDecimal rushingCarries) {
    	this.rushingCarries = rushingCarries;
    }

	public void setRushingYards(BigDecimal rushingYards) {
    	this.rushingYards = rushingYards;
    }

	public void setRushingTouchdowns(BigDecimal rushingTouchdowns) {
    	this.rushingTouchdowns = rushingTouchdowns;
    }


	public void setFumbles(BigDecimal fumbles) {
		this.fumbles = fumbles;
	}
}
