package com.nataliele.connect4;

import io.dropwizard.views.View;

public class GridView extends View {
    private final Grid grid;

    public GridView(Grid grid) {
        super("grid.ftl");
        this.grid = grid;
    }

    public Grid getGrid() {
        return grid;
    }
}
