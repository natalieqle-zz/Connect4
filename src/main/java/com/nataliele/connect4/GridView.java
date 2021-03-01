package com.nataliele.connect4;

import io.dropwizard.views.View;

public class GridView extends View {
    private final Grid grid;
    private final int currentPlayer;
    private final String message;

    public GridView(Grid grid, int currentPlayer, String message) {
        super("grid.ftl");
        this.grid = grid;
        this.currentPlayer = currentPlayer;
        this.message = message;
    }

    public Grid getGrid() {
        return grid;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public String getMessage() {
        return message;
    }
}
