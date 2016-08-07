/**
 * 
 */
package mpt.auctionmaster.players.stats;

import java.math.BigDecimal;

/**
 * @author Matthew Tuominen
 *
 */
public final class PassingStats {

	private final BigDecimal passingAttempts;
	
	private final BigDecimal passingCompletions;
	
	private final BigDecimal passingYards;
	
	private final BigDecimal passingTouchdowns;
	
	private final BigDecimal passingInterceptions;

	/**
     * @param passingAttempts
     * @param passingCompletions
     * @param passingYards
     * @param passingTouchdowns
     * @param passingInterceptions
     */
    public PassingStats(BigDecimal passingAttempts, BigDecimal passingCompletions,
			BigDecimal passingYards, BigDecimal passingTouchdowns,
            BigDecimal passingInterceptions) {
	    this.passingAttempts = passingAttempts;
	    this.passingCompletions = passingCompletions;
	    this.passingYards = passingYards;
	    this.passingTouchdowns = passingTouchdowns;
	    this.passingInterceptions = passingInterceptions;
    }

	public BigDecimal getPassingAttempts() {
    	return passingAttempts;
    }

	public BigDecimal getPassingCompletions() {
    	return passingCompletions;
    }

	public BigDecimal getPassingYards() {
    	return passingYards;
    }

	public BigDecimal getPassingTouchdowns() {
    	return passingTouchdowns;
    }

	public BigDecimal getPassingInterceptions() {
    	return passingInterceptions;
    }
	
	public boolean isEmpty() {
		return null == passingAttempts 
				&& null == passingCompletions 
				&& null == passingYards 
				&& null == passingTouchdowns 
				&& null == passingInterceptions;
	}

}
