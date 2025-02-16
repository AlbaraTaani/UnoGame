package scoring;

import UI.GameOutput;
import playerManagement.Player;

import java.util.*;

public class Scoreboard {
    private Map<Player, Integer> scores = new HashMap<>();
    private ScoringStrategy strategy;
    private int winningScore;
    private GameOutput output;

    public Scoreboard(ScoringStrategy strategy, int winningScore, GameOutput output) {
        this.strategy = strategy;
        this.winningScore = Math.max(winningScore, 1);
        this.output = output;
    }

    public void onRoundEnd(Player winner, List<Player> players) {
        int roundPoints = players.stream()
                .filter(player -> !player.equals(winner))
                .mapToInt(player -> strategy.calculatePoints(player.getHand()))
                .sum();
        scores.put(winner, scores.getOrDefault(winner, 0) + roundPoints);
        output.displayRoundSummary(winner.getName(), roundPoints, scores.get(winner));
    }

    public Map<Player, Integer> getPlayerScores() {
        return Collections.unmodifiableMap(scores);
    }

    public Optional<Player> getWinner() {
        return scores.entrySet().stream()
                .filter(entry -> entry.getValue() >= winningScore)
                .map(Map.Entry::getKey)
                .findFirst();
    }
}
