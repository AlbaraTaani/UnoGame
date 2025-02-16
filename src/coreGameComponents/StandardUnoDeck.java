package coreGameComponents;

import card.Card;

import java.util.*;


public class StandardUnoDeck implements Deck {
    private final Deque<Card> drawPile = new ArrayDeque<>();
    private final Deque<Card> discardPile = new ArrayDeque<>();
    private final DeckFactory deckFactory;

    public StandardUnoDeck(DeckFactory deckFactory) {
        this.deckFactory = deckFactory;
        initialize();
    }

    private void initialize() {
        drawPile.addAll(deckFactory.createNewDeck());
        shuffle();
    }

    @Override
    public void shuffle() {
        List<Card> temp = new ArrayList<>(drawPile);
        Collections.shuffle(temp);
        drawPile.clear();
        drawPile.addAll(temp);
    }

    @Override
    public Card drawCard() {
        if (drawPile.isEmpty()) {
            replenishFromDiscard();
        }
        if (drawPile.isEmpty()) {
            throw new RuntimeException("No cards left in the deck.");
        }
        return drawPile.pop();
    }

    @Override
    public void discard(Card card) {
        discardPile.push(card);
    }

    @Override
    public void replenishFromDiscard() {
        if (discardPile.isEmpty()) throw new RuntimeException("Discard pile empty.");
        Card lastDiscard = discardPile.pop();
        drawPile.addAll(discardPile);
        discardPile.clear();
        discardPile.push(lastDiscard);
        shuffle();
    }

    @Override
    public Card peekTopDiscard() {
        if (discardPile.isEmpty()) throw new RuntimeException("Discard pile empty.");
        return discardPile.peek();
    }
}
