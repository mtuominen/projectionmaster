/**
 * 
 */
package mpt.auctionmaster.players.stats;

import java.math.BigDecimal;

/**
 * @author Matthew Tuominen
 *
 */
public final class TeamDefenseStats {
	
	private final BigDecimal touchdowns;
	
	private final BigDecimal sacks;
	
	private final BigDecimal interceptions;
	
	private final BigDecimal fumblesRecovered;
	
	private final BigDecimal safeties;

	private final BigDecimal pointsAllowed;

	/**
     * @param touchdowns
     * @param sacks
     * @param interceptions
     * @param fumblesRecovered
     * @param safeties
	 * @param pointsAllowed
     */
    public TeamDefenseStats(BigDecimal touchdowns, BigDecimal sacks,
            BigDecimal interceptions, BigDecimal fumblesRecovered,
            BigDecimal safeties, BigDecimal pointsAllowed) {
	    this.touchdowns = touchdowns;
	    this.sacks = sacks;
	    this.interceptions = interceptions;
	    this.fumblesRecovered = fumblesRecovered;
	    this.safeties = safeties;
		this.pointsAllowed = pointsAllowed;
    }

	public BigDecimal getTouchdowns() {
    	return touchdowns;
    }

	public BigDecimal getSacks() {
    	return sacks;
    }

	public BigDecimal getInterceptions() {
    	return interceptions;
    }

	public BigDecimal getFumblesRecovered() {
    	return fumblesRecovered;
    }

	public BigDecimal getSafeties() {
    	return safeties;
    }

	public BigDecimal getPointsAllowed() { return pointsAllowed; }
	
	public boolean isEmpty() {
		return null == touchdowns 
				&& null == sacks 
				&& null == interceptions 
				&& null == fumblesRecovered 
				&& null == safeties
				&& null == pointsAllowed;
	}

}
