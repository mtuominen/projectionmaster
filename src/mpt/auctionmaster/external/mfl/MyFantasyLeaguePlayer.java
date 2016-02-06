package mpt.auctionmaster.external.mfl;

/**
 * Created by UTUOMMA on 8/9/2015.
 */
public class MyFantasyLeaguePlayer extends BaseDomain {
	private String position;
	private String name;
	private Integer id;
	private String team;
	private String status;


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTeam() {
		return team;
	}


	public void setTeam(String team) {
		this.team = team;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
}
