package card;

import cardActions.SkipAction;
import enumsAndInterfaces.*;

public class SkipCard extends ActionCard {
    public SkipCard(Color color) {
        super(color, CardType.SKIP, new SkipAction());
    }

    @Override
    public int getPointValue() {
        return 20;
    }

    @Override
    public boolean isPlayableOn(Card topCard) {
        return this.color == topCard.getColor() || topCard.getType() == CardType.SKIP;
    }
}
