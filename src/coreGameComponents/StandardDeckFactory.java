package coreGameComponents;

import card.*;
import enumsAndInterfaces.*;

import java.util.*;

public class StandardDeckFactory implements DeckFactory {
    private final CardFactory cardFactory;

    public StandardDeckFactory(CardFactory cardFactory) {
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
                deck.add(cardFactory.createCard(CardType.NUMBER, color, i));
            }
            deck.add(cardFactory.createCard(CardType.SKIP, color));
            deck.add(cardFactory.createCard(CardType.SKIP, color));
            deck.add(cardFactory.createCard(CardType.REVERSE, color));
            deck.add(cardFactory.createCard(CardType.REVERSE, color));
            deck.add(cardFactory.createCard(CardType.DRAW_TWO, color));
            deck.add(cardFactory.createCard(CardType.DRAW_TWO, color));
        }
        for (int i = 0; i < 4; i++) {
            deck.add(cardFactory.createCard(CardType.WILD, Color.WILD));
            deck.add(cardFactory.createCard(CardType.WILD_DRAW_FOUR, Color.WILD));
        }
        return deck;
    }
}
