package mpt.auctionmaster.value;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mpt.auctionmaster.enums.Position;
import mpt.auctionmaster.players.Player;
import mpt.auctionmaster.util.RoundingUtil;

public class MultipleBaselineAlgorithm implements AuctionAlgorithm {
	
	private Map<Position, List<Player>> initPlayerMap = new HashMap<Position, List<Player>>();
	
	private MultipleBaselineConfiguration baselineConfiguration;
	
	private Map<Position, Map<BaseLineType, BigDecimal>> positionToBaseline = new EnumMap<Position, Map<BaseLineType, BigDecimal>>(Position.class);
	
	private Map<Position, BigDecimal> positionToPositionVBDPool = new EnumMap<Position, BigDecimal>(Position.class);
	
	public MultipleBaselineAlgorithm(
			Map<Position, List<Player>> initPlayerMap, 
			MultipleBaselineConfiguration baselineConfiguration
	) {
		this.initPlayerMap.putAll(initPlayerMap);
		sortPlayers(this.initPlayerMap);
		this.baselineConfiguration = baselineConfiguration;
		
		determineBaselines();
		initVBD();
	}
	
	private final void determineBaselines() {
		for (Position currentPosition : initPlayerMap.keySet()) {
			System.out.println("MultipleBaselineAlgorithm.determineBaselines - Position: " + currentPosition.name());
			final List<Player> players = initPlayerMap.get(currentPosition);
			
			final Map<BaseLineType, Integer> baselines = baselineConfiguration.getBaselines(currentPosition);
			final Map<BaseLineType, BigDecimal> pointsBaseline = new HashMap<BaseLineType, BigDecimal>();
			for (BaseLineType currentType : BaseLineType.values()) {
				final Integer index = baselines.get(currentType);
				final BigDecimal baselinePoints = players.get(index.intValue() - 1).getTotalFantasyPoints();
				
				pointsBaseline.put(currentType, baselinePoints);
			}
			positionToBaseline.put(currentPosition, pointsBaseline);
		}
	}
	
	private void initVBD() {
		for (Position currentPosition : initPlayerMap.keySet()) {
			final Map<BaseLineType, BigDecimal> baselines = positionToBaseline.get(currentPosition);
			final List<Player> players = initPlayerMap.get(currentPosition);
			for (Player currentPlayer : players) {
				System.out.println("MultipleBaselineAlgorithm.initVBD - Player: " + currentPlayer.getName());
				final BigDecimal vbd = getVBD(currentPlayer, baselines);
				currentPlayer.setTfpVBD(vbd);
				currentPlayer.setDollarValue(new BigDecimal(0));
			}
		}
	}
	
	private BigDecimal getVBD(Player currentPlayer, Map<BaseLineType, BigDecimal> baselines) {
		BigDecimal totalVBD = new BigDecimal(0);
		final BigDecimal playerPoints = currentPlayer.getTotalFantasyPoints();
		System.out.println("MultipleBaselineAlgorithm.getVBD - Total Fantasy Points: " + playerPoints.toPlainString());
		for (BaseLineType baseline : baselines.keySet()) {
			final BigDecimal baselinePoints = baselines.get(baseline);
			if (playerPoints.compareTo(baselinePoints) > 0) {
				final BigDecimal baselineVBD = playerPoints.subtract(baselinePoints);
				totalVBD = totalVBD.add(baselineVBD);
				System.out.println("MultipleBaselineAlgorithm.getVBD - Baseline: " + baselinePoints.toPlainString());
				System.out.println("MultipleBaselineAlgorithm.getVBD - VBD: " + totalVBD.toPlainString());
			}
		}
		return totalVBD;
	}

	@Override
	public void populateAuctionValues(
	        Map<Position, List<Player>> playerMap,
	        AuctionAlgorithmConfiguration configuration
	) {
		sortPlayers(playerMap);
		BigDecimal totalPoolVBD = getRemainingVBDPool(playerMap);
		BigDecimal unallocatedDollars = configuration.getUnallocatedDollars();
		resetDollarValues(playerMap);
		for (Position currentPosition : playerMap.keySet()) {
			BigDecimal positionDollarsAvailable = getDollarsRelativeToUnallocatedDollars(totalPoolVBD, unallocatedDollars, positionToPositionVBDPool.get(currentPosition));
			
			final List<Player> players = playerMap.get(currentPosition);
			final int playersToBeAuctioned = configuration.getNumberOfPlayersToBeAuctioned(currentPosition);
			int oneDollarPlayersToBeAuctioned = configuration.getNumberOfOneDollarPlayersTobeAuctioned(currentPosition);
			while (oneDollarPlayersToBeAuctioned > 0) {
				final Player currentPlayer = players.get(playersToBeAuctioned - oneDollarPlayersToBeAuctioned);
				currentPlayer.setDollarValue(new BigDecimal(1));
				oneDollarPlayersToBeAuctioned--;
			}
			Player lastPlayer = null;
			for (Player currentPlayer : players) {
				System.out.println("MultipleBaselineAlgorithm.populateAuctionValues - Player: " + currentPlayer.getName());
				if (positionToPositionVBDPool.get(currentPosition).intValue() > 0
						&& currentPlayer.getTfpVBD().doubleValue() > 0) {
					final BigDecimal dollarsAboveBaseline = getDollarsRelativeToUnallocatedDollars(positionToPositionVBDPool.get(currentPosition), positionDollarsAvailable, currentPlayer.getTfpVBD());
					long dollarValue = round(dollarsAboveBaseline.add(new BigDecimal("1.5")));
					if (null != lastPlayer && lastPlayer.getDollarValue().longValue() < dollarValue) {
						dollarValue -= 1;
					}
					positionDollarsAvailable = positionDollarsAvailable.subtract(new BigDecimal(dollarValue).subtract(new BigDecimal("1.5")));
					
					currentPlayer.setDollarValue(new BigDecimal(dollarValue));
					lastPlayer = currentPlayer;
				} else {
					currentPlayer.setDollarValue(new BigDecimal(0));
				}
			}
		}
	}
	
	private BigDecimal getRemainingVBDPool(Map<Position, List<Player>> playerMap) {
		positionToPositionVBDPool.clear();
		BigDecimal totalPoolVBD = new BigDecimal(0);
		for (Position currentPosition : playerMap.keySet()) {
			BigDecimal positionPoolVBD = new BigDecimal(0);
			final List<Player> players = playerMap.get(currentPosition);
			for (Player currentPlayer : players) {
				final BigDecimal vbd = currentPlayer.getTfpVBD();
				positionPoolVBD = positionPoolVBD.add(vbd);
			}
			//Log.v("MultipleBaselineAlgorithm.getRemainingVBDPool", "position: " + currentPosition.name());
			//Log.v("MultipleBaselineAlgorithm.getRemainingVBDPool", "positionPoolVBD: " + positionPoolVBD.toPlainString());
			positionToPositionVBDPool.put(currentPosition, positionPoolVBD);
			totalPoolVBD = totalPoolVBD.add(positionPoolVBD);
			//Log.v("MultipleBaselineAlgorithm.getRemainingVBDPool", "totalPoolVBD: " + totalPoolVBD.toPlainString());
		}
		
		return totalPoolVBD;
	}
	
	private void resetDollarValues(Map<Position, List<Player>> playerMap) {
		for (Position currentPosition : playerMap.keySet()) {
			final List<Player> players = playerMap.get(currentPosition);
			for (Player currentPlayer : players) {
				currentPlayer.setDollarValue(new BigDecimal(0));
			}
		}
	}
	
	private BigDecimal getDollarsRelativeToUnallocatedDollars(BigDecimal totalPoolVBD, BigDecimal unallocatedDollars, BigDecimal vbd) {
		System.out.println("MultipleBaselineAlgorithm.getDollarsRelativeToUnallocatedDollars - totalPoolVBD: " + totalPoolVBD.toPlainString());
		System.out.println("MultipleBaselineAlgorithm.getDollarsRelativeToUnallocatedDollars - vbd: " + vbd.toPlainString());
		final BigDecimal vbdPercentage = vbd.divide(totalPoolVBD, 10, RoundingMode.HALF_UP);
		System.out.println("MultipleBaselineAlgorithm.getDollarsRelativeToUnallocatedDollars - vbd %: " + vbdPercentage.toPlainString());
		System.out.println("MultipleBaselineAlgorithm.getDollarsRelativeToUnallocatedDollars - unallocated: " + unallocatedDollars.toPlainString());
		return vbdPercentage.multiply(unallocatedDollars);
	}
	
	private long round(BigDecimal bigDecimal) {
		return RoundingUtil.round(bigDecimal).longValue();
	}
	
	private void sortPlayers(Map<Position, List<Player>> playerMap) {
		for (Position currentPosition : playerMap.keySet()) {
			final List<Player> players = playerMap.get(currentPosition);
			Collections.sort(players);
		}
	}
	
	

}
