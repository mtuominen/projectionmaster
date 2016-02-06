package mpt.auctionmaster.projections;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.EnumMap;
import java.util.Map;

import mpt.auctionmaster.enums.Position;
import mpt.auctionmaster.properties.ApplicationProperties;

/**
 * Created by UTUOMMA on 8/21/2015.
 */
public class ProjectionWeightService {

	private final ApplicationProperties properties;

	public ProjectionWeightService(ApplicationProperties properties) {
		this.properties = properties;
	}

	public Map<ProjectionSource, BigDecimal> getProjectionWeight(Position position) throws IOException, URISyntaxException {
		final ProjectionSource firstSource = ProjectionSource.valueOf(properties.getProperty(position.name() + "-0-source"));
		final ProjectionSource secondSource = ProjectionSource.valueOf(properties.getProperty(position.name() + "-1-source"));

		final BigDecimal firstWeight = new BigDecimal(properties.getProperty(position.name() + "-0-weight"));
		final BigDecimal secondWeight = new BigDecimal(properties.getProperty(position.name() + "-1-weight"));

		final Map<ProjectionSource, BigDecimal> projectionWeights = new EnumMap<>(ProjectionSource.class);

		projectionWeights.put(firstSource, firstWeight);
		projectionWeights.put(secondSource, secondWeight);

		return projectionWeights;
	}
}
