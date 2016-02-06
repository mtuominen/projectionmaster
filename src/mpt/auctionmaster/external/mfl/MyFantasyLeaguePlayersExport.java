package mpt.auctionmaster.external.mfl;


/**
 * Created by UTUOMMA on 8/9/2015.
 */
public class MyFantasyLeaguePlayersExport extends BaseDomain {

	private String version;
	private MyFantasyLeaguePlayers players;
	private String encoding;


	public String getVersion() {
		return version;
	}


	public void setVersion(String version) {
		this.version = version;
	}


	public MyFantasyLeaguePlayers getPlayers() {
		return players;
	}


	public void setPlayers(MyFantasyLeaguePlayers players) {
		this.players = players;
	}


	public String getEncoding() {
		return encoding;
	}


	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
}
