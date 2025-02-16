package card;

import cardActions.CardAction;
import enumsAndInterfaces.*;
import game.*;


public abstract class ActionCard extends Card {
    protected CardAction action;

    public ActionCard(Color color, CardType type, CardAction action) {
        super(color, type);
        this.action = action;
    }

    @Override
    public void executeAction(Game game) {
        action.execute(game);
    }
}
