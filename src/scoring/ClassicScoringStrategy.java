package scoring;

import card.Card;
import java.util.List;
public class ClassicScoringStrategy implements ScoringStrategy {
    @Override
    public int calculatePoints(List<Card> cards) {
        return cards.stream().mapToInt(Card::getPointValue).sum();
    }
}
