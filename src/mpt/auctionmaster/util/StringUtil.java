package mpt.auctionmaster.util;

import java.math.BigDecimal;

public class StringUtil {
	
	public static String stringFromInteger(Integer i) {
		return null == i ? "" : "" + i.intValue();
	}
	
	public static String stringFromBigDecimal(BigDecimal bd) {
		return null == bd ? "" : "" + bd.toString();
	}
	
	public static String nullToEmpty(String s) {
		return null == s ? "" : trimNullSafe(s);
	}

	public static String trimNullSafe(String s) {
		if (null == s) {
			return null;
		} else if (s.trim().length() == 0) {
			return null;
		} else {
			return s.trim();
		}
	}

	public static boolean isEmpty(String s) {
		final String trimmed = trimNullSafe(s);
		return trimmed == null || trimmed.isEmpty();
	}
}
