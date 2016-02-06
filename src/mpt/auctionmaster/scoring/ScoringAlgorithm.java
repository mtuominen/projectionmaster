package mpt.auctionmaster.scoring;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import mpt.auctionmaster.enums.Position;
import mpt.auctionmaster.players.stats.KickingStats;
import mpt.auctionmaster.players.stats.PassingStats;
import mpt.auctionmaster.players.Player;
import mpt.auctionmaster.players.stats.ReceivingStats;
import mpt.auctionmaster.players.stats.RushingStats;
import mpt.auctionmaster.players.stats.TeamDefenseStats;
import mpt.auctionmaster.util.RoundingUtil;

public class ScoringAlgorithm {

	private ScoringConfiguration configuration;
	
	public ScoringAlgorithm(ScoringConfiguration configuration) {
		this.configuration = configuration;
	}
	
	public void scoreAll(Map<Position, List<Player>> playerMap) {
		for (Position currentPosition : playerMap.keySet()) {
			for (Player currentPlayer : playerMap.get(currentPosition)) {
				currentPlayer.setTotalFantasyPoints(getTotalFantasyPoints(currentPlayer));
				System.out.println("ScoringAlgorithm.scoreAll - Player: " + currentPlayer.getName());
				System.out.println("ScoringAlgorithm.scoreAll - Total Fantasy Points: " + currentPlayer.getTotalFantasyPoints());
			}
		}
	}
	
	public BigDecimal getTotalFantasyPoints(Player player) {
		return round(
				getPassingPoints(player)
					.add(getRushPoints(player))
					.add(getReceivingPoints(player))
					.add(getKickingPoints(player))
					.add(getTeamDefensePoints(player))
		);
	}
	
	private BigDecimal getPassingPoints(Player player) {
		final PassingStats stats = player.getPassingStatistics();
		
		if (stats.isEmpty()) {
			return new BigDecimal(0);
		}
		
		final BigDecimal touchdownPoints = round(stats.getPassingTouchdowns().multiply(configuration.getPointsPerPassingTouchdown()));
		final BigDecimal yardPoints = round(new BigDecimal(stats.getPassingYards().intValue()).multiply(configuration.getPointsPerPassingYard()));
		final BigDecimal interceptionPoints = round(stats.getPassingInterceptions().multiply(configuration.getPointsPerPassingInterception()));
		
		return round(
				touchdownPoints
					.add(yardPoints)
					.add(interceptionPoints)
		);
	}
	
	private BigDecimal getRushPoints(Player player) {
		final RushingStats stats = player.getRushStatistics();
		
		if (stats.isEmpty()) {
			return new BigDecimal(0);
		}
		
		final BigDecimal touchdownPoints = round(stats.getRushingTouchdowns().multiply(configuration.getPointsPerRushRecTouchdown()));
		final BigDecimal yardPoints = round(new BigDecimal(stats.getRushingYards().intValue()).multiply(configuration.getPointsPerRushRecYard()));
		
		return round(
				touchdownPoints
					.add(yardPoints)
		);
	}
	
	private BigDecimal getReceivingPoints(Player player) {
		final ReceivingStats stats = player.getReceivingStatistics();
		
		if (stats.isEmpty()) {
			return new BigDecimal(0);
		}
		
		final BigDecimal touchdownPoints = round(stats.getReceivingTouchdowns().multiply(configuration.getPointsPerRushRecTouchdown()));
		final BigDecimal yardPoints = round(new BigDecimal(stats.getReceivingYards().intValue()).multiply(configuration.getPointsPerRushRecYard()));
		final BigDecimal receptionPoints = round(stats.getReceptions().multiply(configuration.getPointsPerReception()));
		
		return round(
				touchdownPoints
					.add(yardPoints)
					.add(receptionPoints)
		);
	}
	
	private BigDecimal getKickingPoints(Player player) {
		final KickingStats stats = player.getKickingStatistics();
		
		if (stats.isEmpty()) {
			return new BigDecimal(0);
		}
		
		final BigDecimal fgPoints = round(stats.getMadeFieldGoals().multiply(configuration.getPointsPerFG()));
		final BigDecimal xpPoints = round(stats.getMadeExtraPoints().multiply(configuration.getPointsPerXP()));
		final BigDecimal fgMissPoints = round(stats.getMissedFieldGoals().multiply(configuration.getPointsPerMissedFG()));
		final BigDecimal xpMissPoints = round(stats.getMissedExtraPoints().multiply(configuration.getPointsPerMissedXP()));
		final BigDecimal fortiesBonusPoints = round(stats.getFortiesFieldGoals().multiply(configuration.getBonusPointsPerFortiesFG()));
		final BigDecimal fiftiesBonusPoints = round(stats.getFiftyPlusFieldGoals().multiply(configuration.getBonusPointsPerFiftyPlusFG()));
		
		return round(
				fgPoints
					.add(xpPoints)
					.add(fgMissPoints)
					.add(xpMissPoints)
					.add(fortiesBonusPoints)
					.add(fiftiesBonusPoints)
		);
	}
	
	private BigDecimal getTeamDefensePoints(Player player) {
		final TeamDefenseStats stats = player.getDefenseStatistics();
		
		if (stats.isEmpty()) {
			return new BigDecimal(0);
		}
		
		final BigDecimal frPoints = round(stats.getFumblesRecovered().multiply(configuration.getPointsPerFumbleRecovered()));
		final BigDecimal intPoints = round(stats.getInterceptions().multiply(configuration.getPointsPerDefensiveInterception()));
		final BigDecimal sackPoints = round(stats.getSacks().multiply(configuration.getPointsPerSack()));
		final BigDecimal safetyPoints = round(stats.getSafeties().multiply(configuration.getPointsPerSafety()));
		final BigDecimal tdPoints = round(stats.getTouchdowns().multiply(configuration.getPointsPerDefensiveTD()));
		
		return round(
				frPoints
					.add(intPoints)
					.add(sackPoints)
					.add(safetyPoints)
					.add(tdPoints)
		);
	}
	
	private BigDecimal round(BigDecimal decimal) {
		return RoundingUtil.round(decimal);
	}
}
