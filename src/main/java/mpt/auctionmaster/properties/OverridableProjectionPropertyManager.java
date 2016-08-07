package mpt.auctionmaster.properties;

/**
 * Created by UTUOMMA on 8/16/2015.
 */
public class OverridableProjectionPropertyManager extends DefaultPropertyManager {

	private final String projectionSubdirectory;

	public OverridableProjectionPropertyManager(String dir, String projectionSubdirectory) {
		super(dir);
		this.projectionSubdirectory = projectionSubdirectory;
	}

	@Override
	public String getProjectionsDirectory() {
		return getDir() + "/" + PROJECTION_DIRECTORY + "/" + projectionSubdirectory;
	}
}
