package com.nataliele.connect4;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenLocation {
    private int column;

    @JsonProperty
    public int getColumn() {
        return column;
    }
}
