package mpt.auctionmaster.breakdown;

import mpt.auctionmaster.enums.Position;

public class PositionRankBreakdownBuilder {
	
	private Position position;
	
	private int rank;
	
	private int min;
	
	private int trend;
	
	private int max;
	
	PositionRankBreakdownBuilder() {
		
	}
	
	PositionRankBreakdown build() {
    	return new PositionRankBreakdown(position,
    			rank, min,
    			trend, max);
    }

	public void setPosition(Position position) {
    	this.position = position;
    }

	public void setRank(int rank) {
    	this.rank = rank;
    }

	public void setMin(int min) {
    	this.min = min;
    }

	public void setTrend(int trend) {
    	this.trend = trend;
    }

	public void setMax(int max) {
    	this.max = max;
    }
}
