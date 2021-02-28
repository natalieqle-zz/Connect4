package com.nataliele.connect4;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/connect-4")
public class GameResource {
    private final Coordinator coordinator;

    public GameResource(int gridWidth, int gridHeight, int numPlayers) {
        this.coordinator = new Coordinator(gridWidth, gridHeight, numPlayers);
    }

    @POST
    @Path("/play")
    @Produces(MediaType.APPLICATION_JSON)
    public void dropToken(TokenLocation tokenLocation) {
        coordinator.dropToken(tokenLocation.getColumn());
    }

    @GET
    @Path("/grid")
    @Produces(MediaType.TEXT_HTML)
    public GridView getGrid() {
        return new GridView(coordinator.getGrid());
    }
}
