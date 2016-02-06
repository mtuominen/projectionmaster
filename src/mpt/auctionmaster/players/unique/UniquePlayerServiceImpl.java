package mpt.auctionmaster.players.unique;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import mpt.auctionmaster.enums.Position;

/**
 * Created by UTUOMMA on 8/10/2015.
 */
public class UniquePlayerServiceImpl implements UniquePlayerService {

	private Map<UniquePlayer, UniquePlayer> uniquePlayerToUniquePlayer = new HashMap<>();

	private Map<Integer, UniquePlayer> idToUniquePlayer = new HashMap<>();

	private Map<Position, Map<UniquePlayer, UniquePlayer>> positionToUniquePlayerMap = new EnumMap<>(Position.class);

	private final ReadWriteLock lock = new ReentrantReadWriteLock(true);

	@Override
	public void addUniquePlayer(UniquePlayer player) {
		lock.writeLock().lock();
		idToUniquePlayer.put(player.getId(), player);
		uniquePlayerToUniquePlayer.put(player, player);

		Map<UniquePlayer, UniquePlayer> positionalMap = positionToUniquePlayerMap.get(player.getPosition());
		if (positionalMap == null) {
			positionalMap = new HashMap<>();
			positionToUniquePlayerMap.put(player.getPosition(), positionalMap);
		}
		positionalMap.put(player, player);

		lock.writeLock().unlock();
	}


	@Override
	public UniquePlayer getUniquePlayer(String position, String firstName, String lastName, Integer id, String team, String status) {
		lock.readLock().lock();
		UniquePlayer playerToReturn = null;
		if (id != null) {
			playerToReturn = idToUniquePlayer.get(id);
		}
		if (playerToReturn == null) {

		}
		if (playerToReturn == null) {
			throw new RuntimeException("No unique player found:" + position + " " + firstName + " " + lastName + " " + id + " " + team + " " + status);
		}
		lock.readLock().unlock();
		return playerToReturn;
	}
}
