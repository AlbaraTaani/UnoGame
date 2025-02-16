package coreGameComponents;

import card.*;
import enumsAndInterfaces.*;

import java.util.*;

public class SimpleDeckFactory implements DeckFactory {
    private final CardFactory cardFactory;

    public SimpleDeckFactory(CardFactory cardFactory) {
        this.cardFactory = cardFactory;
    }

    @Override
    public List<Card> createNewDeck() {
        List<Card> deck = new ArrayList<>();
        EnumSet<Color> colors = EnumSet.of(Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW);
        for (Color color : colors) {
            deck.add(cardFactory.createCard(CardType.NUMBER, color, 0));
            for (int i = 1; i <= 9; i++) {
                deck.add(cardFactory.createCard(CardType.NUMBER, color, i));
            }
        }
        return deck;
    }
}
