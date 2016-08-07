package mpt.auctionmaster.players;

/**
 * Created by UTUOMMA on 8/26/2015.
 */
public class DefaultPlayerIDGetter implements PlayerIDGetterStrategy {
	@Override
	public String getID(Player player) {
		return player.getID();
	}
}
