package com.nataliele.connect4.orchestration;

import com.nataliele.connect4.grid.Grid;
import com.nataliele.connect4.grid.GridView;

public class Orchestrator {

    private Grid grid;
    private final int numPlayers;
    private int currentPlayer;
    private String message;
    private boolean isGameOver;

    public Orchestrator(int gridWidth, int gridHeight, int numPlayers, int winCondition) {
        this.grid = new Grid(gridWidth, gridHeight, winCondition);
        this.numPlayers = numPlayers;
        this.currentPlayer = 1;
        this.message = "";
        this.isGameOver = false;
    }

    public void dropToken(int col) {
        if (isGameOver) return;
        try {
            grid.dropToken(col, currentPlayer);
            if (grid.hasWinner(currentPlayer)) {
                message = "We've got a winner!";
                isGameOver = true;
            } else {
                if (grid.getRemainingSpots() != 0) {
                    advanceTurn();
                    message = "";
                } else {
                    message = "It's a tie!";
                    isGameOver = true;
                }
            }
        } catch (IllegalArgumentException | IllegalStateException ex) {
            message = String.format("%s. Try again!", ex.getMessage());
        }
    }

    public GridView getGridView() {
        return new GridView(grid, currentPlayer, message);
    }

    private boolean checkForWinner() {
        return true;
    }

    private void advanceTurn() {
        currentPlayer++;
        if (currentPlayer > numPlayers) {
            currentPlayer = 1;
        }
    }
}
