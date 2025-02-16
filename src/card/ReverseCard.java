package card;

import cardActions.ReverseAction;
import enumsAndInterfaces.*;

public class ReverseCard extends ActionCard {
    public ReverseCard(Color color) {
        super(color, CardType.REVERSE, new ReverseAction());
    }

    @Override
    public int getPointValue() {
        return 20;
    }

    @Override
    public boolean isPlayableOn(Card topCard) {
        return this.color == topCard.getColor() || topCard.getType() == CardType.REVERSE;
    }
}
