/**
 * 
 */
package mpt.auctionmaster.enums;


/**
 * @author Matthew Tuominen
 *
 */
public enum Position {
	QUARTERBACK("QB"),
	RUNNINGBACK("RB"),
	WIDERECEIVER("WR"),
	TIGHTEND("TE"),
	PLACEKICKER("PK"),
	TEAMDEFENSE("D");
	
	private String abbreviation;
	
	private Position(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	
	public String getAbbreviation() {
		return abbreviation;
	}
}
