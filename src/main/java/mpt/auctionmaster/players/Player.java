/**
 * 
 */
package mpt.auctionmaster.players;

import java.math.BigDecimal;

import mpt.auctionmaster.enums.Position;
import mpt.auctionmaster.enums.Team;
import mpt.auctionmaster.players.stats.KickingStats;
import mpt.auctionmaster.players.stats.PassingStats;
import mpt.auctionmaster.players.stats.ReceivingStats;
import mpt.auctionmaster.players.stats.ReturningStats;
import mpt.auctionmaster.players.stats.RushingStats;
import mpt.auctionmaster.players.stats.TeamDefenseStats;

/**
 * @author Matthew Tuominen
 *
 */
public final class Player implements Comparable<Player> {

	private final String playerID;

	private final Integer positionRank;

	private final String name;

	private final String firstName;

	private final String lastName;

	private final Team team;

	private final Integer byeWeek;

	private final Position position;

	private final BigDecimal gamesPlayed;

	private BigDecimal averageFantasyPoints;

	private BigDecimal totalFantasyPoints;

	private BigDecimal afpVBD;

	private BigDecimal tfpVBD;

	private BigDecimal dollarValue;

	private final PassingStats passingStatistics;

	private final RushingStats rushingStatistics;

	private final ReceivingStats receivingStatistics;

	private final ReturningStats returningStats;

	private final KickingStats kickingStatistics;

	private final TeamDefenseStats defenseStatistics;


	/**
	 * @param playerID
	 * @param positionRank
	 * @param name
	 * @param team
	 * @param byeWeek
	 * @param position
	 * @param gamesPlayed
	 * @param averageFantasyPoints
	 * @param totalFantasyPoints
	 * @param afpVBD
	 * @param tfpVBD
	 * @param dollarValue
	 * @param passingStatistics
	 * @param rushingStatistics
	 * @param receivingStatistics
	 * @param returningStats
	 * @param kickingStatistics
	 * @param defenseStatistics
	 */
	public Player(
		String playerID, Integer positionRank, String name, String firstName,
		String lastName, Team team, Integer byeWeek, Position position,
		BigDecimal gamesPlayed, BigDecimal averageFantasyPoints,
		BigDecimal totalFantasyPoints, BigDecimal afpVBD,
		BigDecimal tfpVBD, BigDecimal dollarValue,
		PassingStats passingStatistics, RushingStats rushingStatistics,
		ReceivingStats receivingStatistics, ReturningStats returningStats,
		KickingStats kickingStatistics, TeamDefenseStats defenseStatistics
	) {
		this.playerID = playerID;
		this.positionRank = positionRank;
		this.name = name;
		this.firstName = firstName;
		this.lastName = lastName;
		this.team = team;
		this.byeWeek = byeWeek;
		this.position = position;
		this.gamesPlayed = gamesPlayed;
		this.averageFantasyPoints = averageFantasyPoints;
		this.totalFantasyPoints = totalFantasyPoints;
		this.afpVBD = afpVBD;
		this.tfpVBD = tfpVBD;
		this.dollarValue = dollarValue;
		this.passingStatistics = passingStatistics;
		this.rushingStatistics = rushingStatistics;
		this.receivingStatistics = receivingStatistics;
		this.returningStats = returningStats;
		this.kickingStatistics = kickingStatistics;
		this.defenseStatistics = defenseStatistics;
	}


	public String getID() {
		return playerID;
	}


	public Integer getPositionRank() {
		return positionRank;
	}


	public String getName() {
		if (null == name && firstName != null && lastName != null) {
			return firstName + " " + lastName;
		} else {
			return name;
		}

	}


	public String getFirstName() {
		return firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public Team getTeam() {
		return team;
	}


	public Integer getByeWeek() {
		return byeWeek;
	}


	public Position getPosition() {
		return position;
	}


	public BigDecimal getGamesPlayed() {
		return gamesPlayed;
	}


	public BigDecimal getAverageFantasyPoints() {
		return averageFantasyPoints;
	}


	public BigDecimal getTotalFantasyPoints() {
		return totalFantasyPoints;
	}


	public BigDecimal getAfpVBD() {
		return afpVBD;
	}


	public BigDecimal getTfpVBD() {
		return tfpVBD;
	}


	public BigDecimal getDollarValue() {
		return dollarValue;
	}


	public PassingStats getPassingStatistics() {
		return passingStatistics;
	}


	public RushingStats getRushStatistics() {
		return rushingStatistics;
	}


	public ReceivingStats getReceivingStatistics() {
		return receivingStatistics;
	}


	public ReturningStats getReturningStats() {
		return returningStats;
	}


	public KickingStats getKickingStatistics() {
		return kickingStatistics;
	}


	public TeamDefenseStats getDefenseStatistics() {
		return defenseStatistics;
	}


	@Override
	public int compareTo(Player otherPlayer) {
		return otherPlayer.totalFantasyPoints.compareTo(totalFantasyPoints);
	}


	public void setTotalFantasyPoints(BigDecimal totalFantasyPoints) {
		this.totalFantasyPoints = totalFantasyPoints;
	}


	public void setTfpVBD(BigDecimal tfpVBD) {
		this.tfpVBD = tfpVBD;
	}


	public void setDollarValue(BigDecimal dollarValue) {
		this.dollarValue = dollarValue;
	}
}