package mpt.auctionmaster.players;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Map;

import mpt.auctionmaster.enums.Statistic;

/**
 * Created by UTUOMMA on 8/21/2015.
 */
public class StatisticEnumToBigDecimalStatisticGetter {

	private final Map<Statistic, BigDecimalStatisticGetter> statisticToStatisticGetter = new EnumMap<>(Statistic.class);

	public StatisticEnumToBigDecimalStatisticGetter() {
		statisticToStatisticGetter.put(Statistic.GAMESPLAYED, new GamesPlayedGetter());
		statisticToStatisticGetter.put(Statistic.PASSATTEMPTS, new PassingAttemptsGetter());
		statisticToStatisticGetter.put(Statistic.PASSCOMPLETIONS, new PassingCompletionsGetter());
		statisticToStatisticGetter.put(Statistic.PASSYARDS, new PassingYardsGetter());
		statisticToStatisticGetter.put(Statistic.PASSTOUCHDOWNS, new PassingTouchdownsGetter());
		statisticToStatisticGetter.put(Statistic.PASSINTERCEPTIONS, new PassingInterceptionsGetter());
		statisticToStatisticGetter.put(Statistic.RUSHCARRIES, new RushingCarriesGetter());
		statisticToStatisticGetter.put(Statistic.RUSHYARDS, new RushingYardsGetter());
		statisticToStatisticGetter.put(Statistic.RUSHTOUCHDOWNS, new RushingTouchdownsGetter());
		statisticToStatisticGetter.put(Statistic.FUMBLES, new FumblesGetter());
		statisticToStatisticGetter.put(Statistic.RECEPTIONS, new ReceptionsGetter());
		statisticToStatisticGetter.put(Statistic.RECEIVINGYARDS, new ReceivingYardsGetter());
		statisticToStatisticGetter.put(Statistic.RECEIVINGTOUCHDOWNS, new ReceivingTouchdownsGetter());
		statisticToStatisticGetter.put(Statistic.KICKRETURNTOUCHDOWNS, new KickReturnTouchdownsGetter());
		statisticToStatisticGetter.put(Statistic.PUNTRETURNTOUCHDOWNS, new PuntReturnTouchdownsGetter());
		statisticToStatisticGetter.put(Statistic.MADEFIELDGOALS, new MadeFieldGoalsGetter());
		statisticToStatisticGetter.put(Statistic.MISSEDFIELDGOALS, new MissedFieldGoalsGetter());
		statisticToStatisticGetter.put(Statistic.FORTIESFIELDGOALS, new FortiesFieldGoalsGetter());
		statisticToStatisticGetter.put(Statistic.FIFTYPLUSFIELDGOALS, new FiftyPlusFieldGoalsGetter());
		statisticToStatisticGetter.put(Statistic.MADEEXTRAPOINTS, new MadeExtraPointsGetter());
		statisticToStatisticGetter.put(Statistic.MISSEDEXTRAPOINTS, new MissedExtraPointsGetter());
		statisticToStatisticGetter.put(Statistic.TOUCHDOWNS, new DefensiveTouchdownsGetter());
		statisticToStatisticGetter.put(Statistic.SACKS, new DefensiveSacksGetter());
		statisticToStatisticGetter.put(Statistic.INTERCEPTIONS, new DefensiveInterceptionsGetter());
		statisticToStatisticGetter.put(Statistic.FUMBLESRECOVERED, new DefensiveFumblesRecoveredGetter());
		statisticToStatisticGetter.put(Statistic.SAFETIES, new DefensiveSafetiesGetter());
		statisticToStatisticGetter.put(Statistic.POINTSALLOWED, new DefensivePointAllowedGetter());

	}
	
	public BigDecimalStatisticGetter getGetter(Statistic statisticEnum) {
		return statisticToStatisticGetter.get(statisticEnum);
	}

	private static class GamesPlayedGetter implements BigDecimalStatisticGetter {
		
		@Override
		public BigDecimal get(Player player) {
			return player.getGamesPlayed();
		}
	}
	
	private static class PassingAttemptsGetter implements BigDecimalStatisticGetter {
			
		@Override
		public BigDecimal get(Player player) {
			return player.getPassingStatistics().getPassingAttempts();
		}
	}

	private static class PassingCompletionsGetter implements BigDecimalStatisticGetter {

		@Override
		public BigDecimal get(Player player) {
			return player.getPassingStatistics().getPassingCompletions();
		}
	}

	private static class PassingYardsGetter implements BigDecimalStatisticGetter {

		@Override
		public BigDecimal get(Player player) {
			return player.getPassingStatistics().getPassingYards();
		}
	}

	private static class PassingTouchdownsGetter implements BigDecimalStatisticGetter {

		@Override
		public BigDecimal get(Player player) {
			return player.getPassingStatistics().getPassingTouchdowns();
		}
	}

	private static class PassingInterceptionsGetter implements BigDecimalStatisticGetter {

		@Override
		public BigDecimal get(Player player) {
			return player.getPassingStatistics().getPassingInterceptions();
		}
	}

	private static class RushingCarriesGetter implements BigDecimalStatisticGetter {

		@Override
		public BigDecimal get(Player player) {
			return player.getRushStatistics().getRushingCarries();
		}
	}

	private static class RushingYardsGetter implements BigDecimalStatisticGetter {

		@Override
		public BigDecimal get(Player player) {
			return player.getRushStatistics().getRushingYards();
		}
	}

	private static class RushingTouchdownsGetter implements BigDecimalStatisticGetter {

		@Override
		public BigDecimal get(Player player) {
			return player.getRushStatistics().getRushingTouchdowns();
		}
	}

	private static class FumblesGetter implements BigDecimalStatisticGetter {

		@Override
		public BigDecimal get(Player player) {
			return player.getRushStatistics().getFumbles();
		}
	}

	private static class ReceptionsGetter implements BigDecimalStatisticGetter {

		@Override
		public BigDecimal get(Player player) {
			return player.getReceivingStatistics().getReceptions();
		}
	}

	private static class ReceivingYardsGetter implements BigDecimalStatisticGetter {

		@Override
		public BigDecimal get(Player player) {
			return player.getReceivingStatistics().getReceivingYards();
		}
	}

	private static class ReceivingTouchdownsGetter implements BigDecimalStatisticGetter {

		@Override
		public BigDecimal get(Player player) {
			return player.getReceivingStatistics().getReceivingTouchdowns();
		}
	}

	private static class KickReturnTouchdownsGetter implements BigDecimalStatisticGetter {

		@Override
		public BigDecimal get(Player player) {
			return player.getReturningStats().getKickReturnTouchdowns();
		}
	}

	private static class PuntReturnTouchdownsGetter implements BigDecimalStatisticGetter {

		@Override
		public BigDecimal get(Player player) {
			return player.getReturningStats().getPuntReturnTouchdowns();
		}
	}

	private static class MadeFieldGoalsGetter implements BigDecimalStatisticGetter {

		@Override
		public BigDecimal get(Player player) {
			return player.getKickingStatistics().getMadeFieldGoals();
		}
	}

	private static class MissedFieldGoalsGetter implements BigDecimalStatisticGetter {

		@Override
		public BigDecimal get(Player player) {
			return player.getKickingStatistics().getMissedFieldGoals();
		}
	}

	private static class FortiesFieldGoalsGetter implements BigDecimalStatisticGetter {

		@Override
		public BigDecimal get(Player player) {
			return player.getKickingStatistics().getFortiesFieldGoals();
		}
	}

	private static class FiftyPlusFieldGoalsGetter implements BigDecimalStatisticGetter {

		@Override
		public BigDecimal get(Player player) {
			return player.getKickingStatistics().getFiftyPlusFieldGoals();
		}
	}

	private static class MadeExtraPointsGetter implements BigDecimalStatisticGetter {

		@Override
		public BigDecimal get(Player player) {
			return player.getKickingStatistics().getMadeExtraPoints();
		}
	}

	private static class MissedExtraPointsGetter implements BigDecimalStatisticGetter {

		@Override
		public BigDecimal get(Player player) {
			return player.getKickingStatistics().getMissedExtraPoints();
		}
	}

	private static class DefensiveTouchdownsGetter implements BigDecimalStatisticGetter {

		@Override
		public BigDecimal get(Player player) {
			return player.getDefenseStatistics().getTouchdowns();
		}
	}

	private static class DefensiveSacksGetter implements BigDecimalStatisticGetter {

		@Override
		public BigDecimal get(Player player) {
			return player.getDefenseStatistics().getSacks();
		}
	}

	private static class DefensiveInterceptionsGetter implements BigDecimalStatisticGetter {

		@Override
		public BigDecimal get(Player player) {
			return player.getDefenseStatistics().getInterceptions();
		}
	}

	private static class DefensiveFumblesRecoveredGetter implements BigDecimalStatisticGetter {

		@Override
		public BigDecimal get(Player player) {
			return player.getDefenseStatistics().getFumblesRecovered();
		}
	}

	private static class DefensiveSafetiesGetter implements BigDecimalStatisticGetter {

		@Override
		public BigDecimal get(Player player) {
			return player.getDefenseStatistics().getSafeties();
		}
	}

	private static class DefensivePointAllowedGetter implements BigDecimalStatisticGetter {

		@Override
		public BigDecimal get(Player player) {
			return player.getDefenseStatistics().getPointsAllowed();
		}
	}

}
