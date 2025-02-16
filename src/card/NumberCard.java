package card;

import enumsAndInterfaces.*;
import game.Game;

public class NumberCard extends Card {
    private int number;

    public NumberCard(Color color, int number) {
        super(color, CardType.NUMBER);
        this.number = number;
    }

    @Override
    public void executeAction(Game game) {

    }

    @Override
    public int getPointValue() {
        return number;
    }

    @Override
    public boolean isPlayableOn(Card topCard) {
        if (this.color == topCard.getColor()) return true;
        if (topCard.getType() == CardType.NUMBER && topCard instanceof NumberCard) {
            return this.number == ((NumberCard) topCard).number;
        }
        return false;
    }

    public int getNumber() {
        return number;
    }
}
