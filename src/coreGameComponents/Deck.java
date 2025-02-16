package coreGameComponents;

import card.Card;

public interface Deck {
    void shuffle();

    Card drawCard();

    void discard(Card card);

    void replenishFromDiscard();

    Card peekTopDiscard();
}
