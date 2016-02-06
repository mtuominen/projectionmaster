package mpt.auctionmaster.players.stats.build;

import java.math.BigDecimal;

import mpt.auctionmaster.players.stats.PassingStats;

public class PassingStatsBuilder {

	private BigDecimal passingAttempts;

	private BigDecimal passingCompletions;

	private BigDecimal passingYards;

	private BigDecimal passingTouchdowns;

	private BigDecimal passingInterceptions;

	public PassingStatsBuilder() {}

	/**
     * @param passingAttempts
     * @param passingCompletions
     * @param passingYards
     * @param passingTouchdowns
     * @param passingInterceptions
     */
    private PassingStatsBuilder(BigDecimal passingAttempts, BigDecimal passingCompletions,
			BigDecimal passingYards, BigDecimal passingTouchdowns,
            BigDecimal passingInterceptions) {
	    this.passingAttempts = passingAttempts;
	    this.passingCompletions = passingCompletions;
	    this.passingYards = passingYards;
	    this.passingTouchdowns = passingTouchdowns;
	    this.passingInterceptions = passingInterceptions;
    }

    public PassingStats build() {
    	return new PassingStats(passingAttempts, passingCompletions,
                passingYards, passingTouchdowns, passingInterceptions);
    }

    public void setPassingAttempts(BigDecimal passingAttempts) {
    	this.passingAttempts = passingAttempts;
    }

    public void setPassingCompletions(BigDecimal passingCompletions) {
    	this.passingCompletions = passingCompletions;
    }

    public void setPassingYards(BigDecimal passingYards) {
    	this.passingYards = passingYards;
    }

    public void setPassingTouchdowns(BigDecimal passingTouchdowns) {
    	this.passingTouchdowns = passingTouchdowns;
    }

    public void setPassingInterceptions(BigDecimal passingInterceptions) {
    	this.passingInterceptions = passingInterceptions;
    }
}
