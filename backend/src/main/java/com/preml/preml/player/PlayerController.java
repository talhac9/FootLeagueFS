package com.preml.preml.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/player")
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }
    @GetMapping
    public List<Player> getPlayers(
            @RequestParam(required = false) String team,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String position,
            @RequestParam(required = false) String country) {
        if (team != null && position != null) {
            return playerService.getPlayersByTeamAndPos(team, position);
        }
        else if (team != null ) return playerService.getPlayersFromTeam(team);
        else if (name != null) return playerService.getPlayersByName(name);
        else if (position != null) return playerService.getPlayersByPos(position);
        else if (country != null) return playerService.getPlayersByCountry(country);
        else return playerService.getPlayers();
    }

    @PostMapping
    public ResponseEntity<Player> addPlayer (@RequestBody Player player) {
        Player createdPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(createdPlayer, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Player> updatePlayer (@RequestBody Player player) {
        Player resPlayer = playerService.updatePlayer(player);
        if (resPlayer != null)
            return new ResponseEntity<>(resPlayer, HttpStatus.CREATED);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<String> deletePlayer(@PathVariable String name) {
        playerService.deletePlayer(name);
        return new ResponseEntity<>("Player Deleted",  HttpStatus.CREATED);
    }

}
