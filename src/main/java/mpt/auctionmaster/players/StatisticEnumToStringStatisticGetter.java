package mpt.auctionmaster.players;

import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import mpt.auctionmaster.enums.Statistic;

/**
 * Created by UTUOMMA on 8/24/2015.
 */
@Component
public class StatisticEnumToStringStatisticGetter {
	
	private final Map<Statistic, StringStatisticGetter> statisticToStatisticGetter = new EnumMap<>(Statistic.class);
	
	public StatisticEnumToStringStatisticGetter() {
		statisticToStatisticGetter.put(Statistic.IDENTIFIER, new IdentifierGetter());
		statisticToStatisticGetter.put(Statistic.RANK, new PositionRankGetter());
		statisticToStatisticGetter.put(Statistic.NAME, new NameGetter());
		statisticToStatisticGetter.put(Statistic.FIRSTNAME, new FirstNameGetter());
		statisticToStatisticGetter.put(Statistic.LASTNAME, new LastNameGetter());
		statisticToStatisticGetter.put(Statistic.TEAM, new TeamGetter());
		statisticToStatisticGetter.put(Statistic.POSITION, new PositionGetter());
		statisticToStatisticGetter.put(Statistic.BYEWEEK, new ByeWeekGetter());
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
		statisticToStatisticGetter.put(Statistic.POINTSALLOWED, new DefensivePointAllowedSetterFactor());

	}
	
	public StringStatisticGetter getGetter(Statistic statisticEnum) {
		return statisticToStatisticGetter.get(statisticEnum);
	}
	
	private static class IdentifierGetter implements StringStatisticGetter {
		
		@Override
		public String get(Player player) {
			return player.getID();
		}
	}
	
	private static class PositionRankGetter implements StringStatisticGetter {
			
		@Override
		public String get(Player player) {
			return String.valueOf(player.getPositionRank());
		}
	}
	
	private static class NameGetter implements StringStatisticGetter {
		
		@Override
		public String get(Player player) {
			return player.getName();
		}
	}
	
	private static class FirstNameGetter implements StringStatisticGetter {
			
		@Override
		public String get(Player player) {
			return player.getFirstName();
		}
	}
	
	private static class LastNameGetter implements StringStatisticGetter {
		
		@Override
		public String get(Player player) {
			return player.getLastName();
		}
	}
	
	private static class TeamGetter implements StringStatisticGetter {

		@Override
		public String get(Player player) {
			return player.getTeam().name();
		}
	}
	
	private static class PositionGetter implements StringStatisticGetter {
		
		@Override
		public String get(Player player) {
			return player.getPosition().getAbbreviation();
		}
	}
	
	private static class ByeWeekGetter implements StringStatisticGetter {
			
		@Override
		public String get(Player player) {
			return String.valueOf(player.getByeWeek());
		}
	}
	
	private static class GamesPlayedGetter implements StringStatisticGetter {
		
		@Override
		public String get(Player player) {
			return String.valueOf(player.getGamesPlayed());
		}
	}
	
	private static class PassingAttemptsGetter implements StringStatisticGetter {
			
		@Override
		public String get(Player player) {
			return player.getPassingStatistics().getPassingAttempts().setScale(0, RoundingMode.HALF_UP).toPlainString();
		}
	}

	private static class PassingCompletionsGetter implements StringStatisticGetter {

		@Override
		public String get(Player player) {
			return player.getPassingStatistics().getPassingCompletions().setScale(0, RoundingMode.HALF_UP).toPlainString();
		}
	}

	private static class PassingYardsGetter implements StringStatisticGetter {

		@Override
		public String get(Player player) {
			return player.getPassingStatistics().getPassingYards().setScale(0, RoundingMode.HALF_UP).toPlainString();
		}
	}

	private static class PassingTouchdownsGetter implements StringStatisticGetter {

		@Override
		public String get(Player player) {
			return player.getPassingStatistics().getPassingTouchdowns().setScale(1, RoundingMode.HALF_UP).toPlainString();
		}
	}

	private static class PassingInterceptionsGetter implements StringStatisticGetter {

		@Override
		public String get(Player player) {
			return player.getPassingStatistics().getPassingInterceptions().setScale(1, RoundingMode.HALF_UP).toPlainString();
		}
	}

	private static class RushingCarriesGetter implements StringStatisticGetter {

		@Override
		public String get(Player player) {
			return player.getRushStatistics().getRushingCarries().setScale(0, RoundingMode.HALF_UP).toPlainString();
		}
	}

	private static class RushingYardsGetter implements StringStatisticGetter {

		@Override
		public String get(Player player) {
			return player.getRushStatistics().getRushingYards().setScale(0, RoundingMode.HALF_UP).toPlainString();
		}
	}

	private static class RushingTouchdownsGetter implements StringStatisticGetter {

		@Override
		public String get(Player player) {
			return player.getRushStatistics().getRushingTouchdowns().setScale(1, RoundingMode.HALF_UP).toPlainString();
		}
	}

	private static class FumblesGetter implements StringStatisticGetter {

		@Override
		public String get(Player player) {
			return player.getRushStatistics().getFumbles().setScale(1, RoundingMode.HALF_UP).toPlainString();
		}
	}

	private static class ReceptionsGetter implements StringStatisticGetter {

		@Override
		public String get(Player player) {
			return player.getReceivingStatistics().getReceptions().setScale(1, RoundingMode.HALF_UP).toPlainString();
		}
	}

	private static class ReceivingYardsGetter implements StringStatisticGetter {

		@Override
		public String get(Player player) {
			return player.getReceivingStatistics().getReceivingYards().setScale(0, RoundingMode.HALF_UP).toPlainString();
		}
	}

	private static class ReceivingTouchdownsGetter implements StringStatisticGetter {

		@Override
		public String get(Player player) {
			return player.getReceivingStatistics().getReceivingTouchdowns().setScale(1, RoundingMode.HALF_UP).toPlainString();
		}
	}

	private static class KickReturnTouchdownsGetter implements StringStatisticGetter {

		@Override
		public String get(Player player) {
			return player.getReturningStats().getKickReturnTouchdowns().setScale(1, RoundingMode.HALF_UP).toPlainString();
		}
	}

	private static class PuntReturnTouchdownsGetter implements StringStatisticGetter {

		@Override
		public String get(Player player) {
			return player.getReturningStats().getPuntReturnTouchdowns().setScale(1, RoundingMode.HALF_UP).toPlainString();
		}
	}

	private static class MadeFieldGoalsGetter implements StringStatisticGetter {

		@Override
		public String get(Player player) {
			return player.getKickingStatistics().getMadeFieldGoals().setScale(1, RoundingMode.HALF_UP).toPlainString();
		}
	}

	private static class MissedFieldGoalsGetter implements StringStatisticGetter {

		@Override
		public String get(Player player) {
			return player.getKickingStatistics().getMissedFieldGoals().setScale(1, RoundingMode.HALF_UP).toPlainString();
		}
	}

	private static class FortiesFieldGoalsGetter implements StringStatisticGetter {

		@Override
		public String get(Player player) {
			return player.getKickingStatistics().getFortiesFieldGoals().setScale(1, RoundingMode.HALF_UP).toPlainString();
		}
	}

	private static class FiftyPlusFieldGoalsGetter implements StringStatisticGetter {

		@Override
		public String get(Player player) {
			return player.getKickingStatistics().getFiftyPlusFieldGoals().setScale(1, RoundingMode.HALF_UP).toPlainString();
		}
	}

	private static class MadeExtraPointsGetter implements StringStatisticGetter {

		@Override
		public String get(Player player) {
			return player.getKickingStatistics().getMadeExtraPoints().setScale(1, RoundingMode.HALF_UP).toPlainString();
		}
	}

	private static class MissedExtraPointsGetter implements StringStatisticGetter {

		@Override
		public String get(Player player) {
			return player.getKickingStatistics().getMissedExtraPoints().setScale(1, RoundingMode.HALF_UP).toPlainString();
		}
	}

	private static class DefensiveTouchdownsGetter implements StringStatisticGetter {

		@Override
		public String get(Player player) {
			return player.getDefenseStatistics().getTouchdowns().setScale(1, RoundingMode.HALF_UP).toPlainString();
		}
	}

	private static class DefensiveSacksGetter implements StringStatisticGetter {

		@Override
		public String get(Player player) {
			return player.getDefenseStatistics().getSacks().setScale(1, RoundingMode.HALF_UP).toPlainString();
		}
	}

	private static class DefensiveInterceptionsGetter implements StringStatisticGetter {

		@Override
		public String get(Player player) {
			return player.getDefenseStatistics().getInterceptions().setScale(1, RoundingMode.HALF_UP).toPlainString();
		}
	}

	private static class DefensiveFumblesRecoveredGetter implements StringStatisticGetter {

		@Override
		public String get(Player player) {
			return player.getDefenseStatistics().getFumblesRecovered().setScale(1, RoundingMode.HALF_UP).toPlainString();
		}
	}

	private static class DefensiveSafetiesGetter implements StringStatisticGetter {

		@Override
		public String get(Player player) {
			return player.getDefenseStatistics().getSafeties().setScale(1, RoundingMode.HALF_UP).toPlainString();
		}
	}

	private static class DefensivePointAllowedSetterFactor implements StringStatisticGetter {

		@Override
		public String get(Player player) {
			return player.getDefenseStatistics().getPointsAllowed().setScale(0, RoundingMode.HALF_UP).toPlainString();
		}
	}


}
