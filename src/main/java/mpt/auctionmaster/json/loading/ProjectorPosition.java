package mpt.auctionmaster.json.loading;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectorPosition {
    @JsonProperty("projector")
    private int projector;
    @JsonProperty("type")
    private String type;
    @JsonProperty("lastupdated")
    private String lastupdated;
    @JsonProperty("set_id")
    private String setId;
    @JsonProperty("projections")
    private Map<String, JSONPlayerProjection> projections;

    public int getProjector() {
        return projector;
    }

    public void setProjector(int projector) {
        this.projector = projector;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLastupdated() {
        return lastupdated;
    }

    public void setLastupdated(String lastupdated) {
        this.lastupdated = lastupdated;
    }

    public String getSetId() {
        return setId;
    }

    public void setSetId(String setId) {
        this.setId = setId;
    }

    public Map<String, JSONPlayerProjection> getProjections() {
        return projections;
    }

    public void setProjections(Map<String, JSONPlayerProjection> projections) {
        this.projections = projections;
    }
}
