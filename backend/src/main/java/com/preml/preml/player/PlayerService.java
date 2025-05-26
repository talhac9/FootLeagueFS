package com.preml.preml.player;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;

@Component
public class PlayerService {
    private final PlayerRepo playerRepo;

    @Autowired
    public PlayerService(PlayerRepo playerRepo) {
        this.playerRepo = playerRepo;
    }

    public List<Player> getPlayers() {
        return playerRepo.findAll();
    }

    public List<Player> getPlayersFromTeam(String teamName) {
        return playerRepo.findAll().stream()
                .filter(player -> teamName.equalsIgnoreCase(player.getTeam()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByName(String searchText) {
        return playerRepo.findAll().stream()
                .filter(player -> player.getName().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByPos(String searchText) {

        return playerRepo.findAll().stream()
                .filter(player -> player.getPosition() != null && player.getPosition().toLowerCase()
                        .contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByCountry(String searchText) {
        return playerRepo.findAll().stream()
                .filter(player -> player.getCountry() != null && player.getCountry().equals(searchText))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByTeamAndPos(String team, String pos) {
        return playerRepo.findAll().stream()
                .filter(player -> team.equals(player.getTeam()) && pos.equals(player.getPosition()))
                .collect(Collectors.toList());
    }

    public Player addPlayer(Player player) {
        playerRepo.save(player);
        return player;
    }

    public Player updatePlayer(Player updatedPlayer) {
        Optional<Player> existingPlayer = playerRepo.findByName(updatedPlayer.getName());

        if (existingPlayer.isPresent()) {
            Player playerToUpdate = existingPlayer.get();
            playerToUpdate.setName(updatedPlayer.getName());
            playerToUpdate.setTeam(updatedPlayer.getTeam());
            playerToUpdate.setPosition(updatedPlayer.getPosition());
            playerToUpdate.setCountry(updatedPlayer.getCountry());

            playerRepo.save(playerToUpdate);
            return playerToUpdate;
        }
        return null;
    }

    @Transactional
    public void deletePlayer(String playername) {
        playerRepo.deleteByName(playername);
    }

}
