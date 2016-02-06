/**
 * 
 */
package mpt.auctionmaster.enums;

/**
 * @author Matthew Tuominen
 *
 */
public class PositionConverter implements EnumConverter<Position> {

	@Override
    public Position convert(String name) {
	    return Position.valueOf(name);
    }

}
