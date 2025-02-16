package game;

import UI.*;
import coreGameComponents.Deck;
import enumsAndInterfaces.GameRule;
import playerManagement.*;
import scoring.Scoreboard;

import java.util.*;

public abstract class Game {
    protected List<Player> players;
    protected Deck deck;
    protected PlayerManager playerManager;
    protected GameInput input;
    protected GameOutput output;
    protected List<GameRule> gameRules = new ArrayList<>();
    protected Scoreboard scoreboard;

    protected Player currentPlayer;

    public Game(GameInput input, GameOutput output, Deck deck, Scoreboard scoreboard) {
        this.input = input;
        this.output = output;
        this.deck = deck;
        this.scoreboard = scoreboard;
    }

    public void addGameRule(GameRule rule) {
        gameRules.add(rule);
    }

    public void registerPlayers() {
        int playerCount = input.readPlayerCount();
        players = new ArrayList<>();
        for (int i = 1; i <= playerCount; i++) {
            PlayerCreationData data = input.readPlayerDetails(i);
            players.add(PlayerFactory.createPlayer(data, input));
        }
        playerManager = new PlayerManager(players);
    }
    public abstract void play();

    public Deck getDeck() {
        return deck;
    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player player) {
        this.currentPlayer = player;
    }

    public GameInput getInput() {
        return input;
    }
}
