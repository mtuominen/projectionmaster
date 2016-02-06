/**
 * 
 */
package mpt.auctionmaster.enums;

/**
 * @author Matthew Tuominen
 *
 */
public interface EnumConverter <E extends Enum<E>>{
	
	/**
	 * @param name
	 * @return
	 */
	E convert(String name);

}
