package cardActions;

import game.Game;
import playerManagement.Player;

public class DrawTwoAction implements CardAction {
    @Override
    public void execute(Game game) {
        Player next = game.getPlayerManager().getNextPlayer();
        next.drawMultipleCards(game.getDeck(), 2);
    }
}
