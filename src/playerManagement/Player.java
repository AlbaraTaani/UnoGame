package playerManagement;

import card.Card;
import enumsAndInterfaces.Color;
import coreGameComponents.Deck;
import game.Game;
import UI.GameInput;

import java.util.*;

public abstract class Player {
    protected String name;
    protected List<Card> hand = new ArrayList<>();

    public Player(String name) {
        this.name = name;
    }

    public abstract Card playCard(Game game);

    public void drawCard(Card card) {
        hand.add(card);
    }

    public void drawMultipleCards(Deck deck, int count) {
        for (int i = 0; i < count; i++) {
            drawCard(deck.drawCard());
        }
    }

    public boolean hasWon() {
        return hand.isEmpty();
    }

    public List<Card> getHand() {
        return Collections.unmodifiableList(hand);
    }

    public String getName() {
        return name;
    }

    public void initializeHand(Deck deck) {
        for (int i = 0; i < 7; i++) {
            drawCard(deck.drawCard());
        }
    }

    public void clearHand() {
        hand.clear();
    }

    public Color chooseColor(GameInput input) {
        return input.readForColor();
    }
}
