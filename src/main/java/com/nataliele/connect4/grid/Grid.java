package com.nataliele.connect4.grid;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Grid {

    private int[][] placement;
    private String[] representation;
    private final int winCondition;
    private Map<Integer, Set<TokenLocation>> placedTokens;
    private int remainingSpots;

    public Grid(int width, int height, int winCondition) {
        this.placement = new int[height][width];
        this.representation = new String[height];
        this.winCondition = winCondition;
        this.placedTokens = new HashMap<>();
        this.remainingSpots = width * height;
    }

    public void dropToken(int col, int player) {
        col--; // not zero-based for (user) clarity
        if (col < 0 || col >= placement[0].length) {
            throw new IllegalArgumentException("Cannot drop token in a nonexistent column");
        }
        for (int row = placement.length - 1; row >= 0; row--) {
            if (placement[row][col] == 0) {
                placement[row][col] = player;
                TokenLocation tokenLocation = new TokenLocation(row, col);
                placedTokens.computeIfAbsent(player, k -> new HashSet<>()).add(tokenLocation);
                remainingSpots--;
                return;
            }
        }
        throw new IllegalStateException("Cannot drop token in full column");
    }

    @JsonProperty
    public int[][] getPlacement() {
        return placement;
    }

    @JsonProperty
    public String[] getRepresentation() {
        for (int row = 0; row < placement.length; row++) {
            StringBuilder rowRep = new StringBuilder();
            for (int col = 0; col < placement[0].length; col++) {
                String placeholder = Integer.toString(placement[row][col]);
                if (placeholder.equals("0")) {
                    placeholder = "";
                }
                rowRep.append(String.format("[ %s ]", placeholder));
            }
            representation[row] = rowRep.toString();
        }
        return representation;
    }

    public int getRemainingSpots() {
        return remainingSpots;
    }

    public boolean hasWinner(int currentPlayer) {
        for (TokenLocation tokenLocation : placedTokens.get(currentPlayer)) {
            if (checkForWin(tokenLocation, currentPlayer, 1, 0, 1) ||
                    checkForWin(tokenLocation, currentPlayer, 1, 1, 1) ||
                    checkForWin(tokenLocation, currentPlayer, 0, 1, 1) ||
                    checkForWin(tokenLocation, currentPlayer, -1, 1, 1) ||
                    checkForWin(tokenLocation, currentPlayer, -1, 0, 1) ||
                    checkForWin(tokenLocation, currentPlayer, -1, -1, 1) ||
                    checkForWin(tokenLocation, currentPlayer, 0, -1, 1) ||
                    checkForWin(tokenLocation, currentPlayer, 1, -1, 1)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkForWin(TokenLocation tokenLocation, int player, int xDist, int yDist, int consecutive) {
        if (consecutive == winCondition) {
            return true;
        }
        int currRow = tokenLocation.getRow() + xDist;
        int currCol = tokenLocation.getCol() + yDist;
        if (currRow < 0 || currRow == placement.length) return false;
        if (currCol < 0 || currCol == placement[0].length) return false;
        if (placement[currRow][currCol] == player) {
            return checkForWin(new TokenLocation(currRow, currCol), player, xDist, yDist, consecutive + 1);
        } else {
            return false;
        }
    }

    private class TokenLocation {
        private final int row;
        private final int col;

        public TokenLocation(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }
    }
}
