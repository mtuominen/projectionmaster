/**
 * 
 */
package mpt.auctionmaster.properties;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import mpt.auctionmaster.enums.EnumConverter;

/**
 * @author Matthew Tuominen
 *
 */
public class PropertyMapBuilder<E extends Enum<E>> {
	
	/**
	 * Converts the properties object into an enum map where the key is the 
	 * input String that is parsed and the value is the associated enum.
	 * 
	 * @param properties
	 * 		a Properties object where the key is the input value that is 
	 * 		parsed and the value is the String representation of the Enum
	 * @param converter
	 * 		converts the String to an enum
	 * 
	 * @return 
	 * 		an enum map where the key is the input String that is parsed and
	 * 		the value is the associated enum
	 */
	public Map<String, E> getEnumMap(Properties properties, EnumConverter<E> converter) {
		Map<String, E> enumMap = new HashMap<String, E>(properties.size());
		for (Object k : properties.keySet()) {
			final String key = (String) k;
			final String value = properties.getProperty(key);
			enumMap.put(key.replace("_", " "), converter.convert(value));
		}
		return enumMap;
	}

}
