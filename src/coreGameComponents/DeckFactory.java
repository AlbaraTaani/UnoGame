package coreGameComponents;

import card.Card;

import java.util.List;

public interface DeckFactory {
    List<Card> createNewDeck();
}
