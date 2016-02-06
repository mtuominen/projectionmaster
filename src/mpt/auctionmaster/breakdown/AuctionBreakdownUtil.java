package mpt.auctionmaster.breakdown;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import mpt.auctionmaster.enums.Position;
import mpt.auctionmaster.properties.PropertyManager;

public class AuctionBreakdownUtil {
	
	private enum ColumnType {
		RANK, MIN, TREND, MAX
	}
	
	private PropertyManager propertyManager;
	
	private Map<Position, PositionBreakdown> positionToPositionBreakdown = new HashMap<Position, PositionBreakdown>();
	
	public AuctionBreakdownUtil(PropertyManager propertyManager) {
		this.propertyManager = propertyManager;
	}
	
	public PositionRankBreakdown getBreakdown(Position position, int rank) throws IOException {
		return getPositionBreakdown(position).getRankBreakdown(new Integer(rank));
	}
	
	public PositionBreakdown getPositionBreakdown(Position position) throws IOException {
		synchronized(positionToPositionBreakdown) {
			if (!positionToPositionBreakdown.containsKey(position)) {
				loadBreakdown(position);
			}
			
			return positionToPositionBreakdown.get(position);
		}
	}
	
	private void loadBreakdown(Position position) throws IOException {
		final String folder = propertyManager.getProjectionsDirectory();
		System.out.println("CSVPlayerLoader.loadPlayers - Projections Folder: " + folder);
		final String[] files = new File(folder).list();
		if (!doesListContainPosition(files, position)) {
			//add empty breakdown so we don't keep checking.
			positionToPositionBreakdown.put(position, new PositionBreakdown(position, new HashMap<Integer, PositionRankBreakdown>()));
		} else {
			InputStream inputStream = null;
			try {
				inputStream = new FileInputStream(new File(folder, position.getAbbreviation()));
				final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
				final List<ColumnType> columnTypes = parseHeader(reader);
				
				final Map<Integer, PositionRankBreakdown> rankToBreakdown = new HashMap<Integer, PositionRankBreakdown>();
				
				String line = null;
				while ((line = reader.readLine()) != null) {
					final List<Integer> values = parseLine(line);
					final PositionRankBreakdown currentBreakdown = buildBreakdown(position, values, columnTypes);
					rankToBreakdown.put(new Integer(currentBreakdown.getRank()), currentBreakdown);
				}
				
				positionToPositionBreakdown.put(position, new PositionBreakdown(position, rankToBreakdown));
			} finally {
				if (null != inputStream) {
					inputStream.close();
				}
			}
		}
		
	}
	
	private boolean doesListContainPosition(String[] fileList, Position position) {
		for (String file : fileList) {
			if (position.getAbbreviation().equals(file)) {
				return true;
			}
		}
		return false;
	}
	
	private List<ColumnType> parseHeader(BufferedReader reader) throws IOException {
		final List<String> headers = new ArrayList<String>();
		final String line = reader.readLine();
		
		final StringTokenizer tokenizer = new StringTokenizer(line, ",");
		while (tokenizer.hasMoreTokens()) {
			headers.add(tokenizer.nextToken());
		}
		
		return convertHeadersToColumnTypes(headers);
	}
	
	private List<ColumnType> convertHeadersToColumnTypes(List<String> headers) {
		final List<ColumnType> columnTypes = new ArrayList<ColumnType>();
		for (String currentHeader : headers) {
			columnTypes.add(ColumnType.valueOf(currentHeader.toUpperCase()));
		}
		
		return columnTypes;
	}
	
	private List<Integer> parseLine(String line) {
		final StringTokenizer tokenizer = new StringTokenizer(line, ",");
		final List<Integer> values = new ArrayList<Integer>();
		
		while (tokenizer.hasMoreTokens()) {
			values.add(new Integer(tokenizer.nextToken()));
		}
		
		return values;
	}
	
	private PositionRankBreakdown buildBreakdown(
			Position position, 
			List<Integer> values, 
			List<ColumnType> columnTypes) {
		final PositionRankBreakdownBuilder builder = new PositionRankBreakdownBuilder();
		builder.setPosition(position);
		int i = 0;
		for (Integer currentValue : values) {
			setAttribute(builder, columnTypes.get(i++), currentValue);
		}
		
		return builder.build();
	}
	
	private void setAttribute(PositionRankBreakdownBuilder builder, ColumnType type, Integer value) {
		switch (type) {
		case RANK:
			builder.setRank(value.intValue());
			break;
		case MIN:
			builder.setMin(value.intValue());
			break;
		case TREND:
			builder.setTrend(value.intValue());
			break;
		case MAX:
			builder.setMax(value.intValue());
			break;
		}
	}

}
