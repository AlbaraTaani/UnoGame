package playerManagement;

import card.Card;
import game.Game;
import UI.GameInput;

public class HumanPlayer extends Player {
    private GameInput input;

    public HumanPlayer(String name, GameInput input) {
        super(name);
        this.input = input;
    }

    @Override
    public Card playCard(Game game) {
        Card chosen;
        while (true) {
            chosen = input.readCardSelection(this);

            if (chosen == null) return null;

            if (chosen.isPlayableOn(game.getDeck().peekTopDiscard())) {
                hand.remove(chosen);
                return chosen;
            } else {
                System.out.println("Card not playable on the top card. Try again.");
            }
        }
    }
}
