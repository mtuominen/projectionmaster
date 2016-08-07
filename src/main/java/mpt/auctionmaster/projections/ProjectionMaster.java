package mpt.auctionmaster.projections;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import mpt.auctionmaster.csv.saving.CSVPlayerSaver;
import mpt.auctionmaster.enums.Position;
import mpt.auctionmaster.players.Player;
import mpt.auctionmaster.projections.average.AveragedPlayerService;

/**
 * Created by UTUOMMA on 8/21/2015.
 */
public class ProjectionMaster {

	public static void main(String[] args) throws Exception {
		final ApplicationContext ctx = 
				   new AnnotationConfigApplicationContext(ProjectionMasterConfig.class);
		
		final AveragedPlayerService averagedPlayerService = ctx.getBean(AveragedPlayerService.class);
		for (final Position currentPosition : Position.values()) {
			final List<Player> averagedPlayers = averagedPlayerService.getAveragedPlayers(currentPosition);
			ctx.getBean(CSVPlayerSaver.class).save(currentPosition, averagedPlayers);
		}

	}
}
