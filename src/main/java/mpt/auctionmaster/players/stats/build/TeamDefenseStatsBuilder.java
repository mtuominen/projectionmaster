package mpt.auctionmaster.players.stats.build;

import java.math.BigDecimal;

import mpt.auctionmaster.players.stats.TeamDefenseStats;

public class TeamDefenseStatsBuilder {
	
	private BigDecimal touchdowns;
	
	private BigDecimal sacks;
	
	private BigDecimal interceptions;
	
	private BigDecimal fumblesRecovered;
	
	private BigDecimal safeties;

	private BigDecimal pointsAllowed;
	
	public TeamDefenseStatsBuilder() {}

	/**
     * @param touchdowns
     * @param sacks
     * @param interceptions
     * @param fumblesRecovered
     * @param safeties
     */
    private TeamDefenseStatsBuilder(BigDecimal touchdowns, BigDecimal sacks,
            BigDecimal interceptions, BigDecimal fumblesRecovered,
            BigDecimal safeties, BigDecimal pointsAllowed) {
	    this.touchdowns = touchdowns;
	    this.sacks = sacks;
	    this.interceptions = interceptions;
	    this.fumblesRecovered = fumblesRecovered;
	    this.safeties = safeties;
		this.pointsAllowed = pointsAllowed;
    }
    
    public TeamDefenseStats build() {
    	return new TeamDefenseStats(touchdowns, sacks,
                interceptions, fumblesRecovered,
                safeties, pointsAllowed);
    }

    public void setTouchdowns(BigDecimal touchdowns) {
    	this.touchdowns = touchdowns;
    }

	public void setSacks(BigDecimal sacks) {
    	this.sacks = sacks;
    }

	public void setInterceptions(BigDecimal interceptions) {
    	this.interceptions = interceptions;
    }

	public void setFumblesRecovered(BigDecimal fumblesRecovered) {
    	this.fumblesRecovered = fumblesRecovered;
    }

	public void setSafeties(BigDecimal safeties) {
    	this.safeties = safeties;
    }


	public void setPointsAllowed(BigDecimal pointsAllowed) {
		this.pointsAllowed = pointsAllowed;
	}
}
