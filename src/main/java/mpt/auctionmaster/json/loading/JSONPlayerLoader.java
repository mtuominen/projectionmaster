package mpt.auctionmaster.json.loading;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import mpt.auctionmaster.PlayerLoader;
import mpt.auctionmaster.enums.Position;
import mpt.auctionmaster.enums.Team;
import mpt.auctionmaster.players.Player;
import mpt.auctionmaster.players.stats.build.PassingStatsBuilder;
import mpt.auctionmaster.players.stats.build.PlayerBuilder;
import mpt.auctionmaster.players.stats.build.ReceivingStatsBuilder;
import mpt.auctionmaster.players.stats.build.RushingStatsBuilder;
import mpt.auctionmaster.projections.ProjectionSourceContext;
import mpt.auctionmaster.properties.PropertyManager;

@Component
public class JSONPlayerLoader implements PlayerLoader {

    @Autowired
    private ProjectionSourceContext projectionSourceContext;

    private PropertyManager propertyManager;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Map<Position, List<Player>> loadPlayers() throws IOException, URISyntaxException {
        propertyManager = projectionSourceContext.getProjectionSource().getPropertyManager();
        Map<Position, List<Player>> returnValue = new HashMap<Position, List<Player>>();

        final String folder = propertyManager.getProjectionsDirectory();
        System.out.println("CSVPlayerLoader.loadPlayers - Projections Folder: " + folder);
        final File projectionsFile = new File(folder, "Projections.json");
        final File playersFile = new File(folder, "NFLPlayers.json");

        final String projectionsJson = readFile(projectionsFile);
        final String playersJSON = readFile(playersFile);

        final AllProjections allProjections = objectMapper.readValue(projectionsJson, AllProjections.class);
        final AllPlayers players = objectMapper.readValue(playersJSON, AllPlayers.class);

        Map<String, JSONPlayer> idToPlayer = players.stream()
                                                    .collect(Collectors.toMap(
                                                            JSONPlayer::getPlayerId,
                                                            player -> player
                                                    ));

        Map<String, ProjectorPosition> idToProjectorPosition = allProjections.stream()
                .filter(projectorPosition -> projectorPosition.getProjector() == propertyManager.getProjectorId())
                .collect(Collectors.toMap(
                        ProjectorPosition::getType,
                        projectorPosition -> projectorPosition
                ));

        ProjectorPosition projectorPosition = idToProjectorPosition.get("off");
        Map<String, JSONPlayerProjection> playerIdToProjection = projectorPosition.getProjections();
        List<Player> playersList = playerIdToProjection.entrySet()
                            .stream()
                            .filter(entry -> idToPlayer.containsKey(entry.getKey()))
                            .map(entry -> {
                                JSONPlayer jsonPlayer = idToPlayer.get(entry.getKey());
                                return buildPlayer(jsonPlayer, entry.getValue());
                            }).collect(Collectors.toList());

        Map<Position, List<Player>> positionToPlayer = new HashMap<>();
        for (Player player : playersList) {
            if (!positionToPlayer.containsKey(player.getPosition())) {
                positionToPlayer.put(player.getPosition(), new ArrayList<>());
            }

            positionToPlayer.get(player.getPosition()).add(player);
        }


        return positionToPlayer;
    }

    private Player buildPlayer(JSONPlayer jsonPlayer, JSONPlayerProjection playerProjection) {
        PlayerBuilder playerBuilder = new PlayerBuilder();

        playerBuilder.setPlayerID(jsonPlayer.getPlayerId());
        playerBuilder.setFirstName(jsonPlayer.getFirstName());
        playerBuilder.setLastName(jsonPlayer.getLastName());
        try {
            Position p = propertyManager.getPositionProperties().get(jsonPlayer.getPosition());
            playerBuilder.setPosition(p);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            final Team team = propertyManager.getTeamProperties().get(jsonPlayer.getTeamId());
            playerBuilder.setTeam(team);
            final Integer byeWeek = propertyManager.getByeProperties().get(team);
            playerBuilder.setByeWeek(byeWeek);
        } catch (Exception e) {
            e.printStackTrace();
        }

        PassingStatsBuilder passingStats = playerBuilder.getPassingStats();
        passingStats.setPassingAttempts(new BigDecimal(playerProjection.getPassingAttempts()));
        passingStats.setPassingCompletions(new BigDecimal(playerProjection.getPassingCompletions()));
        passingStats.setPassingYards(new BigDecimal(playerProjection.getPassingYards()));
        passingStats.setPassingTouchdowns(new BigDecimal(playerProjection.getPassingTouchdowns()));
        passingStats.setPassingInterceptions(new BigDecimal(playerProjection.getPassingInterceptions()));

        RushingStatsBuilder rushingStatsBuilder = playerBuilder.getRushingStats();
        rushingStatsBuilder.setRushingCarries(new BigDecimal(playerProjection.getRushingCarries()));
        rushingStatsBuilder.setRushingYards(new BigDecimal(playerProjection.getRushingYards()));
        rushingStatsBuilder.setRushingTouchdowns(new BigDecimal(playerProjection.getRushingTouchdowns()));
        rushingStatsBuilder.setFumbles(new BigDecimal(playerProjection.getFumbles()));

        ReceivingStatsBuilder receivingStatsBuilder = playerBuilder.getReceivingStats();
        receivingStatsBuilder.setReceptions(new BigDecimal(playerProjection.getReceptions()));
        receivingStatsBuilder.setReceivingYards(new BigDecimal(playerProjection.getReceivingYards()));
        receivingStatsBuilder.setReceivingTouchdowns(new BigDecimal(playerProjection.getReceivingTouchdowns()));

        return playerBuilder.build();
    }

    private String readFile(File file) throws IOException {

        StringBuilder fileContents = new StringBuilder((int)file.length());
        Scanner scanner = new Scanner(file);
        String lineSeparator = System.getProperty("line.separator");

        try {
            while(scanner.hasNextLine()) {
                fileContents.append(scanner.nextLine()).append(lineSeparator);
            }
            return fileContents.toString();
        } finally {
            scanner.close();
        }
    }
}
