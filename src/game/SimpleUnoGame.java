package game;

import card.Card;
import coreGameComponents.Deck;
import UI.*;
import enumsAndInterfaces.GameRule;
import playerManagement.Player;
import scoring.Scoreboard;

public class SimpleUnoGame extends Game {

    public SimpleUnoGame(GameInput input, GameOutput output, Deck deck, Scoreboard scoreboard) {
        super(input, output, deck, scoreboard);
    }

    @Override
    public void play() {
        registerPlayers();
        startNewRound();
        while (!scoreboard.getWinner().isPresent()) {
            playRound();
            output.displayScoreboard(scoreboard.getPlayerScores());
        }
        scoreboard.getWinner().ifPresent(winner -> output.displayGameResult(winner.getName()));
    }

    /**
     * In this variation, each player starts with 5 cards.
     */
    private void startNewRound() {
        deck.shuffle();
        int initialHandSize = 5;
        for (Player player : players) {
            player.clearHand();
            for (int i = 0; i < initialHandSize; i++) {
                player.drawCard(deck.drawCard());
            }
        }
        deck.discard(deck.drawCard());
    }

    private void playRound() {
        while (!isRoundOver()) {
            Player current = playerManager.getNextPlayer();
            setCurrentPlayer(current);
            output.displayTurnStart(current);
            output.displayTopCard(deck.peekTopDiscard());

            Card played = current.playCard(this);
            if (played != null) {
                output.displayCardPlayed(current, played);
                deck.discard(played);
                played.executeAction(this);
            } else {
                Card drawn = deck.drawCard();
                current.drawCard(drawn);
                System.out.println(current.getName() + " drew a card.");
            }
            for (GameRule rule : gameRules) {
                rule.applyRule(this);
            }
        }
        Player roundWinner = players.stream().filter(Player::hasWon).findFirst().orElse(null);
        if (roundWinner != null) {
            scoreboard.onRoundEnd(roundWinner, players);
        }
        startNewRound();
    }

    private boolean isRoundOver() {
        return players.stream().anyMatch(Player::hasWon);
    }
}
