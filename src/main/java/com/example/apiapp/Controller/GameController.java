package com.example.apiapp.Controller;


import com.example.apiapp.Model.Game;
import com.example.apiapp.repository.GameRepository;
import exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class GameController {

    private final GameRepository gameRepository;

    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @GetMapping("/Games")
    public List<Game> getAllGames(){
        return  gameRepository.findAll();
    }

    @GetMapping("/Games/{id}")
    public Game getEmployeeById(@PathVariable(value = "id") Long GameID)
            throws ResourceNotFoundException {
        return gameRepository.findById(GameID)
                .orElseThrow(() -> new ResourceNotFoundException("Game not found for this id :: " + GameID));
    }

    @PostMapping("/Games")
    public Game createGame(@Validated @RequestBody Game game) {
        return gameRepository.save(game);
    }

    @PutMapping("/Games/{id}")
    public Game updateGame(@PathVariable(value = "id") Long gameID,
                           @Validated @RequestBody Game gameDetails) throws ResourceNotFoundException {
        Game game = gameRepository.findById(gameID)
                .orElseThrow(() -> new ResourceNotFoundException("Game not found for this id :: " + gameID));
        game.setGameName(gameDetails.getGameName());
        game.setGenre(gameDetails.getGenre());
        game.setStory(gameDetails.getStory());
        game.setYearOfProduction(gameDetails.getYearOfProduction());
        return gameRepository.save(game);
    }

    @DeleteMapping("/Games/{id}")
    public void deleteGame(@PathVariable(value = "id") Long gameID) throws ResourceNotFoundException {
        Game game = gameRepository.findById(gameID)
                .orElseThrow(() -> new ResourceNotFoundException("Game not found for this id :: " + gameID));

        gameRepository.delete(game);
    }




}
