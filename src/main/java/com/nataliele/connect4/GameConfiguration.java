package com.nataliele.connect4;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GameConfiguration extends Configuration {
    private int gridWidth;
    private int gridHeight;
    private int numPlayers;

    @JsonProperty
    public int getGridWidth() {
        return gridWidth;
    }

    @JsonProperty
    public int getGridHeight() {
        return gridHeight;
    }

    @JsonProperty
    public int getNumPlayers() {
        return numPlayers;
    }
}