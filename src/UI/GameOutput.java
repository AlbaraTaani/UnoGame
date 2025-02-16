package UI;

import card.*;
import playerManagement.Player;

import java.util.*;

public class GameOutput {
    public void displayTurnStart(Player player) {
        System.out.println("\nIt is " + player.getName() + "'s turn!");
    }

    public void displayTopCard(Card card) {
        System.out.println("Top Card: " + describeCard(card));
    }

    public void displayCardPlayed(Player player, Card card) {
        System.out.println(player.getName() + " played " + describeCard(card));
    }

    public void displayScoreboard(Map<Player, Integer> scores) {
        System.out.println("------ Scoreboard ------");
        scores.forEach((player, score) -> System.out.println(player.getName() + ": " + score));
        System.out.println("------------------------");
    }

    public void displayRoundSummary(String winnerName, int roundPoints, int totalScore) {
        System.out.println(winnerName + " wins the round! Earned " + roundPoints + " points. Total score: " + totalScore);
    }

    public void displayGameResult(String winnerName) {
        System.out.println("Game Over! Winner: " + winnerName);
    }

    private String describeCard(Card card) {
        if (card instanceof NumberCard) {
            return card.getColor() + " " + ((NumberCard) card).getNumber();
        } else {
            return card.getColor() + " " + card.getType();
        }
    }
}
