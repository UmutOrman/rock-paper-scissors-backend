package com.rabobank.demo.controller;

import com.rabobank.demo.model.Hand;
import com.rabobank.demo.model.Response;
import com.rabobank.demo.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author horman
 */
@RestController
@RequestMapping("/game")
public class GameController {
    private final GameService gameService;

    public GameController(final GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Response getGameResponse(@RequestParam("playerHand") Hand playerHand) {
        return gameService.getResponse(playerHand);
    }
}
