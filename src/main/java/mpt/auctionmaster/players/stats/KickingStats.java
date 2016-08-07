/**
 * 
 */
package mpt.auctionmaster.players.stats;

import java.math.BigDecimal;


/**
 * @author Matthew Tuominen
 *
 */
public final class KickingStats  {

	private final BigDecimal madeFieldGoals;
	
	private final BigDecimal missedFieldGoals;
	
	private final BigDecimal fortiesFieldGoals;
	
	private final BigDecimal fiftyPlusFieldGoals;
	
	private final BigDecimal madeExtraPoints;
	
	private final BigDecimal missedExtraPoints;

	/**
     * @param madeFieldGoals
     * @param missedFieldGoals
     * @param fortiesFieldGoals
     * @param fiftyPlusFieldGoals
     * @param madeExtraPoints
     * @param missedExtraPoints
     */
    public KickingStats(BigDecimal madeFieldGoals, BigDecimal missedFieldGoals,
            BigDecimal fortiesFieldGoals, BigDecimal fiftyPlusFieldGoals,
            BigDecimal madeExtraPoints, BigDecimal missedExtraPoints) {
	    this.madeFieldGoals = madeFieldGoals;
	    this.missedFieldGoals = missedFieldGoals;
	    this.fortiesFieldGoals = fortiesFieldGoals;
	    this.fiftyPlusFieldGoals = fiftyPlusFieldGoals;
	    this.madeExtraPoints = madeExtraPoints;
	    this.missedExtraPoints = missedExtraPoints;
    }

	public BigDecimal getMadeFieldGoals() {
    	return madeFieldGoals;
    }

	public BigDecimal getMissedFieldGoals() {
    	return missedFieldGoals;
    }

	public BigDecimal getFortiesFieldGoals() {
    	return fortiesFieldGoals;
    }

	public BigDecimal getFiftyPlusFieldGoals() {
    	return fiftyPlusFieldGoals;
    }

	public BigDecimal getMadeExtraPoints() {
    	return madeExtraPoints;
    }

	public BigDecimal getMissedExtraPoints() {
    	return missedExtraPoints;
    }
	
	public boolean isEmpty() {
		return null == madeFieldGoals 
				&& null == missedFieldGoals 
				&& null == fortiesFieldGoals 
				&& null == fiftyPlusFieldGoals 
				&& null == madeExtraPoints
				&& null == missedExtraPoints;
	}
	
}
