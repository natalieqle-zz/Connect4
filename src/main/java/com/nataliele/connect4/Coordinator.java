package com.nataliele.connect4;

public class Coordinator {

    private Grid grid;
    private final int numPlayers;
    private int currentPlayer;
    private String message;
    private boolean isGameOver;

    public Coordinator(int gridWidth, int gridHeight, int numPlayers) {
        this.grid = new Grid(gridWidth, gridHeight);
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
        } catch (IllegalStateException ex) {
            message = ex.getMessage();
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
