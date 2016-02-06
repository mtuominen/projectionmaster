package mpt.auctionmaster.players.unique;

import mpt.auctionmaster.enums.Position;
import mpt.auctionmaster.enums.Team;

/**
 * Created by UTUOMMA on 8/10/2015.
 */
public final class UniquePlayer {

	private final Position position;
	private final String firstName;
	private final String lastName;
	private final Integer id;
	private final Team team;
	private final String status;


	public UniquePlayer(Position position, String firstName, String lastName, Integer id, Team team, String status) {
		this.position = position;
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.team = team;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}


	public Position getPosition() {
		return position;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		final UniquePlayer that = (UniquePlayer)o;

		if (id.equals(that.id)) {
			return true;
		}

		if (!firstName.equals(that.firstName)) return false;
		if (!lastName.equals(that.lastName)) return false;
		if (position != null ? !position.equals(that.position) : that.position != null) return false;
		if (!team.equals(that.team)) return false;

		return true;
	}


	@Override
	public int hashCode() {
		int result = firstName.hashCode();
		result = 31 * result + lastName.hashCode();
		result = 31 * result + team.hashCode();
		result = 31 * result + (position != null ? position.hashCode() : 0);
		return result;
	}
}
