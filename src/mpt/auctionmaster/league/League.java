package mpt.auctionmaster.league;

import java.util.List;

public final class League {
	
	private final Integer leagueId;
	
	private final String name;
	
	private final List<Franchise> franchises;
	
	//TODO add configuration/scoring system information

	/**
     * @param leagueId
     * @param name
	 * @param franchises
     */
    public League(Integer leagueId, String name, List<Franchise> franchises) {
    	this.leagueId = leagueId;
	    this.name = name;
	    this.franchises = franchises;
    }

    public Integer getID() {
    	return leagueId;
    }

	public String getName() {
    	return name;
    }

	public List<Franchise> getFranchises() {
    	return franchises;
    }

}
