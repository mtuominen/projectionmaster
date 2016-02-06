package mpt.auctionmaster.breakdown;

import mpt.auctionmaster.enums.Position;

public final class PositionRankBreakdown {
	
	private final Position position;
	
	private final int rank;
	
	private final int min;
	
	private final int trend;
	
	private final int max;

	/**
     * @param position
     * @param rank
     * @param min
     * @param trend
     * @param max
     */
    public PositionRankBreakdown(
    		Position position, 
    		int rank, 
    		int min,
            int trend, 
            int max
    ) {
	    this.position = position;
	    this.rank = rank;
	    this.min = min;
	    this.trend = trend;
	    this.max = max;
    }

	public Position getPosition() {
    	return position;
    }

	public int getRank() {
    	return rank;
    }

	public int getMin() {
    	return min;
    }

	public int getTrend() {
    	return trend;
    }

	public int getMax() {
    	return max;
    }
}
