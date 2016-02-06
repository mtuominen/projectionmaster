package mpt.auctionmaster.util;

import java.math.BigDecimal;
import java.math.MathContext;

public class RoundingUtil {
	
	private static final MathContext ONE_PLACE = new MathContext(1);
	private static final MathContext TWO_PLACES = new MathContext(2);
	private static final MathContext THREE_PLACES = new MathContext(3);
	private static final MathContext FOUR_PLACES = new MathContext(4);
	
	public static BigDecimal round(BigDecimal bigDecimal) {
		if (bigDecimal.doubleValue() > 100) {
			return bigDecimal.round(FOUR_PLACES);
		} else if (bigDecimal.doubleValue() > 10) { 
			return bigDecimal.round(THREE_PLACES);
		} else { 
			return bigDecimal.round(TWO_PLACES);
		}
	}
	
	public static BigDecimal roundDollars(BigDecimal bigDecimal) {
		if (bigDecimal.doubleValue() > 10) { 
			return bigDecimal.round(TWO_PLACES);
		} else { 
			return bigDecimal.round(ONE_PLACE);
		}
	}
}
