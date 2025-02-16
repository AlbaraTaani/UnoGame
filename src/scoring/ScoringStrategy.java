package scoring;

import card.Card;

import java.util.List;

public interface ScoringStrategy {
    int calculatePoints(List<Card> cards);
}
