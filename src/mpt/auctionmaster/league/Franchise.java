package mpt.auctionmaster.league;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mpt.auctionmaster.enums.Position;
import mpt.auctionmaster.players.Player;

public final class Franchise {
	
	private final Integer franchiseId;
	
	private final Integer leagueId;
	
	private final String name;
	
	private final String owner;
	
	private final List<SelectedPlayer> selectedPlayers;
	
	private final Map<Player, Integer> playerToValue = new HashMap<Player, Integer>();

	/**
     * @param name
     * @param owner
     */
    public Franchise(
    		Integer franchiseId, 
    		Integer leagueId,
    		String name, 
    		String owner, 
    		List<SelectedPlayer> selectedPlayers
    ) {
    	this.franchiseId = franchiseId;
    	this.leagueId = leagueId;
	    this.name = name;
	    this.owner = owner;
	    this.selectedPlayers = selectedPlayers;
    }

    public Integer getID() {
    	return franchiseId;
    }
    
    public Integer getLeagueId() {
    	return leagueId;
    }

	public String getName() {
    	return name;
    }

	public String getOwner() {
    	return owner;
    }
	
	public List<SelectedPlayer> getSelectedPlayers() {
    	return selectedPlayers;
    }

	public Map<Player, Integer> getPlayerToValue() {
		if (selectedPlayers.size() > playerToValue.size()) {
			playerToValue.clear();
			for (SelectedPlayer currentPlayer : selectedPlayers) {
				playerToValue.put(currentPlayer.getPlayer(), currentPlayer.getValue());
			}
		}
    	return playerToValue;
    }

	public int getNumberOfPlayers() {
		return playerToValue.size();
	}
	
	public int getNumberOfPlayersAtPosition(Position position) {
		int i = 0;
		
		if (null != position) {
			for (Player currentPlayer : playerToValue.keySet()) {
				if (position.equals(currentPlayer.getPosition())) {
					i++;
				}
			}
		}
		
		return i;
	}
	
	public int getAmountSpentAtPosition(Position position) {
		int value = 0;
		
		if (null != position) {
			for (Player currentPlayer : playerToValue.keySet()) {
				if (position.equals(currentPlayer.getPosition())) {
					value += playerToValue.get(currentPlayer).intValue();
				}
			}
		}
		
		return value;
	}
	
	public int getTotalPlayerValue() {
		int value = 0;
		
		for (Player currentPlayer : playerToValue.keySet()) {
			value += playerToValue.get(currentPlayer).intValue();
		}
		
		return value;
	}

}
