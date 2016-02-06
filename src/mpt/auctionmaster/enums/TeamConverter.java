package mpt.auctionmaster.enums;

public class TeamConverter implements EnumConverter<Team> {

	@Override
    public Team convert(String name) {
	    return Team.valueOf(name);
    }

}
