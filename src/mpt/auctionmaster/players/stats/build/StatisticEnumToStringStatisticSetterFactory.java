package mpt.auctionmaster.players.stats.build;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.Map;

import mpt.auctionmaster.enums.Position;
import mpt.auctionmaster.enums.Statistic;
import mpt.auctionmaster.enums.Team;
import mpt.auctionmaster.properties.PropertyManager;

public class StatisticEnumToStringStatisticSetterFactory {

	private final Map<Statistic, StringStatisticSetterFactory> statisticToStatisticSetterFactory = new EnumMap<>(Statistic.class);
	
	public StatisticEnumToStringStatisticSetterFactory(PropertyManager propertyManager) {

		statisticToStatisticSetterFactory.put(Statistic.IDENTIFIER, new IdentifierSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.RANK, new PositionRankSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.NAME, new NameSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.FIRSTNAME, new FirstNameSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.LASTNAME, new LastNameSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.TEAM, new TeamSetterFactory(propertyManager));
		statisticToStatisticSetterFactory.put(Statistic.POSITION, new PositionSetterFactory(propertyManager));
		statisticToStatisticSetterFactory.put(Statistic.BYEWEEK, new ByeWeekSetterFactory());
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
		statisticToStatisticSetterFactory.put(Statistic.ATTEMPTEDFIELDGOALS, new AttemptedFieldGoalsSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.FORTIESFIELDGOALS, new FortiesFieldGoalsSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.FIFTYPLUSFIELDGOALS, new FiftyPlusFieldGoalsSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.MADEEXTRAPOINTS, new MadeExtraPointsSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.MISSEDEXTRAPOINTS, new MissedExtraPointsSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.ATTEMPTEDEXTRAPOINTS, new AttemptedExtraPointsSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.TOUCHDOWNS, new DefensiveTouchdownsSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.SACKS, new DefensiveSacksSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.INTERCEPTIONS, new DefensiveInterceptionsSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.FUMBLESRECOVERED, new DefensiveFumblesRecoveredSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.SAFETIES, new DefensiveSafetiesSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.POINTSALLOWED, new DefensivePointAllowedSetterFactor());
		statisticToStatisticSetterFactory.put(Statistic.AVERAGEFANTASYPOINTS, new AverageFantasyPointsSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.TOTALFANTASYPOINTS, new TotalFantasyPointsSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.AVERAGEFANTASYPOINT_VBD, new AverageFantasyPointsVBDSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.TOTALFANTASYPOINTS_VBD, new TotalFantasyPointsVBDSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.DOLLAR_VALUE, new DollarValueSetterFactory());
		statisticToStatisticSetterFactory.put(Statistic.UNUSED, new UnusedSetterFactory());

	}
	
	public StringStatisticSetterFactory getFactory(Statistic statisticEnum) {
		return statisticToStatisticSetterFactory.get(statisticEnum);
	}

	private static class IdentifierSetterFactory implements StringStatisticSetterFactory {

		@Override
		public StringStatisticSetter create(final PlayerBuilder player) {
			return new StringStatisticSetter() {
				@Override
				public PlayerBuilder set(String value) {
					player.setPlayerID(value);
					return player;
				}

			};
		}

	}


	private static class PositionRankSetterFactory implements StringStatisticSetterFactory {

		@Override
        public StringStatisticSetter create(final PlayerBuilder player) {
	        return new StringStatisticSetter() {
				@Override
                public PlayerBuilder set(String value) {
					System.out.println("PositionRankSetterFactory - value=" + value);
					final StringBuilder numberBuilder = new StringBuilder();
					for (int i = 0; i < value.length(); i++) {
						if (Character.isDigit(value.charAt(i))) {
							numberBuilder.append(value.charAt(i));
						}
					}
					System.out.println("PositionRankSetterFactory - parsing value=" + numberBuilder.toString());
	                player.setPositionRank(new Integer(numberBuilder.toString()));
	                return player;
                }
	        	
	        };
        }
		
	}
	
	private static class NameSetterFactory implements StringStatisticSetterFactory {

		@Override
        public StringStatisticSetter create(final PlayerBuilder player) {
	        return new StringStatisticSetter() {
				@Override
                public PlayerBuilder set(String value) {
	                player.setName(value);
	                return player;
                }
	        	
	        };
        }
		
	}

	private static class FirstNameSetterFactory implements StringStatisticSetterFactory {

		@Override
		public StringStatisticSetter create(final PlayerBuilder player) {
			return new StringStatisticSetter() {
				@Override
				public PlayerBuilder set(String value) {
					player.setFirstName(value);
					return player;
				}

			};
		}

	}

	private static class LastNameSetterFactory implements StringStatisticSetterFactory {

		@Override
		public StringStatisticSetter create(final PlayerBuilder player) {
			return new StringStatisticSetter() {
				@Override
				public PlayerBuilder set(String value) {
					player.setLastName(value);
					return player;
				}

			};
		}

	}
	
	private static class TeamSetterFactory implements StringStatisticSetterFactory {
		
		private PropertyManager propertyManager;
		
		public TeamSetterFactory(PropertyManager propertyManager) {
			this.propertyManager = propertyManager;
		}

		@Override
        public StringStatisticSetter create(final PlayerBuilder player) {
	        return new StringStatisticSetter() {
				@Override
                public PlayerBuilder set(String value) {
					try {
						final Team team = propertyManager.getTeamProperties().get(value);
		                player.setTeam(team);
		                final Integer byeWeek = propertyManager.getByeProperties().get(team);
		                player.setByeWeek(byeWeek);
					} catch (Exception e) {
						e.printStackTrace();
					}
	                return player;
                }
	        	
	        };
        }
		
	}
	
	private static class PositionSetterFactory implements StringStatisticSetterFactory {
		
		private PropertyManager propertyManager;
		
		public PositionSetterFactory(PropertyManager propertyManager) {
			this.propertyManager = propertyManager;
		}

		@Override
        public StringStatisticSetter create(final PlayerBuilder player) {
	        return new StringStatisticSetter() {
				@Override
                public PlayerBuilder set(String value) {
					try {
						Position p = propertyManager.getPositionProperties().get(value);
		                player.setPosition(p);
					} catch (Exception e) {
						e.printStackTrace();
					}
	                return player;
                }
	        	
	        };
        }
		
	}
	
	private static class ByeWeekSetterFactory implements StringStatisticSetterFactory {

		@Override
        public StringStatisticSetter create(final PlayerBuilder player) {
	        return new StringStatisticSetter() {
				@Override
                public PlayerBuilder set(String value) {
	                player.setByeWeek(new Integer(value));
	                return player;
                }
	        	
	        };
        }
		
	}
	
	private static class GamesPlayedSetterFactory implements StringStatisticSetterFactory {

		@Override
        public StringStatisticSetter create(final PlayerBuilder player) {
	        return new StringStatisticSetter() {
				@Override
                public PlayerBuilder set(String value) {
	                player.setGamesPlayed(new BigDecimal(value));
	                return player;
                }
	        	
	        };
        }
		
	}
	
	private static class PassingAttemptsSetterFactory implements StringStatisticSetterFactory {

		@Override
        public StringStatisticSetter create(final PlayerBuilder player) {
	        return new StringStatisticSetter() {
				@Override
                public PlayerBuilder set(String value) {
	                player.getPassingStats().setPassingAttempts(new BigDecimal(value));
	                return player;
                }
	        	
	        };
        }
		
	}
	
	private static class PassingCompletionsSetterFactory implements StringStatisticSetterFactory {

		@Override
        public StringStatisticSetter create(final PlayerBuilder player) {
	        return new StringStatisticSetter() {
				@Override
                public PlayerBuilder set(String value) {
	                player.getPassingStats().setPassingCompletions(new BigDecimal(value));
	                return player;
                }
	        	
	        };
        }
		
	}
	
	private static class PassingYardsSetterFactory implements StringStatisticSetterFactory {

		@Override
        public StringStatisticSetter create(final PlayerBuilder player) {
	        return new StringStatisticSetter() {
				@Override
                public PlayerBuilder set(String value) {
	                player.getPassingStats().setPassingYards(new BigDecimal(value.replace(",", "")));
	                return player;
                }
	        	
	        };
        }
		
	}
	
	private static class PassingTouchdownsSetterFactory implements StringStatisticSetterFactory {

		@Override
        public StringStatisticSetter create(final PlayerBuilder player) {
	        return new StringStatisticSetter() {
				@Override
                public PlayerBuilder set(String value) {
	                player.getPassingStats().setPassingTouchdowns(new BigDecimal(value));
	                return player;
                }
	        	
	        };
        }
		
	}
	
	private static class PassingInterceptionsSetterFactory implements StringStatisticSetterFactory {

		@Override
        public StringStatisticSetter create(final PlayerBuilder player) {
	        return new StringStatisticSetter() {
				@Override
                public PlayerBuilder set(String value) {
	                player.getPassingStats().setPassingInterceptions(new BigDecimal(value));
	                return player;
                }
	        	
	        };
        }
		
	}
	
	private static class RushingCarriesSetterFactory implements StringStatisticSetterFactory {

		@Override
        public StringStatisticSetter create(final PlayerBuilder player) {
	        return new StringStatisticSetter() {
				@Override
                public PlayerBuilder set(String value) {
	                player.getRushingStats().setRushingCarries(new BigDecimal(value));
	                return player;
                }
	        	
	        };
        }
		
	}
	
	private static class RushingYardsSetterFactory implements StringStatisticSetterFactory {

		@Override
        public StringStatisticSetter create(final PlayerBuilder player) {
	        return new StringStatisticSetter() {
				@Override
                public PlayerBuilder set(String value) {
	                player.getRushingStats().setRushingYards(new BigDecimal(value.replace(",", "")));
	                return player;
                }
	        	
	        };
        }
		
	}
	
	private static class RushingTouchdownsSetterFactory implements StringStatisticSetterFactory {

		@Override
        public StringStatisticSetter create(final PlayerBuilder player) {
	        return new StringStatisticSetter() {
				@Override
                public PlayerBuilder set(String value) {
	                player.getRushingStats().setRushingTouchdowns(new BigDecimal(value));
	                return player;
                }
	        	
	        };
        }
		
	}

	private static class FumblesSetterFactory implements StringStatisticSetterFactory {

		@Override
		public StringStatisticSetter create(final PlayerBuilder player) {
			return new StringStatisticSetter() {
				@Override
				public PlayerBuilder set(String value) {
					player.getRushingStats().setFumbles(new BigDecimal(value));
					return player;
				}

			};
		}

	}

	
	private static class ReceptionsSetterFactory implements StringStatisticSetterFactory {

		@Override
        public StringStatisticSetter create(final PlayerBuilder player) {
	        return new StringStatisticSetter() {
				@Override
                public PlayerBuilder set(String value) {
	                player.getReceivingStats().setReceptions(new BigDecimal(value));
	                return player;
                }
	        	
	        };
        }
		
	}
	
	private static class ReceivingYardsSetterFactory implements StringStatisticSetterFactory {

		@Override
        public StringStatisticSetter create(final PlayerBuilder player) {
	        return new StringStatisticSetter() {
				@Override
                public PlayerBuilder set(String value) {
	                player.getReceivingStats().setReceivingYards(new BigDecimal(value.replace(",", "")));
	                return player;
                }
	        	
	        };
        }
		
	}
	
	private static class ReceivingTouchdownsSetterFactory implements StringStatisticSetterFactory {

		@Override
        public StringStatisticSetter create(final PlayerBuilder player) {
	        return new StringStatisticSetter() {
				@Override
                public PlayerBuilder set(String value) {
	                player.getReceivingStats().setReceivingTouchdowns(new BigDecimal(value));
	                return player;
                }
	        	
	        };
        }
		
	}

	private static class KickReturnTouchdownsSetterFactory implements StringStatisticSetterFactory {

		@Override
		public StringStatisticSetter create(final PlayerBuilder player) {
			return new StringStatisticSetter() {
				@Override
				public PlayerBuilder set(String value) {
					player.getReturningStats().setKickReturnTouchdowns(new BigDecimal(value));
					return player;
				}

			};
		}

	}

	private static class PuntReturnTouchdownsSetterFactory implements StringStatisticSetterFactory {

		@Override
		public StringStatisticSetter create(final PlayerBuilder player) {
			return new StringStatisticSetter() {
				@Override
				public PlayerBuilder set(String value) {
					player.getReturningStats().setPuntReturnTouchdowns(new BigDecimal(value));
					return player;
				}

			};
		}

	}
	
	private static class MadeFieldGoalsSetterFactory implements StringStatisticSetterFactory {

		@Override
        public StringStatisticSetter create(final PlayerBuilder player) {
	        return new StringStatisticSetter() {
				@Override
                public PlayerBuilder set(String value) {
	                player.getKickingStats().setMadeFieldGoals(new BigDecimal(value));
	                return player;
                }
	        	
	        };
        }
		
	}
	
	private static class MissedFieldGoalsSetterFactory implements StringStatisticSetterFactory {

		@Override
        public StringStatisticSetter create(final PlayerBuilder player) {
	        return new StringStatisticSetter() {
				@Override
                public PlayerBuilder set(String value) {
	                player.getKickingStats().setMissedFieldGoals(new BigDecimal(value));
	                return player;
                }
	        	
	        };
        }
		
	}

	private static class AttemptedFieldGoalsSetterFactory implements StringStatisticSetterFactory {

		@Override
		public StringStatisticSetter create(final PlayerBuilder player) {
			return new StringStatisticSetter() {
				@Override
				public PlayerBuilder set(String value) {
					final BigDecimal madeFieldGoals = new KickingStatsBuilderAccessor(player.getKickingStats()).getMadeFieldGoals();
					player.getKickingStats().setMissedFieldGoals(new BigDecimal(value).subtract(madeFieldGoals));
					return player;
				}

			};
		}

	}
	
	private static class FortiesFieldGoalsSetterFactory implements StringStatisticSetterFactory {

		@Override
        public StringStatisticSetter create(final PlayerBuilder player) {
	        return new StringStatisticSetter() {
				@Override
                public PlayerBuilder set(String value) {
	                player.getKickingStats().setFortiesFieldGoals(new BigDecimal(value));
	                return player;
                }
	        	
	        };
        }
		
	}
	
	private static class FiftyPlusFieldGoalsSetterFactory implements StringStatisticSetterFactory {

		@Override
        public StringStatisticSetter create(final PlayerBuilder player) {
	        return new StringStatisticSetter() {
				@Override
                public PlayerBuilder set(String value) {
	                player.getKickingStats().setFiftyPlusFieldGoals(new BigDecimal(value));
	                return player;
                }
	        	
	        };
        }
		
	}
	
	private static class MadeExtraPointsSetterFactory implements StringStatisticSetterFactory {

		@Override
        public StringStatisticSetter create(final PlayerBuilder player) {
	        return new StringStatisticSetter() {
				@Override
                public PlayerBuilder set(String value) {
	                player.getKickingStats().setMadeExtraPoints(new BigDecimal(value));
	                return player;
                }
	        	
	        };
        }
		
	}
	
	private static class MissedExtraPointsSetterFactory implements StringStatisticSetterFactory {

		@Override
        public StringStatisticSetter create(final PlayerBuilder player) {
	        return new StringStatisticSetter() {
				@Override
                public PlayerBuilder set(String value) {
	                player.getKickingStats().setMissedExtraPoints(new BigDecimal(value));
	                return player;
                }
	        	
	        };
        }
		
	}

	private static class AttemptedExtraPointsSetterFactory implements StringStatisticSetterFactory {

		@Override
		public StringStatisticSetter create(final PlayerBuilder player) {
			return new StringStatisticSetter() {
				@Override
				public PlayerBuilder set(String value) {
					final BigDecimal madeExtraPoints = new KickingStatsBuilderAccessor(player.getKickingStats()).getMadeExtraPoints();
					player.getKickingStats().setMissedExtraPoints(new BigDecimal(value).subtract(madeExtraPoints));
					return player;
				}

			};
		}

	}
	
	private static class DefensiveTouchdownsSetterFactory implements StringStatisticSetterFactory {

		@Override
        public StringStatisticSetter create(final PlayerBuilder player) {
	        return new StringStatisticSetter() {
				@Override
                public PlayerBuilder set(String value) {
	                player.getTeamDefenseStats().setTouchdowns(new BigDecimal(value));
	                return player;
                }
	        	
	        };
        }
		
	}
	
	private static class DefensiveSacksSetterFactory implements StringStatisticSetterFactory {

		@Override
        public StringStatisticSetter create(final PlayerBuilder player) {
	        return new StringStatisticSetter() {
				@Override
                public PlayerBuilder set(String value) {
	                player.getTeamDefenseStats().setSacks(new BigDecimal(value));
	                return player;
                }
	        	
	        };
        }
		
	}
	
	private static class DefensiveInterceptionsSetterFactory implements StringStatisticSetterFactory {

		@Override
        public StringStatisticSetter create(final PlayerBuilder player) {
	        return new StringStatisticSetter() {
				@Override
                public PlayerBuilder set(String value) {
	                player.getTeamDefenseStats().setInterceptions(new BigDecimal(value));
	                return player;
                }
	        	
	        };
        }
		
	}
	
	private static class DefensiveFumblesRecoveredSetterFactory implements StringStatisticSetterFactory {

		@Override
        public StringStatisticSetter create(final PlayerBuilder player) {
	        return new StringStatisticSetter() {
				@Override
                public PlayerBuilder set(String value) {
	                player.getTeamDefenseStats().setFumblesRecovered(new BigDecimal(value));
	                return player;
                }
	        	
	        };
        }
		
	}
	
	private static class DefensiveSafetiesSetterFactory implements StringStatisticSetterFactory {

		@Override
        public StringStatisticSetter create(final PlayerBuilder player) {
	        return new StringStatisticSetter() {
				@Override
                public PlayerBuilder set(String value) {
	                player.getTeamDefenseStats().setSafeties(new BigDecimal(value));
	                return player;
                }
	        	
	        };
        }
		
	}

	private static class DefensivePointAllowedSetterFactor implements StringStatisticSetterFactory {

		@Override
		public StringStatisticSetter create(final PlayerBuilder player) {
			return new StringStatisticSetter() {
				@Override
				public PlayerBuilder set(String value) {
					player.getTeamDefenseStats().setPointsAllowed(new BigDecimal(value));
					return player;
				}

			};
		}

	}
	
	private static class AverageFantasyPointsSetterFactory implements StringStatisticSetterFactory {

		@Override
        public StringStatisticSetter create(final PlayerBuilder player) {
	        return new StringStatisticSetter() {
				@Override
                public PlayerBuilder set(String value) {
	                player.setAverageFantasyPoints(new BigDecimal(value));
	                return player;
                }
	        	
	        };
        }
		
	}
	
	private static class TotalFantasyPointsSetterFactory implements StringStatisticSetterFactory {

		@Override
        public StringStatisticSetter create(final PlayerBuilder player) {
	        return new StringStatisticSetter() {
				@Override
                public PlayerBuilder set(String value) {
	                player.setTotalFantasyPoints(new BigDecimal(value));
	                return player;
                }
	        	
	        };
        }
		
	}
	
	private static class AverageFantasyPointsVBDSetterFactory implements StringStatisticSetterFactory {

		@Override
        public StringStatisticSetter create(final PlayerBuilder player) {
	        return new StringStatisticSetter() {
				@Override
                public PlayerBuilder set(String value) {
	                player.setAfpVBD(new BigDecimal(value));
	                return player;
                }
	        	
	        };
        }
		
	}
	
	private static class TotalFantasyPointsVBDSetterFactory implements StringStatisticSetterFactory {

		@Override
        public StringStatisticSetter create(final PlayerBuilder player) {
	        return new StringStatisticSetter() {
				@Override
                public PlayerBuilder set(String value) {
	                player.setTfpVBD(new BigDecimal(value));
	                return player;
                }
	        	
	        };
        }
		
	}
	
	private static class DollarValueSetterFactory implements StringStatisticSetterFactory {

		@Override
        public StringStatisticSetter create(final PlayerBuilder player) {
	        return new StringStatisticSetter() {
				@Override
                public PlayerBuilder set(String value) {
	                player.setDollarValue(new BigDecimal(value));
	                return player;
                }
	        	
	        };
        }
		
	}
	
	private static class UnusedSetterFactory implements StringStatisticSetterFactory {

		@Override
        public StringStatisticSetter create(final PlayerBuilder player) {
	        return new StringStatisticSetter() {
				@Override
                public PlayerBuilder set(String value) {
					//do nothing
	                return player;
                }
	        	
	        };
        }
		
	}

}
