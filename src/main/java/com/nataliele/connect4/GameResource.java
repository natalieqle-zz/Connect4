package com.nataliele.connect4;

import com.nataliele.connect4.grid.GridView;
import com.nataliele.connect4.orchestration.Orchestrator;
import com.nataliele.connect4.requests.TokenLocation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/connect-4")
public class GameResource {
    private Orchestrator orchestrator;
    private final int gridWidth;
    private final int gridHeight;
    private final int numPlayers;
    private final int winCondition;

    public GameResource(int gridWidth, int gridHeight, int numPlayers, int winCondition) {
        this.orchestrator = new Orchestrator(gridWidth, gridHeight, numPlayers, winCondition);
        this.gridWidth = gridWidth;
        this.gridHeight = gridHeight;
        this.numPlayers = numPlayers;
        this.winCondition = winCondition;
    }

    @POST
    @Path("/play")
    @Produces(MediaType.APPLICATION_JSON)
    public void dropToken(TokenLocation tokenLocation) {
        orchestrator.dropToken(tokenLocation.getColumn());
    }

    @GET
    @Path("/grid")
    @Produces(MediaType.TEXT_HTML)
    public GridView getGrid() {
        return orchestrator.getGridView();
    }

    @PUT
    @Path("/restart")
    @Produces(MediaType.APPLICATION_JSON)
    public void restartGame() {
        this.orchestrator = new Orchestrator(gridWidth, gridHeight, numPlayers, winCondition);
    }
}
