package cardActions;

import game.Game;

public class SkipAction implements CardAction {
    @Override
    public void execute(Game game) {
        game.getPlayerManager().skipPlayer();
    }
}
