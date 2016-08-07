package mpt.auctionmaster.enums;

public class StatisticConverter implements EnumConverter<Statistic> {

	@Override
    public Statistic convert(String name) {
	    return Statistic.valueOf(name);
    }

}
