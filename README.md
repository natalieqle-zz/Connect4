# Connect4
A simple Connect4 game created with Dropwizard.

## Features
- Can play with 2+ players
- Customizable grid dimensions (must contain at least 4 squares)
- Choose how many consecutive tokens are required for a win (i.e. Connect5, Connect100, etc.)

## Getting Started
Run the jar with a YAML containing your desired config.
```aidl
java -jar connect4-1.0-SNAPSHOT.jar server connect4.yml
```
The above example contains the example config, `connect4.yml`, but any YAML file that follows the structure can be used.

## Playing The Game
To view the grid, see whose turn it is, and view the winner, refresh `http://localhost:8080/connect-4/grid` throughout the game.

To drop a token in a certain column (1-indexed):
```aidl
curl -H "Content-Type: application/json" --data '{"column":1}' http://localhost:8080/connect-4/play
```

To restart the game:
```aidl
curl -X PUT http://localhost:8080/connect-4/restart
```