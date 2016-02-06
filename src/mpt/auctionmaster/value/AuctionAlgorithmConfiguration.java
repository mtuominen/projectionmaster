package mpt.auctionmaster.value;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Map;

import mpt.auctionmaster.enums.Position;

public final class AuctionAlgorithmConfiguration {
	
	private final int remainingBudget; 
	
	private final Map<Position, Integer> numberOfPlayersToBeAuctioned;
	
	private final Map<Position, Integer> numberOfOneDollarPlayersTobeAuctioned;
	
	public AuctionAlgorithmConfiguration() { 
		this.remainingBudget = 1200;
		
		this.numberOfPlayersToBeAuctioned = new EnumMap<Position, Integer>(Position.class);
		numberOfPlayersToBeAuctioned.put(Position.QUARTERBACK, new Integer(25));
		numberOfPlayersToBeAuctioned.put(Position.RUNNINGBACK, new Integer(63));
		numberOfPlayersToBeAuctioned.put(Position.WIDERECEIVER, new Integer(53));
		numberOfPlayersToBeAuctioned.put(Position.TIGHTEND, new Integer(13));
		numberOfPlayersToBeAuctioned.put(Position.PLACEKICKER, new Integer(13));
		numberOfPlayersToBeAuctioned.put(Position.TEAMDEFENSE, new Integer(13));
		
		this.numberOfOneDollarPlayersTobeAuctioned = new EnumMap<Position, Integer>(Position.class);
		numberOfOneDollarPlayersTobeAuctioned.put(Position.QUARTERBACK, new Integer(5));
		numberOfOneDollarPlayersTobeAuctioned.put(Position.RUNNINGBACK, new Integer(12));
		numberOfOneDollarPlayersTobeAuctioned.put(Position.WIDERECEIVER, new Integer(12));
		numberOfOneDollarPlayersTobeAuctioned.put(Position.TIGHTEND, new Integer(3));
		numberOfOneDollarPlayersTobeAuctioned.put(Position.PLACEKICKER, new Integer(9));
		numberOfOneDollarPlayersTobeAuctioned.put(Position.TEAMDEFENSE, new Integer(4));
	}
	
	public AuctionAlgorithmConfiguration(
			int remainingBudget, 
		Map<Position, Integer> numberOfPlayersToBeAuctioned, 
		Map<Position, Integer> numberOfOneDollarPlayersTobeAuctioned
	) { 
		this.remainingBudget = remainingBudget;
		this.numberOfPlayersToBeAuctioned = numberOfPlayersToBeAuctioned;
		this.numberOfOneDollarPlayersTobeAuctioned = numberOfOneDollarPlayersTobeAuctioned;
	}
	
	public int getRemainingBudget() {
		return remainingBudget;
	}
	
	public int getNumberOfPlayersToBeAuctioned(Position position) {
		return numberOfPlayersToBeAuctioned.get(position).intValue();
	}
	
	public int getNumberOfOneDollarPlayersTobeAuctioned(Position position) {
		return numberOfOneDollarPlayersTobeAuctioned.get(position).intValue();
	}
	
	public int getOneDollarPlayerCount() {
		int playerCount = 0;
		for (Position currentPosition : numberOfOneDollarPlayersTobeAuctioned.keySet()) {
			playerCount += numberOfOneDollarPlayersTobeAuctioned.get(currentPosition).intValue();
		}
		return playerCount;
	}
	
	public int getPlayerCount() {
		int playerCount = 0;
		for (Position currentPosition : numberOfPlayersToBeAuctioned.keySet()) {
			playerCount += numberOfPlayersToBeAuctioned.get(currentPosition).intValue();
		}
		return playerCount;
	}
	
	public BigDecimal getUnallocatedDollars() {
		final int budgetMinusOneDollarPlayers = remainingBudget - getOneDollarPlayerCount();
		final int onePointFivePlayers = getPlayerCount() - getOneDollarPlayerCount();
		final BigDecimal onePointFivePlayerBudget = new BigDecimal("" + onePointFivePlayers).multiply(new BigDecimal("1.5"));
		return new BigDecimal(budgetMinusOneDollarPlayers).subtract(onePointFivePlayerBudget);
	}

}
