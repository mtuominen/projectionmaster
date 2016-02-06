package mpt.auctionmaster.projections;

import mpt.auctionmaster.properties.DefaultPropertyManager;
import mpt.auctionmaster.properties.OverridableProjectionPropertyManager;
import mpt.auctionmaster.properties.PropertyManager;

/**
 * Created by UTUOMMA on 8/21/2015.
 */
public enum ProjectionSource {
	DODDS(new OverridableProjectionPropertyManager("footballguys", "dodds")),
	HENRY(new OverridableProjectionPropertyManager("footballguys", "henry")),
	PAULSEN(new DefaultPropertyManager("4for4"));

	private final PropertyManager propertyManager;

	ProjectionSource(PropertyManager propertyManager) {
		this.propertyManager = propertyManager;
	}


	public PropertyManager getPropertyManager() {
		return propertyManager;
	}
}
