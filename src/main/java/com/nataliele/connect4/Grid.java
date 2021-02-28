package com.nataliele.connect4;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Grid {

    private int[][] placement;
    private String[] representation;

    public Grid() {
        // Jackson deserialization
    }

    public Grid(int width, int height) {
        this.placement = new int[width][height];
        this.representation = new String[height];
    }

    public void dropToken(int col, int player) {
        col--; // not zero-based for clarity
        for (int row = placement.length - 1; row >= 0; row--) {
            if (placement[row][col] == 0) {
                placement[row][col] = player;
                break;
            }
        }
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
}
