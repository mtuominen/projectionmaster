package mpt.auctionmaster.projections;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.EnumMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import mpt.auctionmaster.enums.Position;
import mpt.auctionmaster.properties.ApplicationProperties;

/**
 * Created by UTUOMMA on 8/21/2015.
 */
@Component
public class ProjectionWeightService {

	@Autowired
	private Environment env;

	public Map<ProjectionSource, BigDecimal> getProjectionWeight(Position position) throws IOException, URISyntaxException {
		final ProjectionSource firstSource = ProjectionSource.valueOf(env.getProperty(position.name() + "-0-source"));
		final ProjectionSource secondSource = ProjectionSource.valueOf(env.getProperty(position.name() + "-1-source"));

		final BigDecimal firstWeight = new BigDecimal(env.getProperty(position.name() + "-0-weight"));
		final BigDecimal secondWeight = new BigDecimal(env.getProperty(position.name() + "-1-weight"));

		final Map<ProjectionSource, BigDecimal> projectionWeights = new EnumMap<>(ProjectionSource.class);

		projectionWeights.put(firstSource, firstWeight);
		projectionWeights.put(secondSource, secondWeight);

		return projectionWeights;
	}
}
