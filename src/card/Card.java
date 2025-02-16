package card;


import enumsAndInterfaces.*;
import game.Game;


public abstract class Card {
    protected Color color;
    protected CardType type;

    public Card(Color color, CardType type) {
        this.color = color;
        this.type = type;
    }

    public abstract void executeAction(Game game);

    public abstract int getPointValue();

    public abstract boolean isPlayableOn(Card topCard);

    public Color getColor() {
        return color;
    }

    public CardType getType() {
        return type;
    }

    public void setColor(Color newColor) {
        this.color = newColor;
    }
}
