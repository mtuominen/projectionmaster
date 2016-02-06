package mpt.auctionmaster.breakdown;

import java.util.Map;

import mpt.auctionmaster.enums.Position;

public final class PositionBreakdown {
	
	private final Position position;
	
	private final Map<Integer, PositionRankBreakdown> rankToBreakdown;

	/**
     * @param position
     * @param rankToBreakdown
     */
    public PositionBreakdown(Position position,
            Map<Integer, PositionRankBreakdown> rankToBreakdown) {
	    this.position = position;
	    this.rankToBreakdown = rankToBreakdown;
    }

	public Position getPosition() {
    	return position;
    }

	public Map<Integer, PositionRankBreakdown> getRankToBreakdown() {
    	return rankToBreakdown;
    }
	
	public PositionRankBreakdown getRankBreakdown(Integer rank) {
		return rankToBreakdown.get(rank);
	}

}
