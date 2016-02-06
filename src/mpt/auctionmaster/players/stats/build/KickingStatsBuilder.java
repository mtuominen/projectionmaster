package mpt.auctionmaster.players.stats.build;

import java.math.BigDecimal;

import mpt.auctionmaster.players.stats.KickingStats;

public class KickingStatsBuilder {
	
	private BigDecimal madeFieldGoals;
	
	private BigDecimal missedFieldGoals;
	
	private BigDecimal fortiesFieldGoals;
	
	private BigDecimal fiftyPlusFieldGoals;
	
	private BigDecimal madeExtraPoints;
	
	private BigDecimal missedExtraPoints;
	
	public KickingStatsBuilder() {}

	/**
     * @param madeFieldGoals
     * @param missedFieldGoals
     * @param fortiesFieldGoals
     * @param fiftyPlusFieldGoals
     * @param madeExtraPoints
     * @param missedExtraPoints
     */
    public KickingStatsBuilder(BigDecimal madeFieldGoals,
            BigDecimal missedFieldGoals, BigDecimal fortiesFieldGoals,
            BigDecimal fiftyPlusFieldGoals, BigDecimal madeExtraPoints,
            BigDecimal missedExtraPoints) {
	    this.madeFieldGoals = madeFieldGoals;
	    this.missedFieldGoals = missedFieldGoals;
	    this.fortiesFieldGoals = fortiesFieldGoals;
	    this.fiftyPlusFieldGoals = fiftyPlusFieldGoals;
	    this.madeExtraPoints = madeExtraPoints;
	    this.missedExtraPoints = missedExtraPoints;
    }
    
    public KickingStats build() {
    	return new KickingStats(madeFieldGoals,
                missedFieldGoals, fortiesFieldGoals,
                fiftyPlusFieldGoals, madeExtraPoints,
                missedExtraPoints);
    }

    public void setMadeFieldGoals(BigDecimal madeFieldGoals) {
    	this.madeFieldGoals = madeFieldGoals;
    }

    public void setMissedFieldGoals(BigDecimal missedFieldGoals) {
    	this.missedFieldGoals = missedFieldGoals;
    }

    public void setFortiesFieldGoals(BigDecimal fortiesFieldGoals) {
    	this.fortiesFieldGoals = fortiesFieldGoals;
    }

    public void setFiftyPlusFieldGoals(BigDecimal fiftyPlusFieldGoals) {
    	this.fiftyPlusFieldGoals = fiftyPlusFieldGoals;
    }

    public void setMadeExtraPoints(BigDecimal madeExtraPoints) {
    	this.madeExtraPoints = madeExtraPoints;
    }

    public void setMissedExtraPoints(BigDecimal missedExtraPoints) {
    	this.missedExtraPoints = missedExtraPoints;
    }


	BigDecimal getMadeFieldGoals() {
		return madeFieldGoals;
	}


	BigDecimal getMadeExtraPoints() {
		return madeExtraPoints;
	}
}
