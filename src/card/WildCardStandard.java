package card;

import enumsAndInterfaces.*;
import game.Game;


public class WildCardStandard extends WildCard {
    public WildCardStandard(IColorChooser colorChooser) {
        super(CardType.WILD, colorChooser);
    }

    @Override
    public void executeAction(Game game) {
        Color chosen = game.getCurrentPlayer().chooseColor(game.getInput());
        game.getDeck().peekTopDiscard().setColor(chosen);
    }

    @Override
    public int getPointValue() {
        return 50;
    }
}
