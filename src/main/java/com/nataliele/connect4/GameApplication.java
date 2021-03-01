package com.nataliele.connect4;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

public class GameApplication extends Application<GameConfiguration> {
    public static void main(String[] args) throws Exception {
        new GameApplication().run(args);
    }

    @Override
    public String getName() {
        return "connect4";
    }

    @Override
    public void initialize(Bootstrap<GameConfiguration> bootstrap) {
        bootstrap.addBundle(new ViewBundle<>());
    }

    @Override
    public void run(GameConfiguration configuration,
                    Environment environment) {
        final GameResource resource = new GameResource(
                configuration.getGridWidth(),
                configuration.getGridHeight(),
                configuration.getNumPlayers(),
                configuration.getWinCondition()
        );
        environment.jersey().register(resource);
    }

}