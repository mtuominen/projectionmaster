/**
 * 
 */
package mpt.auctionmaster.properties;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import mpt.auctionmaster.enums.Position;
import mpt.auctionmaster.enums.PositionConverter;
import mpt.auctionmaster.enums.Statistic;
import mpt.auctionmaster.enums.StatisticConverter;
import mpt.auctionmaster.enums.Team;
import mpt.auctionmaster.enums.TeamConverter;
import mpt.auctionmaster.util.PropertyLoadingUtil;

/**
 * @author Matthew Tuominen
 *
 */
public class DefaultPropertyManager implements PropertyManager {
	
	private static final String TEAM_MAP = "LabelToTeam.properties";
	
	private static final String BYE_MAP = "TeamToBye.properties";
	
	private static final String STATISTIC_MAP = "LabelToStatistic.properties";
	
	private static final String POSITION_MAP = "AbbreviationToPosition.properties";
	
	private static final String STATISTIC_ORDER = "UnlabeledStatisticOrder.properties";
	
	private final String dir;

	private final ProjectionFormat projectionFormat;
	
	public DefaultPropertyManager(String dir, ProjectionFormat projectionFormat) {
		this.dir = dir;
		this.projectionFormat = projectionFormat;
	}
	
	@Override
	public String getProjectionsDirectory() {
		return dir + "/" + PROJECTION_DIRECTORY;
	}
	
	@Override
	public String getAuctionBreakdownDirectory() {
		return dir + "/auctionbreakdown";
	}
	
	@Override
	public Map<String, Team> getTeamProperties() throws IOException, URISyntaxException {
		final Properties properties = PropertyLoadingUtil.loadProperties(dir + "/properties/" + TEAM_MAP);

		final PropertyMapBuilder<Team> mapBuilder = new PropertyMapBuilder<Team>();

		return mapBuilder.getEnumMap(properties, new TeamConverter());
	}
	
	@Override
	public Map<Team, Integer> getByeProperties() throws IOException, URISyntaxException {
		//final InputStream inputStream = new FileInputStream(new File(dir, BYE_MAP));
			final Properties properties = PropertyLoadingUtil.loadProperties(BYE_MAP);
			
			final TeamConverter converter = new TeamConverter();
			final Map<Team, Integer> enumMap = new EnumMap<Team, Integer>(Team.class);
			for (Object k : properties.keySet()) {
				final String key = (String) k;
				final String value = properties.getProperty(key);
				enumMap.put(converter.convert(key), new Integer(value));
			}
			return enumMap;
	}

	@Override
    public Map<String, Statistic> getStatisticProperties() throws IOException, URISyntaxException {
		//final InputStream inputStream = new FileInputStream(new File(dir, STATISTIC_MAP));

		final Properties properties = PropertyLoadingUtil.loadProperties(dir + "/properties/" + STATISTIC_MAP);

		final PropertyMapBuilder<Statistic> mapBuilder = new PropertyMapBuilder<Statistic>();

		return mapBuilder.getEnumMap(properties, new StatisticConverter());
    }

	@Override
    public Map<String, Position> getPositionProperties() throws IOException, URISyntaxException {
		final Properties properties = PropertyLoadingUtil.loadProperties(dir + "/properties/" + POSITION_MAP);

		final PropertyMapBuilder<Position> mapBuilder = new PropertyMapBuilder<Position>();

		return mapBuilder.getEnumMap(properties, new PositionConverter());
    }

	@Override
    public List<Statistic> getUnlabeledStatisticOrder() throws IOException {
	    InputStream inputStream = null;
		try {
			final List<Statistic> statisticOrder = new ArrayList<Statistic>();
			
			inputStream = new FileInputStream(new File(dir + "/properties/", STATISTIC_ORDER));
			//inputStream = manager.open(dir + "/properties/" + STATISTIC_ORDER);
			final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			
			String line = null;
			while ((line = reader.readLine()) != null) {
				final Statistic currentStatistic = Statistic.valueOf(line);
				statisticOrder.add(currentStatistic);
			}
			
		    return statisticOrder;
		} finally {
			if (null != inputStream) {
				inputStream.close();
			}
		}
    }

	protected String getDir() {
		return dir;
	}

	public ProjectionFormat getProjectionFormat() {
		return projectionFormat;
	}

	public int getProjectorId() {
		return -1;
	}
}
