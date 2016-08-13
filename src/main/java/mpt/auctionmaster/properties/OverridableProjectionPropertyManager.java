package mpt.auctionmaster.properties;

/**
 * Created by UTUOMMA on 8/16/2015.
 */
public class OverridableProjectionPropertyManager extends DefaultPropertyManager {

	private final String projectionSubdirectory;
	private final int projectorId;

	public OverridableProjectionPropertyManager(String dir, ProjectionFormat projectionFormat, int projectorId, String projectionSubdirectory) {
		super(dir, projectionFormat);
		this.projectionSubdirectory = projectionSubdirectory;
		this.projectorId = projectorId;
	}

	@Override
	public String getProjectionsDirectory() {
		return getDir() + "/" + PROJECTION_DIRECTORY + "/" + projectionSubdirectory;
	}

	public int getProjectorId() {
		return projectorId;
	}
}
