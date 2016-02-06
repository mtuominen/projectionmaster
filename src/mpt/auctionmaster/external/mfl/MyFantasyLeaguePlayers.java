package mpt.auctionmaster.external.mfl;

import java.util.List;


/**
 * Created by UTUOMMA on 8/9/2015.
 */
public class MyFantasyLeaguePlayers extends BaseDomain {
	private long timestamp;
	private List<MyFantasyLeaguePlayer> player;


	public long getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}


	public List<MyFantasyLeaguePlayer> getPlayer() {
		return player;
	}


	public void setPlayer(List<MyFantasyLeaguePlayer> player) {
		this.player = player;
	}
}
