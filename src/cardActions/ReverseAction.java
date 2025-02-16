package cardActions;

import game.Game;

public class ReverseAction implements CardAction {
    @Override
    public void execute(Game game) {
        game.getPlayerManager().reverseOrder();
    }
}
