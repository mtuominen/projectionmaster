package mpt.auctionmaster.external.mfl;

import java.util.Map;

import mpt.auctionmaster.enums.Position;
import mpt.auctionmaster.enums.Team;
import mpt.auctionmaster.players.unique.UniquePlayerBuilder;
import mpt.auctionmaster.players.unique.UniquePlayerService;
import mpt.auctionmaster.players.unique.UniquePlayerServiceImpl;
import mpt.auctionmaster.properties.DefaultPropertyManager;
import mpt.auctionmaster.properties.PropertyManager;
import mpt.auctionmaster.rest.ServiceProxyFactory;

/**
 * Created by UTUOMMA on 8/3/2015.
 */

public class MyFantasyLeaguePullMain {

	public static void main(String[] args) throws Exception {
		final MyFantasyLeagueService mflServiceProxy = new ServiceProxyFactory().createRESTEasyProxy(MyFantasyLeagueService.class, "http://football.myfantasyleague.com/", 443, null, null);
		final MyFantasyLeaguePlayersExport player = mflServiceProxy.getPlayerExport("players", "", "", 1);
		final UniquePlayerService uniquePlayerService = new UniquePlayerServiceImpl();
		final PropertyManager propertyManager = new DefaultPropertyManager("myfantasyleague");
		final Map<String, Position> positionProperties = propertyManager.getPositionProperties();
		final Map<String, Team> teamProperties = propertyManager.getTeamProperties();
		for (final MyFantasyLeaguePlayer currentPlayer : player.getPlayers().getPlayer()) {
			System.out.println(currentPlayer.getPosition());
			final Position position = positionProperties.get(currentPlayer.getPosition());
			if (position != null) {
				final UniquePlayerBuilder uniquePlayerBuilder = new UniquePlayerBuilder();
				uniquePlayerBuilder.setId(currentPlayer.getId());
				uniquePlayerBuilder.setPosition(position);

				uniquePlayerBuilder.setStatus(currentPlayer.getStatus());
				uniquePlayerBuilder.setTeam(teamProperties.get(currentPlayer.getTeam()));//TODO this is nulling out
				final String fullName = currentPlayer.getName();
				uniquePlayerBuilder.setFirstName(fullName.substring(fullName.indexOf(",") + 1));
				uniquePlayerBuilder.setLastName(fullName.substring(0, fullName.indexOf(",")));
				uniquePlayerService.addUniquePlayer(uniquePlayerBuilder.build());
			}
		}

		//TODO once everything here is working I think I should work on CSV parsing FBG proj files
		//TODO then storing projections based on person making the projection and associating to uniqueplayer in some way
		//TODO finally we need to be able to loop through and get projections averaged for every single player

		System.out.println(player.getVersion());
		System.out.println(player.getPlayers().getPlayer().size());
	}
}
