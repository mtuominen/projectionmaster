package mpt.auctionmaster.projections;

import mpt.auctionmaster.properties.DefaultPropertyManager;
import mpt.auctionmaster.properties.OverridableProjectionPropertyManager;
import mpt.auctionmaster.properties.ProjectionFormat;
import mpt.auctionmaster.properties.PropertyManager;

/**
 * Created by UTUOMMA on 8/21/2015.
 */
public enum ProjectionSource {
	DODDS(new OverridableProjectionPropertyManager("footballguys", ProjectionFormat.JSON, 2, "dodds")),
	HENRY(new OverridableProjectionPropertyManager("footballguys", ProjectionFormat.JSON, 41, "henry")),
	PAULSEN(new DefaultPropertyManager("4for4", ProjectionFormat.CSV));

	private final PropertyManager propertyManager;

	ProjectionSource(PropertyManager propertyManager) {
		this.propertyManager = propertyManager;
	}


	public PropertyManager getPropertyManager() {
		return propertyManager;
	}
}
