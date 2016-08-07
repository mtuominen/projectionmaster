package mpt.auctionmaster.players;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Map;

import mpt.auctionmaster.enums.Statistic;
import mpt.auctionmaster.players.stats.build.PlayerBuilder;

/**
 * Created by UTUOMMA on 8/21/2015.
 */
public class StatisticEnumToBigDecimalStatisticSetterFactory {
	
	private final Map<Statistic, BigDecimalStatisticSetterFactory> statisticToStatisticSetterFactory = new EnumMap<>(Statistic.class);

	public StatisticEnumToBigDecimalStatisticSetterFactory() {
		statisticToStatisticSetterFactory.put(Statistic.GAMESPLAYED, new GamesPlayedSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.PASSATTEMPTS, new PassingAttemptsSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.PASSCOMPLETIONS, new PassingCompletionsSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.PASSYARDS, new PassingYardsSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.PASSTOUCHDOWNS, new PassingTouchdownsSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.PASSINTERCEPTIONS, new PassingInterceptionsSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.RUSHCARRIES, new RushingCarriesSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.RUSHYARDS, new RushingYardsSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.RUSHTOUCHDOWNS, new RushingTouchdownsSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.FUMBLES, new FumblesSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.RECEPTIONS, new ReceptionsSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.RECEIVINGYARDS, new ReceivingYardsSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.RECEIVINGTOUCHDOWNS, new ReceivingTouchdownsSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.KICKRETURNTOUCHDOWNS, new KickReturnTouchdownsSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.PUNTRETURNTOUCHDOWNS, new PuntReturnTouchdownsSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.MADEFIELDGOALS, new MadeFieldGoalsSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.MISSEDFIELDGOALS, new MissedFieldGoalsSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.FORTIESFIELDGOALS, new FortiesFieldGoalsSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.FIFTYPLUSFIELDGOALS, new FiftyPlusFieldGoalsSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.MADEEXTRAPOINTS, new MadeExtraPointsSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.MISSEDEXTRAPOINTS, new MissedExtraPointsSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.TOUCHDOWNS, new DefensiveTouchdownsSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.SACKS, new DefensiveSacksSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.INTERCEPTIONS, new DefensiveInterceptionsSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.FUMBLESRECOVERED, new DefensiveFumblesRecoveredSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.SAFETIES, new DefensiveSafetiesSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.POINTSALLOWED, new DefensivePointAllowedSetterFactory());

	}
	
	public BigDecimalStatisticSetterFactory getSetter(Statistic statisticEnum) {
		return statisticToStatisticSetterFactory.get(statisticEnum);
	}

	private static class GamesPlayedSetterFactory implements BigDecimalStatisticSetterFactory {

		@Override
		public BigDecimalStatisticSetter create(final PlayerBuilder player) {
			return new BigDecimalStatisticSetter() {
				@Override
				public PlayerBuilder set(BigDecimal value) {
					player.setGamesPlayed(value);
					return player;
				}

			};
		}

	}

	private static class PassingAttemptsSetterFactory implements BigDecimalStatisticSetterFactory {

		@Override
		public BigDecimalStatisticSetter create(final PlayerBuilder player) {
			return new BigDecimalStatisticSetter() {
				@Override
				public PlayerBuilder set(BigDecimal value) {
					player.getPassingStats().setPassingAttempts(value);
					return player;
				}

			};
		}

	}

	private static class PassingCompletionsSetterFactory implements BigDecimalStatisticSetterFactory {

		@Override
		public BigDecimalStatisticSetter create(final PlayerBuilder player) {
			return new BigDecimalStatisticSetter() {
				@Override
				public PlayerBuilder set(BigDecimal value) {
					player.getPassingStats().setPassingCompletions(value);
					return player;
				}

			};
		}

	}

	private static class PassingYardsSetterFactory implements BigDecimalStatisticSetterFactory {

		@Override
		public BigDecimalStatisticSetter create(final PlayerBuilder player) {
			return new BigDecimalStatisticSetter() {
				@Override
				public PlayerBuilder set(BigDecimal value) {
					player.getPassingStats().setPassingYards(value);
					return player;
				}

			};
		}

	}

	private static class PassingTouchdownsSetterFactory implements BigDecimalStatisticSetterFactory {

		@Override
		public BigDecimalStatisticSetter create(final PlayerBuilder player) {
			return new BigDecimalStatisticSetter() {
				@Override
				public PlayerBuilder set(BigDecimal value) {
					player.getPassingStats().setPassingTouchdowns(value);
					return player;
				}

			};
		}

	}

	private static class PassingInterceptionsSetterFactory implements BigDecimalStatisticSetterFactory {

		@Override
		public BigDecimalStatisticSetter create(final PlayerBuilder player) {
			return new BigDecimalStatisticSetter() {
				@Override
				public PlayerBuilder set(BigDecimal value) {
					player.getPassingStats().setPassingInterceptions(value);
					return player;
				}

			};
		}

	}

	private static class RushingCarriesSetterFactory implements BigDecimalStatisticSetterFactory {

		@Override
		public BigDecimalStatisticSetter create(final PlayerBuilder player) {
			return new BigDecimalStatisticSetter() {
				@Override
				public PlayerBuilder set(BigDecimal value) {
					player.getRushingStats().setRushingCarries(value);
					return player;
				}

			};
		}

	}

	private static class RushingYardsSetterFactory implements BigDecimalStatisticSetterFactory {

		@Override
		public BigDecimalStatisticSetter create(final PlayerBuilder player) {
			return new BigDecimalStatisticSetter() {
				@Override
				public PlayerBuilder set(BigDecimal value) {
					player.getRushingStats().setRushingYards(value);
					return player;
				}

			};
		}

	}

	private static class RushingTouchdownsSetterFactory implements BigDecimalStatisticSetterFactory {

		@Override
		public BigDecimalStatisticSetter create(final PlayerBuilder player) {
			return new BigDecimalStatisticSetter() {
				@Override
				public PlayerBuilder set(BigDecimal value) {
					player.getRushingStats().setRushingTouchdowns(value);
					return player;
				}

			};
		}

	}

	private static class FumblesSetterFactory implements BigDecimalStatisticSetterFactory {

		@Override
		public BigDecimalStatisticSetter create(final PlayerBuilder player) {
			return new BigDecimalStatisticSetter() {
				@Override
				public PlayerBuilder set(BigDecimal value) {
					player.getRushingStats().setFumbles(value);
					return player;
				}

			};
		}

	}

	private static class ReceptionsSetterFactory implements BigDecimalStatisticSetterFactory {

		@Override
		public BigDecimalStatisticSetter create(final PlayerBuilder player) {
			return new BigDecimalStatisticSetter() {
				@Override
				public PlayerBuilder set(BigDecimal value) {
					player.getReceivingStats().setReceptions(value);
					return player;
				}

			};
		}

	}

	private static class ReceivingYardsSetterFactory implements BigDecimalStatisticSetterFactory {

		@Override
		public BigDecimalStatisticSetter create(final PlayerBuilder player) {
			return new BigDecimalStatisticSetter() {
				@Override
				public PlayerBuilder set(BigDecimal value) {
					player.getReceivingStats().setReceivingYards(value);
					return player;
				}

			};
		}

	}

	private static class ReceivingTouchdownsSetterFactory implements BigDecimalStatisticSetterFactory {

		@Override
		public BigDecimalStatisticSetter create(final PlayerBuilder player) {
			return new BigDecimalStatisticSetter() {
				@Override
				public PlayerBuilder set(BigDecimal value) {
					player.getReceivingStats().setReceivingTouchdowns(value);
					return player;
				}

			};
		}

	}

	private static class KickReturnTouchdownsSetterFactory implements BigDecimalStatisticSetterFactory {

		@Override
		public BigDecimalStatisticSetter create(final PlayerBuilder player) {
			return new BigDecimalStatisticSetter() {
				@Override
				public PlayerBuilder set(BigDecimal value) {
					player.getReturningStats().setKickReturnTouchdowns(value);
					return player;
				}

			};
		}

	}

	private static class PuntReturnTouchdownsSetterFactory implements BigDecimalStatisticSetterFactory {

		@Override
		public BigDecimalStatisticSetter create(final PlayerBuilder player) {
			return new BigDecimalStatisticSetter() {
				@Override
				public PlayerBuilder set(BigDecimal value) {
					player.getReturningStats().setPuntReturnTouchdowns(value);
					return player;
				}

			};
		}

	}

	private static class MadeFieldGoalsSetterFactory implements BigDecimalStatisticSetterFactory {

		@Override
		public BigDecimalStatisticSetter create(final PlayerBuilder player) {
			return new BigDecimalStatisticSetter() {
				@Override
				public PlayerBuilder set(BigDecimal value) {
					player.getKickingStats().setMadeFieldGoals(value);
					return player;
				}

			};
		}

	}

	private static class MissedFieldGoalsSetterFactory implements BigDecimalStatisticSetterFactory {

		@Override
		public BigDecimalStatisticSetter create(final PlayerBuilder player) {
			return new BigDecimalStatisticSetter() {
				@Override
				public PlayerBuilder set(BigDecimal value) {
					player.getKickingStats().setMissedFieldGoals(value);
					return player;
				}

			};
		}

	}

	private static class FortiesFieldGoalsSetterFactory implements BigDecimalStatisticSetterFactory {

		@Override
		public BigDecimalStatisticSetter create(final PlayerBuilder player) {
			return new BigDecimalStatisticSetter() {
				@Override
				public PlayerBuilder set(BigDecimal value) {
					player.getKickingStats().setFortiesFieldGoals(value);
					return player;
				}

			};
		}

	}

	private static class FiftyPlusFieldGoalsSetterFactory implements BigDecimalStatisticSetterFactory {

		@Override
		public BigDecimalStatisticSetter create(final PlayerBuilder player) {
			return new BigDecimalStatisticSetter() {
				@Override
				public PlayerBuilder set(BigDecimal value) {
					player.getKickingStats().setFiftyPlusFieldGoals(value);
					return player;
				}

			};
		}

	}

	private static class MadeExtraPointsSetterFactory implements BigDecimalStatisticSetterFactory {

		@Override
		public BigDecimalStatisticSetter create(final PlayerBuilder player) {
			return new BigDecimalStatisticSetter() {
				@Override
				public PlayerBuilder set(BigDecimal value) {
					player.getKickingStats().setMadeExtraPoints(value);
					return player;
				}

			};
		}

	}

	private static class MissedExtraPointsSetterFactory implements BigDecimalStatisticSetterFactory {

		@Override
		public BigDecimalStatisticSetter create(final PlayerBuilder player) {
			return new BigDecimalStatisticSetter() {
				@Override
				public PlayerBuilder set(BigDecimal value) {
					player.getKickingStats().setMissedExtraPoints(value);
					return player;
				}

			};
		}

	}

	private static class DefensiveTouchdownsSetterFactory implements BigDecimalStatisticSetterFactory {

		@Override
		public BigDecimalStatisticSetter create(final PlayerBuilder player) {
			return new BigDecimalStatisticSetter() {
				@Override
				public PlayerBuilder set(BigDecimal value) {
					player.getTeamDefenseStats().setTouchdowns(value);
					return player;
				}

			};
		}

	}

	private static class DefensiveSacksSetterFactory implements BigDecimalStatisticSetterFactory {

		@Override
		public BigDecimalStatisticSetter create(final PlayerBuilder player) {
			return new BigDecimalStatisticSetter() {
				@Override
				public PlayerBuilder set(BigDecimal value) {
					player.getTeamDefenseStats().setSacks(value);
					return player;
				}

			};
		}

	}

	private static class DefensiveInterceptionsSetterFactory implements BigDecimalStatisticSetterFactory {

		@Override
		public BigDecimalStatisticSetter create(final PlayerBuilder player) {
			return new BigDecimalStatisticSetter() {
				@Override
				public PlayerBuilder set(BigDecimal value) {
					player.getTeamDefenseStats().setInterceptions(value);
					return player;
				}

			};
		}

	}

	private static class DefensiveFumblesRecoveredSetterFactory implements BigDecimalStatisticSetterFactory {

		@Override
		public BigDecimalStatisticSetter create(final PlayerBuilder player) {
			return new BigDecimalStatisticSetter() {
				@Override
				public PlayerBuilder set(BigDecimal value) {
					player.getTeamDefenseStats().setFumblesRecovered(value);
					return player;
				}

			};
		}

	}


	private static class DefensiveSafetiesSetterFactory implements BigDecimalStatisticSetterFactory {

		@Override
		public BigDecimalStatisticSetter create(final PlayerBuilder player) {
			return new BigDecimalStatisticSetter() {
				@Override
				public PlayerBuilder set(BigDecimal value) {
					player.getTeamDefenseStats().setSafeties(value);
					return player;
				}

			};
		}

	}

	private static class DefensivePointAllowedSetterFactory implements BigDecimalStatisticSetterFactory {

		@Override
		public BigDecimalStatisticSetter create(final PlayerBuilder player) {
			return new BigDecimalStatisticSetter() {
				@Override
				public PlayerBuilder set(BigDecimal value) {
					player.getTeamDefenseStats().setPointsAllowed(value);
					return player;
				}

			};
		}

	}

}
