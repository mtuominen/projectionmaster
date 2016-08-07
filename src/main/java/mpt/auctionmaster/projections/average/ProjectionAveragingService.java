package mpt.auctionmaster.projections.average;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mpt.auctionmaster.enums.Statistic;
import mpt.auctionmaster.players.BigDecimalStatisticGetter;
import mpt.auctionmaster.players.BigDecimalStatisticSetter;
import mpt.auctionmaster.players.Player;
import mpt.auctionmaster.players.PlayerIDGetterStrategy;
import mpt.auctionmaster.players.StatisticEnumToBigDecimalStatisticGetter;
import mpt.auctionmaster.players.StatisticEnumToBigDecimalStatisticSetterFactory;
import mpt.auctionmaster.players.stats.build.PlayerBuilder;

/**
 * Created by UTUOMMA on 8/19/2015.
 */
public class ProjectionAveragingService {

	private static final StatisticEnumToBigDecimalStatisticSetterFactory statisticToFactory = new StatisticEnumToBigDecimalStatisticSetterFactory();
	private static final StatisticEnumToBigDecimalStatisticGetter statisticEnumToStatisticGetter = new StatisticEnumToBigDecimalStatisticGetter();

	private ProjectionAveragingService() {

	}

	public static List<Player> getWeightedAverages(
		List<Player> projection1,
		List<Player> projection2,
		BigDecimal weight1,
		BigDecimal weight2,
		PlayerIDGetterStrategy playerIDGetterStrategy
	) {
		final Map<String, Player> idToPlayerMap = convertToMap(projection2, playerIDGetterStrategy);
		final List<Player> playerToReturn = new ArrayList<>();
		for (final Player firstProjectedPlayer : projection1) {
			final String playerID = playerIDGetterStrategy.getID(firstProjectedPlayer);
			final Player secondProjectedPlayer = idToPlayerMap.get(playerID);
			if (secondProjectedPlayer != null) {
				final Player averagedPlayer = averagePlayer(firstProjectedPlayer, secondProjectedPlayer, weight1, weight2);
				playerToReturn.add(averagedPlayer);
			} else {
				System.out.println("Could not retrieve player - " + playerID);
			}
		}

		return playerToReturn;
	}

	private static Player averagePlayer(Player firstProjectedPlayer,
		Player secondProjectedPlayer,
		BigDecimal weight1,
		BigDecimal weight2
	) {
		final PlayerBuilder playerBuilder = new PlayerBuilder();
		playerBuilder.setPlayerFields(firstProjectedPlayer);
		final List<Statistic> averagableStatistics = Statistic.getAverageableStatistics();

		for (final Statistic currentStatistic : averagableStatistics) {
			final BigDecimalStatisticSetter setter = statisticToFactory.getSetter(currentStatistic).create(playerBuilder);
			final BigDecimalStatisticGetter getter = statisticEnumToStatisticGetter.getGetter(currentStatistic);
			setter.set(
				weightedAverageValues(
					getter.get(firstProjectedPlayer),
					getter.get(secondProjectedPlayer),
					weight1,
					weight2
				)
			);
		}
		return playerBuilder.build();
	}

	private static BigDecimal weightedAverageValues(
		BigDecimal value1,
		BigDecimal value2,
		BigDecimal weight1,
		BigDecimal weight2
	) {
		if (value1 != null && value2 != null) {
			final BigDecimal first = value1.multiply(weight1);
			final BigDecimal second = value2.multiply(weight2);
			return first.add(second);
		} else {
			return new BigDecimal(0);
		}
	}

	private static Map<String, Player> convertToMap(List<Player> players, PlayerIDGetterStrategy playerIDGetterStrategy) {
		final Map<String, Player> idToPlayer = new HashMap<>();
		for (final Player currentPlayer : players) {
			final String playerID = playerIDGetterStrategy.getID(currentPlayer);
			if (idToPlayer.containsKey(playerID)) {
				throw new IllegalStateException("Duplicate player - " + playerID);
			}
			idToPlayer.put(playerID, currentPlayer);
		}
		return idToPlayer;
	}
}
