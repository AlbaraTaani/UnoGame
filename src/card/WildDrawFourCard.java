package card;

import enumsAndInterfaces.*;
import game.Game;
import playerManagement.Player;

public class WildDrawFourCard extends WildCard {
    public WildDrawFourCard(IColorChooser colorChooser) {
        super(CardType.WILD_DRAW_FOUR, colorChooser);
    }

    @Override
    public void executeAction(Game game) {
        Player next = game.getPlayerManager().getNextPlayer();
        next.drawMultipleCards(game.getDeck(), 4);
        Color chosen = game.getCurrentPlayer().chooseColor(game.getInput());
        game.getDeck().peekTopDiscard().setColor(chosen);
    }

    @Override
    public int getPointValue() {
        return 50;
    }
}
