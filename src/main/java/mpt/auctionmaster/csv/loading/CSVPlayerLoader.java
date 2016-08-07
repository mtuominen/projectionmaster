package mpt.auctionmaster.csv.loading;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mpt.auctionmaster.PlayerLoader;
import mpt.auctionmaster.enums.Position;
import mpt.auctionmaster.enums.Statistic;
import mpt.auctionmaster.players.Player;
import mpt.auctionmaster.players.stats.build.PlayerBuilder;
import mpt.auctionmaster.players.stats.build.PlayerBuilderAccessor;
import mpt.auctionmaster.players.stats.build.StatisticEnumToStringStatisticSetterFactory;
import mpt.auctionmaster.players.stats.build.StringStatisticSetter;
import mpt.auctionmaster.players.stats.build.StringStatisticSetterFactory;
import mpt.auctionmaster.projections.ProjectionSourceContext;
import mpt.auctionmaster.properties.PropertyManager;
import mpt.auctionmaster.util.StringUtil;

@Component
public class CSVPlayerLoader implements PlayerLoader {
	
	@Autowired
	private ProjectionSourceContext projectionSourceContext;

	private PropertyManager propertyManager;
	
	@Override
	public Map<Position, List<Player>> loadPlayers() throws IOException, URISyntaxException {
		propertyManager = projectionSourceContext.getProjectionSource().getPropertyManager();
		Map<Position, List<Player>> returnValue = new HashMap<Position, List<Player>>();
		
		final String folder = propertyManager.getProjectionsDirectory();
		System.out.println("CSVPlayerLoader.loadPlayers - Projections Folder: " + folder);
		final String[] files = new File(folder).list();
		for (String currentFile : files) {
			System.out.println("CSVPlayerLoader.loadPlayers - Projections file: " + currentFile);
			InputStream inputStream = null;
			try {
				//final InputStream input = new FileInputStream(currentFile);
				inputStream = new FileInputStream(new File(folder + "/" + currentFile));
				final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
				final List<StringStatisticSetterFactory> statisticSetterFactories = parseHeader(reader);
				
				String line = null;
				while ((line = reader.readLine()) != null) {
					final Player currentPlayer = parsePlayer(line, statisticSetterFactories);
					List<Player> positionList = returnValue.get(currentPlayer.getPosition());
					if (null == positionList) {
						positionList = new ArrayList<Player>();
						returnValue.put(currentPlayer.getPosition(), positionList);
					}
					positionList.add(currentPlayer);
				}
			} finally {
				if (null != inputStream) {
					inputStream.close();
				}
			}
		}
		
		return returnValue;
	}
	
	private List<StringStatisticSetterFactory> parseHeader(BufferedReader reader) throws IOException, URISyntaxException {
		//TODO need something that determines the number of header rows
		final int numberOfHeaderRows = 1;
		final List<StringBuilder> headers = new ArrayList<StringBuilder>();
		for (int i = 0; i < numberOfHeaderRows; i++) {
			final String line = reader.readLine();
			
			final StringTokenizer tokenizer = new StringTokenizer(line, ",");
			System.out.println("CSVPlayerLoader.parseHeader - Header Token Count: " + tokenizer.countTokens());
			int j = 0;
			while (tokenizer.hasMoreTokens()) {
				if (j == headers.size()) {
					headers.add(new StringBuilder(tokenizer.nextToken()));
				} else {
					headers.get(j).append(" ").append(tokenizer.nextToken());
				}
				j++;
			}
		}
		
		return convertHeadersToFactories(headers);
	}
	
	private List<StringStatisticSetterFactory> convertHeadersToFactories(List<StringBuilder> headers) throws IOException, URISyntaxException {
		final Map<String, Statistic> statisticProperties = propertyManager.getStatisticProperties();
		final Iterator<Statistic> unlabeledOrder = propertyManager.getUnlabeledStatisticOrder().iterator();
		final List<StringStatisticSetterFactory> factoryList = new ArrayList<StringStatisticSetterFactory>();
		final StatisticEnumToStringStatisticSetterFactory factoryBuilder = new StatisticEnumToStringStatisticSetterFactory(propertyManager);
		for (StringBuilder currentColumn : headers) {
			final String columnName = currentColumn.toString().trim();
			System.out.println("CSVPlayerLoader.parseHeader - Column Name: " + columnName);
			final Statistic columnStatistic; 
			if ("".equals(columnName)) {
				columnStatistic = unlabeledOrder.next();
			} else {
				columnStatistic = statisticProperties.get(columnName);
			}
			System.out.println("CSVPlayerLoader.parseHeader - Statistic: " + columnStatistic.name());
			final StringStatisticSetterFactory factory = factoryBuilder.getFactory(columnStatistic);
			factoryList.add(factory);
		}
		
		return factoryList;
	}
	
	private Player parsePlayer(String line, List<StringStatisticSetterFactory> setterFactories) {
		final String[] tokens = line.split(",", -1);
		int i = 0;
		final PlayerBuilder builder = new PlayerBuilder();
		for (int j = 0; j < tokens.length; j++) {
			if (!StringUtil.isEmpty(tokens[j])) {
				final StringStatisticSetterFactory factory = setterFactories.get(i);
				final StringStatisticSetter setter = factory.create(builder);
				final StringBuilder value = new StringBuilder(tokens[j]);
				//TODO this should be more robust
				if (value.toString().indexOf('"') >= 0) {
					j++;
					final String token = tokens[j];
					value.append(",").append(token);
				}
				try {
					setter.set(value.toString().replace("\"", ""));
				} catch (Exception e) {
					System.out.println("Error setting statistic for " + new PlayerBuilderAccessor(builder).getName());
					e.printStackTrace();
				}
			}
			i++;
		}
		
		return builder.build();
	}

	/*public static void main(String[] args) throws Exception {
		System.out.println("Working Directory = " +
		              System.getProperty("user.dir"));

		final PropertyManager propertyManager = new OverridableProjectionPropertyManager("footballguys", "henry");
		//final PropertyManager propertyManager = new DefaultPropertyManager("4for4");
		final Map<Position, List<Player>> positionToPlayersMap = new CSVPlayerLoader(propertyManager).loadPlayers();
		System.out.println(positionToPlayersMap.size());
		System.out.println(positionToPlayersMap.get(Position.QUARTERBACK).size());
		System.out.println(positionToPlayersMap.get(Position.RUNNINGBACK).size());
		System.out.println(positionToPlayersMap.get(Position.WIDERECEIVER).size());
		System.out.println(positionToPlayersMap.get(Position.TIGHTEND).size());

		//TODO Both are parsing, now lets combine them
		System.out.println(positionToPlayersMap.get(Position.PLACEKICKER).size());
		System.out.println(positionToPlayersMap.get(Position.TEAMDEFENSE).size());
	}*/

}
