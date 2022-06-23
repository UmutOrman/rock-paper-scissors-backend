package com.rabobank.demo.service;

import com.rabobank.demo.model.Hand;
import com.rabobank.demo.model.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.rabobank.demo.model.GameResult.*;
import static com.rabobank.demo.model.Hand.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * @author horman
 */
@ExtendWith(MockitoExtension.class)
class GameServiceTest {
    @Spy
    private GameService gameService;

    @Test
    @DisplayName("Test generateRandomHand generates 10000 random hands without an error")
    void test1() {
        for (int i = 0; i < 10000; i++) {
            assertDoesNotThrow(() -> gameService.generateRandomHand());
        }
    }

    @Test
    @DisplayName("Test getResponse, ROCK vs ROCK, gameResult should be DRAW")
    void test2() {
        // Arrange
        when(gameService.generateRandomHand()).thenReturn(ROCK);
        final Hand playerHand = ROCK;

        // Act
        final Response response = gameService.getResponse(playerHand);

        // Assert
        assertEquals(DRAW, response.getGameResult());
    }

    @Test
    @DisplayName("Test getResponse, ROCK vs PAPER, gameResult should be LOSS")
    void test3() {
        // Arrange
        when(gameService.generateRandomHand()).thenReturn(PAPER);
        final Hand playerHand = ROCK;

        // Act
        final Response response = gameService.getResponse(playerHand);

        // Assert
        assertEquals(LOSS, response.getGameResult());
    }

    @Test
    @DisplayName("Test getResponse, ROCK vs SCISSORS, gameResult should be WIN")
    void test4() {
        // Arrange
        when(gameService.generateRandomHand()).thenReturn(SCISSORS);
        final Hand playerHand = ROCK;

        // Act
        final Response response = gameService.getResponse(playerHand);

        // Assert
        assertEquals(WIN, response.getGameResult());
    }

    @Test
    @DisplayName("Test getResponse, PAPER vs ROCK, gameResult should be WIN")
    void test5() {
        // Arrange
        when(gameService.generateRandomHand()).thenReturn(ROCK);
        final Hand playerHand = PAPER;

        // Act
        final Response response = gameService.getResponse(playerHand);

        // Assert
        assertEquals(WIN, response.getGameResult());
    }

    @Test
    @DisplayName("Test getResponse, PAPER vs PAPER, gameResult should be DRAW")
    void test6() {
        // Arrange
        when(gameService.generateRandomHand()).thenReturn(PAPER);
        final Hand playerHand = PAPER;

        // Act
        final Response response = gameService.getResponse(playerHand);

        // Assert
        assertEquals(DRAW, response.getGameResult());
    }

    @Test
    @DisplayName("Test getResponse,PAPER vs SCISSORS, gameResult should be LOSS")
    void test7() {
        // Arrange
        when(gameService.generateRandomHand()).thenReturn(SCISSORS);
        final Hand playerHand = PAPER;

        // Act
        final Response response = gameService.getResponse(playerHand);

        // Assert
        assertEquals(LOSS, response.getGameResult());
    }

    @Test
    @DisplayName("Test getResponse, SCISSORS vs ROCK, gameResult should be LOSS")
    void test8() {
        // Arrange
        when(gameService.generateRandomHand()).thenReturn(ROCK);
        final Hand playerHand = SCISSORS;

        // Act
        final Response response = gameService.getResponse(playerHand);

        // Assert
        assertEquals(LOSS, response.getGameResult());
    }

    @Test
    @DisplayName("Test getResponse, SCISSORS vs PAPER, gameResult should be WIN")
    void test9() {
        // Arrange
        when(gameService.generateRandomHand()).thenReturn(PAPER);
        final Hand playerHand = SCISSORS;

        // Act
        final Response response = gameService.getResponse(playerHand);

        // Assert
        assertEquals(WIN, response.getGameResult());
    }

    @Test
    @DisplayName("Test getResponse, SCISSORS vs SCISSORS, gameResult should be DRAW")
    void test10() {
        // Arrange
        when(gameService.generateRandomHand()).thenReturn(SCISSORS);
        final Hand playerHand = SCISSORS;

        // Act
        final Response response = gameService.getResponse(playerHand);

        // Assert
        assertEquals(DRAW, response.getGameResult());
    }

}