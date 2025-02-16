package card;

import cardActions.DrawTwoAction;
import enumsAndInterfaces.*;

public class DrawTwoCard extends ActionCard {
    public DrawTwoCard(Color color) {
        super(color, CardType.DRAW_TWO, new DrawTwoAction());
    }

    @Override
    public int getPointValue() {
        return 20;
    }

    @Override
    public boolean isPlayableOn(Card topCard) {
        return this.color == topCard.getColor() || topCard.getType() == CardType.DRAW_TWO;
    }
}
