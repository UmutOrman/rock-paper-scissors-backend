package com.rabobank.demo.model;

/**
 * @author horman
 */
public class Response {
    private Hand computerHand;
    private GameResult gameResult;

    public Response(){}

    public Response(Hand computerHand, GameResult gameResult) {
        this.computerHand = computerHand;
        this.gameResult = gameResult;
    }

    public Hand getComputerHand() {
        return computerHand;
    }

    public GameResult getGameResult() {
        return gameResult;
    }

    public void setComputerHand(Hand computerHand) {
        this.computerHand = computerHand;
    }

    public void setGameResult(GameResult gameResult) {
        this.gameResult = gameResult;
    }
}
