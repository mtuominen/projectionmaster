package mpt.auctionmaster.players.unique;

import mpt.auctionmaster.enums.Position;
import mpt.auctionmaster.enums.Team;

/**
 * Created by UTUOMMA on 8/10/2015.
 */
public class UniquePlayerBuilder {

	private Position position;
	private String firstName;
	private String lastName;
	private Integer id;
	private Team team;
	private String status;

	public UniquePlayer build() {
		return new UniquePlayer(position, firstName, lastName, id, team, status);
	}


	public void setPosition(Position position) {
		this.position = position;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public void setTeam(Team team) {
		this.team = team;
	}


	public void setStatus(String status) {
		this.status = status;
	}
}
