package mpt.auctionmaster.league;

import mpt.auctionmaster.players.Player;

public class SelectedPlayer {
	
	private final Integer selectedPlayerId;
	
	private final Player player;
	
	private final Integer franchiseId;
	
	private final Integer value;
	
	/**
     * @param selectedPlayerId
     * @param player
     * @param franchiseId
     * @param value
     */
    public SelectedPlayer(Integer selectedPlayerId, Player player,
            Integer franchiseId, Integer value) {
	    this.selectedPlayerId = selectedPlayerId;
	    this.player = player;
	    this.franchiseId = franchiseId;
	    this.value = value;
    }

	public Integer getID() {
    	return selectedPlayerId;
    }

	public Player getPlayer() {
    	return player;
    }
	
	public Integer getFranchiseId() {
    	return franchiseId;
    }

	public Integer getValue() {
    	return value;
    }
	
	

}
