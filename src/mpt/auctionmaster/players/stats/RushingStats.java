/**
 * 
 */
package mpt.auctionmaster.players.stats;

import java.math.BigDecimal;

/**
 * @author Matthew Tuominen
 *
 */
public final class RushingStats {
	
	private final BigDecimal rushingCarries;
	
	private final BigDecimal rushingYards;
	
	private final BigDecimal rushingTouchdowns;

	private final BigDecimal fumbles;

	/**
     * @param rushingCarries
     * @param rushingYards
     * @param rushingTouchdowns
     */
    public RushingStats(
		BigDecimal rushingCarries,
		BigDecimal rushingYards,
        BigDecimal rushingTouchdowns,
		BigDecimal fumbles
	) {
	    this.rushingCarries = rushingCarries;
	    this.rushingYards = rushingYards;
	    this.rushingTouchdowns = rushingTouchdowns;
		this.fumbles = fumbles;
    }

	public BigDecimal getRushingCarries() {
    	return rushingCarries;
    }

	public BigDecimal getRushingYards() {
    	return rushingYards;
    }

	public BigDecimal getRushingTouchdowns() {
    	return rushingTouchdowns;
    }


	public BigDecimal getFumbles() {
		return fumbles;
	}


	public boolean isEmpty() {
		return null == rushingCarries 
				&& null == rushingYards 
				&& null == rushingTouchdowns
				&& null == fumbles;
	}

}
