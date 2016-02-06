/**
 * 
 */
package mpt.auctionmaster.enums;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Matthew Tuominen
 *
 */
public enum Statistic {
	IDENTIFIER("id"),
	RANK(""),
	NAME(""),
	FIRSTNAME(""),
	LASTNAME(""),
	TEAM(""),
	POSITION(""),
	BYEWEEK("Bye"),
	GAMESPLAYED("GP"),
	PASSATTEMPTS("Att"),
	PASSCOMPLETIONS("Cmp"),
	PASSYARDS("Pass Yds"),
	PASSTOUCHDOWNS("Pass TDs"),
	PASSINTERCEPTIONS("Pass Int"),
	RUSHCARRIES("Car"),
	RUSHYARDS("Rush Yds"),
	RUSHTOUCHDOWNS("Rush TDs"),
	RECEPTIONS("Recp"),
	RECEIVINGYARDS("Rec. Yds"),
	RECEIVINGTOUCHDOWNS("Rec. TDs"),
	FUMBLES("Fum"),
	MADEFIELDGOALS("Made FG"),
	MISSEDFIELDGOALS("Miss FG"),
	ATTEMPTEDFIELDGOALS("Att FG"),
	FORTIESFIELDGOALS("40-49 FG"),
	FIFTYPLUSFIELDGOALS("50+ FG"),
	MADEEXTRAPOINTS("Made XP"),
	MISSEDEXTRAPOINTS("Miss XP"),
	ATTEMPTEDEXTRAPOINTS("Att XP"),
	TOUCHDOWNS("TDs"),
	SACKS("Sack"),
	INTERCEPTIONS("Int"),
	FUMBLESRECOVERED("Fum"),
	SAFETIES("Saf"),
	POINTSALLOWED("Pts Allowed"),
	KICKRETURNTOUCHDOWNS("KR TDs"),
	PUNTRETURNTOUCHDOWNS("PR TDs"),
	AVERAGEFANTASYPOINTS("AVG FP"),
	TOTALFANTASYPOINTS("TOT FP"),
	AVERAGEFANTASYPOINT_VBD("AFP VBD"),
	TOTALFANTASYPOINTS_VBD("TFP VBD"),
	DOLLAR_VALUE("$$$ VAL"),
	UNUSED("");

	private static final List<Statistic> averageableStatistics = new ArrayList<>();

	static {
		averageableStatistics.add(GAMESPLAYED);
		averageableStatistics.add(PASSATTEMPTS);
		averageableStatistics.add(PASSCOMPLETIONS);
		averageableStatistics.add(PASSYARDS);
		averageableStatistics.add(PASSTOUCHDOWNS);
		averageableStatistics.add(PASSINTERCEPTIONS);
		averageableStatistics.add(RUSHCARRIES);
		averageableStatistics.add(RUSHYARDS);
		averageableStatistics.add(RUSHTOUCHDOWNS);
		averageableStatistics.add(FUMBLES);
		averageableStatistics.add(RECEPTIONS);
		averageableStatistics.add(RECEIVINGYARDS);
		averageableStatistics.add(RECEIVINGTOUCHDOWNS);
		averageableStatistics.add(KICKRETURNTOUCHDOWNS);
		averageableStatistics.add(PUNTRETURNTOUCHDOWNS);
		averageableStatistics.add(MADEFIELDGOALS);
		averageableStatistics.add(MISSEDFIELDGOALS);
		averageableStatistics.add(FORTIESFIELDGOALS);
		averageableStatistics.add(FIFTYPLUSFIELDGOALS);
		averageableStatistics.add(MADEEXTRAPOINTS);
		averageableStatistics.add(MISSEDEXTRAPOINTS);
		averageableStatistics.add(TOUCHDOWNS);
		averageableStatistics.add(SACKS);
		averageableStatistics.add(INTERCEPTIONS);
		averageableStatistics.add(FUMBLESRECOVERED);
		averageableStatistics.add(SAFETIES);
		averageableStatistics.add(POINTSALLOWED);
	}
	
	private final String label;
	
	Statistic(String label) {
		this.label = label;
	}
	
	public String getLabel() {
    	return label;
    }

	public static List<Statistic> getAverageableStatistics() {
		return new ArrayList<>(averageableStatistics);
	}

}
