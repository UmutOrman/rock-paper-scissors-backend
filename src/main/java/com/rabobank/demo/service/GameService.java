package com.rabobank.demo.service;

import com.rabobank.demo.model.GameResult;
import com.rabobank.demo.model.Hand;
import com.rabobank.demo.model.Response;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

import static com.rabobank.demo.model.GameResult.*;
import static com.rabobank.demo.model.Hand.PAPER;
import static com.rabobank.demo.model.Hand.ROCK;

/**
 * @author horman
 */
@Service
public class GameService {
    public Response getResponse(final Hand playerHand) {
        final Hand computerHand = generateRandomHand();
        if (playerHand == computerHand) {
            return new Response(computerHand, DRAW);
        }
        final GameResult gameResult;
        switch (playerHand) {
            case ROCK:
                gameResult = computerHand == PAPER ? LOSS : WIN;
                break;
            case PAPER:
                gameResult = computerHand == ROCK ? WIN : LOSS;
                break;
            default:
                gameResult = computerHand == PAPER ? WIN : LOSS;
        }
        return new Response(computerHand, gameResult);
    }

    Hand generateRandomHand() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 3);
        return Hand.values()[randomNum];
    }
}
