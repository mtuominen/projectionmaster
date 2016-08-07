package mpt.auctionmaster.projections;

import org.springframework.stereotype.Component;

@Component
public class ProjectionSourceContext {
	
	private ProjectionSource projectionSource;

	public ProjectionSource getProjectionSource() {
		return projectionSource;
	}

	public void setProjectionSource(ProjectionSource projectionSource) {
		this.projectionSource = projectionSource;
	}

}
