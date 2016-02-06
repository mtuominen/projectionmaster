package mpt.auctionmaster.projections;

import java.util.List;

import mpt.auctionmaster.csv.saving.CSVPlayerSaver;
import mpt.auctionmaster.enums.Position;
import mpt.auctionmaster.players.Player;
import mpt.auctionmaster.projections.average.AveragedPlayerService;
import mpt.auctionmaster.properties.ApplicationProperties;

/**
 * Created by UTUOMMA on 8/21/2015.
 */
public class ProjectionMaster {

	public static void main(String[] args) throws Exception {
		final ApplicationProperties properties = new ApplicationProperties();
		final AveragedPlayerService averagedPlayerService = new AveragedPlayerService(properties);
		for (final Position currentPosition : Position.values()) {
			final List<Player> averagedPlayers = averagedPlayerService.getAveragedPlayers(currentPosition);
			new CSVPlayerSaver(properties).save(currentPosition, averagedPlayers);
		}

	}
}
