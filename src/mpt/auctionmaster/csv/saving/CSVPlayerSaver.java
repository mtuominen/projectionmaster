package mpt.auctionmaster.csv.saving;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import mpt.auctionmaster.enums.Position;
import mpt.auctionmaster.enums.Statistic;
import mpt.auctionmaster.players.Player;
import mpt.auctionmaster.players.StatisticEnumToStringStatisticGetter;
import mpt.auctionmaster.players.StringStatisticGetter;
import mpt.auctionmaster.properties.ApplicationProperties;

/**
 * Created by UTUOMMA on 8/23/2015.
 */
public class CSVPlayerSaver {

	private final ApplicationProperties properties;

	public CSVPlayerSaver(ApplicationProperties properties) {
		this.properties = properties;
	}

	public void save(Position position, List<Player> playerList) throws IOException, URISyntaxException {
		final List<Statistic> statisticList = getHeaderOrder(position);
		FileWriter writer = null;
		try {
			writer = new FileWriter(position.name() + ".csv");
			writeHeader(writer, statisticList);
			writePlayers(writer, playerList, statisticList);
		} finally {
			if (writer != null) {
				writer.flush();
				writer.close();
			}
		}
	}

	private List<Statistic> getHeaderOrder(Position position) throws IOException, URISyntaxException {
		final String fields = properties.getProperty(position.name() + "-csvFields");
		final String[] headerFields = fields.split(",");
		final List<Statistic> statisticList = new ArrayList<>();
		for (final String headerField : headerFields) {
			statisticList.add(Statistic.valueOf(headerField));
		}

		return statisticList;
	}

	private static void writeHeader(Writer writer, List<Statistic> statisticList) throws IOException {
		boolean first = true;
		for (final Statistic statistic : statisticList) {
			if (first) {
				first = false;
			} else {
				writer.append(",");
			}
			writer.append(statistic.getLabel());
		}
		writer.append("\n");
	}

	private static void writePlayers(Writer writer, List<Player> playerList, List<Statistic> statisticList) throws IOException {
		final StatisticEnumToStringStatisticGetter statisticEnumToStringStatisticGetter = new StatisticEnumToStringStatisticGetter();
		final List<StringStatisticGetter> getterList = new ArrayList<>();
		for (final Statistic statistic : statisticList) {
			getterList.add(statisticEnumToStringStatisticGetter.getGetter(statistic));
		}

		for (final Player currentPlayer : playerList) {
			writePlayer(writer, currentPlayer, getterList);
		}
	}

	private static void writePlayer(Writer writer, Player player, List<StringStatisticGetter> getterList) throws IOException {
		boolean first = true;
		for (final StringStatisticGetter getter : getterList) {
			if (first) {
				first = false;
			} else {
				writer.append(",");
			}
			writer.append(getter.get(player));
		}
		writer.append("\n");
	}
}
