package mpt.auctionmaster.players.stats.build;

import java.math.BigDecimal;

import mpt.auctionmaster.enums.Position;
import mpt.auctionmaster.enums.Team;
import mpt.auctionmaster.players.stats.KickingStats;
import mpt.auctionmaster.players.stats.PassingStats;
import mpt.auctionmaster.players.Player;
import mpt.auctionmaster.players.stats.ReceivingStats;
import mpt.auctionmaster.players.stats.ReturningStats;
import mpt.auctionmaster.players.stats.RushingStats;
import mpt.auctionmaster.players.stats.TeamDefenseStats;

public class PlayerBuilder {
	
	private String playerID;
	
	private Integer positionRank;
	
	private String name;

	private String firstName;

	private String lastName;
	
	private Team team;
	
	private Integer byeWeek;
	
	private Position position;
	
	private BigDecimal gamesPlayed;
	
	private BigDecimal averageFantasyPoints;
	
	private BigDecimal totalFantasyPoints;
	
	private BigDecimal afpVBD;
	
	private BigDecimal tfpVBD;
	
	private BigDecimal dollarValue;
	
	private PassingStatsBuilder passingStats;
	
	private RushingStatsBuilder rushingStats;
	
	private ReceivingStatsBuilder receivingStats;

	private ReturningStatsBuilder returningStats;
	
	private KickingStatsBuilder kickingStats;
	
	private TeamDefenseStatsBuilder teamDefenseStats;
	
	public PlayerBuilder() {}

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
     */
    private PlayerBuilder(String playerID, Integer positionRank, String name, Team team,
    		Integer byeWeek, Position position, BigDecimal gamesPlayed,
            BigDecimal averageFantasyPoints, BigDecimal totalFantasyPoints,
            BigDecimal afpVBD, BigDecimal tfpVBD, BigDecimal dollarValue) {
    	this.playerID = playerID;
	    this.positionRank = positionRank;
	    this.name = name;
	    this.team = team;
	    this.byeWeek = byeWeek;
	    this.position = position;
	    this.gamesPlayed = gamesPlayed;
	    this.averageFantasyPoints = averageFantasyPoints;
	    this.totalFantasyPoints = totalFantasyPoints;
	    this.afpVBD = afpVBD;
	    this.tfpVBD = tfpVBD;
	    this.dollarValue = dollarValue;
    }
    
    public Player build() {
    	return new Player(playerID, positionRank, name, firstName, lastName, team, byeWeek, position,
    			gamesPlayed, averageFantasyPoints, totalFantasyPoints, afpVBD,
    			tfpVBD, dollarValue, getPassingStats().build(), getRushingStats().build(),
    			getReceivingStats().build(), getReturningStats().build(),
				getKickingStats().build(), getTeamDefenseStats().build());
    }
    
    public Player build(PassingStats passingStats, 
    		RushingStats rushingStats, 
    		ReceivingStats receivingStats,
			ReturningStats returningStats,
    		KickingStats kickingStats,
    		TeamDefenseStats teamDefenseStats) {
    	return new Player(playerID, positionRank, name, firstName, lastName, team, byeWeek, position,
    			gamesPlayed, averageFantasyPoints, totalFantasyPoints, afpVBD,
    			tfpVBD, dollarValue, passingStats, rushingStats, receivingStats, 
    			returningStats, kickingStats, teamDefenseStats);
    }

	public void setPlayerFields(Player player) {
		setPlayerID(player.getID());
		setPositionRank(player.getPositionRank());
		setName(player.getName());
		setFirstName(player.getFirstName());
		setLastName(player.getLastName());
		setTeam(player.getTeam());
		setByeWeek(player.getByeWeek());
		setPosition(player.getPosition());
	}

    public void setPlayerID(String playerID) {
    	this.playerID = playerID;
    }
    
    public void setPositionRank(Integer positionRank) {
    	this.positionRank = positionRank;
    }

    public void setName(String name) {
    	this.name = name;
    }


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public void setTeam(Team team) {
		if (null != team) {
			this.team = team;
		} else {
			this.team = Team.FA;
		}
    	
    }

    public void setByeWeek(Integer byeWeek) {
    	this.byeWeek = byeWeek;
    }

    public void setPosition(Position position) {
    	this.position = position;
    }

    public void setGamesPlayed(BigDecimal gamesPlayed) {
    	this.gamesPlayed = gamesPlayed;
    }

    public void setAverageFantasyPoints(BigDecimal averageFantasyPoints) {
    	this.averageFantasyPoints = averageFantasyPoints;
    }

    public void setTotalFantasyPoints(BigDecimal totalFantasyPoints) {
    	this.totalFantasyPoints = totalFantasyPoints;
    }

    public void setAfpVBD(BigDecimal afpVBD) {
    	this.afpVBD = afpVBD;
    }

    public void setTfpVBD(BigDecimal tfpVBD) {
    	this.tfpVBD = tfpVBD;
    }

    public void setDollarValue(BigDecimal dollarValue) {
    	this.dollarValue = dollarValue;
    }

    public PassingStatsBuilder getPassingStats() {
		if (null == passingStats) {
			passingStats = new PassingStatsBuilder();
		}
    	return passingStats;
    }

    public RushingStatsBuilder getRushingStats() {
		if (null == rushingStats) {
			rushingStats = new RushingStatsBuilder();
		}
    	return rushingStats;
    }

    public ReceivingStatsBuilder getReceivingStats() {
		if (null == receivingStats) {
			receivingStats = new ReceivingStatsBuilder();
		}
    	return receivingStats;
    }

	public ReturningStatsBuilder getReturningStats() {
		if (null == returningStats) {
			returningStats = new ReturningStatsBuilder();
		}
    	return returningStats;
    }

    public KickingStatsBuilder getKickingStats() {
		if (null == kickingStats) {
			kickingStats = new KickingStatsBuilder();
		}
    	return kickingStats;
    }

    public TeamDefenseStatsBuilder getTeamDefenseStats() {
		if (null == teamDefenseStats) {
			teamDefenseStats = new TeamDefenseStatsBuilder();
		}
    	return teamDefenseStats;
    }
	

	String getName() {
		if (null == name && firstName != null && lastName != null) {
			return firstName + " " + lastName;
		} else {
			return name;
		}
	}

}
