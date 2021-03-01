package com.nataliele.connect4.configs;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;

public class GameConfiguration extends Configuration {
    private int gridWidth;
    private int gridHeight;
    private int numPlayers;
    private int winCondition;

    @JsonProperty
    @Min(1)
    public int getGridWidth() {
        return gridWidth;
    }

    @JsonProperty
    @Min(1)
    public int getGridHeight() {
        return gridHeight;
    }

    @JsonProperty
    @Min(2)
    public int getNumPlayers() {
        return numPlayers;
    }

    @JsonProperty
    @Min(2)
    public int getWinCondition() {
        return winCondition;
    }
}