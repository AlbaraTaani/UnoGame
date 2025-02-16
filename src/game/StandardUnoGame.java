package game;

import UI.*;
import card.Card;
import coreGameComponents.Deck;
import enumsAndInterfaces.GameRule;
import playerManagement.Player;
import scoring.Scoreboard;

public class StandardUnoGame extends Game {

    public StandardUnoGame(GameInput input, GameOutput output, Deck deck, Scoreboard scoreboard) {
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

    private void startNewRound() {
        deck.shuffle();
        for (Player player : players) {
            player.clearHand();
            player.initializeHand(deck);
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
