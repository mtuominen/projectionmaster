package mpt.auctionmaster.value;

import java.util.EnumMap;
import java.util.Map;

import mpt.auctionmaster.enums.Position;

public class MultipleBaselineConfiguration {
	
	private Map<Position, Map<BaseLineType, Integer>> positionToBaselines;
	
	public MultipleBaselineConfiguration() {
		positionToBaselines = new EnumMap<Position, Map<BaseLineType, Integer>>(Position.class);
		
		final Map<BaseLineType, Integer> qbBaselines = new EnumMap<BaseLineType, Integer>(BaseLineType.class);
		qbBaselines.put(BaseLineType.ELITE, new Integer(6));
		qbBaselines.put(BaseLineType.WORSTSTARTER, new Integer(12));
		qbBaselines.put(BaseLineType.WORSTFIRSTBENCH, new Integer(18));
		qbBaselines.put(BaseLineType.BESTONEDOLLAR, new Integer(21));
		
		final Map<BaseLineType, Integer> rbBaselines = new EnumMap<BaseLineType, Integer>(BaseLineType.class);
		rbBaselines.put(BaseLineType.ELITE, new Integer(12));
		rbBaselines.put(BaseLineType.WORSTSTARTER, new Integer(24));
		rbBaselines.put(BaseLineType.WORSTFIRSTBENCH, new Integer(36));
		rbBaselines.put(BaseLineType.BESTONEDOLLAR, new Integer(62));
		
		final Map<BaseLineType, Integer> wrBaselines = new EnumMap<BaseLineType, Integer>(BaseLineType.class);
		wrBaselines.put(BaseLineType.ELITE, new Integer(12));
		wrBaselines.put(BaseLineType.WORSTSTARTER, new Integer(24));
		wrBaselines.put(BaseLineType.WORSTFIRSTBENCH, new Integer(36));
		wrBaselines.put(BaseLineType.BESTONEDOLLAR, new Integer(52));
		
		final Map<BaseLineType, Integer> teBaselines = new EnumMap<BaseLineType, Integer>(BaseLineType.class);
		teBaselines.put(BaseLineType.ELITE, new Integer(6));
		teBaselines.put(BaseLineType.WORSTSTARTER, new Integer(11));
		teBaselines.put(BaseLineType.WORSTFIRSTBENCH, new Integer(11));
		teBaselines.put(BaseLineType.BESTONEDOLLAR, new Integer(11));
		
		final Map<BaseLineType, Integer> pkBaselines = new EnumMap<BaseLineType, Integer>(BaseLineType.class);
		pkBaselines.put(BaseLineType.ELITE, new Integer(5));
		pkBaselines.put(BaseLineType.WORSTSTARTER, new Integer(5));
		pkBaselines.put(BaseLineType.WORSTFIRSTBENCH, new Integer(5));
		pkBaselines.put(BaseLineType.BESTONEDOLLAR, new Integer(5));
		
		final Map<BaseLineType, Integer> dtBaselines = new EnumMap<BaseLineType, Integer>(BaseLineType.class);
		dtBaselines.put(BaseLineType.ELITE, new Integer(6));
		dtBaselines.put(BaseLineType.WORSTSTARTER, new Integer(10));
		dtBaselines.put(BaseLineType.WORSTFIRSTBENCH, new Integer(10));
		dtBaselines.put(BaseLineType.BESTONEDOLLAR, new Integer(10));
		
		positionToBaselines.put(Position.QUARTERBACK, qbBaselines);
		positionToBaselines.put(Position.RUNNINGBACK, rbBaselines);
		positionToBaselines.put(Position.WIDERECEIVER, wrBaselines);
		positionToBaselines.put(Position.TIGHTEND, teBaselines);
		positionToBaselines.put(Position.PLACEKICKER, pkBaselines);
		positionToBaselines.put(Position.TEAMDEFENSE, dtBaselines);
	}
	
	public MultipleBaselineConfiguration(Map<Position, Map<BaseLineType, Integer>> positionToBaselines) {
		this.positionToBaselines = positionToBaselines;
	}
	
	public Map<BaseLineType, Integer> getBaselines(Position position) {
		return positionToBaselines.get(position);
	}
}
