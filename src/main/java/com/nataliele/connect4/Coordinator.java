package com.nataliele.connect4;

public class Coordinator {

    private Grid grid;
    private final int numPlayers;
    private int currentPlayer;

    public Coordinator(int gridWidth, int gridHeight, int numPlayers) {
        this.grid = new Grid(gridWidth, gridHeight);
        this.numPlayers = numPlayers;
        this.currentPlayer = 1;
    }

    public void dropToken(int col) {
        grid.dropToken(col, currentPlayer);
        advanceTurn();
    }

    public Grid getGrid() {
        return grid;
    }

    private void advanceTurn() {
        currentPlayer++;
        if (currentPlayer > numPlayers) {
            currentPlayer = 1;
        }
    }
}
