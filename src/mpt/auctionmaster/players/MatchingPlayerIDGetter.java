package mpt.auctionmaster.players;

/**
 * Created by UTUOMMA on 8/26/2015.
 */
public class MatchingPlayerIDGetter implements PlayerIDGetterStrategy {

	@Override
	public String getID(Player player) {
		return player.getPosition().getAbbreviation() + "_" + player.getTeam() + "_" + player.getName().substring(0, 2) + "_" + getLastName(player);
	}

	private static String getLastName(Player player) {
		final String[] tokens = player.getName().split(" ");
		if (tokens.length == 2) {
			return tokens[1];
		} else {
			if (tokens[1].length() > tokens[2].length()) {
				return tokens[1];
			} else {
				return tokens[2];
			}
		}
	}
}
