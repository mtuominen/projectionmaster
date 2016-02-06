package mpt.auctionmaster.scoring;

import java.math.BigDecimal;

public final class ScoringConfiguration {
	
	private final BigDecimal pointsPerPassingYard;
	
	private final BigDecimal pointsPerPassingTouchdown;
	
	private final BigDecimal pointsPerPassingInterception;
	
	private final BigDecimal pointsPerPassingTwoPointConversion;
	
	private final BigDecimal pointsPerRushRecYard;
	
	private final BigDecimal pointsPerRushRecTouchdown;
	
	private final BigDecimal pointsPerRushRecTwoPointConversion;
	
	private final BigDecimal pointsPerReception;
	
	//TODO include fumble stats someday
	//private final BigDecimal pointsPerOffensiveFumble;
	
	private final BigDecimal pointsPerXP;
	
	private final BigDecimal pointsPerMissedXP;
	
	private final BigDecimal pointsPerFG;
	
	private final BigDecimal pointsPerMissedFG;
	
	private final BigDecimal bonusPointsPerFortiesFG;
	
	private final BigDecimal bonusPointsPerFiftyPlusFG;
	
	private final BigDecimal pointsPerDefensiveTD;
	
	private final BigDecimal pointsPerSack;
	
	private final BigDecimal pointsPerDefensiveInterception;
	
	private final BigDecimal pointsPerFumbleRecovered;
	
	private final BigDecimal pointsPerSafety;
	
	public ScoringConfiguration() {
		pointsPerPassingYard = new BigDecimal("0.04"); 
		pointsPerPassingTouchdown =new BigDecimal("4");
		pointsPerPassingInterception = new BigDecimal("-1");
		pointsPerPassingTwoPointConversion = new BigDecimal("1");
		pointsPerRushRecYard = new BigDecimal("0.1");
		pointsPerRushRecTouchdown = new BigDecimal("6");
		pointsPerRushRecTwoPointConversion = new BigDecimal("2");
		pointsPerReception = new BigDecimal("0.5");
		pointsPerXP = new BigDecimal("1");
		pointsPerMissedXP = new BigDecimal("-1");
		pointsPerFG = new BigDecimal("3");
		pointsPerMissedFG = new BigDecimal("-1");
		bonusPointsPerFortiesFG = new BigDecimal("1");
		bonusPointsPerFiftyPlusFG = new BigDecimal("2");
		pointsPerDefensiveTD = new BigDecimal("6");
		pointsPerSack = new BigDecimal("1");
		pointsPerDefensiveInterception = new BigDecimal("2");
		pointsPerFumbleRecovered = new BigDecimal("2");
		pointsPerSafety = new BigDecimal("2");
	}
	
	protected ScoringConfiguration(
		BigDecimal pointsPerPassingYard, 
		BigDecimal pointsPerPassingTouchdown, 
		BigDecimal pointsPerPassingInterception,
		BigDecimal pointsPerPassingTwoPointConversion,
		BigDecimal pointsPerRushRecYard,
		BigDecimal pointsPerRushRecTouchdown,
		BigDecimal pointsPerRushRecTwoPointConversion,
		BigDecimal pointsPerReception,
		BigDecimal pointsPerXP,
		BigDecimal pointsPerMissedXP,
		BigDecimal pointsPerFG,
		BigDecimal pointsPerMissedFG,
		BigDecimal bonusPointsPerFortiesFG,
		BigDecimal bonusPointsPerFiftyPlusFG,
		BigDecimal pointsPerDefensiveTD,
		BigDecimal pointsPerSack,
		BigDecimal pointsPerDefensiveInterception,
		BigDecimal pointsPerFumbleRecovered,
		BigDecimal pointsPerSafety
	) {
		this.pointsPerPassingYard = pointsPerPassingYard; 
		this.pointsPerPassingTouchdown = pointsPerPassingTouchdown; 
		this.pointsPerPassingInterception = pointsPerPassingInterception;
		this.pointsPerPassingTwoPointConversion = pointsPerPassingTwoPointConversion;
		this.pointsPerRushRecYard = pointsPerRushRecYard;
		this.pointsPerRushRecTouchdown = pointsPerRushRecTouchdown;
		this.pointsPerRushRecTwoPointConversion = pointsPerRushRecTwoPointConversion;
		this.pointsPerReception = pointsPerReception;
		this.pointsPerXP = pointsPerXP;
		this.pointsPerMissedXP = pointsPerMissedXP;
		this.pointsPerFG = pointsPerFG;
		this.pointsPerMissedFG = pointsPerMissedFG;
		this.bonusPointsPerFortiesFG = bonusPointsPerFortiesFG;
		this.bonusPointsPerFiftyPlusFG = bonusPointsPerFiftyPlusFG;
		this.pointsPerDefensiveTD = pointsPerDefensiveTD;
		this.pointsPerSack = pointsPerSack;
		this.pointsPerDefensiveInterception = pointsPerDefensiveInterception;
		this.pointsPerFumbleRecovered = pointsPerFumbleRecovered;
		this.pointsPerSafety = pointsPerSafety;
	}

	public BigDecimal getPointsPerPassingYard() {
    	return pointsPerPassingYard;
    }

	public BigDecimal getPointsPerPassingTouchdown() {
    	return pointsPerPassingTouchdown;
    }

	public BigDecimal getPointsPerPassingInterception() {
    	return pointsPerPassingInterception;
    }

	public BigDecimal getPointsPerPassingTwoPointConversion() {
    	return pointsPerPassingTwoPointConversion;
    }

	public BigDecimal getPointsPerRushRecYard() {
    	return pointsPerRushRecYard;
    }

	public BigDecimal getPointsPerRushRecTouchdown() {
    	return pointsPerRushRecTouchdown;
    }

	public BigDecimal getPointsPerRushRecTwoPointConversion() {
    	return pointsPerRushRecTwoPointConversion;
    }

	public BigDecimal getPointsPerReception() {
    	return pointsPerReception;
    }

	public BigDecimal getPointsPerXP() {
    	return pointsPerXP;
    }

	public BigDecimal getPointsPerMissedXP() {
    	return pointsPerMissedXP;
    }

	public BigDecimal getPointsPerFG() {
    	return pointsPerFG;
    }

	public BigDecimal getPointsPerMissedFG() {
    	return pointsPerMissedFG;
    }

	public BigDecimal getBonusPointsPerFortiesFG() {
    	return bonusPointsPerFortiesFG;
    }

	public BigDecimal getBonusPointsPerFiftyPlusFG() {
    	return bonusPointsPerFiftyPlusFG;
    }

	public BigDecimal getPointsPerDefensiveTD() {
    	return pointsPerDefensiveTD;
    }

	public BigDecimal getPointsPerSack() {
    	return pointsPerSack;
    }

	public BigDecimal getPointsPerDefensiveInterception() {
    	return pointsPerDefensiveInterception;
    }

	public BigDecimal getPointsPerFumbleRecovered() {
    	return pointsPerFumbleRecovered;
    }

	public BigDecimal getPointsPerSafety() {
    	return pointsPerSafety;
    }

}
